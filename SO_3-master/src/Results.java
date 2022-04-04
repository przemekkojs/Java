import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Magdalena Polak on 18.04.2016.
 */
public class Results
{
    public static void main (String[]args)
    {
        ArrayList frames = new ArrayList<>();
        Scanner reader = new Scanner(System.in);
        System.out.println("How many page references do you want? ");
        int k = reader.nextInt();
        System.out.println("And from what interval? ");
        int d = reader.nextInt();
        System.out.println("How many sizes of frames do you want? ");
        int n = reader.nextInt();
        for(int  i = 0; i < n; i++)
        {
            int b = i + 1;
            System.out.println("Size of frame "+ b + ":");
            int p  = reader.nextInt();
            frames.add(p);
        }
        Result r = new Result(k, d, frames);

    }

}
