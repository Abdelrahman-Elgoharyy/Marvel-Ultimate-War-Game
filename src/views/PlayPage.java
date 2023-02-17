package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import engine.Game;
import engine.Player;
import engine.PriorityQueue;
import exceptions.AbilityUseException;
import exceptions.ChampionDisarmedException;
import exceptions.InvalidTargetException;
import exceptions.LeaderAbilityAlreadyUsedException;
import exceptions.LeaderNotCurrentException;
import exceptions.NotEnoughResourcesException;
import exceptions.UnallowedMovementException;
import model.abilities.Ability;
import model.abilities.AreaOfEffect;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.world.AntiHero;
import model.world.Champion;
import model.world.Cover;
import model.world.Damageable;
import model.world.Direction;
import model.world.Hero;
import model.world.Villain;

public class PlayPage implements ActionListener{

	JFrame frame;
	JPanel grid;
	JPanel player1;
	JPanel player2;
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	JLabel l9;
	JLabel l10;
	JLabel l11;
	JLabel l12;
	JLabel l13;
	JLabel l14;
	JLabel l15;
	JLabel l16;
	JLabel l17;
	JLabel l18;
	JLabel l19;
	JLabel l20;
	JLabel l21;
	JLabel l22;
	JLabel l23;
	JLabel l24;
	JLabel l25;
	JButton move;
	JLabel[][] labels;
	Game g;
	JComboBox turns;
	String[] order;
	JButton endturn;
	JButton attack;
	JButton[] champions;
	String[] names;
	JButton champf1;
	JButton champf2;
	JButton champf3;
	JButton champs1;
	JButton champs2;
	JButton champs3;
	JButton[] firstteambuttons;
	JButton[] secondteambuttons;

	JButton comp1;
	JButton comp2;	
	JButton comp3;
	JButton comp4;
	JButton comp5;
	JButton comp6;
	JButton comp7;
	JButton comp8;
	JButton comp9;
	JButton comp10;
	JButton comp11;

	ArrayList<JLabel> labelsofCover;
	ArrayList<JLabel> labelsofChamp;

	JComboBox ability;
	ArrayList<Damageable> allComps;
	
	JButton leader;
	
	JCheckBox firstleader;
	JCheckBox secondleader;
	JLabel lead1;
	JLabel lead2;
	
	JLabel current;
	JButton currentchamp;
	JButton currentab;
	JButton currentef;
	
	OverPage over;


	public PlayPage(Game g , Player p1 , Player p2) throws IOException {

		this.g= g;
		g.loadAbilities("Abilities.csv");
		g.loadChampions("Champions.csv");
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(2048,1190);
		frame.setLayout(new BorderLayout());
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setLayout(new BorderLayout());
		frame.setVisible(true);
		frame.setTitle("Marvel Game");
		ImageIcon marvel = new ImageIcon("marvelgame.png");
		frame.setIconImage(marvel.getImage());
		grid = new JPanel();
		player1 = new JPanel();
		player2 = new JPanel();
		grid.setBackground(new Color(0,0,70));
		player1.setBackground(new Color(0,0,70));
		player2.setBackground(new Color(0,0,70));
		player1.setPreferredSize(new Dimension(400,900));
		player2.setPreferredSize(new Dimension(400,900));
		grid.setPreferredSize(new Dimension(600,900));		
		frame.add(player1,BorderLayout.WEST);
		frame.add(player2 , BorderLayout.EAST);
		frame.add(grid,BorderLayout.CENTER);
		GridLayout layout = new GridLayout();
		layout.setHgap(10);
		layout.setVgap(10);

		l1 = new JLabel();
		l2 = new JLabel();
		l3 = new JLabel();
		l4 = new JLabel();
		l5 = new JLabel();
		l6 = new JLabel();
		l7 = new JLabel();
		l8 = new JLabel();
		l9 = new JLabel();
		l10 = new JLabel();
		l11 = new JLabel();
		l12 = new JLabel();
		l13 = new JLabel();
		l14 = new JLabel();
		l15 = new JLabel();
		l16 = new JLabel();
		l17 = new JLabel();
		l18 = new JLabel();
		l19 = new JLabel();
		l20 = new JLabel();
		l21 = new JLabel();
		l22 = new JLabel();
		l23 = new JLabel();
		l24 = new JLabel();
		l25 = new JLabel();

		l1.setPreferredSize(new Dimension(130,130));
		l2.setPreferredSize(new Dimension(130,130));
		l3.setPreferredSize(new Dimension(130,130));
		l4.setPreferredSize(new Dimension(130,130));
		l5.setPreferredSize(new Dimension(130,130));
		l6.setPreferredSize(new Dimension(130,130));
		l7.setPreferredSize(new Dimension(130,130));
		l8.setPreferredSize(new Dimension(130,130));
		l9.setPreferredSize(new Dimension(130,130));
		l10.setPreferredSize(new Dimension(130,130));
		l11.setPreferredSize(new Dimension(130,130));
		l12.setPreferredSize(new Dimension(130,130));
		l13.setPreferredSize(new Dimension(130,130));
		l14.setPreferredSize(new Dimension(130,130));
		l15.setPreferredSize(new Dimension(130,130));
		l16.setPreferredSize(new Dimension(130,130));
		l17.setPreferredSize(new Dimension(130,130));
		l18.setPreferredSize(new Dimension(130,130));
		l19.setPreferredSize(new Dimension(130,130));
		l20.setPreferredSize(new Dimension(130,130));
		l21.setPreferredSize(new Dimension(130,130));
		l22.setPreferredSize(new Dimension(130,130));
		l23.setPreferredSize(new Dimension(130,130));
		l24.setPreferredSize(new Dimension(130,130));
		l25.setPreferredSize(new Dimension(130,130));


		l1.setBackground(Color.white);
		l2.setBackground(Color.white);
		l3.setBackground(Color.white);
		l4.setBackground(Color.white);
		l5.setBackground(Color.white);
		l6.setBackground(Color.white);
		l7.setBackground(Color.white);
		l8.setBackground(Color.white);
		l9.setBackground(Color.white);
		l10.setBackground(Color.white);
		l11.setBackground(Color.white);
		l12.setBackground(Color.white);
		l13.setBackground(Color.white);
		l14.setBackground(Color.white);
		l15.setBackground(Color.white);
		l16.setBackground(Color.white);
		l17.setBackground(Color.white);
		l18.setBackground(Color.white);
		l19.setBackground(Color.white);
		l20.setBackground(Color.white);
		l21.setBackground(Color.white);
		l22.setBackground(Color.white);
		l23.setBackground(Color.white);
		l24.setBackground(Color.white);
		l25.setBackground(Color.white);

		l1.setFont(new Font(null,Font.BOLD,10));
		l2.setFont(new Font(null,Font.BOLD,10));
		l3.setFont(new Font(null,Font.BOLD,10));
		l4.setFont(new Font(null,Font.BOLD,10));
		l5.setFont(new Font(null,Font.BOLD,10));
		l6.setFont(new Font(null,Font.BOLD,10));
		l7.setFont(new Font(null,Font.BOLD,10));
		l8.setFont(new Font(null,Font.BOLD,10));
		l9.setFont(new Font(null,Font.BOLD,10));
		l10.setFont(new Font(null,Font.BOLD,10));
		l11.setFont(new Font(null,Font.BOLD,10));
		l12.setFont(new Font(null,Font.BOLD,10));
		l13.setFont(new Font(null,Font.BOLD,10));
		l14.setFont(new Font(null,Font.BOLD,10));
		l15.setFont(new Font(null,Font.BOLD,10));
		l16.setFont(new Font(null,Font.BOLD,10));
		l17.setFont(new Font(null,Font.BOLD,10));
		l18.setFont(new Font(null,Font.BOLD,10));
		l19.setFont(new Font(null,Font.BOLD,10));
		l20.setFont(new Font(null,Font.BOLD,10));
		l21.setFont(new Font(null,Font.BOLD,10));
		l22.setFont(new Font(null,Font.BOLD,10));
		l23.setFont(new Font(null,Font.BOLD,10));
		l24.setFont(new Font(null,Font.BOLD,10));
		l25.setFont(new Font(null,Font.BOLD,10));


		l1.setHorizontalAlignment(JLabel.CENTER);
		l2.setHorizontalAlignment(JLabel.CENTER);
		l3.setHorizontalAlignment(JLabel.CENTER);
		l4.setHorizontalAlignment(JLabel.CENTER);
		l4.setVerticalAlignment(JLabel.CENTER);
		l5.setHorizontalAlignment(JLabel.CENTER);
		l5.setVerticalAlignment(JLabel.CENTER);
		l6.setHorizontalAlignment(JLabel.CENTER);
		l6.setVerticalAlignment(JLabel.CENTER);
		l7.setHorizontalAlignment(JLabel.CENTER);
		l7.setVerticalAlignment(JLabel.CENTER);
		l8.setHorizontalAlignment(JLabel.CENTER);
		l8.setVerticalAlignment(JLabel.CENTER);
		l9.setHorizontalAlignment(JLabel.CENTER);
		l9.setVerticalAlignment(JLabel.CENTER);
		l10.setHorizontalAlignment(JLabel.CENTER);
		l10.setVerticalAlignment(JLabel.CENTER);
		l11.setHorizontalAlignment(JLabel.CENTER);
		l11.setVerticalAlignment(JLabel.CENTER);
		l12.setHorizontalAlignment(JLabel.CENTER);
		l12.setVerticalAlignment(JLabel.CENTER);
		l13.setHorizontalAlignment(JLabel.CENTER);
		l13.setVerticalAlignment(JLabel.CENTER);
		l14.setHorizontalAlignment(JLabel.CENTER);
		l14.setVerticalAlignment(JLabel.CENTER);
		l15.setHorizontalAlignment(JLabel.CENTER);
		l15.setVerticalAlignment(JLabel.CENTER);
		l16.setHorizontalAlignment(JLabel.CENTER);
		l16.setVerticalAlignment(JLabel.CENTER);
		l17.setHorizontalAlignment(JLabel.CENTER);
		l17.setVerticalAlignment(JLabel.CENTER);
		l18.setHorizontalAlignment(JLabel.CENTER);
		l18.setVerticalAlignment(JLabel.CENTER);
		l19.setHorizontalAlignment(JLabel.CENTER);
		l19.setVerticalAlignment(JLabel.CENTER);
		l20.setHorizontalAlignment(JLabel.CENTER);
		l20.setVerticalAlignment(JLabel.CENTER);
		l21.setHorizontalAlignment(JLabel.CENTER);
		l21.setVerticalAlignment(JLabel.CENTER);
		l22.setHorizontalAlignment(JLabel.CENTER);
		l22.setVerticalAlignment(JLabel.CENTER);
		l23.setHorizontalAlignment(JLabel.CENTER);
		l23.setVerticalAlignment(JLabel.CENTER);
		l24.setHorizontalAlignment(JLabel.CENTER);
		l24.setVerticalAlignment(JLabel.CENTER);
		l25.setHorizontalAlignment(JLabel.CENTER);
		l25.setVerticalAlignment(JLabel.CENTER);

		l1.setHorizontalTextPosition(JLabel.CENTER);
		l1.setVerticalTextPosition(JLabel.BOTTOM);
		l2.setHorizontalTextPosition(JLabel.CENTER);
		l2.setVerticalTextPosition(JLabel.BOTTOM);
		l3.setHorizontalTextPosition(JLabel.CENTER);
		l3.setVerticalTextPosition(JLabel.BOTTOM);
		l4.setHorizontalTextPosition(JLabel.CENTER);
		l4.setVerticalTextPosition(JLabel.BOTTOM);
		l5.setHorizontalTextPosition(JLabel.CENTER);
		l5.setVerticalTextPosition(JLabel.BOTTOM);
		l6.setHorizontalTextPosition(JLabel.CENTER);
		l6.setVerticalTextPosition(JLabel.BOTTOM);
		l7.setHorizontalTextPosition(JLabel.CENTER);
		l7.setVerticalTextPosition(JLabel.BOTTOM);
		l8.setHorizontalTextPosition(JLabel.CENTER);
		l8.setVerticalTextPosition(JLabel.BOTTOM);
		l9.setHorizontalTextPosition(JLabel.CENTER);
		l9.setVerticalTextPosition(JLabel.BOTTOM);
		l10.setHorizontalTextPosition(JLabel.CENTER);
		l10.setVerticalTextPosition(JLabel.BOTTOM);
		l11.setHorizontalTextPosition(JLabel.CENTER);
		l11.setVerticalTextPosition(JLabel.BOTTOM);
		l12.setHorizontalTextPosition(JLabel.CENTER);
		l12.setVerticalTextPosition(JLabel.BOTTOM);
		l13.setHorizontalTextPosition(JLabel.CENTER);
		l13.setVerticalTextPosition(JLabel.BOTTOM);
		l14.setHorizontalTextPosition(JLabel.CENTER);
		l14.setVerticalTextPosition(JLabel.BOTTOM);
		l15.setHorizontalTextPosition(JLabel.CENTER);
		l15.setVerticalTextPosition(JLabel.BOTTOM);
		l16.setHorizontalTextPosition(JLabel.CENTER);
		l16.setVerticalTextPosition(JLabel.BOTTOM);
		l17.setHorizontalTextPosition(JLabel.CENTER);
		l17.setVerticalTextPosition(JLabel.BOTTOM);
		l18.setHorizontalTextPosition(JLabel.CENTER);
		l18.setVerticalTextPosition(JLabel.BOTTOM);
		l19.setHorizontalTextPosition(JLabel.CENTER);
		l19.setVerticalTextPosition(JLabel.BOTTOM);
		l20.setHorizontalTextPosition(JLabel.CENTER);
		l20.setVerticalTextPosition(JLabel.BOTTOM);
		l21.setHorizontalTextPosition(JLabel.CENTER);
		l21.setVerticalTextPosition(JLabel.BOTTOM);
		l22.setHorizontalTextPosition(JLabel.CENTER);
		l22.setVerticalTextPosition(JLabel.BOTTOM);
		l23.setHorizontalTextPosition(JLabel.CENTER);
		l23.setVerticalTextPosition(JLabel.BOTTOM);
		l24.setHorizontalTextPosition(JLabel.CENTER);
		l24.setVerticalTextPosition(JLabel.BOTTOM);
		l25.setHorizontalTextPosition(JLabel.CENTER);
		l25.setVerticalTextPosition(JLabel.BOTTOM);

		l1.setOpaque(true);
		l2.setOpaque(true);
		l3.setOpaque(true);
		l4.setOpaque(true);
		l5.setOpaque(true);
		l6.setOpaque(true);
		l7.setOpaque(true);
		l8.setOpaque(true);
		l9.setOpaque(true);
		l10.setOpaque(true);
		l11.setOpaque(true);
		l12.setOpaque(true);
		l13.setOpaque(true);
		l14.setOpaque(true);
		l15.setOpaque(true);
		l16.setOpaque(true);
		l17.setOpaque(true);
		l18.setOpaque(true);
		l19.setOpaque(true);
		l20.setOpaque(true);
		l21.setOpaque(true);
		l22.setOpaque(true);
		l23.setOpaque(true);
		l24.setOpaque(true);
		l25.setOpaque(true);

		grid.add(l1);
		grid.add(l2);
		grid.add(l3);
		grid.add(l4);
		grid.add(l5);
		grid.add(l6);
		grid.add(l7);
		grid.add(l8);
		grid.add(l9);
		grid.add(l10);
		grid.add(l11);
		grid.add(l12);
		grid.add(l13);
		grid.add(l14);
		grid.add(l15);
		grid.add(l16);
		grid.add(l17);
		grid.add(l18);
		grid.add(l19);
		grid.add(l20);
		grid.add(l21);
		grid.add(l22);
		grid.add(l23);
		grid.add(l24);
		grid.add(l25);

		order = new String[6];
		PriorityQueue temp = new PriorityQueue(6);
		turns = new JComboBox();
		for(int f=g.getTurnOrder().getElements().length-1 ; f>=0 ; f--) {
			turns.addItem(((Champion)(g.getTurnOrder().getElements()[f])).getName());
		}

		turns.setBackground(new Color(255,205,0));



		ImageIcon cover = new ImageIcon(new ImageIcon("Hydra.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

		labelsofCover = new ArrayList<>();
       
		comp1 = new JButton();
		comp2 = new JButton();
		comp3 = new JButton();
		comp4 = new JButton();
		comp5 = new JButton();
		comp6 = new JButton();
		comp7 = new JButton();
		comp8 = new JButton();
		comp9 = new JButton();
		comp10 = new JButton();
		comp11 = new JButton();
        
		comp1.setBackground(Color.black);
		comp2.setBackground(Color.black);
		comp3.setBackground(Color.black);
		comp4.setBackground(Color.black);
		comp5.setBackground(Color.black);
		comp6.setBackground(Color.black);
		comp7.setBackground(Color.black);
		comp8.setBackground(Color.black);
		comp9.setBackground(Color.black);
		comp10.setBackground(Color.black);
		comp11.setBackground(Color.black);

		comp1.setText("info");
		comp2.setText("info");
		comp3.setText("info");
		comp4.setText("info");
		comp5.setText("info");
		comp6.setText("info");
		comp7.setText("info");
		comp8.setText("info");
		comp9.setText("info");
		comp10.setText("info");
		comp11.setText("info");

		comp1.setFocusable(false);
		comp2.setFocusable(false);
		comp3.setFocusable(false);
		comp4.setFocusable(false);
		comp5.setFocusable(false);
		comp6.setFocusable(false);
		comp7.setFocusable(false);
		comp8.setFocusable(false);
		comp9.setFocusable(false);
		comp10.setFocusable(false);
		comp11.setFocusable(false);


		comp1.setForeground(Color.white);
		comp2.setForeground(Color.white);
		comp3.setForeground(Color.white);
		comp4.setForeground(Color.white);
		comp5.setForeground(Color.white);
		comp6.setForeground(Color.white);
		comp7.setForeground(Color.white);
		comp8.setForeground(Color.white);
		comp9.setForeground(Color.white);
		comp10.setForeground(Color.white);
		comp11.setForeground(Color.white);


		comp1.addActionListener(this);
		comp2.addActionListener(this);
		comp3.addActionListener(this);
		comp4.addActionListener(this);
		comp5.addActionListener(this);
		comp6.addActionListener(this);
		comp7.addActionListener(this);
		comp8.addActionListener(this);
		comp9.addActionListener(this);
		comp10.addActionListener(this);
		comp11.addActionListener(this);

		comp1.setPreferredSize(new Dimension(70,20));
		comp2.setPreferredSize(new Dimension(70,20));
		comp3.setPreferredSize(new Dimension(70,20));
		comp4.setPreferredSize(new Dimension(70,20));
		comp5.setPreferredSize(new Dimension(70,20));
		comp6.setPreferredSize(new Dimension(70,20));
		comp7.setPreferredSize(new Dimension(70,20));
		comp8.setPreferredSize(new Dimension(70,20));
		comp9.setPreferredSize(new Dimension(70,20));
		comp10.setPreferredSize(new Dimension(70,20));
		comp11.setPreferredSize(new Dimension(70,20));

		if((g.getBoard())[4][0] instanceof Cover) {
			labelsofCover.add(l1);
			l1.setIcon(cover);
			l1.setText("1"); }
		if((g.getBoard())[4][4] instanceof Cover) {
			labelsofCover.add(l5);
			l5.setIcon(cover);
			l5.setText("5"); }
		if((g.getBoard())[3][0] instanceof Cover) {
			labelsofCover.add(l6);
			l6.setIcon(cover);
			l6.setText("6"); }
		if((g.getBoard())[3][1] instanceof Cover) {
			labelsofCover.add(l7);
			l7.setIcon(cover);
			l7.setText("7"); }
		if((g.getBoard())[3][2] instanceof Cover) {
			labelsofCover.add(l8);
			l8.setIcon(cover);
			l8.setText("8"); }
		if((g.getBoard())[3][3] instanceof Cover) {
			labelsofCover.add(l9);
			l9.setIcon(cover);
			l9.setText("9"); }
		if((g.getBoard())[3][4] instanceof Cover) {
			labelsofCover.add(l10);
			l10.setIcon(cover);
			l10.setText("10"); }
		if((g.getBoard())[2][0] instanceof Cover) {
			labelsofCover.add(l11);
			l11.setIcon(cover);
			l11.setText("11"); }
		if((g.getBoard())[2][1] instanceof Cover) {
			labelsofCover.add(l12);
			l12.setIcon(cover);
			l12.setText("12"); }
		if((g.getBoard())[2][2] instanceof Cover) {
			labelsofCover.add(l13);
			l13.setIcon(cover);
			l13.setText("13"); }
		if((g.getBoard())[2][3] instanceof Cover) {
			labelsofCover.add(l14);
			l14.setIcon(cover);
			l14.setText("14"); }
		if((g.getBoard())[2][4] instanceof Cover) {
			labelsofCover.add(l15);
			l15.setIcon(cover);
			l15.setText("15");}
		if((g.getBoard())[1][0] instanceof Cover) {
			l16.setIcon(cover);
			labelsofCover.add(l16);
			l16.setText("16");}
		if((g.getBoard())[1][1] instanceof Cover) {
			l17.setIcon(cover);
			labelsofCover.add(l17);
			l17.setText("17");}
		if((g.getBoard())[1][2] instanceof Cover) {
			l18.setIcon(cover);
			labelsofCover.add(l18);
			l18.setText("18");}
		if((g.getBoard())[1][3] instanceof Cover) {
			l19.setIcon(cover);
			labelsofCover.add(l19);
			l19.setText("19");}
		if((g.getBoard())[1][4] instanceof Cover) {
			l20.setIcon(cover);
			labelsofCover.add(l20);
			l20.setText("20");}
		if((g.getBoard())[0][0] instanceof Cover){
			l21.setIcon(cover);
			labelsofCover.add(l21);
			l21.setText("21");}
		if((g.getBoard())[0][4] instanceof Cover) {
			l25.setIcon(cover);
			labelsofCover.add(l25);
			l25.setText("25");}


		labelsofCover.get(0).setLayout(new FlowLayout());
		labelsofCover.get(1).setLayout(new FlowLayout());
		labelsofCover.get(2).setLayout(new FlowLayout());
		labelsofCover.get(3).setLayout(new FlowLayout());
		labelsofCover.get(4).setLayout(new FlowLayout());


		(labelsofCover.get(0)).add(comp1,JLabel.CENTER);
		(labelsofCover.get(1)).add(comp2,JLabel.CENTER);
		(labelsofCover.get(2)).add(comp3,JLabel.CENTER);
		(labelsofCover.get(3)).add(comp4,JLabel.CENTER);
		(labelsofCover.get(4)).add(comp5,JLabel.CENTER);

		labels = new JLabel[5][5]; 
		labels[0][0] = l21; labels[1][1] = l17; labels[2][2] = l13; labels[3][3] = l9;  labels[4][4] = l5;
		labels[0][1] = l22;	labels[1][2] = l18;	labels[2][3] = l14; labels[3][4] = l10;
		labels[0][2] = l23;	labels[1][3] = l19; labels[2][4] = l15; labels[4][0] = l1;
		labels[0][3] = l24;	labels[1][4] = l20; labels[3][0] = l6;  labels[4][1] = l2;
		labels[0][4] = l25;	labels[2][0] = l11; labels[3][1] = l7;  labels[4][2] = l3;
		labels[1][0] = l16; labels[2][1] = l12; labels[3][2] = l8;  labels[4][3] = l4;

		labelsofChamp = new ArrayList<>();

		l2.setLayout(new FlowLayout());
		l3.setLayout(new FlowLayout());
		l4.setLayout(new FlowLayout());
		l22.setLayout(new FlowLayout());
		l23.setLayout(new FlowLayout());
		l24.setLayout(new FlowLayout());

		l2.setText("champ1");
		l3.setText("champ2"); 
		l4.setText("champ3");
		l22.setText("champ4");
		l23.setText("champ5"); 
		l24.setText("champ6");
		l2.add(comp6);
		l3.add(comp7);
		l4.add(comp8);
		l22.add(comp9);
		l23.add(comp10);
		l24.add(comp11);


		move = new JButton();
		move.setText("Move");
		move.setPreferredSize(new Dimension(80,30));
		move.setBackground(new Color(255,205,0));
		move.setFocusable(false);
		move.addActionListener(this);
		endturn = new JButton("End Turn");
		endturn.setPreferredSize(new Dimension(100,30));
		endturn.setFocusable(false);
		endturn.setBackground(new Color(255,205,0));
		endturn.addActionListener(this);
		attack= new JButton("Attack");
		attack.setPreferredSize(new Dimension(80,30));
		attack.setBackground(new Color(255,205,0));
		attack.setFocusable(false);
		attack.addActionListener(this);

		String[] abilities = {g.getCurrentChampion().getAbilities().get(0).getName(),g.getCurrentChampion().getAbilities().get(1).getName(),g.getCurrentChampion().getAbilities().get(2).getName()};
		ability = new JComboBox(abilities);
		ability.setBackground(new Color(255,205,0));
		ability.addActionListener(this);
		
		leader = new JButton("Leader Ability");
		leader.setPreferredSize(new Dimension(150,30));
		leader.setBackground(new Color(255,205,0));
		leader.setFocusable(false);
		leader.addActionListener(this);
		
		
		grid.add(move);	
		grid.add(attack);
		grid.add(endturn);
		grid.add(leader);
		grid.add(turns);
		grid.add(ability);



		ArrayList<JLabel> labelchamp = new ArrayList<>();
		labelchamp.add(l1); 		
		labelchamp.add(l2); 		
		labelchamp.add(l3); 		
		labelchamp.add(l22); 		
		labelchamp.add(l23); 		
		labelchamp.add(l24); 		

		names = new String[6];
		champions = new JButton[15];

		for(int r=0 ; r<3 ;r++) {
			names[r]=p1.getTeam().get(r).getName();
		}
		for(int r=3 ; r<6 ;r++) {
			names[r]=p2.getTeam().get(r-3).getName();
		}
		ImageIcon captain = new ImageIcon(new ImageIcon("captainamerica.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon deadpool = new ImageIcon(new ImageIcon("deadpool.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon strange = new ImageIcon(new ImageIcon("drstrange.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon electro = new ImageIcon(new ImageIcon("electro.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon ghost = new ImageIcon(new ImageIcon("ghostrider.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon hela = new ImageIcon(new ImageIcon("hela.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon hulk = new ImageIcon(new ImageIcon("hulk.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon iceman = new ImageIcon(new ImageIcon("iceman.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon ironman = new ImageIcon(new ImageIcon("ironman.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon loki = new ImageIcon(new ImageIcon("loki.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon silver = new ImageIcon(new ImageIcon("quicksilver.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon spider = new ImageIcon(new ImageIcon("spiderman.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon thor = new ImageIcon(new ImageIcon("thor.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon venom = new ImageIcon(new ImageIcon("venom.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
		ImageIcon yellow = new ImageIcon(new ImageIcon("yellowjacket.png").getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));

		
		String name1 = g.getFirstPlayer().getTeam().get(0).getName();
		switch(name1) {
		case "Captain America" : l22.setIcon(captain); break;
		case "Deadpool" : l22.setIcon(deadpool); break;
		case "Dr Strange" : l22.setIcon(strange); break;
		case "Electro" : l22.setIcon(electro); break;
		case "Ghost Rider" : l22.setIcon(ghost); break;
		case "Hela" : l22.setIcon(hela); break;
		case "Hulk" : l22.setIcon(hulk); break;
		case "Iceman" : l22.setIcon(iceman); break;
		case "Ironman" : l22.setIcon(ironman); break;
		case "Loki" : l22.setIcon(loki); break;
		case "Quicksilver" : l22.setIcon(silver); break;
		case "Spiderman" : l22.setIcon(spider); break;
		case "Thor" : l22.setIcon(thor); break;
		case "Venom" : l22.setIcon(venom); break;
		case "Yellow Jacket" : l22.setIcon(yellow); break;
		}
		if(g.getFirstPlayer().getTeam().get(0).getName().equals(g.getFirstPlayer().getLeader().getName()))
			l22.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
		
		
		String name2 = g.getFirstPlayer().getTeam().get(1).getName();
		switch(name2) {
		case "Captain America" : l23.setIcon(captain); break;
		case "Deadpool" : l23.setIcon(deadpool); break;
		case "Dr Strange" : l23.setIcon(strange); break;
		case "Electro" : l23.setIcon(electro); break;
		case "Ghost Rider" : l23.setIcon(ghost); break;
		case "Hela" : l23.setIcon(hela); break;
		case "Hulk" : l23.setIcon(hulk); break;
		case "Iceman" : l23.setIcon(iceman); break;
		case "Ironman" : l23.setIcon(ironman); break;
		case "Loki" : l23.setIcon(loki); break;
		case "Quicksilver" : l23.setIcon(silver); break;
		case "Spiderman" : l23.setIcon(spider); break;
		case "Thor" : l23.setIcon(thor); break;
		case "Venom" : l23.setIcon(venom); break;
		case "Yellow Jacket" : l23.setIcon(yellow); break;
		}
		if(g.getFirstPlayer().getTeam().get(1).getName().equals(g.getFirstPlayer().getLeader().getName()))
			l23.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
		
		
		String name3 = g.getFirstPlayer().getTeam().get(2).getName();
		switch(name3) {
		case "Captain America" : l24.setIcon(captain); break;
		case "Deadpool" : l24.setIcon(deadpool); break;
		case "Dr Strange" : l24.setIcon(strange); break;
		case "Electro" : l24.setIcon(electro); break;
		case "Ghost Rider" : l24.setIcon(ghost); break;
		case "Hela" : l24.setIcon(hela); break;
		case "Hulk" : l24.setIcon(hulk); break;
		case "Iceman" : l24.setIcon(iceman); break;
		case "Ironman" : l24.setIcon(ironman); break;
		case "Loki" : l24.setIcon(loki); break;
		case "Quicksilver" : l24.setIcon(silver); break;
		case "Spiderman" : l24.setIcon(spider); break;
		case "Thor" : l24.setIcon(thor); break;
		case "Venom" : l24.setIcon(venom); break;
		case "Yellow Jacket" : l24.setIcon(yellow); break;
		}
		if(g.getFirstPlayer().getTeam().get(2).getName().equals(g.getFirstPlayer().getLeader().getName()))
			l24.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
		
		
		String name4 = g.getSecondPlayer().getTeam().get(0).getName();
		switch(name4) {
		case "Captain America" : l2.setIcon(captain); break;
		case "Deadpool" : l2.setIcon(deadpool); break;
		case "Dr Strange" : l2.setIcon(strange); break;
		case "Electro" : l2.setIcon(electro); break;
		case "Ghost Rider" : l2.setIcon(ghost); break;
		case "Hela" : l2.setIcon(hela); break;
		case "Hulk" : l2.setIcon(hulk); break;
		case "Iceman" : l2.setIcon(iceman); break;
		case "Ironman" : l2.setIcon(ironman); break;
		case "Loki" : l2.setIcon(loki); break;
		case "Quicksilver" : l2.setIcon(silver); break;
		case "Spiderman" : l2.setIcon(spider); break;
		case "Thor" : l2.setIcon(thor); break;
		case "Venom" : l2.setIcon(venom); break;
		case "Yellow Jacket" : l2.setIcon(yellow); break;
		}
		if(g.getSecondPlayer().getTeam().get(0).getName().equals(g.getSecondPlayer().getLeader().getName()))
			l2.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
		
		
		String name5 = g.getSecondPlayer().getTeam().get(1).getName();
		switch(name5) {
		case "Captain America" : l3.setIcon(captain); break;
		case "Deadpool" : l3.setIcon(deadpool); break;
		case "Dr Strange" : l3.setIcon(strange); break;
		case "Electro" : l3.setIcon(electro); break;
		case "Ghost Rider" : l3.setIcon(ghost); break;
		case "Hela" : l3.setIcon(hela); break;
		case "Hulk" : l3.setIcon(hulk); break;
		case "Iceman" : l3.setIcon(iceman); break;
		case "Ironman" : l3.setIcon(ironman); break;
		case "Loki" : l3.setIcon(loki); break;
		case "Quicksilver" : l3.setIcon(silver); break;
		case "Spiderman" : l3.setIcon(spider); break;
		case "Thor" : l3.setIcon(thor); break;
		case "Venom" : l3.setIcon(venom); break;
		case "Yellow Jacket" : l3.setIcon(yellow); break;
		}
		if(g.getSecondPlayer().getTeam().get(1).getName().equals(g.getSecondPlayer().getLeader().getName()))
			l3.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
		
		
		String name6 = g.getSecondPlayer().getTeam().get(2).getName();
		switch(name6) {
		case "Captain America" : l4.setIcon(captain); break;
		case "Deadpool" : l4.setIcon(deadpool); break;
		case "Dr Strange" : l4.setIcon(strange); break;
		case "Electro" : l4.setIcon(electro); break;
		case "Ghost Rider" : l4.setIcon(ghost); break;
		case "Hela" : l4.setIcon(hela); break;
		case "Hulk" : l4.setIcon(hulk); break;
		case "Iceman" : l4.setIcon(iceman); break;
		case "Ironman" : l4.setIcon(ironman); break;
		case "Loki" : l4.setIcon(loki); break;
		case "Quicksilver" : l4.setIcon(silver); break;
		case "Spiderman" : l4.setIcon(spider); break;
		case "Thor" : l4.setIcon(thor); break;
		case "Venom" : l4.setIcon(venom); break;
		case "Yellow Jacket" : l4.setIcon(yellow); break;
		}
		if(g.getSecondPlayer().getTeam().get(2).getName().equals(g.getSecondPlayer().getLeader().getName()))
			l4.setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
		
		JButton champ1 = new JButton();
		champ1.setPreferredSize(new Dimension(70,90));
		champ1.setBackground(Color.white);
		champ1.setFocusable(false);
		champ1.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ1.setIcon(captain);
		champ1.setHorizontalTextPosition(JButton.CENTER);
		champ1.setVerticalTextPosition(JButton.BOTTOM);
		champ1.setText("Captain America");
		champions[0]=champ1;

		JButton champ2 = new JButton();
		champ2.setPreferredSize(new Dimension(70,90));
		champ2.setBackground(Color.white);
		champ2.setFocusable(false);
		champ2.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ2.setIcon(deadpool);
		champ2.setHorizontalTextPosition(JButton.CENTER);
		champ2.setVerticalTextPosition(JButton.BOTTOM);
		champ2.setText("Deadpool");
		champions[1]=champ2;

		JButton champ3 = new JButton();		
		champ3.setPreferredSize(new Dimension(70,90));
		champ3.setBackground(Color.white);
		champ3.setFocusable(false);
		champ3.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ3.setIcon(strange);
		champ3.setHorizontalTextPosition(JButton.CENTER);
		champ3.setVerticalTextPosition(JButton.BOTTOM);
		champ3.setText("Dr Strange");
		champions[2]=champ3;

		JButton champ4 = new JButton();
		champ4.setPreferredSize(new Dimension(70,90));
		champ4.setBackground(Color.white);
		champ4.setFocusable(false);
		champ4.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ4.setIcon(electro);
		champ4.setHorizontalTextPosition(JButton.CENTER);
		champ4.setVerticalTextPosition(JButton.BOTTOM);
		champ4.setText("Electro");
		champions[3]=champ4;

		JButton champ5 = new JButton();
		champ5.setPreferredSize(new Dimension(70,90));
		champ5.setBackground(Color.white);
		champ5.setFocusable(false);
		champ5.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ5.setIcon(ghost);
		champ5.setHorizontalTextPosition(JButton.CENTER);
		champ5.setVerticalTextPosition(JButton.BOTTOM);
		champ5.setText("Ghost Rider");
		champions[4]=champ5;

		JButton champ6 = new JButton();
		champ6.setPreferredSize(new Dimension(70,90));
		champ6.setBackground(Color.white);
		champ6.setFocusable(false);
		champ6.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ6.setIcon(hela);
		champ6.setHorizontalTextPosition(JButton.CENTER);
		champ6.setVerticalTextPosition(JButton.BOTTOM);
		champ6.setText("Hela");
		champions[5]=champ6;

		JButton champ7 = new JButton();
		champ7.setPreferredSize(new Dimension(70,90));
		champ7.setBackground(Color.white);
		champ7.setFocusable(false);
		champ7.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ7.setIcon(hulk);
		champ7.setHorizontalTextPosition(JButton.CENTER);
		champ7.setVerticalTextPosition(JButton.BOTTOM);
		champ7.setText("Hulk");
		champions[6]=champ7;

		JButton champ8 = new JButton();
		champ8.setPreferredSize(new Dimension(70,90));
		champ8.setBackground(Color.white);
		champ8.setFocusable(false);
		champ8.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ8.setIcon(iceman);
		champ8.setHorizontalTextPosition(JButton.CENTER);
		champ8.setVerticalTextPosition(JButton.BOTTOM);
		champ8.setText("Iceman");
		champions[7]=champ8;

		JButton champ9 = new JButton();
		champ9.setPreferredSize(new Dimension(70,90));
		champ9.setBackground(Color.white);
		champ9.setFocusable(false);
		champ9.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ9.setIcon(ironman);
		champ9.setHorizontalTextPosition(JButton.CENTER);
		champ9.setVerticalTextPosition(JButton.BOTTOM);
		champ9.setText("Ironman");
		champions[8]=champ9;

		JButton champ10 = new JButton();
		champ10.setPreferredSize(new Dimension(70,90));
		champ10.setBackground(Color.white);
		champ10.setFocusable(false);
		champ10.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ10.setIcon(loki);
		champ10.setHorizontalTextPosition(JButton.CENTER);
		champ10.setVerticalTextPosition(JButton.BOTTOM);
		champ10.setText("Loki");
		champions[9]=champ10;

		JButton champ11 = new JButton();
		champ11.setPreferredSize(new Dimension(70,90));
		champ11.setBackground(Color.white);
		champ11.setFocusable(false);
		champ11.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ11.setIcon(silver);
		champ11.setHorizontalTextPosition(JButton.CENTER);
		champ11.setVerticalTextPosition(JButton.BOTTOM);
		champ11.setText("Quicksilver");
		champions[10]=champ11;

		JButton champ12 = new JButton();
		champ12.setPreferredSize(new Dimension(70,90));
		champ12.setBackground(Color.white);
		champ12.setFocusable(false);
		champ12.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ12.setIcon(spider);
		champ12.setHorizontalTextPosition(JButton.CENTER);
		champ12.setVerticalTextPosition(JButton.BOTTOM);
		champ12.setText("Spiderman");
		champions[11]=champ12;

		JButton champ13 = new JButton();
		champ13.setPreferredSize(new Dimension(70,90));
		champ13.setBackground(Color.white);
		champ13.setFocusable(false);
		champ13.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ13.setIcon(thor);
		champ13.setHorizontalTextPosition(JButton.CENTER);
		champ13.setVerticalTextPosition(JButton.BOTTOM);
		champ13.setText("Thor");
		champions[12]=champ13;

		JButton champ14 = new JButton();
		champ14.setPreferredSize(new Dimension(70,90));
		champ14.setBackground(Color.white);
		champ14.setFocusable(false);
		champ14.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ14.setIcon(venom);
		champ14.setHorizontalTextPosition(JButton.CENTER);
		champ14.setVerticalTextPosition(JButton.BOTTOM);
		champ14.setText("Venom");
		champions[13]=champ14;

		JButton champ15 = new JButton();
		champ15.setPreferredSize(new Dimension(70,90));
		champ15.setBackground(Color.white);
		champ15.setFocusable(false);
		champ15.setFont(new Font("SansSerif",Font.BOLD,20));;
		champ15.setIcon(yellow);
		champ15.setHorizontalTextPosition(JButton.CENTER);
		champ15.setVerticalTextPosition(JButton.BOTTOM);
		champ15.setText("Yellow Jacket");
		champions[14]=champ15;


		JLabel layer1 = new JLabel();
		layer1.setBounds(0,105, 400, 150);
		GridLayout grid = new GridLayout();
		grid.setHgap(5);
		layer1.setLayout(grid);
		player1.add(layer1);

		JLabel layer2 = new JLabel();
		layer2.setBounds(0,105, 400, 150);
		layer2.setLayout(grid);
		player2.add(layer2);
		
		lead1=new JLabel("‘Leader Ability‘ not used");
		lead1.setBounds(5,230,400,100);
		lead1.setLayout(new BorderLayout());
		lead1.setFont(new Font("Serif" , Font.BOLD , 30));
		lead1.setForeground(new Color(255,205,0));
		player1.add(lead1);
		
		lead2=new JLabel("‘Leader Ability‘ not used");
		lead2.setBounds(0,230,400,100);
		lead2.setFont(new Font("Serif" , Font.BOLD , 30));
		lead2.setLayout(new BorderLayout());
		lead2.setForeground(new Color(255,205,0));
		player2.add(lead2);

		firstteambuttons=new JButton[3];
		secondteambuttons=new JButton[3];

		for(int b=0 ; b<champions.length;b++) {	
			if(names[0].equals((champions[b]).getText()) ) {
				champf1 = new JButton();
				champf1.setPreferredSize(new Dimension(70,90));
				champf1.setBackground(Color.white);
				champf1.setFocusable(false);
				champf1.setFont(new Font("SansSerif",Font.BOLD,20));;
				champf1.setIcon((champions[b]).getIcon());
				champf1.setHorizontalTextPosition(JButton.CENTER);
				champf1.setVerticalTextPosition(JButton.BOTTOM);
				champf1.setText((champions[b]).getText());
				layer1.add(champf1);
				firstteambuttons[0]=champf1;
			}
		}

		for(int b=0 ; b<champions.length;b++) {	
			if(names[1].equals((champions[b]).getText()) ) {
				champf2 = new JButton();
				champf2.setPreferredSize(new Dimension(70,90));
				champf2.setBackground(Color.white);
				champf2.setFocusable(false);
				champf2.setFont(new Font("SansSerif",Font.BOLD,20));;
				champf2.setIcon((champions[b]).getIcon());
				champf2.setHorizontalTextPosition(JButton.CENTER);
				champf2.setVerticalTextPosition(JButton.BOTTOM);
				champf2.setText((champions[b]).getText());
				layer1.add(champf2);
				firstteambuttons[1]=champf2;
			}
		}

		for(int b=0 ; b<champions.length;b++) {	
			if(names[2].equals((champions[b]).getText()) ) {
				champf3 = new JButton();
				champf3.setPreferredSize(new Dimension(70,90));
				champf3.setBackground(Color.white);
				champf3.setFocusable(false);
				champf3.setFont(new Font("SansSerif",Font.BOLD,20));;
				champf3.setIcon((champions[b]).getIcon());
				champf3.setHorizontalTextPosition(JButton.CENTER);
				champf3.setVerticalTextPosition(JButton.BOTTOM);
				champf3.setText((champions[b]).getText());
				layer1.add(champf3);
				firstteambuttons[2]=champf3;
			}
		}
		for(int b=0 ; b<champions.length;b++) {	
			if(names[3].equals((champions[b]).getText()) ) {
				champs1 = new JButton();
				champs1.setPreferredSize(new Dimension(70,90));
				champs1.setBackground(Color.white);
				champs1.setFocusable(false);
				champs1.setFont(new Font("SansSerif",Font.BOLD,20));;
				champs1.setIcon((champions[b]).getIcon());
				champs1.setHorizontalTextPosition(JButton.CENTER);
				champs1.setVerticalTextPosition(JButton.BOTTOM);
				champs1.setText((champions[b]).getText());
				layer2.add(champs1);
				secondteambuttons[0]=champs1;
			}
		}
		for(int b=0 ; b<champions.length;b++) {	
			if(names[4].equals((champions[b]).getText()) ) {
				champs2 = new JButton();
				champs2.setPreferredSize(new Dimension(70,90));
				champs2.setBackground(Color.white);
				champs2.setFocusable(false);
				champs2.setFont(new Font("SansSerif",Font.BOLD,20));;
				champs2.setIcon((champions[b]).getIcon());
				champs2.setHorizontalTextPosition(JButton.CENTER);
				champs2.setVerticalTextPosition(JButton.BOTTOM);
				champs2.setText((champions[b]).getText());
				layer2.add(champs2);
				secondteambuttons[1]=champs2;
			}
		}
		for(int b=0 ; b<champions.length;b++) {	
			if(names[5].equals((champions[b]).getText()) ) {
				champs3 = new JButton();
				champs3.setPreferredSize(new Dimension(70,90));
				champs3.setBackground(Color.white);
				champs3.setFocusable(false);
				champs3.setFont(new Font("SansSerif",Font.BOLD,20));;
				champs3.setIcon((champions[b]).getIcon());
				champs3.setHorizontalTextPosition(JButton.CENTER);
				champs3.setVerticalTextPosition(JButton.BOTTOM);
				champs3.setText((champions[b]).getText());
				layer2.add(champs3);
				secondteambuttons[2]=champs3;
			}
		}

		JLabel first = new JLabel();
		JLabel second = new JLabel();
		first.setText("First Player: " + p1.getName());
		second.setText("Second Player: " + p2.getName());
		first.setBounds(25,0,500,100);
		second.setBounds(0,0,500,100);
		first.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		second.setFont(new Font("Trebuchet MS",Font.BOLD,35));
		first.setForeground(Color.white);
		second.setForeground(Color.white);
		player1.setLayout(null);
		player2.setLayout(null);
		player1.add(first);
		player2.add(second);

		current = new JLabel();
		current.setBounds(0, 320, 365, 400);
		current.setBackground(new Color(140,0,0));
		current.setVisible(false);
		current.setOpaque(true);
		current.setLayout(null);
		player2.add(current);
		
		currentab=new JButton("Abilities");
		currentab.setBounds(50, 350, 100, 30);
		currentab.setBackground(new Color(255,205,0));
		currentab.setFocusable(false);
		currentab.setForeground(Color.black);
		currentab.addActionListener(this);
		
		currentef=new JButton("Applied Effects");
		currentef.setBounds(165, 350, 150, 30);
		currentef.setBackground(new Color(255,205,0));
		currentef.setFocusable(false);
		currentef.setForeground(Color.black);
		currentef.addActionListener(this);
		
		current.add(currentab);
		current.add(currentef);
		
		currentchamp = new JButton("Currently playing");
		currentchamp.setBounds(100,500,250,100);
		currentchamp.setFocusable(false);
		currentchamp.setBackground(new Color(140,0,0));
		currentchamp.setForeground(Color.white);
		currentchamp.addActionListener(this);
		player1.add(currentchamp);
		
		

		allComps = new ArrayList<>();
		allComps.add(p1.getTeam().get(0));
		allComps.add(p1.getTeam().get(1));
		allComps.add(p1.getTeam().get(2));
		allComps.add(p2.getTeam().get(0));
		allComps.add(p2.getTeam().get(1));
		allComps.add(p2.getTeam().get(2));
		
		for(int x=0 ; x<g.getBoardheight();x++) {
			for(int y=0 ; y<g.getBoardwidth();y++) {
				
				if((g.getBoard())[x][y] instanceof Cover)
				{
					Cover c = (Cover) (g.getBoard())[x][y];
					allComps.add(c);
				}	
			}
		}


		
		
		frame.revalidate();
		frame.repaint();


	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==currentab) {
			
			frame = new JFrame();
			frame.setTitle("Abilities");
			frame.setSize(1500,500);
			frame.setLocationRelativeTo(null);
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			frame.setLayout(new BorderLayout());
			Champion c=g.getCurrentChampion();
			Ability a1 = c.getAbilities().get(0);
			Ability a2 = c.getAbilities().get(1);
			Ability a3 = c.getAbilities().get(2);
			String type1= null;
			String type2= null;
			String type3= null;
			Object res1 =null;
			Object res2 =null;
			Object res3 =null;
			
			if(a1 instanceof DamagingAbility)
				{type1 = "Damaging Ability";
				res1 = ((DamagingAbility) a1).getDamageAmount();}
			if(a1 instanceof HealingAbility)
				{type1 = "Healing Ability";
				res1= ((HealingAbility) a1).getHealAmount();}
			if(a1 instanceof CrowdControlAbility)
				{type1 = "Crowd Control Ability";
				res1 = ((CrowdControlAbility) a1).getEffect().getName();}
		
			if(a2 instanceof DamagingAbility)
			{type2 = "Damaging Ability";
			res2 = ((DamagingAbility) a2).getDamageAmount();}			
			if(a2 instanceof HealingAbility)
			{type2 = "Healing Ability";
			res2= ((HealingAbility) a2).getHealAmount();}
			if(a2 instanceof CrowdControlAbility)
			{type2 = "Crowd Control Ability";
			res2 = ((CrowdControlAbility) a2).getEffect().getName();}		
			
			
			if(a3 instanceof DamagingAbility)
			{type3 = "Damaging Ability";
			res3 = ((DamagingAbility) a3).getDamageAmount();}	
			if(a3 instanceof HealingAbility)
			{type3 = "Healing Ability";
			res3= ((HealingAbility) a3).getHealAmount();}
			if(a3 instanceof CrowdControlAbility)
			{type3 = "Crowd Control Ability";
			res3 = ((CrowdControlAbility) a3).getEffect().getName();}
			
			
			JLabel ab1 = new JLabel("<html><body>Name: "+a1.getName()+"<html><body><br>Type: "+type1+"<html><body><br>Area of Effect: "+
					a1.getCastArea()+"<html><body><br>Cast Range: "+a1.getCastRange()+"<html><body><br>Mana cost: "+
					a1.getManaCost()+"<html><body><br>required AP: "+a1.getRequiredActionPoints()+"<html><body><br>Base CD: "+
					a1.getBaseCooldown()+"<html><body><br>Current CD: "+a1.getCurrentCooldown()+"<html><body><br>Impact: "+
					res1,SwingConstants.CENTER);
			JLabel ab2 = new JLabel("<html><body>Name: "+a2.getName()+"<html><body><br>Type: "+type2+"<html><body><br>Area of Effect: "+
					a2.getCastArea()+"<html><body><br>Cast Range: "+a2.getCastRange()+"<html><body><br>Mana cost: "+
					a2.getManaCost()+"<html><body><br>required AP: "+a2.getRequiredActionPoints()+"<html><body><br>Base CD: "+
					a2.getBaseCooldown()+"<html><body><br>Current CD: "+a2.getCurrentCooldown()+"<html><body><br>Impact: "+
					res2,SwingConstants.CENTER);
			JLabel ab3 = new JLabel("<html><body>Name: "+a3.getName()+"<html><body><br>Type: "+type3+"<html><body><br>Area of Effect: "+
					a3.getCastArea()+"<html><body><br>Cast Range: "+a3.getCastRange()+"<html><body><br>Mana cost: "+
					a3.getManaCost()+"<html><body><br>required AP: "+a3.getRequiredActionPoints()+"<html><body><br>Base CD: "+
					a3.getBaseCooldown()+"<html><body><br>Current CD: "+a3.getCurrentCooldown()+"<html><body><br>Impact: "+
					res3,SwingConstants.CENTER);
			
			ab1.setPreferredSize(new Dimension(500,100));
			ab2.setPreferredSize(new Dimension(500,100));
			ab3.setPreferredSize(new Dimension(500,100));
			
			ab1.setBackground(new Color(210,0,0));
			ab2.setBackground(new Color(140,0,0));
			ab3.setBackground(new Color(70,0,0));
			ab1.setHorizontalAlignment(JLabel.CENTER);
			ab1.setVerticalAlignment(JLabel.CENTER);
			ab2.setHorizontalAlignment(JLabel.CENTER);
			ab2.setVerticalAlignment(JLabel.CENTER);
			ab3.setHorizontalAlignment(JLabel.CENTER);
			ab3.setVerticalAlignment(JLabel.CENTER);
			ab1.setOpaque(true);
			ab2.setOpaque(true);
			ab3.setOpaque(true);
			ab1.setFont(new Font("Trebuchet MS",Font.BOLD,20));
			ab2.setFont(new Font("Trebuchet MS",Font.BOLD,20));
			ab3.setFont(new Font("Trebuchet MS",Font.BOLD,20));
			ab1.setForeground(Color.white);
			ab2.setForeground(Color.white);
			ab3.setForeground(Color.white);
			frame.add(ab1 , BorderLayout.WEST);
			frame.add(ab2 , BorderLayout.CENTER);
			frame.add(ab3 , BorderLayout.EAST);
			frame.setVisible(true);
		}
		
		if(e.getSource()==currentef) {
			
			frame = new JFrame();
			frame.setTitle("Applied Effects");
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setLayout(new BorderLayout());
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			Champion c=g.getCurrentChampion();
			ArrayList<String> appliedeffects = new ArrayList<>();
			
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				
				appliedeffects.add("" + c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration());
			}
			JLabel eff = new JLabel("Applied Effects: "+appliedeffects ,SwingConstants.CENTER);
			eff.setFont(new Font("Trebuchet MS",Font.BOLD,20));
			eff.setForeground(Color.white);
			frame.add(eff);
			frame.setVisible(true);
		}
		
		if(e.getSource()==currentchamp) {
			
			if(current.isVisible()) {
				
				current.setVisible(false);
				
			}
			
			else{
				Champion c = g.getCurrentChampion();
				String name=c.getName();
				String type=null;
				if(c instanceof Hero)
					type="Hero";
				if(c instanceof Villain)
					type="Villain";
				if(c instanceof AntiHero)
					type="AntiHero";
				int m = c.getMana();
				int ap = c.getCurrentActionPoints();
				int hp = c.getCurrentHP();
				int ad = c.getAttackDamage();
				int ar = c.getAttackRange();
				
				current.setText("<html><body>Type: "+type+"<html><body><br> Name: " +name + "<html><body><br>CurrentHP: " +
						hp + "<html><body><br>Mana: " + m +  "<html><body><br>current AP: " + 
						ap + "<html><body><br>Att.Damage: " + ad + "<html><body><br>Range: " + ar);
				current.setHorizontalAlignment(JLabel.CENTER);
				current.setVerticalAlignment(JLabel.CENTER);
				current.setFont(new Font("Trebuchet MS",Font.BOLD,30));
				current.setForeground(Color.white);
				current.setVisible(true);
			}
			
		}
		
		if(e.getSource()==leader) {
			
			try {
				g.useLeaderAbility();
				
				if(g.getFirstPlayer().getTeam().contains(g.getCurrentChampion()))
					{	
					lead1.setText(null);
					lead1.setText("‘Leader Ability‘ already used");
					}
				if(g.getSecondPlayer().getTeam().contains(g.getCurrentChampion()))
				{	
				lead2.setText(null);
				lead2.setText("‘Leader Ability‘ already used");
				}
				editView();
			} catch (LeaderNotCurrentException e1) {
				JOptionPane.showMessageDialog(null,"The current champion is not a leader" ,"Error",JOptionPane.ERROR_MESSAGE);

			} catch (LeaderAbilityAlreadyUsedException e1) {
				JOptionPane.showMessageDialog(null,"This leader already used his ability" ,"Error",JOptionPane.ERROR_MESSAGE);
			}
			
		}

		if(e.getSource()==ability) {

			if(current.isVisible()) {
				current.setVisible(false);
			}
			int index = ability.getSelectedIndex();
					Ability ab = g.getCurrentChampion().getAbilities().get(index);
					
			if(ab.getCastArea()==AreaOfEffect.DIRECTIONAL) {
				String[] responses = {"UP","DOWN","LEFT","RIGHT"};
				int answer = JOptionPane.showOptionDialog(null, "Choose direction of the ability", "Cast Ability", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, 
						null, responses, 0);

				try {
					if(answer==0) {
						g.castAbility(ab, Direction.UP);
						this.editView();
						this.over();
					}
					if(answer==1) {
						g.castAbility(ab, Direction.DOWN);
						this.editView();
						this.over();
					}
					if(answer==0) {
						g.castAbility(ab, Direction.LEFT);
						this.editView();
						this.over();
					}
					if(answer==0) {
						g.castAbility(ab, Direction.RIGHT);
						this.editView();
						this.over();
					}

				} catch (NotEnoughResourcesException e1) {

					JOptionPane.showMessageDialog(null,"you need at least " + ab.getManaCost() + " mana and at least " + ab.getRequiredActionPoints() + " action points to cast this ability" ,"Error",JOptionPane.ERROR_MESSAGE);

				} catch (AbilityUseException e1) {

					JOptionPane.showMessageDialog(null,"Can not cast an ability while being silenced or its in cooldown" ,"Error",JOptionPane.ERROR_MESSAGE);

				} catch (CloneNotSupportedException e1) {

					JOptionPane.showMessageDialog(null,"Clone not supported exception" ,"Error",JOptionPane.ERROR_MESSAGE);
				}
			}

			if(ab.getCastArea()==AreaOfEffect.SINGLETARGET) {

				String x = JOptionPane.showInputDialog("Enter x");
				String y = JOptionPane.showInputDialog("Enter y");

				int X = Integer.parseInt(x);
				int Y = Integer.parseInt(y);

				try {
					g.castAbility(ab, X, Y);
					this.editView();
					this.over();
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null,"you need at least " + ab.getManaCost() + " mana and at least " + ab.getRequiredActionPoints() + " action points to cast this ability" ,"Error",JOptionPane.ERROR_MESSAGE);
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null,"Can not cast an ability while being silenced or its in cooldown" ,"Error",JOptionPane.ERROR_MESSAGE);
				} catch (InvalidTargetException e1) {
					JOptionPane.showMessageDialog(null,"Invalid Target" ,"Error",JOptionPane.ERROR_MESSAGE);
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null,"Clone not supported exception" ,"Error",JOptionPane.ERROR_MESSAGE);
				}

			}
			
			if(ab.getCastArea()==AreaOfEffect.SELFTARGET || ab.getCastArea()==AreaOfEffect.SURROUND || ab.getCastArea()==AreaOfEffect.TEAMTARGET) {
				
				try {
					g.castAbility(ab);
					this.editView();
					this.over();
				} catch (NotEnoughResourcesException e1) {
					JOptionPane.showMessageDialog(null,"you need at least " + ab.getManaCost() + " mana and at least " + ab.getRequiredActionPoints() + " action points to cast this ability" ,"Error",JOptionPane.ERROR_MESSAGE);
				} catch (AbilityUseException e1) {
					JOptionPane.showMessageDialog(null,"Can not cast an ability while being silenced or its in cooldown" ,"Error",JOptionPane.ERROR_MESSAGE);
				} catch (CloneNotSupportedException e1) {
					JOptionPane.showMessageDialog(null,"Clone not supported exception" ,"Error",JOptionPane.ERROR_MESSAGE);
				}
				
			}
			
			
			
		}


		if(e.getSource()==move) {
			if(current.isVisible()) {
				current.setVisible(false);
			}
			String[] responses = {"UP","DOWN","LEFT","RIGHT"};
			int answer = JOptionPane.showOptionDialog(null, "Choose direction of the move", "Move", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, 
					null, responses, 0);

			try {
				if(answer==0) {
					Point p = g.getCurrentChampion().getLocation();
					int x = (int) p.getX(); int y= (int)p.getY();
					g.move(Direction.UP);
					Point newp = g.getCurrentChampion().getLocation();
					int newx = (int) newp.getX(); int newy= (int)newp.getY();

					if((g.getCurrentChampion().getName().equals(g.getFirstPlayer().getLeader().getName())) || (g.getCurrentChampion().getName().equals(g.getSecondPlayer().getLeader().getName())))
					{
						labels[x][y].setBorder(null);
						labels[newx][newy].setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
					}
					Component[] components = ((JLabel)labels[x][y]).getComponents();
					Icon temp = ((JLabel)labels[x][y]).getIcon();
					((JLabel)labels[newx][newy]).setIcon(temp);
					String text = ((JLabel)labels[x][y]).getText();
					((JLabel)labels[newx][newy]).setText(text);
					((JLabel)labels[x][y]).setText("");
					for (Component component : components) {
						((JLabel)labels[newx][newy]).add(component);
						((JLabel)labels[x][y]).remove(component);  
					}
					((JLabel)labels[x][y]).setIcon(null);
					((JLabel)labels[x][y]).revalidate();
					((JLabel)labels[x][y]).repaint();	

				}
				if(answer==1) {
					Point p = g.getCurrentChampion().getLocation();
					int x = (int) p.getX(); int y= (int)p.getY();
					g.move(Direction.DOWN);
					Point newp = g.getCurrentChampion().getLocation();
					int newx = (int) newp.getX(); int newy= (int)newp.getY();

					if((g.getCurrentChampion().getName().equals(g.getFirstPlayer().getLeader().getName())) || (g.getCurrentChampion().getName().equals(g.getSecondPlayer().getLeader().getName())))
					{
						labels[x][y].setBorder(null);
						labels[newx][newy].setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
					}
					Component[] components = ((JLabel)labels[x][y]).getComponents();
					Icon temp = ((JLabel)labels[x][y]).getIcon();
					((JLabel)labels[newx][newy]).setIcon(temp);
					String text = ((JLabel)labels[x][y]).getText();
					((JLabel)labels[newx][newy]).setText(text);
					((JLabel)labels[x][y]).setText("");

					for (Component component : components) {
						((JLabel)labels[newx][newy]).add(component);
						((JLabel)labels[x][y]).remove(component);  
					}
					((JLabel)labels[x][y]).setIcon(null);
					((JLabel)labels[x][y]).revalidate();
					((JLabel)labels[x][y]).repaint();	

				}
				if(answer==2) {
					Point p = g.getCurrentChampion().getLocation();
					int x = (int) p.getX(); int y= (int)p.getY();
					g.move(Direction.LEFT);
					Point newp = g.getCurrentChampion().getLocation();
					int newx = (int) newp.getX(); int newy= (int)newp.getY();

					if((g.getCurrentChampion().getName().equals(g.getFirstPlayer().getLeader().getName())) || (g.getCurrentChampion().getName().equals(g.getSecondPlayer().getLeader().getName())))
					{
						labels[x][y].setBorder(null);
						labels[newx][newy].setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
					}
					Component[] components = ((JLabel)labels[x][y]).getComponents();
					Icon temp = ((JLabel)labels[x][y]).getIcon();
					((JLabel)labels[newx][newy]).setIcon(temp);
					String text = ((JLabel)labels[x][y]).getText();
					((JLabel)labels[newx][newy]).setText(text);
					((JLabel)labels[x][y]).setText("");

					for (Component component : components) {
						((JLabel)labels[newx][newy]).setIcon(temp);
						((JLabel)labels[newx][newy]).add(component);
						((JLabel)labels[x][y]).remove(component);  
					}
					((JLabel)labels[x][y]).setIcon(null);
					((JLabel)labels[x][y]).revalidate();
					((JLabel)labels[x][y]).repaint();	

				}
				if(answer==3) {
					Point p = g.getCurrentChampion().getLocation();
					int x = (int) p.getX(); int y= (int)p.getY();
					g.move(Direction.RIGHT);
					Point newp = g.getCurrentChampion().getLocation();
					int newx = (int) newp.getX(); int newy= (int)newp.getY();
					if((g.getCurrentChampion().getName().equals(g.getFirstPlayer().getLeader().getName())) || (g.getCurrentChampion().getName().equals(g.getSecondPlayer().getLeader().getName())))
					{
						labels[x][y].setBorder(null);
						labels[newx][newy].setBorder(BorderFactory.createLineBorder(new Color(140,0,0),5));
					}
					Component[] components = ((JLabel)labels[x][y]).getComponents();
					Icon temp = ((JLabel)labels[x][y]).getIcon();
					((JLabel)labels[newx][newy]).setIcon(temp);
					String text = ((JLabel)labels[x][y]).getText();
					((JLabel)labels[newx][newy]).setText(text);
					((JLabel)labels[x][y]).setText("");

					for (Component component : components) {
						((JLabel)labels[newx][newy]).add(component);
						((JLabel)labels[x][y]).remove(component);  
					}
					((JLabel)labels[x][y]).setIcon(null);
					((JLabel)labels[x][y]).revalidate();
					((JLabel)labels[x][y]).repaint();	

				}

			} catch (UnallowedMovementException e2) {

				JOptionPane.showMessageDialog(null,"Invalid Movement" ,"Error",JOptionPane.ERROR_MESSAGE);
			}
			catch(NotEnoughResourcesException e2) {

				JOptionPane.showMessageDialog(null,"You need at least one action point to MOVE" ,"Error",JOptionPane.ERROR_MESSAGE);
			}

		}

		if(e.getSource()==endturn) {

			if(current.isVisible()) {
				current.setVisible(false);
			}
			g.endTurn();
			order = new String[6];
			turns.removeAllItems();
			
			for(int j=g.getTurnOrder().size()-1 ; j>=0 ; j--)
			{
				if(g.getTurnOrder().getElements()[j] != null)
					turns.addItem(((Champion)(g.getTurnOrder().getElements()[j])).getName());
			}
			
			
			ability.removeActionListener(this);

			ability.removeAllItems();
			
			for(int j=0 ; j<g.getCurrentChampion().getAbilities().size();j++) {
				ability.addItem(g.getCurrentChampion().getAbilities().get(j).getName());
			}

			ability.addActionListener(this);
			
			
		}

		if(e.getSource()==comp1) {

			frame = new JFrame();
			frame.setSize(400,400);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Cover c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if((labelsofCover.get(0)).getText().equals((labels[f][s]).getText()))
					{
						c = (Cover) g.getBoard()[f][s]; 
					}
				}

			}
			JLabel text = new JLabel("<html><body>CurrentHp : " + c.getCurrentHP() +"</body></html>" , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp2) {

			frame = new JFrame();
			frame.setSize(400,400);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Cover c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if((labelsofCover.get(1)).getText().equals((labels[f][s]).getText()))
					{
						c = (Cover) g.getBoard()[f][s]; 
					}
				}

			}
			JLabel text = new JLabel("<html><body>CurrentHp : " + c.getCurrentHP() +"</body></html>" , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp3) {

			frame = new JFrame();
			frame.setSize(400,400);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Cover c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if((labelsofCover.get(2)).getText().equals((labels[f][s]).getText()))
					{
						c = (Cover) g.getBoard()[f][s]; 
					}
				}

			}
			JLabel text = new JLabel("<html><body>CurrentHp : " + c.getCurrentHP() +"</body></html>" , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp4) {
			frame = new JFrame();
			frame.setSize(400,400);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Cover c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if((labelsofCover.get(3)).getText().equals((labels[f][s]).getText()))
					{
						c = (Cover) g.getBoard()[f][s]; 
					}
				}

			}
			JLabel text = new JLabel("<html><body>CurrentHp : " + c.getCurrentHP() +"</body></html>" , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp5) {

			frame = new JFrame();
			frame.setSize(400,400);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Cover c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if((labelsofCover.get(4)).getText().equals((labels[f][s]).getText()))
					{
						c = (Cover) g.getBoard()[f][s]; 
					}
				}

			}
			JLabel text = new JLabel("<html><body>CurrentHp : " + c.getCurrentHP() +"</body></html>" , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}

		if(e.getSource()==comp6) {

			frame = new JFrame();
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Champion c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if(("champ1").equals((labels[f][s]).getText()))
					{
						c = (Champion) g.getBoard()[f][s]; 
					}
				}

			}
			String type=null;
			if(c instanceof Hero)
				type="Hero";
			if(c instanceof Villain)
				type="Villain";
			if(c instanceof AntiHero)
				type="AntiHero";
			
			ArrayList<String> appliedeffect = new ArrayList<>();
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				String effect =""+ c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration();		
				appliedeffect.add(effect);
			}
			
			JLabel text = new JLabel("<html><body>Type:"+type+"<html><body><br> Name: " + c.getName() + "<html><body><br>CurrentHP: " + c.getCurrentHP() + "<html><body><br>Mana: " + 
					c.getMana() + "<html><body><br>Speed: " + c.getSpeed() + "<html><body><br>maxAP: " + 
					c.getMaxActionPointsPerTurn() + "<html><body><br>Att.Damage: " + c.getAttackDamage() + 
					"<html><body><br>Range: " + c.getAttackRange() + "<html><body><br> Leader: "
					+ (c.getName().equals(g.getSecondPlayer().getLeader().getName())) + "<html><body><br> Applied Effect: " +
					appliedeffect, SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp7) {

			frame = new JFrame();
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Champion c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if(("champ2").equals((labels[f][s]).getText()))
					{
						c = (Champion) g.getBoard()[f][s]; 
					}
				}

			}
			String type=null;
			if(c instanceof Hero)
				type="Hero";
			if(c instanceof Villain)
				type="Villain";
			if(c instanceof AntiHero)
				type="AntiHero";
			ArrayList<String> appliedeffect = new ArrayList<>();
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				String effect =""+ c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration();		
				appliedeffect.add(effect);
			}
			JLabel text = new JLabel("<html><body>Type:"+type+"<html><body><br> Name: " + c.getName() + "<html><body><br>CurrentHP: " + c.getCurrentHP() + "<html><body><br>Mana: " + 
					c.getMana() + "<html><body><br>Speed: " + c.getSpeed() + "<html><body><br>maxAP: " + 
					c.getMaxActionPointsPerTurn() + "<html><body><br>Att.Damage: " + c.getAttackDamage() + 
					"<html><body><br>Range: " + c.getAttackRange() + "<html><body><br> Leader: "
					+ (c.getName().equals(g.getSecondPlayer().getLeader().getName()))+ "<html><body><br> Applied Effect: " +
							appliedeffect  , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}

		if(e.getSource()==comp8) {

			frame = new JFrame();
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Champion c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if(("champ3").equals((labels[f][s]).getText()))
					{
						c = (Champion) g.getBoard()[f][s]; 
					}
				}

			}
			String type=null;
			if(c instanceof Hero)
				type="Hero";
			if(c instanceof Villain)
				type="Villain";
			if(c instanceof AntiHero)
				type="AntiHero";
			
			ArrayList<String> appliedeffect = new ArrayList<>();
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				String effect =""+ c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration();		
				appliedeffect.add(effect);
			}
			JLabel text = new JLabel("<html><body>Type:"+type+"<html><body><br> Name: " + c.getName() + "<html><body><br>CurrentHP: " + c.getCurrentHP() + "<html><body><br>Mana: " + 
					c.getMana() + "<html><body><br>Speed: " + c.getSpeed() + "<html><body><br>maxAP: " + 
					c.getMaxActionPointsPerTurn() + "<html><body><br>Att.Damage: " + c.getAttackDamage() + 
					"<html><body><br>Range: " + c.getAttackRange()+ "<html><body><br> Leader: "
					+ (c.getName().equals(g.getSecondPlayer().getLeader().getName()))+ "<html><body><br> Applied Effect: " +
							appliedeffect  , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp9) {

			frame = new JFrame();
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Champion c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if(("champ4").equals((labels[f][s]).getText()))
					{
						c = (Champion) g.getBoard()[f][s]; 
					}
				}

			}
			String type=null;
			if(c instanceof Hero)
				type="Hero";
			if(c instanceof Villain)
				type="Villain";
			if(c instanceof AntiHero)
				type="AntiHero";
			
			ArrayList<String> appliedeffect = new ArrayList<>();
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				String effect =""+ c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration();		
				appliedeffect.add(effect);
			}
			JLabel text = new JLabel("<html><body>Type:"+type+"<html><body><br> Name: "+ c.getName() + "<html><body><br>CurrentHP: " + c.getCurrentHP() + "<html><body><br>Mana: " + 
					c.getMana() + "<html><body><br>Speed: " + c.getSpeed() + "<html><body><br>maxAP: " + 
					c.getMaxActionPointsPerTurn() + "<html><body><br>Att.Damage: " + c.getAttackDamage() + 
					"<html><body><br>Range: " + c.getAttackRange()  + "<html><body><br> Leader: "
					+ (c.getName().equals(g.getFirstPlayer().getLeader().getName()))+ "<html><body><br> Applied Effect: " +
							appliedeffect, SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}

		if(e.getSource()==comp10) {

			frame = new JFrame();
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Champion c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if(("champ5").equals((labels[f][s]).getText()))
					{
						c = (Champion) g.getBoard()[f][s]; 
					}
				}

			}
			String type=null;
			if(c instanceof Hero)
				type="Hero";
			if(c instanceof Villain)
				type="Villain";
			if(c instanceof AntiHero)
				type="AntiHero";
			ArrayList<String> appliedeffect = new ArrayList<>();
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				String effect =""+ c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration();		
				appliedeffect.add(effect);
			}
			JLabel text = new JLabel("<html><body>Type:"+type+"<html><body><br> Name: "+ c.getName() + "<html><body><br>CurrentHP: " + c.getCurrentHP() + "<html><body><br>Mana: " + 
					c.getMana() + "<html><body><br>Speed: " + c.getSpeed() + "<html><body><br>maxAP: " + 
					c.getMaxActionPointsPerTurn() + "<html><body><br>Att.Damage: " + c.getAttackDamage() + 
					"<html><body><br>Range: " + c.getAttackRange() + "<html><body><br> Leader: "
					+ (c.getName().equals(g.getFirstPlayer().getLeader().getName()))+ "<html><body><br> Applied Effect: " +
							appliedeffect , SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}
		if(e.getSource()==comp11) {

			frame = new JFrame();
			frame.setSize(600,500);
			frame.setLocationRelativeTo(null);
			frame.getContentPane().setBackground(new Color(140,0,0));
			frame.setTitle("Marvel Game");
			ImageIcon marvel = new ImageIcon("marvelgame.png");
			frame.setIconImage(marvel.getImage());
			int f=0;
			int s = 0;
			Champion c=null;
			for( f=0;f<5;f++) {
				for( s=0;s<5;s++)
				{
					if(("champ6").equals((labels[f][s]).getText()))
					{
						c = (Champion) g.getBoard()[f][s]; 
					}
				}

			}
			String type=null;
			if(c instanceof Hero)
				type="Hero";
			if(c instanceof Villain)
				type="Villain";
			if(c instanceof AntiHero)
				type="AntiHero";
			ArrayList<String> appliedeffect = new ArrayList<>();
			for(int i=0 ; i<c.getAppliedEffects().size();i++) {
				String effect =""+ c.getAppliedEffects().get(i).getName() + "-" + c.getAppliedEffects().get(i).getDuration();		
				appliedeffect.add(effect);
			}
			JLabel text = new JLabel("<html><body>Type:"+type+"<html><body><br> Name: " + c.getName() + "<html><body><br>CurrentHP: " + c.getCurrentHP() + "<html><body><br>Mana: " + 
					c.getMana() + "<html><body><br>Speed: " + c.getSpeed() + "<html><body><br>maxAP: " + 
					c.getMaxActionPointsPerTurn() + "<html><body><br>Att.Damage: " + c.getAttackDamage() + 
					"<html><body><br>Range: " + c.getAttackRange()  + "<html><body><br> Leader: "
					+ (c.getName().equals(g.getFirstPlayer().getLeader().getName()))+ "<html><body><br> Applied Effect: " +
							appliedeffect, SwingConstants.CENTER);
			text.setFont(new Font("Serif",Font.BOLD,20));
			text.setForeground(Color.white);
			frame.add(text , BorderLayout.CENTER);
			frame.setVisible(true);

		}

		if(e.getSource()==attack) {

			if(current.isVisible()) {
				current.setVisible(false);
			}
			String[] responses = {"UP","DOWN","LEFT","RIGHT"};
			int answer = JOptionPane.showOptionDialog(null, "Choose direction of the ATTACK", "Move", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE, 
					null, responses, 0);

			try {

				if(answer==0) {
					g.attack(Direction.UP);
					editView();
					this.over();
				}

				if(answer==1) {
					g.attack(Direction.DOWN);   
					editView();
					this.over();
				}

				if(answer==2) {
					g.attack(Direction.LEFT);
					editView();
					this.over();
				}

				if(answer==3) {
					g.attack(Direction.RIGHT);	
					editView();
					this.over();
					
				}

			} catch (NotEnoughResourcesException e1) {

				JOptionPane.showMessageDialog(null,"You need at least two action point to perform a normal attack" ,"Error",JOptionPane.ERROR_MESSAGE);

			} catch (ChampionDisarmedException e1) {

				JOptionPane.showMessageDialog(null,"Can not attack while being disarmed" ,"Error",JOptionPane.ERROR_MESSAGE);

			} catch (InvalidTargetException e1) {

				JOptionPane.showMessageDialog(null,"Invalid Target" ,"Error",JOptionPane.ERROR_MESSAGE);

			}


		}

	}
	
	public void editView () {
		
		for(int i=0 ; i<allComps.size() ; i++) {
			
			if(allComps.get(i).getCurrentHP()==0) {
				
				Point p = allComps.get(i).getLocation();
				int x = (int)p.getX(); int y= (int) p.getY();
				Damageable n = (Damageable) allComps.get(i);
				if(n instanceof Champion)
				{
					if(g.getFirstPlayer().getTeam().contains(n)) {
						for(int g=0 ; g<firstteambuttons.length ; g++) {

							if((firstteambuttons[g]).getText().equals(((Champion)n).getName())){
								firstteambuttons[g].setVisible(false);
							}	
						}
					}
					if(g.getSecondPlayer().getTeam().contains(n)) {
						for(int g=0 ; g<secondteambuttons.length ; g++) {

							if((secondteambuttons[g]).getText().equals(((Champion)n).getName())){
								secondteambuttons[g].setVisible(false);
							}	
						}
					}
				}
				if(n instanceof Champion)
					if((((Champion)n).getName().equals(g.getFirstPlayer().getLeader().getName())) || (((Champion)n).getName().equals(g.getSecondPlayer().getLeader().getName())))
					{
						labels[x][y].setBorder(null);
					}

				((JLabel)labels[x][y]).setText("");
				Component[] components = ((JLabel)labels[x][y]).getComponents();

					for (Component component : components) {
						((JLabel)labels[x][y]).remove(component);  
					}
						((JLabel)labels[x][y]).setIcon(null);
					
				
					allComps.remove(i);	
					((JLabel)labels[x][y]).revalidate();
					((JLabel)labels[x][y]).repaint();	
					
				
			}
			
		}
		
	}
	
	public void over() {
		
		if(g.checkGameOver()!=null) {
		Player winner = g.checkGameOver();
		frame.dispose();
		over = new OverPage(winner);
		}
	}


}
