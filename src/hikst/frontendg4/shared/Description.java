package hikst.frontendg4.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Description implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6397120006771778860L;
	long minimumTime;
	long maximumTime;
	SimulatorObject simulatorObject;
	List<Plot> plots = new ArrayList<Plot>();
	
	public long getMinimumTime() {
		return minimumTime;
	}



	public long getMaximumTime() {
		return maximumTime;
	}

	public SimulatorObject getSimulatorObject() {
		return simulatorObject;
	}

	public List<Plot> getPlots() {
		return plots;
	}
	
	public Description(){}
	
	public Description(SimulatorObject simulatorObject, List<Plot> plots, long minimum, long maximum)
	{
		this.simulatorObject = simulatorObject;
		this.plots = plots;
		this.minimumTime = minimum;
		this.maximumTime = maximum;
	}
	
	public double[] getEffects()
	{
		double[] effects = new double[plots.size()];
		
		for(int i = 0; i<plots.size(); i++)
		{
			effects[i] = plots.get(i).getEffectY();
		}
		
		return effects;
	}
	
	public double[] getCurrents()
	{
		double[] currents = new double[plots.size()];
		
		for(int i = 0; i<plots.size(); i++)
		{
			currents[i] = plots.get(i).getCurrentY();
		}
		
		return currents;
	}
	
	public double[] getPowerConsumptions()
	{
		double[] consumptions = new double[plots.size()];
		
		for(int i = 0; i<plots.size(); i++)
		{
			consumptions[i] = plots.get(i).getCurrentY();
		}
		
		return consumptions;
	}
	
	public double[] getVoltage()
	{
		double[] voltages = new double[plots.size()];
		
		for(int i = 0; i<plots.size(); i++)
		{
			voltages[i] = plots.get(i).getVoltageY();
		}
		
		return voltages;
	}
	
	public Date[] getTimes()
	{
		Date[] times = new Date[plots.size()];
		
		for(int i = 0; i<plots.size(); i++)
		{
			times[i] = plots.get(i).getDateX();
		}
		
		return times;
	}
}
