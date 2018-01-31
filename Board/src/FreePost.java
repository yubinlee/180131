import java.util.Scanner;

public class FreePost extends Post{
	private String memo;
	
	public FreePost(String postName, String userName, String postDate) {
		super(postName, userName, postDate);
		CreatePost();
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	void CreatePost() {
		Scanner scan = new Scanner(System.in);
		System.out.println("작성할 내용을 입력하세요: ");
		String str = scan.nextLine();
		setMemo(str);
	}

	@Override
	void readPost() {
		System.out.println("조회하신 게시글의 정보입니다: ");
		System.out.println("글 제목: "+ getPostName());
		System.out.println("작성자: "+ getUserName());
		System.out.println("작성 날짜: "+ getPostDate());
		click();
		System.out.println("조회수: "+ getHit());
		System.out.println("내용: "+ getMemo());
	}

	@Override
	void updatePost() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 내용을 입력하세요: ");
		String str = scan.nextLine();
		System.out.println("정말 수정하시겠습니까?(Y/N)");
		char ch = scan.nextLine().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			setMemo(str);
			System.out.println("변경사항이 저장되었습니다.");
		}
	}
	
}
