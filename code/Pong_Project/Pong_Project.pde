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
boolean upL, downL;//Variables for movement of left paddle with keyPressed/Released

int padRX, padRY;//Create integers for right paddle, known here as padR. Integers follow same order as above
boolean upR, downR;//Variables for movement of right paddle with keyPressed/Released

int scoreL = 0;//Integer for score for left paddle
int scoreR = 0;//Integer for score for right paddle

int winScore = 3;//Integer for which the game will end at certain score, subject to change.

int timer;//Timer for millis to make modifiers
boolean dPaddles = false;//Variable for changing the paddle color. Also helps with splash screen
void setup() {
  size(750,750);//Size of the canvas, subject to change
  
  x = width/2;//List circle parameters
  y = height/2;
  w = 25;
  h = 25;
  speedX = 4;
  speedY = 3;
  

  rectMode(CENTER);
  padLX = 50;//Left paddle coordinates
  padLY = height/2;
  
  padRX = width-50;//Right paddle coordinates
  padRY = height/2;
  
  padLW = 20;//paddle parameters
  padLH = 50;//In these 3 cases padL represents both since they have the same size and speed.
  padLS = 10;//Will be the same wherever these variables are listed.
  
  textSize(30);//Text size and alignment for the points of each player
  textAlign(CENTER, CENTER);
  
  timer = millis();//Timer for each round
}

void draw() {
  background(0);//Color of canvas
  
  circleDraw();//Call from void circleDraw
  circleMove();//Call from void circleMove
  wallBounce();//Call from void wallBounce
  
  padLRDraw();//Call from void padLRDraw
  padLRMove();//Call from void padLRMove
  padLRLimit();//Call from void padLRLimit
  padLRHit();//Call from void padLRHit
  
  scores();//Call from void scores
  gameOver();//call from void gameOver
  if(dPaddles == false) {//Stops bug where splash page would loop when scores are 0
    splashPage();//call from void splashPage
  }
}

void padLRDraw() {//Draw the paddles
  fill(255);
  rect(padLX, padLY, padLW, padLH);
  rect(padRX, padRY, padLW, padLH);
  if(dPaddles) { //boolean variable to stop timer from having effect at splash screen
    if(millis() - timer > 10000) {//At 25 seconds into the round the paddles turn black
      fill(0);
      strokeWeight(.1);
      stroke(255);
      rect(padLX, padLY, padLW, padLH);
      rect(padRX, padRY, padLW, padLH);
      
      fill(255);
      text("Blind Mode", width/2, height/8);
      textSize(20);
    }
    if(millis() - timer > 15000) {//At 33 seconds the paddles turn white
      fill(255);
      strokeWeight(0);
      stroke(0);
      rect(padLX, padLY, padLW, padLH);
      rect(padRX, padRY, padLW, padLH);
      text("", width/2, height/8);
    }
    if(millis() - timer > 50000) {//Timer at 55 seconds
      fill(0);
      strokeWeight(.1);
      stroke(255);
      rect(padLX, padLY, padLW, padLH);
      rect(padRX, padRY, padLW, padLH);
      
      fill(255);
      text("Blind Mode", width/2, height/8);
      textSize(20);
    }
    if(millis() - timer > 65000) {//Timer at 65 seconds
      fill(255);
      strokeWeight(0);
      stroke(0);
      rect(padLX, padLY, padLW, padLH);
      rect(padRX, padRY, padLW, padLH);
      text("", width/2, height/8);
    }
  }
}

void padLRMove () {//Move the paddles with corresponding keys listed in void keyPressed & keyReleased
  if(upL == true) {
    padLY = padLY - padLS;
  }
  if(downL == true) {
    padLY = padLY + padLS;
  }
  if(upR == true) {
    padRY = padRY - padLS;
  }
  if(downR == true) {
    padRY = padRY + padLS;
  }
}

void padLRLimit() {//Set window limit so paddles dont move off screen
  if(padLY - padLH/2 < 0) {
    padLY = padLY + padLS;
  }
  if(padLY + padLH/2 > height) {
    padLY = padLY - padLS;
  }
  if(padRY - padLH/2 < 0) {
    padRY = padRY + padLS;
  }
  if(padRY + padLH/2 > height) {
    padRY = padRY - padLS;
  }
}

void padLRHit(){//Set rules for if the ball hits the paddles
  if(x - w/2 < padLX + padLW/2 && y - h/2 < padLY + padLH/2 && y + h/2 > padLY - padLH/2) {
    if(speedX < 0) {//Fixes glitch if the ball hit under or above the paddle
    speedX = -speedX + 1;//Left paddle collision
    }
  }
  else if(x + w/2 > padRX - padLW/2 && y - h/2 < padRY + padLH/2 && y + h/2 > padRY - padLH/2) {
    if(speedX > 0) {//Fixes glitch if the ball hit under or above the paddle
    speedX = -speedX - 1;//Right paddle collision
    }
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
    setup();//Resets to initial setup
    speedX = -speedX;
    scoreL = scoreL + 1;
  }
  
  else if ( x < 0 + w/2) {
    setup();//Resets to initial setup
    scoreR = scoreR + 1;
  }
  
  if( y > height - h/2) {
    speedY = -speedY;
  }
  
  else if( y < 0 + h/2) {
    speedY = -speedY;
  }
 
}

void gameOver() {//Displays written text once either player reaches score limit
  if(scoreL == winScore) {
    gameOverPage("Player 1 Wins!"); 
  }
  
  if(scoreR == winScore) {
    gameOverPage("Player 2 Wins!");
  }
}

void gameOverPage(String text) {//The page that displays when maximum score is reached. 
  
  speedX = 0;//Ball stops
  speedY = 0;
  
  text("Game over", width/2, height/3 -40);
  text(text, width/2, height/3);
  text("Click to Play again", width/2, height/3 + 40);//Displays text once score limit is reached
  
  if(mousePressed) {//Mouse press resets game once you see game over screen
    scoreR = 0;
    scoreL = 0;
    speedX = 4;
    speedY = 3;
  }
}

void splashPage() {//Page that displays at the beginning of program
  if(scoreL == 0 && scoreR == 0) {//Set score values so that page runs only when scores are this number
  
    speedX = 0;//Ball pauses until mouse is pressed
    speedY = 0;
    
    fill(255);
    text(scoreL, 100, 50);
    text(scoreR, width-100, 50);
    textSize(15);
    textAlign(CENTER, CENTER);
    
    text("Made by Caleb Kryton", width/2, height/12);
    text("Welcome to Pong!", width/2, height/6);//Text that displays during splash page
    text("This side is player 1", width/4, height/4);
    text("This side is player 2", 575, height/4);
    text("Player 1 uses S and W to move the paddle", width/4, height/4 + 40);
    text("Player 2 uses the UP and DOWN arrows", 575, height/4 + 40);
    text("Click the mouse to play!", width/2, height/2.5);
    text("There are some changes to this game, watch out!", width/2, height/2.8);
    
    textSize(30);
  }
  
  if(mousePressed) {//Game starts when mouse is pressed and points are set to 0 to start the game.
    setup();
    scoreR = 0;
    scoreL = 0;
    dPaddles = true;
  }
}

void keyPressed() {//Set key commands for left and right paddle
  if(key == 'w' || key == 'W') {
    upL = true;
  }
  
  if(key == 's' || key == 'S') {
    downL = true;
  }
  if(keyCode == UP) {
    upR = true;
  }
  
  if(keyCode == DOWN) {
    downR = true;
  }
}

void scores() {//Display the  score of each player
  fill(255);
  text(scoreL, 100, 50);
  text(scoreR, width-100, 50);
}

void keyReleased() {//For when the key is released, makes movement smoother
  if(key == 'w' || key == 'W') {
    upL = false;
  }
  
  if(key == 's' || key == 'S') {
    downL = false;
  }
  if(keyCode == UP) {
    upR = false;
  }
  
  if(keyCode == DOWN) {
    downR = false;
  }
}
