public class Fibonacci {

    public static void main(String[] args) {

        StopUhr st = new StopUhr();

        int x = 50;

        st.start();
        System.out.print(fibRec(x));
        st.stop();
        System.out.println(" Rekursiv benötigt " + (st.getDuration()/(Math.pow(10,9))) + " Sekunden");
        st.start();
        System.out.print(fibIt(x));
        st.stop();
        System.out.println(" Iterativ benötigt " + (st.getDuration()/(Math.pow(10,9))) + " Sekunden");
    }

    public static int fibRec(int n){

        if(n == 0) return 0;
        else if(n == 1) return 1;
        else return fibRec(n-1) + fibRec(n-2);
    }

    public static int fibIt(int n) {

        int fib;
        int fib1 = 1;
        int fib2;

        if(n == 1) return 1;
        else{

            fib = 1;

            while(n-2 > 0) {

                int x = fib;
                fib2 = fib1;
                fib1 = x;
                fib = fib2 + fib1;
                n--;
            }
        }

        return fib;
    }
}


