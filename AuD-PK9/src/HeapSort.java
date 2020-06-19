public class HeapSort
{
	// Versickere das Element mit Index pos in dem Teilfeld von Index links bis einschließlich Index rechts
	public static void versickere(int[] array, final int links, int pos, final int rechts)
	{
		// Im Gegensatz zur Vorlesung benötigt diese Methode vier Parameter, da der zu sortierende Bereich
		// nicht bei 0, sondern bei links anfängt. Linkes Kind von Knoten x: (x-links)*2+links+1

		int iLKind = (pos-links)*2+links+1;
		int iRKind = (pos-links)*2+links+2;
		boolean bCheck = true;

		do {
			if (iLKind <= rechts) { // hat linkes Kind

				if (iRKind <= rechts) { // hat rechtes Kind

					if ((array[iLKind] > array[iRKind]) && (array[iLKind] > array[pos])) {

						swap(array, iLKind, pos);
//						versickere(array, links, iLKind, rechts);
						pos = iLKind;
					} else if ((array[iRKind] > array[iLKind]) && (array[iRKind] > array[pos])) {

						swap(array, iRKind, pos);
//						versickere(array, links, iRKind, rechts);
						pos = iRKind;
					} else if ((array[iLKind] == array[iRKind]) && (array[iLKind]) > array[pos]) {

						swap(array, iRKind, pos);
//						versickere(array, links, iRKind, rechts);
						pos = iRKind;
					} else {

						bCheck = false;
					}

					iLKind = (pos-links)*2+links+1;
					iRKind = (pos-links)*2+links+2;
				} else {

					if (array[iLKind] > array[pos]) {
						swap(array, iLKind, pos);
//						versickere(array, links, iLKind, rechts);
						pos = iLKind;
						iLKind = (pos-links)*2+links+1;
						iRKind = (pos-links)*2+links+2;
					} else {

						bCheck = false;
					}
				}
			} else {

				bCheck = false;
			}
		} while (bCheck);
	}

	public static void heapsort(int[] array, final int links, final int rechts)
	{
		int iLPointer;
		int iRPointer = rechts;

		for (iLPointer = (links+rechts) / 2; iLPointer >= 0; iLPointer--){

			versickere(array, links, iLPointer, rechts);
		}

		while (iRPointer > links) {

			swap(array, 0, iRPointer);
			iRPointer--;
			versickere(array, links,links,iRPointer);
		}

//		System.out.print(array[array.length -1] + "Hey" + array[array.length -2]);
	}

	private static void swap(int [] iaArray, int iPos1, int iPos2) {

		int x = iaArray [iPos1];
		iaArray [iPos1] = iaArray[iPos2];
		iaArray[iPos2] = x;
	}
}