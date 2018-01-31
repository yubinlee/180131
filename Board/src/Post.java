public abstract class Post {
	private String postName;
	private String userName;
	private String postDate;
	private int	hit;
	
	public Post(String postName, String userName, String postDate) {
		this.postName = postName;
		this.userName = userName;
		this.postDate = postDate;
		hit = 0;
	}

	public String getPostName() {
		return postName;
	}

	public void setPostName(String postName) {
		this.postName = postName;
	}

	public String getUserName() {
		return userName;
	}
	
	public String getPostDate() {
		return postDate;
	}

	public int getHit() {
		return hit;
	}
	
	abstract void CreatePost();
	
	abstract void readPost();
	
	abstract void updatePost();
	
	void click() {
		hit++;
	}
}