package no.hvl.dat102;

import java.util.Arrays;

//package no.hib.dat102.klient;

//import no.hib.dat102.haug.tabell.*;

public class KlientHaug {
	public static void main(String[] a) {
		// Tester haugen ved � sortere verdier i en tabell
		int tab[] = { 300, 10, 30, 2, 100, 33, 1, 200, 18, 54 };
		TabellHaug<Integer> h1 = new TabellHaug<Integer>();
		for (int i = 0; i < tab.length; i++) {

			h1.leggTilElement(new Integer(tab[i]));
		}
		System.out.println("tabellen for innsetting");
		System.out.println(Arrays.toString(tab));
		System.out.println("\nVerdiene i tabellen er n�:");
		h1.skrivTab();
		// Tar ut av haugen og skriver i sortert rekkef�lge
		System.out.println("\nHaugen i sortert rekkefoelge:");
		while (!h1.erTom()) {
			Integer h = (Integer) h1.fjernMinste();
			System.out.print(h + "  ");
		}
		System.out.println();
	}
}