import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;

import javax.swing.JFrame;

/**
 * 游戏窗口
 * @author chate clin
 *
 */
public class MyGameFrame extends JFrame{
	
	
	Image bj=GameUtil.getImage("images/bj.jpg");
	Image planeimage=GameUtil.getImage("images/plane.jpg");
	Image shellimage=GameUtil.getImage("images/shell.jpg");
	Explode bao;
	Plane plane=new Plane(planeimage,270,500);
	Shell[] shell2=new Shell[4];
	public void paint(Graphics g) {
		g.drawImage(bj, 0,0,null);
		plane.drawSelf(g);
		
		for(int i=0;i<shell2.length;i++) {
			shell2[i].drawShell(g);
			boolean peng=shell2[i].getRect().intersects(plane.getRect());
			if(peng) {
				plane.live=false;
				if(bao==null) {
					bao=new Explode(plane.x,plane.y);
				}
				bao.draw(g);
			}
		}

	}
	public void launchFrame() {
		this.setTitle("飞机大作战");
		this.setVisible(true);
		this.setSize(Constent.GAME_WIDTH,Constent.GAME_HEIGHT);
		this.setLocation(200,200);
		this.addWindowListener(new WindowAdapter() {
		public void windowClosed(WindowEvent e) {
			System.exit(0);
		}
		});
		new PaintThread().start();
		addKeyListener(new KeyMonitor());
		for(int i=0;i<shell2.length;i++) {
			shell2[i]=new Shell(shellimage);
		}
	}
	class PaintThread extends Thread {
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(10);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
			
		}
		
	}
	
	private Image offScreenImage=null;
	public void updata(Graphics g) {
		if(offScreenImage==null)
			offScreenImage=this.createImage(Constent.GAME_WIDTH,Constent.GAME_HEIGHT);
		Graphics gOff=offScreenImage.getGraphics();
		paint(gOff);
		g.drawImage(offScreenImage,0,0,null);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
MyGameFrame f=new MyGameFrame();
f.launchFrame();

	}

}
