import java.util.Scanner;

public class Tic-Tac-Toe
{
 public static void main(String args[])
 {
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

