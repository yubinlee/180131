
public abstract class Car {

	private String carNumber;
	private int X; 
	private int Y; 
	private int startTime;
	private int endTime;
	private int sec;
	private int charge;
	
	public Car(String carNumber, int x, int y) {
		this.carNumber = carNumber;
		X = x;
		Y = y;
		this.sec = 0;
		this.charge = 0;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getStartTime() {
		return startTime;
	}

	public int getEndTime() {
		return endTime;
	}

	public int getSec() {
		sec = (endTime - startTime)/1000;
		return sec;
	}
	
	public int getCharge() {
		return charge;
	}

	public void setCharge(int charge) {
		this.charge = charge;
	}

	abstract void payCharge(int sec);
	
	public void carIn(){
		startTime = (int)System.currentTimeMillis();
	}
	
	public void carOut(){
		endTime = (int)System.currentTimeMillis();
		payCharge(getSec());
	}
}
