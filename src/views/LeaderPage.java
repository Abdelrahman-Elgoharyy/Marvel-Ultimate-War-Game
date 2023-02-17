package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import engine.Game;
import engine.Player;
import model.world.Champion;
import model.world.Hero;

public class LeaderPage implements ActionListener{

	JFrame frame;
	JPanel background;
	JButton fchamp1;
	JButton fchamp2;
	JButton fchamp3;
	JButton schamp1;
	JButton schamp2;
	JButton schamp3;
	Player firstplayer;
	Player secondplayer;
	JButton next;
	PlayPage play;
	Game g;

	public LeaderPage(Player firstplayer , Player secondplayer) {

		this.g=new Game(firstplayer,secondplayer);
		this.firstplayer = firstplayer;
		this.secondplayer=secondplayer;
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2048,1190);
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setTitle("Marvel Game");
		ImageIcon marvel = new ImageIcon("marvelgame.png");
		frame.setIconImage(marvel.getImage());
		background = new JPanel();
		background.setBackground(new Color(255,204,0));
		background.isMaximumSizeSet();
		frame.add(background);
		background.setLayout(null);;
		JLabel first = new JLabel();
		JLabel second = new JLabel();
		first.setBounds(100,100,400,200);
		second.setBounds(100,300,400,200);
		first.setFont(new Font(null,Font.BOLD,35));
		first.setForeground(Color.black);
		first.setText("First Player: " + firstplayer.getName());
		second.setFont(new Font(null,Font.BOLD,35));
		second.setForeground(Color.black);
		second.setText("Second Player: " + secondplayer.getName());

		fchamp1 = new JButton();
		fchamp1.addActionListener(this);
		fchamp1.setText(firstplayer.getTeam().get(0).getName());
		fchamp1.addActionListener(this);
		fchamp1.setBounds(520,150,300,150);
		fchamp1.setBackground(Color.white);
		fchamp1.setFocusable(false);
		fchamp1.setFont(new Font("SansSerif",Font.BOLD,30));;
		fchamp1.setHorizontalTextPosition(JButton.CENTER);
		fchamp1.setVerticalTextPosition(JButton.BOTTOM);
		background.add(fchamp1);

		fchamp2 = new JButton();
		fchamp2.addActionListener(this);
		fchamp2.setText(firstplayer.getTeam().get(1).getName());
		fchamp2.addActionListener(this);
		fchamp2.setBounds(825,150,300,150);
		fchamp2.setBackground(Color.white);
		fchamp2.setFocusable(false);
		fchamp2.setFont(new Font("SansSerif",Font.BOLD,30));;
		fchamp2.setHorizontalTextPosition(JButton.CENTER);
		fchamp2.setVerticalTextPosition(JButton.BOTTOM);
		background.add(fchamp2);

		fchamp3 = new JButton();
		fchamp3.addActionListener(this);
		fchamp3.setText(firstplayer.getTeam().get(2).getName());
		fchamp3.addActionListener(this);
		fchamp3.setBounds(1130,150,300,150);
		fchamp3.setBackground(Color.white);
		fchamp3.setFocusable(false);
		fchamp3.setFont(new Font("SansSerif",Font.BOLD,30));;
		fchamp3.setHorizontalTextPosition(JButton.CENTER);
		fchamp3.setVerticalTextPosition(JButton.BOTTOM);
		background.add(fchamp3);

		schamp1 = new JButton();
		schamp1.addActionListener(this);
		schamp1.setText(secondplayer.getTeam().get(0).getName());
		schamp1.addActionListener(this);
		schamp1.setBounds(520,350,300,150);
		schamp1.setBackground(Color.white);
		schamp1.setFocusable(false);
		schamp1.setFont(new Font("SansSerif",Font.BOLD,30));;
		schamp1.setHorizontalTextPosition(JButton.CENTER);
		schamp1.setVerticalTextPosition(JButton.BOTTOM);
		background.add(schamp1);

		schamp2 = new JButton();
		schamp2.addActionListener(this);
		schamp2.setText(secondplayer.getTeam().get(1).getName());
		schamp2.addActionListener(this);
		schamp2.setBounds(825,350,300,150);
		schamp2.setBackground(Color.white);
		schamp2.setFocusable(false);
		schamp2.setFont(new Font("SansSerif",Font.BOLD,30));;
		schamp2.setHorizontalTextPosition(JButton.CENTER);
		schamp2.setVerticalTextPosition(JButton.BOTTOM);
		background.add(schamp2);

		schamp3 = new JButton();
		schamp3.addActionListener(this);
		schamp3.setText(secondplayer.getTeam().get(2).getName());
		schamp3.addActionListener(this);
		schamp3.setBounds(1130,350,300,150);
		schamp3.setBackground(Color.white);
		schamp3.setFocusable(false);
		schamp3.setFont(new Font("SansSerif",Font.BOLD,30));;
		schamp3.setHorizontalTextPosition(JButton.CENTER);
		schamp3.setVerticalTextPosition(JButton.BOTTOM);
		background.add(schamp3);

		background.add(first);
		background.add(second);
		
		next = new JButton("Next");
		next.setBackground(Color.white);
		next.setFocusable(false);
		next.setFont(new Font(null,Font.BOLD,35));
		next.setBorderPainted(true);
		next.setBounds(1345, 740, 200, 50);
		background.add(next);
		next.addActionListener(this);
		
		frame.revalidate();
		frame.repaint();

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(firstplayer.getLeader()==null) {

			if(e.getSource()==fchamp1)
			{
				fchamp1.setBorder(BorderFactory.createLineBorder(new Color(0,0,70),10));
				firstplayer.setLeader(firstplayer.getTeam().get(0));
			}
			if(e.getSource()==fchamp2)
			{
				fchamp2.setBorder(BorderFactory.createLineBorder(new Color(0,0,70),10));
				firstplayer.setLeader(firstplayer.getTeam().get(1));
			}
			if(e.getSource()==fchamp3)
			{
				fchamp3.setBorder(BorderFactory.createLineBorder(new Color(0,0,70),10));
				firstplayer.setLeader(firstplayer.getTeam().get(2));
			}
		}
			if(secondplayer.getLeader()==null) {

				if(e.getSource()==schamp1)
				{
					schamp1.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),10));
					secondplayer.setLeader(secondplayer.getTeam().get(0));
				}
				if(e.getSource()==schamp2)
				{
					schamp2.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),10));
					secondplayer.setLeader(secondplayer.getTeam().get(1));
				}
				if(e.getSource()==schamp3)
				{
					schamp3.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),10));
					secondplayer.setLeader(secondplayer.getTeam().get(2));
				}
			

		}
		
		if(e.getSource()==next) {
			if(firstplayer.getLeader()==null || secondplayer.getLeader()==null)
			{
				JOptionPane.showMessageDialog(null, "You need to choose the Leaders");
			}
			else 
			{
				frame.dispose();
				try {
					play = new PlayPage(g ,firstplayer,secondplayer);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		
		
	}

}
