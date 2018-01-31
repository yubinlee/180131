
public class GeneralCar extends Car {

	public GeneralCar(String carNumber, int x, int y) {
		super(carNumber, x, y);
	}

	@Override
	void payCharge(int sec) {
		this.setCharge(sec*100);
	}
}
