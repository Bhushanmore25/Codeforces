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

    public static List<Integer> List_digit(long n) {
        List<Integer> li = new ArrayList<>();
        while (n != 0) {
            li.add((int) n % 10);
            n /= 10;
        }
        return li;
    }

    // public static void solve(Scanner sc, ArrayList<List<Integer>> ans) {
    public static void solve(Scanner sc, ArrayList<String> ans) {
        String s = sc.next();
        int n = s.length();

        Set<Character> set = new HashSet<>();
        boolean ok = true;

        int k = 0;

        // Find first repeating position
        for (k = 0; k < n; k++) {
            if (!set.contains(s.charAt(k))) {
                set.add(s.charAt(k));
            } else {
                break;
            }
        }

        // Check periodicity
        for (int i = k; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - k)) {
                ok = false;
                break;
            }
        }

        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
    public static boolean check(int[] freq)
    {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int i = 0; i < freq.length; i++) {
            if(freq[i]>0)
            {
                min=Math.min(min, freq[i]);
                max=Math.max(max, freq[i]);
            }
        }
        return max-min<=1;
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
        // // System.out.println("___________________");
        // for (Integer i : s) {
        // System.out.print(i+" ");
        // }
        // System.out.println();
        // }
        for (String i : ans) {
            System.out.println(i);
        }
        // for (int i = 0; i < ans.size()-1; i+=2) {
        // System.out.println(ans.get(i)+" "+ans.get(i+1));
        // }
    }
}