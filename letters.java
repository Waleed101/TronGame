public class letters
{
   private static String color, phrase;
   private static int row, col; 
   static void typeLetters(String userPhrase, Board gameBoard, int userRow, int userCol, String userColor)
   {
      color = userColor;
      phrase = userPhrase;
      row = userRow;
      col = userCol;
      phrase = phrase.toLowerCase();
      int length = phrase.length();
      letterLoop(length, gameBoard);
   }
   
   static void typeNumbers(int num, Board gameBoard, int userRow, int userCol, String userColor)
   {
      color = userColor;
      phrase = String.valueOf(num);
      System.out.println(phrase);
      row = userRow;
      col = userCol;
      int length = phrase.length();
      letterLoop(length, gameBoard);
   }
   
   static void removeLetters(String userPhrase, Board gameBoard, int userRow, int userCol, String userColor)
   {
      color = userColor;
      phrase = userPhrase;
      row = userRow;
      col = userCol;
      phrase = phrase.toLowerCase();
      int length = phrase.length();
      removeLetterLoop(length, gameBoard);
   }
   
   static void removeNumbers(int num, Board gameBoard, int userRow, int userCol, String userColor)
   {
      color = userColor;
      phrase = String.valueOf(num);
      System.out.println(phrase);
      row = userRow;
      col = userCol;
      int length = phrase.length();
      removeLetterLoop(length, gameBoard);
   }

   
   
   
   private static void removeLetterLoop(int length, Board gameBoard)
   {
      for(int i=0; i < length; i++)
      {
         switch(phrase.substring(i, i+1))
         {
            case "a":
            removeLetters("a", gameBoard);
            break;
            
            case "b":
            removeLetters("b", gameBoard);
            break;
            
            case "c":
            removeLetters("c", gameBoard);
            break;
            
            case "d":
            removeLetters("d", gameBoard);
            break;
            
            case "e":
            removeLetters("e", gameBoard);
            break;
            
            case "f":
            removeLetters("f", gameBoard);
            break;
            
            case "g":
            removeLetters("g", gameBoard);
            break;
            
            case "h":
            removeLetters("h", gameBoard);
            break;
            
            case "i":
            removeLetters("i", gameBoard);
            break;
            
            case "j":
            removeLetters("j", gameBoard);
            break;
            
            case "k":
            removeLetters("k", gameBoard);
            break;
            
            case "l":
            removeLetters("l", gameBoard);
            break;
            
            case "m":
            removeLetters("m", gameBoard);
            break;
            
            case "n":
            removeLetters("n", gameBoard);
            break;
            
            case "o":
            removeLetters("o", gameBoard);
            break;
            
            case "p":
            removeLetters("p", gameBoard);
            break;
            
            case "q":
            removeLetters("q", gameBoard);
            break;
            
            case "r":
            removeLetters("r", gameBoard);
            break;
            
            case "s":
            removeLetters("s", gameBoard);
            break;
            
            case "t":
            removeLetters("t", gameBoard);
            break;
            
            case "u":
            removeLetters("u", gameBoard);
            break;
            
            case "v":
            removeLetters("v", gameBoard);
            break;
            
            case "w":
            removeLetters("w", gameBoard);
            break;
            
            case "x":
            removeLetters("x", gameBoard);
            break;
            
            case "y":
            removeLetters("y", gameBoard);
            break;
            
            case "z":
            removeLetters("z", gameBoard);
            break;
            
            case ",":
            removeLetters(",", gameBoard);
            break;
            
            case ".":
            removeLetters(".", gameBoard);
            break;
            
            case ":":
            removeLetters(":", gameBoard);
            break;
            
            case "!":
            removeLetters("!", gameBoard);
            
            case "0":
            removeLetters("0", gameBoard);
            break;
            
            case "1":
            col++;
            removeLetters("1", gameBoard);
            break;
            
            case "2":
            removeLetters("2", gameBoard);
            break;
            
            case "3":
            removeLetters("3", gameBoard);
            break;
            
            case "4":
            removeLetters("4", gameBoard);
            break;
            
            case "5":
            removeLetters("5", gameBoard);
            break;
            
            case "6":
            removeLetters("6", gameBoard);
            break;
            
            case "7":
            removeLetters("7", gameBoard);
            break;
            
            case "8":
            removeLetters("8", gameBoard);
            break;
            
            case "9":
            removeLetters("9", gameBoard);
            break;
             
            default:
            col+=2;
            break;
         }
      }
   }
   
   private static void letterLoop(int length, Board gameBoard)
   {
      for(int i=0; i < length; i++)
      {
         switch(phrase.substring(i, i+1))
         {
            case "a":
            drawLetters("a", gameBoard);
            break;
            
            case "b":
            drawLetters("b", gameBoard);
            break;
            
            case "c":
            drawLetters("c", gameBoard);
            break;
            
            case "d":
            drawLetters("d", gameBoard);
            break;
            
            case "e":
            drawLetters("e", gameBoard);
            break;
            
            case "f":
            drawLetters("f", gameBoard);
            break;
            
            case "g":
            drawLetters("g", gameBoard);
            break;
            
            case "h":
            drawLetters("h", gameBoard);
            break;
            
            case "i":
            drawLetters("i", gameBoard);
            break;
            
            case "j":
            drawLetters("j", gameBoard);
            break;
            
            case "k":
            drawLetters("k", gameBoard);
            break;
            
            case "l":
            drawLetters("l", gameBoard);
            break;
            
            case "m":
            drawLetters("m", gameBoard);
            break;
            
            case "n":
            drawLetters("n", gameBoard);
            break;
            
            case "o":
            drawLetters("o", gameBoard);
            break;
            
            case "p":
            drawLetters("p", gameBoard);
            break;
            
            case "q":
            drawLetters("q", gameBoard);
            break;
            
            case "r":
            drawLetters("r", gameBoard);
            break;
            
            case "s":
            drawLetters("s", gameBoard);
            break;
            
            case "t":
            drawLetters("t", gameBoard);
            break;
            
            case "u":
            drawLetters("u", gameBoard);
            break;
            
            case "v":
            drawLetters("v", gameBoard);
            break;
            
            case "w":
            drawLetters("w", gameBoard);
            break;
            
            case "x":
            drawLetters("x", gameBoard);
            break;
            
            case "y":
            drawLetters("y", gameBoard);
            break;
            
            case "z":
            drawLetters("z", gameBoard);
            break;
            
            case ",":
            drawLetters(",", gameBoard);
            break;
            
            case ".":
            drawLetters(".", gameBoard);
            break;
            
            case ":":
            drawLetters(":", gameBoard);
            break;
            
            case "!":
            drawLetters("!", gameBoard);
            break;
            
            case "0":
            drawLetters("0", gameBoard);
            break;
            
            case "1":
            col++;
            drawLetters("1", gameBoard);
            break;
            
            case "2":
            drawLetters("2", gameBoard);
            break;
            
            case "3":
            drawLetters("3", gameBoard);
            break;
            
            case "4":
            drawLetters("4", gameBoard);
            break;
            
            case "5":
            drawLetters("5", gameBoard);
            break;
            
            case "6":
            drawLetters("6", gameBoard);
            break;
            
            case "7":
            drawLetters("7", gameBoard);
            break;
            
            case "8":
            drawLetters("8", gameBoard);
            break;
            
            case "9":
            drawLetters("9", gameBoard);
            break;
             
            default:
            col+=2;
            break;
         }
      }
   }
   
     private static void removeLetters(String letter, Board gameBoard)
   {
      switch(letter)
      {
         case "a":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(2+row, 2+col);
         col+=4;
         break;
         
         case "b":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(1+row, 2+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);
         col+=3;
         break;
         
         case "c":
         gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 3+col);
         col+=4;
         break;
         
         case "d":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(1+row, 2+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(4+row, 1+col);
         col+=4;
         break;
         
         case "e":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);
         col+=3;
         break;
         
         case "f":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(2+row, 1+col);
         col+=3;
         break;
         
         case "g":
         gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(2+row, 2+col);
         col+=4;
         break;
         
         case "h":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 3+col);
         col+=4;
         break;
         
         case "i":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 2+col);
         col+=3;
         break; 
         
         case "j":
         gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 2+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(3+row, 0+col);
         col+=4;
         break;
         
         case "k":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(1+row, 2+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(0+row, 3+col);
         col+=4;
         break;
         
         case "l":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);
         col+=3;
         break; 
         
         case "m":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 4+col);gameBoard.removePeg(1+row, 4+col);gameBoard.removePeg(2+row, 4+col);gameBoard.removePeg(3+row, 4+col);gameBoard.removePeg(4+row, 4+col);
         col+=5;
         break;
         
         case "n":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 4+col);gameBoard.removePeg(3+row, 4+col);gameBoard.removePeg(2+row, 4+col);gameBoard.removePeg(1+row, 4+col);gameBoard.removePeg(0+row, 4+col);
         col+=5;
         break; 
         
         case "o":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);
         col+=4;
         break;
         
         case "p":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(1+row, 2+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);
         col+=3;
         break;
         
         case "q":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(5+row, 4+col);
         col+=5;
         break;
         
         case "r":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(1+row, 2+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(4+row, 2+col);
         col+=3;
         break;
         
         case "s":
         gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 0+col);
         col+=4;
         break;
         
         case "t":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(4+row, 1+col);
         col+=3;
         break;
         
         case "u":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 3+col);
         col+=4;
         break;
         
         case "v":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(3+row, 4+col);gameBoard.removePeg(2+row, 5+col);gameBoard.removePeg(1+row, 6+col);gameBoard.removePeg(0+row, 6+col);
         col+=7;
         break;
         
         case "w":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 4+col);gameBoard.removePeg(3+row, 4+col);gameBoard.removePeg(2+row, 4+col);gameBoard.removePeg(1+row, 4+col);gameBoard.removePeg(0+row, 4+col);
         col+=5;
         break;
         
         case "x":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 4+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 4+col);
         col+=5;
         break;
         
         case "y":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 4+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(4+row, 2+col);
         col+=5;
         break;
         
         case "z":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 4+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 2+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(4+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(4+row, 4+col);
         col+=5;
         break; 
         
         case ",":
         gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(5+row, 0+col);
         col+=2;
         break; 
         
         case ".":
         gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(3+row, 1+col);
         col+=2;
         break;
         
         case ":":
         gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(3+row, 0+col);
         col++;
         break;
         
         case "0":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(5+row, 0+col);gameBoard.removePeg(6+row, 0+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(6+row, 2+col);gameBoard.removePeg(6+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);
         col+=4;
         break;
         
         case "1":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(5+row, 0+col);gameBoard.removePeg(6+row, 0+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(4+row, 1+col);gameBoard.removePeg(5+row, 1+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(2+row, 1+col);gameBoard.removePeg(1+row, 1+col);gameBoard.removePeg(0+row, 1+col);
         col+=2;
         break;
         
         case "2":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(5+row, 0+col);gameBoard.removePeg(6+row, 0+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(6+row, 2+col);gameBoard.removePeg(6+row, 3+col);
         col+=4;
         break;
         
         case "3":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(6+row, 3+col);gameBoard.removePeg(6+row, 2+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(6+row, 0+col);
         col+=4;
         break;
         
         case "4":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(6+row, 3+col);     
         col+=4;
         break;
         
         case "5":
         gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(6+row, 3+col);gameBoard.removePeg(6+row, 2+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(6+row, 0+col); 
         col+=4;
         break;
         
         case "6":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(5+row, 0+col);gameBoard.removePeg(6+row, 0+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(6+row, 2+col);gameBoard.removePeg(6+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(3+row, 1+col);
         col+=4;
         break;
         
         case "7":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(6+row, 3+col);
         col+=4;
         break;
         
         case "8":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(4+row, 0+col);gameBoard.removePeg(5+row, 0+col);gameBoard.removePeg(6+row, 0+col);gameBoard.removePeg(6+row, 1+col);gameBoard.removePeg(6+row, 2+col);gameBoard.removePeg(6+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(4+row, 3+col);
         col+=4;
         break;
         
         case "9":
         gameBoard.removePeg(0+row, 0+col);gameBoard.removePeg(1+row, 0+col);gameBoard.removePeg(2+row, 0+col);gameBoard.removePeg(3+row, 0+col);gameBoard.removePeg(3+row, 1+col);gameBoard.removePeg(0+row, 1+col);gameBoard.removePeg(0+row, 2+col);gameBoard.removePeg(0+row, 3+col);gameBoard.removePeg(1+row, 3+col);gameBoard.removePeg(2+row, 3+col);gameBoard.removePeg(3+row, 3+col);gameBoard.removePeg(3+row, 2+col);gameBoard.removePeg(4+row, 3+col);gameBoard.removePeg(5+row, 3+col);gameBoard.removePeg(6+row, 3+col);
         col+=4;
         break;             
      }
      col++;
      
   }
   
   private static void drawLetters(String letter, Board gameBoard)
   {
      switch(letter)
      {
         case "a":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);
         col+=4;
         break;
         
         case "b":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 1+row, 2+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);
         col+=3;
         break;
         
         case "c":
         gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);
         col+=4;
         break;
         
         case "d":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 1+row, 2+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 4+row, 1+col);
         col+=4;
         break;
         
         case "e":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);
         col+=3;
         break;
         
         case "f":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 2+row, 1+col);
         col+=3;
         break;
         
         case "g":
         gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 2+row, 2+col);
         col+=4;
         break;
         
         case "h":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);
         col+=4;
         break;
         
         case "i":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 2+col);
         col+=3;
         break; 
         
         case "j":
         gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 2+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 3+row, 0+col);
         col+=4;
         break;
         
         case "k":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 1+row, 2+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);
         col+=4;
         break;
         
         case "l":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);
         col+=3;
         break; 
         
         case "m":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 4+col);gameBoard.putPeg(color, 1+row, 4+col);gameBoard.putPeg(color, 2+row, 4+col);gameBoard.putPeg(color, 3+row, 4+col);gameBoard.putPeg(color, 4+row, 4+col);
         col+=5;
         break;
         
         case "n":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 4+col);gameBoard.putPeg(color, 3+row, 4+col);gameBoard.putPeg(color, 2+row, 4+col);gameBoard.putPeg(color, 1+row, 4+col);gameBoard.putPeg(color, 0+row, 4+col);
         col+=5;
         break; 
         
         case "o":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);
         col+=4;
         break;
         
         case "p":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 1+row, 2+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);
         col+=3;
         break;
         
         case "q":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 5+row, 4+col);
         col+=5;
         break;
         
         case "r":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 1+row, 2+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);
         col+=3;
         break;
         
         case "s":
         gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 0+col);
         col+=4;
         break;
         
         case "t":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 4+row, 1+col);
         col+=3;
         break;
         
         case "u":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);
         col+=4;
         break;
         
         case "v":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 3+row, 4+col);gameBoard.putPeg(color, 2+row, 5+col);gameBoard.putPeg(color, 1+row, 6+col);gameBoard.putPeg(color, 0+row, 6+col);
         col+=7;
         break;
         
         case "w":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 4+col);gameBoard.putPeg(color, 3+row, 4+col);gameBoard.putPeg(color, 2+row, 4+col);gameBoard.putPeg(color, 1+row, 4+col);gameBoard.putPeg(color, 0+row, 4+col);
         col+=5;
         break;
         
         case "x":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 4+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 4+col);
         col+=5;
         break;
         
         case "y":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 4+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 4+row, 2+col);
         col+=5;
         break;
         
         case "z":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 4+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 2+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 4+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 4+row, 4+col);
         col+=5;
         break; 
         
         case ",":
         gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 5+row, 0+col);
         col+=2;
         break; 
         
         case ".":
         gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 3+row, 1+col);
         col+=2;
         break;
         
         case ":":
         gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);
         col++;
         break;
         
         case "!":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);
         col++;
         break;
         
         case "0":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 5+row, 0+col);gameBoard.putPeg(color, 6+row, 0+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);
         col+=4;
         break;
         
         case "1":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 5+row, 0+col);gameBoard.putPeg(color, 6+row, 0+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 4+row, 1+col);gameBoard.putPeg(color, 5+row, 1+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 2+row, 1+col);gameBoard.putPeg(color, 1+row, 1+col);gameBoard.putPeg(color, 0+row, 1+col);
         col+=2;
         break;
         
         case "2":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 5+row, 0+col);gameBoard.putPeg(color, 6+row, 0+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 3+col);
         col+=4;
         break;
         
         case "3":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 6+row, 3+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 0+col);     col+=4;
         break;
         
         case "4":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 6+row, 3+col);     col+=4;
         break;
         
         case "5":
         gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 6+row, 3+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 0+col);
         col+=4;
         break;
         
         case "6":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 5+row, 0+col);gameBoard.putPeg(color, 6+row, 0+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 3+row, 1+col);
         col+=4;
         break;
         
         case "7":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 6+row, 3+col);
         col+=4;
         break;
         
         case "8":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 4+row, 0+col);gameBoard.putPeg(color, 5+row, 0+col);gameBoard.putPeg(color, 6+row, 0+col);gameBoard.putPeg(color, 6+row, 1+col);gameBoard.putPeg(color, 6+row, 2+col);gameBoard.putPeg(color, 6+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 4+row, 3+col);
         col+=4;
         break;
         
         case "9":
         gameBoard.putPeg(color, 0+row, 0+col);gameBoard.putPeg(color, 1+row, 0+col);gameBoard.putPeg(color, 2+row, 0+col);gameBoard.putPeg(color, 3+row, 0+col);gameBoard.putPeg(color, 3+row, 1+col);gameBoard.putPeg(color, 0+row, 1+col);gameBoard.putPeg(color, 0+row, 2+col);gameBoard.putPeg(color, 0+row, 3+col);gameBoard.putPeg(color, 1+row, 3+col);gameBoard.putPeg(color, 2+row, 3+col);gameBoard.putPeg(color, 3+row, 3+col);gameBoard.putPeg(color, 3+row, 2+col);gameBoard.putPeg(color, 4+row, 3+col);gameBoard.putPeg(color, 5+row, 3+col);gameBoard.putPeg(color, 6+row, 3+col);
         col+=4;
         break;             
      }
      col++;
      
   }
   

     
   
   
}