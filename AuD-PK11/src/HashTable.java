import java.io.PrintStream;

public class HashTable
{
	private static final int START_TABELLENGROESSE = 10;	// Standardgröße

	private IHashable[] table;								// Array für Hash-Objekte
	private int currentSize;								// Die Anzahl der belegten Slots

	public HashTable()
	{
		this(START_TABELLENGROESSE);
	}

	// Konstruktor mit expliziter Größenangabe
	public HashTable(final int groesse)
	{
		assert(groesse > 0);

		table = new IHashable[groesse];
		clear();
	}

	// Fügt ein Objekt in die Hashtabelle ein.
	// Falls der Eintrag bereits existiert passiert NICHTS!
	public void insert(final IHashable o)
	{
		assert(o != null);

		final int currentPos = findePosition(o);

		if (table[currentPos] == null)
		{
			table[currentPos] = o;

			if (++currentSize > table.length / 2)
				rehash();
		}
	}

	// Erweiterung der Hashtabelle
	private void rehash()
	{
		// Debug-Ausgabe
		System.out.println("rehash(" + table.length+ ")");

		// Kopie der alten Hashtabelle anlegen
		IHashable[] oldTable = table;

		// Erzeuge table mit mindestens der doppelten Größe
		// (führt zu O(log n) Vergrößerungs-Operationen für n Objekte)
		table = new IHashable[nextPrime(2 * oldTable.length)];

		currentSize = 0;

		// Einsortieren der Elemente ins neue Array
		for (int a = 0; a < oldTable.length; a++)
			if (oldTable[a] != null)
				insert(oldTable[a]);
	}

	// Quadratisches Sondieren
	public int findePosition(IHashable o)
	{


		Professor p = (Professor) o;
		int iHashCode = p.hash(table.length);

		if(table[iHashCode] == null) {

			return iHashCode;
		} else if(table[iHashCode].equals(p)) {

			return iHashCode;
		} else {

			int icntr = 1;
			int icrntPos = iHashCode;

			while (table[icrntPos] != null && table[iHashCode].equals(p)) {

				icrntPos = (iHashCode + (int) Math.pow(icntr,2))% table.length;
				icntr++;
			}

			return icrntPos;
		}
		// Suche Index, an der das Objekt o in table eingetragen ist bzw. eingetragen werden kann
		// Kollisionauflösung durch quadratisches Sondieren
	}

	// Findet ein Objekt in der Hashtabelle
	public IHashable find(IHashable o)
	{
		return table[findePosition(o)];
	}

	// Löschen der gesamten Hashtabelle
	public void clear()
	{
		for (int a = 0; a < table.length; a++)
			table[a] = null;

		currentSize = 0;
	}

	// Interne Test-Methode
	public IHashable getEntry(final int pos)
	{
		return table[pos];
	}

	// Interne Test-Methode
	public int getSize()
	{
		return table.length;
	}

	// Private Funktion, die zu einer vorgegebenen Zahl n die nächsthöhere Primzahl findet
	private static int nextPrime(int n)
	{
		assert(n >= 0);

		// Nächste ungerade Zahl
		n |= 1;

		while (!isPrime(n))
			n += 2;

		return n;
	}

	// Testet, ob eine Zahl eine Primzahl ist (einfache, aber ineffiziente Implementierung)
	private static boolean isPrime(final int n)
	{
		if ((n == 2) || (n == 3))
			return true;

		if ((n == 1) || ((n & 1) == 0))
			return false;

		for (int a = 3; a * a <= n; a += 2)
			if ((n % a) == 0)
				return false;

		return true;
	}
}