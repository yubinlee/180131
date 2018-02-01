import java.util.Scanner;

public class ParkingLotMain {
	private static Car[] cararr;
	private static int carCount;
	public static final int MAX_CAR_WIDTH = 30;
	public static final int MAX_CAR_HEIGHT = 30;
	
	public static void initParkingLot() {
		cararr = new Car[MAX_CAR_NUM];
		carCount = 0;
	}
	
	public static void showMenu() {
		System.out.println("1. 주차하기");
		System.out.println("2. 출차하기");
		System.out.println("0. 종료");
	}
	
	public static void showType() {
		System.out.println("1. 일반차");
		System.out.println("2. 경차");
		System.out.println("3. 정기권 사용자");
	}
	
	public static void showParkingLot() {
		System.out.println("*현재 주차장 상황*");
		for (int i = 0; i < MAX_CAR_HEIGHT; i++){
			for (int j = 0; j < MAX_CAR_WIDTH; j++){
				System.out.print("[ ");
				int idx = checkLocation(i, j);
				if (idx != -1){
					System.out.print(cararr[idx].getCarNumber());
				}
				else {
					System.out.print("\t");
				}
				System.out.print(" ]");
			}
			System.out.println(" ");
		}
	}

	public static int checkLocation(int i, int j){
		for (int idx = 0; idx < carCount; idx++){
			if (i == cararr[idx].getX() && j == cararr[idx].getY()) {
				return idx;
			}
		}
		return -1;
	}
	
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
