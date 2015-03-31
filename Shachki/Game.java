package Shachki;


import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Neo on 19.01.2015.
 */
public class Game
{

    public Game(){
    Field field = new Field();
        field.getStart();
        field.print();
    }

    public static void main(String[] args)  throws  Exception
    {
        Game game = new Game();
        boolean isGaming = false;
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        int xod=0;
        Field field = new Field();
        while (!isGaming)
        {
            String move =reader.readLine();
            while (!move.equals(""))
            {
                //  move =reader.readLine();
                if (move.equals("q")&&xod%2==0)
                {
                    xod++;
                    WhiteChes.whiteChes.left(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()));
                }else if (move.equals("e")&&xod%2==0){
                    xod++;
                    WhiteChes.whiteChes.right(Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()));
                }else if (move.equals("q")&&xod%2!=0){
                    BleakCheas.bleakCheas.left(Integer.parseInt(reader.readLine()),Integer.parseInt(reader.readLine()));
                    xod++;
                }else if (move.equals("e")&&xod%2!=0)
                {
                    BleakCheas.bleakCheas.right(Integer.parseInt(reader.readLine()), Integer.parseInt(reader.readLine()));
                    xod++;
                }else System.out.println("Try again");
                field.print();

                move =reader.readLine();
            }
        }
    }
}
