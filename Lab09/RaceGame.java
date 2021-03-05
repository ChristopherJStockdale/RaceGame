/* 
 *
 * Project: JavaFX Template
 * Purpose: Lab 09
 * Author: Christopher Stockdale
 * Course: CS - 225 (Fall '20)
 *
 */

public class RaceGame {
	// declare race end
	private final static int RACEEND = 100;
	// declare racers
	// array of GanericRacer with 4 slots
	public GenericRacer[] racers = new GenericRacer[4]; 
	
	public double[] racersLoc = new double[4];
 
	public RaceGame() {
		// 1. declare all starting points
		// slot 1 is Racer 1
		racers[0] = new Racer1("Urza");
		// slot 2 is Racer 2
		racers[1] = new Racer2("Fenix");
		// slot 3 is Racer 3
		racers[2] = new Racer3("Drek");
		// slot 4 is Racer 4
		racers[3] = new Racer4("Dijkstra");
		
		// racer 1 location
		racersLoc[0] = 0;
		// racer 2 location
		racersLoc[1] = 0;
		// racer 3 location
		racersLoc[2] = 0;
		// racer 4 location
		racersLoc[3] = 0;
	}
	
	
	
	// check to see if the game is complete
	public boolean gameOver() {
		boolean gameover = false;
		// check every one
		for (int i = 0; i < racers.length; i++) {
			// if someone crossed the finish line 
			if (racers[i].getLocation()>=RACEEND) {
				gameover = true;
			}
		}
		return gameover;
	}
	// move each racer
	public void moveRacers() {
		for (int i = 0; i < racers.length; i++) {
			racers[i].move();
			racersLoc[i] = racers[i].getLocation(); 
		}
	}
	// getter for racers
	public GenericRacer[] getRacers() {
		return racers;
	}
}
