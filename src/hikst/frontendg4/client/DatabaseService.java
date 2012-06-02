package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.Plot;
import hikst.frontendg4.shared.SimulatorObject;

import java.util.List;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("database")
public interface DatabaseService extends RemoteService
{
	List<Integer> getSimulationDescriptionsIDs() throws IllegalArgumentException;
	List<Plot> getData(int sim_description_id) throws IllegalArgumentException;
	SimulatorObject getSimulatorObject(int simulation_object_id) throws IllegalArgumentException;
	Description getSimulation(int sim_description_id) throws IllegalArgumentException;
	List<Description> getSimulations() throws IllegalArgumentException;
}
