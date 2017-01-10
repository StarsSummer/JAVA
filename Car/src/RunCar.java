import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;


public class RunCar extends JFrame implements ActionListener{
	public int v1,v2,v3,v4;
	public RunCar(){
		add(new Car());
	}
	
	public static void main(String[] args){
		RunCar frame = new RunCar();
		frame.setTitle("Drive cars");
		frame.setSize(500,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

class Car extends JPanel{
	private int x1=10,x2=10,x3=10,x4=10;
	private int y1=90,y2=140,y3=190,y4=240;
	private int v1,v2,v3,v4;
	
	Timer time =new Timer(100,new ActionListener(){
		public void actionPerformed(ActionEvent e){
			repaint(0,50,500,300);
		}
	});
	
	protected void paintComponent(Graphics g){
		time.start();
		super.paintComponent(g);
		
		g.setColor(new Color(0,0,0));
		g.drawString("car1", 15, 30);
		g.drawString("car2", 115, 30);
		g.drawString("car3", 215, 30);
		g.drawString("car4", 315, 30);
		g.drawLine(0, 50, 500, 50);
		g.drawLine(0, y1+10, 500, y1+10);
		g.drawLine(0, y2+10, 500, y2+10);
		g.drawLine(0, y3+10, 500, y3+10);
		g.drawLine(0, y4+10, 500, y4+10);
		
		g.setColor(new Color(0,0,0));
		g.fillOval(x1, y1, 10, 10);
		g.fillOval(x1+20, y1, 10, 10);
		g.setColor(new Color(255,0,0));
		g.fillRect(x1-10,y1-10,50,10);
		int [] x1Points = {x1-2,x1+5,x1+25,x1+32};
		int [] y1Points = {y1-10,y1-20,y1-20,y1-10};
		g.fillPolygon(x1Points,y1Points,4);
		
		g.setColor(new Color(0,0,0));
		g.fillOval(x2, y2, 10, 10);
		g.fillOval(x2+20, y2, 10, 10);
		g.setColor(new Color(255,255,0));
		g.fillRect(x2-10,y2-10,50,10);
		int [] x2Points = {x2-2,x2+5,x2+25,x2+32};
		int [] y2Points = {y2-10,y2-20,y2-20,y2-10};
		g.fillPolygon(x2Points,y2Points,4);
		
		g.setColor(new Color(0,0,0));
		g.fillOval(x3, y3, 10, 10);
		g.fillOval(x3+20, y3, 10, 10);
		g.setColor(new Color(30,144,255));
		g.fillRect(x3-10,y3-10,50,10);
		int [] x3Points = {x3-2,x3+5,x3+25,x3+32};
		int [] y3Points = {y3-10,y3-20,y3-20,y3-10};
		g.fillPolygon(x3Points,y3Points,4);
		
		g.setColor(new Color(0,0,0));
		g.fillOval(x4, y4, 10, 10);
		g.fillOval(x4+20, y4, 10, 10);
		g.setColor(new Color(50,205,50));
		g.fillRect(x4-10,y4-10,50,10);
		int [] x4Points = {x4-2,x4+5,x4+25,x4+32};
		int [] y4Points = {y4-10,y4-20,y4-20,y4-10};
		g.fillPolygon(x4Points,y4Points,4);
		JTextField speed1 = new JTextField();
		JTextField speed2 = new JTextField();
		JTextField speed3 = new JTextField();
		JTextField speed4 = new JTextField();
		speed1.setBounds(45,15,50,20);
		speed2.setBounds(145,15,50,20);
		speed3.setBounds(245,15,50,20);
		speed4.setBounds(345,15,50,20);
		this.add(speed1);
		this.add(speed2);
		this.add(speed3);
		this.add(speed4);
		/*
		JButton btn = new JButton(">>");
		btn.setBounds(420,15,50,20);
		this.add(btn);
		btn.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String answer = speed1.getText();
			v1 = Integer.parseInt(answer);
			answer = speed2.getText();
			v2 = Integer.parseInt(answer);
			answer = speed3.getText();
			v3 = Integer.parseInt(answer);
			answer = speed4.getText();
			v4 = Integer.parseInt(answer);
			}
		});*/
		speed1.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER){
				String answer = speed1.getText();
				v1 = Integer.parseInt(answer);
			}}
		});
		speed2.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER){
				String answer = speed2.getText();
				v2 = Integer.parseInt(answer);
			}}
		});
		speed3.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER){
				String answer = speed3.getText();
				v3 = Integer.parseInt(answer);
			}}
		});
		speed4.addKeyListener(new KeyAdapter(){
			public void keyPressed(KeyEvent e) {
			if(e.getKeyChar()==KeyEvent.VK_ENTER){
				String answer = speed4.getText();
				v4 = Integer.parseInt(answer);
			}}
		});
		
		movecar(v1,v2,v3,v4);
		
	}

	private void movecar(int a,int b,int c,int d) {
		x1=x1+v1;
		if(x1>500)
			x1=10;
		x2=x2+v2;
		if(x2>500)
			x2=10;
		x3=x3+v3;
		if(x3>500)
			x3=10;
		x4=x4+v4;
		if(x4>500)
			x4=10;
		
	}
}
