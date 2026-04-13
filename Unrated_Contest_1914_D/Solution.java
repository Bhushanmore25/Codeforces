// Bhushan More

import java.util.*;
//2 3
//1 2

public class Main {
    static int MOD = 1_000_000_007;
    static class Pair {
        long value;
        int index;

        Pair(long v, int i) {
            value = v;
            index = i;
        }
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    private static long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a / gcd(a, b)) * b;
    }

    public static int digit_Sum(long digit) {
        int val = 0;
        while (digit != 0) {
            val += digit % 10;
            digit /= 10;
        }
        return val;
    }

    static int xorUpto(int n) {
        if (n % 4 == 0)
            return n;
        if (n % 4 == 1)
            return 1;
        if (n % 4 == 2)
            return n + 1;
        return 0;
    }

    public static int countDistinctPrimeFactors(int n) {
        int count = 0;

        if (n % 2 == 0) {
            count++;
            while (n % 2 == 0)
                n /= 2;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                count++;
                while (n % i == 0)
                    n /= i;
            }
        }

        if (n > 1)
            count++;

        return count;
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }

        return true;
    }

    // public static void solve(Scanner sc, ArrayList<List<Integer>> ans) {
    public static void solve(Scanner sc, ArrayList<String> ans) {
        int n = sc.nextInt();
        int[] a=new int[n];
        for (int i = 0; i < a.length; i++) a[i]=sc.nextInt();
        int[] b=new int[n];
        for (int i = 0; i < a.length; i++) b[i]=sc.nextInt();
        int[] c=new int[n];
        for (int i = 0; i < a.length; i++) c[i]=sc.nextInt();
        
        int[][] maxa=new int[3][2];
        int[][] maxb=new int[3][2];
        int[][] maxc=new int[3][2];
        int k=0;
        for(int i=0;i<n;i++)
        {
            if(maxa[k][0]<a[i])
            {
                maxa[k][0]=a[i];
                maxa[k][1]=i;
            }
            if(maxb[k][0]<b[i])
            {
                maxb[k][0]=b[i];
                maxb[k][1]=i;
            }
            if(maxc[k][0]<c[i])
            {
                maxc[k][0]=c[i];
                maxc[k][1]=i;
            }
        }
        k++;
        for(int i=0;i<n;i++)
        {
            if(maxa[k][0]<a[i] && maxa[k-1][1]!=i)
            {
                maxa[k][0]=a[i];
                maxa[k][1]=i;
            }
            if(maxb[k][0]<b[i] && maxb[k - 1][1] != i)
            {
                maxb[k][0]=b[i];
                maxb[k][1]=i;
            }
            if(maxc[k][0]<c[i] && maxc[k - 1][1] != i)
            {
                maxc[k][0]=c[i];
                maxc[k][1]=i;
            }
        }
        k++;
        for(int i=0;i<n;i++)
        {
            if(maxa[k][0]<a[i] && maxa[k-1][1]!=i && maxa[k-2][1]!=i)
            {
                maxa[k][0]=a[i];
                maxa[k][1]=i;
            }
            if(maxb[k][0]<b[i] && maxb[k - 1][1] != i && maxb[k - 2][1] != i)
            {
                maxb[k][0]=b[i];
                maxb[k][1]=i;
            }
            if(maxc[k][0]<c[i] && maxc[k - 1][1] != i && maxc[k - 2][1] != i)
            {
                maxc[k][0]=c[i];
                maxc[k][1]=i;
            }
        }
        
        long total=0l;
        // if(maxa[0][1]!=maxb[0][1] && maxa[0][1]!=maxc[0][1] && maxb[0][1] !=maxc[0][1])
        // {
        //     total=maxa[0][0] + maxb[0][0]+ maxc[0][0];
        // }
        // else if(maxa[0][1]==maxb[0][1] && maxb[0][1]!=maxc[0][1]) //a==b
        // {
        //     int l=0,r=0;
        //     if(maxa[0][0]>=maxb[0][0])
        //     {
        //         l=maxa[0][0];
        //         r=maxb[1][0];
        //     }
        //     else{
        //         l=maxa[1][0];
        //         r=maxb[0][0];
        //     }
        //     total= l + r + maxc[0][0];
        // }
        // else if (maxa[0][1] == maxc[0][1] && maxb[0][1] != maxc[0][1]) // a==c
        // {
        //     int l = 0, r = 0;
        //     if (maxa[0][0] >= maxc[0][0]) {
        //         l = maxa[0][0];
        //         r = maxc[1][0];
        //     } else {
        //         l = maxa[1][0];
        //         r = maxc[0][0];
        //     }
        //     total = l + r + maxb[0][0];
        // }
        // else if (maxb[0][1] == maxc[0][1] && maxa[0][1] != maxc[0][1]) // b==c
        // {
        //     int l = 0, r = 0;
        //     if (maxb[0][0] >= maxc[0][0]) {
        //         l = maxb[0][0];
        //         r = maxc[1][0];
        //     } else {
        //         l = maxb[1][0];
        //         r = maxc[0][0];
        //     }
        //     total = l + r + maxa[0][0];
        // }else if(maxb[0][1] == maxc[0][1] && maxa[0][1] == maxc[0][1]){
            
        //     total=Math.max(maxa[0][0], Math.max(maxb[0][0], maxc[0][0])) + Math.max(maxa[1][0], Math.max(maxb[1][0], maxc[1][0])) + Math.max(maxa[2][0], Math.max(maxb[2][0], maxc[2][0]));
        // }
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                for(int x=0;x<3;x++)
                {
                    if(maxa[i][1]!=maxb[j][1] && maxa[i][1]!=maxc[x][1] && maxb[j][1]!=maxc[x][1])
                    {
                        total=Math.max(total, maxa[i][0]+maxb[j][0]+maxc[x][0]);
                    }
                }
            }
        }
        ans.add(Long.toString(total));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        // int t = 1;

        // ArrayList<List<Integer>> ans = new ArrayList<>();
        ArrayList<String> ans = new ArrayList<>();

        while (t-- > 0) {
            solve(scanner, ans);
        }

        print(ans);
        scanner.close();
    }

    // public static void print(ArrayList<List<Integer>> ans) {
    public static void print(ArrayList<String> ans) {
        // for (List<Integer> s : ans) {
        //     // System.out.println("___________________");
        //     for (Integer i : s) {
        //         System.out.print(i+" ");
        //     }
        //     System.out.println();
        // }
        for (String i : ans) {
            System.out.print(i+" ");
        }
        // for (int i = 0; i < ans.size()-1; i+=2) {
        // System.out.println(ans.get(i)+" "+ans.get(i+1));
        // }
    }
}
