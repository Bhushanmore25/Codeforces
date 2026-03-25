    // Bhushan More

    import java.util.*;
    //2 3
    //1 2

    public class Main {

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

        private static int lcm(int a, int b) {
            return (a / gcd(a, b)) * b;
        }
        public static int digit_Sum(long digit)
        {
            int val=0;
            while (digit!=0) {
                val+=digit%10;
                digit/=10;
            }
            return val;
        }
        static int xorUpto(int n) {
            if (n % 4 == 0) return n;
            if (n % 4 == 1) return 1;
            if (n % 4 == 2) return n + 1;   
            return 0;
        }
        public static List<Integer> List_digit(long n)
        {
            List<Integer> li=new ArrayList<>();
            while (n!=0) {
                li.add((int)n%10);
                n/=10;
            }
            return li;
        }
        
        static long MOD = 1_000_000_007;
        // public static void solve(Scanner sc, ArrayList<List<Integer>> ans) {
        public static void solve(Scanner sc, ArrayList<String> ans) {
            int n=sc.nextInt(); 
            int[] a=new int[n];
            for (int i = 0; i < a.length; i++) {
                a[i]=sc.nextInt();
            }
            int[] b=new int[n];
            for (int i = 0; i < b.length; i++) {
                b[i]=sc.nextInt();
            }
            int start=-1,end=-1;
            for (int i = 0; i < n; i++) {
                if(a[i]!=b[i] && start==-1) start=i;
                else if(a[i]!=b[i]) end=i;
            }
            int localMax=Integer.MIN_VALUE;
            int localMin=Integer.MAX_VALUE;
            for (int i = start; i <= end; i++) {
                localMax=Math.max(localMax, b[i]);
                localMin=Math.min(localMin, b[i]);
            }
            while (start>0 && b[start-1]<=localMin) {
                start--;
                localMin=Math.min(localMin,b[start]);
            }
            while (end<n-1 && b[end+1]>=localMax) {
                end++;
                localMax=Math.max(localMax, b[end]);
            }
            ans.add((start+1)+" "+(end+1));
        }
        

        public static boolean check(int[] a, long h, long x) {

            long water = 0;

            for (int val : a) {

                if (h > val) {
                    water += (h - val);
                }

                if (water > x)
                    return false;
            }

            return water <= x;
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
            //         // System.out.println("___________________");
            //     for (Integer i : s) {
            //         System.out.print(i+" ");
            //     }
            //     System.out.println();
            // }
            for (String i : ans) {
                System.out.println(i);
            }
            // for (int i = 0; i < ans.size()-1; i+=2) {
            //     System.out.println(ans.get(i)+" "+ans.get(i+1));
            // }
        }
    }
