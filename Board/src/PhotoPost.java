import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.Scanner;

public class PhotoPost extends Post {

	private String imageURL;
	
	public PhotoPost(String postName, String userName, String postDate) {
		super(postName, userName, postDate);
		CreatePost();
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
		System.out.print("등록할 이미지 주소를 입력하세요: ");
		imageURL = scan.nextLine();
		//imageURL = "/Users/yubin/Desktop/heart.png";
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
		Photo p = new Photo(imageURL);
	}

	@Override
	void updatePost() {
		Scanner scan = new Scanner(System.in);
		System.out.println("수정할 이미지 주소를 입력하세요: ");
		String str = scan.nextLine();
		//String str = "/Users/yubin/Desktop/twinkleheart.png";
		System.out.println("정말 수정하시겠습니까?(Y/N)");
		char ch = scan.nextLine().charAt(0);
		if (ch == 'y' || ch == 'Y') {
			setImage(str);
			System.out.println("변경사항이 저장되었습니다.");
		}
	}
}
