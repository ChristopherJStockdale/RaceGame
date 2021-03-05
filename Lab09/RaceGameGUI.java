/* 
 *
 * Project: JavaFX Template
 * Purpose: Lab 09
 * Author: Christopher Stockdale
 * Course: CS - 225 (Fall '20)
 *
 */

// --------- IMPORTS ---------
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
// ---------------------------


public class RaceGameGUI extends Application {
	public static int turn;
	Pane pane = new Pane();
	StackPane holder = new StackPane();

	public RaceGameGUI() {
		
		
		RaceGame rg = new RaceGame();
		//misc
		
				Text turnCount = new Text();
				turnCount.setX(10);
				turnCount.setY(390);
				turnCount.setFill(Color.WHITE);
				
				Text racer1Text = new Text();
				racer1Text.setX(10);
				racer1Text.setY(200);
				racer1Text.setFill(Color.RED);
				
				Text racer2Text = new Text();
				racer2Text.setX(10);
				racer2Text.setY(220);
				racer2Text.setFill(Color.BLUE);
				
				Text racer3Text = new Text();
				racer3Text.setX(10);
				racer3Text.setY(240);
				racer3Text.setFill(Color.GREEN);
				
				Text racer4Text = new Text();
				racer4Text.setX(10);
				racer4Text.setY(260);
				racer4Text.setFill(Color.YELLOW);
		// make shapes
				
				//finish-line
				
				Line finish = new Line();				
				finish.setStartX(710);
				finish.setStartY(-100);
				finish.setEndX(710);
				finish.setEndY(500);
				finish.setStroke(Color.WHITE); 
			//Racers
				
				Circle racer1 = new Circle(5);
				double r1X = 10;
				racer1.setCenterX(r1X); 
				racer1.setCenterY(10.0f); 
			    racer1.setRadius(10.0f); 
		        racer1.setFill(javafx.scene.paint.Color.RED); 
		        //
		        Circle racer2 = new Circle(5);
		        double r2X = 10;
		        racer2.setCenterX(r2X); 
		        racer2.setCenterY(60.0f); 
		        racer2.setRadius(10.0f); 
		        racer2.setFill(javafx.scene.paint.Color.BLUE); 
		        //
		        Circle racer3 = new Circle(5);
		        double r3X = 10;
		        racer3.setCenterX(r3X); 
		        racer3.setCenterY(110.0f); 
		        racer3.setRadius(10.0f); 
		        racer3.setFill(javafx.scene.paint.Color.GREEN); 
		        //
		        Circle racer4 = new Circle(5);
		        double r4X = 10;
		        racer4.setCenterX(r4X); 
		        racer4.setCenterY(160.0f); 
		        racer4.setRadius(10.0f); 
		        racer4.setFill(javafx.scene.paint.Color.YELLOW); 
		        //
				
				pane.getChildren().add(racer1);
				pane.getChildren().add(racer2);
				pane.getChildren().add(racer3);
				pane.getChildren().add(racer4);
				pane.getChildren().add(turnCount);
				pane.getChildren().add(finish);
				pane.getChildren().add(racer1Text);
				pane.getChildren().add(racer2Text);
				pane.getChildren().add(racer3Text);
				pane.getChildren().add(racer4Text);
				
			
				
		
		
		
		// we do not have while loops in GUI so a Timeline is used
		// make timeline
		Timeline timeline = new Timeline();
		// make timeline repeat infinite number of times
		timeline.setCycleCount(Timeline.INDEFINITE);
		// timeline uses keyframes so make a keyframe
		//make a keyframe that runs every half second
		// keyframe can use a lambda expression for its action
		KeyFrame keyframe = new KeyFrame(Duration.millis(500), action -> {
			
			// do something
			
			
			rg.moveRacers();
			
			double r1L = rg.racersLoc[0];
			racer1.setLayoutX(r1L*7);
			System.out.println(r1L);
			String r1T = " position: ";
			racer1Text.setText(rg.racers[0].getName()+r1T+r1L);
			
			double r2L = rg.racersLoc[1];
			racer2.setLayoutX(r2L*7);
			System.out.println(r2L);
			String r2T = " position: ";
			racer2Text.setText(rg.racers[1].getName()+r2T+r2L);
			
			double r3L = rg.racersLoc[2];
			racer3.setLayoutX(r3L*7);
			System.out.println(r3L);
			String r3T = " position: ";
			racer3Text.setText(rg.racers[2].getName()+r3T+r3L);
			
			double r4L = rg.racersLoc[3];
			racer4.setLayoutX(r4L*7);
			System.out.println(r4L);
			String r4T = " position: ";
			racer4Text.setText(rg.racers[3].getName()+r4T+r4L);
			
			String turnText = "The current time is: " + getTurn() + " seconds.";
			turnCount.setText(turnText);
		
		boolean end = rg.gameOver();
		if (end == true) {
			System.out.println("The Race is Over!");
			
			if (r1L > r2L && r1L > r3L && r1L > r4L) {
				Text r1Win = new Text();
				r1Win.setText("Racer 1 Wins!");
				r1Win.setX(450);
				r1Win.setY(200);
				r1Win.setFill(Color.RED);
				pane.getChildren().add(r1Win);
			}
			
			else if (r2L > r1L && r2L > r3L && r2L > r4L) {
				Text r2Win = new Text();
				r2Win.setText("Racer 2 Wins!");
				r2Win.setX(450);
				r2Win.setY(200);
				r2Win.setFill(Color.BLUE);
				pane.getChildren().add(r2Win);
			}
			
			else if (r3L > r1L && r3L > r2L && r3L > r4L) {
				Text r3Win = new Text();
				r3Win.setText("Racer 3 Wins!");
				r3Win.setX(450);
				r3Win.setY(200);
				r3Win.setFill(Color.GREEN);
				pane.getChildren().add(r3Win);
			}
			
			else { 
				Text r4Win = new Text();
				r4Win.setText("Racer 4 Wins!");
				r4Win.setX(450);
				r4Win.setY(200);
				r4Win.setFill(Color.YELLOW);
				pane.getChildren().add(r4Win);
			}
			
			
			
			timeline.stop();
			
		}
		else {
			
		}
		
		int turn = getTurn();
		setTurn(turn+1);
		System.out.println(turn);
			
		});

		// add keyframe to timeline
		timeline.getKeyFrames().add(keyframe);

		// start the timeline
		timeline.play();


	}

	@Override
	public void start(Stage stage) {

		stage.setTitle("Race Game");
		stage.setScene(new Scene(pane, 1000, 400, Color.BLACK));
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public static int getTurn() {
		;
		return turn;
	}
	
	public static void setTurn(int newTurn) {
		turn = newTurn;
	}
	


}
