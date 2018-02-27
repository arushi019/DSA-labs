import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.text.DecimalFormat;
//Arushi Chauhan
//BTech CSE 2020
//Roll no:2016019
//Lab3 submission
public class sys implements ActionListener{
	private JTextField itott,ctott,iappd,imand,iorad,ipind,iband,cappd,cmand,corad,cpind,cband;
	private JButton submit;
	private int ia,im,ip,io,ib,ca,cm,cp,cb,co;
	public void fire(){
		JFrame fr=new JFrame();
		//setLayout(new GridLayout(5,2,3,1));
		ia=10;
		im=8;
		io=6;
		ip=4;
		ib=2;
		ca=0;
		cm=0;
		cb=0;
		cp=0;
		co=0;
		Panel up=new Panel(new BorderLayout());
		JLabel welc=new JLabel("IIITD Fruit Stall",SwingConstants.CENTER);
		Panel inup=new Panel(new BorderLayout());
		//welc.setPreferredSize(new Dimension(300,10));
		//Panel div=new Panel(new GridLayout(2,0));
		JLabel inv=new JLabel("Inventory",SwingConstants.CENTER);
		JLabel use=new JLabel("User",SwingConstants.CENTER);
		up.add(welc);
		inup.add(inv,BorderLayout.WEST);
		inup.add(use,BorderLayout.EAST);
		up.add(inup,BorderLayout.SOUTH);
		Panel ipanel=new Panel(new GridLayout(7,1,0,0));
		//JLabel inv=new JLabel("Inventory");
		//ipanel.add(inv);
		JLabel init=new JLabel("Items");
		ipanel.add(init);
		JLabel inqu=new JLabel("Quantity");
		ipanel.add(inqu);
		JLabel apple=new JLabel("Apples");
		ipanel.add(apple);
		iappd=new JTextField("10",4);
		ipanel.add(iappd);
		JLabel mango=new JLabel("Mango");
		ipanel.add(mango);
		imand=new JTextField("8",4);
		ipanel.add(imand);
		JLabel orange=new JLabel("Oranges");
		ipanel.add(orange);
		iorad=new JTextField("6",4);
		ipanel.add(iorad);
		JLabel pine=new JLabel("Pineapple");
		ipanel.add(pine);
		ipind=new JTextField("4",4);
		ipanel.add(ipind);
		JLabel bana=new JLabel("Bananas");
		ipanel.add(bana);
		iband=new JTextField("2",4);
		ipanel.add(iband);
		JLabel itot=new JLabel("Total");
		ipanel.add(itot);
		itott=new JTextField("30",4);
		ipanel.add(itott);
		Panel cpanel=new Panel(new GridLayout(7,1,0,0));
		//JLabel use=new JLabel("User");
		//cpanel.add(use);
		JLabel cuit=new JLabel("Items");
		cpanel.add(cuit);
		JLabel cuqu=new JLabel("Quantity");
		cpanel.add(cuqu);
		JLabel capple=new JLabel("Apples");
		cpanel.add(capple);
		cappd=new JTextField("0",4);
		cpanel.add(cappd);
		JLabel cmango=new JLabel("Mango");
		cpanel.add(cmango);
		cmand=new JTextField("0",4);
		cpanel.add(cmand);
		JLabel corange=new JLabel("Oranges");
		cpanel.add(corange);
		corad=new JTextField("0",4);
		cpanel.add(corad);
		JLabel cpine=new JLabel("Pineapple");
		cpanel.add(cpine);
		cpind=new JTextField("0",4);
		cpanel.add(cpind);
		JLabel cbana=new JLabel("Bananas");
		cpanel.add(cbana);
		cband=new JTextField("0",4);
		cpanel.add(cband);
		JLabel ctot=new JLabel("Total");
		cpanel.add(ctot);
		ctott=new JTextField("0",4);
		cpanel.add(ctott);
		submit=new JButton("Submit");
		submit.addActionListener(this);
		fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		fr.setLayout(new BorderLayout());
		fr.getContentPane().add(up,BorderLayout.NORTH);
		//fr.getContentPane().add(div);
		fr.getContentPane().add(ipanel,BorderLayout.WEST);
		fr.getContentPane().add(cpanel,BorderLayout.EAST);
		fr.getContentPane().add(submit,BorderLayout.SOUTH);
		fr.setSize(500,250);
		fr.setVisible(true);
	}
	public void actionPerformed(ActionEvent event){
		ca=Integer.parseInt(cappd.getText());
		if (ca>ia){
			ca=0;
		}
		else{
			ia=ia-ca;
		}
		cm=Integer.parseInt(cmand.getText());
		if (cm>im){
			cm=0;
		}
		else{
			im=im-cm;
		}
		co=Integer.parseInt(corad.getText());
		if (co>io){
			co=0;
		}
		else{
			io=io-co;
		}
		cp=Integer.parseInt(cpind.getText());
		if (cp>ip){
			cp=0;
		}
		else{
			ip=ip-cp;
		}
		cb=Integer.parseInt(cband.getText());
		if (cb>ib){
			cb=0;
		}
		else{
			ib=ib-cb;
		}
		if (ia==0)cappd.setEnabled(false);
		if (im==0)cmand.setEnabled(false);
		if (io==0)corad.setEnabled(false);
		if (ip==0)cpind.setEnabled(false);
		if (ib==0)cband.setEnabled(false);
		int tc=ca+cm+co+cp+cb;
		int ti=ia+im+io+ip+ib;
		cappd.setText(String.valueOf(ca));
		cmand.setText(String.valueOf(cm));
		corad.setText(String.valueOf(co));
		cband.setText(String.valueOf(cb));
		cpind.setText(String.valueOf(cp));
		iappd.setText(String.valueOf(ia));
		imand.setText(String.valueOf(im));
		iorad.setText(String.valueOf(io));
		ipind.setText(String.valueOf(ip));
		iband.setText(String.valueOf(ib));
		itott.setText(String.valueOf(ti));
		ctott.setText(String.valueOf(tc));

	} 
	public static void main(String[] args){
		sys star=new sys();
		//sys.press();
		star.fire();
	}
}