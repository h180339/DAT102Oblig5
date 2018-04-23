package no.hvl.dat102;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;

public class HashSetTest {

	public static void main(String[] args) {

		Random tilfeldig = new Random();


		Integer[] tab = new Integer[1000000];
		HashSet<Integer> hashSet = new HashSet<>(1000000);

		for(int i = 0; i < 1000000; i++) {
			Integer element = new Integer(tilfeldig.nextInt(999999));
			element = (element + 45713) % 1000000;
			hashSet.add(element);
			tab[i] = element;
		}
		Arrays.sort(tab);

		Integer[] sokeTallTab = new Integer[100000];

		int funnet = 0;

		for(int a = 0; a < sokeTallTab.length; a++) {
			sokeTallTab[a] = new Integer(tilfeldig.nextInt(999999));
		}

		long totaltid = 0;
		long startTid = System.nanoTime();

		for(int c = 0; c < sokeTallTab.length; c++) {
			if(Arrays.binarySearch(tab, sokeTallTab[c]) > 0) {
				funnet++;
			}
		}
		long sluttTid = System.nanoTime();
		System.out.println("Kjøretid tabell = " + (sluttTid - startTid) + " ns");
		System.out.println("Funnet : " + funnet);

		funnet = 0;

		totaltid = 0;
		startTid = System.nanoTime();

		for(int d = 0; d < sokeTallTab.length; d++) {
			if(hashSet.contains(sokeTallTab[d])) {
				funnet++;
			}
		}

		sluttTid = System.nanoTime();
		System.out.println("Kjøretid hashSet = " + (sluttTid - startTid) + " ns");
		System.out.println("Funnet : " + funnet);
	}

}
