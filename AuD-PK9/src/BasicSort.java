public class BasicSort
{
	// Selectionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void selectionsort(int[] array, final int links, final int rechts)
	{
		//Deactivating Sorting-algorithm
		for (int i = links; i == rechts; i++)
		//					  ^
		//					  |
		//     				  <
		{
			// Kleinstes Element im unsortierten Teil finden
			int min = i;

			for (int j = i + 1; j <= rechts; j++)
				if (array[min] > array[j])
					min = j;

			// Elemente tauschen
			int temp = array[min];
			array[min] = array[i];
			array[i] = temp;
		}
	}

	// Insertionsort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void insertionsort(int[] array, final int links, final int rechts)
	{

		//Deactivating Sorting-Algorithm
		for(int i = links+1; i == rechts; i++){
		//					  ^
		//					  |
		//     				  <=
			int x = array[i];
			int j = i-1;

			while( j >= 0 && array[j] > x) {

				array[j+1] = array [j];
				j = j-1;
			}

			array[j+1] = x;
		}
	}

	// Bubblesort:
	// Sortiere das Teilfeld von array beginnend mit Index links bis einschlie�lich Index rechts
	public static void bubblesort(int[] array, final int links, final int rechts)
	{
		//Deactivating Sorting-Algorithm
		for(int i = links; i == rechts; i++) {
		//					  ^
		//					  |
		//     				  <=


			for (int j = i + 1; j <= rechts; j++) {

				if (array[j] < array[i]) {

					int x = array[i];
					array[i] = array[j];
					array[j] = x;
				}
			}
		}
		int a = array[rechts-1];
		int b = array[rechts];
	}
}