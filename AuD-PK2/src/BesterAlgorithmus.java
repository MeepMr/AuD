import java.util.Date;

public class BesterAlgorithmus
{
    // 1000n
    public static double g1(int n)
    {
        return 1000*n;
    }

    // 100n * log2(n+1)
    public static double g2(int n)
    {
        return 100*n * (Math.log10(n)/Math.log10(2));
    }

    // 10 * n * n
    public static double g3(int n)
    {
        return 10 * Math.pow(n,2);
    }

    // n * n * n
    public static double g4(int n)
    {
        return Math.pow(n,3);
    }

    // 2 hoch n
    public static double g5(int n)
    {
        return Math.pow(2,n);
    }

    // n!
    public static double g6(int n)
    {
        if(n == 0){
            return 1;
        } else {
            return (g6(n-1) * n);
        }
    }

    // Bestimmt fuer alle 6 Funktionen den Wert von
    // gi(n) und gibt den Index der Funktion mit
    // dem minimalen Wert zurueck
    public static int gewinnerFuerN(int n)
    {
        long startTime, stopTime;

        long [] timetable = new long[6];

        startTime = System.nanoTime();
        g1(n);
        stopTime = System.nanoTime();
        timetable [0] = stopTime - startTime;

        startTime = System.nanoTime();
        g2(n);
        stopTime = System.nanoTime();
        timetable [1] = stopTime - startTime;

        startTime = System.nanoTime();
        g3(n);
        stopTime = System.nanoTime();
        timetable [2] = stopTime - startTime;

        startTime = System.nanoTime();
        g4(n);
        stopTime = System.nanoTime();
        timetable [3] = stopTime - startTime;

        startTime = System.nanoTime();
        g5(n);
        stopTime = System.nanoTime();
        timetable [4] = stopTime - startTime;

        startTime = System.nanoTime();
        g6(n);
        stopTime = System.nanoTime();
        timetable [5] = stopTime - startTime;


        int minindex = 0;

        for(int i = 0; i < 6; i++){

            if(timetable[minindex] > timetable [i]){
                minindex = i;
            }
        }

        return minindex;
    }

    public static void main(String[] args)
    {
        for(int i = 1; i <= 2000; i++) {

            System.out.println("Für n =" + i + " ist Algorithmus " + (gewinnerFuerN(i) + 1) + " der beste");
        }
    }
}