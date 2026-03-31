// Bhushan More

import java.util.*;
public class ProblemB {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
    public static void solve(Scanner sc, ArrayList<Integer> ans) {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int l=0,r=n-1;
        int resultLeft=-1,resultRight=-1;
        long leftSum=0l,rightSum=0l;
        while (l<=r) {
            
            if (leftSum <= rightSum) {
                leftSum += arr[l++];
            } else {
                rightSum += arr[r--];
            }
            if (leftSum == rightSum && leftSum!=0) {
                resultLeft = l;
                resultRight = r;
            }
        }
        // System.out.println(resultLeft+" "+ (resultRight));
        // System.out.println((n - resultLeft)+" " + (resultRight + 1));
        if(resultLeft==-1) ans.add(0);
        else ans.add(n - resultRight + resultLeft - 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        ArrayList<Integer> ans= new ArrayList<>();
        
        while (t-->0) {
            solve(scanner,ans);
        }
        print(ans);
        scanner.close();
    }
    public static void print(ArrayList<Integer> ans) {
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + " ");
        }
        System.out.println();
    }

}