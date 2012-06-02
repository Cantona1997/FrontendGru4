package hikst.frontendg4.client;

import hikst.frontendg4.shared.Description;
import hikst.frontendg4.shared.Plot;
import hikst.frontendg4.shared.SimulatorObject;

import java.util.Date;
import java.util.List;

import com.google.gwt.user.client.Window;
import com.googlecode.gchart.client.GChart;

public class Graph extends GChart
{
	//the length of a second in milliseconds
	private final int Second = 1000;
	//the length of a minute in milliseconds
	private final int Minute = 60*Second;
	//the length of an hour in milliseconds
	private final int Hour = 60*Minute;
	//the length of a day in milliseconds 
	private final int Day = 24*Hour;
	//the length of a week in milliseconds
	private final int Week = 7*Day;
	//the length of a month that is even in the gregorian calendar
	private final int evenMonth = 30*Day;
	//the length of a month that is odd in the gregorian calendar
	private final int oddMonth = 31*Day;
	
	private final String PADDING = "5px";
	private static final int Width = 900;
	private static final int Height = 450;
	
	private Date[] x;
	private double[] y;
	private SimulatorObject simulatorObject;
	
	public Graph(Date[] x, double[] y,SimulatorObject simulatorObject,String yLabel,String legendLabel,String color)
	{
		super(Width,Height);
		
		System.out.println(yLabel);
		System.out.println("x: ");
		for(int i = 0; i<x.length; i++)
		{
			System.out.print(x[i]+" ");
		}
		
		System.out.println(yLabel);
		System.out.println("y: ");
		for(int i = 0; i<y.length; i++)
		{
			System.out.println(y[i]+" ");
		}
		
		this.x = x;
		this.y = y;
		this.simulatorObject = simulatorObject;
		
		this.setPadding(PADDING);
		
		long simulatedTimeInMilliSeconds = x[x.length-1].getTime() - x[0].getTime();
		
		setChartTitle("<b><i><big>"+yLabel+" for "+simulatorObject.getName()+"</big></i></b>");
		
		getXAxis().setAxisLabel(getXAxisLabel(simulatedTimeInMilliSeconds));
		getXAxis().setHasGridlines(true);
		getXAxis().setTickCount(x.length);
		
		double minValue = y[getMin(y)];
		double maxValue = y[getMax(y)];
		
		double diff = maxValue - minValue;
		double space = Math.max(diff*3.0/4.0,20);
		
		double minimumY = minValue - space;
		double maximumY = maxValue + space;
		
		getYAxis().setAxisMin(minimumY);
		getYAxis().setAxisMax(maximumY);
		getYAxis().setAxisLabel(yLabel);
		getYAxis().setHasGridlines(true);
		
		addCurve();
	    getCurve().setLegendLabel("<i>"+legendLabel+"</i>");
	    getCurve().getSymbol().setBorderColor(color);
	    getCurve().getSymbol().setBackgroundColor(color);
		getCurve().getSymbol().setFillSpacing(10);
	    getCurve().getSymbol().setFillThickness(3);
	    
	    for (int i = 0; i < x.length; i++){
	        getCurve().addPoint(x[i].getTime(),y[i]);
	      }
	}
	
	private int getMax(double[] plots)
	{
		double max = Float.MIN_VALUE;
		int index = 0;
		
		for(int i = 0; i<plots.length; i++)
		{
			if(plots[i]>max)
			{
				max = plots[i];
				index = i;
			}
		}
		
		return index;
	}
	
	private int getMin(double[] plots)
	{
		double min = Integer.MAX_VALUE;
		int index = 0;
		
		for(int i = 0; i<plots.length; i++)
		{
			if(plots[i]< min)
			{
				min = plots[i];
				index = i;
			}
		}
		
		return index;
	}
	
	private String getXAxisLabel(long simulatedTime)
	{
		String time = "";
		
		//if the length of the simulated time is less than or equal to a second
		if(simulatedTime <= Second)
		{	
			time += simulatedTime+" Milliseconds ";
		}
		else if(simulatedTime <= Minute)
		{
			time += getSeconds(simulatedTime) +" Seconds "; 
			simulatedTime %= Second;
			time += simulatedTime+" Milliseconds ";
		}
		else if(simulatedTime <= Hour)
		{
			time += getMinutes(simulatedTime) + " Hours ";
			simulatedTime %= Minute;
			time += getSeconds(simulatedTime) +" Seconds "; 
			simulatedTime %= Second;
			time += simulatedTime+" Milliseconds ";
		}
		else if(simulatedTime <= Day)
		{
			time += getHours(simulatedTime) + " Days ";
			simulatedTime %= Hour;
			time += getMinutes(simulatedTime) + " Hours ";
			simulatedTime %= Minute;
			time += getSeconds(simulatedTime) +" Seconds "; 
			simulatedTime %= Second;
			time += simulatedTime+" Milliseconds ";
		}
		else
		{
			time += getHours(simulatedTime) + " Days ";
			simulatedTime %= Hour;
			time += getMinutes(simulatedTime) + " Hours ";
			simulatedTime %= Minute;
			time += getSeconds(simulatedTime) +" Seconds "; 
			simulatedTime %= Second;
			time += simulatedTime+" Milliseconds ";
		}
		
		//TODO:
		//insert for month, and year here 
		
		return "<small><b><i>"+time+"</i></b></small>";
	}
	
	private long getSeconds(long milliseconds)
	{
		return ((int)milliseconds) / Second;
	}
	
	private long getMinutes(long milliseconds)
	{
		return ((int)milliseconds) / Minute;
	}
	
	private long getHours(long milliseconds)
	{
		return ((int)milliseconds) / Hour;
	}
	
	private int getDays(long milliseconds)
	{
		return ((int)milliseconds) / Day;
	}
}
