/**
*Pong Project
*by Caleb Kryton
*Computer Science and Coding 10
*
*The purpose of this project is to experiment with modifiers, controllable
*objects and getting a ball to bounce around the screen. It is my major project 
*for my Computer Science 10 class.
*It is also to experiment with making my first game.
*/

int x;//Create integers for circle parameters
int y;
int w;
int h;//The reason for this is so that it is easier to make move later.

int speedX;//Speed of moving ball on x-axis
int speedY;//Speed of moving ball on y-axis

void setup() {
  size(750,750);//Size of canvas, subject to change
  
  x = width/2;//List circle parameters
  y = height/2;
  w = 50;
  h = 50;
  speedX = 2;
  speedY = 2;
}

void draw() {
  background(0);//Color of canvas
  
  fill(255,255,255);//Color of circle
  ellipse(x, y, w, h);//Draw circle
  
  if(x > width - w/2) {//If statement to bounce off right wall
    speedX = -speedX;
  }
  else if ( x < 0 + w/2) {//Secondary statement to bounce off left wall
    speedX = -speedX;
  }
  
  if( y > height - h/2) {
    speedY = -speedY;
  }
  
  else if( y < 0 + h/2) {
    speedY = -speedY;
  }
 
  x = x + speedX;
  y = y + speedY;
}
