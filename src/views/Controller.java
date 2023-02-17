package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import engine.Game;

public class Controller {

	Game game;
	HomePage home;
	ChampionPage prepare;
	PlayPage play;
	Credits credit;
	
	public Controller() {
		 
		home = new HomePage();	
		
	}
		
	
	public static void main (String [] args) {
		
		Controller AllViews = new Controller();
		

}
}
