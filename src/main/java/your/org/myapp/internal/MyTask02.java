package your.org.myapp.internal;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyEdge;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.model.subnetwork.CyRootNetwork;
import org.cytoscape.model.subnetwork.CySubNetwork;
import org.cytoscape.service.util.internal.CyActivator;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.model.View;
import org.cytoscape.view.presentation.property.BasicVisualLexicon;
import org.cytoscape.view.presentation.property.NodeShapeVisualProperty;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyle;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;
import org.cytoscape.work.Tunable;
public class MyTask02 extends AbstractTask
{
	
	@Tunable(description="This is my tunable description for my task",groups={"mahdi2", "salamcmd2"})
	CyNetworkFactory networkFactory;
	CyNetworkManager networkManager;
	CyNetworkNaming networkNaming;
	CyNetworkViewFactory viewFactory;
	CyNetworkViewManager viewManager;
	VisualMappingFunctionFactory mappingFunctionFactory;
	VisualStyleFactory styleFactory;
	VisualMappingManager mappingManager;
	
	VisualMappingFunctionFactory mappingFunctionFactoryContinous;

	public MyTask02(CyNetworkFactory networkFactory, CyNetworkManager networkManager, CyNetworkNaming networkNaming,
			CyNetworkViewFactory viewFactory, CyNetworkViewManager viewManager,
			VisualMappingFunctionFactory mappingFunctionFactory, VisualStyleFactory styleFactory,
			VisualMappingManager mappingManager, VisualMappingFunctionFactory mappingFunctionFactoryContinous)
	{
		this.networkFactory = networkFactory;
		this.networkManager = networkManager;
		this.networkNaming = networkNaming;
		this.viewFactory = viewFactory;
		this.viewManager = viewManager;
		this.mappingFunctionFactory = mappingFunctionFactory;
		this.styleFactory = styleFactory;
		this.mappingManager = mappingManager;
		this.mappingFunctionFactoryContinous = mappingFunctionFactoryContinous;
	}

	@Override
	public void run(TaskMonitor arg0) throws Exception
	{
		CySubNetwork newNetwork = (CySubNetwork)networkManager.getNetwork(52);
		System.out.println(newNetwork.getSUID());
		CyRootNetwork rootNetwork = newNetwork.getRootNetwork();
		System.out.println("This is the root network SUID: " + rootNetwork.getSUID());
		
		CySubNetwork subNet2 = (CySubNetwork)networkManager.getNetwork(82);
		System.out.println("This is the second root network SUID: " + subNet2.getRootNetwork().getSUID());
		
		CySubNetwork subNet3 = (CySubNetwork)networkManager.getNetwork(96);
		System.out.println("This is the third root network SUID: " + subNet3.getRootNetwork().getSUID());
		
		CySubNetwork subNet4 = (CySubNetwork)networkManager.getNetwork(130);
		System.out.println("This is the fourth root network SUID: " + subNet4.getRootNetwork().getSUID());
		
		CyRootNetwork rootNet1 = (CyRootNetwork)networkManager.getNetwork(36);
		if (rootNet1 == newNetwork)
		{
			System.out.println("Har 2 Yeki hastand");
		}
		else
		{
			System.out.println("They are different!");
		}
		
		
		CyNode node6 = networkManager.getNetwork(96).getNode(142);
		if(node6 == null)
		{
			System.out.println("node 6 is null!");
		}
		else
		{
			System.out.println("node 6 SUID is "+node6.getSUID());
		}
		int nodeCount = networkManager.getNetwork(96).getNodeCount();
		System.out.println("Node count net 96 is :" + nodeCount);
		
//		for (CyNode node : networkManager.getNetwork(96))
		
		if (((CySubNetwork)networkManager.getNetwork(96)).getRootNetwork().containsNode(node6))
		{
			System.out.println("Root network has this node");
		}
		if (networkManager.getNetwork(52).containsNode(node6))
		{
			System.out.println("network 52 has this node");
		}
//		
		if (networkManager.getNetwork(96).containsNode(node6))
		{
			System.out.println("network 96 has this node");
		}
		
		System.out.println("These are all the nodes in root net:");
//		System.out.println(rootNetwork.);
		for(CyNode cyNode : rootNetwork.getNodeList())
		{
			System.out.println(cyNode.getSUID());
		}
		
		
		
		Object test1 = networkManager.getNetwork(36);
		System.out.println(test1 == null); //result = null
		
		Object test2 = ((CySubNetwork)networkManager.getNetwork(96)).getRootNetwork();
		System.out.println(test2 == null); //result is not null!
		
		System.out.println(rootNetwork.getBaseNetwork().getSUID());
		
		
		//System.out.println(networkManager.getNetwork(36).getSUID());
		
		
		//newNetwork.getRow(newNetwork).set(CyNetwork.NAME, "This is my newNetwork");
	
		
		
		//networkManager.addNetwork(newNetwork);

		boolean destroyNetwork = false;
		if (destroyNetwork)
		{
			// Destroy it
			networkManager.destroyNetwork(newNetwork);
		}

	}

}
