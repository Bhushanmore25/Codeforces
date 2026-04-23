// Bhushan More

import java.util.*;
//2 3
//1 2
import java.util.function.IntToDoubleFunction;

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

    private static long lcm(long a, long b) {
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
        int n=sc.nextInt();
        int[] a=new int[n];
        TreeMap<Integer,Integer> map=new TreeMap<>(); 
        for(int i=0;i<n;i++)
        {
            a[i]=sc.nextInt();
            map.put(a[i],map.getOrDefault(a[i], 0)+1);
        }
        List<int[]> li=new ArrayList<>();
        for (Map.Entry<Integer, Integer> e :map.entrySet())
            li.add(new int[]{e.getKey(),e.getValue()});
        int result=li.get(0)[1];
        for(int i=1;i<li.size();i++)
        {
            if(li.get(i)[0]==li.get(i-1)[0]+1)
            {
                if(li.get(i-1)[1]<li.get(i)[1]) result+=li.get(i)[1]-li.get(i-1)[1];
            }
            else{
                result+=li.get(i)[1];
            }
        }
        ans.add(Integer.toString(result));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine();
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
        // // System.out.println("___________________");
        // for (Integer i : s) {
        // System.out.print(i+" ");
        // }
        // System.out.println();
        // }
        for (String i : ans) {
            System.out.println(i + " ");
        }
        // for (int i = 0; i < ans.size()-1; i+=2) {
        // System.out.println(ans.get(i)+" "+ans.get(i+1));
        // }
    }
}
