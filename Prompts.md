// Original Seed Prompts
I'm starting a Java game project in VS Code using Swing.
Create a single file called SnakeGame.java with a main method that opens a JFrame window (600x600 pixels) titled "Snake".
Add a JPanel subclass called GamePanel inside the frame. No game logic yet — just get the window to open.

Add a 20x20 grid to GamePanel. Represent the snake as a sequence of grid cells and start it with 3 segments near the center,
facing right. Each cell should be drawn as a 30x30 pixel square. Draw the snake in green and the background in dark gray.

Make the snake move automatically using a Swing timer that ticks every 150 milliseconds —
the snake should advance one cell per tick in its current direction. Add arrow key controls so the player can steer,
but don't allow the snake to reverse direction.
For now, have the snake wrap around the edges instead of dying. Make sure the panel can receive keyboard input

Add a food pellet that spawns at a random empty cell. When the snake eats it, grow by one segment and spawn new food.
Add collision detection: hitting a wall or the snake's own body should end the game, stop movement,
and show a "Game Over" message with the final score in the center of the screen.
Display the current score in the top-left corner during play.
When the game is over, let the player press R to reset everything and play again.

// Prompts used by Ben Ellefson

Convert the imported java file into HTML:
This was to create a working Web-version of the Snake game described by the seed prompts
to test that it was able to run by itself.

Add a start button to the game instead of the game starting automatically after you close the last one.:
This add a start button with an .addEventListener function on a click that would make the game easier to manage
if you wanted to play more than once. I feel its way more user friendly and i always felt when i play games that
it helped the player prepare for the next game better.

Put a countdown on the screen after the start button is pushed starting at 3. Instead of putting 0 at the end, have it say "GO!" and the game begin immediatly after:
I feel this gives the player a better chance to catch up to the faster pace of the game with a countdown. This prompt added a countdownelemnt to the event listener of the start button and was tied into the click command to begin immediately after that action.

Put an ascending musical sound effect synced with the countdown to start the game, and a sound effect that sounds like a chomp when the snake eats food.:
I just felt that when you hear sound effects when youre playing a game it really adds to the fun and immersion especially in more 
of an arcade stlye game. This prompt added a few functions called playtone, initaudio and playcountdownsound which was interesting to work with for the first time. One thing the AI didn't quite capture right away was having the pitch of the countdown going up instead of down. This gave it more of a crescendo feel before you get into the game which i enjoy.


Make the red square for the food look like an apple, with a small black stem on top and a little white on the outside resembling the shine of the apple. Then make the snake have two white eyes and a red line representing the tongue:
This just added a little more visual character to the game to make it look more like a snake and to have the red block in the shape of an apple. I wanted to keep it a brighter color still so the contrast makes it easier for the player to find it on the screen quickly. 
I had to also ask the AI to keep the tongue facing the direction the snake was going otherwise it made the snake head look more like a chicken. 
