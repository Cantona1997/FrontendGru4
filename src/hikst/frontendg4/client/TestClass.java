package hikst.frontendg4.client;


public class TestClass {
	
	private double x;
	private double y;
	public double res;
	
	public TestClass(double xx, double yy){
		
		x = xx;
		y = yy;
	}

	private double getX() {
		return x;
	}

	private double getY() {
		return y;
	}

	public double calcX(){
		res = x * y;
		return res;
	}
}
