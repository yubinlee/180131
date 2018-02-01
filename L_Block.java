import java.util.Random;

public class L_Block extends Block{

	public L_Block() {
		Random r = new Random();
		int num = Math.abs(r.nextInt()%4)+1;
		setState(num);
	}

	@Override
	void move() {
		// TODO Auto-generated method stub
		
	}

	@Override
	void rotate() {
		if (getState() == 4) {
			setState(1);
		}
		else {
			int state = getState()+1;
			setState(state);
		}
	}

	@Override
	void printBlock() {
		int state = getState();
		switch(state) {
		case 1:
			System.out.println("■□");
			System.out.println("■■");
			break;
		case 2:
			System.out.println("■■");
			System.out.println("■□");
			break;
		case 3:
			System.out.println("■■");
			System.out.println("□■");
			break;
		case 4:
			System.out.println("□■");
			System.out.println("■■");
			break;
		}
	}
	
}
