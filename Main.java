import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int p=sc.nextInt();
        int k=sc.nextInt();
        int j=sc.nextInt();

        int monkey=0;
        while(k>0)
        {
            k-=m;
            monkey++;
        }
        while(j>0)
        {
            j-=p;
            monkey++;
        }
        System.out.println(n-monkey);
    }
}