<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Snake Game</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            margin: 0;
            background-color: #222;
            font-family: Arial, sans-serif;
        }
        
        #gameContainer {
            text-align: center;
        }
        
        h1 {
            color: #fff;
            margin-bottom: 20px;
        }
        
        canvas {
            border: 2px solid #666;
            display: block;
            background-color: #323232;
        }
        
        #score {
            color: #fff;
            margin-top: 20px;
            font-size: 18px;
        }
        
        #instructions {
            color: #aaa;
            margin-top: 20px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <div id="gameContainer">
        <h1>Snake Game</h1>
        <canvas id="gameCanvas" width="600" height="600"></canvas>
        <div id="score">Score: 0</div>
        <div id="instructions">Use arrow keys to control the snake</div>
    </div>

    <script>
        const canvas = document.getElementById('gameCanvas');
        const ctx = canvas.getContext('2d');
        
        const GRID_SIZE = 20;
        const CELL_SIZE = 30;
        
        let snake = [
            { x: 10, y: 10 }, // Head
            { x: 9, y: 10 },  // Body
            { x: 8, y: 10 }   // Tail
        ];
        
        let direction = { x: 1, y: 0 };
        let nextDirection = { x: 1, y: 0 };
        let food = { x: 15, y: 15 };
        let score = 0;
        let gameRunning = true;
        
        // Keyboard controls
        document.addEventListener('keydown', (e) => {
            switch(e.key) {
                case 'ArrowUp':
                    if (direction.y === 0) nextDirection = { x: 0, y: -1 };
                    e.preventDefault();
                    break;
                case 'ArrowDown':
                    if (direction.y === 0) nextDirection = { x: 0, y: 1 };
                    e.preventDefault();
                    break;
                case 'ArrowLeft':
                    if (direction.x === 0) nextDirection = { x: -1, y: 0 };
                    e.preventDefault();
                    break;
                case 'ArrowRight':
                    if (direction.x === 0) nextDirection = { x: 1, y: 0 };
                    e.preventDefault();
                    break;
            }
        });
        
        function drawGrid() {
            ctx.strokeStyle = '#505050';
            ctx.lineWidth = 1;
            
            for (let i = 0; i <= GRID_SIZE; i++) {
                // Vertical lines
                ctx.beginPath();
                ctx.moveTo(i * CELL_SIZE, 0);
                ctx.lineTo(i * CELL_SIZE, GRID_SIZE * CELL_SIZE);
                ctx.stroke();
                
                // Horizontal lines
                ctx.beginPath();
                ctx.moveTo(0, i * CELL_SIZE);
                ctx.lineTo(GRID_SIZE * CELL_SIZE, i * CELL_SIZE);
                ctx.stroke();
            }
        }
        
        function drawSnake() {
            ctx.fillStyle = '#00FF00';
            for (let segment of snake) {
                ctx.fillRect(
                    segment.x * CELL_SIZE,
                    segment.y * CELL_SIZE,
                    CELL_SIZE,
                    CELL_SIZE
                );
            }
        }
        
        function drawFood() {
            ctx.fillStyle = '#FF0000';
            ctx.fillRect(
                food.x * CELL_SIZE,
                food.y * CELL_SIZE,
                CELL_SIZE,
                CELL_SIZE
            );
        }
        
        function generateFood() {
            let newFood;
            let onSnake = true;
            while (onSnake) {
                newFood = {
                    x: Math.floor(Math.random() * GRID_SIZE),
                    y: Math.floor(Math.random() * GRID_SIZE)
                };
                onSnake = snake.some(segment => 
                    segment.x === newFood.x && segment.y === newFood.y
                );
            }
            food = newFood;
        }
        
        function update() {
            if (!gameRunning) return;
            
            direction = nextDirection;
            
            // Calculate new head position
            const head = snake[0];
            const newHead = {
                x: head.x + direction.x,
                y: head.y + direction.y
            };
            
            // Check collisions with walls
            if (newHead.x < 0 || newHead.x >= GRID_SIZE || 
                newHead.y < 0 || newHead.y >= GRID_SIZE) {
                gameRunning = false;
                alert(`Game Over! Final Score: ${score}`);
                location.reload();
                return;
            }
            
            // Check collisions with self
            if (snake.some(segment => segment.x === newHead.x && segment.y === newHead.y)) {
                gameRunning = false;
                alert(`Game Over! Final Score: ${score}`);
                location.reload();
                return;
            }
            
            // Add new head
            snake.unshift(newHead);
            
            // Check if food is eaten
            if (newHead.x === food.x && newHead.y === food.y) {
                score += 10;
                document.getElementById('score').textContent = `Score: ${score}`;
                generateFood();
            } else {
                snake.pop();
            }
        }
        
        function draw() {
            // Clear canvas
            ctx.fillStyle = '#323232';
            ctx.fillRect(0, 0, canvas.width, canvas.height);
            
            // Draw grid
            drawGrid();
            
            // Draw game elements
            drawFood();
            drawSnake();
        }
        
        function gameLoop() {
            update();
            draw();
        }
        
        // Start game loop - update 10 times per second
        setInterval(gameLoop, 100);
    </script>
</body>
</html>
