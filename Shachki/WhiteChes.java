package Shachki;

/**
 * Created by Neo on 19.01.2015.
 */
public class WhiteChes extends Thread
{
    private static int[][] matrix ;
    static boolean isMoved = false;
    int x;
    int y;
    public static   WhiteChes whiteChes =new WhiteChes();
    public  void right(int y ,int x){
        this.y=x-1;
        this.x=y+1;
        if (Field.matrix[x][y]==1)
        {
            if (Field.isMove(x - 2, y + 2) && BleakCheas.isBlackPosition(x - 1, y + 1))
            {
                Field.matrix[x - 1][y + 1] = 0;
                Field.matrix[x][y] = 0;
                Field.matrix[x - 2][y - 2] = 1;
            } else if (Field.isMove(this.y, this.x))
            {
                Field.matrix[x][y] = 0;
                Field.matrix[this.y][this.x] = 1;
            }
        }
    }
    public void left(int y,int x){
        this.y =x-1;
        this.x=y-1;
        if (Field.matrix[x][y]==1)
        {
            if (Field.isMove(x - 2, y - 2) && BleakCheas.isBlackPosition(x - 1, y - 1))
            {
                Field.matrix[x - 1][y - 1] = 0;
                Field.matrix[x][y] = 0;
                Field.matrix[x - 2][y - 2] = 1;
            } else if (Field.isMove(this.y, this.x))
            {
                Field.matrix[x][y] = 0;
                Field.matrix[this.y][this.x] = 1;
            }
        }

    }




    int[][] getStartPosition()
    {
        matrix = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1},
                {1, 0, 1, 0, 1, 0, 1, 0}};
        return matrix;
    }


    public static int[][] getMatrix()
    {
     //   WhiteChes whiteChes = new WhiteChes();


        return whiteChes.getStartPosition();
    }

    public static boolean isWhitePosition(int x,int y){
        return Field.matrix[x][y]==1;
    }

}
