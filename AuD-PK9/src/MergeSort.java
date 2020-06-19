import javax.print.DocFlavor;

public class MergeSort
{
	public static void mergesort(int[] array, final int links, final int rechts)
	{
		int[] hilfsarray = new int[array.length];
		
		mergesortBU(array, hilfsarray, links, rechts);
	}
	
	// Top-Down-Mergesort entsprechend der Vorlesung
	public static void mergesortTD(int[] array, int[] hilfsarray, final int links, final int rechts)
	{
		if (links < rechts)
		{
			// mindestens 2 Elemente
			int mitte = (links + rechts)/2;
			// Feld in der Mitte teilen und rekursive Aufrufe für Teilfelder
			mergesortTD(array, hilfsarray, links, mitte);
			mergesortTD(array, hilfsarray, mitte+1, rechts);
			// Sortierte Teilfelder mischen
			merge(array, hilfsarray, links, mitte, rechts);
		}
	}

	// Bottom-Up-Mergesort
	public static void mergesortBU(int[] array, int[] hilfsarray, final int links, final int rechts)
	{
		int step = 1;

		while (links+step <= rechts)  {

			int i = links;
			while (i+step <= rechts) {

				int r = Integer.min(i+2*step-1, rechts);
				merge(array, hilfsarray, i, i+step-1, r);

				i += 2*step;
			}

			step *= 2;
		}


/*		int step = 2;
		int i = links;

		while (step < rechts) {


			for(i = step; i <= rechts; i += step) {

				merge(array, hilfsarray, i-step, (i-1+i-step)/2 , i-1);
			}

			merge(array,hilfsarray,i-step,(rechts+i-step)/2,rechts);
			step *= 2;
		}

		step /= 2;
		merge(array,hilfsarray,links,step-1,rechts);

		System.out.print("Gey");*/
	}


	// Mischen der Teilfelder array[links]...array[mitte] und array[mitte+1]...array[rechts]
	private static void merge(int[] array, int[] hilfsarray, final int links, final int mitte, final int rechts)
	{
		int i, j;

		i = links; 
		j = mitte+1;
		
		// Mischen in Hilfsarray
		for (int k=links; k <= rechts; k++)
		{
			if (i>mitte)  
				hilfsarray[k] = array[j++]; // 1. Teilfeld schon zu Ende			
			else if (j>rechts)
				hilfsarray[k] = array[i++]; // 2. Zeilfeld schon zu Ende
			else if(array[i] < array[j])
				hilfsarray[k] = array[i++]; // Element aus 1. Teilfeld übernehmen
			else
				hilfsarray[k] = array[j++];	// Element aus 2. teilfeld übernehmen						
		}

		
		for (int k = links; k <= rechts; k++)
		{
			array[k] = hilfsarray[k];
		}
	}

	// Alternative Metdode zum Mischen
	private static void merge2(int[] array, int[] hilfsarray, final int links, final int mitte, final int rechts)
	{
		int i, j;

		// 1. Teilfeld kopieren
		for (i = mitte+1; i > links; i--)
			hilfsarray[i-1] = array[i-1];
		// 2. Teilfeld in umgekehrter Reihenfolge kopieren
		for (j = mitte; j < rechts; j++)
			hilfsarray[rechts+mitte-j] = array[j+1];
		
		// Zeiger i und j gegeneinander laufen lassen
		for (int k = links; k <= rechts; k++ )
			if (hilfsarray[j] < hilfsarray[i])
				array[k] = hilfsarray[j--];
			else
				array[k] = hilfsarray[i++];				
	}
}
