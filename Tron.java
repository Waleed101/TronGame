/**********************************************************
	File: Tron.java 
	Purpose: Advanced Tron game with single player and multiplayer modes. The user can control the colors of the players,
   the speed of the players, and the number of max points. The user can also mute the game.
	Author: Waleed Sawan
	Date: December 26, 2017
   Time: 10:51 PM
	Based on: ICS3U Java Final Assignment    
********************************************************
*/

// Library to deal with JFrame and the board
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;

// Library to deal with keyboard input
import javax.swing.*;

// Library for scanner class
import java.util.Scanner;

// Library to deal with text file inputs and outputs
import java.io.*;

// Library to deal with sound effects
import javax.sound.sampled.Clip;
 
class Tron extends JFrame
        implements KeyListener,
        ActionListener
{
    static int row = 24, col = 19, rowP2 = 24, colP2 = 68, directionP1 = 2, directionP2 = 4, size = 48, sizeCol = 89, speed = 70, scoreP1 = 0, scoreP2 = 0, prevSpeed = speed, maxScore = 3, prevMax = maxScore, roundno = 1, prevScoreP1 = scoreP1, prevScoreP2 = scoreP2;
    
    /*
     * Above variables deal with starting position of both players, starting direction (1 being north, 4 being west), speed of both players, players score, 
     * and max round score, previous speed and previous max round score for algorithims, current round no, previous score of player one and two from the previous round 
    */  
    
    static Board gameBoard = new Board(size,sizeCol); // Declaring the board - visual purposes
    static String[][] boardInfo = new String[size][sizeCol]; // Declaring the board array - logical purposes
    static boolean game = false, ftime = true, curGame = true, oneplayer = false, off = false, setFtime = true, homeScreen = true, tie = false, playSound = true;
    
    /*
     * Boolean to hold main game running, ftime to hold if it is the start of a new round, curGame to hold if the round is over or still going, onePlayer to know
     * if the user wants to play against computer or human opponent, setFtime for settings, homeScreen to know what screen to display, and tie to check if tie is true
    */  
    
    static String roundWinner = "na", colorP1 = "redP1", colorP2 = "redP2";
    
    /*
     * String to hold the current round winner, the color of player one and the color of player two
    */
    
    static Coordinate click; // Static variable for coordinate click
    static Clip music = JCanvas.loadClip("backgroundV2.mp3");
    JTextField typingArea; // Typing for controls is shown
    
    static void resetVars() // Reset the variables for every round (eg. Player One starting point)
    {
      ftime = true;
      curGame = true;
      row = 24;
      col = 68;
      rowP2 = 24;
      colP2 = 19;
      directionP1 = 4;
      directionP2 = 2;
    }
    
    static void scanData() throws IOException // Function to read setting values from tronSettings and tronColors
    {
     File dataFile = new File("tronSettings.txt");  
     Scanner scanFile = new Scanner(dataFile);
     speed = scanFile.nextInt(); // Read speed of players
     maxScore = scanFile.nextInt(); // Read maxScore of players
     scanFile.close();
     File dataColor = new File("tronColors.txt"); 
     Scanner scanString = new Scanner(dataColor);
     colorP1 = scanString.nextLine(); // Read color of player one
     colorP2 = scanString.nextLine(); // Read color of player two
     scanString.close();
    }
    
    static void addNewData() throws IOException // Function to update data for tronSettings and tronColors
    {
      File nameFile = new File("tronSettings.txt"); 
      PrintStream printToFile = new PrintStream(nameFile);
      printToFile.println(speed); // Write speed of players
      printToFile.println(maxScore); // Write maxScore of players
      printToFile.close();
      File stringFile = new File("tronColors.txt");
      PrintStream printToString = new PrintStream(stringFile);
      printToString.println(colorP1); // Write color of player one
      printToString.println(colorP2); // Write color of player two
      printToString.close();
    }
    
    static void drawBox() // Function to draw boxes for the score and the countdown/buttons
    {
     removeBoxBorders(); // Remove box borders to add score, and button boxes
     // Add outline for top left box - score player two 
     for(int i=0; i<10; i++) 
      addPeg("red", i, 6);  
     for(int i=5; i!=-1; i--)
      addPeg("red", 9, i);  
     
     // Add outline for top right box - score player one
     for(int i=0; i<10; i++)
      addPeg("red", i, 82);  
     for(int i=82; i<89; i++)
      addPeg("red", 9, i); 
     
     // Add outline for top middle box - buttons and countdown
     for(int i=0; i<10; i++)
     {
      addPeg("red", i, 35);
      addPeg("red", i, 52);
     }
     for(int i=35; i<53; i++)
      addPeg("red", 9, i);
    }
    
    static void removeBoxBorders() // Function to remove box borders to help draw the top 
    {
      for(int i=0; i<10; i++) // Remove box borders for the top right and left
      {
         removePeg(i, 82);
         removePeg(i, 88);
         removePeg(i, 0);
      }
      removePeg(0,5); 
      removePeg(0,6);
      for(int i=0; i<5; i++) // Remove box borders for the top right and left
      {
         removePeg(0, 83+i);
         removePeg(0, i);
      }
      for(int i=36; i<52; i++) // Remove box borders for the top center
         removePeg(0, i);
    }
    
    
       
    static void removePeg(int rowR, int colR) // Function to remove peg visually and logically
    { 
      gameBoard.removePeg(rowR, colR); // Removes peg from the gameboard
      boardInfo[rowR][colR] = "empty"; // Removes peg from the board info array - set row col to empty
    }
    
    static void addPeg(String color, int rowA, int colA)// Function to add peg visually and logically
    {
      gameBoard.putPeg(color, rowA, colA); // Adds peg to the gameboard
      boardInfo[rowA][colA] = color; // Adds peg to the board Info array - set row col to the color
    }
    
 
    static void displayScore(int score, String color, int row, int col) // Function to display users score
    {
     letters.typeNumbers(score, gameBoard, row, col, color);
    }
      
    static void outlineBoard() // Function to outline the entire user board
    {
      
      for(int i=0; i < size; i++) // Outline the right and left sides
      {
         addPeg("red", i, 0);
         addPeg("red", i, sizeCol-1);
      }
      
      for(int i=0; i < sizeCol; i++) // Outline the top and bottom sides
      {
         addPeg("red", 0, i);
         addPeg("red", size-1, i);
      }      
    }
    
           
    static void soundEffects(int type) // Function of sound effects
    {
      String clipName = "backgroundV2.mp3";
      switch(type)
      {
         case 1: // Countdown; 5, 4, 3, 2, 1, GOOOOO!
         clipName = "countdown.wav";
         break;
         
         case 2: // Click; '/click'
         clipName = "click.wav";
         break;
         
         case 3: // Gameover; gameover from original tron game
         clipName = "gameover.wav";
         break;
      }
      Clip clip = JCanvas.loadClip(clipName); // Load the clip
      if(playSound)
      {
            JCanvas.playClip(clip); // Play the clip only if music is set to true 
            if(off)
            {
               JCanvas.playClip(music);
               off = false;
            }
      }
      else
            JCanvas.stopClip(music); // Stop the music if sound is off
      }
    
    static void countdown() throws InterruptedException // Function to add countdown to top box 
    {
      displayScore(scoreP1, colorP1, 1, 1); // Display the score of player one during the countdown
      displayScore(scoreP2, colorP2, 1, 84); // Display the score of player two during the countdown
      letters.typeLetters("Round No. ", gameBoard, 20, 18, "white"); // Display the current round number during the countdown
      letters.typeNumbers(roundno, gameBoard, 19, 60, "white");
      soundEffects(1);
      letters.typeNumbers(5, gameBoard, 1, 42,"green"); // Write five
      Thread.sleep(1000); // Delay 1000ms
      letters.removeNumbers(5, gameBoard, 1, 42,"green"); // Remove five
      letters.typeNumbers(4, gameBoard, 1, 42,"green"); // Write four
      Thread.sleep(1000); // Delay 1000ms
      letters.removeNumbers(4, gameBoard, 1, 42,"green"); // Remove four
      letters.typeNumbers(3, gameBoard, 1, 42,"green"); // Write three
      Thread.sleep(1000); // Delay 1000ms
      letters.removeNumbers(3, gameBoard, 1, 42,"green"); // Remove three
      letters.typeNumbers(2, gameBoard, 1, 42,"green"); // Write two
      Thread.sleep(1000); // Delay 1000ms
      letters.removeNumbers(2, gameBoard, 1, 42,"green"); // Remove two
      letters.typeNumbers(1, gameBoard, 1, 42,"green"); // Write one
      Thread.sleep(1000); // Delay 1000ms
      letters.removeNumbers(1, gameBoard, 1, 42,"green"); // Remove one
      Thread.sleep(500);
    }
    
    static void drawSquare(String color, int row, int col) // Function to draw square outline for the settings around the chosen color
    {
      addPeg(color, 0+row, 0+col);addPeg(color, 1+row, 0+col);addPeg(color, 2+row, 0+col);addPeg(color, 2+row, 1+col);addPeg(color, 2+row, 2+col);addPeg(color, 1+row, 2+col);addPeg(color, 0+row, 2+col);addPeg(color, 0+row, 1+col);addPeg(color, 1+row, 1+col);addPeg(color, 3+row, 0+col);addPeg(color, 3+row, 1+col);addPeg(color, 3+row, 2+col);addPeg(color, 3+row, 3+col);addPeg(color, 2+row, 2+col);addPeg(color, 2+row, 3+col);addPeg(color, 1+row, 3+col);addPeg(color, 0+row, 3+col);addPeg(color, 4+row, 0+col);addPeg(color, 4+row, 1+col);addPeg(color, 4+row, 2+col);addPeg(color, 4+row, 3+col);addPeg(color, 4+row, 4+col);addPeg(color, 3+row, 4+col);addPeg(color, 2+row, 4+col);addPeg(color, 1+row, 4+col);addPeg(color, 0+row, 4+col);
    }
         
     static void movePieces() // Function to move the two tron players
    {
      switch(directionP1) // Switch for direction of player two
      {
         case 1: // 1 - Go North one peg
         row--; 
         addNewPeg(row, col, colorP2);
         break;
         
         case 2: // 2 - Go East one peg
         col++;
         addNewPeg(row, col, colorP2);
         break;
         
         case 3: // 3 - Go South one peg
         row++;
         addNewPeg(row, col, colorP2);
         break;
         
         case 4: // 4 - Go West one peg
         col--;
         addNewPeg(row, col, colorP2);
         break;
      }
      
      switch(directionP2) // Switch for direction of player one
      {
         case 1: // 1 - Go North one peg
         rowP2--;
         addNewPeg(rowP2, colP2, colorP1);
         break;
         
         case 2: // 2 - Go East one peg
         colP2++;
         addNewPeg(rowP2, colP2, colorP1);
         break;
         
         case 3: // 3 - Go South one peg
         rowP2++;
         addNewPeg(rowP2, colP2, colorP1);
         break;
         
         case 4: // 4 - Go West one peg
         colP2--;
         addNewPeg(rowP2, colP2, colorP1);
         break;
      }

    }
    
    static void addNewPeg(int rowAdd, int colAdd, String color) // Function to check validty of move 
    {
      if(checkMove(rowAdd, colAdd, color)) // If there are no pegs in where the player wishes to go...
         {
            addPeg(color, rowAdd, colAdd); // Add peg
         }
      else // Else, then the player is touching their line, the opponents line or the outer border
         gameOver(color); // Run gameover function
    }
    
    static boolean checkMove(int rowCheck, int colCheck, String color) // Function to check vaildty of move
    {
      if(rowCheck > size-1 || rowCheck < 0 || colCheck > sizeCol-1 || colCheck < 0) // Check if the user is touch the outside border
         return false; // Return false - meaning dead
      else
      {
        if(boardInfo[rowCheck][colCheck].equals("empty")) // Check if the user is going on to a new peg
         return true; // Return true - meaning alive
         
        else
         return false; // Return false - meaning dead
      }
    }

    static void gameOver(String color) // Function for gameover 
    {
      if(color.equals(colorP2)) // If the color that lost is second player
      {
         scoreP1++; // Add to player 1 score
         roundWinner = colorP1; // Set current roundwinner to player1
      }
      else
      {
         scoreP2++; // Add to player 2 score
         roundWinner = colorP2; // Set current roundwinner to player2
      }
      curGame = false;
      soundEffects(3);
    }
    
    static void clearBoard() // Function to clear the entire board 
    {
      for(int i=0; i < size; i++)
         for(int n=0; n < sizeCol; n++)
            removePeg(i,n);
    }
   
    static void setup() throws InterruptedException // Function for intial setup of the game start
    {
       clearBoard(); // Clear the board
       resetVars(); // Reset all the variables
       outlineBoard(); // Outline the boards
       drawBox(); // Draw the top left, right and middle boxes
       countdown(); // Begin the countdown
       clearBoard(); // Clear the board
       outlineBoard(); // Outline the boards
       drawBox(); // Draw the top left, right and middle boxes
       createAndShowGUI(); // Create the controls box in the top left
       addPeg(colorP2, row, col); // Add player two to the board
       addPeg(colorP1, rowP2, colP2); // Add player two to the board
       ftime = false; // Set ftime to false after first
    }

    static void tronName() // Function to write the tron name 
    {
       //Type Tron twice for a cool effect and Waleed S. at the bottom
       letters.typeLetters("TRON", gameBoard, 12, 32, "blue");
       letters.typeLetters("TRON", gameBoard, 14, 36, "white");
       letters.typeLetters("Waleed S.", gameBoard, 42, 25, "green"); 
    }
   
    static void midGame() // Function for mid game display
    {  
      outlineBoard(); // Outline the board
      drawBox(); // Draw the boxes for the top right, left and middle
      makeButtons(2); // Make white abort button
      makeButtons(3); // Make cyan continue button
      letters.typeNumbers(scoreP1, gameBoard, 1, 1, colorP1); // Show score for player one
      letters.typeNumbers(scoreP2, gameBoard, 1, 84, colorP2); // Show score for player two
    }
    
    static void homeScreen() // Function to show homescreen
    {  
      clearBoard(); // Clear board
      outlineBoard(); // Outline the board
      drawBox(); // Draw the boxes for the top right, left and middle
      tronName(); // Write the tron title
      // Create the help, settings, single player, multiplayer, abort button
      makeButtons(1);
      makeButtons(2);
      makeButtons(3);
      makeButtons(4);
      makeButtons(7);
      
      // Display zero score for both users
      displayScore(0, colorP1, 1, 1);
      displayScore(0, colorP2, 1, 84);
    }
    
    static void gameOverText(String color)
    {
      clearBoard(); // Clear board
      outlineBoard(); // Outline the board
      drawBox(); // Draw the boxes for the top right, left and middle
      
      // Draw home and abort button
      makeButtons(2);
      makeButtons(5);
      
      // Write game over and the winner
      letters.typeLetters("Game Over", gameBoard, 14, 19, "white");
      if(color.equals(colorP2))
         letters.typeLetters("Player Two Wins", gameBoard, 20, 19, colorP2);     

      else
         letters.typeLetters("Player One Wins", gameBoard, 20, 19, colorP1);
      
      // Draw the semicolon for the score
      gameBoard.putPeg("white", 27, 40);gameBoard.putPeg("white", 28, 40);gameBoard.putPeg("white", 28, 41);gameBoard.putPeg("white", 27, 41);gameBoard.putPeg("white", 30, 40);gameBoard.putPeg("white", 31, 40);gameBoard.putPeg("white", 31, 41);gameBoard.putPeg("white", 30, 41);
      letters.typeNumbers(scoreP1, gameBoard, 26, 34, colorP1); // Write player one score
      letters.typeNumbers(scoreP2, gameBoard, 26, 44, colorP2); // Write player two score
    }
    
    static void makeButtons(int type) // Function to draw buttons
    {
      switch(type)
      {
        case 1: // Draw single player button
        addPeg("green", 2, 37);addPeg("green", 3, 37);addPeg("green", 4, 37);addPeg("green", 5, 37);addPeg("green", 6, 37);addPeg("green", 5, 38);addPeg("green", 4, 39);addPeg("green", 3, 38);addPeg("green", 4, 38);
        break;
        
        case 2: // Draw abort button
        addPeg("white", 2, 41);addPeg("white", 3, 41);addPeg("white", 4, 41);addPeg("white", 5, 41);addPeg("white", 5, 41);addPeg("white", 6, 41);addPeg("white", 6, 42);addPeg("white", 6, 43);addPeg("white", 6, 44);addPeg("white", 5, 44);addPeg("white", 4, 44);addPeg("white", 3, 44);addPeg("white", 2, 44);addPeg("white", 2, 43);addPeg("white", 2, 42);addPeg("white", 3, 42);addPeg("white", 3, 43);addPeg("white", 4, 42);addPeg("white", 4, 43);addPeg("white", 5, 42);addPeg("white", 5, 43);
        break;
        
        case 3: // Draw mutliplayer and continue button
        addPeg("cyan", 2, 46);addPeg("cyan", 3, 46);addPeg("cyan", 4, 46);addPeg("cyan", 5, 46);addPeg("cyan", 6, 46);addPeg("cyan", 5, 47);addPeg("cyan", 4, 47);addPeg("cyan", 3, 47);addPeg("cyan", 2, 48);addPeg("cyan", 3, 48);addPeg("cyan", 4, 48);addPeg("cyan", 5, 48);addPeg("cyan", 6, 48);addPeg("cyan", 5, 49);addPeg("cyan", 4, 50);addPeg("cyan", 3, 49);addPeg("cyan", 4, 49);
        break;
        
        case 4: // Draw help button
        addPeg("yellow", 41, 81);addPeg("yellow", 40, 81);addPeg("yellow", 39, 81);addPeg("yellow", 38, 82);addPeg("yellow", 38, 83);addPeg("yellow", 38, 84);addPeg("yellow", 39, 85);addPeg("yellow", 40, 85);addPeg("yellow", 41, 85);addPeg("yellow", 42, 84);addPeg("yellow", 43, 83);addPeg("yellow", 44, 83);addPeg("yellow", 46, 83);
        break;
        
        case 5: // Draw home button
        addPeg("purple", 44, 1);addPeg("purple", 43, 2);addPeg("purple", 42, 3);addPeg("purple", 43, 4);addPeg("purple", 44, 5);addPeg("purple", 44, 2);addPeg("purple", 45, 2);addPeg("purple", 46, 2);addPeg("purple", 46, 3);addPeg("purple", 46, 4);addPeg("purple", 45, 4);addPeg("purple", 44, 4);addPeg("purple", 44, 3);
        break;
        
        case 6: // Draw next button
        addPeg("teal", 43, 86);addPeg("teal", 44, 87);addPeg("teal", 45, 86);addPeg("teal", 44, 85);addPeg("teal", 44, 84);addPeg("teal", 44, 83);
        break;
        
        case 7: // Draw settings button
        addPeg("darkgray", 46, 1);addPeg("darkgray", 45, 2);addPeg("darkgray", 44, 3);addPeg("darkgray", 43, 3);addPeg("darkgray", 42, 4);addPeg("darkgray", 44, 4);addPeg("darkgray", 43, 5);
        break;
        
        case 8: // Draw plus button for speed
        addPeg("greenP", 13, 45);addPeg("greenP", 13, 46);addPeg("greenP", 13, 47);addPeg("greenP", 13, 48);addPeg("greenP", 13, 49);addPeg("greenP", 11, 47);addPeg("greenP", 11, 47);addPeg("greenP", 12, 47);addPeg("greenP", 14, 47);addPeg("greenP", 15, 47);
        break;
        
        case 9: // Draw minus button for speed
        addPeg("red", 13, 28);addPeg("red", 13, 29);addPeg("red", 13, 30);addPeg("red", 13, 31);addPeg("red", 13, 32);
        break;
        
        case 10: // Draw minus button for first to score
        addPeg("redR", 21, 37);addPeg("redR", 21, 38);addPeg("redR", 21, 39);addPeg("redR", 21, 40);addPeg("redR", 21, 41);
        break;
        
        case 11: // Draw plus button for first to score
        addPeg("greenR", 21, 48);addPeg("greenR", 21, 49);addPeg("greenR", 21, 50);addPeg("greenR", 21, 51);addPeg("greenR", 21, 52);addPeg("greenR", 19, 50);addPeg("greenR", 20, 50);addPeg("greenR", 22, 50);addPeg("greenR", 23, 50);
        break;
        
        case 12: // Draw volume on button
        addPeg("greenM", 43, 79);addPeg("greenM", 44, 79);addPeg("greenM", 45, 79);addPeg("greenM", 45, 80);addPeg("greenM", 46, 81);addPeg("greenM", 46, 82);addPeg("greenM", 45, 82);addPeg("greenM", 44, 82);addPeg("greenM", 43, 82);addPeg("greenM", 42, 82);addPeg("greenM", 42, 81);addPeg("greenM", 43, 80);addPeg("greenM", 43, 84);addPeg("greenM", 44, 84);addPeg("greenM", 45, 84);addPeg("greenM", 42, 86);addPeg("greenM", 43, 86);addPeg("greenM", 44, 86);addPeg("greenM", 45, 86);addPeg("greenM", 46, 86);
        break;
        
        case 13: // Draw volume off button
        addPeg("redM", 43, 79);addPeg("redM", 44, 79);addPeg("redM", 45, 79);addPeg("redM", 45, 80);addPeg("redM", 46, 81);addPeg("redM", 46, 82);addPeg("redM", 45, 82);addPeg("redM", 44, 82);addPeg("redM", 43, 82);addPeg("redM", 42, 82);addPeg("redM", 42, 81);addPeg("redM", 43, 80);
        break;
      }
    }
    
    static void help() // Function for settings
    {
      clearBoard(); // Clear board
      outlineBoard(); // Outline the board
      drawBox(); // Draw the boxes for the top right, left and middle
      
      // Make home, single player, mutliplayer and abort buttons
      makeButtons(1);
      makeButtons(2);
      makeButtons(3);
      makeButtons(5);
      
      // Type instructions for the user
      letters.typeLetters("THE AIM OF TRON IS TO", gameBoard, 11, 4, "white"); 
      letters.typeLetters("GET YOUR OPPONENT", gameBoard, 17, 4, "white");
      letters.typeLetters("TO TOUCH YOUR LINE, ", gameBoard, 23, 4, "white");
      letters.typeLetters("THEIR LINE, OR THE RED", gameBoard, 29, 4, "white");
      letters.typeLetters("SIDES.", gameBoard, 35, 4, "white");
    }
    
    static boolean checkNext() // Function for computer player to check next two spots
    {
       boolean check = false;
       switch(directionP2)
       {
         case 1: // Check above by 2 for empty
         if(!(boardInfo[rowP2-1][colP2].equals("empty")))
            check = true;         
         break;
         
         case 2: // Check right by 2 for empty
         if(!(boardInfo[rowP2][colP2+1].equals("empty")))
            check = true; 
         break;
         
         case 3: // Check below by 2 for empty
         if(!(boardInfo[rowP2+1][colP2].equals("empty")))
            check = true; 
         break;
         
         case 4: // Check left by 2 for empty
         if(!(boardInfo[rowP2][colP2-1].equals("empty")))
            check = true; 
         break;
      }
      return check; // Return check

    }
    
    static void changeDirection() // Function for random change direction for the computer player
    {
         int random = directionP2;
         while(random==directionP2) // Generate a random direction that is different from the current direction
            random = (((int)(Math.random()*(4-1+1)))+1); 
            
         switch(directionP2)
         {
            case 1:
            while(random==3 || random == 1) // Make sure it doesn't go the opposite direction
               random = (((int)(Math.random()*(4-1+1)))+1); 
            directionP2 = random;
            break;
            
            case 2:
            while(random==4 || random == 2) // Make sure it doesn't go the opposite direction
               random = (((int)(Math.random()*(4-1+1)))+1);
            directionP2 = random;
            break; 
            
            case 3:
            while(random==1 || random == 3) // Make sure it doesn't go the opposite direction
               random = (((int)(Math.random()*(4-1+1)))+1); 
            directionP2 = random;
            break;
            
            case 4:
            while(random==2 || random == 4) // Make sure it doesn't go the opposite direction
               random = (((int)(Math.random()*(4-1+1)))+1); 
            directionP2 = random;
            break;  
         }
     }
   
    
    static void checkButton(String buttonColor) throws InterruptedException, IOException
    {
      switch(buttonColor)
      {
         case "cyanP1": // Change player one color to cyan
         colorP1 = "cyanP1";
         break;
         
         case "cyanP2": // Change player two color to cyan
         colorP2 = "cyanP2";
         break;
         
         case "yellowP1": // Change player one color to yellow
         colorP1 = "yellowP1";
         break;
         
         case "yellowP2": // Change player two color to yellow
         colorP2 = "yellowP2";
         break;
         
         case "redP1": // Change player one color to red
         colorP1 = "redP1";
         break;
         
         case "redP2": // Change player two color to red
         colorP2 = "redP2";
         break;
         
         case "greenP1": // Change player one color to green
         colorP1 = "greenP1";
         break;
         
         case "greenP2": // Change player two color to green
         colorP2 = "greenP2";
         break;
         
         case "white": // Abort program
         System.exit(0);
         break;
         
         case "cyan": // Start game - mutliplayer
         game = true;
         break;
         
         case "green": // Start game - singleplayer
         game = true;
         oneplayer = true;
         break;
         
         case "yellow": // Open help
         help();
         break;
         
         case "purple": // Open home
         homeScreen();
         homeScreen = true;
         // Set score to 0 and round number to 1
         scoreP1 = 0;
         scoreP2 = 0;
         roundno = 1;
         break;
         
         case "darkgray": // Open settings
         settings();
         homeScreen = false;
         break;
         
         case "red": // Reduce speed by 1
         speed(-1);
         break;
         
         case "greenP": // Increase speed by 1
         speed(1);
         break;  
         
         case "redR": // Reduce maxscore by 1
         maxScore(-1);
         break;
         
         case "greenR": // Increase maxscore by 1
         maxScore(1);
         break;
         
         case "greenM": // Mute the game
         playSound = false;
         off = true;
         soundEffects(4);
         break;
         
         case "redM": // Unmute the game
         playSound = true;
         soundEffects(4);
         break;
      }
      soundEffects(2); // Play click sound
    } 
    
    static String checkColor(String color) // Function to reduce color names - eg. redP2 -> red - for printing to the screen
    {
      if(color.substring(0, 3).equals("red"))
         return "red";
      else if(color.substring(0, 4).equals("cyan"))
         return "cyan";
      else if(color.substring(0, 5).equals("green"))
         return "green";
      else
         return "yellow";
    }
    
    static void speed(int change) throws IOException // Function to write any speed changes
    {
      prevSpeed = speed; // Set previous speed to current speed
      if(speed + change > 95) // Make sure speed doesn't go above 95
         speed = 95;
      else if(speed + change < 0) // Make sure speed doesn't go below 5
         speed = 5;
      else
         speed+=change;
      addNewData(); // Add data to txt file
    }
    
    static void maxScore(int change) throws IOException // Function to write any max score changes
    {
      prevMax = maxScore; // Set previous max score to current max score
      if(maxScore + change > 9) // Make sure max score doesn't go above 9
         maxScore = 9;
      else if(maxScore + change < 1) // Make sure max score doesn't go below 1
         maxScore = 1;
      else
         maxScore+=change;
      addNewData(); // Add data to txt file
    }
    
    static boolean checkButton(int range, int num) // Function to hide plus or minus button when max or min is reached
     {
      if(num == range)
       return true;
      else
       return false;
    }
    
    static void drawButtons() // Function to draw buttons
    {
      if(!(checkButton(99, speed))) // Check to draw plus speed button
         makeButtons(8);
      if(!(checkButton(5, speed))) // Check to draw minus speed button
         makeButtons(9);
      if(!(checkButton(9, maxScore))) // Check to draw plus max score button
         makeButtons(11);
      if(!(checkButton(1, maxScore))) // Check to draw minus max score button
         makeButtons(10);
    }
    
    static void drawSquareOutline(String color, int row, int col) // Function to draw white square outline around the color
    {
        gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 5+row, 0+col);gameBoard.putPeg(color, 6+row, 0+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 3+col);gameBoard.putPeg(color, 6+row, 4+col);gameBoard.putPeg(color, 6+row, 5+col);gameBoard.putPeg(color, 6+row, 6+col);gameBoard.putPeg(color, 5+row, 6+col);gameBoard.putPeg(color, 4+row, 6+col);gameBoard.putPeg(color, 3+row, 6+col);gameBoard.putPeg(color, 2+row, 6+col);gameBoard.putPeg(color, 1+row, 6+col);gameBoard.putPeg(color, 0+row, 6+col);gameBoard.putPeg(color, 0+row, 5+col);gameBoard.putPeg(color, 0+row, 4+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);
    }
    
    static void squaresSettings() // Function to draw the eight squares for the color choice
    {
     // Draw the four colors for player one
     drawSquare("cyanP1", 35, 4); // Cyan
     drawSquare("yellowP1", 35, 11); // Yellow
     drawSquare("redP1", 35, 18); // Red 
     drawSquare("greenP1", 35, 25); // Green
     
     switch(colorP1) // Check which color to draw white square around
     {
      case "cyanP1":
      drawSquareOutline("white", 34, 3);
      break;
      
      case "yellowP1":
      drawSquareOutline("white", 34, 10);
      break;
      
      case "redP1":
      drawSquareOutline("white", 34, 17);
      break;
      
      case "greenP1":
      drawSquareOutline("white", 34, 24);
      break;
     }
     
     // Draw the four colors for player two
     drawSquare("cyanP2", 35, 45); // Cyan
     drawSquare("yellowP2", 35, 52); // Yellow
     drawSquare("redP2", 35, 59); // Red
     drawSquare("greenP2", 35, 66); // Green
     
     switch(colorP2) // Check which color to draw white square around
     {
      case "cyanP2":
      drawSquareOutline("white", 34, 44);
      break;
      
      case "yellowP2":
      drawSquareOutline("white", 34, 51);
      break;
      
      case "redP2":
      drawSquareOutline("white", 34, 58);
      break;
      
      case "greenP2":
      drawSquareOutline("white", 34, 65);
      break;
     }
    }
    
    static void settings() throws InterruptedException, IOException // Function to show settings menu
    {
     String prevColorP1 = colorP1, prevColorP2 = colorP2; // Set previous color to the current colors
     while(!homeScreen)
     {
        if(setFtime || prevSpeed != speed || prevMax != maxScore || !(prevColorP1.equals(colorP1)) || !(prevColorP2.equals(colorP2)))
        // Only run if there is a change in the speed, maxScore, or color
        {
            // Set previous color to current color
            prevColorP1 = colorP1;
            prevColorP2 = colorP2;
            setFtime = false;
            clearBoard(); // Clear the board
            drawButtons(); // Draw the buttons for the settings
            outlineBoard(); // Outline the board
            makeButtons(5); // Make the home button
            if(playSound) // Check which button to draw
               makeButtons(12); // Draw music on button
            else
               makeButtons(13); // Draw music off button
            letters.typeLetters("Settings", gameBoard, 4, 4, "white"); // Type settings in the top left corner 
            letters.typeLetters("Speed:", gameBoard, 11, 4, "white"); // Type speed in the top left corner
            if(speed < 10) // If speed is less than ten, put a zero right beside for a better look
            {
               letters.typeNumbers(0, gameBoard, 10, 34, "white");
               letters.typeNumbers(speed, gameBoard, 10, 39, "white");
            }
            else
               letters.typeNumbers(speed, gameBoard, 10, 34, "white");
            // Display the first to score
            letters.typeLetters("First To:", gameBoard, 19, 4, "white"); 
            letters.typeNumbers(maxScore, gameBoard, 18, 43, "white");
            
            // Show the player one and two color selections
            letters.typeLetters("P. One:", gameBoard, 28, 4, "white");
            letters.typeLetters("P. Two:", gameBoard, 28, 45, "white");
            squaresSettings();
            
            // Get the click from the gameboard
            click = gameBoard.getClick();
            String buttonColor = boardInfo[click.getRow()][click.getCol()];
            checkButton(buttonColor);
            addNewData(); // Add the new data
            scanData(); // Scan the new data
        } 
      }
    }
    
    static void gameButtons() throws InterruptedException, IOException // Function to check any click from the game buttons
    {
        while(!game) // Run endlessly until the game starts
        {
         // Get the click
         click = gameBoard.getClick(); 
         String buttonColor = boardInfo[click.getRow()][click.getCol()];
         
         // Send it over to the check button function to check the button that was clicked
         checkButton(buttonColor);
        }
    }
    
    static void checkPrevScore() // Check the previous score
    {
      if(prevScoreP1 != scoreP1 && prevScoreP2 != scoreP2) // If score increase on both players, set score to to previous scores and tie to true
      {
         scoreP1 = prevScoreP1;
         scoreP2 = prevScoreP2;
         tie = true;
      }
      else // Else continue and set tie to false
      {
         prevScoreP1 = scoreP1;
         prevScoreP2 = scoreP2;
         tie = false;
      }
    }
    
    static void writeRoundWinner() // Function to write who won the round
    {
      if(roundWinner.equals(colorP2) && !tie) // If tie is false and player one wins is true
         letters.typeLetters("Player One Wins!", gameBoard, 30, 12, checkColor(colorP2));
      else if(roundWinner.equals(colorP1) && !tie) // If tie is false and player two wins is true
         letters.typeLetters("Player Two Wins!", gameBoard, 30, 12, checkColor(colorP1));
      else
         letters.typeLetters("Tie!", gameBoard, 30, 40, "white"); // Write tie to the screen
    }
    
    static void manageRound() throws InterruptedException
    {
      while(curGame)
              {  
                 if(ftime)
                 {
                  setup(); // Run setup function
                  displayScore(scoreP1, colorP1, 1, 1); // Display the score for player one
                  displayScore(scoreP2, colorP2, 1, 84); // Display the score for player two
                  letters.typeLetters("Go!", gameBoard, 2, 39, "green"); // Write go on the screen
                 }              
                 if(oneplayer && checkNext()) // Check if it is oneplayer and if there is a block in front
                  changeDirection(); // Change the direction
                 
                 movePieces(); // Move the pieces one forward
                 Thread.sleep(99-speed); // Sleep teh game for 99 - the users preset speed
             }
            roundno++; // Add one to the round number
            clearBoard(); // Clear the board
            if(scoreP1 == maxScore || scoreP2 == maxScore) // If score is equal to the max score set game to false
               game = false;
            else 
            {  
               midGame(); // Show midgame screen
               checkPrevScore(); // Check to make sure that it wasn't a tie
               printText(); // Print the continue instruction
               writeRoundWinner(); // Write the round winner
               click = gameBoard.getClick(); // Get the users next click
               String buttonColor = boardInfo[click.getRow()][click.getCol()];
               if(buttonColor.equals("cyan")) // If it is cyan, continue the game
                  resetVars();
               else if(buttonColor.equals("white")) // Else abort the entire game
                  System.exit(0);
               else if(buttonColor.equals("purple")) // Else open the home game
               {
                  homeScreen();
                  homeScreen = true;
               }
            }   

    
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
       scanData(); // Scan the values from the text files
       JCanvas.playClip(music); // Start playing the background music
        while(true) // Endless loop
        {
           while(!game) // While game has not started
           {
              prevScoreP1 = scoreP1; // Set prevscore to player one score
              prevScoreP2 = scoreP2; // Set prevscore to player two score
              homeScreen(); // Show homescreen
              addNewData(); // Add the new data to the text file
              gameButtons(); // Show all the button
           }
           while(game){ // While game has started
              manageRound(); // Run the game function             
           }
           clearBoard(); // Clear the board 
           outlineBoard(); // Outline the board
           while(scoreP1 == maxScore || scoreP2 == maxScore) // Make sure that the neither player has reached the max score
           {
            // Game over
            // If so type to the screen who won
            if(scoreP1>scoreP2)
               gameOverText(colorP1);
            else
               gameOverText(colorP2);
               
            click = gameBoard.getClick();
            String buttonColor = boardInfo[click.getRow()][click.getCol()];
            checkButton(buttonColor); 
           }  
       }  
    }
    
    static void printText() // Function to write how to continue on with the game
    {
      letters.typeLetters("Click", gameBoard, 15, 18, "white");gameBoard.putPeg("cyan", 15, 42);gameBoard.putPeg("cyan", 17, 42);gameBoard.putPeg("cyan", 16, 42);gameBoard.putPeg("cyan", 18, 42);gameBoard.putPeg("cyan", 19, 42);gameBoard.putPeg("cyan", 18, 43);gameBoard.putPeg("cyan", 17, 43);gameBoard.putPeg("cyan", 16, 43);gameBoard.putPeg("cyan", 15, 44);gameBoard.putPeg("cyan", 16, 44);gameBoard.putPeg("cyan", 17, 44);gameBoard.putPeg("cyan", 19, 44);gameBoard.putPeg("cyan", 18, 44);gameBoard.putPeg("cyan", 17, 46);gameBoard.putPeg("cyan", 16, 45);gameBoard.putPeg("cyan", 17, 45);gameBoard.putPeg("cyan", 18, 45);letters.typeLetters("to continue", gameBoard, 22, 27, "white");
    }
    
    private static void createAndShowGUI() { // Function to create the GUI for the user input
        Tron frame = new Tron("Controls"); // Ste name to controls
        frame.addComponentsToPane();
        frame.pack();
        frame.setVisible(true); // Set visible to true, because false will result in the program not working
    } 
     
    private void addComponentsToPane() // Function to create the input for the board 
    {
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);                 
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
    }
     
    public Tron(String name) {super(name);}     
     
    public void keyTyped(KeyEvent e) {displayInfo(e);} // If user types - check
     
    public void keyPressed(KeyEvent e){displayInfo(e);} // If user presses - check
     
    public void keyReleased(KeyEvent e) {displayInfo(e);} // If user released - check
     
    public void actionPerformed(ActionEvent e) {
        typingArea.setText("");
        typingArea.requestFocusInWindow();
    }
    
    private void displayInfo(KeyEvent e){
        int id = e.getID(); // Get the key id
        int keyCode = e.getKeyCode(); // Get the keyCode
        String keyString = KeyEvent.getKeyText(keyCode); // Convert it to the string
       
        switch(keyString)
        {
         case "Left":
         checkMoveP1(4);      
         break;
         
         case "Right":
         checkMoveP1(2);       
         break;
         
         case "Up":
         checkMoveP1(1);       
         break;
         
         case "Down":
         checkMoveP1(3);       
         break;
       }
       if(!oneplayer) // Only run if there is multiplayer
       {
        switch(keyString)
        {
         case "A": // A - Left
         checkMoveP2(4);      
         break;
         
         case "D": // D - Right
         checkMoveP2(2);       
         break;
         
         case "W": // W - Up
         checkMoveP2(1);       
         break;
         
         case "S": // S - Down
         checkMoveP2(3);       
         break;
        } 
       }
    
    }
    static void checkMoveP1(int direction) // Function to check the direction to make sure the user doesn't go backwards
    {
         switch(direction)
         {
            case 1:
               if(!(directionP1 == 3))
                  directionP1 = direction;  
            break;
            
            case 2:
               if(!(directionP1 == 4))
                  directionP1 = direction;
            break;
            
            case 3:
               if(!(directionP1 == 1))
                  directionP1 = direction;
            break;
            
            case 4:
               if(!(directionP1 == 2))
                  directionP1 = direction;
            break;
         }
    }
    
    static void checkMoveP2(int direction) // Function to check the direction to make sure the user doesn't go backwards
    {
         switch(direction)
         {
            case 1:
               if(!(directionP2 == 3))
                  directionP2 = direction;  
            break;
            
            case 2:
               if(!(directionP2 == 4))
                  directionP2 = direction;
            break;
            
            case 3:
               if(!(directionP2 == 1))
                  directionP2 = direction;
            break;
            
            case 4:
               if(!(directionP2 == 2))
                  directionP2 = direction;
            break;
         }
    }
}