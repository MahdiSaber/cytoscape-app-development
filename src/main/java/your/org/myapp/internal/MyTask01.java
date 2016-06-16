package your.org.myapp.internal;

import org.cytoscape.model.CyColumn;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.View;
import org.cytoscape.view.model.VisualProperty;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.presentation.property.DoubleVisualProperty;
import org.cytoscape.view.presentation.property.NodeShapeVisualProperty;
import org.cytoscape.view.presentation.property.VisualPropertyUtil;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.view.vizmap.mappings.PassthroughMapping;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class MyTask01 extends AbstractTask
{
	CyNetworkFactory networkFactory;
	CyNetworkManager networkManager;
	CyNetworkNaming networkNaming;
	CyNetworkViewFactory viewFactory;
	CyNetworkViewManager viewManager;
	VisualMappingFunctionFactory mappingFunctionFactory;
	VisualStyleFactory styleFactory;
	VisualMappingManager mappingManager;

	public MyTask01(CyNetworkFactory networkFactory, CyNetworkManager networkManager, CyNetworkNaming networkNaming,
			CyNetworkViewFactory viewFactory, CyNetworkViewManager viewManager,
			VisualMappingFunctionFactory mappingFunctionFactory, VisualStyleFactory styleFactory,
			VisualMappingManager mappingManager)
	{
		this.networkFactory = networkFactory;
		this.networkManager = networkManager;
		this.networkNaming = networkNaming;
		this.viewFactory = viewFactory;
		this.viewManager = viewManager;
		this.mappingFunctionFactory = mappingFunctionFactory;
		this.styleFactory = styleFactory;
		this.mappingManager = mappingManager;
	}

	@Override
	public void run(TaskMonitor arg0) throws Exception
	{
		CyNetwork newNetwork = networkFactory.createNetwork();

		// newNetwork.getRow(newNetwork).set(CyNetwork.NAME,
		// networkNaming.getSuggestedNetworkTitle("Best Network"));
		//
		// Step 3_1:
		// Mahdi: Pay attotion to the second manner for setting the network
		// name.
		// This is equal to the line!
		newNetwork.getDefaultNetworkTable().getRow(newNetwork.getSUID()).set("name",
				networkNaming.getSuggestedNetworkTitle("Bestest Network"));

		CyNode node1 = newNetwork.addNode();
		CyNode node2 = newNetwork.addNode();
		CyNode node3 = newNetwork.addNode();
		CyNode node4 = newNetwork.addNode();

		// Step 3_1_continue (Change the name of the node or nodes):

		newNetwork.getDefaultNodeTable().getRow(node1.getSUID()).set("name", "Node1");
		newNetwork.getDefaultNodeTable().getRow(node2.getSUID()).set("name", "Node2");
		newNetwork.getDefaultNodeTable().getRow(node3.getSUID()).set("name", "Node3");
		newNetwork.getDefaultNodeTable().getRow(node4.getSUID()).set("name", "Node4");

		// Step 3_2 (Create two new node columns):
		newNetwork.getDefaultNodeTable().createColumn("Hello", String.class, true);
		newNetwork.getDefaultNodeTable().createColumn("World", Double.class, true);

		// Step 3_3 (Add data to the new columns):
		newNetwork.getDefaultNodeTable().getRow(node1.getSUID()).set("Hello", "H1");
		newNetwork.getDefaultNodeTable().getRow(node1.getSUID()).set("World", 10.0);

		newNetwork.getDefaultNodeTable().getRow(node2.getSUID()).set("Hello", "H2");
		newNetwork.getDefaultNodeTable().getRow(node2.getSUID()).set("World", 20.0);

		newNetwork.getDefaultNodeTable().getRow(node3.getSUID()).set("Hello", "H3");
		newNetwork.getDefaultNodeTable().getRow(node3.getSUID()).set("World", 30.0);

		newNetwork.getDefaultNodeTable().getRow(node4.getSUID()).set("Hello", "H4");
		newNetwork.getDefaultNodeTable().getRow(node4.getSUID()).set("World", 40.0);

		// The third parameter is related to directional/non-directional
		CyEdge edge14 = newNetwork.addEdge(node1, node4, false);
		// Question: why are they not shown in a directed manner?
		CyEdge edge12 = newNetwork.addEdge(node1, node2, true);
		CyEdge edge23 = newNetwork.addEdge(node2, node3, true);
		CyEdge edge32 = newNetwork.addEdge(node3, node2, true);
		CyEdge edge24 = newNetwork.addEdge(node2, node4, true);

		networkManager.addNetwork(newNetwork);

		// **************************************
		// *** The Problem:
		// *** The correct view is hidden until we do "Clear All Edge Bends"
		// **************************************
		// Step 4_1
		// newNetwork.
		CyNetworkView view01 = viewFactory.createNetworkView(newNetwork);

		View<CyEdge> edge12_view = view01.getEdgeView(edge12);
		View<CyNode> node1_view = view01.getNodeView(node1);

		node1_view.setVisualProperty(BasicVisualLexicon.NODE_FILL_COLOR, java.awt.Color.PINK);
		node1_view.setVisualProperty(BasicVisualLexicon.NODE_SHAPE, NodeShapeVisualProperty.DIAMOND);

		node1_view.setVisualProperty(BasicVisualLexicon.NODE_LABEL, "Mahdi");
		node1_view.setVisualProperty(BasicVisualLexicon.NODE_Y_LOCATION, 10);
		node1_view.setVisualProperty(BasicVisualLexicon.NODE_Y_LOCATION, 50);
		
		PassthroughMapping pMapping = (PassthroughMapping)
		mappingFunctionFactory.createVisualMappingFunction("name", String.class, BasicVisualLexicon.NODE_LABEL);
		
		VisualStyle visualStyle = styleFactory.createVisualStyle("MahdiStyle!");
		visualStyle.addVisualMappingFunction(pMapping);
		
		
		visualStyle.apply(view01);
		view01.updateView();
		// view01.
		viewManager.addNetworkView(view01);

		// edge12_view.setVisualProperty(DoubleVisualProperty, value);

		// Step 4_1_End

		boolean destroyNetwork = false;
		if (destroyNetwork)
		{
			// Destroy it
			networkManager.destroyNetwork(newNetwork);
		}

	}

}
