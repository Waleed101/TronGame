import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.*;
 
class TronV3 extends JFrame
        implements KeyListener,
        ActionListener
{
    static int row = 24, col = 19, rowP2 = 24, colP2 = 68, directionP1 = 2, directionP2 = 4, size = 48, sizeCol = 89, speed = 35, scoreP1 = 0, scoreP2 = 0, prevSpeed = speed, maxScore = 3, prevMax = maxScore, roundno = 1, prevScoreP1 = scoreP1, prevScoreP2 = scoreP2;
    static Board gameBoard = new Board(size,sizeCol);
    static String[][] boardInfo = new String[size][sizeCol];
    static boolean game = false, ftime = true, curGame = true, oneplayer = false, compftime = true, setFtime = true, homeScreen = true, tie = false;
    static String roundWinner = "na";
    static Coordinate click;
    JTextArea displayArea;
    JTextField typingArea;
    
    static void resetVars()
    {
      ftime = true;
      curGame = true;
      compftime = true;
      row = 24;
      col = 68;
      rowP2 = 24;
      colP2 = 19;
      directionP1 = 4;
      directionP2 = 2;
    }
    
    static void scanData() throws IOException
    {
     File dataFile = new File("tronSettings.txt");
     Scanner scanFile = new Scanner(dataFile);
     speed = scanFile.nextInt();
     maxScore = scanFile.nextInt();
    }
    
    static void addNewData() throws IOException
    {
      File nameFile = new File("tronSettings.txt");
      PrintStream printToFile = new PrintStream(nameFile);
      printToFile.println(speed);
      printToFile.println(maxScore);
      printToFile.close();
    }
    
    static void drawBox()
    {
     removeBoxBorders();
     for(int i=0; i<10; i++)
      addPeg("red", i, 6);  
     for(int i=5; i!=-1; i--)
      addPeg("red", 9, i);  
     for(int i=0; i<10; i++)
      addPeg("red", i, 82);  
     for(int i=82; i<89; i++)
      addPeg("red", 9, i); 
     for(int i=0; i<10; i++)
     {
      addPeg("red", i, 35);
      addPeg("red", i, 52);
     }
     for(int i=35; i<53; i++)
      addPeg("red", 9, i);
    }
    
       
    static void removePeg(int rowR, int colR)
    {
      gameBoard.removePeg(rowR, colR);
      boardInfo[rowR][colR] = "empty";
    }
    
    static void addPeg(String color, int rowA, int colA)
    {
      gameBoard.putPeg(color, rowA, colA);
      boardInfo[rowA][colA] = color;
    }
    
 
    static void displayScore(int score, String color, int row, int col)
    {
     letters.typeNumbers(score, gameBoard, row, col, color);
    }
    
    static void removeBoxBorders()
    {
      for(int i=0; i<10; i++)
      {
         removePeg(i, 82);
         removePeg(i, 88);
         removePeg(i, 0);
      }
      removePeg(0,5);
      removePeg(0,6);
      for(int i=0; i<5; i++)
      {
         removePeg(0, 83+i);
         removePeg(0, i);
      }
      for(int i=36; i<52; i++)
         removePeg(0, i);
    }
    
      
    static void outlineBoard()
    {
      
      for(int i=0; i < size; i++)
      {
         addPeg("red", i, 0);
         addPeg("red", i, sizeCol-1);
      }
      
      for(int i=0; i < sizeCol; i++)
      {
         addPeg("red", 0, i);
         addPeg("red", size-1, i);
      }      
    }
    
           
    static void countdown() throws InterruptedException
    {
      displayScore(scoreP1, "orange", 1, 1);
      displayScore(scoreP2, "blue", 1, 84); 
      letters.typeLetters("Round No. ", gameBoard, 20, 18, "white");
      letters.typeNumbers(roundno, gameBoard, 19, 60, "white");
      letters.typeNumbers(3, gameBoard, 1, 42,"green");
      Thread.sleep(1000);
      letters.removeNumbers(3, gameBoard, 1, 42,"green");
      letters.typeNumbers(2, gameBoard, 1, 42,"green");
      Thread.sleep(1000);
      letters.removeNumbers(2, gameBoard, 1, 42,"green");
      letters.typeNumbers(1, gameBoard, 1, 42,"green");
      Thread.sleep(1000);
      letters.removeNumbers(1, gameBoard, 1, 42,"green");
    }
    
    
         
     static void movePieces()
    {
      switch(directionP1)
      {
         case 1:
         row--;
         addNewPeg(row, col, "blue");
         break;
         
         case 2:
         col++;
         addNewPeg(row, col, "blue");
         break;
         
         case 3:
         row++;
         addNewPeg(row, col, "blue");
         break;
         
         case 4:
         col--;
         addNewPeg(row, col, "blue");
         break;
      }
      
      switch(directionP2)
      {
         case 1:
         rowP2--;
         addNewPeg(rowP2, colP2, "orange");
         break;
         
         case 2:
         colP2++;
         addNewPeg(rowP2, colP2, "orange");
         break;
         
         case 3:
         rowP2++;
         addNewPeg(rowP2, colP2, "orange");
         break;
         
         case 4:
         colP2--;
         addNewPeg(rowP2, colP2, "orange");
         break;
      }

    }
    
    static void addNewPeg(int rowAdd, int colAdd, String color)
    {
      if(checkMove(rowAdd, colAdd, color))
         {
            boardInfo[rowAdd][colAdd] = color;
            addPeg(color, rowAdd, colAdd);
         }
      else
         gameOver(color);
    }
    
    static boolean checkMove(int rowCheck, int colCheck, String color)
    {
      if(rowCheck > size-1 || rowCheck < 0 || colCheck > sizeCol-1 || colCheck < 0)
         return false;   
      else
      {
        if(boardInfo[rowCheck][colCheck].equals("empty"))
         return true; 
         
        else
         return false;
      }
    }

    static void gameOver(String color)
    {
      if(color.equals("blue"))
      {
         scoreP1++;
         roundWinner = "orange";
      }
      else
      {
         scoreP2++;
         roundWinner = "blue";
      }
      curGame = false;
    }
    
    static void clearBoard()
    {
      for(int i=0; i < size; i++)
         for(int n=0; n < sizeCol; n++)
            removePeg(i,n);
    }
   
    static void setup() throws InterruptedException
    {
       clearBoard();
       resetVars();
       outlineBoard();
       drawBox();
       countdown();
       clearBoard();
       outlineBoard();
       drawBox();
       createAndShowGUI();
       addPeg("blue", row, col);
       addPeg("orange", rowP2, colP2);
       ftime = false;
    }
    
      static void drawSwan() throws InterruptedException
   {
      for(int i=0; i<50; i++)
      {
       gameBoard.putPeg("white", 33, 19+i);gameBoard.putPeg("white", 34, 20+i);gameBoard.putPeg("white", 35, 21+i);gameBoard.putPeg("white", 36, 22+i);gameBoard.putPeg("white", 36, 23+i);gameBoard.putPeg("white", 36, 24+i);gameBoard.putPeg("white", 36, 25+i);gameBoard.putPeg("white", 36, 26+i);gameBoard.putPeg("white", 36, 27+i);gameBoard.putPeg("white", 35, 28+i);gameBoard.putPeg("white", 34, 29+i);gameBoard.putPeg("white", 33, 30+i);gameBoard.putPeg("white", 32, 19+i);gameBoard.putPeg("white", 31, 20+i);gameBoard.putPeg("white", 30, 21+i);gameBoard.putPeg("white", 29, 22+i);gameBoard.putPeg("white", 29, 23+i);gameBoard.putPeg("white", 29, 24+i);gameBoard.putPeg("white", 29, 25+i);gameBoard.putPeg("white", 32, 29+i);gameBoard.putPeg("white", 31, 28+i);gameBoard.putPeg("white", 30, 27+i);gameBoard.putPeg("white", 29, 26+i);gameBoard.putPeg("white", 31, 29+i);gameBoard.putPeg("white", 29, 27+i);gameBoard.putPeg("white", 27, 27+i);gameBoard.putPeg("white", 30, 29+i);gameBoard.putPeg("white", 29, 29+i);gameBoard.putPeg("white", 28, 27+i);gameBoard.putPeg("white", 28, 29+i);gameBoard.putPeg("white", 27, 29+i);gameBoard.putPeg("white", 26, 29+i);gameBoard.putPeg("white", 26, 27+i);gameBoard.putPeg("white", 25, 27+i);gameBoard.putPeg("white", 24, 27+i);gameBoard.putPeg("white", 23, 28+i);gameBoard.putPeg("white", 24, 29+i);gameBoard.putPeg("white", 24, 30+i);gameBoard.putPeg("white", 24, 31+i);gameBoard.putPeg("white", 25, 30+i);gameBoard.putPeg("white", 31, 21+i);gameBoard.putPeg("white", 31, 21+i);gameBoard.putPeg("white", 32, 21+i);gameBoard.putPeg("white", 33, 22+i);gameBoard.putPeg("white", 31, 22+i);gameBoard.putPeg("white", 31, 23+i);gameBoard.putPeg("white", 32, 24+i);gameBoard.putPeg("white", 34, 23+i);gameBoard.putPeg("white", 35, 24+i);gameBoard.putPeg("white", 33, 25+i);gameBoard.putPeg("white", 34, 26+i);gameBoard.putPeg("white", 35, 27+i);   
       Thread.sleep(50);
       for(int y=0; y < 48; y++)
         for(int n=0; n < 89; n++)
            gameBoard.removePeg(y,n);
       outlineBoard();
       drawBox();
      }
      
  }

   static void tronName() throws InterruptedException
   {
      letters.typeLetters("TRON", gameBoard, 12, 32, "blue");
      letters.typeLetters("TRON", gameBoard, 14, 36, "white");
      letters.typeLetters("Waleed S.", gameBoard, 42, 25, "green"); 
   }
    static void midGame() 
    {  
      outlineBoard();
      drawBox();
      makeButtons(1);
      makeButtons(2);
      makeButtons(3);
      letters.typeNumbers(scoreP1, gameBoard, 1, 1, "orange");
      letters.typeNumbers(scoreP2, gameBoard, 1, 84, "blue");   
    }
    
    static void homeScreen() throws InterruptedException
    {  
      clearBoard();
      outlineBoard();
      drawBox();
      tronName();
      
      makeButtons(1);
      makeButtons(2);
      makeButtons(3);
      makeButtons(4);
      makeButtons(7);
      displayScore(scoreP1, "orange", 1, 1);
      displayScore(scoreP2, "blue", 1, 84);
    }
    
    static void gameOverText(String color)
    {
      clearBoard();
      outlineBoard();
      drawBox();
      makeButtons(1);
      makeButtons(2);
      makeButtons(3);
      makeButtons(5);
      letters.typeLetters("Game Over", gameBoard, 14, 19, "white");
      if(color.equals("blue"))
         letters.typeLetters("Blue Wins", gameBoard, 20, 19, "blue");     

      else
         letters.typeLetters("Orange Wins", gameBoard, 20, 19, "orange");
      
      gameBoard.putPeg("white", 27, 40);gameBoard.putPeg("white", 28, 40);gameBoard.putPeg("white", 28, 41);gameBoard.putPeg("white", 27, 41);gameBoard.putPeg("white", 30, 40);gameBoard.putPeg("white", 31, 40);gameBoard.putPeg("white", 31, 41);gameBoard.putPeg("white", 30, 41);
      letters.typeNumbers(scoreP1, gameBoard, 26, 34, "orange");
      letters.typeNumbers(scoreP2, gameBoard, 26, 44, "blue");
    }
    
    static void makeButtons(int type)
    {
      switch(type)
      {
        case 1:
        addPeg("green", 2, 37);addPeg("green", 3, 37);addPeg("green", 4, 37);addPeg("green", 5, 37);addPeg("green", 6, 37);addPeg("green", 5, 38);addPeg("green", 4, 39);addPeg("green", 3, 38);addPeg("green", 4, 38);
        break;
        
        case 2:
        addPeg("white", 2, 41);addPeg("white", 3, 41);addPeg("white", 4, 41);addPeg("white", 5, 41);addPeg("white", 5, 41);addPeg("white", 6, 41);addPeg("white", 6, 42);addPeg("white", 6, 43);addPeg("white", 6, 44);addPeg("white", 5, 44);addPeg("white", 4, 44);addPeg("white", 3, 44);addPeg("white", 2, 44);addPeg("white", 2, 43);addPeg("white", 2, 42);addPeg("white", 3, 42);addPeg("white", 3, 43);addPeg("white", 4, 42);addPeg("white", 4, 43);addPeg("white", 5, 42);addPeg("white", 5, 43);
        break;
        
        case 3:
        addPeg("cyan", 2, 46);addPeg("cyan", 3, 46);addPeg("cyan", 4, 46);addPeg("cyan", 5, 46);addPeg("cyan", 6, 46);addPeg("cyan", 5, 47);addPeg("cyan", 4, 47);addPeg("cyan", 3, 47);addPeg("cyan", 2, 48);addPeg("cyan", 3, 48);addPeg("cyan", 4, 48);addPeg("cyan", 5, 48);addPeg("cyan", 6, 48);addPeg("cyan", 5, 49);addPeg("cyan", 4, 50);addPeg("cyan", 3, 49);addPeg("cyan", 4, 49);
        break;
        
        case 4:
        addPeg("yellow", 41, 81);addPeg("yellow", 40, 81);addPeg("yellow", 39, 81);addPeg("yellow", 38, 82);addPeg("yellow", 38, 83);addPeg("yellow", 38, 84);addPeg("yellow", 39, 85);addPeg("yellow", 40, 85);addPeg("yellow", 41, 85);addPeg("yellow", 42, 84);addPeg("yellow", 43, 83);addPeg("yellow", 44, 83);addPeg("yellow", 46, 83);
        break;
        
        case 5:
        addPeg("purple", 44, 1);addPeg("purple", 43, 2);addPeg("purple", 42, 3);addPeg("purple", 43, 4);addPeg("purple", 44, 5);addPeg("purple", 44, 2);addPeg("purple", 45, 2);addPeg("purple", 46, 2);addPeg("purple", 46, 3);addPeg("purple", 46, 4);addPeg("purple", 45, 4);addPeg("purple", 44, 4);addPeg("purple", 44, 3);
        break;
        
        case 6:
        addPeg("teal", 43, 86);addPeg("teal", 44, 87);addPeg("teal", 45, 86);addPeg("teal", 44, 85);addPeg("teal", 44, 84);addPeg("teal", 44, 83);
        break;
        
        case 7:
        addPeg("darkgray", 46, 1);addPeg("darkgray", 45, 2);addPeg("darkgray", 44, 3);addPeg("darkgray", 43, 3);addPeg("darkgray", 42, 4);addPeg("darkgray", 44, 4);addPeg("darkgray", 43, 5);
        break;
        
        case 8:
        addPeg("greenP", 13, 45);addPeg("greenP", 13, 46);addPeg("greenP", 13, 47);addPeg("greenP", 13, 48);addPeg("greenP", 13, 49);addPeg("greenP", 11, 47);addPeg("greenP", 11, 47);addPeg("greenP", 12, 47);addPeg("greenP", 14, 47);addPeg("greenP", 15, 47);
        break;
        
        case 9:
        addPeg("red", 13, 28);addPeg("red", 13, 29);addPeg("red", 13, 30);addPeg("red", 13, 31);addPeg("red", 13, 32);
        break;
        
        case 10:
        addPeg("redR", 21, 37);addPeg("redR", 21, 38);addPeg("redR", 21, 39);addPeg("redR", 21, 40);addPeg("redR", 21, 41);
        break;
        
        case 11:
        addPeg("greenR", 21, 48);addPeg("greenR", 21, 49);addPeg("greenR", 21, 50);addPeg("greenR", 21, 51);addPeg("greenR", 21, 52);addPeg("greenR", 19, 50);addPeg("greenR", 20, 50);addPeg("greenR", 22, 50);addPeg("greenR", 23, 50);
        break;
        
      }
    }
    
    static void help()
    {
      clearBoard();
      outlineBoard();
      drawBox();
      makeButtons(1);
      makeButtons(2);
      makeButtons(3);
      makeButtons(5);
      makeButtons(6);
      makeButtons(7);
      letters.typeLetters("THE AIM OF TRON IS TO", gameBoard, 11, 4, "white"); 
      letters.typeLetters("GET YOUR OPPONENT", gameBoard, 17, 4, "white");
      letters.typeLetters("TO TOUCH YOUR LINE, ", gameBoard, 23, 4, "white");
      letters.typeLetters("THEIR LINE, OR THE RED", gameBoard, 29, 4, "white");
      letters.typeLetters("SIDES.", gameBoard, 35, 4, "white");
    }
    
    static boolean checkNext()
    {
       boolean check = false;
       switch(directionP2)
       {
         case 1:
         if(!(boardInfo[rowP2-1][colP2].equals("empty")) || !(boardInfo[rowP2-2][colP2].equals("empty")))
            check = true;         
         break;
         
         case 2:
         if(!(boardInfo[rowP2][colP2+1].equals("empty")) || !(boardInfo[rowP2][colP2+2].equals("empty")))
            check = true; 
         break;
         
         case 3:
         if(!(boardInfo[rowP2+1][colP2].equals("empty")) || !(boardInfo[rowP2+2][colP2].equals("empty")))
            check = true; 
         break;
         
         case 4:
         if(!(boardInfo[rowP2][colP2-1].equals("empty")) || !(boardInfo[rowP2][colP2-2].equals("empty")))
            check = true; 
         break;
      }
      return check;

    }
    
    static void changeDirection()
    {
         int random = directionP2;
         while(random==directionP2)
            random = (((int)(Math.random()*(4-1+1)))+1); 
            
         switch(directionP2)
         {
            case 1:
            while(random==3 || random == 1)
               random = (((int)(Math.random()*(4-1+1)))+1); 
            directionP2 = random;
            break;
            
            case 2:
            while(random==4 || random == 2)
               random = (((int)(Math.random()*(4-1+1)))+1);
            directionP2 = random;
            break; 
            
            case 3:
            while(random==1 || random == 3)
               random = (((int)(Math.random()*(4-1+1)))+1); 
            directionP2 = random;
            break;
            
            case 4:
            while(random==2 || random == 4)
               random = (((int)(Math.random()*(4-1+1)))+1); 
               
            directionP2 = random;
            break;  
         }
     }
   
    
    static void checkButton(String buttonColor) throws InterruptedException, IOException
    {
      switch(buttonColor)
      {
         case "cyan":
         game = true;
         break;
         
         case "white":
         System.exit(0);
         break;
         
         case "green":
         game = true;
         oneplayer = true;
         break;
         
         case "yellow":
         help();
         break;
         
         case "purple":
         homeScreen();
         homeScreen = true;
         scoreP1 = 0;
         scoreP2 = 0;
         roundno = 0;
         break;
         
         case "darkgray":
         settings();
         homeScreen = false;
         break;
         
         case "red":
         speed(-1);
         break;
         
         case "greenP":
         speed(1);
         break;  
         
         case "redR":
         maxScore(-1);
         break;
         
         case "greenR":
         maxScore(1);
         break;
      }
    } 
    
    static void speed(int change) throws IOException
    {
      prevSpeed = speed;
      if(speed + change > 95)
         speed = 95;
      else if(speed + change < 0)
         speed = 5;
      else
         speed+=change;
      System.out.println(speed);
      System.out.println(prevSpeed);
      addNewData();
    }
    
    static void maxScore(int change) throws IOException
    {
      prevMax = maxScore;
      if(maxScore + change > 9)
         maxScore = 9;
      else if(maxScore + change < 1)
         maxScore = 1;
      else
         maxScore+=change;
      System.out.println(maxScore);
      System.out.println(prevMax);
      addNewData();
    }
    
    static boolean checkButton(int range, int num)
     {
      if(num == range)
       return true;
      else
       return false;
    }
    
    static void drawButtons()
    {
      if(!(checkButton(99, speed)))
         makeButtons(8);
      if(!(checkButton(5, speed)))
         makeButtons(9);
      if(!(checkButton(9, maxScore)))
         makeButtons(11);
      if(!(checkButton(1, maxScore)))
         makeButtons(10);
    }
    
    static void settings() throws InterruptedException, IOException
    {
     while(!homeScreen)
     {
        if(setFtime || prevSpeed != speed || prevMax != maxScore)
        {
            System.out.println("In settings loop");
            setFtime = false;
            clearBoard();
            drawButtons();
            outlineBoard();
            makeButtons(5);
            letters.typeLetters("Settings", gameBoard, 4, 4, "white"); 
            letters.typeLetters("Speed:", gameBoard, 11, 4, "white");
            if(speed < 10)
            {
               letters.typeNumbers(0, gameBoard, 10, 34, "white");
               letters.typeNumbers(speed, gameBoard, 10, 39, "white");
            }
            else
               letters.typeNumbers(speed, gameBoard, 10, 34, "white");
            letters.typeLetters("Rounds:", gameBoard, 19, 4, "white");
            letters.typeNumbers(maxScore, gameBoard, 18, 43, "white");
            click = gameBoard.getClick();
            String buttonColor = boardInfo[click.getRow()][click.getCol()];
            checkButton(buttonColor);
            
        } 
      }
    }
    
    static void gameButtons() throws InterruptedException, IOException
    {
        while(!game)
        {
         click = gameBoard.getClick();
         String buttonColor = boardInfo[click.getRow()][click.getCol()];
         checkButton(buttonColor);
        }
    }
    
    static void checkPrevScore()
    {
      if(prevScoreP1 != scoreP1 && prevScoreP2 != scoreP2)
      {
         scoreP1 = prevScoreP1;
         scoreP2 = prevScoreP2;
         tie = true;
      }
      else
      {
         prevScoreP1 = scoreP1;
         prevScoreP2 = scoreP2;
         tie = false;
      }
    }
    
    static void writeRoundWinner()
    {
      if(roundWinner.equals("blue") && !tie)
         letters.typeLetters("Blue Wins!", gameBoard, 30, 18, "blue");
      else if(roundWinner.equals("orange") && !tie)
         letters.typeLetters("Orange Wins!", gameBoard, 30, 18, "orange");
      else
         letters.typeLetters("Tie!", gameBoard, 30, 18, "white");
    }
    
    static void manageRound() throws InterruptedException
    {
      while(curGame)
              {   
                 if(ftime)
                 {
                  setup();
                  displayScore(scoreP1, "orange", 1, 1);
                  displayScore(scoreP2, "blue", 1, 84);
                  letters.typeLetters("Go!", gameBoard, 2, 39, "green");
                 }              
                 if(oneplayer && checkNext())
                  changeDirection();
                 
                 movePieces();
                 Thread.sleep(99-speed);
             }
            roundno++;
            clearBoard();
            if(scoreP1 == maxScore || scoreP2 == maxScore)
               game = false;
            else
            {  
               checkPrevScore();
               midGame();
               printText();
               writeRoundWinner();
               click = gameBoard.getClick();
               String buttonColor = boardInfo[click.getRow()][click.getCol()];
               if(buttonColor.equals("cyan"))
                  resetVars();
               else if(buttonColor.equals("white"))
                  System.exit(0);
            }   

    
    }
    
    public static void main(String[] args) throws InterruptedException, IOException {
        while(true)
        {
           while(!game)
           {
              prevScoreP1 = scoreP1;
              prevScoreP2 = scoreP2;
              homeScreen();
              scanData();
              gameButtons();
           }
           while(game){
              manageRound();               
           }
           clearBoard();
           outlineBoard();
           while(scoreP1 == maxScore || scoreP2 == maxScore)
           {
            if(scoreP1>scoreP2)
               gameOverText("orange");
            else
               gameOverText("blue");
               
            click = gameBoard.getClick();
            String buttonColor = boardInfo[click.getRow()][click.getCol()];
            checkButton(buttonColor); 
           }  
       }  
    }
    
    static void printText()
    {
      letters.typeLetters("Click", gameBoard, 15, 18, "white");gameBoard.putPeg("cyan", 15, 42);gameBoard.putPeg("cyan", 17, 42);gameBoard.putPeg("cyan", 16, 42);gameBoard.putPeg("cyan", 18, 42);gameBoard.putPeg("cyan", 19, 42);gameBoard.putPeg("cyan", 18, 43);gameBoard.putPeg("cyan", 17, 43);gameBoard.putPeg("cyan", 16, 43);gameBoard.putPeg("cyan", 15, 44);gameBoard.putPeg("cyan", 16, 44);gameBoard.putPeg("cyan", 17, 44);gameBoard.putPeg("cyan", 19, 44);gameBoard.putPeg("cyan", 18, 44);gameBoard.putPeg("cyan", 17, 46);gameBoard.putPeg("cyan", 16, 45);gameBoard.putPeg("cyan", 17, 45);gameBoard.putPeg("cyan", 18, 45);letters.typeLetters("to continue", gameBoard, 22, 27, "white");
    }
    
    private static void createAndShowGUI() {
        TronV3 frame = new TronV3("Controls");
        frame.addComponentsToPane();
        frame.pack();
        frame.setVisible(true);
    } 
     
    private void addComponentsToPane() {
         
        typingArea = new JTextField(20);
        typingArea.addKeyListener(this);                 
        getContentPane().add(typingArea, BorderLayout.PAGE_START);
    }
     
    public TronV3(String name) {
        super(name);
    }
     
     
    public void keyTyped(KeyEvent e) {
    if(oneplayer)
      displayInfoOne(e);
    else
      displayInfoTwo(e);
    
    }
     
    public void keyPressed(KeyEvent e) {
    if(oneplayer)
      displayInfoOne(e);
    else
      displayInfoTwo(e);
        }
     
    public void keyReleased(KeyEvent e) {
    if(oneplayer)
      displayInfoOne(e);
    else
      displayInfoTwo(e);
        
    }
     
    public void actionPerformed(ActionEvent e) {
        displayArea.setText("");
        typingArea.setText("");
        typingArea.requestFocusInWindow();
    }
    
    private void displayInfoOne(KeyEvent e){
      int id = e.getID();
        String keyString;
        int keyCode = e.getKeyCode();
        keyString = KeyEvent.getKeyText(keyCode);
       
        switch(keyString)
        {
         case "Left":
         System.out.print("Left");
         checkMoveP1(4);      
         break;
         
         case "Right":
         System.out.print("Right");
         checkMoveP1(2);       
         break;
         
         case "Up":
         System.out.print("Up");
         checkMoveP1(1);       
         break;
         
         case "Down":
         System.out.print("Down");
         checkMoveP1(3);       
         break;
       }
    
    }
    
    private void displayInfoTwo(KeyEvent e){
        int id = e.getID();
        String keyString;
        int keyCode = e.getKeyCode();
        keyString = KeyEvent.getKeyText(keyCode);
       
        switch(keyString)
        {
         case "Left":
         System.out.print("Left");
         checkMoveP1(4);      
         break;
         
         case "Right":
         System.out.print("Right");
         checkMoveP1(2);       
         break;
         
         case "Up":
         System.out.print("Up");
         checkMoveP1(1);       
         break;
         
         case "Down":
         System.out.print("Down");
         checkMoveP1(3);       
         break;
         
         
         case "A":
         System.out.print("Left");
         checkMoveP2(4);      
         break;
         
         case "D":
         System.out.print("Right");
         checkMoveP2(2);       
         break;
         
         case "W":
         System.out.print("Up");
         checkMoveP2(1);       
         break;
         
         case "S":
         System.out.print("Down");
         checkMoveP2(3);       
         break;
        }
    }
    
    static void checkMoveP1(int direction)
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
    
    static void checkMoveP2(int direction)
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