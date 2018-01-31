import java.awt.Frame;
import java.awt.Image;
import java.awt.Toolkit;

public class Photo extends Frame {
	private Image image;
	private String imageURL;
	
	public Photo(String imageURL) {
		this.imageURL = imageURL;
		super.setVisible(true);
		super.setSize(400, 400);
		super.setResizable(true);
		
	}
	public void paint(java.awt.Graphics g){
		image = Toolkit.getDefaultToolkit().getImage(imageURL);
		g.drawImage(image, 0, 0, this);
	}	
}
