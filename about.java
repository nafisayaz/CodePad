
import java.awt.*;  
import javax.swing.*;  


class about 
{
	about()
	{
		JFrame frame = new JFrame("About");
		String text = "<html> CodePad+ is a small and lightweight text editor for Linux Desktop.<br> " 
					   +"This application is very useful for Code which supports C++, Java, Python, JavaScript"
					   +" HTML, CSS with autoindent. No need to install Compilers and Interpreters externally in terminal. "
					   +" Once you have to write the code which you prefer it will automatically install to your System permanently "
					   +" the compiler or interpreter  accordinding to your coding laguage."
					   +"<br><br> ...............................Copyright © 5th Nov 2016..............................</html>";
		JLabel label = new JLabel(text);
		label.setSize(500,300);
		frame.add(label);
		frame.setSize(500,500);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}
