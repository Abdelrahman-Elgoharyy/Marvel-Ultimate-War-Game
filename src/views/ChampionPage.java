package views;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import engine.Game;
import engine.Player;
import model.world.Champion;

public class ChampionPage implements ActionListener , MouseListener{

	JFrame frame;
	JPanel pnl;
	Game g;
	ArrayList<ImageIcon> icons;
	JButton next;
	JButton champ1;
	JButton champ2;
	JButton champ3;
	JButton champ4;
	JButton champ5;
	JButton champ6;
	JButton champ7;
	JButton champ8;
	JButton champ9;
	JButton champ10;
	JButton champ11;
	JButton champ12;
	JButton champ13;
	JButton champ14;
	JButton champ15;
	JButton champ1char;
	JButton champ2char;
	JButton champ3char;
	JButton champ4char;
	JButton champ5char;
	JButton champ6char;
	JButton champ7char;
	JButton champ8char;
	JButton champ9char;
	JButton champ10char;
	JButton champ11char;
	JButton champ12char;
	JButton champ13char;
	JButton champ14char;
	JButton champ15char;
	ArrayList<Champion> firstteam;
	ArrayList<Champion> secondteam;
	JPanel player;
	JPanel merge;
	Player p1;
	Player p2;
	LeaderPage chooseleader;
	JLabel layer1 ;
	JLabel layer2 ;
	JButton choose1;
	JButton choose2;
	JButton choose3;
	JButton choose4;
	JButton choose5;
	JButton choose6;
	JButton choose7;
	JButton choose8;
	JButton choose9;
	JButton choose10;
	JButton choose11;
	JButton choose12;
	JButton choose13;
	JButton choose14;
	JButton choose15;
	ImageIcon captain;
	ImageIcon deadpool;
	ImageIcon strange;
	ImageIcon electro;
	ImageIcon ghost;
	ImageIcon hela;
	ImageIcon hulk;
	ImageIcon iceman;
	ImageIcon ironman;
	ImageIcon loki;
	ImageIcon silver;
	ImageIcon spider;
	ImageIcon thor;
	ImageIcon venom;
	ImageIcon yellow;
	JButton back;
	HomePage backpage;
	
	public ChampionPage() throws IOException {
		
		frame = new JFrame();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setVisible(true);
		frame.setLayout(null);
		frame.setTitle("Marvel Game");
		ImageIcon marvel = new ImageIcon("marvelgame.png");
		frame.setIconImage(marvel.getImage());
		pnl = new JPanel();
		pnl.setBackground(new Color(0,0,70));
		pnl.setBounds(0, 0, 940, 900);
		player = new JPanel();
		player.setBackground(new Color(140,0,0));
		player.setBounds(960,0,700,900);
		merge = new JPanel();
		merge.setBackground(new Color(255,204,0));
		merge.setBounds(940, 0,20 ,900);
		merge.setOpaque(true);
		frame.add(merge);
		frame.add(pnl);
		frame.add(player);
		player.setLayout(null);
		pnl.setLayout(null);
		String firstplayer = JOptionPane.showInputDialog("Enter the name of the first player");
		String secondplayer = JOptionPane.showInputDialog("Enter the name of the second player");
		p1 = new Player(firstplayer);
		p2 = new Player(secondplayer);
		g = new Game(p1 , p2);
		g.loadAbilities("Abilities.csv");
		g.loadChampions("Champions.csv");
		
		
		JLabel first = new JLabel();
		JLabel second = new JLabel();
		first.setText("First Player: " + firstplayer);
		second.setText("Second Player: " + secondplayer);
		first.setFont(new Font("Serif",Font.BOLD,40));
		second.setFont(new Font("Serif",Font.BOLD,40));
		first.setBounds(30,0 , 700, 200);
		second.setBounds(30,350 ,700, 200);
		first.setForeground(Color.white);
		second.setForeground(Color.white);
		player.add(first);
		player.add(second);
		firstteam = new ArrayList<>();
		secondteam = new ArrayList<>();
		
		layer1 = new JLabel();
		layer1.setBounds(0,180, 600, 150);
		layer1.setLayout(new FlowLayout());
		player.add(layer1);
		
		layer2 = new JLabel();
		layer2.setBounds(0,525, 600, 150);
		layer2.setLayout(new FlowLayout());
		player.add(layer2);
		
		
		captain = new ImageIcon(new ImageIcon("captainamerica.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		deadpool = new ImageIcon(new ImageIcon("deadpool.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		strange = new ImageIcon(new ImageIcon("drstrange.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		electro = new ImageIcon(new ImageIcon("electro.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ghost = new ImageIcon(new ImageIcon("ghostrider.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		hela = new ImageIcon(new ImageIcon("hela.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		hulk = new ImageIcon(new ImageIcon("hulk.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		iceman = new ImageIcon(new ImageIcon("iceman.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		ironman = new ImageIcon(new ImageIcon("ironman.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		loki = new ImageIcon(new ImageIcon("loki.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		silver = new ImageIcon(new ImageIcon("quicksilver.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		spider = new ImageIcon(new ImageIcon("spiderman.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		thor = new ImageIcon(new ImageIcon("thor.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		venom = new ImageIcon(new ImageIcon("venom.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		yellow = new ImageIcon(new ImageIcon("yellowjacket.png").getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
		
		
			
			champ1 = new JButton();
			champ1.setText(g.getAvailableChampions().get(0).getName());
			champ1char = new JButton();
			String Details1 = "<html><body>Type: Hero <br>Max HP: " + g.getAvailableChampions().get(0).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(0).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(0).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(0).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(0).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(0).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Shield Throw"+
					"<htm><body>, " + "I can do this all day"+
					"<htm><body>, " + "Shield Up";
			champ1char.setText(Details1);
			champ1char.setBounds(15,10,300,150);
			champ1char.setBackground(Color.white);
			champ1char.setFocusable(false);
			champ1char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ1char.setHorizontalTextPosition(JButton.CENTER);
			champ1char.setVerticalTextPosition(JButton.CENTER);
			champ1char.addMouseListener(this);
			champ1char.setVisible(false);
			pnl.add(champ1char);
			champ1.setBounds(15,10,300,150);
			champ1.setBackground(Color.white);
			champ1.setFocusable(false);
			champ1.setFont(new Font("SansSerif",Font.BOLD,20));;
			//champ1.setIcon(captain);
			champ1.setHorizontalTextPosition(JButton.CENTER);
			champ1.setVerticalTextPosition(JButton.BOTTOM);
			champ1.addMouseListener(this);
			pnl.add(champ1);
			
			champ2 = new JButton();
			champ2char = new JButton();
			String Details2 = "<html><body>Type: AntiHero <br>Max HP: " + g.getAvailableChampions().get(1).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(1).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(1).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(1).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(1).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(1).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Try Harder"+
					"<htm><body>, " + "8 Bullets Left"+
					"<htm><body>, " + "Can't Catch Me";
			champ2char.setText(Details2);
			champ2char.setBounds(320,10,300,150);
			champ2char.setBackground(Color.white);
			champ2char.setFocusable(false);
			champ2char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ2char.setHorizontalTextPosition(JButton.CENTER);
			champ2char.setVerticalTextPosition(JButton.CENTER);
			champ2char.addMouseListener(this);
			champ2char.setVisible(false);
			pnl.add(champ2char);
			champ2.addMouseListener(this);
			champ2.setText(g.getAvailableChampions().get(1).getName());
			champ2.setBounds(320,10,300,150);
			champ2.setBackground(Color.white);
			champ2.setFocusable(false);
			champ2.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ2.setIcon(deadpool);
			champ2.setHorizontalTextPosition(JButton.CENTER);
			champ2.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ2);
			
			champ3 = new JButton();
			champ3char = new JButton();
			String Details3 = "<html><body>Type: Hero <br>Max HP: " +g.getAvailableChampions().get(2).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(2).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(2).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(2).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(2).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(2).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "The Eye of Agamotto"+
					"<htm><body>, " + "Thousand Hand"+
					"<htm><body>, " + "Mirror Dimension";
			champ3char.setText(Details3);
			champ3char.setBounds(625,10,300,150);
			champ3char.setBackground(Color.white);
			champ3char.setFocusable(false);
			champ3char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ3char.setHorizontalTextPosition(JButton.CENTER);
			champ3char.setVerticalTextPosition(JButton.CENTER);
			champ3char.addMouseListener(this);
			champ3char.setVisible(false);
			pnl.add(champ3char);
			champ3.addMouseListener(this);
			champ3.setText(g.getAvailableChampions().get(2).getName());
			champ3.addActionListener(this);
			champ3.setBounds(625,10,300,150);
			champ3.setBackground(Color.white);
			champ3.setFocusable(false);
			champ3.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ3.setIcon(strange);
			champ3.setHorizontalTextPosition(JButton.CENTER);
			champ3.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ3);
			
			champ4 = new JButton();
			champ4char = new JButton();
			String Details4 = "<html><body>Type: Villain <br>Max HP: " +g.getAvailableChampions().get(3).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(3).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(3).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(3).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(3).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(3).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Fully Charged"+
					"<htm><body>, " + "EMP"+
					"<htm><body>, " + "Lightning Strike";
			champ4char.setText(Details4);
			champ4char.setBounds(15,165,300,150);
			champ4char.setBackground(Color.white);
			champ4char.setFocusable(false);
			champ4char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ4char.setHorizontalTextPosition(JButton.CENTER);
			champ4char.setVerticalTextPosition(JButton.CENTER);
			champ4char.addMouseListener(this);
			champ4char.setVisible(false);
			pnl.add(champ4char);
			champ4.addMouseListener(this);
			champ4.setText(g.getAvailableChampions().get(3).getName());
			champ4.addActionListener(this);
			champ4.setBounds(15,165,300,150);
			champ4.setBackground(Color.white);
			champ4.setFocusable(false);
			champ4.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ4.setIcon(electro);
			champ4.setHorizontalTextPosition(JButton.CENTER);
			champ4.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ4);
			
			champ5 = new JButton();
			champ5char = new JButton();
			String Details5 = "<html><body>Type: AntiHero <br>Max HP: " + g.getAvailableChampions().get(4).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(4).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(4).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(4).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(4).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(4).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Death Stare"+
					"<htm><body>, " + "Fire Breath"+
					"<htm><body>, " + "Chain Whip";
			champ5char.setText(Details5);
			champ5char.setBounds(320,165,300,150);
			champ5char.setBackground(Color.white);
			champ5char.setFocusable(false);
			champ5char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ5char.setHorizontalTextPosition(JButton.CENTER);
			champ5char.setVerticalTextPosition(JButton.CENTER);
			champ5char.addMouseListener(this);
			champ5char.setVisible(false);
			pnl.add(champ5char);
			champ5.addMouseListener(this);
			champ5.setText(g.getAvailableChampions().get(4).getName());
			champ5.addActionListener(this);
			champ5.setBounds(320,165,300,150);
			champ5.setBackground(Color.white);
			champ5.setFocusable(false);
			champ5.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ5.setIcon(ghost);
			champ5.setHorizontalTextPosition(JButton.CENTER);
			champ5.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ5);
			
			champ6 = new JButton();
			champ6char = new JButton();
			String Details6 = "<html><body>Type: Villain <br>Max HP: " + g.getAvailableChampions().get(5).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(5).getAttackDamage()+
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(5).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(5).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(5).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(5).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Godess of Death"+
					"<htm><body>, " + "Thorn Shield"+
					"<htm><body>, " + "Thorn Shower";
			champ6char.setText(Details6);
			champ6char.setBounds(625,165,300,150);
			champ6char.setBackground(Color.white);
			champ6char.setFocusable(false);
			champ6char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ6char.setHorizontalTextPosition(JButton.CENTER);
			champ6char.setVerticalTextPosition(JButton.CENTER);
			champ6char.addMouseListener(this);
			champ6char.setVisible(false);
			pnl.add(champ6char);
			champ6.addMouseListener(this);
			champ6.setText(g.getAvailableChampions().get(5).getName());
			champ6.addActionListener(this);
			champ6.setBounds(625,165,300,150);
			champ6.setBackground(Color.white);
			champ6.setFocusable(false);
			champ6.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ6.setIcon(hela);
			champ6.setHorizontalTextPosition(JButton.CENTER);
			champ6.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ6);
			
			champ7 = new JButton();
			champ7char = new JButton();
			String Details7 = "<html><body>Type: Hero <br>Max HP: " + g.getAvailableChampions().get(6).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(6).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(6).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(6).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(6).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(6).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Rage"+
					"<htm><body>, " + "Hulk Smash"+
					"<htm><body>, " + "Sun is getting real low";
			champ7char.setText(Details7);
			champ7char.setBounds(15,320,300,150);
			champ7char.setBackground(Color.white);
			champ7char.setFocusable(false);
			champ7char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ7char.setHorizontalTextPosition(JButton.CENTER);
			champ7char.setVerticalTextPosition(JButton.CENTER);
			champ7char.addMouseListener(this);
			champ7char.setVisible(false);
			pnl.add(champ7char);
			champ7.addMouseListener(this);
			champ7.setText(g.getAvailableChampions().get(6).getName());
			champ7.addActionListener(this);
			champ7.setBounds(15,320,300,150);
			champ7.setBackground(Color.white);
			champ7.setFocusable(false);
			champ7.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ7.setIcon(hulk);
			champ7.setHorizontalTextPosition(JButton.CENTER);
			champ7.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ7);
			
			champ8 = new JButton();
			champ8char = new JButton();
			String Details8 = "<html><body>Type: Hero <br>Max HP: " + g.getAvailableChampions().get(7).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(7).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(7).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(7).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(7).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(7).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Frost Bite"+
					"<htm><body>, " + "SubZero"+
					"<htm><body>, " + "Hail Storm";
			champ8char.setText(Details8);
			champ8char.setBounds(320,320,300,150);
			champ8char.setBackground(Color.white);
			champ8char.setFocusable(false);
			champ8char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ8char.setHorizontalTextPosition(JButton.CENTER);
			champ8char.setVerticalTextPosition(JButton.CENTER);
			champ8char.addMouseListener(this);
			champ8char.setVisible(false);
			pnl.add(champ8char);
			champ8.addMouseListener(this);
			champ8.setText(g.getAvailableChampions().get(7).getName());
			champ8.addActionListener(this);
			champ8.setBounds(320,320,300,150);
			champ8.setBackground(Color.white);
			champ8.setFocusable(false);
			champ8.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ8.setIcon(iceman);
			champ8.setHorizontalTextPosition(JButton.CENTER);
			champ8.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ8);
			
			champ9 = new JButton();
			champ9char = new JButton();
			String Details9 = "<html><body>Type: Hero <br>Max HP: " + g.getAvailableChampions().get(8).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(8).getAttackDamage()+
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(8).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(8).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(8).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(8).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Iam Ironman"+
					"<htm><body>, " + "Unibeam"+
					"<htm><body>, " + "3000";
			champ9char.setText(Details9);
			champ9char.setBounds(625,320,300,150);
			champ9char.setBackground(Color.white);
			champ9char.setFocusable(false);
			champ9char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ9char.setHorizontalTextPosition(JButton.CENTER);
			champ9char.setVerticalTextPosition(JButton.CENTER);
			champ9char.addMouseListener(this);
			champ9char.setVisible(false);
			pnl.add(champ9char);
			champ9.addMouseListener(this);
			champ9.setText(g.getAvailableChampions().get(8).getName());
			champ9.addActionListener(this);
			champ9.setBounds(625,320,300,150);
			champ9.setBackground(Color.white);
			champ9.setFocusable(false);
			champ9.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ9.setIcon(ironman);
			champ9.setHorizontalTextPosition(JButton.CENTER);
			champ9.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ9);
			
			champ10 = new JButton();
			champ10char = new JButton();
			String Details10 = "<html><body>Type: Villain <br>Max HP: " + g.getAvailableChampions().get(9).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(9).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(9).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(9).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(9).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(9).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "God of Mischief"+
					"<htm><body>, " + "The Hidden Dagger"+
					"<htm><body>, " + "Fake Death";
			champ10char.setText(Details10);
			champ10char.setBounds(15,475,300,150);
			champ10char.setBackground(Color.white);
			champ10char.setFocusable(false);
			champ10char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ10char.setHorizontalTextPosition(JButton.CENTER);
			champ10char.setVerticalTextPosition(JButton.CENTER);
			champ10char.addMouseListener(this);
			champ10char.setVisible(false);
			pnl.add(champ10char);
			champ10.addMouseListener(this);
			champ10.setText(g.getAvailableChampions().get(9).getName());
			champ10.addActionListener(this);
			champ10.setBounds(15,475,300,150);
			champ10.setBackground(Color.white);
			champ10.setFocusable(false);
			champ10.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ10.setIcon(loki);
			champ10.setHorizontalTextPosition(JButton.CENTER);
			champ10.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ10);
			
			champ11 = new JButton();
			champ11char = new JButton();
			String Details11 = "<html><body>Type: Villain <br>Max HP: " + g.getAvailableChampions().get(10).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(10).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(10).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(10).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(10).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(10).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Time in a Bottle"+
					"<htm><body>, " + "Good as New"+
					"<htm><body>, " + "1 Sec 100 Punch";
			champ11char.setText(Details11);
			champ11char.setBounds(320,475,300,150);
			champ11char.setBackground(Color.white);
			champ11char.setFocusable(false);
			champ11char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ11char.setHorizontalTextPosition(JButton.CENTER);
			champ11char.setVerticalTextPosition(JButton.CENTER);
			champ11char.addMouseListener(this);
			champ11char.setVisible(false);
			pnl.add(champ11char);
			champ11.addMouseListener(this);
			champ11.setText(g.getAvailableChampions().get(10).getName());
			champ11.addActionListener(this);
			champ11.setBounds(320,475,300,150);
			champ11.setBackground(Color.white);
			champ11.setFocusable(false);
			champ11.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ11.setIcon(silver);
			champ11.setHorizontalTextPosition(JButton.CENTER);
			champ11.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ11);
			
			champ12 = new JButton();
			champ12char = new JButton();
			String Details12 = "<html><body>Type: Hero <br>Max HP: " +  g.getAvailableChampions().get(11).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(11).getAttackDamage()+
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(11).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(11).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(11).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(11).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Give me that"+
					"<htm><body>, " + "Web Trap"+
					"<htm><body>, " + "SpiderVerse";
			champ12char.setText(Details12);
			champ12char.setBounds(625,475,300,150);
			champ12char.setBackground(Color.white);
			champ12char.setFocusable(false);
			champ12char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ12char.setHorizontalTextPosition(JButton.CENTER);
			champ12char.setVerticalTextPosition(JButton.CENTER);
			champ12char.addMouseListener(this);
			champ12char.setVisible(false);
			pnl.add(champ12char);
			champ12.addMouseListener(this);
			champ12.setText(g.getAvailableChampions().get(11).getName());
			champ12.addActionListener(this);
			champ12.setBounds(625,475,300,150);
			champ12.setBackground(Color.white);
			champ12.setFocusable(false);
			champ12.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ12.setIcon(spider);
			champ12.setHorizontalTextPosition(JButton.CENTER);
			champ12.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ12);
			
			champ13 = new JButton();
			champ13char = new JButton();
			String Details13 = "<html><body>Type: Hero <br>Max HP: " + g.getAvailableChampions().get(12).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(12).getAttackDamage() +
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(12).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(12).getSpeed() +"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(12).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(12).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "God of Thunder"+
					"<htm><body>, " + "Mjollnir Throw"+
					"<htm><body>, " + "Bring Me Thanos";
			champ13char.setText(Details13);
			champ13char.setBounds(15,630,300,150);
			champ13char.setBackground(Color.white);
			champ13char.setFocusable(false);
			champ13char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ13char.setHorizontalTextPosition(JButton.CENTER);
			champ13char.setVerticalTextPosition(JButton.CENTER);
			champ13char.addMouseListener(this);
			champ13char.setVisible(false);
			pnl.add(champ13char);
			champ13.addMouseListener(this);
			champ13.setText(g.getAvailableChampions().get(12).getName());
			champ13.addActionListener(this);
			champ13.setBounds(15,630,300,150);
			champ13.setBackground(Color.white);
			champ13.setFocusable(false);
			champ13.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ13.setIcon(thor);
			champ13.setHorizontalTextPosition(JButton.CENTER);
			champ13.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ13);
			
			champ14 = new JButton();
			champ14char = new JButton();
			String Details14 = "<html><body>Type: AntiHero <br>Max HP: "+  g.getAvailableChampions().get(13).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(13).getAttackDamage()+
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(13).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(13).getSpeed() +"<htm><body><br>Mana: "+
					g.getAvailableChampions().get(13).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(13).getMaxActionPointsPerTurn()+ 
					"<htm><body><br>Abilities: " + "Head Bite"+
					"<htm><body>, " + "We Are Venom"+
					"<htm><body>, " + "Symbiosis";
			champ14char.setText(Details14);
			champ14char.setBounds(320,630,300,150);
			champ14char.setBackground(Color.white);
			champ14char.setFocusable(false);
			champ14char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ14char.setHorizontalTextPosition(JButton.CENTER);
			champ14char.setVerticalTextPosition(JButton.CENTER);
			champ14char.addMouseListener(this);
			champ14char.setVisible(false);
			pnl.add(champ14char);
			champ14.addMouseListener(this);
			champ14.setText(g.getAvailableChampions().get(13).getName());
			champ14.addActionListener(this);
			champ14.setBounds(320,630,300,150);
			champ14.setBackground(Color.white);
			champ14.setFocusable(false);
			champ14.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ14.setIcon(venom);
			champ14.setHorizontalTextPosition(JButton.CENTER);
			champ14.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ14);
			
			champ15 = new JButton();
			champ15char = new JButton();
			String Details15 = "<html><body>Type: Villain <br>Max HP: " + g.getAvailableChampions().get(14).getMaxHP() +
					"<htm><body><br>Attack Damage: " + g.getAvailableChampions().get(14).getAttackDamage()+
					"<htm><body><br>Attack Range: "+ g.getAvailableChampions().get(14).getAttackRange() +
					"<htm><body><br>Speed: " + g.getAvailableChampions().get(14).getSpeed()+"<htm><body><br>Mana: "+
							g.getAvailableChampions().get(14).getMana()+"<htm><body><br>Max AP: "+
					g.getAvailableChampions().get(14).getMaxActionPointsPerTurn()+  
					"<htm><body><br>Abilities: " + "Laser Sting"+
					"<htm><body>, " + "QuANTaMANia"+
					"<htm><body>, " + "Pym Particle Upsize";
			champ15char.setText(Details15);
			champ15char.setBounds(625,630,300,150);
			champ15char.setBackground(Color.white);
			champ15char.setFocusable(false);
			champ15char.setFont(new Font("SansSerif",Font.BOLD,12));;
			champ15char.setHorizontalTextPosition(JButton.CENTER);
			champ15char.setVerticalTextPosition(JButton.CENTER);
			champ15char.addMouseListener(this);
			champ15char.setVisible(false);
			pnl.add(champ15char);
			champ15.addMouseListener(this);
			champ15.setText(g.getAvailableChampions().get(14).getName());
			champ15.addActionListener(this);
			champ15.setBounds(625,630,300,150);
			champ15.setBackground(Color.white);
			champ15.setFocusable(false);
			champ15.setFont(new Font("SansSerif",Font.BOLD,20));;
			champ15.setIcon(yellow);
			champ15.setHorizontalTextPosition(JButton.CENTER);
			champ15.setVerticalTextPosition(JButton.BOTTOM);
			pnl.add(champ15);
			
			next = new JButton("Next");
			next.setBackground(new Color(255,205,0));
			next.setFocusable(false);
			next.setFont(new Font(null,Font.BOLD,35));
			next.setBorderPainted(true);
			next.setForeground(Color.black);
			next.setBounds(380, 740, 200, 50);
			player.add(next);
			next.addMouseListener(this);
			
			back = new JButton("Return");
			back.setBackground(new Color(255,205,0));
			back.setForeground(Color.black);
			back.setFocusable(false);
			back.setFont(new Font(null,Font.BOLD,35));
			back.setBounds(5,740,200,50);
			back.addMouseListener(this);
			player.add(back); 
			
			frame.revalidate();
			frame.repaint();
			
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		
	}


	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(firstteam.size()<3) { 
		if(e.getSource()==champ1char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(0)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(0));
			champ1char.setEnabled(false);
			champ1.setEnabled(false);
			choose1 = new JButton();
			choose1.setPreferredSize(new Dimension(150,150));
			choose1.setFocusable(false);
			choose1.setIcon(captain);
			choose1.setBackground(Color.white);
			layer1.add(choose1);
			}
		}
		if(e.getSource()==champ2char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(1)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(1));
			champ2char.setEnabled(false);
			champ2.setEnabled(false);
			choose2 = new JButton();
			choose2.setPreferredSize(new Dimension(150,150));
			choose2.setFocusable(false);
			choose2.setIcon(deadpool);
			choose2.setBackground(Color.white);
			layer1.add(choose2);
			}
		}
		if(e.getSource()==champ3char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(2)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(2));
			champ3char.setEnabled(false);
			champ3.setEnabled(false);
			choose3 = new JButton();
			choose3.setPreferredSize(new Dimension(150,150));
			choose3.setFocusable(false);
			choose3.setIcon(strange);
			choose3.setBackground(Color.white);
			layer1.add(choose3);
			}
		}
		if(e.getSource()==champ4char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(3)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(3));
			champ4char.setEnabled(false);
			champ4.setEnabled(false);
			choose4 = new JButton();
			choose4.setPreferredSize(new Dimension(150,150));
			choose4.setFocusable(false);
			choose4.setIcon(electro);
			choose4.setBackground(Color.white);
			layer1.add(choose4);
			}
			
		}
		if(e.getSource()==champ5char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(4)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else { 
			firstteam.add(g.getAvailableChampions().get(4));
			champ5char.setEnabled(false);
			champ5.setEnabled(false);
			choose5 = new JButton();
			choose5.setPreferredSize(new Dimension(150,150));
			choose5.setFocusable(false);
			choose5.setIcon(ghost);
			choose5.setBackground(Color.white);
			layer1.add(choose5);
			}
		}
		if(e.getSource()==champ6char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(5)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(5));
			champ6char.setEnabled(false);
			champ6.setEnabled(false);
			choose6 = new JButton();
			choose6.setPreferredSize(new Dimension(150,150));
			choose6.setFocusable(false);
			choose6.setIcon(hela);
			choose6.setBackground(Color.white);
			layer1.add(choose6);
			}
		}
		if(e.getSource()==champ7char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(6)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(6));
			champ7char.setEnabled(false);
			champ7.setEnabled(false);
			choose7 = new JButton();
			choose7.setPreferredSize(new Dimension(150,150));
			choose7.setFocusable(false);
			choose7.setIcon(hulk);
			choose7.setBackground(Color.white);
			layer1.add(choose7);
			}
		}
		if(e.getSource()==champ8char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(7)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(7));
			champ8char.setEnabled(false);
			champ8.setEnabled(false);
			choose8 = new JButton();
			choose8.setPreferredSize(new Dimension(150,150));
			choose8.setFocusable(false);
			choose8.setIcon(iceman);
			choose8.setBackground(Color.white);
			layer1.add(choose8);
			}
		}
		if(e.getSource()==champ9char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(8)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(8));
			champ9char.setEnabled(false);
			champ9.setEnabled(false);
			choose9 = new JButton();
			choose9.setPreferredSize(new Dimension(150,150));
			choose9.setFocusable(false);
			choose9.setIcon(ironman);
			choose9.setBackground(Color.white);
			layer1.add(choose9);
			}
		}
		if(e.getSource()==champ10char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(9)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(9));
			champ10char.setEnabled(false);
			champ10.setEnabled(false);
			choose10 = new JButton();
			choose10.setPreferredSize(new Dimension(150,150));
			choose10.setFocusable(false);
			choose10.setIcon(loki);
			choose10.setBackground(Color.white);
			layer1.add(choose10);
			}
		}
		if(e.getSource()==champ11char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(10)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(10));
			champ11char.setEnabled(false);
			champ11.setEnabled(false);
			choose11 = new JButton();
			choose11.setPreferredSize(new Dimension(150,150));
			choose11.setFocusable(false);
			choose11.setIcon(silver);
			choose11.setBackground(Color.white);
			layer1.add(choose11);
			}
		}
		if(e.getSource()==champ12char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(11)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(11));
			champ12char.setEnabled(false);
			champ12.setEnabled(false);
			choose12 = new JButton();
			choose12.setPreferredSize(new Dimension(150,150));
			choose12.setFocusable(false);
			choose12.setIcon(spider);
			choose12.setBackground(Color.white);
			layer1.add(choose12);
			}
		}
		if(e.getSource()==champ13char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(12)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(12));
			champ13char.setEnabled(false);
			champ13.setEnabled(false);
			choose13 = new JButton();
			choose13.setPreferredSize(new Dimension(150,150));
			choose13.setFocusable(false);
			choose13.setIcon(thor);
			choose13.setBackground(Color.white);
			layer1.add(choose13);
			}
		}
		if(e.getSource()==champ14char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(13)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(13));
			champ14char.setEnabled(false);
			champ14.setEnabled(false);
			choose14 = new JButton();
			choose14.setPreferredSize(new Dimension(150,150));
			choose14.setFocusable(false);
			choose14.setIcon(venom);
			choose14.setBackground(Color.white);
			layer1.add(choose14);
			}
		}
		if(e.getSource()==champ15char)
		{
			if(firstteam.contains(g.getAvailableChampions().get(14)))
			{
				JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
			}
			else {
			firstteam.add(g.getAvailableChampions().get(14));
			champ15char.setEnabled(false);
			champ15.setEnabled(false);
			choose15 = new JButton();
			choose15.setPreferredSize(new Dimension(150,150));
			choose15.setFocusable(false);
			choose15.setIcon(yellow);
			choose15.setBackground(Color.white);
			layer1.add(choose15);
			}
		}
		}
		else {
			if(e.getSource()==champ1char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(0)) || firstteam.contains(g.getAvailableChampions().get(0)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(0));
					champ1char.setEnabled(false);
					champ1.setEnabled(false);
					choose1 = new JButton();
					choose1.setPreferredSize(new Dimension(150,150));
					choose1.setFocusable(false);
					choose1.setIcon(captain);
					choose1.setBackground(Color.white);
					layer2.add(choose1);
				}
			}
			if(e.getSource()==champ2char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(1)) || firstteam.contains(g.getAvailableChampions().get(1)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(1));
					champ2char.setEnabled(false);
					champ2.setEnabled(false);
					choose2 = new JButton();
					choose2.setPreferredSize(new Dimension(150,150));
					choose2.setFocusable(false);
					choose2.setIcon(deadpool);
					choose2.setBackground(Color.white);
					layer2.add(choose2);
				}
			}
			if(e.getSource()==champ3char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(2)) || firstteam.contains(g.getAvailableChampions().get(2)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(2));
					champ3char.setEnabled(false);
					champ3.setEnabled(false);
					choose3 = new JButton();
					choose3.setPreferredSize(new Dimension(150,150));
					choose3.setFocusable(false);
					choose3.setIcon(strange);
					choose3.setBackground(Color.white);
					layer2.add(choose3);
				}
			}
			if(e.getSource()==champ4char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(3)) || firstteam.contains(g.getAvailableChampions().get(3)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(3));
					champ4char.setEnabled(false);
					champ4.setEnabled(false);
					choose4 = new JButton();
					choose4.setPreferredSize(new Dimension(150,150));
					choose4.setFocusable(false);
					choose4.setIcon(electro);
					choose4.setBackground(Color.white);
					layer2.add(choose4);
				}
			}
			if(e.getSource()==champ5char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(4)) || firstteam.contains(g.getAvailableChampions().get(4)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(4));
					champ5char.setEnabled(false);
					champ5.setEnabled(false);
					choose5 = new JButton();
					choose5.setPreferredSize(new Dimension(150,150));
					choose5.setFocusable(false);
					choose5.setIcon(ghost);
					choose5.setBackground(Color.white);
					layer2.add(choose5);
				}
				}
			if(e.getSource()==champ6char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(5)) || firstteam.contains(g.getAvailableChampions().get(5)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(5));
					champ6char.setEnabled(false);
					champ6.setEnabled(false);
					choose6 = new JButton();
					choose6.setPreferredSize(new Dimension(150,150));
					choose6.setFocusable(false);
					choose6.setIcon(hela);
					choose6.setBackground(Color.white);
					layer2.add(choose6);
				}
			}
			if(e.getSource()==champ7char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(6)) || firstteam.contains(g.getAvailableChampions().get(6)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(6));
					champ7char.setEnabled(false);
					champ7.setEnabled(false);
					choose7 = new JButton();
					choose7.setPreferredSize(new Dimension(150,150));
					choose7.setFocusable(false);
					choose7.setIcon(hulk);
					choose7.setBackground(Color.white);
					layer2.add(choose7);
				}
			}
			if(e.getSource()==champ8char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(7)) || firstteam.contains(g.getAvailableChampions().get(7)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(7));
					champ8char.setEnabled(false);
					champ8.setEnabled(false);
					choose8 = new JButton();
					choose8.setPreferredSize(new Dimension(150,150));
					choose8.setFocusable(false);
					choose8.setIcon(iceman);
					choose8.setBackground(Color.white);
					layer2.add(choose8);
				}
				}
			if(e.getSource()==champ9char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(8)) || firstteam.contains(g.getAvailableChampions().get(8)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(8));
					champ9char.setEnabled(false);
					champ9.setEnabled(false);
					choose9 = new JButton();
					choose9.setPreferredSize(new Dimension(150,150));
					choose9.setFocusable(false);
					choose9.setIcon(ironman);
					choose9.setBackground(Color.white);
					layer2.add(choose9);
				}
			}
			if(e.getSource()==champ10char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(9)) || firstteam.contains(g.getAvailableChampions().get(9)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(9));
					champ10char.setEnabled(false);
					champ10.setEnabled(false);
					choose10 = new JButton();
					choose10.setPreferredSize(new Dimension(150,150));
					choose10.setFocusable(false);
					choose10.setIcon(loki);
					choose10.setBackground(Color.white);
					layer2.add(choose10);
				}
			}
			if(e.getSource()==champ11char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(10)) || firstteam.contains(g.getAvailableChampions().get(10)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(10));
					champ11char.setEnabled(false);
					champ11.setEnabled(false);
					choose11 = new JButton();
					choose11.setPreferredSize(new Dimension(150,150));
					choose11.setFocusable(false);
					choose11.setIcon(silver);
					choose11.setBackground(Color.white);
					layer2.add(choose11);
				}
			}
			if(e.getSource()==champ12char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(11)) || firstteam.contains(g.getAvailableChampions().get(11)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
					secondteam.add(g.getAvailableChampions().get(11));
					champ12char.setEnabled(false);
					champ12.setEnabled(false);
					choose12 = new JButton();
					choose12.setPreferredSize(new Dimension(150,150));
					choose12.setFocusable(false);
					choose12.setIcon(spider);
					choose12.setBackground(Color.white);
					layer2.add(choose12);
				}
			}
			if(e.getSource()==champ13char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(12)) || firstteam.contains(g.getAvailableChampions().get(12)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
				secondteam.add(g.getAvailableChampions().get(12));
				champ13char.setEnabled(false);
				champ13.setEnabled(false);
				choose13 = new JButton();
				choose13.setPreferredSize(new Dimension(150,150));
				choose13.setFocusable(false);
				choose13.setIcon(thor);
				choose13.setBackground(Color.white);
				layer2.add(choose13);
				}
			}
			if(e.getSource()==champ14char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(13)) || firstteam.contains(g.getAvailableChampions().get(13)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
				secondteam.add(g.getAvailableChampions().get(13));
				champ14char.setEnabled(false);
				champ14.setEnabled(false);
				choose14 = new JButton();
				choose14.setPreferredSize(new Dimension(150,150));
				choose14.setFocusable(false);
				choose14.setIcon(venom);
				choose14.setBackground(Color.white);
				layer2.add(choose14);
				}
			}
			if(e.getSource()==champ15char)
			{
				if(secondteam.contains(g.getAvailableChampions().get(14)) || firstteam.contains(g.getAvailableChampions().get(14)))
				{
					JOptionPane.showMessageDialog(null, "A champion can not be chosen twice");
				}
				else {
				secondteam.add(g.getAvailableChampions().get(14));
				champ15char.setEnabled(false);
				champ15.setEnabled(false);
				choose15 = new JButton();
				choose15.setPreferredSize(new Dimension(150,150));
				choose15.setFocusable(false);
				choose15.setIcon(yellow);
				choose15.setBackground(Color.white);
				layer2.add(choose15);
				}
				}
			
			
			
		}
		
		if(e.getSource()==next) {
			if(firstteam.size()==3 && secondteam.size()==3)
			{
			frame.dispose();
			for(int i=0 ; i<firstteam.size() ; i++) {
				p1.getTeam().add(firstteam.get(i));
				p2.getTeam().add(secondteam.get(i));
			}
			chooseleader = new LeaderPage(p1, p2);
			}
			else 
				JOptionPane.showMessageDialog(null, "You need to choose the rest of the Champions");

		}
		if(e.getSource()==back)
		{
			frame.dispose();
			backpage=new HomePage();
		}
		
	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		
		
		if(e.getSource()==champ1)
		{
			champ1.setVisible(false);
			champ1char.setVisible(true);
		}
		if(e.getSource()==champ2)
		{
			champ2.setVisible(false);
			champ2char.setVisible(true);
		}
		if(e.getSource()==champ3)
		{
			champ3.setVisible(false);
			champ3char.setVisible(true);
		}
		if(e.getSource()==champ4)
		{
			champ4.setVisible(false);
			champ4char.setVisible(true);
		}
		if(e.getSource()==champ5)
		{
			champ5.setVisible(false);
			champ5char.setVisible(true);
		}
		if(e.getSource()==champ6)
		{
			champ6.setVisible(false);
			champ6char.setVisible(true);
		}
		if(e.getSource()==champ7)
		{
			champ7.setVisible(false);
			champ7char.setVisible(true);
		}
		if(e.getSource()==champ8)
		{
			champ8.setVisible(false);
			champ8char.setVisible(true);
		}
		if(e.getSource()==champ9)
		{
			champ9.setVisible(false);
			champ9char.setVisible(true);
		}
		if(e.getSource()==champ10)
		{
			champ10.setVisible(false);
			champ10char.setVisible(true);
		}
		if(e.getSource()==champ11)
		{
			champ11.setVisible(false);
			champ11char.setVisible(true);
		}
		if(e.getSource()==champ12)
		{
			champ12.setVisible(false);
			champ12char.setVisible(true);
		}
		if(e.getSource()==champ13)
		{
			champ13.setVisible(false);
			champ13char.setVisible(true);
		}
		if(e.getSource()==champ14)
		{
			champ14.setVisible(false);
			champ14char.setVisible(true);
		}
		if(e.getSource()==champ15)
		{
			champ15.setVisible(false);
			champ15char.setVisible(true);
		}
	}


	@Override
	public void mouseExited(MouseEvent e) {

		if(e.getSource()==champ1char)
		{
			champ1.setVisible(true);
			champ1char.setVisible(false);
		}
		if(e.getSource()==champ2char)
		{
			champ2.setVisible(true);
			champ2char.setVisible(false);
		}
		if(e.getSource()==champ3char)
		{
			champ3.setVisible(true);
			champ3char.setVisible(false);
		}
		if(e.getSource()==champ4char)
		{
			champ4.setVisible(true);
			champ4char.setVisible(false);
		}
		if(e.getSource()==champ5char)
		{
			champ5.setVisible(true);
			champ5char.setVisible(false);
		}
		if(e.getSource()==champ6char)
		{
			champ6.setVisible(true);
			champ6char.setVisible(false);
		}
		if(e.getSource()==champ7char)
		{
			champ7.setVisible(true);
			champ7char.setVisible(false);
		}
		if(e.getSource()==champ8char)
		{
			champ8.setVisible(true);
			champ8char.setVisible(false);
		}
		if(e.getSource()==champ9char)
		{
			champ9.setVisible(true);
			champ9char.setVisible(false);
		}
		if(e.getSource()==champ10char)
		{
			champ10.setVisible(true);
			champ10char.setVisible(false);
		}
		if(e.getSource()==champ11char)
		{
			champ11.setVisible(true);
			champ11char.setVisible(false);
		}
		if(e.getSource()==champ12char)
		{
			champ12.setVisible(true);
			champ12char.setVisible(false);
		}
		if(e.getSource()==champ13char)
		{
			champ13.setVisible(true);
			champ13char.setVisible(false);
		}
		if(e.getSource()==champ14char)
		{
			champ14.setVisible(true);
			champ14char.setVisible(false);
		}
		if(e.getSource()==champ15char)
		{
			champ15.setVisible(true);
			champ15char.setVisible(false);
		}
	}


}
