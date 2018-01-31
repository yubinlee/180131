import java.util.Scanner;

public class SalesPost extends Post{
	private String memo;
	private String imageURL;
	
	public SalesPost(String postName, String userName, String postDate) {
		super(postName, userName, postDate);
		CreatePost();
	}
	
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getImage() {
		return imageURL;
	}


	public void setImage(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	void CreatePost() {
		Scanner scan = new Scanner(System.in);
		System.out.println("작성할 내용을 입력하세요: ");
		String str = scan.nextLine();
		setMemo(str);
		System.out.print("등록할 이미지 주소를 입력하세요: ");
		imageURL = scan.nextLine();
		Photo p = new Photo(imageURL);
	}

	@Override
	void readPost() {
		System.out.println("조회하신 게시글의 정보입니다: ");
		System.out.println("글 제목: "+ getPostName());
		System.out.println("작성자: "+ getUserName());
		System.out.println("작성 날짜: "+ getPostDate());
		click();
		System.out.println("조회수: "+ getHit());
		System.out.println("내용: ");
		System.out.println(getMemo());
		Photo p = new Photo(imageURL);
	}

	@Override
	void updatePost() {
		Scanner scan = new Scanner(System.in);
		Scanner scan2 = new Scanner(System.in);
		System.out.println("무엇을 수정하시겠습니까?");
		System.out.println("1. 내용");
		System.out.println("2. 이미지");
		int num = scan2.nextInt();
		switch (num){
		case 1:
			System.out.println("수정할 내용을 입력하세요: ");
			String str = scan.nextLine();
			System.out.println("정말 수정하시겠습니까?(Y/N)");
			char ch = scan.nextLine().charAt(0);
			if (ch == 'y' || ch == 'Y') {
				setMemo(str);
				System.out.println("변경사항이 저장되었습니다.");
			}
		case 2:
			System.out.println("수정할 이미지 주소를 입력하세요: ");
			String str2 = scan.nextLine();
			System.out.println("정말 수정하시겠습니까?(Y/N)");
			char ch2 = scan.nextLine().charAt(0);
			if (ch2 == 'y' || ch2 == 'Y') {
				setImage(str2);
				System.out.println("변경사항이 저장되었습니다.");
			}
			break;
		}
	}

}
