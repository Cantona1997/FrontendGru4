package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.Plot;
import hikst.frontendg4.shared.SimulatorObject;

import java.util.List;

import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>DatabaseService</code>.
 */
public interface DatabaseServiceAsync {

	void getData(int sim_description_id, AsyncCallback<List<Plot>> callback)
	throws IllegalArgumentException;
	void getSimulatorObject(int simulation_object_id, AsyncCallback<SimulatorObject> callback)
	throws IllegalArgumentException;
	void getSimulationDescriptionsIDs(AsyncCallback<List<Integer>> callback)
	throws IllegalArgumentException;
	void getSimulation(int sim_description_id, AsyncCallback<Description> callback)
	throws IllegalArgumentException;
	void getSimulations(AsyncCallback<List<Description>> callback)
	throws IllegalArgumentException;;
}
