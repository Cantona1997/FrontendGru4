package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class DescriptionsCallback implements AsyncCallback<Description>
{
	MyDockLayoutPanel panel;
	
	DescriptionsCallback(MyDockLayoutPanel panel)
	{
		this.panel = panel;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(Description result) {
		
		panel.setData(result);
	}

}
