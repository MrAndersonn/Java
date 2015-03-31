package Shachki;



/**
 * Created by Neo on 19.01.2015.
 */
public class BleakCheas extends Thread
{
   static   boolean isMoved = false;
    int x ;
    int y;

   public static BleakCheas bleakCheas =new BleakCheas();

    private static int[][] matrix ;//= new int[8][8];


    public  void right(int y ,int x){

        this.y=x+1;
        this.x=y+1;

            if (Field.matrix[x][y]==2)
            {
                if (Field.isMove(x+2,y+2)&&WhiteChes.isWhitePosition(x+1,y+1)){
                Field.matrix[x+1][y+1]=0;
                Field.matrix[x][y]=0;
                Field.matrix[x+2][y+2]=2;
            }
            else if (Field.isMove(this.y, this.x)) {
                Field.matrix[x][y] = 0;
                Field.matrix[this.y][this.x] = 2;
            }
            }




    }
    public void left(int y,int x){
        this.y =x+1;
        this.x=y-1;

            if (Field.matrix[x][y]==2)
            {
                if (Field.isMove(x+2,y-2)&&WhiteChes.isWhitePosition(x+1,y-1)){
                Field.matrix[x+1][y-1]=0;
                Field.matrix[x][y]=0;
                Field.matrix[x+2][y-2]=2;
            }
            else if (Field.isMove(this.y, this.x)) {
                Field.matrix[x][y] = 0;
                Field.matrix[this.y][this.x] = 2;
            }

            }


        }



     int[][] getStartPosition()
    {
          matrix = new int[][]{
                {0, 2, 0, 2, 0, 2, 0, 2},
                {2, 0, 2, 0, 2, 0, 2, 0},
                {0, 2, 0, 2, 0, 2, 0, 2},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0}};
      return matrix;
    }

    public static int[][] getMatrix()
    {
    //    BleakCheas bleakCheas =new BleakCheas();

        return bleakCheas.getStartPosition();
    }
    public static boolean isBlackPosition(int x,int y){
        return Field.matrix[x][y]==2;
    }


    @Override
    public void run()
    {
        while (!isMoved){
        }

    }
}




