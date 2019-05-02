package lxd.Hello;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Ranima {
	private static final int W=100;
	private static final int H=25;
	private static String sss=null;
	private Ranima(){};
	public static String getimava(){
		return sss;
	}
	public static BufferedImage getima(){
		BufferedImage ima=new BufferedImage(W, H,BufferedImage.TYPE_INT_RGB );
		Graphics g=ima.getGraphics();
		setbk(g);
		setbd(g);
		drl(g);
		sss=drn((Graphics2D)g);
		return ima;
	}
	//设置背景色
	private static void setbk(Graphics im){
		im.setColor(Color.WHITE);
		im.fillRect(0, 0, W, H);
	}
	//设置边框
	private static void setbd(Graphics im){
		im.setColor(Color.BLUE);
		im.drawRect(1, 1, W-2, H-2);
	}
	//甚至干扰线
	private static void drl(Graphics im){
		im.setColor(Color.GREEN);
		Random ra=new Random();
		for(int i=0;i!=15;++i){

			im.drawLine(ra.nextInt(W),ra.nextInt(H),ra.nextInt(W),ra.nextInt(H));
		}

	}
	//写随机数
	private static String drn(Graphics2D im){
		im.setColor(Color.RED);
		im.setFont(new Font("宋体",Font.BOLD,23));
		//[\u4e00-\u9fa5]
		String s="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random ra=new Random();
		StringBuilder ss=new StringBuilder("");
		for(int i=0;i!=4;++i){
			String ch= s.charAt(ra.nextInt(s.length()))+"";
			ss.append(ch);
			//   int tx=ra.nextInt(5)+3+i*30,ty=ra.nextInt(5)+23;
			int tx=i*25+8,ty=20;
			double tz=(ra.nextInt(60)-30)*Math.PI/180;
			im.rotate(tz,tx,ty);
			im.drawString(ch,tx,ty);
			im.rotate(-tz, tx, ty);
		}
		return ss.toString();
	}


}
