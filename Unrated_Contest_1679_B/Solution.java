import java.util.*;
public class Temp {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        int[][] a=new int[n][2];
        long sum=0l;
        for (int i = 0; i < n; i++) {
            a[i][0]=sc.nextInt();
            a[i][1]=-1;
            sum+=a[i][0];
        }
        int lastGlobal=-1,lastGlobalValue=0;
        StringBuilder result=new StringBuilder();
        for(int z=0;z<q;z++)
        {
            long val=0l;
            int t=sc.nextInt();
            if(t==1)
            {
                int i=sc.nextInt();
                int x=sc.nextInt();
                if(a[i-1][1]<lastGlobal)
                    val=sum-lastGlobalValue+x;
                
                else
                    val=sum-a[i-1][0]+x;
                sum=val;
                a[i-1][0]=x;
                a[i-1][1]=z;
            }
            else{
                int x=sc.nextInt();
                lastGlobal=z;
                lastGlobalValue=x;
                sum=(long)n*x;
                val=sum;
            }
            result.append(val+" ");
        }
        System.out.println(result.toString());
    }
}
