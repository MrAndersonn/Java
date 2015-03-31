package Shachki;

/**
 * Created by Neo on 19.01.2015.
 */
public class Field
{
    static int[][] matrix = new int[9][9];


    public int[][] getStart()
    {
        for (int i = 0; i < BleakCheas.getMatrix().length; i++)
        {
            for (int j = 0; j < BleakCheas.getMatrix()[i].length; j++)
            {
                if (BleakCheas.getMatrix()[i][j] != 0)
                {
                    matrix[i + 1][j + 1] = BleakCheas.getMatrix()[i][j];
                    // System.out.println(BleakCheas.getMatrix().length);
                }
            }
        }

        for (int i = 0; i < WhiteChes.getMatrix().length; i++)
        {
            for (int j = 0; j < WhiteChes.getMatrix()[i].length; j++)
            {
                if (WhiteChes.getMatrix()[i][j] != 0)
                {
                    matrix[i + 1][j + 1] = WhiteChes.getMatrix()[i][j];
                }
            }
        }

        return matrix;
    }

    public void print()
    {

        for (int i = 0; i < matrix.length; i++)
        {
            for (int j = 0; j < matrix[i].length; j++)
            {
                if (i == 0)
                {
                    matrix[i][j] = j;
                } else
                    matrix[i][0] = i;
            }
        }

        for (int i = 0; i < matrix.length; i++)
        {
            System.out.print("   ");
            for (int j = 0; j < matrix[i].length; j++)
            {

                if (i != 0 && j != 0)
                {
                    if (matrix[i][j] == 1)
                        System.out.print(" ■ ");
                    else if (matrix[i][j]==2){
                        System.out.print(" ✹ ");

                    }
                    else if (matrix[i][j] == 0)
                        System.out.print(" □ ");
                } else
                    System.out.printf(" №%d", matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean isMove(int x, int y)
    {
        if (x < 1||x> 9) return false;
        else if (y >9||y < 1) return false;
        else return true;

    }
    //  System.out.println(matrix.toString());


}




