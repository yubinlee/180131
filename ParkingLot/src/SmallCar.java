
public class SmallCar extends Car{

	public SmallCar(String carNumber, int x, int y) {
		super(carNumber, x, y);
	}
	
	@Override
	void payCharge(int sec) {
		this.setCharge(sec*50);
	}

}
