package hikst.frontendg4.client;

import java.util.Date;

import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.SimulatorObject;

public class Simulation
{
	private static final String WATT = "Watt";
	private static final String AMPERE = "Ampere";
	private static final String VOLT = "Volt";
	private static final String KILOWATT_PER_HOUR ="KiloWatt/Hour";
	
	private static final String WATT_Y_LABEL = "W";
	private static final String AMPERE_Y_LABEL = "A";
	private static final String VOLT_Y_LABEL = "V";
	private static final String KILOWATT_PER_HOUR_Y_LABEL = "KwH";
	
	private static final String WATT_COLOR = "blue";
	private static final String AMPERE_COLOR = "red";
	private static final String VOLT_COLOR = "green";
	private static final String WATT_PER_HOUR_COLOR = "yellow";
	
	private Graph effectGraph;
	public Graph getEffectGraph() {
		return effectGraph;
	}

	public Graph getVoltageGraph() {
		return voltageGraph;
	}

	public Graph getPowerConsumptionGraph() {
		return powerConsumptionGraph;
	}

	public Graph getCurrentGraph() {
		return currentGraph;
	}

	public SimulatorObject getSimulatorObject() {
		return simulatorObject;
	}

	private Graph voltageGraph;
	private Graph powerConsumptionGraph;
	private Graph currentGraph;
	
	private SimulatorObject simulatorObject;
	
	public Simulation(Description description)
	{
		simulatorObject = description.getSimulatorObject();
		
		Date[] times = description.getTimes();
		double[] effects = description.getEffects();
		double[] voltages = description.getVoltage();
		double[] currents = description.getCurrents();
		double[] power_consumptions = description.getPowerConsumptions();
		
		effectGraph = new Graph(times,effects,simulatorObject,WATT_Y_LABEL,WATT,WATT_COLOR);
		voltageGraph = new Graph(times,voltages,simulatorObject,VOLT_Y_LABEL,VOLT,VOLT_COLOR);
		currentGraph = new Graph(times,currents, simulatorObject,AMPERE_Y_LABEL,AMPERE,AMPERE_COLOR);
		powerConsumptionGraph = new Graph(times,power_consumptions,simulatorObject,KILOWATT_PER_HOUR_Y_LABEL,KILOWATT_PER_HOUR,WATT_PER_HOUR_COLOR);
	}
}

