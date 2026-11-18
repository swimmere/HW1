public class Assignment01Q03 {
    public static void main(String[] args) {
        int x = Integer.parseInt(args[0]); // TODO: Read the first string argument (replace this line)
        System.out.println("The first " + x + " Fibonacci numbers are:");

        int[] fib = new int[x];
        fib[0] = 1;
        int prev = 0;
        int curr = 1;

        for (int i = 1; i < x; i++) {
            fib[i] = prev + curr;
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        
        int numOdd = 0;
        for (int i = 0; i < x; i++) {
            if (fib[i] % 2 != 0) {
                numOdd++;
            }
            System.out.print(fib[i]);
            if (i < x - 1) {
                System.out.print(" ");
            }
        }
        System.out.println();
        
        ////////////////////////////////////////////////////////////////
        
        System.out.println("The number of odd numbers is: " + numOdd);
    }
}
