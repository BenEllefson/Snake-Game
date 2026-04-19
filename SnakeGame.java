import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class SnakeGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Snake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.add(new GamePanel());
        frame.setVisible(true);
    }
}

class GamePanel extends JPanel {
    private static final int GRID_SIZE = 20;
    private static final int CELL_SIZE = 30;
    private List<int[]> snake;

    public GamePanel() {
        setBackground(new Color(50, 50, 50)); // Dark gray
        initializeSnake();
    }

    private void initializeSnake() {
        snake = new ArrayList<>();
        // Start with 3 segments near the center, facing right
        // Head at (10, 10), body segments behind it
        snake.add(new int[]{10, 10}); // Head
        snake.add(new int[]{9, 10});  // Body
        snake.add(new int[]{8, 10});  // Tail
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        // Draw grid
        drawGrid(g2d);
        
        // Draw snake
        drawSnake(g2d);
    }

    private void drawGrid(Graphics2D g) {
        g.setColor(new Color(100, 100, 100)); // Lighter gray for grid lines
        for (int i = 0; i <= GRID_SIZE; i++) {
            // Vertical lines
            g.drawLine(i * CELL_SIZE, 0, i * CELL_SIZE, GRID_SIZE * CELL_SIZE);
            // Horizontal lines
            g.drawLine(0, i * CELL_SIZE, GRID_SIZE * CELL_SIZE, i * CELL_SIZE);
        }
    }

    private void drawSnake(Graphics2D g) {
        g.setColor(Color.GREEN);
        for (int[] segment : snake) {
            int x = segment[0] * CELL_SIZE;
            int y = segment[1] * CELL_SIZE;
            g.fillRect(x, y, CELL_SIZE, CELL_SIZE);
        }
    }
}