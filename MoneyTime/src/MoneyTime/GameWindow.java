package MoneyTime;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class GameWindow implements ActionListener {

	Random random = new Random();final Audio audio = new Audio();
	JLabel copyRight;JLabel L100;JLabel L200;JLabel L300;JLabel L500;JLabel L1000;JLabel L2000;JLabel L4000;
	JLabel L8000;JLabel L16000;JLabel L32000;JLabel L64000;JLabel L125000;JLabel L250000;JLabel L500000;
	JLabel L1000000;JLabel LC;JLabel LA;JLabel QuestionLabel;JLabel lblmistakeCounter;JLabel LD;JLabel LB;
	JButton answerButtonOne;JButton answerButtonTwo;JButton answerButtonThree;JButton answerButtonFour;	

	final JButton RockPaperScissor;
	final JButton FiftyFifty;
	final JButton Audience;
	final JButton oneUpQuestion;

	public GameWindow(final JFrame frame) {

		//JlabelArray holds all the labels used in the class to allow the following for loops to print the labels using less repetitive code.
		JLabel[] JlabelArray = new JLabel[22];
		copyRight = new JLabel("@FirasAltayeb");JlabelArray[0]=copyRight;
		L100 = new JLabel("100\u00A3");JlabelArray[1]=L100;
		L200 = new JLabel("200\u00A3");JlabelArray[2]=L200;
		L300 = new JLabel("300\u00A3");JlabelArray[3]=L300;
		L500 = new JLabel("500\u00A3");JlabelArray[4]=L500;
		L1000 = new JLabel("1000\u00A3");JlabelArray[5]=L1000;
		L2000 = new JLabel("2000\u00A3");JlabelArray[6]=L2000;
		L4000 = new JLabel("4000\u00A3");JlabelArray[7]=L4000;
		L8000 = new JLabel("8000\u00A3");JlabelArray[8]=L8000;
		L16000 = new JLabel("16000\u00A3");JlabelArray[9]=L16000;
		L32000 = new JLabel("32000\u00A3");JlabelArray[10]=L32000;
		L64000 = new JLabel("64000\u00A3");JlabelArray[11]=L64000;
		L125000 = new JLabel("125000\u00A3");JlabelArray[12]=L125000;
		L250000 = new JLabel("250000\u00A3");JlabelArray[13]=L250000;
		L500000 = new JLabel("500000\u00A3");JlabelArray[14]=L500000;
		L1000000 = new JLabel("1000000\u00A3");JlabelArray[15]=L1000000;
		LC= new JLabel("c.");JlabelArray[16]=LC;
		LA = new JLabel("a.");JlabelArray[17]=LA;
		QuestionLabel = new JLabel(Utility.currentQuestion);JlabelArray[18]=QuestionLabel;
		lblmistakeCounter = new JLabel("MISTAKE COUNTER = 5 ");JlabelArray[19]=lblmistakeCounter;
		LD = new JLabel("d.");JlabelArray[20]=LD;
		LB = new JLabel("b.");JlabelArray[21]=LB;

		int yAxis = 250;
		int xAxis;
		//the following for loop prints the first 16 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=0;i<=16;i++) {	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
			JlabelArray[i].setForeground(Color.RED);
			JlabelArray[i].setBounds(0, yAxis, 500, 500);
			frame.getContentPane().add(JlabelArray[i]);
			yAxis-=30;

		}

		yAxis=200;
		xAxis=250;
		//the following for loop prints the last 5 labels in the JlabelArray with the same font and foreground but with different bounds.
		for(int i=16;i<=21;i++) {	
			JlabelArray[i].setFont(new Font("Tahoma", Font.BOLD| Font.ITALIC, 20));
			JlabelArray[i].setForeground(Color.WHITE);
			JlabelArray[i].setBounds(xAxis, yAxis, 800, 500);
			frame.getContentPane().add(JlabelArray[i]);
			yAxis-=120;
			if(i==19){yAxis=200; xAxis = 600;}	
		}

		//------------------------ Answer buttons variables  ------------------------------------------------

		answerButtonOne = new JButton(Utility.answerOptionArray[0]);
		answerButtonTwo = new JButton(Utility.answerOptionArray[1]);
		answerButtonThree = new JButton(Utility.answerOptionArray[2]);
		answerButtonFour = new JButton(Utility.answerOptionArray[3]);

		//JButtonArray holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray = new JButton[4];
		JButtonArray[0] = answerButtonOne;
		JButtonArray[1] = answerButtonTwo;
		JButtonArray[2] = answerButtonThree;
		JButtonArray[3] = answerButtonFour;	

		yAxis=430;
		xAxis=280;
		//the following for loop prints the buttons in the JButtonArray with the same background,foreground  and font but with different bounds.
		for(int i=0;i<=3;i++) {
			JButtonArray[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray[i].setBounds(xAxis, yAxis, 300, 50);
			JButtonArray[i].setForeground(Color.BLACK);
			JButtonArray[i].setBackground(Color.RED);
			frame.getContentPane().add(JButtonArray[i]);
			if(i==0){xAxis=640;}
			if(i==1){xAxis=280; yAxis=300;}
			if(i==2){xAxis=640;}

		}

		answerButtonOne.addActionListener(this);
		answerButtonTwo.addActionListener(this);
		answerButtonThree.addActionListener(this);
		answerButtonFour.addActionListener(this);

		//------------------------------  Extra buttons -----------------------------------------------------

		RockPaperScissor = new JButton("Rock.Paper.Scissor");
		FiftyFifty = new JButton("50/50");
		Audience = new JButton("Audience");
		oneUpQuestion = new JButton("1-UP Question");

		//JButtonArray2 holds the four similar buttons mentioned above to allow the following for loops to print the buttons using less repetitive code.
		JButton[] JButtonArray2 = new JButton[4];
		JButtonArray2[0] = RockPaperScissor;
		JButtonArray2[1] = FiftyFifty;
		JButtonArray2[2] = Audience;
		JButtonArray2[3] = oneUpQuestion;

		xAxis=0;
		//the following for loop prints the buttons in the JButtonArray2 with the same background and foreground but with different bounds.
		for(int i=0;i<=3;i++){
			JButtonArray2[i].setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
			JButtonArray2[i].setBounds(xAxis, 0, 250, 30);
			frame.getContentPane().add(JButtonArray2[i]);
			xAxis+=250;
		}

		RockPaperScissor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				audio.cameraSound4();
				new RockPaperScissor(answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour);
				RockPaperScissor.setEnabled(false);
			}
		});

		/*disables two wrong answer's buttons,after the button is used the button becomes disabled*/
		FiftyFifty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				audio.cameraSound2();
				if (answerButtonOne.getText().equals(Utility.correctAnswer))
				{
					answerButtonTwo.setEnabled(false);
					answerButtonFour.setEnabled(false);
				}

				else if (answerButtonTwo.getText().equals(Utility.correctAnswer))
				{
					answerButtonThree.setEnabled(false);
					answerButtonOne.setEnabled(false);
				}

				else if (answerButtonThree.getText().equals(Utility.correctAnswer))
				{
					answerButtonTwo.setEnabled(false);
					answerButtonFour.setEnabled(false);
				}

				else if(answerButtonFour.getText().equals(Utility.correctAnswer))
				{
					answerButtonOne.setEnabled(false);
					answerButtonTwo.setEnabled(false);
				}

				FiftyFifty.setEnabled(false);
			}
		});

		/*The Audience actions button opens a new frame with a chart indicating the possible answer,
		  if the player has not reached the eighth question yet the chart has a 75% chance of providing
		  the correct answer and if the player has passed the eighth question the chart has a 50%
		  chance of providing the correct answer */
		Audience.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{	
				audio.chargeSound();
				JFrame AudienceFrame = new JFrame();
				AudienceFrame.setSize(700, 500);
				AudienceFrame.setVisible(true);
				double[] values = new double[4];
				String[] names = new String[4];
				names[0] = "A";
				names[1] = "B";
				names[2] = "C";
				names[3] = "D";
				if(Utility.questionCounter<=8)
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(Utility.correctAnswer.equals(Utility.answerOptionArray[0]))
					{
						values[0] += 3;
					}
					else if(Utility.correctAnswer.equals(Utility.answerOptionArray[1]))
					{
						values[1] += 3;
					}
					else if(Utility.correctAnswer.equals(Utility.answerOptionArray[2]))
					{
						values[2] += 3;
					}
					else
					{
						values[3] += 3;
					}

				}
				else 
				{
					values[0] = random.nextInt(5);
					values[1] = random.nextInt(5);
					values[2] = random.nextInt(5);
					values[3] = random.nextInt(5);

					if(Utility.correctAnswer.equals(Utility.answerOptionArray[0]))
					{
						values[0] += 2;
					}
					else if(Utility.correctAnswer.equals(Utility.answerOptionArray[1]))
					{
						values[1] += 2;
					}
					else if(Utility.correctAnswer.equals(Utility.answerOptionArray[2]))
					{
						values[2] += 2;
					}
					else 
					{
						values[3] += 2;
					}

				}
				AudienceFrame.getContentPane().add(new AudienceFrame(values, names, "Audience"));
				Audience.setEnabled(false);
			}
		});


		oneUpQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent q) 
			{
				answerButtonOne.setEnabled(true);
				answerButtonTwo.setEnabled(true);
				answerButtonThree.setEnabled(true);
				answerButtonFour.setEnabled(true);
				audio.cameraSound1();
				Utility.oneUpQuestion(answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				oneUpQuestion.setEnabled(false);

			}
		});


		/*JLabel img = new JLabel( new ImageIcon("WM2.jpg"));
		img.setBounds(0, 0, 1900, 1100);
		frame.getContentPane().add(img);*/
		//pictureLabel stores the background picture of the game and prints it.
		JLabel pictureLabel = new JLabel(""); 
		Image img = new ImageIcon(this.getClass().getResource("/offlineM.jpg")).getImage(); 
		pictureLabel.setIcon(new ImageIcon(img)); 
		pictureLabel.setBounds(0, 0, 1000, 1000); 
		frame.getContentPane().add(pictureLabel); 


		//-------------------------- JMenuBar --------------------------------------------------------------

		JMenuBar menuBar = new JMenuBar();

		JMenu difficulty = new JMenu("Difficulty");
		difficulty.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		difficulty.setMnemonic(KeyEvent.VK_A);

		JMenu help = new JMenu("Help");
		help.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		help.setMnemonic(KeyEvent.VK_A);

		JMenu quit = new JMenu("Quit");
		quit.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 25));
		quit.setMnemonic(KeyEvent.VK_A);

		JMenuItem easy = new JMenuItem("easy");
		JMenuItem hard = new JMenuItem("Hard");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem information = new JMenuItem("Information");
		JMenuItem exit = new JMenuItem("Exit");
		JMenuItem collect = new JMenuItem("Collect Cash");
		JMenuItem[] JMenuItemArray = new JMenuItem[6];
		JMenuItemArray[0] = easy;
		JMenuItemArray[1] = hard;
		JMenuItemArray[2] = restart;
		JMenuItemArray[3] = information;
		JMenuItemArray[4] = exit;
		JMenuItemArray[5] = collect;

		for(int i=0;i<=5;i++){
			JMenuItemArray[i].setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 20));
			JMenuItemArray[i].setAccelerator(KeyStroke.getKeyStroke
					(KeyEvent.VK_1,ActionEvent.ALT_MASK));	
		}

		easy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame(10);
			}

		});

		hard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame(3);
			}

		});

		restart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0)
			{
				restartGame(5);
			}

		});

		// Opens the user's browser to a URL page which shows general information about the game.
		information.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				try
				{
					Desktop.getDesktop().browse(new URL("https://en.wikipedia.org/wiki/Who_Wants_to_Be_a_Millionaire%3F").toURI());
				}
				catch(Exception e)
				{}
			}

		});

		/*When exit is clicked the game promotes a frame asking the user if he wants to quit or not
		if the user chose yes the game will close and if the user chose no nothing will happen.*/
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				audio.buzzerSound2();
				Object[] options = { "YES", "NO" };
				int optionButton = JOptionPane.showOptionDialog(frame,
						"Are you sure you wish to quit?", null,
						JOptionPane.PLAIN_MESSAGE,
						JOptionPane.QUESTION_MESSAGE, null, options,
						options[1]);

				if (optionButton == JOptionPane.YES_OPTION) {System.exit(0);}

			}
		});

		// Allows the user to exit the game with the current amount of money the user has gained using questionCounter
		collect.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0)
			{
				if(Utility.questionCounter >= 1) {
					audio.applauseSound2();
					switch (Utility.questionCounter){
					case 1:	JOptionPane.showMessageDialog(null, "You won 100�");System.exit(0);
					case 2:	JOptionPane.showMessageDialog(null, "You won 200�");System.exit(0);
					case 3:	JOptionPane.showMessageDialog(null, "You won 300�");System.exit(0);
					case 4: JOptionPane.showMessageDialog(null, "You won 500�");System.exit(0);
					case 5:	JOptionPane.showMessageDialog(null, "You won 1000�");System.exit(0);
					case 6:	JOptionPane.showMessageDialog(null, "You won 2000�");System.exit(0);
					case 7:	JOptionPane.showMessageDialog(null, "You won 4000�");System.exit(0);
					case 8:	JOptionPane.showMessageDialog(null, "You won 8000�");System.exit(0);
					case 9:	JOptionPane.showMessageDialog(null, "You won 16000�");System.exit(0);
					case 10: JOptionPane.showMessageDialog(null, "You won 32000�");System.exit(0);
					case 11: JOptionPane.showMessageDialog(null, "You won 64000�");System.exit(0);
					case 12: JOptionPane.showMessageDialog(null, "You won 125000�");System.exit(0);
					case 13: JOptionPane.showMessageDialog(null, "You won 250000�");System.exit(0);
					case 14: JOptionPane.showMessageDialog(null, "You won 500000�");System.exit(0);	
					case 15: JOptionPane.showMessageDialog(null, "You won 1000000�");System.exit(0);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "You have no cash to collect");
				}
			}
		});

		difficulty.add(easy);
		difficulty.add(hard);
		help.add(restart);
		help.add(information);
		quit.add(collect);
		quit.add(exit);
		menuBar.add(difficulty);
		menuBar.add(help);
		menuBar.add(quit);
		frame.setJMenuBar(menuBar);
		frame.pack();
	}

	/*This action compares the calling button text with the correctAnswer by using both "e.getActionCommand()" and ".equals" methods,
	  if oneUp is set as true and the user correctly answers the current question the user gains an attempt by increasing his mistakeCounter 
	  and then all the labels foreground turn yellow by using the ".colorChanger" method after that a new question with it's answers are fetched 
	  using the ".newQuestion" method and oneUp is set as false to allow the game to run normally. when oneUp is set as false and the user correctly 
	  answers the current question all the labels foreground turn yellow by using the ".colorChanger" method and then a new question with 
	  it's answers are fetched using the ".newQuestion" method and the questionCounter is increased to indicate the clearing of the level.
 	  if the answer within the calling button does not equals the correct answer mistakeCounter is decreased to indicate the decrease in 
 	  attempts and then the ".mistakeAdujster" method rewrite the label to match the remaining attempts number. */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals(Utility.correctAnswer)) {
			if(Utility.oneUpQus) {
				Utility.mistakeCounter++;
				lblmistakeCounter.setText("MISTAKE COUNTER = " + Utility.mistakeCounter);
				int randNum = Utility.colorChanger("yellow",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				Utility.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
				Utility.oneUpQus = false;
			}
			else {
				Utility.questionCounter++;		
				int randNum = Utility.colorChanger("yellow",L100, L200, L300, L500,
						L1000, L2000, L4000, L8000, L16000, L32000
						,L64000,L125000,L250000, L500000, L1000000);
				Utility.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);}
		}
		else {
			audio.losingSound();
			Utility.mistakeCounter--;
			lblmistakeCounter.setText("MISTAKE COUNTER = " + Utility.mistakeCounter);
			if(Utility.mistakeCounter == 0){
				JOptionPane.showMessageDialog(null, "You have reached the maxium amount of mistakes");
				audio.buzzerSound2();
				restartGame(5);
			} 
		}
	}

	public void restartGame(int counter) {
		Utility.mistakeCounter = counter;
		Utility.questionCounter = 0;
		int randNum = Utility.colorChanger("red",L100, L200, L300, L500,
				L1000, L2000, L4000, L8000, L16000, L32000
				,L64000,L125000,L250000, L500000, L1000000);
		Utility.newQuestion(randNum,answerButtonOne,answerButtonTwo,answerButtonThree,answerButtonFour,QuestionLabel);
		lblmistakeCounter.setText("MISTAKE COUNTER = " + counter);
		FiftyFifty.setEnabled(true);
		Audience.setEnabled(true);
		oneUpQuestion.setEnabled(true);
		RockPaperScissor.setEnabled(true);
	}
}