package hikst.frontendg4.client;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import com.google.gwt.user.client.Timer;
import com.googlecode.gchart.client.GChart;

/** Simple time sequence example with date-time x-axis labels */
public class EffektvsTidGraf extends GChart {
	//Objects o = new Objects();
	Timer t;
	final int N_EDITABLE_CURVES = 10;
    int insertionCurve = N_EDITABLE_CURVES-1;
    final int N_POINTS = 100;
    String[] colorArray = {"blue","red","yellow","green","pink","magenta","black"};
    int colorIndex = 0;
    
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
   
   EffektvsTidGraf(ArrayList<Objects> houses) {   	
    super(900,450);
       
    
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
     int maxYAxis = 0;
     for(int k= 0; k<houses.size();k++){
    	 if(houses.get(k).yAxis>maxYAxis)
    		 maxYAxis= houses.get(k).yAxis;
     }
     getYAxis().setAxisMax(maxYAxis);
     
     for(int i = 0; i < houses.size();i++){
     persX1 = new DateStampedValue[]{
     	    new DateStampedValue("5/25/2012 00:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 02:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 03:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 04:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 05:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 06:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 07:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 08:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 09:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 10:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 11:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 12:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 13:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 14:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 15:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 16:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 17:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 18:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 19:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 20:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 21:30", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 22:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1)),
     	    new DateStampedValue("5/25/2012 23:00", lightbolb * houses.get(i).housesize*houses.get(i).nrpersons*(rnd.nextInt(4)+1))
     	   };
     
     addCurve();
     getCurve().setLegendLabel("<i>Watt</i>");
     String color = colorArray[colorIndex];
     colorIndex ++;
     if(colorIndex >= colorArray.length){
    	 colorIndex = 0;
     }
     
     getCurve().getSymbol().setBorderColor(color);
     getCurve().getSymbol().setBackgroundColor(color);
     getCurve().getSymbol().setFillSpacing(1);
     getCurve().getSymbol().setFillThickness(2);
     getCurve().getSymbol().setSymbolType(SymbolType.LINE);
     for (int x = 0; x < persX1.length; x++){
	       getCurve().addPoint(persX1[x].date.getTime(), persX1[x].value);
     }
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
