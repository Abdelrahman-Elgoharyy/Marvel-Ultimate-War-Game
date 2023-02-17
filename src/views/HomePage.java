package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage implements ActionListener{

	JFrame frame;
	JLabel label;
	ImageIcon image;
	JButton quit;
	JButton game;
	JButton credits;
	JButton howtoplay;
	Credits credit;
	ChampionPage load;
	
	
	public HomePage() {
		
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2048,1190);
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Marvel Game");
		ImageIcon marvel = new ImageIcon("marvelgame.png");
		frame.setIconImage(marvel.getImage());
		image = new ImageIcon("marvel.jpg");
		label = new JLabel();
		label.setLayout(null);
		label.setIcon(image);
		frame.add(label,BorderLayout.CENTER);
		frame.setVisible(true);
		label.setLayout(null);
		
		game = new JButton ("New Game");
		game.setFocusable(false);
		game.setFont(new Font ("Serif", Font.BOLD, 20));
		game.setBounds(650,250,200,70);
		game.setBackground(new Color(0,0,50));
		game.setForeground(Color.white);
		label.add(game);
		quit = new JButton ("Quit Game");
		quit.setFocusable(false);
		quit.setFont(new Font ("Serif", Font.BOLD, 20));
		quit.setBounds(650,550,200,70);
		quit.setBackground(new Color(0,0,50));
		quit.setForeground(Color.white);
		label.add(quit);
		credits = new JButton ("Credits");
		credits.setFocusable(false);
		credits.setFont(new Font ("Serif", Font.BOLD, 20));
		credits.setBounds(650,450,200,70);
		credits.setBackground(new Color(0,0,50));
		credits.setForeground(Color.white);
		label.add(credits);
		howtoplay = new JButton ("How To Play");
		howtoplay.setFocusable(false);
		howtoplay.setFont(new Font ("Serif", Font.BOLD, 20));
		howtoplay.setBounds(650,350,200,70);
		howtoplay.setBackground(new Color(0,0,50));
		howtoplay.setForeground(Color.white);
		label.add(howtoplay);
		quit.addActionListener(this);
		game.addActionListener(this);
		howtoplay.addActionListener(this);
		credits.addActionListener(this);

		frame.revalidate();
		frame.repaint();
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==quit)
		{
			frame.dispose();
		}
		
		if(e.getSource()==credits)
		{
			frame.dispose();
			credit = new Credits();
		}
		if(e.getSource()==game)
		{
			frame.dispose();
			try {
				load = new ChampionPage();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
		
		
	}
	
}
