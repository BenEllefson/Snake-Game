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

