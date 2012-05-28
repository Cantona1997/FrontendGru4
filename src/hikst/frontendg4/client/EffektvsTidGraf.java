package hikst.frontendg4.client;

import java.util.Date;

import com.googlecode.gchart.client.GChart;

public class EffektvsTidGraf extends GChart {
	
	static class GraphValues {
	     Date date;
	     double value;
	     double tidsenhet;
	     public GraphValues(double tidsenhet, double value) {
	   //  this.date = new Date(dateTimeString);
	     this.value = value;
	     this.tidsenhet = tidsenhet;
	     }
	   }
	
	 GraphValues[] dateSequence = {
			   
			    new GraphValues(1, 80.0),
			    new GraphValues(2, 80.0),
			    new GraphValues(3, 40.0),
			    new GraphValues(4, 40.0),
			    new GraphValues(5, 80.0),
			    new GraphValues(6, 80.0),
			    new GraphValues(7, 80.0),
			    new GraphValues(8, 80.0),
			    new GraphValues(9, 120.0),
			    new GraphValues(10, 120.0),
			    new GraphValues(11, 120.0),
			    new GraphValues(12, 160.0),
			    new GraphValues(13, 160.0),
			    new GraphValues(14, 200.0),
			    new GraphValues(15, 280.0),
			    new GraphValues(16, 320.0),
			    new GraphValues(17, 320.0),
			    new GraphValues(18, 320.0),
			    new GraphValues(19, 320.0),
			    new GraphValues(20, 200.0),
			    new GraphValues(21, 200.0),
			    new GraphValues(22, 160.0),
			    new GraphValues(23, 160.0),
			    new GraphValues(24, 120.0),
			   };
	 
	 EffektvsTidGraf() {
		 super(1000,600); 
	     setChartTitle("<b><i><big>Effektbruk over tid</big></i></b>");
	     setPadding("5px");
	     
	     getXAxis().setAxisLabel("<small><b><i>Tid</i></b></small>");
	     getXAxis().setHasGridlines(true);
	     getXAxis().setTickCount(10);
	     // Except for "=(Date)", a standard GWT DateTimeFormat string
	    // getXAxis().setTickLabelFormat("=(Date)dd/h:mm a");
	          
	     getYAxis().setAxisLabel("<small><b><i>WATT</i></b></small>");
	     getYAxis().setHasGridlines(true);
	     getYAxis().setTickCount(10);
	     getYAxis().setAxisMin(0);
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
	    	getCurve().addPoint(dateSequence[i].tidsenhet,
	    	dateSequence[i].value);
	   }
}


