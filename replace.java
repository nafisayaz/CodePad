
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


class replace
{
	StringBuffer newText = new StringBuffer();;
	private JFrame frame;
	private JLabel firstLabel;
	private JLabel secondLabel;
	private JTextField first;
	private JTextField second;
	
	String str = new String();
	
	replace(String text)
	{
		this.newText = new StringBuffer(text);
	}
	void create()
	{
		frame = new JFrame("Replace");
		frame.setLayout(new FlowLayout());	
		firstLabel = new JLabel("Search: ");
		firstLabel.setFont(new Font("Courier New", Font.BOLD, 15) );
		frame.add(firstLabel);
		
		first = new JTextField(10);
		frame.add(first);
		
		secondLabel = new JLabel("Replace with: ");
		secondLabel.setFont(new Font("Courier New", Font.BOLD, 15) );

		frame.add(secondLabel);
		
		second = new JTextField(10);
		frame.add(second);

		Button button = new Button("Replace");
		frame.add(button);
		
		button.addActionListener( (ActionEvent e )-> {
				
				String firstPattern = first.getText();
				String secondPattern = second.getText();

				Pattern p = Pattern.compile(firstPattern);
				Matcher m = p.matcher(this.newText);
	
				System.out.println(m.find() );

				this.newText = new StringBuffer(m.replaceAll(secondPattern));
				System.out.println(" ->> "+this.newText);


		});

		frame.pack();
		frame.setVisible(true);
	}
}

