package hikst.frontendg4.server;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import hikst.frontendg4.client.DatabaseService;
import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.Plot;
import hikst.frontendg4.shared.SimulatorObject;

import com.google.gwt.user.client.Window;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class DatabaseServiceImpl extends RemoteServiceServlet implements DatabaseService
{

	@Override
	public List<Plot> getData(int sim_description_id) throws IllegalArgumentException {
		
		Connection connection = DB.getDBC();
		List<Plot> plots = new ArrayList<Plot>();
		
		try
		{
			String query = "SELECT Time, Effect, Power_Consumption, Voltage, Current FROM Simulations WHERE Sim_Description_ID=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, sim_description_id);
			ResultSet set = statement.executeQuery();
			
			while(set.next())
			{
				Date time = new Date(set.getLong(1));
				float effect = set.getFloat(2);
				float power_consumption = set.getFloat(3);
				float voltage = set.getFloat(4);
				float current = set.getFloat(5);
				
				plots.add(new Plot(time,effect,power_consumption,voltage,current));
			}
		}
		catch(SQLException ex)
		{
			//send out error message some way....
			ex.printStackTrace();
		}
	
		return plots;
	}

	@Override
	public SimulatorObject getSimulatorObject(int simulation_object_id)throws IllegalArgumentException
	{
		Connection connection = DB.getDBC();
		
		try
		{		
			String query = "SELECT Name FROM Objects WHERE ID=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, simulation_object_id);
			ResultSet set = statement.executeQuery();
			
			if(set.next())
			{
				String name = set.getString(1);
				return new SimulatorObject(name, new ArrayList<SimulatorObject>());
				
				//TODO: hente ut sønn-objekter også
			}
			else
			{
				throw new IllegalArgumentException();
			}
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			
		}
	
		return null;
	}

	@Override
	public List<Integer> getSimulationDescriptionsIDs(){
		
		List<Integer> simulation_descriptions = new ArrayList<Integer>();
		
		Connection connection = DB.getDBC();
		
		try
		{
			
			String query = "SELECT Simulation_Descriptions.ID FROM Simulation_Descriptions, Simulator_Queue_Objects WHERE Simulation_Descriptions.ID = Simulator_Queue_Objects.Simulation_Descriptions_ID and Status_ID=4";
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet set = statement.executeQuery();
			
			while(set.next())
			{
				simulation_descriptions.add(set.getInt(1));
			}	
		}
		catch(SQLException ex)
		{
			//send message back to client in some way...
			//paste in here...
			ex.printStackTrace();
			throw new IllegalArgumentException();
		}
		
		return simulation_descriptions;
	}
	
	@Override
	public Description getSimulation(int sim_description_id)
	{
		try
		{
			Connection connection = DB.getDBC();
			
			String query = "SELECT Object_ID, minimumTime, maximumTime FROM Simulation_Descriptions WHERE ID=?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, sim_description_id);
			ResultSet set = statement.executeQuery();
			
			if(set.next())
			{
				int object_id = set.getInt(1);
				long minimumTime = set.getLong(2);
				long maximumTime = set.getLong(3);
				
				SimulatorObject simulator_object = getSimulatorObject(object_id);
				List<Plot> plots = getData(sim_description_id);
				
				return new Description(simulator_object,plots,minimumTime,maximumTime);
			}
			else
			{
				throw new IllegalArgumentException();
			}
			
		}catch(SQLException ex)
		{
			//send message back to server that the request failed
			ex.printStackTrace();
			throw new IllegalArgumentException();
			
		}
	}

	@Override
	public List<Description> getSimulations() throws IllegalArgumentException {
		
		List<Description> simulations = new ArrayList<Description>();
		
		List<Integer> descriptionIDs = getSimulationDescriptionsIDs();
		
		for(int i = 0; i<descriptionIDs.size(); i++)
		{
			simulations.add(this.getSimulation(descriptionIDs.get(i)));
		}
		
		return simulations;
	}
}
