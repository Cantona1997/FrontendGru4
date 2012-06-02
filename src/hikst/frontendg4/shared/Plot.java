package hikst.frontendg4.shared;

import java.io.Serializable;
import java.util.Date;

public class Plot implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private Date date;
	private float effect;
	private float power_consumption;
	private float voltage;
	private float current;
	
	public Date getDateX() {
		return date;
	}
	
	public float getEffectY() {
		return effect;
	}
	
	public float getPower_consumptionY() {
		return power_consumption;
	}
	
	public float getVoltageY() {
		return voltage;
	}
	
	public float getCurrentY() {
		return current;
	}

	public Plot(){}
	
	public Plot(Date date, float effect, float power_consumption,
			float voltage, float current) {
		super();
		this.date = date;
		this.effect = effect;
		this.power_consumption = power_consumption;
		this.voltage = voltage;
		this.current = current;
	}
}
