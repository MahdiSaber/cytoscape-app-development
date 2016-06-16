package your.org.myapp.internal;

import org.cytoscape.model.CyNetworkFactory;
import org.cytoscape.model.CyNetworkManager;
import org.cytoscape.session.CyNetworkNaming;
import org.cytoscape.view.model.CyNetworkViewFactory;
import org.cytoscape.view.model.CyNetworkViewManager;
import org.cytoscape.view.vizmap.VisualMappingFunctionFactory;
import org.cytoscape.view.vizmap.VisualMappingManager;
import org.cytoscape.view.vizmap.VisualStyleFactory;
import org.cytoscape.work.AbstractTaskFactory;
import org.cytoscape.work.TaskIterator;

public class MyTaskFactory extends AbstractTaskFactory
{
	CyNetworkManager networkManager;
	CyNetworkFactory networkFactory;
	CyNetworkNaming networkNaming;
	CyNetworkViewFactory viewFactory;
	CyNetworkViewManager viewManager;
	VisualMappingFunctionFactory mappingFunctionFactory;
	VisualStyleFactory styleFactory;
	VisualMappingManager mappingManager;
	
	public MyTaskFactory(CyNetworkFactory networkFactory,
			CyNetworkManager networkManager,
			CyNetworkNaming networkNaming,
			CyNetworkViewFactory viewFactory,
			CyNetworkViewManager viewManager,
			VisualMappingFunctionFactory mappingFunctionFactory,
			VisualStyleFactory styleFactory,
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
	public TaskIterator createTaskIterator()
	{
		return new TaskIterator(new MyTask01(networkFactory, networkManager, networkNaming, viewFactory,viewManager,mappingFunctionFactory,styleFactory, mappingManager));

	}

}
