package hikst.frontendg4.client;

public class Objects {
	public int housesize;
	public int nrpersons;
	public int yAxis;
	
	public Objects(){
		this.housesize = 1;
		this.nrpersons = 1;
		this.yAxis = 1200;
	}
	
	public int getHouseSize(){
		return housesize;
	}

	public int getNrPersons(){
		return housesize;
	}
	
	public void setnrPersons(int nrpersons){
		this.nrpersons = nrpersons;
	}
	
	public void setHouseSize(int housesize){
		this.housesize = housesize;
	}
	
	public int getYAxis(){
		return yAxis;
	}

	public void setYAxis(int yAxis){
		this.yAxis = yAxis;
	}
	
	public String ToString (int nrpersons, int housesize, int yAxis){
		return null;
	}
}
