package hikst.frontendg4.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FlowPanel;
 
public class MyDockLayoutPanel extends Composite {
 
    private static MyDockLayoutPanelUiBinder uiBinder = GWT
            .create(MyDockLayoutPanelUiBinder.class);
    
    EffektvsTidGraf g1 = new EffektvsTidGraf();
    
    @UiField Button runButton;
    @UiField FlowPanel centerpanel;
 
    interface MyDockLayoutPanelUiBinder extends
            UiBinder<Widget, MyDockLayoutPanel> {
    }
 
    public MyDockLayoutPanel() {
        initWidget(uiBinder.createAndBindUi(this));
    }
    
    @UiHandler("runButton")
    void onClick(ClickEvent e) {
    
    	centerpanel.add(g1);
    	g1.update();
    }
}


