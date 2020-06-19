public class QuickSort
{

	public static void quicksort(int[] array, final int links, final int rechts) {

		int pivotindex = ((rechts - links) / 2) + links;
		int pivot = array[pivotindex];
		int l = links;
		int r = rechts;

		do {

			while (array[l] < pivot) {
				l++;
			}
			while (array[r] > pivot) {
				r--;
			}

			if (l <= r) {

				int x = array[l];
				array[l] = array[r];
				array[r] = x;

				l++;
				r--;
			}

		} while (l <= r);
		if (links < r) quicksort(array, links, r);
		if (rechts > l) quicksort(array, l, rechts);
	}
}