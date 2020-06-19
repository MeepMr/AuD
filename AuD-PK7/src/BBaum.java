class BBaum<T extends Comparable<T>>
{
	public BKnoten<T> wurzel;

	public BBaum(BKnoten<T> wurzel)
	{
		assert(wurzel != null);

		this.wurzel = wurzel;
	}

	// Wrapper-Methode
	public void traversieren()
	{
		traversieren(wurzel);
	}

	// Eigentliche Implementierung
	private void traversieren(BKnoten<T> knoten)
	{
		if(knoten == null){

			return;
		}

		if(knoten.elemente.length > knoten.kinder.length) {

			int i;

			for(i = 0; i < knoten.kinder.length; i++) {

				traversieren(knoten.kinder[i]);
				System.out.print(knoten.elemente[i]+",");
			}

			System.out.print(knoten.elemente[i]+",");
		} else {

			int i;

			for(i = 0; i < knoten.elemente.length; i++) {

				traversieren(knoten.kinder[i]);
				System.out.print(knoten.elemente[i]+",");
			}

			traversieren(knoten.kinder[i]);
		}
	}

	// Wrapper-Methode
	public boolean suchen(final T daten)
	{
		assert(daten != null);

		return suchen(daten, wurzel);
	}

	// Eigentliche Implementierung
	private boolean suchen(final T daten, BKnoten<T> knoten)
	{

		int i = 0;
		for(T x:knoten.elemente) {

			if(daten.compareTo(x) == 0) {

				return true;
			} else {

				if(daten.compareTo(x) < 0) {

					if(knoten.kinder[i] != null)
					return suchen(daten,knoten.kinder[i]);
					else return false;
				}
			}

			i++;
		}

		if(knoten.kinder.length > knoten.elemente.length){

			if(knoten.kinder[i] != null)
			return suchen(daten,knoten.kinder[i]);
			else return false;
		}

		return false;
	}
}