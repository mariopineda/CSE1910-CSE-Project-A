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

int speed;//Speed of moving ball

void setup() {
  size(500,500);//Size of canvas, subject to change
  
  x = width/2;//List circle parameters
  y = height/2;
  w = 50;
  h = 50;
  speed = 1;
  
}

void draw() {
  background(0);//Color of canvas
  
  fill(255,255,255);//Color of circle
  ellipse(x, y, w, h);//Draw circle
  
  if(x > width) {
    speed = -speed;
  }
  else if ( x < 0) {
    speed = -speed;
  }
  x = x + speed;
}
