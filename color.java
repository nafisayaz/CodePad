

import java.io.*;
import java.nio.*;
import java.awt.*;  
import javax.swing.*;  
import javax.swing.text.*;

class color
{
	public DefaultStyledDocument doc;
	
	private int findLastNonWordChar (String text, int index) {
		while (--index >= 0) {
			if (String.valueOf(text.charAt(index)).matches("\\W")) {
				break;
			}
		}
		return index;
	}

	private int findFirstNonWordChar (String text, int index) {
		while (index < text.length()) {
			if (String.valueOf(text.charAt(index)).matches("\\W")) {
				break;
			}
			index++;
		}
		return index;
	}
	color () 
	{
		final StyleContext cont = StyleContext.getDefaultStyleContext();
		final AttributeSet attrGreen  = cont.addAttribute( cont.getEmptySet(), StyleConstants.Foreground, Color.GREEN );
		final AttributeSet attrYellow = cont.addAttribute( cont.getEmptySet(), StyleConstants.Foreground, Color.YELLOW);
		final AttributeSet attrBlack  = cont.addAttribute( cont.getEmptySet(), StyleConstants.Foreground, Color.BLACK );

		doc = new DefaultStyledDocument() {
			public void insertString (int offset, String str, AttributeSet a) throws BadLocationException {
				super.insertString(offset, str, a);


				String text = getText(0, getLength());
				int before = findLastNonWordChar(text, offset);
				if (before < 0) before = 0;
				int after = findFirstNonWordChar(text, offset + str.length());
				int wordL = before;
				int wordR = before;
				while (wordR <= after)
				{
					if (wordR == after || String.valueOf(text.charAt(wordR)).matches("\\W")) 
					{
						if (text.substring(wordL, wordR).matches("(\\W)*(class|private|public|protected|static|void|int|char|super|throws)"))
							setCharacterAttributes(wordL, wordR - wordL, attrGreen, false);
				
						else if (text.substring(wordL, wordR).matches("(\\W)*(for|while|if|else|return)"))
							setCharacterAttributes(wordL, wordR - wordL, attrYellow, false);
						
						else
							setCharacterAttributes(wordL, wordR - wordL, attrBlack, false);
						
						wordL = wordR;
					}
					wordR++;
				}
			}

			public void remove (int offs, int len) throws BadLocationException {
				super.remove(offs, len);
				String text = getText(0, getLength());
				int before = findLastNonWordChar(text, offs);

				if (before < 0)
					before = 0;
				int after = findFirstNonWordChar(text, offs);

				if (text.substring(before, after).matches("(\\W)*(class|private|public|protected|void|int|char|super|throws)")) 
					setCharacterAttributes(before, after - before, attrGreen, false);
			
				else if (text.substring(before, after).matches("(\\W)*(for|while|if|else|return)")) 
					setCharacterAttributes(before, after - before, attrYellow, false);
				
				else 
					setCharacterAttributes(before, after - before,attrBlack,false);
			}
		};

	}
}

