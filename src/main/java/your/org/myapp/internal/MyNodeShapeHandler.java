package your.org.myapp.internal;

import org.cytoscape.application.CyApplicationManager;
import org.cytoscape.model.CyNetwork;
import org.cytoscape.model.CyTable;
import org.cytoscape.model.events.RowsSetEvent;
import org.cytoscape.model.events.RowsSetListener;

public class MyNodeShapeHandler implements RowsSetListener
{
	CyApplicationManager applicationManager;
	
	public MyNodeShapeHandler(CyApplicationManager applicationManager)
	{
		this.applicationManager = applicationManager;
	}

	@Override
	public void handleEvent(RowsSetEvent e)
	{
	
		CyTable sourceTable = e.getSource();
		System.out.println("Something changed in the table");
		
		
		//if (!e.containsColumn(CyNetwork.))
		//applicationManager.get
		
		//CyNetwork currentNetwork = applicationManager.getCurrentNetwork();
		//currentNetwork.getDefaultNodeTable().getRow(primaryKey)
		
	}
}
