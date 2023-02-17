package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.DomainCombiner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import engine.Player;

public class OverPage implements ActionListener{
	JFrame frame;
	JButton quit;
	public OverPage(Player p) {
	
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2048,1190);
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setTitle("Marvel Game");
		frame.setVisible(true);
		ImageIcon marvel = new ImageIcon("marvelgame.png");
		frame.setIconImage(marvel.getImage());
		frame.setLayout(new BorderLayout());
		JLabel label = new JLabel("The Winner is " + p.getName() );
		label.setBackground(new Color(140,0,0));
		label.setFont(new Font("MV Boli",Font.BOLD,80));
		label.setForeground(new Color(0,0,70));
		label.setLayout(null);
		label.setPreferredSize(new Dimension(1000,1000));
		label.setOpaque(true);
		label.setHorizontalAlignment(JLabel.CENTER);
		label.setVerticalAlignment(JLabel.CENTER);
		frame.add(label);
		
		quit = new JButton("Quit Game");
		quit.setBounds(690,700,150,50);
		quit.setFocusable(false);
		quit.setFont(new Font("Serif",Font.BOLD,20));
		quit.setBackground(new Color(255,205,0));
		quit.addActionListener(this);
		label.add(quit,JLabel.CENTER);
		
		frame.revalidate();
		frame.repaint();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==quit)
			frame.dispose();
		   new HomePage();
	}
	
	
}
