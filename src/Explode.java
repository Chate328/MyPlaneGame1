import java.awt.Graphics;
import java.awt.Image;

public class Explode {
 double x,y;
 static Image[] imgs=new Image[4];
 static {
	 for(int i=0;i<imgs.length;i++) {
		 imgs[i]=GameUtil.getImage("images/planed/timg"+(i+1)+".jpg");
		 imgs[i].getWidth(null);
	 }
 }
 int count;
 
 public void draw(Graphics g) {
	 if(count<=3) {
		 g.drawImage(imgs[count],(int)x,(int)y,null);
		 count++;
	 }
 }
 public Explode(double x,double y) {
	 this.x=x;
	 this.y=y;
 }
}
