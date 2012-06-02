package hikst.frontendg4.client;

import java.util.List;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class DescriptionIDsCallback implements AsyncCallback<List<Integer>>
{

	@Override
	public void onFailure(Throwable caught) {
		
		Window.alert(caught.getMessage());
		
	}

	@Override
	public void onSuccess(List<Integer> result) {
		
	/*	Window.alert("IDs :"+result.size());
		
		for(int i = 0; i<result.size(); i++)
		{
			ids.add(result.get(i));
		}*/
		
	}
	
};