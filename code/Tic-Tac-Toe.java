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

   

