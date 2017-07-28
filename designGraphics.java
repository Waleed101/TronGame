class designGraphics
{
   public static void main(String[] args)
   {
      Board gameBoard = new Board(48,89);
      int hey = 1;
      int[] clicksRow = new int[1000];
      int[] clicksCol = new int[1000];
      int currentClick = 0;
      Coordinate click;
      
  gameBoard.putPeg("greenM", 43, 79);gameBoard.putPeg("greenM", 44, 79);gameBoard.putPeg("greenM", 45, 79);gameBoard.putPeg("greenM", 45, 80);gameBoard.putPeg("greenM", 46, 81);gameBoard.putPeg("greenM", 46, 82);gameBoard.putPeg("greenM", 45, 82);gameBoard.putPeg("greenM", 44, 82);gameBoard.putPeg("greenM", 43, 82);gameBoard.putPeg("greenM", 42, 82);gameBoard.putPeg("greenM", 42, 81);gameBoard.putPeg("greenM", 43, 80);
  while(true)
      {
			click = gameBoard.getClick();
         gameBoard.putPeg("green", click.getRow(), click.getCol());
         System.out.print("gameBoard.putPeg(//, " + click.getRow() + ", " + click.getCol() + ");");
      }
   }

}