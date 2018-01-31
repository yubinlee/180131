
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Board {
	private String boardName;
	private int postCount;
	private Post[] parr;
	public final int MAX_POST_NUM = 1024;

	public Board(String boardName) {
		this.boardName = boardName;
		postCount = 0;
		unifyBoard();
	}
	
	public String getBoardName() {
		return boardName;
	}

	public int getPostCount() {
		return postCount;
	}
	
	public Post[] getParr() {
		return parr;
	}
	
	public void unifyBoard() {
		switch (boardName) {
		case "자유게시판":
			parr = new FreePost[MAX_POST_NUM];
			break;
		case "사진게시판":
			parr = new PhotoPost[MAX_POST_NUM];
			break;
		case "판매게시판":
			parr = new SalesPost[MAX_POST_NUM];
			break;
		}
	}

	public void viewPostList() {
		System.out.println("<"+boardName+">");
		for (int i = 0; i < postCount; i++) {
			System.out.println("["+(i+1)+"] "+parr[i].getPostName());
		}
	}
	
	public boolean checkIdx(int idx) {
		if (idx < 0 || idx > postCount) {
			System.out.println("목록에 있는 번호를 입력해주세요");
			return false;
		}
		return true;
	}
	
	public void createPost() {
		Scanner scan = new Scanner(System.in);
		System.out.print("글 제목: ");
		String postName = scan.nextLine();
		System.out.print("작성자: ");
		String userName = scan.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("yy/MM/dd");
		Date date = new Date();
		String postDate = sdf.format(date);
		switch (boardName) {
		case "자유게시판":
			parr[postCount] = new FreePost(postName, userName, postDate);
			break;
		case "사진게시판":
			parr[postCount] = new PhotoPost(postName, userName, postDate);
			break;
		case "판매게시판":
			parr[postCount] = new SalesPost(postName, userName, postDate);
			break;
		}
		postCount++;
	}
	
	public void readPost() {
		System.out.print("조회를 원하는 글번호를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int idx = scan.nextInt();
		if (checkIdx(idx-1)) {
			parr[idx-1].readPost();
		}
		
	}
	
	public void updatePost() {
		System.out.println("수정을 원하는 글번호를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int idx = scan.nextInt();
		if (checkIdx(idx-1)) {
			parr[idx-1].updatePost();
		}
	}
	
	public void deletePost() {
		System.out.println("삭제를 원하는 글번호를 입력하세요: ");
		Scanner scan = new Scanner(System.in);
		int idx = scan.nextInt();
		if (checkIdx(idx-1)) {
			for (int i = idx-1; i < postCount; i++) {
				parr[i] = parr[i+1];
			}
			postCount--;
		}
	}
	
}