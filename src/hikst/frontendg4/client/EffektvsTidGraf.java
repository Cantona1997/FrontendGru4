package hikst.frontendg4.client;

import java.util.Date;

import com.googlecode.gchart.client.GChart;

public class EffektvsTidGraf extends GChart {
	
	static class DateStampedValue {
	     Date date;
	     double value;
	     public DateStampedValue(String dateTimeString, double value) {
	     this.date = new Date(dateTimeString);
	     this.value = value;
	     }
	   }
	
	 DateStampedValue[] dateSequence = {
			    new DateStampedValue("5/23/2012 03:00", 40.0),
			    new DateStampedValue("5/23/2012 04:00", 80.0),
			    new DateStampedValue("5/23/2012 05:00", 80.0),
			    new DateStampedValue("5/23/2012 06:00", 80.0),
			    new DateStampedValue("5/23/2012 07:00", 80.0),
			    new DateStampedValue("5/23/2012 08:00", 120.0),
			    new DateStampedValue("5/23/2012 09:00", 120.0),
			    new DateStampedValue("5/23/2012 10:00", 120.0),
			    new DateStampedValue("5/23/2012 11:00", 160.0),
			    new DateStampedValue("5/23/2012 12:00", 160.0),
			    new DateStampedValue("5/23/2012 13:00", 200.0),
			    new DateStampedValue("5/23/2012 14:00", 280.0),
			    new DateStampedValue("5/23/2012 15:00", 320.0),
			    new DateStampedValue("5/23/2012 16:00", 320.0),
			    new DateStampedValue("5/23/2012 17:00", 320.0),
			    new DateStampedValue("5/23/2012 18:00", 320.0),
			    new DateStampedValue("5/23/2012 19:00", 200.0),
			    new DateStampedValue("5/23/2012 20:00", 200.0),
			    new DateStampedValue("5/23/2012 21:00", 160.0),
			    new DateStampedValue("5/23/2012 22:00", 160.0),
			    new DateStampedValue("5/23/2012 23:00", 120.0),
			    new DateStampedValue("5/23/2012 00:00", 80.0),
			    new DateStampedValue("5/23/2012 01:00", 80.0),
			    new DateStampedValue("5/23/2012 02:00", 40.0),
			   };
	 
	 EffektvsTidGraf() {
		 super(1000,600); 
	     setChartTitle("<b><i><big>Effektbruk over tid</big></i></b>");
	     setPadding("5px");
	     
	     getXAxis().setAxisLabel("<small><b><i>Tid</i></b></small>");
	     getXAxis().setHasGridlines(true);
	     getXAxis().setTickCount(6);
	     // Except for "=(Date)", a standard GWT DateTimeFormat string
	     getXAxis().setTickLabelFormat("=(Date)dd/h:mm a");
	          
	     getYAxis().setAxisLabel("<small><b><i>WATT</i></b></small>");
	     getYAxis().setHasGridlines(true);
	     getYAxis().setTickCount(6);
	     getYAxis().setAxisMin(10);
	     getYAxis().setAxisMax(400);
	     
	     addCurve();
	     getCurve().setLegendLabel("<i>T (W)</i>");
	     getCurve().getSymbol().setBorderColor("blue");
	     getCurve().getSymbol().setBackgroundColor("blue");
	     getCurve().getSymbol().setFillSpacing(10);
	     getCurve().getSymbol().setFillThickness(3);

	     for (int i = 0; i < dateSequence.length; i++)
	       // Note that getTime() returns milliseconds since
	       // 1/1/70--required whenever "date cast" tick label
	       // formats (those beginning with "=(Date)") are used.
	       getCurve().addPoint(dateSequence[i].date.getTime(),
	                           dateSequence[i].value);
	   }
}


