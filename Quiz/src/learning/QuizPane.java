package learning;

import javax.swing.*;

import java.awt.event.*;
import java.awt.*;

public class QuizPane extends JFrame{
	int Useranswer,num1,num2;
	public QuizPane(){
		this.setLayout(null);
		num1 = (int)(System.currentTimeMillis()%10);
		num2 = (int)(System.currentTimeMillis()*7%10);
		JButton button_OK = new JButton("OK");
		JButton button_CC = new JButton("Cancel");
		button_OK.setBounds(30, 110, 100, 40); 
		button_CC.setBounds(150, 110, 100, 40); 
		this.add(button_CC);
		this.add(button_OK);
		JLabel question = new JLabel("What is "+num1+" + "+num2+" ?");
		question.setBounds(110,15,200,50);
		question.setFont(new Font(null, Font.BOLD, 20));
		this.add(question);
		JTextField answer = new JTextField();
		answer.setBounds(110,65,135,35);
		this.add(answer);	
		JLabel askimage = new JLabel();
		ImageIcon icon = new ImageIcon("src/asking.jpg");
		Image image = icon.getImage();                        
	    Image smallImage = image.getScaledInstance(60,60,Image.SCALE_FAST);
	    ImageIcon smallicon = new ImageIcon(smallImage);
		askimage.setIcon(smallicon);
	    askimage.setBounds(40,35,40,60);
        askimage.setHorizontalAlignment(0);
		askimage.setIcon(smallicon);
		this.add(askimage);
		button_OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				String inputanswer = answer.getText();
				Useranswer = Integer.parseInt(inputanswer);
				setVisible(false);
				MessagePane();
			}
		});
		button_CC.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				answer.setText(null);
			}
		});
		
	}
	public void MessagePane(){
		JFrame frame = new JFrame();
		frame.setLayout(null);
		JButton button_OK = new JButton("OK");
		button_OK.setBounds(90, 110, 100, 40);
		frame.add(button_OK);
		JLabel message = new JLabel(num1+" + "+num2+" = "+Useranswer+" is "+ (num1+num2==Useranswer));
		message.setBounds(60,30,200,50);
		message.setFont(new Font(null, Font.BOLD, 20));
		frame.add(message);
		button_OK.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
	public static void main(String[] args){
		QuizPane frame = new QuizPane();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300,200);
		frame.setVisible(true);
	}
}



/*
public class QuizPane extends JFrame {
  public static void main(String[] args){
	  int num1,num2,selection,answer;
	  String inputanswer;
	  num1 = (int)(System.currentTimeMillis()%10);
	  num2 = (int)(System.currentTimeMillis()*7%10);
	  inputanswer = JOptionPane.showInputDialog("What is " + num1 + " + " + num2 + " ?");
	  answer = Integer.parseInt(inputanswer);
	  JOptionPane.showMessageDialog(null,num1 + " + " + num2 + " = " + answer + " is " + (num1+num2==answer) );
	  
  }
}*/                        //JOptionPane´úÂë
