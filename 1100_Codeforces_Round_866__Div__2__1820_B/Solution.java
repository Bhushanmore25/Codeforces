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
            String s = sc.next();
            int n = s.length();

            String t = s + s;

            int maxLen = 0, curr = 0;

            for (int i = 0; i < t.length(); i++) {
                if (t.charAt(i) == '1') {
                    curr++;
                    maxLen = Math.max(maxLen, curr);
                } else {
                    curr = 0;
                }
            }

            maxLen = Math.min(maxLen, n);

            if (maxLen == 0) {
                ans.add("0");
                return;
            }

            if (maxLen == n) {
                ans.add(Long.toString((long) n * n));
                return;
            }

            long L = maxLen;

            long res = ((L + 1) / 2) * ((L + 2) / 2);

            ans.add(Long.toString(res));
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
