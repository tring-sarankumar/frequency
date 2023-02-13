package assignment.frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Files
{
    public static void main(String[] args)throws FileNotFoundException
    {
        Logger l = Logger.getLogger("Files");
        StringBuilder str = new StringBuilder();
        try
        {
            String s = "C:\\Users\\Tringapps-user15\\Documents\\file.txt";
            File file = new File(s);
            Scanner inp = new Scanner(file);
            while(inp.hasNextLine())
            {
                str.append(inp.nextLine());
                str.append(" ");
            }
        }
        catch(Exception e)
        {
            String s = ""+e;
            l.info(s);
        }
        String[] str1 = str.toString().split(" ");
        HashMap<String ,Integer> hash= new HashMap<>();

        for(int i=0;i< str1.length;i++)
        {
            if(hash.containsKey(str1[i]))
            {
                hash.put(str1[i],hash.get(str1[i])+1);
            }
            else
            {
                hash.put(str1[i],1);
            }
        }
        l.log(Level.INFO, ()->("Frequncy "+hash));
        l.log(Level.INFO, ()->("Size "+str1.length));

        PriorityQueue<Map.Entry<String, Integer>> q = new PriorityQueue<>((a, b) -> {
            return b.getValue() - a.getValue();
        });

        q.addAll(hash.entrySet());

        while (!q.isEmpty()) {
            l.log(Level.INFO,() ->"\n" + q.poll());
        }


    }
}
