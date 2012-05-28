package hikst.frontendg4.client;

import java.util.Date;
import java.util.Random;

import com.googlecode.gchart.client.GChart;

/** Simple time sequence example with date-time x-axis labels */
public class EffektvsTidGraf extends GChart {
	//Objects o = new Objects();
	
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
   
   EffektvsTidGraf(Objects o){   	
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
     
     setChartTitle("<b><i><big>Strømforbruk for lyspærer</big></i></b>");
     setPadding("5px");
     
     getXAxis().setAxisLabel("<small><b><i>24 Timer</i></b></small>");
     getXAxis().setHasGridlines(true);
     getXAxis().setTickCount(6);
     // Except for "=(Date)", a standard GWT DateTimeFormat string
     getXAxis().setTickLabelFormat("=(Date)dd/h:mm a");
          
     getYAxis().setAxisLabel("<small><b><i>Watt</i></b></small>");
     getYAxis().setHasGridlines(true);
     getYAxis().setTickCount(20);
     getYAxis().setAxisMin(0);
     getYAxis().setAxisMax(1200);
     
     addCurve();
     getCurve().setLegendLabel("<i>Watt</i>");
     getCurve().getSymbol().setBorderColor("blue");
     getCurve().getSymbol().setBackgroundColor("blue");
     getCurve().getSymbol().setFillSpacing(10);
     getCurve().getSymbol().setFillThickness(3);

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
