
public class CommuteByCar extends Car {

	public CommuteByCar(String carNumber, int x, int y) {
		super(carNumber, x, y);
	}

	@Override
	void payCharge(int sec) {
		this.setCharge(sec/60*1000);
	}

}
