import java.util.Scanner;

public class TicTacToe
{
 public static void main(String args[])
 {
  Scanner input = new Scanner(System.in);
  int[][] board =
  {
       {0,0,0},
       {0,0,0},
       {0,0,0}
  };

  drawBoard(board);// Draws empty game board
  int row, column; // Cell coordinates on the board
  for (int i = 0; i < 9; i++)//Game will last 9 turns
  {
   while (true)//Infinite loop to read coordinates
   {
    System.out.print("Enter a row (1, 2 or 3) for player" +
     (i % 2 == 0 ? "X" : "O") + ": ");
    row = input.nextInt() - 1;
    System.out.print("Enter a column (1, 2 or 3) for player" +
     (i % 2 == 0 ? "X" : "O") + ": ");
    column = input.nextInt() - 1;
    if (board[row][column] !=0)  //0 means a cell is vacant
    {
     System.out.println("Row" + row + "column" + column + "is already occupied, try again");
    }
    else
     break;
   }

  board[row][column] = (i % 2 == 0) ? 1 : 2;
  drawBoard(board);

   //Check whether one of the players won at the end of the turn
   switch (checkGameStatus(board))
   {
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
 public static void drawBoard(int[][] board)
 {
  for (int[] row : board)
  {
   for (int cell : row)
    switch (cell)
    {
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
 public static int checkGameStatus(int[][] board)
 {
  if (isFormLine(board, 1))
     return 1;//Player X won
  if (isFormLine(board, 2))
     return 2;//Player O won

  return 0;//Game continues
 }

 /** Checks whether digit in number parameter forms
 * horizontal/vertical/diagonal line */
 public static boolean isFormLine(int[][] board, int number)
 {
  boolean lineFormed = false;

  //Check rows of the board for a line of 1 (denotes X) or 2(denotes O)

  for (int i = 0; i < 3; i++)//i = row number
  {
   if (board[i][0] == number &&
       board[i][1] == number &&
       board[i][2] == number)
   {
    lineFormed = true;//Line on a row formed
   }
  }
  for (int j = 0; j < 3; j++)//j = column number
  {
   if (board[0][j] == number &&
       board[1][j] == number &&
       board[2][j] == number)
   {
    lineFormed = true;//Line on a column formed
   }
  }
   if (board[0][0] == number &&
       board[1][1] == number &&
       board[2][2] == number)
   {
    lineFormed = true;//Left Diagonal line formed
   }
   if (board[0][2] == number &&
       board[1][1] == number &&
       board[2][0] == number)
   {
    lineFormed = true;//Right Diagonal line formed
   }
 return lineFormed;
 }
}
