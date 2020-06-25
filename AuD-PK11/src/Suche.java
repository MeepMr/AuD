import java.util.Arrays;

public class Suche {


    public static void main(String[] args) {

        String [] saString = {"standard","injury","decide","row","clue","descent","reporter","branch","pocket","artificial"};

        Arrays.sort(saString);
        String sSearch = "decide";

        System.out.println(binaereSuche(saString, sSearch));
    }

    static boolean binaereSuche(final String[] saWorte, final String sBegriff) {

        int middle = saWorte.length / 2;
        int left = 0, right = saWorte.length;

        while(middle > left && middle < right){
            //get Left or right direction

            int iComp = sBegriff.compareTo(saWorte[middle]);
            if(iComp == 0) return true;
            else if(iComp > 0) {

                left = middle;
                middle = (left+right)/2;
            }
            else {

                right = middle;
                middle = (left+right)/2;
            }
        }

        return saWorte[left].equals(sBegriff) || saWorte[right].equals(sBegriff);
    }
}
