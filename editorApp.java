
import java.io.*;
import java.awt.*;  
import javax.swing.*;  
import java.awt.event.*;

import java.util.Vector;

class frame implements ActionListener 
{

	JFrame f;  
	JTextPane TextPane;
	
	JMenu menu;

	JMenuBar menuBar;
	JMenuItem  cut;
	JMenuItem  copy;
	JMenuItem  paste;
	JMenuItem  select;
	JMenuItem  selectAll;
	JMenuItem  save;
	JMenuItem  saveAs;
	JMenuItem  about;
	JMenuItem  languages;
	JMenuItem  fonts;
	JMenuItem  colors;
	JMenuItem  open;
	JMenuItem  close;
	JMenuItem  undo;
	JMenuItem  redo;
	JMenuItem  find;
	JMenuItem  replace;

	Vector<String> Vsave = new Vector<String>();
	int count = 0;

	frame()
	{  

		f=new JFrame();  
		f.setTitle("CodePad+");
		
		color color = new color();

		TextPane=new JTextPane(color.doc);
//		JScrollPane ScrollPane = new JScrollPane(TextPane);
		
		menu = new JMenu();
		
		f.setLayout(null);  
		f.setSize(500,500);  
		f.setVisible(true);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//		f.add(ScrollPane);

		TextPane.setBounds(5,40, 1300, 700);  
		TextPane.setBackground(Color.magenta);  
//		TextPane.setForeground(Color.green);
		Font font = new Font("Consolas",Font.ITALIC| Font.BOLD, 15);
		TextPane.setFont(font);

		

		cut 	    = new JMenuItem("cut");
		copy    	= new JMenuItem("copy");
		paste	    = new JMenuItem("paste");
		select  	= new JMenuItem("select");
		selectAll	= new JMenuItem("selectAll");
		save	    = new JMenuItem("save");
		saveAs	    = new JMenuItem("saveAs");
		about   	= new JMenuItem("about");
		languages   = new JMenuItem("languages");
		colors	    = new JMenuItem("colors");
		fonts		= new JMenuItem("fonts");
		open		= new JMenuItem("open");
		close		= new JMenuItem("close");
		undo		= new JMenuItem("undo");
		redo		= new JMenuItem("redo");
		find		= new JMenuItem("find");
		replace		= new JMenuItem("replace");

		cut.addActionListener(this); 
		copy.addActionListener(this); 
		paste.addActionListener(this); 
		select.addActionListener(this); 
		selectAll.addActionListener(this); 
		save.addActionListener(this);
		saveAs.addActionListener(this);
		about.addActionListener(this);
		languages.addActionListener(this);
		colors.addActionListener(this);
		fonts.addActionListener(this);
		open.addActionListener(this);
		close.addActionListener(this);
		undo.addActionListener(this);
		redo.addActionListener(this);
		find.addActionListener(this);
		replace.addActionListener(this);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setSize(1300,40);
		
		JMenu file    = new JMenu("File");
		JMenu edit	  = new JMenu("Edit");
		JMenu search  = new JMenu("Search");
		JMenu view    = new JMenu("View");
		JMenu tools   = new JMenu("Tools");
		JMenu codeShare   = new JMenu("Code Share");

		JMenu help    = new JMenu("Help");

		file.add(save);
		file.add(saveAs);
		file.add(open);
		file.add(close);
		edit.add(cut);
		edit.add(copy);
		edit.add(paste);
		edit.add(select);
		edit.add(selectAll);
		edit.add(undo);
		edit.add(redo);
		search.add(find);
		search.add(replace);
		view.add(fonts);
		view.add(colors);
		tools.add(languages);	
		help.add(about);


		menuBar.add(file);
		menuBar.add(edit);
		menuBar.add(search);
		menuBar.add(view);
		menuBar.add(tools);
		menuBar.add(codeShare);
		menuBar.add(help);
		
		f.add(TextPane);
		f.add(menuBar);
		
		f.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//		f.pack();	
	}  

	public void actionPerformed(ActionEvent e) 
	{  
		if(e.getSource()==cut)  
			TextPane.cut();  
		
		if(e.getSource()==paste)  
			TextPane.paste();  
		
		if(e.getSource()==copy)  
			TextPane.copy();  
		
		if(e.getSource()==selectAll)  
			TextPane.selectAll();
		
		if(e.getSource()==about)
		{
			about abt = new about();
		}

		if(e.getSource()==replace)
		{
			
			String text = TextPane.getText();
			replace rplce = new replace(text);
			rplce.create();
			System.out.println(" => "+rplce.newText);
	//		TextPane.setText(newText);
		}
		

	//	try
	//	{
			if(e.getSource()==undo)
			{
				if(count < Vsave.size())
				{
					String text = Vsave.get(Vsave.size()-count-1);
					TextPane.setText(text);
					++count;
				}

			}
			if(e.getSource() == redo)
			{
				if(count < Vsave.size())
				{
					String text = Vsave.get(count);
					TextPane.setText(text);
					--count;
				}
			}

			if(e.getSource()==open)
			{
				/*
				   FileReader in = new FileReader("File.txt");
				   char[] buffer = new char[1024];
				   int n = in.read(buffer);
				   String text = new String(buffer, 0, n);
				   in.close();
				//		Open opn = new Open();
				TextPane.setText(text);
				 */
			}

			if(e.getSource()==save)
			{
				/*
				   FileWriter out = new FileWriter("File.txt");
				   out.write(TextPane.getText());
				   out.close();
				 */

				String text = TextPane.getText();
				Vsave.addElement(text);

			}
			//		}
			/*
			   catch(Exception f)
			   {
			   f.printStackTrace();
			   }
			 */




	}  

}

class editor 
{
	public static void main(String...arg) throws IOException
	{  
		frame Editor = new frame();
	}  
}



