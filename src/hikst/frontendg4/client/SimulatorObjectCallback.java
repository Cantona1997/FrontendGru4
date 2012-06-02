package hikst.frontendg4.client;

import hikst.frontendg4.shared.SimulatorObject;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class SimulatorObjectCallback implements AsyncCallback<SimulatorObject>
{
	MyDockLayoutPanel panel;
	
	SimulatorObjectCallback(MyDockLayoutPanel panel)
	{
		this.panel = panel;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(SimulatorObject result) {
		
		//panel.setData();
	}

}