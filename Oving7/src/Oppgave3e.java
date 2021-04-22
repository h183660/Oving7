import java.util.HashSet;
import java.util.Arrays;
import java.util.Random;

public class Oppgave3e {

	public static void main(String[] args) {

		int antElement = 100000;
		HashSet<Integer> hashSet = new HashSet<Integer>();
		Integer[] tabell = new Integer[antElement];

		// Genererer tallene og setter de inn i HashSet og Tabellen
		int tall = 376; // Her kan vi bruke eit vilkårleg tal
		for (int i = 0; i < antElement; i++) {
			hashSet.add(tall);
			tabell[i] = tall;
			// legg tall til i HashSet og tabell
			tall = (tall + 45713) % 1000000; // Sjå nedanfor om 45713
		}

		// Sorterer Tabellen
		Arrays.sort(tabell);

		// Genererer en tabell av tall vi skal søke etter
		Integer[] soekTab = new Integer[10000];
		Random random = new Random();
		for (int i = 0; i < soekTab.length; i++) {
			soekTab[i] = random.nextInt(999999);
		}

		// Måler tiden på hashSet og Søker teller antall elementer funnet
		long hashSetTid = System.nanoTime();
		int funnetTall = 0;
		System.out.println();
		System.out.println("HashSet:");
		for (Integer soekTall : soekTab) {
			if (hashSet.contains(soekTall)) {
				funnetTall += 1;
			}
		}
		hashSetTid = System.nanoTime() - hashSetTid;
		System.out.println("Tid: " + hashSetTid + " ns, og fant " + funnetTall + " tall.");

		// Måler tiden på binærsøk av den sorterte tabellen og teller antall funnet.
		funnetTall = 0;
		long tabellTid = System.nanoTime();
		System.out.println();
		System.out.println("Tabell:");
		for (Integer soekTall : soekTab) {
			if (Arrays.binarySearch(tabell, 0, antElement, soekTall) >= 0) {
				funnetTall += 1;
			}
		}
		tabellTid = System.nanoTime() - tabellTid;
		System.out.println("Tid: " + tabellTid + " ns, og fant " + funnetTall + " tall.");
	}
}