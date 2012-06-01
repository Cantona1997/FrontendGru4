package hikst.frontendg4.client;

import java.util.Date;
import java.util.Random;


//import com.google.gwt.widgetideas.graphics.client.GWTCanvas;

import java.util.HashMap;


import com.google.gwt.user.client.Timer;
import com.googlecode.gchart.client.GChart;

/** Simple time sequence example with date-time x-axis labels */
public class EffektvsTidGraf extends GChart {
	//Objects o = new Objects();
	Timer t;
	final int N_EDITABLE_CURVES = 10;
    int insertionCurve = N_EDITABLE_CURVES-1;
    final int N_POINTS = 100;
    
   static class DateStampedValue {
     Date date;
     
     double value;
     @SuppressWarnings("deprecation")
	public DateStampedValue(String dateTimeString, double value) {
       this.date = new Date(dateTimeString);
       this.value = value;
     }
   }
   public static double lightbolb = 40.0;
   //MyDockLayoutPanel mdlp = new MyDockLayoutPanel()

// http://groups.google.com/group/Google-Web-Toolkit/msg/6125ce39fd2339ac
   DateStampedValue[] persX1;
   Random rnd = new Random();
   
   EffektvsTidGraf(Objects o) {   	
    super(900,450);
    
    persX1 = new DateStampedValue[]{
    	    new DateStampedValue("5/25/2012 00:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 02:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 03:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 04:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 05:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 06:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 07:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 08:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 09:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 10:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 11:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 12:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 13:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 14:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 15:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 16:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 17:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 18:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 19:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 20:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 21:30", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 22:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1)),
    	    new DateStampedValue("5/25/2012 23:00", lightbolb * o.housesize*o.nrpersons*(rnd.nextInt(4)+1))
    	   };
    
    
    
  /*  GChart.setDefaultSymbolBorderColors(new String[] {
            "#0084d1", "#004586", "#ff420e", "#ffd320",
            "#579d1c", "#7e0021", "#83caff",
            "#314004", "#aecf00", "#4b1f6f",
            "#ff950e", "#c5000b", });
    
     HashMap<String, Double> curveData = new HashMap<String, Double>();
           
     curveData.put("catmull-rom-tension", 0.5);
     
     for (int i = 0; i < N_EDITABLE_CURVES; i++) {
         addCurve();
         getCurve().setCurveData((Object) curveData);
         getCurve().getSymbol().setHeight(7); 
         getCurve().getSymbol().setWidth(7);
         getCurve().getSymbol().setBorderWidth(1);
         getCurve().getSymbol().setSymbolType(SymbolType.LINE);
         getCurve().getSymbol().setFillThickness(2);
         getCurve().getSymbol().setFillSpacing(0);
         if (i == 0) {
           // enveloped sin to give them something to zoom in on 
           for (int j = 0; j < N_POINTS; j++) 
             getCurve().addPoint(j, 100*Math.sin((4*Math.PI*j)/N_POINTS)*
                                    Math.sin(15*(Math.PI * j)/N_POINTS));
         }
         else {
            // single point "starter curve" for editing purposes
            getCurve().addPoint(getXAxis().getAxisMin(),
                                getYAxis().getAxisMin() +
                                ((i+0.0)/N_EDITABLE_CURVES)*
                                (getYAxis().getAxisMax() -
                                 getYAxis().getAxisMin()));
         }

      }*/
     setChartTitle("<b><i><big>Str&oslashmforbruk for lysp&aeligrer</big></i></b>");
     setPadding("5px");
     //setLineJoin(GWTCanvas.ROUND)
     
     getXAxis().setAxisLabel("<small><b><i>24 Timer</i></b></small>");
     getXAxis().setHasGridlines(true);
     getXAxis().setTickCount(6);
     getXAxis().setTickLabelFormat("=(Date)dd/h:mm a");
   //  getXAxis().setAxisMax();
          
     getYAxis().setAxisLabel("<small><b><i>Watt</i></b></small>");
     getYAxis().setHasGridlines(true);
     getYAxis().setTickCount(20);
     getYAxis().setAxisMin(0);
     getYAxis().setAxisMax(o.yAxis);
     
     addCurve();
     getCurve().setLegendLabel("<i>Watt</i>");
     getCurve().getSymbol().setBorderColor("blue");
     getCurve().getSymbol().setBackgroundColor("blue");
     getCurve().getSymbol().setFillSpacing(1);
     getCurve().getSymbol().setFillThickness(2);
     getCurve().getSymbol().setSymbolType(SymbolType.LINE);

    // t = new Timer(){public void run(){};};
//     t = new Timer() {
//    	 
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			   for (int i = 0; i < persX1.length; i++){
//			       getCurve().addPoint(persX1[i].date.getTime(), persX1[i].value);
//			       setUpArray();
//			       update();
//			       t.schedule(1);
//			     }
//		}
//     };
     for (int i = 0; i < persX1.length; i++){
	       getCurve().addPoint(persX1[i].date.getTime(), persX1[i].value);
     }
  
   }
    
    @Override
	public void update() {
		// TODO Auto-generated method stub
		super.update();
	}

	private void setUpArray() {
		// TODO Auto-generated method stub
		
		persX1[0].value = 60;
	}

//	public void setObjects(Objects o){
//    	this.o = o;
//    }
   
}
