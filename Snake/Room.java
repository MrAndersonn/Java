package Snake;



import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;




public class Room extends JPanel
{
    private int width;
    private int height;
    private Snake snake;
    private Mouse mouse;
    public Room(int width, int height, Snake snake)
    {
        this.width = width;
        this.height = height;
        this.snake = snake;
        JFrame frame = new JFrame("SNAKE");
        frame.setLocation(750, 150);
        frame.setMinimumSize(new Dimension(600, 400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);
    }
    public Snake getSnake()
    {
        return snake;
    }
    public Mouse getMouse()
    {
        return mouse;
    }
    public int getWidth()
    {
        return width;
    }
    public int getHeight()
    {
        return height;
    }
    public void setWidth(int width)
    {
        this.width = width;
    }
    public void setHeight(int height)
    {
        this.height = height;
    }
    public void setSnake(Snake snake)
    {
        this.snake = snake;
    }
    public void setMouse(Mouse mouse)
    {
        this.mouse = mouse;
    }

    public void run()
    {
        KeyboardObserver keyboardObserver = new KeyboardObserver();
        keyboardObserver.start();
        while (snake.isAlive())
        {
           if (keyboardObserver.hasKeyEvents())
            {
                KeyEvent event = keyboardObserver.getEventFromTop();
                if (event.getKeyChar() == 'q') return;
                 if (event.getKeyCode() == KeyEvent.VK_LEFT)
                    snake.setDirection(SnakeDirection.LEFT);
                 else if (event.getKeyCode() == KeyEvent.VK_RIGHT)
                    snake.setDirection(SnakeDirection.RIGHT);
                 else if (event.getKeyCode() == KeyEvent.VK_UP)
                    snake.setDirection(SnakeDirection.UP);
                   else if (event.getKeyCode() == KeyEvent.VK_DOWN)
                    snake.setDirection(SnakeDirection.DOWN);
            }
            game.getSnake().move();
            game.repaint();
            sleep();
        }
        //Выводим сообщение "Game Over"
        System.out.println("Game Over!");
    }

    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);
        int[][] matrix = new int[height][width];
        ArrayList<SnakeSection> sections = new ArrayList<SnakeSection>(snake.getSections());
        for (SnakeSection snakeSection : sections)
        {
            matrix[snakeSection.getY()][snakeSection.getX()] = 1;
        }
         matrix[snake.getSections().get(0).getY()][snake.getSections().get(0).getX()] = snake.isAlive() ? 2 : 4;
         matrix[mouse.getY()][mouse.getX()] = 3;
         String[] symbols = {" . ", " x ", " X ", "^_^", "RIP"};
        for (int y = 0; y < height; y++)
        {
            for (int x = 0; x < width; x++)
            {
                    if (matrix[y][x]==2)
                    {
                        g.setColor(Color.black);
                        g.fillRect(x, y, 10, 10);
                    }
                    if (matrix[y][x]==1){
                        g.setColor(Color.GREEN);
                        g.fillRect(x+10,y+10,10,10);
                    }else if (matrix[y][x]==3){
                        g.setColor(Color.RED);
                        g.fillRect(x,y,10,10);
                    }



            }
            //super.paintComponent(g);
            //System.out.println();
        }

        //        System.out.println();
//        System.out.println();
//        System.out.println();
    }

    public void eatMouse()
    {
        createMouse();
    }

    public void createMouse()
    {
        int x = (int) (Math.random() * width);
        int y = (int) (Math.random() * height);
        mouse = new Mouse(x, y);
    }
    public static Room game;
    public static void main(String[] args)
    {
        Snake snake1 = new Snake(10 ,10);
        game = new Room(600, 400, snake1);
        game.getSnake().setDirection(SnakeDirection.DOWN);
        game.createMouse();
        game.run();
        game.repaint();
    }
   public static int[] levelDelay = {1000, 600, 550, 500, 480, 460, 440, 420, 400, 380, 360, 340, 320, 300, 285, 270};

    public void sleep()
    {
        try
        {
            int level = snake.getSections().size();
            int delay = level < 15 ? levelDelay[level] : 250;
            Thread.sleep(delay);
        }
        catch (InterruptedException e)
        {
        }
    }
}