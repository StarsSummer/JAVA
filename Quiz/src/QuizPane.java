
import javax.swing.*;
import java.awt.event.*;

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
}

