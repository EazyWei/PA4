package cen4010.pa4;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class GUI extends JFrame {
Board b;
JFrame Frame;
JLabel timeDisplay1;
JLabel timeDisplay2;
Boolean game_started=false;
Boolean game_stopped=false;
public static int StartingTime=60;
public static int player1time=StartingTime;
public static int player2time=StartingTime;
JPanel TopPanel = new JPanel();
JButton [][] buttons;
DefaultTheme DTheme = new DefaultTheme();

DarkMode DarkMode;
BlueMode BlueMode;
CursedMode CursedMode;
String X = "X";
String O = "O";
	  
	  
	  
		  //player 1 timer
		  Timer timer1 = new Timer(1000, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  if (getPlayer_1()!=null&& game_started) { 
		    	  if (player1time>0)
		          {
		      
		    		  
		    		
		    		  player1time--;
			          timeDisplay1.setText(player1time+"");
			          repaint();
			          
			          
			          if (getPlayer_1().isRobot && Board.turn_number==1)
			          {
			        	  if(getPlayer_1().isRobot) {
			        		  int[] temp;
			        		  temp = getPlayer_1().getMove('x');
				        		
				        		 
								Board.gameboard[temp[0]][temp[1]]='x';
				        		 Board.turn_number++;
			        		 }
			          }
			          
			          //Check to see if board space is occupied and update the board (repaint)
			          for (int i = 0; i<Board.m; i++) {
			      		for (int j = 0; j<Board.n;j++) {
			      			if(Board.gameboard[i][j]=='x') {
			      				//System.out.print("x");
			      				 buttons[i][j].setText(X);
				        		 buttons[i][j].setFont(new Font("Montserrat", Font.BOLD, 42));	
				        		 buttons[i][j].revalidate();
				        		 buttons[i][j].repaint();
			      			}
			      			if(Board.gameboard[i][j]=='o') {
			      				//System.out.print("o");
			      				 buttons[i][j].setText(O);
				        		 buttons[i][j].setFont(new Font("Montserrat", Font.BOLD, 42));
				        		 buttons[i][j].revalidate();
				        		 buttons[i][j].repaint();
			      			}
			      			
			      			
			      			}
			      		}
			          TopPanel.revalidate();
			          TopPanel.repaint();
			          
		    	  }
		          }
		     }
		  });
		  
		  
		  //player 2 timer
		  Timer timer2 = new Timer(1000, new ActionListener() {
		      @Override
		      public void actionPerformed(ActionEvent e) {
		    	  if (player2time>0)
		          {
		      
		    		  player2time--;
		    		  
			          timeDisplay2.setText(player2time+"");
			          repaint();
			          //Check to see if board space is occupied and update the board (repaint)
 
			          for (int i = 0; i<Board.m; i++) {
				      		for (int j = 0; j<Board.n;j++) {
				      			if(Board.gameboard[i][j]=='x') {
				      				//System.out.print("x");
				      				 buttons[i][j].setText(X);
					        		 buttons[i][j].setFont(new Font("Montserrat", Font.BOLD, 42));	
					        		 buttons[i][j].revalidate();
					        		 buttons[i][j].repaint();
				      			}
				      			if(Board.gameboard[i][j]=='o') {
				      				//System.out.print("o");
				      				 buttons[i][j].setText(O);
					        		 buttons[i][j].setFont(new Font("Montserrat", Font.BOLD, 42));	
					        		 buttons[i][j].revalidate();
					        		 buttons[i][j].repaint();
				      			}
				      			
				      			
				      			}
				      		}
				          //TopPanel.revalidate();
				          //TopPanel.repaint();
		    	  }
		      }
		  });


public GUI() {
	Color boardBackgroundColor = DTheme.getBoardBackgroundColor();;
	Color elementColor = DTheme.getElementColor();
	Color textColor = DTheme.getTextColor();
	Color paneColor = DTheme.getPanelBackgroundColor();
	
	int [] dimmensionArray = setUpPopup();
	int m = dimmensionArray[0];
	int n = dimmensionArray[1];
	int k = dimmensionArray[2];
	
	
	
	/******************Frame Settings************************/
	if(getDarkMode() != null) {
		DarkMode DarkMode = getDarkMode();
		boardBackgroundColor = DarkMode.getBoardBackgroundColor();
		elementColor = DarkMode.getElementColor();
		textColor = DarkMode.getTextColor();
		paneColor = DarkMode.getPanelBackgroundColor();
	}
	if(getBlueMode() != null) {
		BlueMode BlueMode = getBlueMode();
		boardBackgroundColor = BlueMode.getBoardBackgroundColor();
		elementColor = BlueMode.getElementColor();
		textColor = BlueMode.getTextColor();
		paneColor = BlueMode.getPanelBackgroundColor();
	}

	if(getCursedMode() != null) {
		CursedMode CursedMode = getCursedMode();
		boardBackgroundColor = CursedMode.getBoardBackgroundColor();
		elementColor = CursedMode.getElementColor();
		textColor = CursedMode.getTextColor();
		paneColor = CursedMode.getPanelBackgroundColor();
		X = CursedMode.getX();
		O = CursedMode.getO();
	}
	
	
	Frame=new JFrame();
	String pathToFileOnDisk="TicTacToe.png";
	ImageIcon img = new ImageIcon(pathToFileOnDisk);
	Frame.setIconImage(img.getImage());
	Frame.setTitle("Tic Tac Toe");
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
	int height = screenSize.height;
	int width = screenSize.width;
	Frame.setResizable(false);
	Frame.setLayout(new GridLayout(2, 1));
	Frame.setSize((int)(width*.75),(int)(height*.75));
	Frame.setLocationRelativeTo(null);
	Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	/******************End Frame Settings************************/
	
	
	
	
	/******************Board Instantiation************************/
	
	
	//ensure k is doable
	try {
		if(k > m && k > n)
			k = Math.min(m, n);
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	Board.createBoard(m, n, k);
	buttons= new JButton[Board.m][Board.n];
	/******************End Board Instantiation************************/
	
	
	/******************Top Panel************************/
	
	TopPanel.setLayout(new GridLayout(Board.m,Board.n,10,10));
	TopPanel.setBackground(boardBackgroundColor);
	TopPanel.setPreferredSize(new Dimension(100,100));
	
	for (int i = 0; i<Board.m; i++) {
		for (int j = 0; j<Board.n;j++) {
			buttons[i][j]=new JButton();
			buttons[i][j].setBackground(elementColor);
			buttons[i][j].setForeground(textColor);

			buttons[i][j].setOpaque(true);
			buttons[i][j].setBorderPainted(false);
			buttons[i][j].setFocusPainted(false);
			TopPanel.add(buttons[i][j]);
			
			//variables are reassigned to fix scope issue
			int o=i;
			int l=j;
			//defines a new function that will be performed when the button is pressed
			ActionListener ButtonAL=new ActionListener() {
		         public void actionPerformed(ActionEvent e) {
		        	 
		        	 
		        	 
		        	 if (Board.gameboard[o][l]==0 && game_started) {
		        		
		        		System.out.println(Board.turn_number); 
		        		 
		        		 
		        		//if turn is odd, place an x	 
		        	 if (Board.turn_number%2==1) {
		        		 if (getPlayer_1().isRobot && Board.turn_number!=1) {
		        		 
		        			 
		        			 int[] temp;
		        			 temp = getPlayer_1().getMove('x');
				        		
		        			 buttons[temp[0]][temp[1]].setText(X);
			        		 buttons[temp[0]][temp[1]].setFont(new Font("Montserrat", Font.BOLD, 42));
			        		 Board.gameboard[temp[0]][temp[1]]='x';
			        		 
		        		 }else {
		        			 buttons[o][l].setText(X);
			        		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
			        		 Board.gameboard[o][l]='x';
			
		        		 
		        		 }
		        		 Board.turn_number++;
		        		 
		        		 
		        		 
		          	
	        		 if (Board.playerWin('x')) {
	        			 for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
	        			 }
	        			 PopupWin("1");
	        			 game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();
			         	}
		        		 
		        		 
		        		 
		        		 
		        		 
		        		 timer1.stop();
		        		 timer2.start();
		        		 
		        		 
		        		// if player2 is a robot... do turn... increment turn number
		        		 if (!Board.gameDraw()) {				         		
				         		
		        		 
		        		
				         if (getPlayer_2().isRobot()) {
				        	 int[] xy;
				        	 xy = getPlayer_2().getMove('o');
				        		
			        		 int x= xy[0];
				     		 int y= xy[1];
				     		 buttons[x][y].setText(O);
				     		 Board.gameboard[x][y]='o';
				     		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
			        		
			        		 }
		        		 }
		        		 
		        		 //player 1 timeout
		        		 if (player1time==0) {
		        			 for (int i = 0; i<Board.m; i++) {
					        		for (int j = 0; j<Board.n;j++) {
					        			buttons[i][j].setEnabled(false);
					        		}
		        			 }
		        			 PopupWin("-2");
		        			 	game_stopped=true;
				         		timer1.stop();
				        		timer2.stop();

			        		}
		        		 //if game is still going... check if the game is over
		        		 else
		        			 if (Board.playerWin('o')) {
			        			 for (int i = 0; i<Board.m; i++) {
						        		for (int j = 0; j<Board.n;j++) {
						        			buttons[i][j].setEnabled(false);
						        		}
			        			 }
			        			 PopupWin("2");
			        			 game_stopped=true;
					         		timer1.stop();
					        		timer2.stop();
					         	}
		        		 if (Board.playerWin('x')) {
		        			 for (int i = 0; i<Board.m; i++) {
					        		for (int j = 0; j<Board.n;j++) {
					        			buttons[i][j].setEnabled(false);
					        		}
		        			 }
		        			 PopupWin("1");
		        			 game_stopped=true;
				         		timer1.stop();
				        		timer2.stop();
				         	}
		        		 	else if (Board.gameDraw()) {				         		
				         		for (int i = 0; i<Board.m; i++) {
					        		for (int j = 0; j<Board.n;j++) {
					        			buttons[i][j].setEnabled(false);
					        		}
				         		}
				         		PopupWin("0");
				         		game_stopped=true;
				         		timer1.stop();
				        		timer2.stop();
				         	}
				         	
				         	
		        		 if (getPlayer_2().isRobot()) {
			        		    Board.turn_number++;	 
			        		 }
		        	 }
		        	 
		        	 
		        	 //player 2 move
		        	 else {
		        		 if(getPlayer_2().isRobot) {
		        			 int[] temp;
		        			 temp = getPlayer_2().getMove('o');
				        		
		        			 buttons[temp[0]][temp[1]].setText(O);
			        		 buttons[temp[0]][temp[1]].setFont(new Font("Montserrat", Font.BOLD, 42));
			        		 Board.gameboard[temp[0]][temp[1]]='o';
			        		 
		        		 }else {
		        			 buttons[o][l].setText(O);
			        		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
			        		 Board.gameboard[o][l]='o';
			        		 
		        		 }
		        		 Board.turn_number++;
		         	//if player1 is a robot... do turn... increment turn number
		         	
		         	if (getPlayer_1().isRobot()) {
		         		int[] xy;
		         		xy = getPlayer_1().getMove('x');
		        		
	        		 int x= xy[0];
		     		 int y= xy[1];
		     		 buttons[x][y].setText(X);
		     		 Board.gameboard[x][y]='x';
		     		 buttons[o][l].setFont(new Font("Montserrat", Font.BOLD, 42));
		     		//Board.turn_number++;
		         	}
		         	if (Board.playerWin('x')) {
	        			 for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
	        			 }
	        			 PopupWin("1");
	        			 game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();
			         	}
		         	
		         	//(harder AI) loop checking all spaces for a winning combo for either player
		                  	
		         	
		         	 timer2.stop();
	        		 timer1.start();
	        		 //player 2 timeout
	        		 if (player2time==0) {
	        			 for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
	        			 }
	        			 PopupWin("-1");
	        			 game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();

		        		}
	        		 else //this else is to prevent a player from running out of time, then placing a winning move after.
	        		 if (Board.playerWin('o')) {
	        			 for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
	        			 }
	        			 PopupWin("2");
	        			 game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();
			         	}
	        		 	else if (Board.gameDraw()) {				         		
			         		for (int i = 0; i<Board.m; i++) {
				        		for (int j = 0; j<Board.n;j++) {
				        			buttons[i][j].setEnabled(false);
				        		}
			         		}
			         		PopupWin("0");
			         		game_stopped=true;
			         		timer1.stop();
			        		timer2.stop();
			         	}
	        		 	if (getPlayer_1().isRobot()) {
	        		    Board.turn_number++;	 
	        		 }
		        	 }
		        	//Board.turn_number++;
		          }
		         }
		       };
			buttons[i][j].addActionListener(ButtonAL);
	}
	}
	/******************End Top Panel************************/
	
	/******************Bottom Panel************************/
	JPanel BottomPanel = new JPanel();
	BottomPanel.setLayout(new GridLayout(2, 1,50,50));
	//creates border spacing
	Border border2 = BottomPanel.getBorder();
	Border margin2 = new EmptyBorder(10,150,150,150);
	BottomPanel.setBorder(new CompoundBorder(border2, margin2));
	BottomPanel.setBackground(paneColor);
	
	
	
	
	/*Start game and player select panel*/
	JPanel StartGamePanel = new JPanel();
	StartGamePanel.setLayout(new GridLayout(1, 3, 150,10));
	
	String[] player_list = {"Human", "Computer", "Harder Computer"};
	JComboBox<?> PlayerList1 = new JComboBox<Object>(player_list);
	PlayerList1.setFocusable(false);
	PlayerList1.setSelectedIndex(-1);
	
	PlayerList1.setBackground(elementColor);
	PlayerList1.setForeground(textColor);
	JComboBox<?> PlayerList2 = new JComboBox<Object>(player_list);
	PlayerList2.setSelectedIndex(-1);
	PlayerList2.setFocusable(false);
	
	PlayerList2.setBackground(elementColor);
	PlayerList2.setForeground(textColor);
	JButton StartButton = new JButton("Start");
	StartButton.setBackground(elementColor);
	StartButton.setOpaque(true);
	StartButton.setForeground(textColor);
	StartButton.setOpaque(true);
	StartButton.setBorderPainted(false);
	StartButton.setFont(new Font("DIALOG", Font.BOLD, 25));

	BottomPanel.add(PlayerList1);
	BottomPanel.add(StartButton);
	BottomPanel.add(PlayerList2);

	ActionListener StartGameAL = new ActionListener() {
        public void actionPerformed(ActionEvent evt) {
        	if (!game_stopped)
        	 {
        		 timer1.start();
	        	 game_started=true;
        	 }
            
        }
	  };
	  StartButton.addActionListener(StartGameAL);
	
	
	ActionListener PlayerList1_AL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == PlayerList1) {
				AssignPlayer(PlayerList1.getSelectedIndex(), 1);
			}
		}
	};
	PlayerList1.addActionListener(PlayerList1_AL);
	
	ActionListener PlayerList2_AL = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == PlayerList2) {
				AssignPlayer(PlayerList2.getSelectedIndex(), 2);
			}
		}
	};
	PlayerList2.addActionListener(PlayerList2_AL);
	
	
	//add the player select and game start buttons to the bottom half of the screen
	StartGamePanel.setBackground(paneColor);
	BottomPanel.add(StartGamePanel);
	/*End start game and player select panel*/
	
	
	
	/*Timer Panel*/
  	JPanel TimerPanel = new JPanel();
  	TimerPanel.setLayout(new GridLayout(1, 2,50,10));
  	TimerPanel.setBackground(paneColor);
  	
  	//Time display for player 1
    timeDisplay1=new JLabel(StartingTime+"");
   
    timeDisplay1.setHorizontalAlignment(SwingConstants.CENTER);
    timeDisplay1.setFont(new Font("DIALOG", Font.BOLD, 28));
    timeDisplay1.setForeground(textColor);
    timeDisplay1.setBackground(elementColor);
    timeDisplay1.setOpaque(true);
    
    //Time display for player 2
    timeDisplay2=new JLabel(StartingTime+"");
    
    timeDisplay2.setHorizontalAlignment(SwingConstants.CENTER);
    timeDisplay2.setFont(new Font("DIALOG", Font.BOLD, 28));
    timeDisplay2.setForeground(textColor);
    timeDisplay2.setBackground(elementColor);
    timeDisplay2.setOpaque(true);
    
    TimerPanel.add(timeDisplay1);
    TimerPanel.add(timeDisplay2);
    BottomPanel.add(TimerPanel);
    /*End Timer Panel*/
    /******************End Bottom Panel************************/
	
	
	
	
	
	
	
	
	
	
	
	
	//set visible
	Frame.add(TopPanel);
	Frame.add(BottomPanel);
	Frame.setVisible(true);
	
	}//end constructor


	/**
	 * Creates a scuffed dimmension popup
	 * @return a 2 long array with dimmensions for the gameboard and a 3rd position for k
	 * TODO: check to make sure the textboxes only take integers
	 */

	
	//****Players****//
	private Player Player_1;
	private Player Player_2;
	
	
	private void setPlayer_1(Player p) {
		this.Player_1 = p;
	}
	private void setPlayer_2(Player p) {
		this.Player_2 = p;
	}
	private Player getPlayer_1() {
		return this.Player_1;
	}
	private Player getPlayer_2() {
		return this.Player_2;
	}
	//0 human, 1 computer, 2 harder computer
	private void AssignPlayer(int player_type,int player_index) {
		if(player_type == 0) {
			if(player_index == 1) {
				Player p = new Player(false);
				setPlayer_1(p);
			}
			if(player_index == 2) {
				Player p = new Player(false);
				setPlayer_2(p);
			}
		}
		else if(player_type == 1 || player_type==2) {
			Player p = new Player(true);
			if (player_type==2) {
				p.setHarderRobot();
			}
		
			if(player_index == 1) {
			
				setPlayer_1(p);
			}
			if(player_index == 2) {
			
				setPlayer_2(p);
			}
		
			
	}
	}
	//**********************//
	
	
	
	//****Popup Win Frame****//
	private void PopupWin(String player) {
		
		//****FRAME****//
		Frame = new JFrame("Congratulations!");
		
		Frame.setSize(400,200);
		Frame.setResizable(false);
		Frame.setLocationRelativeTo(null);
		Frame.setLayout(new GridLayout(1, 1));
		String pathToFileOnDisk="TicTacToe.png";
		ImageIcon img = new ImageIcon(pathToFileOnDisk);
		Frame.setIconImage(img.getImage());
		//****TEXT LABEL****//
	
		JLabel Text = new JLabel();
		//Text.setBounds(0, 100, 400, 100);
		Text.setHorizontalAlignment(SwingConstants.CENTER);
		Text.setFont(new Font("DIALOG", Font.BOLD, 14));
		
		
		if (player.equals("-2")) {
			Frame.setTitle("Too slow...");
			Text.setText("Player 1 ran out of time... Player 2 wins!");
		}
		else
		if (player.equals("-1")) {
			Frame.setTitle("Too slow...");
			Text.setText("Player 2 ran out of time... Player 1 wins!");
		}
		else
		if (player.equals("0")) {
			Frame.setTitle("Game Over...");
			Text.setText("The game has drawn.");
		}
		else {
		Text.setText("Congratulations, player \"" + player + "\" has won!");
		}
		//****RESET BUTTON****//
		JButton ResetButton = new JButton();
		ResetButton.setBounds(150, 100, 100, 20);
		ResetButton.setFont(new Font("DIALOG", Font.BOLD, 15));
		ResetButton.setText("RESET");
		ResetButton.setFocusPainted(false);
		ResetButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	 Frame.dispose();
	        	 //GUI g= new GUI();
	        	 // DO RESET
	          }
	        
	       });
		
		//****DRAW FRAME****//
		Frame.add(Text);
		//Frame.add(ResetButton);
		Frame.setVisible(true);
	}
	//**********************// TODO: fix this prompt
	public int[] setUpPopup() {
		int m = 3;
		int n = 3; 
		int k = 3;
		
		
		//****FRAME****//
		JFrame Popup = new JFrame("Game setup");
		String pathToFileOnDisk="TicTacToe.png";
		ImageIcon img = new ImageIcon(pathToFileOnDisk);
		
		String[] themeOptions = {"Default", "Blue Mode", "Dark Mode", "Cursed Mode"};
		JComboBox<String> themeDropDown = new JComboBox<>(themeOptions);
		themeDropDown.setSelectedIndex(0);
		
		
		
		
		Popup.setIconImage(img.getImage());
		Popup.setSize(400,200);
		Popup.setResizable(false);
		Popup.setLocationRelativeTo(null);
		Popup.setLayout(null);
		
		
		//****Text Fields****//
		JTextField mField = new JTextField(1);
		JTextField nField = new JTextField(1);
		JTextField kField = new JTextField(1);
		JLabel themeLabel = new JLabel("Theme:");
		JLabel mLabel = new JLabel("M:");
		JLabel nLabel = new JLabel("N:");
		JLabel kLabel = new JLabel("K:");
		themeLabel.setBounds(0, 10, 150, 20);
		themeLabel.setFont(new Font("DIALOG", Font.BOLD, 15));
		themeLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		mLabel.setBounds(0, 40, 150, 20);
		mLabel.setFont(new Font("DIALOG", Font.BOLD, 15));
		mLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		nLabel.setBounds(0, 70, 150, 20);
		nLabel.setFont(new Font("DIALOG", Font.BOLD, 15));
		nLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		kLabel.setBounds(0, 100, 150, 20);
		kLabel.setFont(new Font("DIALOG", Font.BOLD, 15));
		kLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		
		themeDropDown.setBounds(160, 10, 200, 20);
		
		mField.setBounds(160, 40, 200, 20);
		
		nField.setBounds(160, 70, 200, 20);
		
		kField.setBounds(160, 100, 200, 20);
		
		JButton submitButton = new JButton();
		submitButton.setBounds(130, 130, 150, 20);
		submitButton.setFont(new Font("DIALOG", Font.BOLD, 15));
		submitButton.setText("Submit");
		submitButton.setFocusPainted(false);
		submitButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	
	        	 Popup.dispose();
	        	 //GUI g= new GUI();
	        	 // DO RESET
	          }
	       	        
	       });
		
		
		themeDropDown.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	        	if(themeDropDown.getSelectedIndex() == 0 || themeDropDown.getSelectedIndex() == 3) {
		        		Popup.getContentPane().setBackground(null);
		        		themeLabel.setForeground(null);
		        		mLabel.setForeground(null);
		        		nLabel.setForeground(null);
		        		kLabel.setForeground(null);
		        		if(themeDropDown.getSelectedIndex() == 0) {
		        			submitButton.setText("Submit");
		        		}
		        		if(themeDropDown.getSelectedIndex() == 3) {
		        			submitButton.setText("OH NO...");
		        		}
		     	}
	        	 
	        	if(themeDropDown.getSelectedIndex() == 1) {
	        		Popup.getContentPane().setBackground(new Color(0, 37, 108));
	        		themeLabel.setForeground(new Color(250,250,250));
	        		mLabel.setForeground(new Color(250,250,250));
	        		nLabel.setForeground(new Color(250,250,250));
	        		kLabel.setForeground(new Color(250,250,250));
	     		}
	        	if(themeDropDown.getSelectedIndex() == 2) {
	        		Popup.getContentPane().setBackground(new Color(30, 30, 30));
	        		themeLabel.setForeground(new Color(250,250,250));
	        		mLabel.setForeground(new Color(250,250,250));
	        		nLabel.setForeground(new Color(250,250,250));
	        		kLabel.setForeground(new Color(250,250,250));
	     		}
	          }
	       	        
	    });
		
		Popup.add(themeLabel);
		Popup.add(themeDropDown);
		
		 Popup.add(mLabel);
     	 Popup.add(mField);
     	 
     	Popup.add(nLabel);
     	 Popup.add(nField);
     	
     	 
    	 
    	 Popup.add(kLabel);
    	 Popup.add(kField);
     	 Popup.add(submitButton);
     	 
     	 Popup.setVisible(true);
     	 while(Popup.isDisplayable()) {
     		 try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
     	 }
     	 try {
			m = Integer.valueOf(mField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			m = 3;
		}
     	 try {
			n = Integer.valueOf(nField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			n = 3;
		}
     	 try {
			k = Integer.valueOf(kField.getText());
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			k = 3;
		}
     	
		int dimmensionArray[] = {m,n,k};
		
		if(themeDropDown.getSelectedIndex() == 1) {
			createBlueMode();
		}
		
		if(themeDropDown.getSelectedIndex() == 2) {
			createDarkMode();
		}
		if(themeDropDown.getSelectedIndex() == 3) {
			createCursedMode();
		}
		
		return dimmensionArray;
	}
	
	private void createBlueMode() {
		this.BlueMode = new BlueMode();
	}
	private BlueMode getBlueMode() {
		return this.BlueMode;
	}
	
	private void createDarkMode() {
		this.DarkMode = new DarkMode();
	}
	private DarkMode getDarkMode() {
		return this.DarkMode;
	}

	private void createCursedMode() {
		this.CursedMode = new CursedMode();
	}
	private CursedMode getCursedMode() {
		return this.CursedMode;
	}
}

