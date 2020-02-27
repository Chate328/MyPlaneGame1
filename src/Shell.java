import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

/**
 * ÅÚµ¯ÃèÊö
 * @author chate clin
 *
 */
public class Shell extends GameObject {
	
double degree;
int speed=2;


public void drawShell(Graphics g) {
	g.drawImage(img, (int)x, (int)y,null);
	
	x+=speed*Math.cos(degree);
	y+=speed*Math.sin(degree);
	
	if(x<0||x>Constent.GAME_WIDTH-30) {
		degree=Math.PI-degree;
	}
	if(y<40||y>Constent.GAME_HEIGHT-40) {
		degree=-degree;
	}
}
public Shell(Image img) {
	this.img=img;
    this.x=200;
	this.y=200;
	this.width=img.getWidth(null);
	this.height=img.getHeight(null);
	degree=Math.PI*Math.random()*2;
}

}
