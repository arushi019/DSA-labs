import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class simplegui3 implements ActionListener{
	JFrame frame;
	public static void main(String[] args){
		simplegui3 gui=new simplegui3();
		gui.go();
	}
	public void go(){
		frame=new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button=new JButton("Change color");
		button.addActionListener(this);
		mypanel p=new mypanel();
		frame.getContentPane().add(BorderLayout.SOUTH,button);
		frame.getContentPane().add(BorderLayout.CENTER,p);
		frame.setSize(300,300);
		frame.setVisible(true);
	}
	public void actionPerformed(ActionEvent event){
		frame.repaint();
	}
}
class mypanel extends JPanel{
	public void paintComponent(Graphics g){
		g.fillRect(0,0,this.getWidth(),this.getHeight());
		int red=(int)(Math.random()*255);
		int green=(int)(Math.random()*255);
		int blue=(int)(Math.random()*255);
		Color randomColor=new Color(red,green,blue);
		g.setColor(randomColor);
		g.fillOval(70,70,100,100);
	}
}