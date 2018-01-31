import java.util.Scanner;

public class BoardMain {
	private static Board[] boardarr;
	
	public static void initBoard() {
		boardarr = new Board[3];
		boardarr[0] = new Board("자유게시판");
		boardarr[1] = new Board("사진게시판");
		boardarr[2] = new Board("판매게시판");
	}
	
	public static void showBoardMenu() {
		System.out.println("1. 자유게시판");
		System.out.println("2. 사진게시판");
		System.out.println("3. 판매게시판");
		System.out.println("0. 종료");
	}
	
	public static void showPostList(Board b) {
		b.viewPostList();
	}
	
	public static void showCRUDMenu() {
		System.out.println("1. 글쓰기");
		System.out.println("2. 글읽기");
		System.out.println("3. 글수정");
		System.out.println("4. 글삭제");
		System.out.println("0. 게시판 목록으로 돌아가기");
	}
	
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		Board b = null;
		initBoard();
		
		while (flag) {
			showBoardMenu();
			int num = scan.nextInt();
			switch (num) {
			case 1:
				b = boardarr[0];
				break;
			case 2:
				b = boardarr[1];
				break;
			case 3:
				b = boardarr[2];
				break;
			case 0:
				flag = false;
				break;
			}
			if (!flag) break;
			boolean flag2 = true;
			while (flag2) {
				showPostList(b);
				showCRUDMenu();
			
				int num2 = scan.nextInt();
				
				switch (num2) {
				case 1: b.createPost(); break;
				case 2: b.readPost(); break;
				case 3: b.updatePost(); break;
				case 4: b.deletePost(); break;
				case 0: flag2 = false;
				}
			}
		}
	}
}
