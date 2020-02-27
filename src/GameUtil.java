import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.URL;

public class GameUtil {
private GameUtil() {
}
public static Image getImage(String path) {
	BufferedImage bi=null;
	try {
		java.net.URL u=GameUtil.class.getClassLoader().getResource(path);
		bi=ImageIO.read(u);
	}catch(IOException e) {
		e.printStackTrace();
	}
	return bi;
}
}
