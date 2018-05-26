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

