import java.awt.*;
import javax.swing.*;
class mypanel extends JPanel{
	public void paintComponent(Graphics g){
		g.setColor(Color.orange);
		g.fillRect(20,50,100,100);
	}
	public static void main(String[] args){
		mypanel p=new mypanel();
		p.paintComponent
	}
}