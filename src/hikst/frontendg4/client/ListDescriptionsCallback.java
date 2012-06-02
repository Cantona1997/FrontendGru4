package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class ListDescriptionsCallback implements AsyncCallback<List<Description>> {

	MyDockLayoutPanel panel;
	
	ListDescriptionsCallback(MyDockLayoutPanel panel)
	{
		this.panel = panel;
	}
	
	@Override
	public void onFailure(Throwable caught) {
		
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(List<Description> result) {
		
		//TODO:
		//add all the finished simulations....
		
		if(result.size() > 0)
		{
			panel.setData(result.get(0));
		}
		else
		{
			Window.alert("No finished simulations found in the database");
		}
		
	}

}
