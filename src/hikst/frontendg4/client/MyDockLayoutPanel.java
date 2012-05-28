package hikst.frontendg4.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Button;
import com.googlecode.gchart.client.GChart;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Label;
 
public class MyDockLayoutPanel extends Composite {

	public boolean lightbolb = false;
	public boolean heater = false;
	public boolean loggedin = false;
	String user1 = "hikst";
	//interface MyUiBinder extends UiBinder<Widget, MyDockLayoutPanel>{}
	Objects o = new Objects();
    EffektvsTidGraf g;
	private static MyDockLayoutPanelUiBinder uiBinder = GWT
    .create(MyDockLayoutPanelUiBinder.class);
    
    @UiField Button Test1;
    @UiField FlowPanel centerPanel;
    @UiField TextBox housesize;
    @UiField TextBox nrpersons;
    @UiField TextBox user;
    @UiField TextBox pass;
    @UiField Button login;
    @UiField Label aa;
    @UiField Button update;
    int nrpersons2 = 1;
    int housesize2 = 1;
    
    public MyDockLayoutPanel(){
    	initWidget(uiBinder.createAndBindUi(this));
    	aa.setText("You need to log in");
    	//housesize.setText("");
    	//nrpersons.setText("");	
    }

    @UiHandler("housesize")
    void onClick(ClickEvent event){
    	housesize.setText("");
    }
    
    @UiHandler("nrpersons")
    void onClick3(ClickEvent event){
    	nrpersons.setText("");
    }
    
    @UiHandler("update")
    void onClick4(ClickEvent e){
    	String s = nrpersons.getText();
    	String ss = housesize.getText();
    	nrpersons2 = Integer.parseInt(s);
    	housesize2 = Integer.parseInt(ss);
    	aa.setText(s + " " + ss);
    	
    	if (nrpersons2 <= 3){
    		nrpersons2 = 1;
    		
    	}
    	
    	if (nrpersons2 >=4 && nrpersons2 <= 6){
    		nrpersons2 = 2;
    		
    	}
    	if (nrpersons2 > 7){
    		nrpersons2 = 3;
    		
    	}
    	if (housesize2 <= 80){
    		housesize2 = 1;
    		
    	}
    	
    	if (housesize2 >=81 && housesize2 <= 150){
    		housesize2 = 2;
    	}
    	if (housesize2 > 151){
    		housesize2 = 3;
    	}
    	o.setHouseSize(nrpersons2);
    	o.setnrPersons(housesize2);
    	
    	
    }
    
    interface MyDockLayoutPanelUiBinder extends
            UiBinder<Widget, MyDockLayoutPanel> {
    }
 
	@UiHandler("Test1")
    void onClick2(ClickEvent e) {
        heater = false;
		lightbolb = true;
		//centerPanel.clear();
		if (loggedin ==  true){
			g = new EffektvsTidGraf(o);	
			centerPanel.clear();
			centerPanel.add(g);
			//g.setObjects(o);
		    g.update();
		}		
		else{
			Window.alert("You need to log in to start the simulation");
		}
    }

	@UiHandler("login") void onClick1(ClickEvent ee){
		
		if (user.getText().toString().equals(user1)){
			loggedin = true;
			aa.setText("");
			aa.setText("You are logged in " + user.getText().toString());
	
		}
		else {
			aa.setText("Wrong username or pass " + user.getText().toString());
		}
	}
	
}