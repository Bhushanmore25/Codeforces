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

    // public static void solve(Scanner sc, ArrayList<List<Integer>> ans) {
    public static void solve(Scanner sc, ArrayList<String> ans) {
        int n=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++) nums[i]=sc.nextInt();

        int i = 0, j = n - 1;

        while (i < j && nums[i] == nums[j]) {
            i++;
            j--;
        }

        // already palindrome
        if (i >= j) {
            ans.add("Yes");
            return;
        }

        Set<Integer> set=new HashSet<>();
        set.add(nums[i]);
        if(i+1<n) set.add(nums[i+1]);
        set.add(nums[j]);
        if(j-1>=0) set.add(nums[j-1]);
        if(check(set, nums)) ans.add("Yes");
        else ans.add("No");
    }
    public static boolean check(Set<Integer> set,int[] nums)
    {
        int n=nums.length;
        boolean ans=false;
        for(int x:set)
        {
            int i=0,j=n-1;
            boolean temp = true;

            while (i <= j) {
                while (i <= j && nums[i] == x)
                    i++;
                while (i <= j && nums[j] == x)
                    j--;

                if (i <= j && nums[i] != nums[j]) {
                    temp = false;
                    break;
                }
                i++;
                j--;
            }

            if (temp)
                return true;
        }
        return ans;
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
            System.out.print(i+" ");
        }
        // for (int i = 0; i < ans.size()-1; i+=2) {
        // System.out.println(ans.get(i)+" "+ans.get(i+1));
        // }
    }
}
