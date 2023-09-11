package Chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UserDetails extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	JTextField textField1;
	JTextField textField2;
	JLabel label1;
	JLabel label2;
	JButton button;
	public UserDetails()
	{
		super("Set Names");
		setLayout(new FlowLayout());
		label1 = new JLabel("Enter Player 1 Name : ");
		add(label1);
		textField1 = new JTextField(10);
		add(textField1);
		label2 = new JLabel("Enter Player 2 Name : ");
		add(label2);
		textField2 = new JTextField(10);
		add(textField2);
		button = new JButton("OK");
		add(button);
		button.setFocusPainted(false);
		button.addActionListener(this);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if (textField1.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Please enter name for Player 1");
		
		else if(textField2.getText().equals(""))
			JOptionPane.showMessageDialog(this, "Please enter name for Player 2");
		
		else if(textField2.getText().equals(textField1.getText()))
		{
			JOptionPane.showMessageDialog(this, "Please enter different names for each players");
			textField1.setText("");
			textField2.setText("");
		}
		else
		{
			JOptionPane.showMessageDialog(this, textField1.getText() + " Gets Green");
			JOptionPane.showMessageDialog(this, textField2.getText() + " Gets Red");
			this.setVisible(false);
		}
	}
}

class PawnSelect extends JFrame implements ActionListener {
    private static final long serialVersionUID = 1L;
    JLabel pawn = new JLabel("");
    JRadioButton elephant;
    JRadioButton horse;
    JRadioButton bishop;
    JRadioButton queen;
    ButtonGroup bg;
    JButton submit;

    public PawnSelect() {
        super("Pawn Selection");
        setLayout(new FlowLayout());
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        elephant = new JRadioButton("Elephant", false);
        horse = new JRadioButton("Horse", false);
        bishop = new JRadioButton("Bishop", false);
        queen = new JRadioButton("Queen", false);
        bg = new ButtonGroup();
        bg.add(elephant);
        bg.add(horse);
        bg.add(bishop);
        bg.add(queen);
        add(elephant);
        add(horse);
        add(bishop);
        add(queen);
        elephant.setFocusPainted(false);
        horse.setFocusPainted(false);
        bishop.setFocusPainted(false);
        queen.setFocusPainted(false);

        submit = new JButton("Done");
        add(submit);
        submit.addActionListener(this);
        submit.setFocusPainted(false);
    }

    public void actionPerformed(ActionEvent ae) {
        if (elephant.isSelected()) {
            pawn.setText(elephant.getText());
        } else if (horse.isSelected()) {
            pawn.setText(horse.getText());
        } else if (bishop.isSelected()) {
            pawn.setText(bishop.getText());
        } else if (queen.isSelected()) {
            pawn.setText(queen.getText());
        } else {
            JOptionPane.showMessageDialog(this, "Select your choice");
            return;
        }

   

        this.setVisible(false);
    }
}


class ChessGame extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	int i;
	String player1;
	String player2;
	boolean colorCondition = true;
	JButton[] blocks = new JButton[64];
	boolean chessCondition = true;
	String globalText;
	int greenPawn[] = new int[8];
	int redPawn[] = new int[8];
	boolean textColorChoice = true;
	int count;
	int redKingCheckCount = 0;
	int greenKingCheckCount = 0;
	
	
	public ChessGame(String player1, String player2)
	{
		super("Chess game");
		this.player1 = player1;
		this.player2 = player2;
		setLayout(new GridLayout(8, 8));
		
		//button setting and adding
		for(i = 1; i < 65; i ++)
		{
			JButton button = new JButton("");
			blocks[i - 1] = button;
			blocks[i - 1].addActionListener(this);
			if(colorCondition == true)
			{
				colorCondition = false;
				if(i%8 == 0)
				{
					colorCondition = true;
				}
				blocks[i - 1].setBackground(Color.white);
			}
			else
			{
				colorCondition = true;
				if(i%8 == 0)
				{
					colorCondition = false;
				}
				blocks[i - 1].setBackground(Color.black);
			}
			button.setFocusPainted(false);
			add(button);
		}
		
		for(i = 8; i < 16; i ++)
		{
			blocks[i].setText("Pawn");
			blocks[i].setForeground(Color.red);
		}
		
		for(i = 48; i < 56; i ++)
		{
			blocks[i].setText("Pawn");
			blocks[i].setForeground(Color.green);
		}
		
		blocks[0].setText("Elephant");
		blocks[0].setFocusPainted(false);
		blocks[0].setForeground(Color.red);
		
		blocks[7].setText("Elephant");
		blocks[7].setFocusPainted(false);
		blocks[7].setForeground(Color.red);
		
		blocks[56].setText("Elephant");
		blocks[56].setFocusPainted(false);
		blocks[56].setForeground(Color.green);
		
		blocks[63].setText("Elephant");
		blocks[63].setFocusPainted(false);
		blocks[63].setForeground(Color.green);

		blocks[1].setText("Horse");
		blocks[1].setFocusPainted(false);
		blocks[1].setForeground(Color.red);
		
		blocks[6].setText("Horse");
		blocks[6].setFocusPainted(false);
		blocks[6].setForeground(Color.red);
		
		blocks[57].setText("Horse");
		blocks[57].setFocusPainted(false);
		blocks[57].setForeground(Color.green);
		
		blocks[62].setText("Horse");
		blocks[62].setFocusPainted(false);
		blocks[62].setForeground(Color.green);
		
		blocks[2].setText("Bishop");
		blocks[2].setFocusPainted(false);
		blocks[2].setForeground(Color.red);
		
		blocks[5].setText("Bishop");
		blocks[5].setFocusPainted(false);
		blocks[5].setForeground(Color.red);
		
		blocks[58].setText("Bishop");
		blocks[58].setFocusPainted(false);
		blocks[58].setForeground(Color.green);
		
		blocks[61].setText("Bishop");
		blocks[61].setFocusPainted(false);
		blocks[61].setForeground(Color.green);
		
		blocks[3].setText("Queen");
		blocks[3].setFocusPainted(false);
		blocks[3].setForeground(Color.red);
		
		blocks[4].setText("King");
		blocks[4].setFocusPainted(false);
		blocks[4].setForeground(Color.red);
		
		blocks[59].setText("Queen");
		blocks[59].setFocusPainted(false);
		blocks[59].setForeground(Color.green);
		
		blocks[60].setText("King");
		blocks[60].setFocusPainted(false);
		blocks[60].setForeground(Color.green);

	}
	
	public void resetTotalGame()
	{
		setWhiteBlack();
		chessCondition = true;
		colorCondition = true;
		globalText = "";
		textColorChoice = true;
		for(i = 0; i < 64; i ++)
		{
			blocks[i].setText("");
		}
		
		for(i = 8; i < 16; i ++)
		{
			blocks[i].setText("Pawn");
			blocks[i].setForeground(Color.red);
		}
		
		for(i = 48; i < 56; i ++)
		{
			blocks[i].setText("Pawn");
			blocks[i].setForeground(Color.green);
		}
		
		blocks[0].setText("Elephant");
		blocks[0].setFocusPainted(false);
		blocks[0].setForeground(Color.red);
		
		blocks[7].setText("Elephant");
		blocks[7].setFocusPainted(false);
		blocks[7].setForeground(Color.red);
		
		blocks[56].setText("Elephant");
		blocks[56].setFocusPainted(false);
		blocks[56].setForeground(Color.green);
		
		blocks[63].setText("Elephant");
		blocks[63].setFocusPainted(false);
		blocks[63].setForeground(Color.green);

		blocks[1].setText("Horse");
		blocks[1].setFocusPainted(false);
		blocks[1].setForeground(Color.red);
		
		blocks[6].setText("Horse");
		blocks[6].setFocusPainted(false);
		blocks[6].setForeground(Color.red);
		
		blocks[57].setText("Horse");
		blocks[57].setFocusPainted(false);
		blocks[57].setForeground(Color.green);
		
		blocks[62].setText("Horse");
		blocks[62].setFocusPainted(false);
		blocks[62].setForeground(Color.green);
		
		blocks[2].setText("Bishop");
		blocks[2].setFocusPainted(false);
		blocks[2].setForeground(Color.red);
		
		blocks[5].setText("Bishop");
		blocks[5].setFocusPainted(false);
		blocks[5].setForeground(Color.red);
		
		blocks[58].setText("Bishop");
		blocks[58].setFocusPainted(false);
		blocks[58].setForeground(Color.green);
		
		blocks[61].setText("Bishop");
		blocks[61].setFocusPainted(false);
		blocks[61].setForeground(Color.green);
		
		blocks[3].setText("Queen");
		blocks[3].setFocusPainted(false);
		blocks[3].setForeground(Color.red);
		
		blocks[4].setText("King");
		blocks[4].setFocusPainted(false);
		blocks[4].setForeground(Color.red);
		
		blocks[59].setText("Queen");
		blocks[59].setFocusPainted(false);
		blocks[59].setForeground(Color.green);
		
		blocks[60].setText("King");
		blocks[60].setFocusPainted(false);
		blocks[60].setForeground(Color.green);
	}
	
	public void setWhiteBlack()
	{
		colorCondition = true;
		for(i = 1; i < 65; i ++)
		{
			if(colorCondition == true)
			{
				colorCondition = false;
				if(i%8 == 0)
				{
					colorCondition = true;
				}
				blocks[i - 1].setBackground(Color.white);
			}
			else
			{
				colorCondition = true;
				if(i%8 == 0)
				{
					colorCondition = false;
				}
				blocks[i - 1].setBackground(Color.black);
			}
		}
	}
	
	public void greenPawn(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		
		//last row
		if((index == 0) || (index == 1) || (index == 2) || (index == 3) || (index == 4) || (index == 5)
				|| (index == 6) || (index == 7))
		{
			textColorChoice = true;
			chessCondition = true;
			return;
		}
		
		if((index == 48) || (index == 49) || (index == 50) || (index == 51) || (index == 52) || (index == 53)
				|| (index == 54) || (index == 55))
		{
			//left Row
			if((index == 48) || (index == 40) || (index == 32) || (index == 24) || (index == 16) || (index == 8))
			{
				JButton button5 = blocks[index - 7];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.red)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
			}
			
			//right row
			else if((index == 15) || (index == 23) || (index == 31) || (index == 39) || (index == 47) || (index == 55))
			{
				JButton button5 = blocks[index - 9];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.red)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
			}
			
			//center
			else
			{
				JButton button5 = blocks[index - 7];
				JButton button6 = blocks[index - 9];
				String c = button5.getText();
				String c1 = button6.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.red)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
					chessCondition = true;
				}
				
				if((!(c1.equals(""))) && (button6.getForeground().equals(Color.red)))
				{
					button6.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
					chessCondition = true;
				}
				
			}
			
			//No enemy
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			if((index - 16) > 0)
			{
				if(blocks[index - 16].getText().equals(""))
				{
					
					if(blocks[index - 8].getText().equals(""))
					{
						blocks[index - 16].setBackground(Color.yellow);
						globalText = button.getText();
						chessCondition = true;
						textColorChoice = true;
					}
				}
			}
		}	
		else
		{
			//left Row
			if((index == 48) || (index == 40) || (index == 32) || (index == 24) || (index == 16) || (index == 8))
			{
				JButton button5 = blocks[index - 7];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.red)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
			}
			
			//right row
			else if((index == 15) || (index == 23) || (index == 31) || (index == 39) || (index == 47) || (index == 55))
			{
				JButton button5 = blocks[index - 9];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.red)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
			}
			
			//center
			else
			{
				JButton button5 = blocks[index - 7];
				JButton button6 = blocks[index - 9];
				String c = button5.getText();
				String c1 = button6.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.red)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
					chessCondition = true;
				}
				
				if((!(c1.equals(""))) && (button6.getForeground().equals(Color.red)))
				{
					button6.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
					chessCondition = true;
				}
				
			}
			
			//No enemy
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
		}
		chessCondition = true;
	}
	

	public void redPawn(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		
		//last row
		if((index == 56) || (index == 57) || (index == 58) || (index == 59) || (index == 60) || (index == 61)
				|| (index == 62) || (index == 63))
		{
			textColorChoice = false;
			chessCondition = false;
			return;
		}
		if((index == 8) || (index == 9) || (index == 10) || (index == 11) || (index == 12) || (index == 13)
				|| (index == 14) || (index == 15))
		{
			//Left Row
			if((index == 8) || (index == 16) || (index == 24) || (index == 32) || (index == 40) || (index == 48))
			{
				JButton button5 = blocks[index + 9];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.green)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}
			}
			
			//Right Row
			else if((index == 15) || (index == 23) || (index == 31) || (index == 39) || (index == 47) || (index == 55))
			{
				JButton button5 = blocks[index + 7];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.green)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}
			}
			
			//Center
			else
			{
				JButton button5 = blocks[index + 7];
				JButton button6 = blocks[index + 9];
				String c = button5.getText();
				String c1 = button6.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.green)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}
				
				if((!(c1.equals(""))) && (button6.getForeground().equals(Color.green)))
				{
					button6.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}	
			}
			
			//No enemy
			
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			if((index + 16) < 64)
			{
				if(blocks[index + 16].getText().equals(""))
				{
					if(blocks[index + 8].getText().equals(""))
					{
						blocks[index + 16].setBackground(Color.yellow);
						globalText = button.getText();
						chessCondition = false;
						textColorChoice = false;
					}
				}
			}
		}
		else
		{
			//Left Row
			if((index == 8) || (index == 16) || (index == 24) || (index == 32) || (index == 40) || (index == 48))
			{
				JButton button5 = blocks[index + 9];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.green)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}
			}
			
			//Right Row
			else if((index == 15) || (index == 23) || (index == 31) || (index == 39) || (index == 47) || (index == 55))
			{
				JButton button5 = blocks[index + 7];
				String c = button5.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.green)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}
			}
			
			//Center
			else
			{
				JButton button5 = blocks[index + 7];
				JButton button6 = blocks[index + 9];
				String c = button5.getText();
				String c1 = button6.getText();
				
				if((!(c.equals(""))) && (button5.getForeground().equals(Color.green)))
				{
					button5.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}
				
				if((!(c1.equals(""))) && (button6.getForeground().equals(Color.green)))
				{
					button6.setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
					chessCondition = false;
				}	
			}
			
			//No enemy
			
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
		}
		chessCondition = false;
		
	}

	public void greenElephant(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		chessCondition = true;
		int i;
		
		//All Corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top corner
			if(index == 0)
			{
				for(i = 8; i < 57; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 1; i < 8; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			//right top corner
			else if(index == 7)
			{
				for(i = 6; i > -1; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 15; i < 64; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			//bottom left corner
			else if(index == 56)
			{
				for(i = 48; i > -1; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 57; i < 64; i += 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
				
			}
			
			//bottom right corner
			else if(index == 63)
			{
				for(i = 62; i > 55; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 55; i > 6 ; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
		}
		
		//top row   
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
			
			//no enemy
			for(i = index - 1; i > -1; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			globalText = button.getText();
			chessCondition = true;
			textColorChoice = true;
		}
		
		//bottom row  
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
			for(i = index - 1; i > 55; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 64; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			globalText = button.getText();
			chessCondition = true;
			textColorChoice = true;
		}
		
		//left row 
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			for(i = index - 8; i > -1; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < index + 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 57; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			globalText = button.getText();
			chessCondition = true;
			textColorChoice = true;
		}
		
		//right row 
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			//up
			for(i = index - 8; i > 6; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			
			for(i = index - 1; i > index - 8; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//down
			for(i = index + 8; i < 64; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			globalText = button.getText();
			chessCondition = true;
			textColorChoice = true;
		}
		
		//center   
		else
		{
			//top
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//bottom
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			if((index == 9) || (index == 10) || (index == 11) || (index == 12) || (index == 13)
					|| (index == 14))
			{
				//left
				for(i = index - 1; i > 7; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 16; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 17) || (index == 18) || (index == 19) || (index == 20) || (index == 21)
					|| (index == 22))
			{
				//left
				for(i = index - 1; i > 15; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 24; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 25) || (index == 26) || (index == 27) || (index == 28) || (index == 29)
					|| (index == 30))
			{
				//left
				for(i = index - 1; i > 23; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 32; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 33) || (index == 34) || (index == 35) || (index == 36) || (index == 37)
					|| (index == 38))
			{
				//left
				for(i = index - 1; i > 31; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 40; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 41) || (index == 42) || (index == 43) || (index == 44) || (index == 45)
					|| (index == 46))
			{
				//left
				for(i = index - 1; i > 39; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 48; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 49) || (index == 50) || (index == 51) || (index == 52) || (index == 53)
					|| (index == 54))
			{
				//left
				for(i = index - 1; i > 47; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 56; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			globalText = button.getText();
			chessCondition = true;
			textColorChoice = true;
		}
		
	}
	
	public void redElephant(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		chessCondition = false;
		int i;
		
		//All corners 
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top corner
			if(index == 0)
			{
				for(i = 8; i < 57; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 1; i < 8; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			//right top corner
			else if(index == 7)
			{
				for(i = 6; i > -1; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 15; i < 64; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			//bottom left corner
			else if(index == 56)
			{
				for(i = 48; i > -1; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 57; i < 64; i += 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
				
			}
			
			//bottom right corner
			else if(index == 63)
			{
				for(i = 62; i > 55; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 55; i > 6 ; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
		}
		
		//top row   
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
			
			//no enemy
			for(i = index - 1; i > -1; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			globalText = button.getText();
			chessCondition = false;
			textColorChoice = false;
		}
		
		//bottom row  
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
			for(i = index - 1; i > 55; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 64; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			globalText = button.getText();
			chessCondition = false;
			textColorChoice = false;
		}
		
		//left row 
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			for(i = index - 8; i > -1; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < index + 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 57; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			globalText = button.getText();
			chessCondition = false;
			textColorChoice = false;
		}
		
		//right row 
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			//up
			for(i = index - 8; i > 6; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			
			for(i = index - 1; i > index - 8; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//down
			for(i = index + 8; i < 64; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			globalText = button.getText();
			chessCondition = false;
			textColorChoice = false;
		}
		
		//center     
		else
		{
			//top
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//bottom
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			if((index == 9) || (index == 10) || (index == 11) || (index == 12) || (index == 13)
					|| (index == 14))
			{
				//left
				for(i = index - 1; i > 7; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 16; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 17) || (index == 18) || (index == 19) || (index == 20) || (index == 21)
					|| (index == 22))
			{
				//left
				for(i = index - 1; i > 15; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 24; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 25) || (index == 26) || (index == 27) || (index == 28) || (index == 29)
					|| (index == 30))
			{
				//left
				for(i = index - 1; i > 23; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 32; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 33) || (index == 34) || (index == 35) || (index == 36) || (index == 37)
					|| (index == 38))
			{
				//left
				for(i = index - 1; i > 31; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 40; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 41) || (index == 42) || (index == 43) || (index == 44) || (index == 45)
					|| (index == 46))
			{
				//left
				for(i = index - 1; i > 39; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 48; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 49) || (index == 50) || (index == 51) || (index == 52) || (index == 53)
					|| (index == 54))
			{
				//left
				for(i = index - 1; i > 47; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 56; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			globalText = button.getText();
			chessCondition = false;
			textColorChoice = false;
		}
	}

	public void greenHorse(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		chessCondition = true;
		globalText = button.getText();
		textColorChoice = true;
		
		//corners 
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top corner    10 17
			if(index == 0)
			{
				//first
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			
			//right top corner
			else if(index == 7)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			
			//bottom left corner  
			else if(index == 56)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			
			//bottom right corner
			else if(index == 63)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//top row
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4) || (index == 5) || (index == 6))
		{
			if(blocks[index + 15].getText().equals(""))
			{
				blocks[index + 15].setBackground(Color.yellow);
			}
			if(!(blocks[index + 15].getText().equals("")))
			{
				if(blocks[index + 15].getForeground().equals(Color.red))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index + 17].getText().equals(""))
			{
				blocks[index + 17].setBackground(Color.yellow);
			}
			if(!(blocks[index + 17].getText().equals("")))
			{
				if(blocks[index + 17].getForeground().equals(Color.red))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
			}
			
			//third
			if(index == 1)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 6)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//bottom row
		else if((index == 57) || (index == 58) || (index == 59) ||
				(index == 60) || (index == 61) || (index == 62))
		{
			if(blocks[index - 15].getText().equals(""))
			{
				blocks[index - 15].setBackground(Color.yellow);
			}
			if(!(blocks[index - 15].getText().equals("")))
			{
				if(blocks[index - 15].getForeground().equals(Color.red))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index - 17].getText().equals(""))
			{
				blocks[index - 17].setBackground(Color.yellow);
			}
			if(!(blocks[index - 17].getText().equals("")))
			{
				if(blocks[index - 17].getForeground().equals(Color.red))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
			}
			//third
			if(index == 62)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 57)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//left row
		else if((index == 8) || (index == 16) || (index == 24) ||
				(index == 32) || (index == 40) || (index == 48))
		{
			if(blocks[index - 6].getText().equals(""))
			{
				blocks[index - 6].setBackground(Color.yellow);
			}
			if(!(blocks[index - 6].getText().equals("")))
			{
				if(blocks[index - 6].getForeground().equals(Color.red))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index + 10].getText().equals(""))
			{
				blocks[index + 10].setBackground(Color.yellow);
			}
			if(!(blocks[index + 10].getText().equals("")))
			{
				if(blocks[index + 10].getForeground().equals(Color.red))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
			}
			
			//third
			if(index == 8)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 48)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) ||
				(index == 39) || (index == 47) || (index == 55))
		{
			if(blocks[index - 10].getText().equals(""))
			{
				blocks[index - 10].setBackground(Color.yellow);
			}
			if(!(blocks[index - 10].getText().equals("")))
			{
				if(blocks[index - 10].getForeground().equals(Color.red))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index + 6].getText().equals(""))
			{
				blocks[index + 6].setBackground(Color.yellow);
			}
			if(!(blocks[index + 6].getText().equals("")))
			{
				if(blocks[index + 6].getForeground().equals(Color.red))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
			}
			
			//third
			if(index == 55)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 15)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 9)
		{
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 14)
		{
			if((index + 6) < 63)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 49)
		{
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 54)
		{
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 6) < 63)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}

		}
		else if((index == 17) || (index == 25) || (index == 33) || (index == 41))
		{
			//negative
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			//positive
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if((index == 22) || (index == 30) || (index == 38) || (index == 46))
		{
			//negative
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			//positive
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 6) < 64)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
		}
		else
		{
			//negative
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.red))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.red))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.red))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.red))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			//positive
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.red))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.red))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.red))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
			if((index + 6) < 64)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.red))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			
		}
		
	}
	
	public void redHorse(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		chessCondition = false;
		globalText = button.getText();
		textColorChoice = false;
		
		//corners 
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top corner 
			if(index == 0)
			{
				//first
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			
			//right top corner
			else if(index == 7)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			
			//bottom left corner  
			else if(index == 56)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			
			//bottom right corner
			else if(index == 63)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
				
				//second
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//top row
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4) || (index == 5) || (index == 6))
		{
			if(blocks[index + 15].getText().equals(""))
			{
				blocks[index + 15].setBackground(Color.yellow);
			}
			if(!(blocks[index + 15].getText().equals("")))
			{
				if(blocks[index + 15].getForeground().equals(Color.green))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index + 17].getText().equals(""))
			{
				blocks[index + 17].setBackground(Color.yellow);
			}
			if(!(blocks[index + 17].getText().equals("")))
			{
				if(blocks[index + 17].getForeground().equals(Color.green))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
			}
			
			//third
			if(index == 1)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 6)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//bottom row
		else if((index == 57) || (index == 58) || (index == 59) ||
				(index == 60) || (index == 61) || (index == 62))
		{
			if(blocks[index - 15].getText().equals(""))
			{
				blocks[index - 15].setBackground(Color.yellow);
			}
			if(!(blocks[index - 15].getText().equals("")))
			{
				if(blocks[index - 15].getForeground().equals(Color.green))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index - 17].getText().equals(""))
			{
				blocks[index - 17].setBackground(Color.yellow);
			}
			if(!(blocks[index - 17].getText().equals("")))
			{
				if(blocks[index - 17].getForeground().equals(Color.green))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
			}
			//third
			if(index == 62)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 57)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//left row
		else if((index == 8) || (index == 16) || (index == 24) ||
				(index == 32) || (index == 40) || (index == 48))
		{
			if(blocks[index - 6].getText().equals(""))
			{
				blocks[index - 6].setBackground(Color.yellow);
			}
			if(!(blocks[index - 6].getText().equals("")))
			{
				if(blocks[index - 6].getForeground().equals(Color.green))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index + 10].getText().equals(""))
			{
				blocks[index + 10].setBackground(Color.yellow);
			}
			if(!(blocks[index + 10].getText().equals("")))
			{
				if(blocks[index + 10].getForeground().equals(Color.green))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
			}
			
			//third
			if(index == 8)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 48)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) ||
				(index == 39) || (index == 47) || (index == 55))
		{
			if(blocks[index - 10].getText().equals(""))
			{
				blocks[index - 10].setBackground(Color.yellow);
			}
			if(!(blocks[index - 10].getText().equals("")))
			{
				if(blocks[index - 10].getForeground().equals(Color.green))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
			}
			
			//second
			if(blocks[index + 6].getText().equals(""))
			{
				blocks[index + 6].setBackground(Color.yellow);
			}
			if(!(blocks[index + 6].getText().equals("")))
			{
				if(blocks[index + 6].getForeground().equals(Color.green))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
			}
			
			//third
			if(index == 55)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			else if(index == 15)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			else
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 9)
		{
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 14)
		{
			if((index + 6) < 63)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 49)
		{
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if(index == 54)
		{
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 6) < 63)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}

		}
		else if((index == 17) || (index == 25) || (index == 33) || (index == 41))
		{
			//negative
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			//positive
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
		}
		
		else if((index == 22) || (index == 30) || (index == 38) || (index == 46))
		{
			//negative
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			//positive
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 6) < 64)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
		}
		else
		{
			//negative
			if((index - 17) > -1)
			{
				if(blocks[index - 17].getText().equals(""))
				{
					blocks[index - 17].setBackground(Color.yellow);
				}
				if(!(blocks[index - 17].getText().equals("")))
				{
					if(blocks[index - 17].getForeground().equals(Color.green))
					{
						blocks[index - 17].setBackground(Color.yellow);
					}
				}
			}
			if((index - 15) > -1)
			{
				if(blocks[index - 15].getText().equals(""))
				{
					blocks[index - 15].setBackground(Color.yellow);
				}
				if(!(blocks[index - 15].getText().equals("")))
				{
					if(blocks[index - 15].getForeground().equals(Color.green))
					{
						blocks[index - 15].setBackground(Color.yellow);
					}
				}
			}
			if((index - 10) > -1)
			{
				if(blocks[index - 10].getText().equals(""))
				{
					blocks[index - 10].setBackground(Color.yellow);
				}
				if(!(blocks[index - 10].getText().equals("")))
				{
					if(blocks[index - 10].getForeground().equals(Color.green))
					{
						blocks[index - 10].setBackground(Color.yellow);
					}
				}
			}
			if((index - 6) > -1)
			{
				if(blocks[index - 6].getText().equals(""))
				{
					blocks[index - 6].setBackground(Color.yellow);
				}
				if(!(blocks[index - 6].getText().equals("")))
				{
					if(blocks[index - 6].getForeground().equals(Color.green))
					{
						blocks[index - 6].setBackground(Color.yellow);
					}
				}
			}
			//positive
			if((index + 17) < 64)
			{
				if(blocks[index + 17].getText().equals(""))
				{
					blocks[index + 17].setBackground(Color.yellow);
				}
				if(!(blocks[index + 17].getText().equals("")))
				{
					if(blocks[index + 17].getForeground().equals(Color.green))
					{
						blocks[index + 17].setBackground(Color.yellow);
					}
				}
			}
			if((index + 15) < 64)
			{
				if(blocks[index + 15].getText().equals(""))
				{
					blocks[index + 15].setBackground(Color.yellow);
				}
				if(!(blocks[index + 15].getText().equals("")))
				{
					if(blocks[index + 15].getForeground().equals(Color.green))
					{
						blocks[index + 15].setBackground(Color.yellow);
					}
				}
			}
			if((index + 10) < 64)
			{
				if(blocks[index + 10].getText().equals(""))
				{
					blocks[index + 10].setBackground(Color.yellow);
				}
				if(!(blocks[index + 10].getText().equals("")))
				{
					if(blocks[index + 10].getForeground().equals(Color.green))
					{
						blocks[index + 10].setBackground(Color.yellow);
					}
				}
			}
			if((index + 6) < 64)
			{
				if(blocks[index + 6].getText().equals(""))
				{
					blocks[index + 6].setBackground(Color.yellow);
				}
				if(!(blocks[index + 6].getText().equals("")))
				{
					if(blocks[index + 6].getForeground().equals(Color.green))
					{
						blocks[index + 6].setBackground(Color.yellow);
					}
				}
			}
		}
	}
	
	//write red
	public void greenBishop(int index)
	{
		JButton button = blocks[index];
		Color previousColor = button.getBackground();
		button.setBackground(Color.blue);
		chessCondition = true;
		globalText = button.getText();
		textColorChoice = true;
		int i;
		int j;
		
		//corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top
			if(index == 0)
			{
				for(i = 9; i < 64; i += 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			//right top   
			else if(index == 7)
			{
				for(i = 14; i < 57; i += 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			//down left
			else if(index == 56)
			{
				for(i = 49; i > 6; i -= 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			//down right
			else if(index == 63)
			{
				for(i = 54; i > -1; i -= 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
		}
		
		//top row
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
			//black
			if((index == 1) || (index == 3) || (index == 5))
			{
				
				//left side
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;

				}
				
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
				
			}
			
			//white
			else if((index == 2) || (index == 4) || (index == 6))
			{
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
			
			globalText = button.getText();
			chessCondition = true;
			textColorChoice = true;
		}

		//bottom row
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
			//white
			if((index == 57) || (index == 59) || (index == 61))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				

				j = index - 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
				
			}
			
			//black
			else if((index == 58) || (index == 60) || (index == 62))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}

				
				j = index - 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
			}

		}
		
		//left row
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			//black
			if((index == 8) || (index == 24) || (index == 40))
			{
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
			}
			
			//white
			else if((index == 16) || (index == 32) || (index == 48))
			{
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			//white
			if((index == 15) || (index == 31) || (index == 47))
			{
				
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
			
			//black
			else if((index == 23) || (index == 39) || (index == 55))
			{
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
		}
		
		//center
		else
		{
			//white   9
			if(previousColor.equals(Color.white))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
			
			//black   10
			if(previousColor.equals(Color.black))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
		}
		globalText = button.getText();
		textColorChoice = true;
	}
	
	public void redBishop(int index)
	{
		JButton button = blocks[index];
		Color previousColor = button.getBackground();
		button.setBackground(Color.blue);
		chessCondition = false;
		int i;
		int j;
		
		//corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top
			if(index == 0)
			{
				for(i = 9; i < 64; i += 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			//right top   
			else if(index == 7)
			{
				for(i = 14; i < 57; i += 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			//down left
			else if(index == 56)
			{
				for(i = 49; i > 6; i -= 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			//down right
			else if(index == 63)
			{
				for(i = 54; i > -1; i -= 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
		}
		
		//top row
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
			//black
			if((index == 1) || (index == 3) || (index == 5))
			{
				
				//left side
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;

				}
				
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
				
			}
			
			//white
			else if((index == 2) || (index == 4) || (index == 6))
			{
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
			
			globalText = button.getText();
			chessCondition = false;
			textColorChoice = false;
		}

		//bottom row
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
			//white
			if((index == 57) || (index == 59) || (index == 61))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				

				j = index - 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
				
			}
			
			//black
			else if((index == 58) || (index == 60) || (index == 62))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}

				
				j = index - 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
			}

		}
		
		//left row
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			//black
			if((index == 8) || (index == 24) || (index == 40))
			{
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
			}
			
			//white
			else if((index == 16) || (index == 32) || (index == 48))
			{
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			//white
			if((index == 15) || (index == 31) || (index == 47))
			{
				
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
			
			//black
			else if((index == 23) || (index == 39) || (index == 55))
			{
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
		}
		
		//center
		else
		{
			//white   9
			if(previousColor.equals(Color.white))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
			
			//black   10
			if(previousColor.equals(Color.black))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
		}
		globalText = button.getText();
		textColorChoice = false;
	}
	
	public void greenQueen(int index)
	{
		JButton button = blocks[index];
		Color previousColor = button.getBackground();
		button.setBackground(Color.blue);
		chessCondition = true;
		globalText = button.getText();
		textColorChoice = true;
		int j;
		
		//corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top corner
			if(index == 0)
			{
				for(i = 9; i < 64; i += 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 8; i < 57; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 1; i < 8; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
			
			//right top corner
			else if(index == 7)
			{
				for(i = 14; i < 57; i += 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				for(i = 6; i > -1; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 15; i < 64; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
			
			//left down corner
			else if(index == 56)
			{
				for(i = 49; i > 6; i -= 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				for(i = 48; i > -1; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 57; i < 64; i += 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
			
			//right down corner
			else if(index == 63)
			{
				for(i = 54; i > -1; i -= 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.red))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				for(i = 62; i > 55; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 55; i > 6 ; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
		}
		//top row
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
			
			for(i = index - 1; i > -1; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			//black
			if((index == 1) || (index == 3) || (index == 5))
			{
				
				//left side
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;

				}
				
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
				
			}
			
			//white
			else if((index == 2) || (index == 4) || (index == 6))
			{
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
		}
		
		//bottom row
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
			for(i = index - 1; i > 55; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 64; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			//white
			if((index == 57) || (index == 59) || (index == 61))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				

				j = index - 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
				
			}
			
			//black
			else if((index == 58) || (index == 60) || (index == 62))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}

				
				j = index - 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
			}
		}
		
		//left row
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			for(i = index - 8; i > -1; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < index + 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 57; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			if((index == 8) || (index == 24) || (index == 40))
			{
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
			}
			
			//white
			else if((index == 16) || (index == 32) || (index == 48))
			{
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			//up
			for(i = index - 8; i > 6; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			
			for(i = index - 1; i > index - 8; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//down
			for(i = index + 8; i < 64; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			if((index == 15) || (index == 31) || (index == 47))
			{
				
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
			
			//black
			else if((index == 23) || (index == 39) || (index == 55))
			{
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
		}
		
		//center
		else
		{
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//bottom
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.red)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			if((index == 9) || (index == 10) || (index == 11) || (index == 12) || (index == 13)
					|| (index == 14))
			{
				//left
				for(i = index - 1; i > 7; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 16; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 17) || (index == 18) || (index == 19) || (index == 20) || (index == 21)
					|| (index == 22))
			{
				//left
				for(i = index - 1; i > 15; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 24; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 25) || (index == 26) || (index == 27) || (index == 28) || (index == 29)
					|| (index == 30))
			{
				//left
				for(i = index - 1; i > 23; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 32; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 33) || (index == 34) || (index == 35) || (index == 36) || (index == 37)
					|| (index == 38))
			{
				//left
				for(i = index - 1; i > 31; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 40; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 41) || (index == 42) || (index == 43) || (index == 44) || (index == 45)
					|| (index == 46))
			{
				//left
				for(i = index - 1; i > 39; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 48; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 49) || (index == 50) || (index == 51) || (index == 52) || (index == 53)
					|| (index == 54))
			{
				//left
				for(i = index - 1; i > 47; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 56; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.red)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			if(previousColor.equals(Color.white))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
			
			//black   10
			if(previousColor.equals(Color.black))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.red))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
		}
		
	}
	
	public void redQueen(int index)
	{
		JButton button = blocks[index];
		Color previousColor = button.getBackground();
		button.setBackground(Color.blue);
		chessCondition = false;
		globalText = button.getText();
		textColorChoice = false;
		int j;
		
		//corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top corner
			if(index == 0)
			{
				for(i = 9; i < 64; i += 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 8; i < 57; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 1; i < 8; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
			
			//right top corner
			else if(index == 7)
			{
				for(i = 14; i < 57; i += 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				for(i = 6; i > -1; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 15; i < 64; i += 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
			
			//left down corner
			else if(index == 56)
			{
				for(i = 49; i > 6; i -= 7)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				for(i = 48; i > -1; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 57; i < 64; i += 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
			
			//right down corner
			else if(index == 63)
			{
				for(i = 54; i > -1; i -= 9)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if(blocks[i].getForeground().equals(Color.green))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				for(i = 62; i > 55; i -= 1)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				for(i = 55; i > 6 ; i -= 8)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}	
			}
		}
		//top row
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
			
			for(i = index - 1; i > -1; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			//black
			if((index == 1) || (index == 3) || (index == 5))
			{
				
				//left side
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;

				}
			}
			
			//white
			else if((index == 2) || (index == 4) || (index == 6))
			{
				j = index + 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				
				j = index + 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
		}
		
		//bottom row
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
			for(i = index - 1; i > 55; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < 64; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			//white
			if((index == 57) || (index == 59) || (index == 61))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				

				j = index - 9;
				while((blocks[j].getBackground().equals(Color.white)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
				
			}
			
			//black
			else if((index == 58) || (index == 60) || (index == 62))
			{
				j = index - 7;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}

				
				j = index - 9;
				while((blocks[j].getBackground().equals(Color.black)))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;

				}
			}
		}
		
		//left row
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			for(i = index - 8; i > -1; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 1; i < index + 8; i ++)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			for(i = index + 8; i < 57; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			if((index == 8) || (index == 24) || (index == 40))
			{
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
			}
			
			//white
			else if((index == 16) || (index == 32) || (index == 48))
			{
				j = index - 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			//up
			for(i = index - 8; i > 6; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			
			for(i = index - 1; i > index - 8; i --)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//down
			for(i = index + 8; i < 64; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			if((index == 15) || (index == 31) || (index == 47))
			{
				
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
			
			//black
			else if((index == 23) || (index == 39) || (index == 55))
			{
				j = index + 7;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
				j = index - 9;
				
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
			}
		}
		
		//center
		else
		{
			for(i = index - 8; i > 0; i -= 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			//bottom
			for(i = index + 8; i < 63; i += 8)
			{
				if(!(blocks[i].getText().equals("")))
				{
					if((blocks[i].getForeground().equals(Color.green)))
					{
						blocks[i].setBackground(Color.yellow);
					}
					break;
				}
				blocks[i].setBackground(Color.yellow);
			}
			
			if((index == 9) || (index == 10) || (index == 11) || (index == 12) || (index == 13)
					|| (index == 14))
			{
				//left
				for(i = index - 1; i > 7; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 16; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 17) || (index == 18) || (index == 19) || (index == 20) || (index == 21)
					|| (index == 22))
			{
				//left
				for(i = index - 1; i > 15; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 24; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 25) || (index == 26) || (index == 27) || (index == 28) || (index == 29)
					|| (index == 30))
			{
				//left
				for(i = index - 1; i > 23; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 32; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 33) || (index == 34) || (index == 35) || (index == 36) || (index == 37)
					|| (index == 38))
			{
				//left
				for(i = index - 1; i > 31; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 40; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 41) || (index == 42) || (index == 43) || (index == 44) || (index == 45)
					|| (index == 46))
			{
				//left
				for(i = index - 1; i > 39; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 48; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			
			else if((index == 49) || (index == 50) || (index == 51) || (index == 52) || (index == 53)
					|| (index == 54))
			{
				//left
				for(i = index - 1; i > 47; i --)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
				
				//right
				for(i = index + 1; i < 56; i ++)
				{
					if(!(blocks[i].getText().equals("")))
					{
						if((blocks[i].getForeground().equals(Color.green)))
						{
							blocks[i].setBackground(Color.yellow);
						}
						break;
					}
					blocks[i].setBackground(Color.yellow);
				}
			}
			if(previousColor.equals(Color.white))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.white))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
			
			//black  
			if(previousColor.equals(Color.black))
			{
				j = index - 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 9;
					if(j < 0)
						break;
				}
				
				j = index - 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j -= 7;
					if(j < 0)
						break;
				}
				
				j = index + 9;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 9;
					if(j > 63)
						break;
				}
				
				j = index + 7;
				while(blocks[j].getBackground().equals(Color.black))
				{
					if(!(blocks[j].getText().equals("")))
					{
						if(blocks[j].getForeground().equals(Color.green))
						{
							blocks[j].setBackground(Color.yellow);
						}
						break;
					}
					blocks[j].setBackground(Color.yellow);
					j += 7;
					if(j > 63)
						break;
				}
			}
		}
		
	}
	
	public void greenKing(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		
		//Four Corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top Corner
			if(index == 0)
			{
				JButton button1 = blocks[1];
				String c1 = button1.getText();
				
				JButton button2 = blocks[8];
				String c2 = button2.getText();
				
				JButton button3 = blocks[9];
				String c3 = button3.getText();
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				//No Enemy 
				if(blocks[1].getText().equals(""))
				{
					blocks[1].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[8].getText().equals(""))
				{
					blocks[8].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[9].getText().equals(""))
				{
					blocks[9].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				
			}
			
			//Right top Corner
			else if(index == 7)
			{
				
				JButton button1 = blocks[6];
				String c1 = button1.getText();
				
				JButton button2 = blocks[14];
				String c2 = button2.getText();
				
				JButton button3 = blocks[15];
				String c3 = button3.getText();
				
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				//No Enemy 
				if(blocks[6].getText().equals(""))
				{
					blocks[6].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[14].getText().equals(""))
				{
					blocks[14].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[15].getText().equals(""))
				{
					blocks[15].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
			}
			
			//Bottom left corner
			else if(index == 56)
			{
				JButton button1 = blocks[57];
				String c1 = button1.getText();
				
				JButton button2 = blocks[48];
				String c2 = button2.getText();
				
				JButton button3 = blocks[49];
				String c3 = button3.getText();
				
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				//No Enemy 
				if(blocks[49].getText().equals(""))
				{
					blocks[49].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[57].getText().equals(""))
				{
					blocks[57].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[48].getText().equals(""))
				{
					blocks[48].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
			}
			//Bottom right corner
			else if(index == 63)
			{
				JButton button1 = blocks[62];
				String c1 = button1.getText();
				
				JButton button2 = blocks[55];
				String c2 = button2.getText();
				
				JButton button3 = blocks[54];
				String c3 = button3.getText();
				
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = true;
					textColorChoice = true;
				}
				
				//No Enemy 
				if(blocks[54].getText().equals(""))
				{
					blocks[54].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[55].getText().equals(""))
				{
					blocks[55].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
				if(blocks[62].getText().equals(""))
				{
					blocks[62].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = true;
				}
			}
		}
		
		//top row 
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
	
			
			JButton button1 = blocks[index - 1];
			String c1 = button1.getText();
			
			JButton button2 = blocks[index + 1];
			String c2 = button2.getText();
			
			JButton button3 = blocks[index + 7];
			String c3 = button3.getText();
			
			JButton button4 = blocks[index + 8];
			String c4 = button4.getText();
			
			JButton button5 = blocks[index + 9];
			String c5 = button5.getText();
			
			
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.red))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.red))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			//No enemy
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 7].getText().equals(""))
			{
				blocks[index + 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 9].getText().equals(""))
			{
				blocks[index + 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
		}
		
		//bottom row 
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
					
			JButton button1 = blocks[index - 1];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index + 1];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index - 7];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index - 8];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index - 9];
			String c5 = button5.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.red))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.red))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
							
			//No enemy
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 7].getText().equals(""))
			{
				blocks[index - 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 9].getText().equals(""))
			{
				blocks[index - 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
		}
		
		//left row 
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			
			
			JButton button1 = blocks[index - 8];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index - 7];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index + 1];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index + 8];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index + 9];
			String c5 = button5.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.red))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.red))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
							
			//No enemy 
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 7].getText().equals(""))
			{
				blocks[index - 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 9].getText().equals(""))
			{
				blocks[index + 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			JButton button1 = blocks[index - 1];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index + 8];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index + 7];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index - 8];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index - 9];
			String c5 = button5.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.red))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.red))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
							
			//No enemy 
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 7].getText().equals(""))
			{
				blocks[index + 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 9].getText().equals(""))
			{
				blocks[index - 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
		}
		
		//center 
		else
		{
			// -9 -8 -7 -1 +1 +7 +8 + 9
			JButton button1 = blocks[index - 9];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index - 8];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index - 7];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index - 1];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index + 1];
			String c5 = button5.getText();
			
			JButton button6 = blocks[index + 7];
			String c6 = button6.getText();
			
			JButton button7 = blocks[index + 8];
			String c7 = button7.getText();
			
			JButton button8 = blocks[index + 9];
			String c8 = button8.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.red))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.red))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.red))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.red))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.red))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			if((!(c6.equals(""))) && ((button6.getForeground().equals(Color.red))))
			{
				button6.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			if((!(c7.equals(""))) && ((button7.getForeground().equals(Color.red))))
			{
				button7.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
			if((!(c8.equals(""))) && ((button8.getForeground().equals(Color.red))))
			{
				button8.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = true;
				textColorChoice = true;
			}
							
			//No enemy 
			// -9 -8 -7 -1 +1 +7 +8 + 9
			if(blocks[index - 9].getText().equals(""))
			{
				blocks[index - 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 7].getText().equals(""))
			{
				blocks[index - 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 7].getText().equals(""))
			{
				blocks[index + 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
			if(blocks[index + 9].getText().equals(""))
			{
				blocks[index + 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = true;
			}
		}
		
		chessCondition = true;
	}
	
	public void redKing(int index)
	{
		JButton button = blocks[index];
		button.setBackground(Color.blue);
		
		//Four Corners
		if((index == 0) || (index == 7) || (index == 56) || (index == 63))
		{
			//left top Corner
			if(index == 0)
			{
				JButton button1 = blocks[1];
				String c1 = button1.getText();
				
				JButton button2 = blocks[8];
				String c2 = button2.getText();
				
				JButton button3 = blocks[9];
				String c3 = button3.getText();
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				//No Enemy 
				if(blocks[1].getText().equals(""))
				{
					blocks[1].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[8].getText().equals(""))
				{
					blocks[8].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[9].getText().equals(""))
				{
					blocks[9].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				
			}
			
			//Right top Corner
			else if(index == 7)
			{
				
				JButton button1 = blocks[6];
				String c1 = button1.getText();
				
				JButton button2 = blocks[14];
				String c2 = button2.getText();
				
				JButton button3 = blocks[15];
				String c3 = button3.getText();
				
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				//No Enemy 
				if(blocks[6].getText().equals(""))
				{
					blocks[6].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[14].getText().equals(""))
				{
					blocks[14].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[15].getText().equals(""))
				{
					blocks[15].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
			}
			
			//Bottom left corner
			else if(index == 56)
			{
				JButton button1 = blocks[57];
				String c1 = button1.getText();
				
				JButton button2 = blocks[48];
				String c2 = button2.getText();
				
				JButton button3 = blocks[49];
				String c3 = button3.getText();
				
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				//No Enemy 
				if(blocks[49].getText().equals(""))
				{
					blocks[49].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[57].getText().equals(""))
				{
					blocks[57].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[48].getText().equals(""))
				{
					blocks[48].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
			}
			//Bottom right corner
			else if(index == 63)
			{
				JButton button1 = blocks[62];
				String c1 = button1.getText();
				
				JButton button2 = blocks[55];
				String c2 = button2.getText();
				
				JButton button3 = blocks[54];
				String c3 = button3.getText();
				
				
				if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
				{
					button1.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
				{
					button2.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
				{
					button3.setBackground(Color.yellow);
					globalText = button.getText();
					chessCondition = false;
					textColorChoice = false;
				}
				
				//No Enemy 
				if(blocks[54].getText().equals(""))
				{
					blocks[54].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[55].getText().equals(""))
				{
					blocks[55].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
				if(blocks[62].getText().equals(""))
				{
					blocks[62].setBackground(Color.yellow);
					globalText = button.getText();
					textColorChoice = false;
				}
			}
		}
		
		//top row 
		else if((index == 1) || (index == 2) || (index == 3) || (index == 4)
				|| (index == 5) || (index == 6))
		{
	
			
			JButton button1 = blocks[index - 1];
			String c1 = button1.getText();
			
			JButton button2 = blocks[index + 1];
			String c2 = button2.getText();
			
			JButton button3 = blocks[index + 7];
			String c3 = button3.getText();
			
			JButton button4 = blocks[index + 8];
			String c4 = button4.getText();
			
			JButton button5 = blocks[index + 9];
			String c5 = button5.getText();
			
			
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.green))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.green))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			//No enemy
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 7].getText().equals(""))
			{
				blocks[index + 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 9].getText().equals(""))
			{
				blocks[index + 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
		}
		
		//bottom row 
		else if((index == 57) || (index == 58) || (index == 59) || (index == 60)
				|| (index == 61) || (index == 62))
		{
					
			JButton button1 = blocks[index - 1];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index + 1];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index - 7];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index - 8];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index - 9];
			String c5 = button5.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.green))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.green))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
							
			//No enemy
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 7].getText().equals(""))
			{
				blocks[index - 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 9].getText().equals(""))
			{
				blocks[index - 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
		}
		
		//left row 
		else if((index == 8) || (index == 16) || (index == 24) || (index == 32)
				|| (index == 40) || (index == 48))
		{
			
			
			JButton button1 = blocks[index - 8];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index - 7];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index + 1];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index + 8];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index + 9];
			String c5 = button5.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.green))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.green))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
							
			//No enemy 
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 7].getText().equals(""))
			{
				blocks[index - 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 9].getText().equals(""))
			{
				blocks[index + 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
		}
		
		//right row
		else if((index == 15) || (index == 23) || (index == 31) || (index == 39)
				|| (index == 47) || (index == 55))
		{
			JButton button1 = blocks[index - 1];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index + 8];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index + 7];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index - 8];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index - 9];
			String c5 = button5.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.green))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.green))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
							
			//No enemy 
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 7].getText().equals(""))
			{
				blocks[index + 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 9].getText().equals(""))
			{
				blocks[index - 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
		}
		
		//center 
		else
		{
			// -9 -8 -7 -1 +1 +7 +8 + 9
			JButton button1 = blocks[index - 9];
			String c1 = button1.getText();
					
			JButton button2 = blocks[index - 8];
			String c2 = button2.getText();
					
			JButton button3 = blocks[index - 7];
			String c3 = button3.getText();
					
			JButton button4 = blocks[index - 1];
			String c4 = button4.getText();
					
			JButton button5 = blocks[index + 1];
			String c5 = button5.getText();
			
			JButton button6 = blocks[index + 7];
			String c6 = button6.getText();
			
			JButton button7 = blocks[index + 8];
			String c7 = button7.getText();
			
			JButton button8 = blocks[index + 9];
			String c8 = button8.getText();
					
					
			if((!(c1.equals(""))) && ((button1.getForeground().equals(Color.green))))
			{
				button1.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c2.equals(""))) && ((button2.getForeground().equals(Color.green))))
			{
				button2.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c3.equals(""))) && ((button3.getForeground().equals(Color.green))))
			{
				button3.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c4.equals(""))) && ((button4.getForeground().equals(Color.green))))
			{
				button4.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
					
			if((!(c5.equals(""))) && ((button5.getForeground().equals(Color.green))))
			{
				button5.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			if((!(c6.equals(""))) && ((button6.getForeground().equals(Color.green))))
			{
				button6.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			if((!(c7.equals(""))) && ((button7.getForeground().equals(Color.green))))
			{
				button7.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
			if((!(c8.equals(""))) && ((button8.getForeground().equals(Color.green))))
			{
				button8.setBackground(Color.yellow);
				globalText = button.getText();
				chessCondition = false;
				textColorChoice = false;
			}
							
			//No enemy 
			// -9 -8 -7 -1 +1 +7 +8 + 9
			if(blocks[index - 9].getText().equals(""))
			{
				blocks[index - 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 8].getText().equals(""))
			{
				blocks[index - 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 7].getText().equals(""))
			{
				blocks[index - 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 1].getText().equals(""))
			{
				blocks[index + 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index - 1].getText().equals(""))
			{
				blocks[index - 1].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 7].getText().equals(""))
			{
				blocks[index + 7].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 8].getText().equals(""))
			{
				blocks[index + 8].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
			if(blocks[index + 9].getText().equals(""))
			{
				blocks[index + 9].setBackground(Color.yellow);
				globalText = button.getText();
				textColorChoice = false;
			}
		}
		
		chessCondition = false;
	}
	
	public int redCheckMate()
	{
		int checkMateCount = 0;
		int indexOfButtons = 0;
		JButton[] greenButtons = new JButton[16];
		int[] greenIndex = new int[16];
		int j;
		
		for(i = 0; i < 64; i ++)
		{
			if((blocks[i].getForeground().equals(Color.green)) &&  (!(blocks[i].getText().equals(""))))
			{
				greenButtons[indexOfButtons] = blocks[i];
				greenIndex[indexOfButtons] = i;
				indexOfButtons ++;
			}
		}
		
		for(i = 0; i < indexOfButtons; i ++)
		{
			if(greenButtons[i].getText().equals("Pawn"))
			{
				//left Row
				if((greenIndex[i] == 48) || (greenIndex[i] == 40) || (greenIndex[i] == 32) ||
						(greenIndex[i] == 24) || (greenIndex[i] == 16) || (greenIndex[i] == 8))
				{
					JButton button5 = blocks[greenIndex[i] - 7];
					String c = button5.getText();
					
					if(((c.equals("King"))) && (button5.getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) ||
						(greenIndex[i] == 39) || (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					JButton button5 = blocks[greenIndex[i] - 9];
					String c = button5.getText();
					
					if(((c.equals("King"))) && (button5.getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
				}
				
				//center
				else
				{
					JButton button5 = blocks[greenIndex[i] - 7];
					JButton button6 = blocks[greenIndex[i] - 9];
					String c = button5.getText();
					String c1 = button6.getText();
					
					if(((c.equals("King"))) && (button5.getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					if(((c1.equals("King"))) && (button6.getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
				}
			}
			else if(greenButtons[i].getText().equals("Elephant"))
			{
				//All Corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top corner
					if(greenIndex[i] == 0)
					{
						for(j = 8; j < 57; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 1; j < 8; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//right top corner
					else if(greenIndex[i] == 7)
					{
						for(j = 6; j > -1; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 15; j < 64; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom left corner
					else if(greenIndex[i] == 56)
					{
						for(j = 48; j > -1; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}	

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 57; j < 64; j += 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom right corner
					else if(greenIndex[i] == 63)
					{
						for(j = 62; j > 55; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 55; j > 6 ; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
				}
				//top row   
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					
					//no enemy
					for(j = greenIndex[i] - 1; j > -1; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//bottom row  
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					for(j = greenIndex[i] - 1; j > 55; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 64; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//left row 
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					for(j = greenIndex[i] - 8; j > -1; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < greenIndex[i] + 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 57; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//right row 
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//up
					for(j = greenIndex[i] - 8; j > 6; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					
					for(j = greenIndex[i] - 1; j > greenIndex[i] - 8; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//down
					for(j = greenIndex[i] + 8; j < 64; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//center   
				else
				{
					//top
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//bottom
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					if((greenIndex[i] == 9) || (greenIndex[i] == 10) || (greenIndex[i] == 11) || 
							(greenIndex[i] == 12) || (greenIndex[i] == 13) || (greenIndex[i] == 14))
					{
						//left
						for(j = greenIndex[i] - 1; j > 7; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 16; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 17) || (greenIndex[i] == 18) || (greenIndex[i] == 19) ||
							(greenIndex[i] == 20) || (greenIndex[i] == 21) || (greenIndex[i] == 22))
					{
						//left
						for(j = greenIndex[i] - 1; j > 15; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 24; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 25) || (greenIndex[i] == 26) || (greenIndex[i] == 27) ||
							(greenIndex[i] == 28) || (greenIndex[i] == 29) || (greenIndex[i] == 30))
					{
						//left
						for(j = greenIndex[i] - 1; j > 23; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 32; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 33) || (greenIndex[i] == 34) || (greenIndex[i] == 35) || 
							(greenIndex[i] == 36) || (greenIndex[i] == 37) || (greenIndex[i] == 38))
					{
						//left
						for(j = greenIndex[i] - 1; j > 31; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 40; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 41) || (greenIndex[i] == 42) || (greenIndex[i] == 43) ||
							(greenIndex[i] == 44) || (greenIndex[i] == 45) || (greenIndex[i] == 46))
					{
						//left
						for(j = greenIndex[i] - 1; j > 39; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 48; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 49) || (greenIndex[i] == 50) || (greenIndex[i] == 51) ||
							(greenIndex[i] == 52) || (greenIndex[i] == 53) || (greenIndex[i] == 54))
					{
						//left
						for(j = greenIndex[i] - 1; j > 47; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 56; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
			}
			else if(greenButtons[i].getText().equals("Horse"))
			{
				//corners 
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top corner    10 17
					if(greenIndex[i] == 0)
					{
						//first
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] + 17].getText().equals("King")) &&
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					
					//right top corner    6  15
					else if(greenIndex[i] == 7)
					{
						//first
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] + 15].getText().equals("King")) &&
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					
					//bottom left corner  -6 -15
					else if(greenIndex[i] == 56)
					{
						//first
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] - 15].getText().equals("King")) &&
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					
					//bottom right corner
					else if(greenIndex[i] == 63)
					{
						//first
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] - 17].getText().equals("King")) &&
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				//top row
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || 
						(greenIndex[i] == 4) || (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					//first
					if((blocks[greenIndex[i] + 15].getText().equals("King")) &&
							(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] + 17].getText().equals("King")) &&
							(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//third
					if(greenIndex[i] == 1)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 6)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				
				//bottom row
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) ||
						(greenIndex[i] == 60) || (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
							(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
							(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					//third
					if(greenIndex[i] == 62)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 57)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				
				//left row
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) ||
						(greenIndex[i] == 32) || (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
							(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
							(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//third
					if(greenIndex[i] == 8)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 48)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) ||
						(greenIndex[i] == 39) || (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
							(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
							(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
					{
						checkMateCount ++;
					}
					
					//third
					if(greenIndex[i] == 55)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 15)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				
				else if(greenIndex[i] == 9)
				{
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				
				else if(greenIndex[i] == 14)
				{
					if((greenIndex[i] + 6) < 63)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
				}
				
				else if(greenIndex[i] == 49)
				{
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
				}
				
				else if(greenIndex[i] == 54)
				{
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 6) < 63)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}

				}
				else if((greenIndex[i] == 17) || (greenIndex[i] == 25) || (greenIndex[i] == 33) || (greenIndex[i] == 41))
				{
					//negative
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					//positive
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				
				else if((greenIndex[i] == 22) || (greenIndex[i] == 30) || (greenIndex[i] == 38) || (greenIndex[i] == 46))
				{
					//negative
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					//positive
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 6) < 64)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
				else
				{
					//negative
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					//positive
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 6) < 64)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}
					}
				}
			}
			else if(greenButtons[i].getText().equals("Bishop"))
			{
				//corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top
					if(greenIndex[i] == 0)
					{
						for(j = 9; j < 64; j += 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//right top   
					else if(greenIndex[i] == 7)
					{
						for(j = 14; j < 57; j += 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down left
					else if(greenIndex[i] == 56)
					{
						for(j = 49; j > 6; j -= 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down right
					else if(greenIndex[i] == 63)
					{
						for(j = 54; j > -1; j -= 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
				//top row
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					//black
					if((greenIndex[i] == 1) || (greenIndex[i] == 3) || (greenIndex[i] == 5))
					{
						
						//left side
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;

						}
					}
					
					//white
					else if((greenIndex[i] == 2) || (greenIndex[i] == 4) || (greenIndex[i] == 6))
					{
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}

				//bottom row
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					//white
					if((greenIndex[i] == 57) || (greenIndex[i] == 59) || (greenIndex[i] == 61))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						

						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
						
					}
					
					//black
					else if((greenIndex[i] == 58) || (greenIndex[i] == 60) || (greenIndex[i] == 62))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}

						
						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
					}

				}
				
				//left row
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					//black
					if((greenIndex[i] == 8) || (greenIndex[i] == 24) || (greenIndex[i] == 40))
					{
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
					}
					
					//white
					else if((greenIndex[i] == 16) || (greenIndex[i] == 32) || (greenIndex[i] == 48))
					{
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//white
					if((greenIndex[i] == 15) || (greenIndex[i] == 31) || (greenIndex[i] == 47))
					{
						
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
					
					//black
					else if((greenIndex[i] == 23) || (greenIndex[i] == 39) || (greenIndex[i] == 55))
					{
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
				}
				//center
				else
				{
					Color previousColor = blocks[greenIndex[i]].getBackground();
					//white   9
					if(previousColor.equals(Color.white))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
					
					//black   10
					if(previousColor.equals(Color.black))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
				}
				
			}
			else if(greenButtons[i].getText().equals("Queen"))
			{
				//All Corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top corner
					if(greenIndex[i] == 0)
					{
						for(j = 8; j < 57; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 1; j < 8; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//right top corner
					else if(greenIndex[i] == 7)
					{
						for(j = 6; j > -1; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 15; j < 64; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom left corner
					else if(greenIndex[i] == 56)
					{
						for(j = 48; j > -1; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}	

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 57; j < 64; j += 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom right corner
					else if(greenIndex[i] == 63)
					{
						for(j = 62; j > 55; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 55; j > 6 ; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
				}
				//top row   
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					
					//no enemy
					for(j = greenIndex[i] - 1; j > -1; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//bottom row  
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					for(j = greenIndex[i] - 1; j > 55; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 64; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//left row 
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					for(j = greenIndex[i] - 8; j > -1; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < greenIndex[i] + 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 57; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//right row 
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//up
					for(j = greenIndex[i] - 8; j > 6; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					
					for(j = greenIndex[i] - 1; j > greenIndex[i] - 8; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//down
					for(j = greenIndex[i] + 8; j < 64; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//center   
				else
				{
					//top
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//bottom
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					if((greenIndex[i] == 9) || (greenIndex[i] == 10) || (greenIndex[i] == 11) || 
							(greenIndex[i] == 12) || (greenIndex[i] == 13) || (greenIndex[i] == 14))
					{
						//left
						for(j = greenIndex[i] - 1; j > 7; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 16; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 17) || (greenIndex[i] == 18) || (greenIndex[i] == 19) ||
							(greenIndex[i] == 20) || (greenIndex[i] == 21) || (greenIndex[i] == 22))
					{
						//left
						for(j = greenIndex[i] - 1; j > 15; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 24; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 25) || (greenIndex[i] == 26) || (greenIndex[i] == 27) ||
							(greenIndex[i] == 28) || (greenIndex[i] == 29) || (greenIndex[i] == 30))
					{
						//left
						for(j = greenIndex[i] - 1; j > 23; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 32; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 33) || (greenIndex[i] == 34) || (greenIndex[i] == 35) || 
							(greenIndex[i] == 36) || (greenIndex[i] == 37) || (greenIndex[i] == 38))
					{
						//left
						for(j = greenIndex[i] - 1; j > 31; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 40; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 41) || (greenIndex[i] == 42) || (greenIndex[i] == 43) ||
							(greenIndex[i] == 44) || (greenIndex[i] == 45) || (greenIndex[i] == 46))
					{
						//left
						for(j = greenIndex[i] - 1; j > 39; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 48; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 49) || (greenIndex[i] == 50) || (greenIndex[i] == 51) ||
							(greenIndex[i] == 52) || (greenIndex[i] == 53) || (greenIndex[i] == 54))
					{
						//left
						for(j = greenIndex[i] - 1; j > 47; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 56; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
				//corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top
					if(greenIndex[i] == 0)
					{
						for(j = 9; j < 64; j += 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//right top   
					else if(greenIndex[i] == 7)
					{
						for(j = 14; j < 57; j += 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down left
					else if(greenIndex[i] == 56)
					{
						for(j = 49; j > 6; j -= 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down right
					else if(greenIndex[i] == 63)
					{
						for(j = 54; j > -1; j -= 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
				//top row
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					//black
					if((greenIndex[i] == 1) || (greenIndex[i] == 3) || (greenIndex[i] == 5))
					{
						
						//left side
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;

						}
					}
					
					//white
					else if((greenIndex[i] == 2) || (greenIndex[i] == 4) || (greenIndex[i] == 6))
					{
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}

				//bottom row
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					//white
					if((greenIndex[i] == 57) || (greenIndex[i] == 59) || (greenIndex[i] == 61))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						

						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
						
					}
					
					//black
					else if((greenIndex[i] == 58) || (greenIndex[i] == 60) || (greenIndex[i] == 62))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}

						
						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
					}

				}
				
				//left row
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					//black
					if((greenIndex[i] == 8) || (greenIndex[i] == 24) || (greenIndex[i] == 40))
					{
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
					}
					
					//white
					else if((greenIndex[i] == 16) || (greenIndex[i] == 32) || (greenIndex[i] == 48))
					{
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//white
					if((greenIndex[i] == 15) || (greenIndex[i] == 31) || (greenIndex[i] == 47))
					{
						
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
					
					//black
					else if((greenIndex[i] == 23) || (greenIndex[i] == 39) || (greenIndex[i] == 55))
					{
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
				}
				//center
				else
				{
					Color previousColor = blocks[greenIndex[i]].getBackground();
					//white   9
					if(previousColor.equals(Color.white))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
					
					//black   10
					if(previousColor.equals(Color.black))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.red)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
				}
			}
			else if(greenButtons[i].getText().equals("King"))
			{
				//Four Corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top Corner
					if(greenIndex[i] == 0)
					{
						JButton button1 = blocks[1];
						String c1 = button1.getText();
						
						JButton button2 = blocks[8];
						String c2 = button2.getText();
						
						JButton button3 = blocks[9];
						String c3 = button3.getText();
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
					}
					
					//Right top Corner
					else if(greenIndex[i] == 7)
					{
						
						JButton button1 = blocks[6];
						String c1 = button1.getText();
						
						JButton button2 = blocks[14];
						String c2 = button2.getText();
						
						JButton button3 = blocks[15];
						String c3 = button3.getText();
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
					}
					
					//Bottom left corner
					else if(greenIndex[i] == 56)
					{
						JButton button1 = blocks[57];
						String c1 = button1.getText();
						
						JButton button2 = blocks[48];
						String c2 = button2.getText();
						
						JButton button3 = blocks[49];
						String c3 = button3.getText();
						
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
					}
					//Bottom right corner
					else if(greenIndex[i] == 63)
					{
						JButton button1 = blocks[62];
						String c1 = button1.getText();
						
						JButton button2 = blocks[55];
						String c2 = button2.getText();
						
						JButton button3 = blocks[54];
						String c3 = button3.getText();
						
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
						{
							checkMateCount ++;
						}
					}
				}
				//top row 
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
			
					
					JButton button1 = blocks[greenIndex[i] - 1];
					String c1 = button1.getText();
					
					JButton button2 = blocks[greenIndex[i] + 1];
					String c2 = button2.getText();
					
					JButton button3 = blocks[greenIndex[i] + 7];
					String c3 = button3.getText();
					
					JButton button4 = blocks[greenIndex[i] + 8];
					String c4 = button4.getText();
					
					JButton button5 = blocks[greenIndex[i] + 9];
					String c5 = button5.getText();
					
					
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
					
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
					
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
					
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
					
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
				}
				
				//bottom row 
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
							
					JButton button1 = blocks[greenIndex[i] - 1];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] + 1];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] - 7];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] - 8];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] - 9];
					String c5 = button5.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
					
				}
				
				//left row 
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					
					
					JButton button1 = blocks[greenIndex[i] - 8];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] - 7];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] + 1];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] + 8];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] + 9];
					String c5 = button5.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
									
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					JButton button1 = blocks[greenIndex[i] - 1];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] + 8];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] + 7];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] - 8];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] - 9];
					String c5 = button5.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
				}
				//center 
				else
				{
					// -9 -8 -7 -1 +1 +7 +8 + 9
					JButton button1 = blocks[greenIndex[i] - 9];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] - 8];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] - 7];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] - 1];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] + 1];
					String c5 = button5.getText();
					
					JButton button6 = blocks[greenIndex[i] + 7];
					String c6 = button6.getText();
					
					JButton button7 = blocks[greenIndex[i] + 8];
					String c7 = button7.getText();
					
					JButton button8 = blocks[greenIndex[i] + 9];
					String c8 = button8.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
					
					if(((c6.equals("King"))) && ((button6.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c7.equals("King"))) && ((button7.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
							
					if(((c8.equals("King"))) && ((button8.getForeground().equals(Color.red))))
					{
						checkMateCount ++;
					}
				}
			}
		}
		if(checkMateCount == 0)
		{
			return 0;
		}
		
		else
		{
			return 2;
		}
	}
	
	public int greenCheckMate()
	{

		int checkMateCount = 0;
		int indexOfButtons = 0;
		JButton[] greenButtons = new JButton[16];
		int[] greenIndex = new int[16];
		int j;
		
		for(i = 0; i < 64; i ++)
		{
			if((blocks[i].getForeground().equals(Color.red)) &&  (!(blocks[i].getText().equals(""))))
			{
				greenButtons[indexOfButtons] = blocks[i];
				greenIndex[indexOfButtons] = i;
				indexOfButtons ++;
			}
		}
		
		for(i = 0; i < indexOfButtons; i ++)
		{
			if(greenButtons[i].getText().equals("Pawn"))
			{
				//left Row
				if((greenIndex[i] == 48) || (greenIndex[i] == 40) || (greenIndex[i] == 32) ||
						(greenIndex[i] == 24) || (greenIndex[i] == 16) || (greenIndex[i] == 8))
				{
					JButton button5 = blocks[greenIndex[i] + 7];
					String c = button5.getText();
					
					if(((c.equals("King"))) && (button5.getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) ||
						(greenIndex[i] == 39) || (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					JButton button5 = blocks[greenIndex[i] + 9];
					String c = button5.getText();
					
					if(((c.equals("King"))) && (button5.getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
				}
				
				//center
				else
				{
					JButton button5 = blocks[greenIndex[i] + 7];
					JButton button6 = blocks[greenIndex[i] + 9];
					String c = button5.getText();
					String c1 = button6.getText();
					
					if(((c.equals("King"))) && (button5.getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					if(((c1.equals("King"))) && (button6.getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
				}
			}
			else if(greenButtons[i].getText().equals("Elephant"))
			{
				//All Corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top corner
					if(greenIndex[i] == 0)
					{
						for(j = 8; j < 57; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 1; j < 8; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//right top corner
					else if(greenIndex[i] == 7)
					{
						for(j = 6; j > -1; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 15; j < 64; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom left corner
					else if(greenIndex[i] == 56)
					{
						for(j = 48; j > -1; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}	

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 57; j < 64; j += 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom right corner
					else if(greenIndex[i] == 63)
					{
						for(j = 62; j > 55; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 55; j > 6 ; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
				}
				//top row   
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					
					//no enemy
					for(j = greenIndex[i] - 1; j > -1; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//bottom row  
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					for(j = greenIndex[i] - 1; j > 55; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 64; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//left row 
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					for(j = greenIndex[i] - 8; j > -1; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < greenIndex[i] + 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 57; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//right row 
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//up
					for(j = greenIndex[i] - 8; j > 6; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					
					for(j = greenIndex[i] - 1; j > greenIndex[i] - 8; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//down
					for(j = greenIndex[i] + 8; j < 64; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//center   
				else
				{
					//top
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//bottom
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					if((greenIndex[i] == 9) || (greenIndex[i] == 10) || (greenIndex[i] == 11) || 
							(greenIndex[i] == 12) || (greenIndex[i] == 13) || (greenIndex[i] == 14))
					{
						//left
						for(j = greenIndex[i] - 1; j > 7; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 16; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 17) || (greenIndex[i] == 18) || (greenIndex[i] == 19) ||
							(greenIndex[i] == 20) || (greenIndex[i] == 21) || (greenIndex[i] == 22))
					{
						//left
						for(j = greenIndex[i] - 1; j > 15; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 24; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 25) || (greenIndex[i] == 26) || (greenIndex[i] == 27) ||
							(greenIndex[i] == 28) || (greenIndex[i] == 29) || (greenIndex[i] == 30))
					{
						//left
						for(j = greenIndex[i] - 1; j > 23; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 32; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 33) || (greenIndex[i] == 34) || (greenIndex[i] == 35) || 
							(greenIndex[i] == 36) || (greenIndex[i] == 37) || (greenIndex[i] == 38))
					{
						//left
						for(j = greenIndex[i] - 1; j > 31; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 40; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 41) || (greenIndex[i] == 42) || (greenIndex[i] == 43) ||
							(greenIndex[i] == 44) || (greenIndex[i] == 45) || (greenIndex[i] == 46))
					{
						//left
						for(j = greenIndex[i] - 1; j > 39; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 48; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 49) || (greenIndex[i] == 50) || (greenIndex[i] == 51) ||
							(greenIndex[i] == 52) || (greenIndex[i] == 53) || (greenIndex[i] == 54))
					{
						//left
						for(j = greenIndex[i] - 1; j > 47; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 56; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
			}
			else if(greenButtons[i].getText().equals("Horse"))
			{
				//corners 
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top corner    10 17
					if(greenIndex[i] == 0)
					{
						//first
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] + 17].getText().equals("King")) &&
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					
					//right top corner    6  15
					else if(greenIndex[i] == 7)
					{
						//first
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] + 15].getText().equals("King")) &&
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					
					//bottom left corner  -6 -15
					else if(greenIndex[i] == 56)
					{
						//first
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] - 15].getText().equals("King")) &&
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					
					//bottom right corner
					else if(greenIndex[i] == 63)
					{
						//first
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						
						//second
						if((blocks[greenIndex[i] - 17].getText().equals("King")) &&
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				//top row
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || 
						(greenIndex[i] == 4) || (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					//first
					if((blocks[greenIndex[i] + 15].getText().equals("King")) &&
							(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] + 17].getText().equals("King")) &&
							(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//third
					if(greenIndex[i] == 1)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 6)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				
				//bottom row
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) ||
						(greenIndex[i] == 60) || (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
							(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
							(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					//third
					if(greenIndex[i] == 62)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 57)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				
				//left row
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) ||
						(greenIndex[i] == 32) || (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
							(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
							(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//third
					if(greenIndex[i] == 8)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 48)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) ||
						(greenIndex[i] == 39) || (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
							(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//second
					if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
							(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
					{
						checkMateCount ++;
					}
					
					//third
					if(greenIndex[i] == 55)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else if(greenIndex[i] == 15)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					else
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				
				else if(greenIndex[i] == 9)
				{
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				
				else if(greenIndex[i] == 14)
				{
					if((greenIndex[i] + 6) < 63)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
				}
				
				else if(greenIndex[i] == 49)
				{
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
				}
				
				else if(greenIndex[i] == 54)
				{
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] + 6) < 63)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}

				}
				else if((greenIndex[i] == 17) || (greenIndex[i] == 25) || (greenIndex[i] == 33) || (greenIndex[i] == 41))
				{
					//negative
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					//positive
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				
				else if((greenIndex[i] == 22) || (greenIndex[i] == 30) || (greenIndex[i] == 38) || (greenIndex[i] == 46))
				{
					//negative
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					//positive
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 6) < 64)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
				else
				{
					//negative
					if((greenIndex[i] - 17) > -1)
					{
						if((blocks[greenIndex[i] - 17].getText().equals("King")) && 
								(blocks[greenIndex[i] - 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 15) > -1)
					{
						if((blocks[greenIndex[i] - 15].getText().equals("King")) && 
								(blocks[greenIndex[i] - 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 10) > -1)
					{
						if((blocks[greenIndex[i] - 10].getText().equals("King")) && 
								(blocks[greenIndex[i] - 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] - 6) > -1)
					{
						if((blocks[greenIndex[i] - 6].getText().equals("King")) && 
								(blocks[greenIndex[i] - 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					//positive
					if((greenIndex[i] + 17) < 64)
					{
						if((blocks[greenIndex[i] + 17].getText().equals("King")) && 
								(blocks[greenIndex[i] + 17].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 15) < 64)
					{
						if((blocks[greenIndex[i] + 15].getText().equals("King")) && 
								(blocks[greenIndex[i] + 15].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 10) < 64)
					{
						if((blocks[greenIndex[i] + 10].getText().equals("King")) && 
								(blocks[greenIndex[i] + 10].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
					if((greenIndex[i] + 6) < 64)
					{
						if((blocks[greenIndex[i] + 6].getText().equals("King")) && 
								(blocks[greenIndex[i] + 6].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}
					}
				}
			}
			else if(greenButtons[i].getText().equals("Bishop"))
			{
				//corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top
					if(greenIndex[i] == 0)
					{
						for(j = 9; j < 64; j += 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//right top   
					else if(greenIndex[i] == 7)
					{
						for(j = 14; j < 57; j += 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down left
					else if(greenIndex[i] == 56)
					{
						for(j = 49; j > 6; j -= 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down right
					else if(greenIndex[i] == 63)
					{
						for(j = 54; j > -1; j -= 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
				//top row
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					//black
					if((greenIndex[i] == 1) || (greenIndex[i] == 3) || (greenIndex[i] == 5))
					{
						
						//left side
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;

						}
					}
					
					//white
					else if((greenIndex[i] == 2) || (greenIndex[i] == 4) || (greenIndex[i] == 6))
					{
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}

				//bottom row
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					//white
					if((greenIndex[i] == 57) || (greenIndex[i] == 59) || (greenIndex[i] == 61))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						

						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
						
					}
					
					//black
					else if((greenIndex[i] == 58) || (greenIndex[i] == 60) || (greenIndex[i] == 62))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}

						
						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
					}

				}
				
				//left row
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					//black
					if((greenIndex[i] == 8) || (greenIndex[i] == 24) || (greenIndex[i] == 40))
					{
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
					}
					
					//white
					else if((greenIndex[i] == 16) || (greenIndex[i] == 32) || (greenIndex[i] == 48))
					{
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//white
					if((greenIndex[i] == 15) || (greenIndex[i] == 31) || (greenIndex[i] == 47))
					{
						
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
					
					//black
					else if((greenIndex[i] == 23) || (greenIndex[i] == 39) || (greenIndex[i] == 55))
					{
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
				}
				//center
				else
				{
					Color previousColor = blocks[greenIndex[i]].getBackground();
					//white   9
					if(previousColor.equals(Color.white))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
					
					//black   10
					if(previousColor.equals(Color.black))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
				}
				
			}
			else if(greenButtons[i].getText().equals("Queen"))
			{
				//All Corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top corner
					if(greenIndex[i] == 0)
					{
						for(j = 8; j < 57; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 1; j < 8; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}
							
							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//right top corner
					else if(greenIndex[i] == 7)
					{
						for(j = 6; j > -1; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 15; j < 64; j += 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom left corner
					else if(greenIndex[i] == 56)
					{
						for(j = 48; j > -1; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}	

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 57; j < 64; j += 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
					
					//bottom right corner
					else if(greenIndex[i] == 63)
					{
						for(j = 62; j > 55; j -= 1)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						for(j = 55; j > 6 ; j -= 8)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}	
					}
				}
				//top row   
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					
					//no enemy
					for(j = greenIndex[i] - 1; j > -1; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//bottom row  
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					for(j = greenIndex[i] - 1; j > 55; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < 64; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//left row 
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					for(j = greenIndex[i] - 8; j > -1; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 1; j < greenIndex[i] + 8; j ++)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					for(j = greenIndex[i] + 8; j < 57; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				
				//right row 
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//up
					for(j = greenIndex[i] - 8; j > 6; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					
					for(j = greenIndex[i] - 1; j > greenIndex[i] - 8; j --)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//down
					for(j = greenIndex[i] + 8; j < 64; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
				}
				//center   
				else
				{
					//top
					for(j = greenIndex[i] - 8; j > 0; j -= 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					//bottom
					for(j = greenIndex[i] + 8; j < 63; j += 8)
					{
						if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
						{
							checkMateCount ++;
						}

						if(!(blocks[j].getText().equals(""))) 
						{
							break;
						}
					}
					
					if((greenIndex[i] == 9) || (greenIndex[i] == 10) || (greenIndex[i] == 11) || 
							(greenIndex[i] == 12) || (greenIndex[i] == 13) || (greenIndex[i] == 14))
					{
						//left
						for(j = greenIndex[i] - 1; j > 7; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 16; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 17) || (greenIndex[i] == 18) || (greenIndex[i] == 19) ||
							(greenIndex[i] == 20) || (greenIndex[i] == 21) || (greenIndex[i] == 22))
					{
						//left
						for(j = greenIndex[i] - 1; j > 15; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 24; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 25) || (greenIndex[i] == 26) || (greenIndex[i] == 27) ||
							(greenIndex[i] == 28) || (greenIndex[i] == 29) || (greenIndex[i] == 30))
					{
						//left
						for(j = greenIndex[i] - 1; j > 23; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 32; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 33) || (greenIndex[i] == 34) || (greenIndex[i] == 35) || 
							(greenIndex[i] == 36) || (greenIndex[i] == 37) || (greenIndex[i] == 38))
					{
						//left
						for(j = greenIndex[i] - 1; j > 31; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 40; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 41) || (greenIndex[i] == 42) || (greenIndex[i] == 43) ||
							(greenIndex[i] == 44) || (greenIndex[i] == 45) || (greenIndex[i] == 46))
					{
						//left
						for(j = greenIndex[i] - 1; j > 39; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 48; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					else if((greenIndex[i] == 49) || (greenIndex[i] == 50) || (greenIndex[i] == 51) ||
							(greenIndex[i] == 52) || (greenIndex[i] == 53) || (greenIndex[i] == 54))
					{
						//left
						for(j = greenIndex[i] - 1; j > 47; j --)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
						
						//right
						for(j = greenIndex[i] + 1; j < 56; j ++)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}

				//corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top
					if(greenIndex[i] == 0)
					{
						for(j = 9; j < 64; j += 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//right top   
					else if(greenIndex[i] == 7)
					{
						for(j = 14; j < 57; j += 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down left
					else if(greenIndex[i] == 56)
					{
						for(j = 49; j > 6; j -= 7)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
					
					//down right
					else if(greenIndex[i] == 63)
					{
						for(j = 54; j > -1; j -= 9)
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
						}
					}
				}
				//top row
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
					//black
					if((greenIndex[i] == 1) || (greenIndex[i] == 3) || (greenIndex[i] == 5))
					{
						
						//left side
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;

						}
					}
					
					//white
					else if((greenIndex[i] == 2) || (greenIndex[i] == 4) || (greenIndex[i] == 6))
					{
						j = greenIndex[i] + 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}

				//bottom row
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
					//white
					if((greenIndex[i] == 57) || (greenIndex[i] == 59) || (greenIndex[i] == 61))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						

						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.white)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
						
					}
					
					//black
					else if((greenIndex[i] == 58) || (greenIndex[i] == 60) || (greenIndex[i] == 62))
					{
						j = greenIndex[i] - 7;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}

						
						j = greenIndex[i] - 9;
						while((blocks[j].getBackground().equals(Color.black)))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;

						}
					}

				}
				
				//left row
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					//black
					if((greenIndex[i] == 8) || (greenIndex[i] == 24) || (greenIndex[i] == 40))
					{
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
					}
					
					//white
					else if((greenIndex[i] == 16) || (greenIndex[i] == 32) || (greenIndex[i] == 48))
					{
						j = greenIndex[i] - 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
					}
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					//white
					if((greenIndex[i] == 15) || (greenIndex[i] == 31) || (greenIndex[i] == 47))
					{
						
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
					
					//black
					else if((greenIndex[i] == 23) || (greenIndex[i] == 39) || (greenIndex[i] == 55))
					{
						j = greenIndex[i] + 7;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
						j = greenIndex[i] - 9;
						
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
					}
				}
				//center
				else
				{
					Color previousColor = blocks[greenIndex[i]].getBackground();
					//white   9
					if(previousColor.equals(Color.white))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.white))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
					
					//black   10
					if(previousColor.equals(Color.black))
					{
						j = greenIndex[i] - 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 9;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] - 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j -= 7;
							if(j < 0)
								break;
						}
						
						j = greenIndex[i] + 9;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 9;
							if(j > 63)
								break;
						}
						
						j = greenIndex[i] + 7;
						while(blocks[j].getBackground().equals(Color.black))
						{
							if((blocks[j].getText().equals("King")) && (blocks[j].getForeground().equals(Color.green)))
							{
								checkMateCount ++;
							}

							if(!(blocks[j].getText().equals(""))) 
							{
								break;
							}
							j += 7;
							if(j > 63)
								break;
						}
					}
				}
			}
			else if(greenButtons[i].getText().equals("King"))
			{
				//Four Corners
				if((greenIndex[i] == 0) || (greenIndex[i] == 7) || (greenIndex[i] == 56) || (greenIndex[i] == 63))
				{
					//left top Corner
					if(greenIndex[i] == 0)
					{
						JButton button1 = blocks[1];
						String c1 = button1.getText();
						
						JButton button2 = blocks[8];
						String c2 = button2.getText();
						
						JButton button3 = blocks[9];
						String c3 = button3.getText();
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
					}
					
					//Right top Corner
					else if(greenIndex[i] == 7)
					{
						
						JButton button1 = blocks[6];
						String c1 = button1.getText();
						
						JButton button2 = blocks[14];
						String c2 = button2.getText();
						
						JButton button3 = blocks[15];
						String c3 = button3.getText();
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
					}
					
					//Bottom left corner
					else if(greenIndex[i] == 56)
					{
						JButton button1 = blocks[57];
						String c1 = button1.getText();
						
						JButton button2 = blocks[48];
						String c2 = button2.getText();
						
						JButton button3 = blocks[49];
						String c3 = button3.getText();
						
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
					}
					//Bottom right corner
					else if(greenIndex[i] == 63)
					{
						JButton button1 = blocks[62];
						String c1 = button1.getText();
						
						JButton button2 = blocks[55];
						String c2 = button2.getText();
						
						JButton button3 = blocks[54];
						String c3 = button3.getText();
						
						
						if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
						
						if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
						{
							checkMateCount ++;
						}
					}
				}
				//top row 
				else if((greenIndex[i] == 1) || (greenIndex[i] == 2) || (greenIndex[i] == 3) || (greenIndex[i] == 4)
						|| (greenIndex[i] == 5) || (greenIndex[i] == 6))
				{
			
					
					JButton button1 = blocks[greenIndex[i] - 1];
					String c1 = button1.getText();
					
					JButton button2 = blocks[greenIndex[i] + 1];
					String c2 = button2.getText();
					
					JButton button3 = blocks[greenIndex[i] + 7];
					String c3 = button3.getText();
					
					JButton button4 = blocks[greenIndex[i] + 8];
					String c4 = button4.getText();
					
					JButton button5 = blocks[greenIndex[i] + 9];
					String c5 = button5.getText();
					
					
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
					
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
					
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
					
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
					
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
				}
				
				//bottom row 
				else if((greenIndex[i] == 57) || (greenIndex[i] == 58) || (greenIndex[i] == 59) || (greenIndex[i] == 60)
						|| (greenIndex[i] == 61) || (greenIndex[i] == 62))
				{
							
					JButton button1 = blocks[greenIndex[i] - 1];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] + 1];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] - 7];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] - 8];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] - 9];
					String c5 = button5.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
					
				}
				
				//left row 
				else if((greenIndex[i] == 8) || (greenIndex[i] == 16) || (greenIndex[i] == 24) || (greenIndex[i] == 32)
						|| (greenIndex[i] == 40) || (greenIndex[i] == 48))
				{
					
					
					JButton button1 = blocks[greenIndex[i] - 8];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] - 7];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] + 1];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] + 8];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] + 9];
					String c5 = button5.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
									
				}
				
				//right row
				else if((greenIndex[i] == 15) || (greenIndex[i] == 23) || (greenIndex[i] == 31) || (greenIndex[i] == 39)
						|| (greenIndex[i] == 47) || (greenIndex[i] == 55))
				{
					JButton button1 = blocks[greenIndex[i] - 1];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] + 8];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] + 7];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] - 8];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] - 9];
					String c5 = button5.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
				}
				//center 
				else
				{
					// -9 -8 -7 -1 +1 +7 +8 + 9
					JButton button1 = blocks[greenIndex[i] - 9];
					String c1 = button1.getText();
							
					JButton button2 = blocks[greenIndex[i] - 8];
					String c2 = button2.getText();
							
					JButton button3 = blocks[greenIndex[i] - 7];
					String c3 = button3.getText();
							
					JButton button4 = blocks[greenIndex[i] - 1];
					String c4 = button4.getText();
							
					JButton button5 = blocks[greenIndex[i] + 1];
					String c5 = button5.getText();
					
					JButton button6 = blocks[greenIndex[i] + 7];
					String c6 = button6.getText();
					
					JButton button7 = blocks[greenIndex[i] + 8];
					String c7 = button7.getText();
					
					JButton button8 = blocks[greenIndex[i] + 9];
					String c8 = button8.getText();
							
							
					if(((c1.equals("King"))) && ((button1.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c2.equals("King"))) && ((button2.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c3.equals("King"))) && ((button3.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c4.equals("King"))) && ((button4.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c5.equals("King"))) && ((button5.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
					
					if(((c6.equals("King"))) && ((button6.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c7.equals("King"))) && ((button7.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
							
					if(((c8.equals("King"))) && ((button8.getForeground().equals(Color.green))))
					{
						checkMateCount ++;
					}
				}
			}
		}
		if(checkMateCount == 0)
		{
			return 0;
		}
		
		else
		{
			return 2;
		}
	}
	
	public void actionPerformed(ActionEvent ae) 
	{
		int i = 0;
		int j;
		JButton button2;
		int checkMate;
		
		//GREEN
		if(chessCondition == true)
		{
			chessCondition = false;
			
			final JButton button3 = (JButton) ae.getSource();
			String text = button3.getText();
			Color c = button3.getBackground();
			boolean tempCondition = text.equals("");
			
			if(c.equals(Color.yellow) && text.equals(""))
			{
					button3.setText(globalText);
					if(textColorChoice == true)
						button3.setForeground(Color.green);
					else
						button3.setForeground(Color.red);
					for(i = 0; i < 64; i ++)
					{
						if(blocks[i].getBackground().equals(Color.blue))
						{
							blocks[i].setText("");
							break;
						}
					}
					setWhiteBlack();
					chessCondition = false;
					
					//pawn final
					if(button3.getText().equals("Pawn"))
					{
						for(j = 0; j < 64; j ++)
						{
							if(ae.getSource().equals(blocks[j]))
							{
								i = j;
								break;
							}
						}
						if((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5)
								|| (i == 6) || (i == 7))
						{
							String pawnChange = "Queen";
							/*
							PawnSelect pawnselect = new PawnSelect();
							pawnselect.setSize(330, 125);
							pawnselect.setVisible(true);
							
							this.setVisible(false);
							
							while(true)
							{
								if(!(pawnselect.isVisible()))
								{
									pawnChange = pawnselect.pawn.getText();
									pawnselect.dispose();
									this.setVisible(true);
									break;
								}
							}
							*/
							button3.setText(pawnChange);
						}
					}
					
					int count = 0;
					
					for(int k = 0; k < 64; k ++)
					{
						if((blocks[k].getText().equals("King")) && (blocks[k].getForeground().equals(Color.red)))
						{
							count ++;
						}
					}
					
					if(count == 0)
					{
						JOptionPane.showMessageDialog(this, "Player " + this.player1 + " Wins");
						resetTotalGame();
					}
					
					checkMate = redCheckMate();
					if(checkMate == 0)
					{
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(this, "CheckMate Red King");
						redKingCheckCount ++;
						return;
					}
			}

			else if(c.equals(Color.yellow) && tempCondition == false)
			{
					button3.setText(globalText);
					if(textColorChoice == true)
						button3.setForeground(Color.green);
					else
						button3.setForeground(Color.red);
					for(i = 0; i < 64; i ++)
					{
						if(blocks[i].getBackground().equals(Color.blue))
						{
							blocks[i].setText("");
							break;
						}
					}
					setWhiteBlack();
					chessCondition = false;
					
					//pawn final
					if(button3.getText().equals("Pawn"))
					{
						for(j = 0; j < 64; j ++)
						{
							if(ae.getSource().equals(blocks[j]))
							{
								i = j;
								break;
							}
						}
						if((i == 0) || (i == 1) || (i == 2) || (i == 3) || (i == 4) || (i == 5)
								|| (i == 6) || (i == 7))
						{
							String pawnChange = "Queen";
							/*
							PawnSelect pawnselect = new PawnSelect();
							pawnselect.setSize(330, 125);
							pawnselect.setVisible(true);
							
							this.setVisible(false);
							
							while(true)
							{
								if(!(pawnselect.isVisible()))
								{
									pawnChange = pawnselect.pawn.getText();
									pawnselect.dispose();
									this.setVisible(true);
									break;
								}
							}
							*/
							button3.setText(pawnChange);

						}
					}
					
					int count = 0;
					
					for(int k = 0; k < 64; k ++)
					{
						if((blocks[k].getText().equals("King")) && (blocks[k].getForeground().equals(Color.red)))
						{
							count ++;
						}
					}
					
					if(count == 0)
					{
						JOptionPane.showMessageDialog(this, "Player " + this.player1 + " Wins");
						resetTotalGame();
					}
					
					checkMate = redCheckMate();
					if(checkMate == 0)
					{
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(this, "CheckMate Red King");
						redKingCheckCount ++;
						return;
					}
			}
				
			//PAWN
			if(ae.getActionCommand().equals("Pawn"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.green))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					greenPawn(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = true;
				}
			}
			
			else if(ae.getActionCommand().equals("Elephant"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.green))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					greenElephant(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = true;
				}
			}
			
			else if(ae.getActionCommand().equals("Horse"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.green))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					greenHorse(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = true;
				}
			}
			
			else if(ae.getActionCommand().equals("Bishop"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.green))
				{		
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					greenBishop(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = true;
				}
			}
			
			else if(ae.getActionCommand().equals("Queen"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.green))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					greenQueen(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = true;
				}
			}
			
			else if(ae.getActionCommand().equals("King"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.green))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					greenKing(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = true;
				}
			}
			
			else if(ae.getActionCommand().equals(""))
			{
				setWhiteBlack();
				chessCondition = true;
				JButton button = (JButton) ae.getSource();
				button.setBackground(Color.green);
			}
		}
		
		//RED
		else
		{
			chessCondition = true;
		
			JButton button3 = (JButton) ae.getSource();
			String text = button3.getText();
			Color c = button3.getBackground();
			boolean tempCondition = text.equals("");
			
			if(c.equals(Color.yellow) && text.equals(""))
			{
					button3.setText(globalText);
					
					if(textColorChoice == true)
						button3.setForeground(Color.green);
					
					else
						button3.setForeground(Color.red);
					
					if(button3.getText().equals("Pawn"))
					{
						for(j = 0; j < 64; j ++)
						{
							if(ae.getSource().equals(blocks[j]))
							{
								i = j;
								break;
							}
						}
						if((i == 56) || (i == 57) || (i == 58) || (i == 59) || (i == 60) || (i == 61)
								|| (i == 62) || (i == 63))
						{
							String pawnChange = "Queen";
							/*
							PawnSelect pawnselect = new PawnSelect();
							pawnselect.setSize(330, 125);
							pawnselect.setVisible(true);
							
							this.setVisible(false);
							
							while(true)
							{
								if(!(pawnselect.isVisible()))
								{
									pawnChange = pawnselect.pawn.getText();
									pawnselect.dispose();
									this.setVisible(true);
									break;
								}
							}
							*/
							button3.setText(pawnChange);
						}
					}
					
					for(i = 0; i < 64; i ++)
					{
						if(blocks[i].getBackground().equals(Color.blue))
						{
							blocks[i].setText("");
							break;
						}
					}
					setWhiteBlack();
					chessCondition = true;
					
					int count = 0;
					
					for(int k = 0; k < 64; k ++)
					{
						if((blocks[k].getText().equals("King")) && (blocks[k].getForeground().equals(Color.green)))
						{
							count ++;
						}
					}
					
					if(count == 0)
					{
						JOptionPane.showMessageDialog(this, "Player " + this.player2 + " Wins");
						resetTotalGame();
					}
					
					checkMate = greenCheckMate();
					if(checkMate == 0)
					{
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(this, "CheckMate Green King");
						greenKingCheckCount ++;
						return;
					}
			}
			
			else if(c.equals(Color.yellow) && tempCondition == false)
			{
					button3.setText(globalText);
					if(textColorChoice == true)
						button3.setForeground(Color.green);
					else
						button3.setForeground(Color.red);
					for(i = 0; i < 64; i ++)
					{
						if(blocks[i].getBackground().equals(Color.blue))
						{
							blocks[i].setText("");
							break;
						}
					}
					setWhiteBlack();
					chessCondition = true;
					
					if(button3.getText().equals("Pawn"))
					{
						for(j = 0; j < 64; j ++)
						{
							if(ae.getSource().equals(blocks[j]))
							{
								i = j;
								break;
							}
						}
						if((i == 56) || (i == 57) || (i == 58) || (i == 59) || (i == 60) || (i == 61)
								|| (i == 62) || (i == 63))
						{
							String pawnChange = "Queen";
							/*
							PawnSelect pawnselect = new PawnSelect();
							pawnselect.setSize(330, 125);
							pawnselect.setVisible(true);
							
							this.setVisible(false);
							
							while(true)
							{
								if(!(pawnselect.isVisible()))
								{
									pawnChange = pawnselect.pawn.getText();
									pawnselect.dispose();
									this.setVisible(true);
									break;
								}
							}
							*/
							button3.setText(pawnChange);
						}
					}
					
					int count = 0;
					
					for(int k = 0; k < 64; k ++)
					{
						if((blocks[k].getText().equals("King")) && (blocks[k].getForeground().equals(Color.green)))
						{
							count ++;
						}
					}
					
					if(count == 0)
					{
						JOptionPane.showMessageDialog(this, "Player " + this.player2 + " Wins");
						resetTotalGame();
					}
					
					checkMate = greenCheckMate();
					if(checkMate == 0)
					{
						return;
					}
					else
					{
						JOptionPane.showMessageDialog(this, "CheckMate Green King");
						greenKingCheckCount ++;
						return;
					}
			}
			
			//PAWN
			if(ae.getActionCommand().equals("Pawn"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.red))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					redPawn(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = false;
				}
			}
			
			else if(ae.getActionCommand().equals("Elephant"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.red))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					redElephant(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = false;
				}
			}
			
			else if(ae.getActionCommand().equals("Horse"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.red))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					redHorse(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = false;
				}
			}
			
			else if(ae.getActionCommand().equals("Bishop"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.red))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					redBishop(i);				}
				else
				{
					setWhiteBlack();
					chessCondition = false;
				}
			}
			
			else if(ae.getActionCommand().equals("Queen"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.red))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					redQueen(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = false;
				}
			}
			
			else if(ae.getActionCommand().equals("King"))
			{
				button2 = (JButton) ae.getSource();
				if(button2.getForeground().equals(Color.red))
				{
					setWhiteBlack();
					for(j = 0; j < 64; j ++)
					{
						if(ae.getSource().equals(blocks[j]))
						{
							i = j;
							break;
						}
					}
					redKing(i);
				}
				else
				{
					setWhiteBlack();
					chessCondition = false;
				}
			}
			
			else if(ae.getActionCommand().equals(""))
			{
				setWhiteBlack();
				chessCondition = false;
				JButton button = (JButton) ae.getSource();
				button.setBackground(Color.RED);
			}
		}
	}
	
}

public class Chess 
{
	public static void main(String a[])
	{
		UserDetails ud = new UserDetails();
		ud.setBounds(660, 350, 320, 150);
		ud.setVisible(true);
		String name1;
		String name2;
		
		while(true)
		{
			if(ud.isVisible() == false)
			{
				name1 = ud.textField1.getText();
				name2 = ud.textField2.getText();
				break;
			}
		}
		
		ChessGame cg = new ChessGame(name1, name2);
		cg.setSize(600, 600);
		cg.setVisible(true);
		
	}
}