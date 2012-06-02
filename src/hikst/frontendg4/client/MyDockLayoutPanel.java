package hikst.frontendg4.client;

import java.util.ArrayList;

import org.apache.tools.ant.taskdefs.Exit;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Tree;
import com.google.gwt.user.client.ui.TreeItem;
import com.google.gwt.user.client.ui.Widget;
 
public class MyDockLayoutPanel extends Composite {

  private boolean lightbolb = false;
  private boolean heater = false;
  private boolean loggedin = false;
  private boolean updated = false;
  private String user1 = "Navn";
  private String userpass = "Passord";
  

	//interface MyUiBinder extends UiBinder<Widget, MyDockLayoutPanel>{}
	Objects o; 
	ArrayList<Objects> houses = new ArrayList<Objects>();
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
    @UiField Tree tree;
    @UiField Button remHouses;
    int nrpersons2 = 1;
    int housesize2 = 1;
    int yAxis = 1200;
	private int houseCounter = 0;
    
    
    public MyDockLayoutPanel(){
    	initWidget(uiBinder.createAndBindUi(this));    	
    	aa.setText("Du m\u00E5 logge inn");
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
    	o = new Objects();
    	updated = true;
    	String s = nrpersons.getText();
    	String ss = housesize.getText();
    	nrpersons2 = Integer.parseInt(s);
    	housesize2 = Integer.parseInt(ss);
    	// aa.setText(s + " " + ss);
    	
    	if (nrpersons2 <= 3){
    		nrpersons2 = 1;
    	}
    	
    	if (nrpersons2 >=4 && nrpersons2 <= 6){
    		nrpersons2 = 2;
    	}
    	
    	if (nrpersons2 > 7){
    		nrpersons2 = 3;
    		yAxis = 3000;
    	}
    	if (nrpersons2 > 9 || housesize2 > 250){
    		Window.alert("For stort hus, eller for mange beboere.");
    		return;
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
    	o.setYAxis(yAxis);
    	houses.add(o);
    	
    	CheckBox cb = new CheckBox("House "+(houseCounter = houseCounter + 1));
    	cb.setValue(true);
    	TreeItem house = new TreeItem(cb);
    	TreeItem info = new TreeItem("Info");
    	info.addItem("Areal: "+Integer.parseInt(ss));
    	house.addItem(info);
    	TreeItem people = new TreeItem("Occupants:");
    	for(int i = 0; i < Integer.parseInt(s);i++){
    		people.addItem("Person "+i);
    	}
    	house.addItem(people);
    	tree.addItem(house);
    	initWidget(tree);
    	
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
			if(updated == true){
				g = new EffektvsTidGraf(houses);
			centerPanel.clear();
			centerPanel.add(g);
		    g.update();
			}
			else {
				 Window.alert("Du m\u00E5 legge til hus før du kan simulere");
			}
			
		}		
		else{
			Window.alert("Du m\u00E5 logge inn f\u00F8r du kan gj\u00F8re en simulasjon!");
		}
    }

	
	
	@UiHandler("login") void onClick1(ClickEvent ee){
		
		if (user.getText().toString().equals(user1) && pass.getText().toString().equals(userpass)){
			loggedin = true;
			aa.setText("");
			aa.setText("Du er logget inn " + user.getText().toString());
		}
		else if (user.getText().toString().equals("") || pass.getText().toString().equals("")){
			aa.setText("Du glemte \u00E5 skrive passord eller brukernavn");
		}
		else {
			aa.setText("Feil brukernavn eller passord");
			}
			
			}
	
	
	@UiHandler("user")
	void onUserClick(ClickEvent event) {
		user.setText("");
	}
	@UiHandler("pass")
	void onPassClick(ClickEvent event) {
		pass.setText("");
	}
	@UiHandler("remHouses")
	void onRemHousesClick(ClickEvent event) {
		houses.clear();
		tree.clear();
		updated = false;
	}
}