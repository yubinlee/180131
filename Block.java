
public abstract class Block {
	public static final int width = 2;
	public static final int height = 2;
	private int state;
	
	public Block() {
	}
	
	public int getWidth() {
		return width;
	}
	public int getHeight() {
		return height;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	abstract void move();
	abstract void rotate();
	abstract void printBlock();
}
