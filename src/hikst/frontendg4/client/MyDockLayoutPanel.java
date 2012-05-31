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

	private boolean lightbolb = false;
	private boolean heater = false;
	private boolean loggedin = false;
	private boolean updated = false;
	private String user1 = "hikst";
	private String userpass = "2012";
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
    	aa.setText("Du må logge inn");
    	//housesize.setText("");
    	//nrpersons.setText("");	
    }

    @UiHandler("housesize")
    void onClick(ClickEvent event){
    	housesize.setText("");
    }
    
    @UiHandler("user")
    void onClick5(ClickEvent e){
    	user.setText("");
    }
    
    @UiHandler("pass")
    void onClick6(ClickEvent e){
    	pass.setText("");
    }
    
    @UiHandler("nrpersons")
    void onClick3(ClickEvent event){
    	nrpersons.setText("");
    }
    
    @UiHandler("update")
    void onClick4(ClickEvent e){
    	updated = true;
    	String s = nrpersons.getText();
    	String ss = housesize.getText();
    	nrpersons2 = Integer.parseInt(s);
    	housesize2 = Integer.parseInt(ss);
    	//aa.setText(s + " " + ss);
    	
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
			
			if (updated == true){
				g = new EffektvsTidGraf(o);	
				centerPanel.clear();
				centerPanel.add(g);
				//g.setObjects(o);
			    g.update();
			}
			else{
				Window.alert("Har du glemt å oppdatere innput?");
			}
			
		}		
		else{
			Window.alert("Du må logge inn før du kan gjøre en simulasjon!");
		}
    }

	@UiHandler("login") void onClick1(ClickEvent ee){
		
		if (user.getText().toString().equals(user1) && pass.getText().toString().equals(userpass)){
			loggedin = true;
			aa.setText("");
			aa.setText("Du er logget inn " + user.getText().toString());
	
		}
		else if (user.getText().toString().equals("") || pass.getText().toString().equals("")){
			aa.setText("Du glemte å skrive passord eller brukernavn");
		}
		else {
			aa.setText("Feil brukernavn eller passord" + user.getText().toString());
		}
	}
	
}