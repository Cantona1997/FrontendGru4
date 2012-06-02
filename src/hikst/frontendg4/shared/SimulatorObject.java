package hikst.frontendg4.shared;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SimulatorObject implements Serializable
{
	private static final long serialVersionUID = 101L;
	
	private String name;
	
	private List<SimulatorObject> sons;
	
	public String getName()
	{
		return name;
	}
	
	public List<SimulatorObject> Sons()
	{
		return sons;
	}
	
	public boolean hasSons()
	{
		return sons.size() > 0;
	}
	
	public SimulatorObject()
	{
		
	}
	
	public SimulatorObject(String name, ArrayList<SimulatorObject> sons)
	{
		this.name = name;
		this.sons = sons;
	}
}
