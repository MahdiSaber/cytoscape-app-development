package your.org.myapp.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.view.model.CyNetworkView;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class MyTask01 extends AbstractTask 
{
	CyNetworkFactory networkFactory;
	CyNetworkManager networkManager;
	CyNetworkViewFactory networkViewFactory;
	CyNetworkViewManager networkViewManager;
	
	public MyTask01(CyNetworkFactory networkFactory, CyNetworkManager networkManager, CyNetworkViewFactory networkViewFactory, CyNetworkViewManager networkViewManager)
	{
		this.networkFactory = networkFactory;
		this.networkManager = networkManager;
		this.networkViewFactory = networkViewFactory;
		this.networkViewManager = networkViewManager;
		
		
	}

	@Override
	public void run(TaskMonitor arg0) throws Exception
	{
		CyNetwork newNetwork = networkFactory.createNetwork();
		networkManager.addNetwork(newNetwork);
		
		CyNode node1 = newNetwork.addNode();
		CyNode node2 = newNetwork.addNode();
		CyNode node3 = newNetwork.addNode();
		newNetwork.getDefaultNodeTable().getRow(node1.getSUID()).set("name", "Node1");
		newNetwork.getDefaultNodeTable().getRow(node2.getSUID()).set("name", "Node2");
		newNetwork.getDefaultNodeTable().getRow(node3.getSUID()).set("name", "Node3");
		newNetwork.addEdge(node1, node2, true);
		newNetwork.addEdge(node2, node3, true);
		
		CyNetworkView view01 = networkViewFactory.createNetworkView(newNetwork);
		networkViewManager.addNetworkView(view01);
		
		
	}

}
