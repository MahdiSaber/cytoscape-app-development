package your.org.myapp.internal;
import org.cytoscape.model.events.AddedNodesEvent;
import org.cytoscape.model.events.AddedNodesListener;;


public class TestHandler implements AddedNodesListener
{
	CyActivator cyActivator;
	
	public TestHandler(CyActivator cyActivator)
	{
		this.cyActivator=cyActivator;
	}
	
	

	@Override
	public void handleEvent(AddedNodesEvent e)
	{
		//System.out.println("My AddedNodesEvent is fired!");
		//cyActivator
		//cyActivator.g//
	}

}
