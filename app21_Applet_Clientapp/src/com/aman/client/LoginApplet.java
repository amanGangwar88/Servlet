package com.aman.client;

import java.applet.Applet;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

 

public class LoginApplet extends Applet implements ActionListener{
  
	Label l1,l2;
	TextField tf1,tf2;
	Button b;
	String status="";
	
	@Override
	public void init() {
		this.setLayout(new FlowLayout());
		this.setBackground(Color.green);
		this.setSize(500, 500);
		
		l1=new Label("User Name");
		l2=new Label("Password");
		
		tf1=new TextField(20);
		tf2=new TextField(20);
		tf2.setEchoChar('*');
		
		b=new Button("Login");
		b.addActionListener(this);
		
		
		Font font=new Font("arial", Font.BOLD, 15);
		l1.setFont(font);
		l2.setFont(font);
		tf1.setFont(font);
		tf2.setFont(font);
		b.setFont(font);
		
		this.add(l1);this.add(tf1);
		this.add(l2);this.add(tf2);
		this.add(b);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	 try {
		String uname=tf1.getText();
		String upwd=tf2.getText();
		
		URL url=new URL("http://localhost:5555/app20/login?uname="+uname+"&upwd="+upwd);
		URLConnection uc=url.openConnection();
		uc.setDoInput(true);
		uc.setDoOutput(true);
		InputStream is=uc.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(is));
		status=br.readLine();
		repaint();
	} catch (Exception exc) {
		exc.printStackTrace();
	}
	}
	public void paint(Graphics g) {
		Font font = new Font("arial", Font.BOLD, 25);
		g.setFont(font);
		g.drawString("Status   :", 100, 300);
	}
}
