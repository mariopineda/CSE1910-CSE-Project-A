# Log Message for Major Project for Week 2
  This week I feel like I learned some very useful methods to make changes to the base game of pong. I learned how to properly use millis() to make a timer which was used to make modifications to the game. I also modified my game and changed a small piece of the game from my initial plan. My initial plan included making a small part of the game have a super speed modifier and make the game much more difficult for the player. My main problem for this was that, first of all, the overall beginning gameplay was very stale since the speed itself never changed so the ball would always move the same speed and it would get boring. The second thing is that it felt too intrusive for the speed to suddenly double for the simple reason of increasing the difficulty drastically. It ruined the flow of the game and presented itself with an interesting bug that I couldn't really fix in time. The bug would be that the ball would always stick to once side of the map while the timer was occuring. This meant that I would have to write a seperate set of bounce properties for the ball once it was in super speed mode and I figured that was too much for the time being.
  
  This led to me deviating from that part of the plan and making the speed increase per bounce instead of rapidly and suddenly. At first I though this would be harder to implement but it turned out to be much simpler than expected. This made the overall feel of the game much better for multiple reasons; the game had a more linear progression to the difficulty instead of suddenly ramping up so people won't be as surprised by the sudden increase in difficulty. It also improved the flow so that added in different modifiers wouldn't make the game feel weird to play and throw off the players too much. I'm thinking of adding in additional text to the modifiers when they occur but that will come if the feedback requires it. I'm pleased with the result of adding modifiers to the game and can't wait to see what presentation will yield for the players and for me as I expect to have improvements to add and nostalgia to ensue for the people who remember the classic game of pong. 
  
## What was your goal for the past week?
  My goal for this week was to add some modifications to the original game of pong. This was the overall main purpose but I also added an additional splash screen to the game which I was brainstorming over during the week. Ultimately I thought it would be a great idea because most people are not inherently ready to play a game the second they open it. Every game made today has some sort of menu screen so I decided to add one to mine as well. Overall it made the game look a lot better and adds some fluency to the game that was much needed. This screen, however, did not come without its own group of issues. I had to polish the font for the scores so that they would be a different size and wouldn't resize themselves when the game changed from splash screen to main game. 
  
  This was accomplished by redrawing the points for each player and adding a second font to the chunk of code where the splash screen takes place. The main challenges for this week were figuring out how to make a timer and solving the problems that presented themselves when creating the timer and splash screen. Once I logically worked my way through the problems they became simple to fix. I also made one change from my original plan in the project. I initially wanted to make a modifier to add a super speed portion to the game but decided to switch up my idea when I figured out that I could make the speed increase everytime the ball hit a paddle, the code for that shown here: *if(x - w/2 < padLX + padLW/2 && y - h/2 < padLY + padLH/2 && y + h/2 > padLY - padLH/2) {
    if(speedX < 0) {
    speedX = -speedX + 1;*
    The key part is the last bit where the speed changes direction and adds 1 unit to the speed of the ball on the x-axis. There is a mirrored part to the code for the opposite paddle but all the math signs are switched so that the reflection works correctly. 
With this changed I decided to add a different modifier to the game. I added a timer to change the fill color of the rectangles to be black but without a small outline so that the player could still see them but not as easily as before. This was accomplished with millis timers and a simple change of strokeWeight and fill as shown here: *if(millis() - timer > 15000) {15 
      fill(0);
      strokeWeight(.1);
      stroke(255);
      rect(padLX, padLY, padLW, padLH);
      rect(padRX, padRY, padLW, padLH);
    }
    if(millis() - timer > 25000) {
      fill(255);
      strokeWeight(0);
      stroke(0);
      rect(padLX, padLY, padLW, padLH);
      rect(padRX, padRY, padLW, padLH);
    }*
    This was everything I wanted to add as modifiers to the game. I thought about adding multiple balls but I felt it was unnecessary and didn't include it into my plan for this particular project. Perhaps it would be more suitable in a Bricks style game where you can use multiple balls to smash a bunch of bricks in a certain shape. 
    
## Did you accomplish last week’s goal? Why/why not?
  I did accomplish my goal for this week. The only thing I had assigned for myself to do this week was to add modifiers. Initially I only wanted to add super speed but that plan changed when I added an overall speed increase to the ball everytime it hit a paddle. This works out much better for the flow of the game anyways so I was content with keeping this change and adding more dynamic paddles instead. Now the paddles change color for a certain amount of time and the ball gets faster as time goes on making the game very difficult to play after a while which is exactly how I wanted it designed. 
  
  I also added a splash screen. This wasn't in my initial plan for the game but I was brainstorming and decided it would be a lot more user friendly if I did add one. It was roughly the same process as making the game over screen but was overall less complex because it was just a seperate screen to display a bunch of text on top of the main game. After changing some fonts and placement of text it makes the game look a lot better once started up. The modifiers don't feel too intrusive to the experience of the game and the game flows really well so I am pleased with the result of all the changes I made this week.

## What did you learn this week?
  This week I learned how to make timers and modifiers using the millis() function. This was an issue I had with a seperate project but I am pleased I finally managed to figure it out. It also was a lot less complicated than I made it out to be for myself. I used the millis timer to introduce new mechanics into the game. My first thought was if the modifiers would break the flow of the game or be too intrusive. I might have to do some small adjustments and maybe add some text to the modifiers if necessary but that will come with feedback. Overall I think it looks and works fine. I also learned how to make a splash screen. This was very similar to making the game over screen but I only had it drawn once in the draw function and had it depend on a boolean variable so that the function wouldn't loop if the points remained at 0 since that was the condition the splash screen was based on. 
  
  This week was about learning how to make timing functions with millis() and learning more about the funtion of boolean variables. Using these two functions enabled me to make the game work much more smoothly than it did before and expands the amount of ways I can implement new changes and functions into my code to make everything work much more smoothly. Everything I set out to do in terms of development for the game has been finished. All that's left is small adjustments and polishing the game. There will also be bug testing for any ridiculous bugs that could possibly be left. 

## What is your goal for next week?
  My main goal for next week is to have a flawless presentation for my game and hopefully have very little bugs or none at all to fix. As this is my first main project in processing I imagine that it won't be flawless so i'm ready and excited to work through the process of identifying bugs and fixing them as they present themselves even though this game is very simple. I also have the goal of making any necessary Quality of Life changes that will make the game look and feel much better for those that decide to play it. 
  
  As I am mostly finished this project I'm excited for the feedback I recieve from my peers and instructor because I want this to be as perfect as it can be. This is my first game and the start of what I hope to do for my career so I want to work through all the processes necessary to make a great game. Any mistakes made will only improve the game and will make my learning much better so I hope to see some issues that I missed. 

## What are the main challenges you are facing next week?
  The main challenges I will face are making any minor changes to the game that will help make the game work like a well oiled machine. Any bugs that present themselves will force me to comb through every bit of my code and tweak each small piece to make sure it is fixed. I will also have to make sure that any adjustments made to the code do not affect anything else and break the game even further.
  
  Another challenge is getting feedback of the "mostly finished" game from my peers. The game has to work well and be appealing to the player and spectators so I hope the changes I made to the standard game of pong still make it appealing to all parties who wish to play it and/or watch it. After all, the whole point of this project is to simulate a finished piece of work to be shown to people who will judge the game and decide if it works and looks good enough to make it to market. I feel ready to make any changes necessary to make the game great and look forward to the process of debugging and working through any glitches that are shown during presentation. 

# Marking Rubric

| Concerns (_Areas that need work_) | Criteria (_Criteria for proficiency_) | Advanced (_Evidence of exceeding proficiency_) |
| ---                               | ---                                   | ---                                            |
| | Log and commit message show evidence of progress and that class time has been used efficiently | X |
| | All required questions have been answered with sufficient detail | X |
| | Log messages are accurate and constent with commit history | X |
| | Appropriate Markdown syntax is used | X |
| | Complete sentences/paragraphs and correct English spelling, grammar and punctuation is used | X |

15/15 (100%)
