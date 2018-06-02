import java.util.Scanner;

public class Tic-Tac-Toe
{
 public static void main(String args[]){
  Scanner input = new Scanner(System.in);
  int[][] board = {
       {0,0,0},
       {0,0,0},
       {0,0,0}
  };

  drawBoard(board);// Draws empty game board
  int row, column; // Cell coordinates on the board

  if(playerNum == 2) //AI
    {
     int bestVal = Integer.MIN_VALUE;// Declares Best value with the minimum value
     int bestSpot = 0;
     for(int i = 0; i < node.length; i++)//Declares Best Spot has to be empty
     {
      if(node[i] != '-')
         continue;
      node[i] = getSymbol(playerNum);
      int value = miniMax(node, 1);
      if(value > bestVal)//Tells if value of the integer is more than the best value
      {
       bestVal = value;
       bestSpot = i;
      }

      node[i] = '-';
     }
     return bestSpot;
    }

  for (int i = 0; i < 9; i++){//Game will last 9 turns

   while (true){//Infinite loop to read coordinates
    System.out.print("Enter a row (1, 2 or 3) for player" +
     (i % 2 == 0 ? "X" : "O") + ": ");
    row = input.nextInt() - 1;
    System.out.print("Enter a column (1, 2 or 3) for player" +
     (i % 2 == 0 ? "X" : "O") + ": ");
    column = input.nextInt() - 1;
    if (board[row][column] !=0) { //0 means a cell is vacant
     System.out.println("Row" + row + "column" + column + "is already occupied, try again");
    }
    else
     break;
   }

  board[row][column] = (i % 2 == 0) ? 1 : 2;
  drawBoard(board);

  //Check whether one of the players won at the end of the turn
  switch (checkGameStatus(board)){
   case 1:
    System.out.println("X player won");
    return;//Ends Game
   case 2:
    System.out.println("O player won");
    return;//Ends Game
   }
  }

  //In case nobody has won after 9 turns
  System.out.println("It's a draw");
 }

/**Visualize game board*/
public static void drawBoard(int[] board){
 for (int[] row : board){
  for (int cell : row)
   switch (cell) {
    case 0:
     System.out.print("| ");
     break;
    case 1:
     System.out.print("|X");
     break;
    case 2:
     System.out.print("|O");
     break;
   default:
     System.out.println("Wrong element on board");
     System.exit(1);
  }
  System.out.println("|");
 }
}

/** Check whether current board state corresponds to the win of one
*of the players */
public static int checkGameStatus(int[][] board){
 if (isFormLine(board, 1))
    return 1;//Player X won
 if (isFormLine(board, 2))
    return 2;//Player O won

 return 0;//Game continues
}

/** Checks whether digit in number parameter forms
* horizontal/vertical/diagonal line */
public static boolean isFormLine(int[][] board, int number){
 boolean lineFormed;

 //Check rows of the board for a line of 1 (denotes X) or 2(denotes O)

 for (int i = 0; i < board.length; i++){
     lineFormed = true;
     for (int j = 0; j < board[i].length; j++)
       if (board[i][j - 1] != number || board[i][j] != number)
          lineFormed = false;
     if (lineFormed)
        return true;//Horizontal line formed
 }

 //Check columns
 for (int j = 0; j < board[0].length; j++){
     lineFormed = true;
     for (int i = 1; i < board.length; i++)
       if (board[i - 1][j] != number || board[i][j] != number)
          lineFormed = false;
     if (lineFormed)
        return true;
 }

 //Check major diagonal
 lineFormed = true;
 for (int i = 1; i < board.length; i++){
     if (board[i - 1][i - 1] != number || board[i][i] != number)
          lineFormed = false;
 if (lineFormed)
    return true;

 //Check minor diagonal
 lineFormed = true;
 for (int i = 1; i < board.length; i++)
     if (board[board.length - i][i - 1] != number ||
           board[board.length - i - 1][i] != number)
         lineFormed = false;
 if (lineFormed)
     return true;

 return false;//If none of the lines is formed
 }
} 
