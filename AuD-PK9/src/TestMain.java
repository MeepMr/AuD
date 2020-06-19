import java.io.RandomAccessFile;
import java.util.Random;

public class TestMain {

    public static void main(String[] args) {
        int[] test = new int[43];

        Random r = new Random();

        for( int i = 0; i < test.length; i++) {

            test[i] = r.nextInt(500);
        }

        MergeSort.mergesort(test,0,test.length -1);
    }
}
