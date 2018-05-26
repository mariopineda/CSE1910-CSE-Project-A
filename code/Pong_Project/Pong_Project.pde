/**
*Pong Project
*by Caleb Kryton
*Computer Science and Coding 10
*
*The purpose of this project is to experiment with modifiers, controllable
*objects and getting a ball to bounce around the screen. It is my major project 
*for my Computer Science 10 class.
*It is also to experiment with making my first game.
*
*I will also experiment with alternative organization practices from my typical projects
*so if the code looks different from then that's why.
*/

int x, y, w, h, speedX, speedY;//Create integers for circle parameters
//I put all the integers on the same line instead of a list to save on memory.

int padLX, padLY, padLW, padLH, padLS;//Create integers for left paddle, known here as padL. Integers follow same order as above
boolean up, down;

void setup() {
  size(750,750);//Size of the canvas, subject to change
  
  x = width/2;//List circle parameters
  y = height/2;
  w = 50;
  h = 50;
  speedX = 2;
  speedY = 1;
  
  rectMode(CENTER);
  padLX = 50;
  padLY = height/2;
  padLW = 20;
  padLH = 75;
  padLS = 5;
}

void draw() {
  background(0);//Color of canvas
  
  circleDraw();//Call from void circleDraw
 
  circleMove();//Call from void circleMove
  
  wallBounce();//Call from void wallBounce
  
  padLDraw();//Call from void padLDraw
  
  padLMove();//Call from void padLMove

}

void padLDraw() {
  fill(255);
  rect(padLX, padLY, padLW, padLH);

}

void padLMove () {
  if(up == true) {
    padLY = padLY - padLS;
  }
  if(down == true) {
    padLY = padLY + padLS;
  }
}

void circleDraw() {//Draw the circle
  fill(255,255,255);//Color of circle
  ellipse(x, y, w, h);
}

void circleMove() {//Make the circle move
  x = x + speedX;
  y = y + speedY;
}

void wallBounce() {//If and if else statements to bounce off wall 
  
  if(x > width - w/2) {
    speedX = -speedX;
  }
  else if ( x < 0 + w/2) {
    speedX = -speedX;
  }
  
  if( y > height - h/2) {
    speedY = -speedY;
  }
  
  else if( y < 0 + h/2) {
    speedY = -speedY;
  }
}

void keyPressed() {
  if(key == 'w' || key == 'W') {
    up = true;
  }
  
  if(key == 's' || key == 'S') {
    down = true;
  }
}

void keyReleased() {
  if(key == 'w' || key == 'W') {
    up = false;
  }
  
  if(key == 's' || key == 'S') {
    down = false;
  }
}
