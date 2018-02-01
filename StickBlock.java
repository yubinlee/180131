import java.util.Random;

public class StickBlock extends Block{

	public StickBlock() {
		Random r = new Random();
		int num = Math.abs(r.nextInt()%2)+1;
		setState(num);
	}

	@Override
	void move() {
		;
	}

	@Override
	void rotate() {
		if (getState() == 1) {
			setState(2);
		}
		else {
			setState(1);
		}
	}

	@Override
	void printBlock() {
		int state = getState();
		switch(state) {
		case 1:
			System.out.println("■");
			System.out.println("■");
			break;
		case 2:
			System.out.println("■■");
			break;
		}
	}

}
