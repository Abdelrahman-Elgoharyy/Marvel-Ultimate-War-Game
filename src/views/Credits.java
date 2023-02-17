package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class Credits implements ActionListener{

	JFrame frame;
	JLabel text;
	JButton back;
	HomePage home;
	
	public Credits () {
		
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(new Color(0,0,70));
		text = new JLabel("<html><body>Welcome<br>We are a group of MET students at GUC<br>We designed this game as a CSEN401 course's project<br>We hope you like and enjoy it <br><br>Team 118 :<br>Adham Khaled<br>Abdelrahman Elgouhary<br>Abdallah Bahaa</body></html>", SwingConstants.CENTER);
		text.setFont(new Font("Serif",Font.BOLD,40));
		text.setForeground(Color.white);
		frame.add(text , BorderLayout.CENTER);
		frame.setVisible(true);
		back = new JButton("return");
		text.setBorder(null);
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.setFocusable(false);
		back.setFont(new Font(null,Font.PLAIN,20));
		back.setBounds(0,0,90,20);
		text.add(back);
		back.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==back)
		{
			frame.dispose();
			home = new HomePage();
		}
		
	}
	
}
