public class SiebDesEratosthenes {

    public static void main(String[] args) {

        int[] test = SiebDesEratosthenes(10000000);

        for(int i = 0; i < test.length; i++){

            System.out.print("." + test[i]);
        }

    }

    public static int [] SiebDesEratosthenes(int limit) {

        int [] primzahlen;
        int [] zahlen = new int[limit-1];

        int counter = 1;

        for(int i = 2; i <= limit; i++){

            zahlen[counter++ -1] = i;
        }

        counter = 2;

        while(zahlen[counter-2] * zahlen [counter -2] <= limit){

            int i = 2;

            while(counter * i <= limit){

                zahlen[counter*i -2] = 0;
                i++;
            }

            counter++;
        }

        int counter2 = 1;

        for (int i = 0; i < limit-1; i++) {

            if(zahlen[i] != 0){

                counter2++;
            }
        }

        System.out.println(counter2);

        primzahlen = new int[counter2];
        primzahlen[0] = 1;
        counter = 0;

        for(int i = 1; i < primzahlen.length; i++){

            while(zahlen[counter] == 0){

                counter++;
            }

            primzahlen[i] = zahlen [counter];
            counter++;
        }



        return primzahlen;
    }
}
