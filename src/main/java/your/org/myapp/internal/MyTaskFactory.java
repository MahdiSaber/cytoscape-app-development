package your.org.myapp.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class MyTaskFactory extends AbstractTaskFactory
{
	CyNetworkManager networkManager;
	CyNetworkFactory networkFactory;
	CyNetworkViewFactory networkViewFactory;
	CyNetworkViewManager networkViewManager;

	public MyTaskFactory(CyNetworkFactory networkFactory, CyNetworkManager networkManager,
			CyNetworkViewFactory networkViewFactory, CyNetworkViewManager networkViewManager)
	{
		this.networkFactory = networkFactory;
		this.networkManager = networkManager;
		this.networkViewFactory = networkViewFactory;
		this.networkViewManager = networkViewManager;

	}

	@Override
	public TaskIterator createTaskIterator()
	{
		return new TaskIterator(new MyTask01(networkFactory, networkManager, networkViewFactory, networkViewManager));

	}

}
