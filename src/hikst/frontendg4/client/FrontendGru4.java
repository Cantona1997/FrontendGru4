package hikst.frontendg4.client;

import hikst.frontendg4.shared.FieldVerifier;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.RootLayoutPanel;
/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class FrontendGru4 implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";
	
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		 RootLayoutPanel.get().add(new MyDockLayoutPanel());				
	}
}
