import java.util.Random;
import java.util.Scanner;

public class TetrisMain {
	private static char[][] tetrisarr;
	public static final int MAX_TETRIS_WIDTH = 6;
	public static final int MAX_TETRIS_HEIGHT = 6;
	private static int blockCount;
	
	public static void initTetris() {
		tetrisarr = new char[MAX_TETRIS_HEIGHT][MAX_TETRIS_WIDTH];
		blockCount = 0;
	}
	
	public static void showMenu() {
		System.out.println("1. 블록쌓기");
		System.out.println("2. 초기화하기");
		System.out.println("0. 종료");
	}
	
	public static void showTetris() {
		for (int i = 0; i < MAX_TETRIS_HEIGHT; i++){
			for (int j = 0; j < MAX_TETRIS_WIDTH; j++){
				if (tetrisarr[i][j] == '■') {
					System.out.print("■");
				}
				System.out.print("□");
			}
			System.out.println("");
		}
	}
	
	public static int checkLocation(int i, int j){
		;
		return -1;
	}
	
	public static Block selectBlockType(){
		Random r = new Random();
		int blocktype = Math.abs(r.nextInt()%3)+1;
		Block b = null;
		switch (blocktype) {
		case 1:
			b = new StickBlock();
			break;
		case 2:
			b = new SquareBlock();
			break;
		case 3:
			b = new L_Block();
			break;
		}
		return b;
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		boolean flag = true;
		initTetris();
		
		while (flag) {
			showTetris();
			showMenu();
			int num = scan.nextInt();
			switch (num) {
			case 1:
				Block b = selectBlockType();
				b.printBlock();
				break;
			case 2:
				tetrisarr =  null;
				initTetris();
				break;
			case 0:
				flag = false;
				break;
			}
		}
		
	}
}
/*
 public class ParkingLotMain {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		boolean flag = true;
		initParkingLot();
		
		while (flag) {
			showParkingLot();
			showMenu();
			int num = scan.nextInt();
			switch (num) {
			case 1:
				System.out.print("주차할 차량의 번호: ");
				String str = scan2.nextLine();
				System.out.print("주차할 차량의 위치: ");
				int i = scan.nextInt();
				int j = scan.nextInt();
				if (checkLocation(i, j) != -1) {
					System.out.println("이미 주차된 자리입니다.");
				}
				else {
					showType();
					System.out.print("주차할 차량의 종류: ");
					int type = scan.nextInt();
					switch (type){
					case 1:cararr[carCount] = new GeneralCar(str, i, j); break;
					case 2:cararr[carCount] = new SmallCar(str, i, j); break;
					case 3:cararr[carCount] = new CommuteByCar(str, i, j); break;
					}
					cararr[carCount].carIn();
					carCount++;
				}
				break;
			case 2:
				System.out.print("출차할 차량의 번호를 입력: ");
				String str2 = scan2.nextLine();
				int targetidx = 0;
				for (int idx = 0; idx < carCount; idx++){
					if (str2.equals(cararr[idx].getCarNumber())){
						targetidx = idx;
						break;
					}
				}
				cararr[targetidx].carOut();
				System.out.println("요금: "+cararr[targetidx].getCharge()+"원");
				for (int idx = targetidx; idx < carCount-1; idx++){
					cararr[targetidx] = cararr[targetidx+1];
				}
				carCount--;
				break;
			case 0:
				flag = false;
				break;
			}
		}
	}
}
 */