import java.util.*;

public class BroadCast {

   static HashMap <Character,ArrayList<Character>> adjs =new HashMap<>();

   public static void BFS(char source)
   {
       HashMap <Character,Boolean> visited = new HashMap<>();
       for(char key:adjs.keySet())
           visited.put(key,false);

       Queue <Character> queue = new LinkedList<>();
       queue.add(source);
       visited.put(source,true);

       while(!queue.isEmpty())
       {
           char temp = queue.poll();
           System.out.print(temp+" ");
           for(char v:adjs.get(temp))
           {
               if(!visited.get(v))
               {
                   queue.add(v);
                   visited.put(v,true);
               }
           }
       }
   }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String area = sc.nextLine();

        String paths []= sc.nextLine().split(" ");

        char start= sc.nextLine().charAt(0);

        for(String s:paths)
        {
            if(!adjs.containsKey(s.charAt(0)))
                adjs.put(s.charAt(0),new ArrayList<Character>());
            adjs.get(s.charAt(0)).add(s.charAt(2));

            if(!adjs.containsKey(s.charAt(2)))
                adjs.put(s.charAt(2),new ArrayList<Character>());
            adjs.get(s.charAt(2)).add(s.charAt(0));
        }

       // System.out.println(adjs);

        BFS(start);
    }
}
