package your.org.myapp.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class MyTaskFactory extends AbstractTaskFactory
{
	CyNetworkManager networkManager;
	CyNetworkFactory networkFactory;
	CyNetworkNaming networkNaming;

	public MyTaskFactory(CyNetworkFactory networkFactory, CyNetworkManager networkManager,
			CyNetworkNaming networkNaming)
	{
		this.networkFactory = networkFactory;
		this.networkManager = networkManager;
		this.networkNaming = networkNaming;

	}

	@Override
	public TaskIterator createTaskIterator()
	{
		return new TaskIterator(new MyTask01(networkFactory, networkManager, networkNaming));

	}

}
