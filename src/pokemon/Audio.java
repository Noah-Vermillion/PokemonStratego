package pokemon;
import java.io.IOException;

public class Audio {
    static Sound openingSong = null;
    static Sound ouchSound = null;

    public static void main(String[] args) {
        boolean keepLooping = true;
        while (keepLooping)
        {
            System.out.println("enter s for starwars");
            System.out.println("      o for ouch");
            System.out.println("      b for break out of starwars");
            System.out.println("      e exit program");
            String str = read();
            
            if (str.charAt(0) == 's')
            {
                if (openingSong != null)
                    openingSong.stopPlaying = true;
                openingSong = new Sound("pokemonRBYTheme.wav"); 
            }   
            if (str.charAt(0) == 'o')
            {
                if (openingSong != null)
                    openingSong.stopPlaying = true;
                openingSong = new Sound("ouch.wav"); 
            }   
            else if (str.charAt(0) == 'b')
            {
                if (openingSong != null)
                    openingSong.stopPlaying = true;
            }
            else if (str.charAt(0) == 'e')
            {
                if (openingSong != null)
                    openingSong.stopPlaying = true;
                if (openingSong != null)
                    openingSong.stopPlaying = true;
                keepLooping = false;
            }            
            
        }
    }
///////////////////////////////////////////////////
    public static String read()
    {
        byte [] buffer = new byte[10];
        try
        {
            int numBytes = System.in.read(buffer);
        }
        catch(IOException e)
        {
            System.out.print("Error: " + e);
            System.exit(1);
        }
        String str = new String(buffer);
        int ball = 5;
        return (str);
    }

    public static void write(String str)
    {
        System.out.print(str);
    }    
}
