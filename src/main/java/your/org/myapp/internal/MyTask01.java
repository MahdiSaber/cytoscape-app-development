package your.org.myapp.internal;

import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.model.CyNode;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.AbstractTask;
import org.cytoscape.work.TaskMonitor;

public class MyTask01 extends AbstractTask
{
	CyNetworkFactory networkFactory;
	CyNetworkManager networkManager;
	CyNetworkNaming networkNaming;

	public MyTask01(CyNetworkFactory networkFactory, CyNetworkManager networkManager, CyNetworkNaming networkNaming)
	{
		this.networkFactory = networkFactory;
		this.networkManager = networkManager;
		this.networkNaming = networkNaming;

	}

	@Override
	public void run(TaskMonitor arg0) throws Exception
	{
		CyNetwork newNetwork = networkFactory.createNetwork();
		newNetwork.getRow(newNetwork).set(CyNetwork.NAME, networkNaming.getSuggestedNetworkTitle("Best Network"));

		CyNode node1 = newNetwork.addNode();
		CyNode node2 = newNetwork.addNode();
		CyNode node3 = newNetwork.addNode();
		CyNode node4 = newNetwork.addNode();

//		newNetwork.getDefaultNodeTable().getRow(node1.getSUID()).set("name", "Node1");
//		newNetwork.getDefaultNodeTable().getRow(node2.getSUID()).set("name", "Node2");
//		newNetwork.getDefaultNodeTable().getRow(node3.getSUID()).set("name", "Node3");
//		newNetwork.getDefaultNodeTable().getRow(node4.getSUID()).set("name", "Node4");

		// The third parameter is related to directional/non-directional
		newNetwork.addEdge(node1, node4, false);
		// Question: why are they not shown in a directed manner?
		newNetwork.addEdge(node1, node2, true);
		newNetwork.addEdge(node2, node3, true);
		newNetwork.addEdge(node3, node2, true);
		newNetwork.addEdge(node2, node4, true);

		networkManager.addNetwork(newNetwork);

		boolean destroyNetwork = false;
		if (destroyNetwork)
		{
			// Destroy it
			networkManager.destroyNetwork(newNetwork);
		}

	}

}
