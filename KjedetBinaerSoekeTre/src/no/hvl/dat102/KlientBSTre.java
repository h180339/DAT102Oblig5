package no.hvl.dat102;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

class KlientBSTre {

	public static void main(String[] a) {
		//Lager BS-tre med 8 noder
		//Skriv ut i in-orden, dvs sortert
		//Sjekker om verdien 10 er i treet
		//

		final int ANTALL_NODER = 4096;
		Random tilfeldig = new Random();

		KjedetBinaerSokeTre<Integer> bs = new KjedetBinaerSokeTre();

		//Lager 100 binæretrer og legger det inn i en tabell kalt "tab"
		final int ANTALL_TRER = 100;
		KjedetBinaerSokeTre<Integer>[] tab = new KjedetBinaerSokeTre[ANTALL_TRER];

		int minstHoyde = Integer.MAX_VALUE;
		int storstHoyde = Integer.MIN_VALUE;

		//legger inn tilfeldige tall i trærene og finner det laveste og høyeste treet underveis som de blir satt inn i tabellen
		for(int i = 0; i < ANTALL_TRER; i++) {
			KjedetBinaerSokeTre<Integer> bst = new KjedetBinaerSokeTre();
			for(int j = 0; j < ANTALL_NODER; j++) {
				Integer element = new Integer(tilfeldig.nextInt(50));
				bst.leggTil(element);

			}
			if(bst.finnHoyde() < minstHoyde) {
				minstHoyde = bst.finnHoyde();
			}
			if(bst.finnHoyde() > storstHoyde) {
				storstHoyde = bst.finnHoyde();
			}
			tab[i] = bst;
		}

		System.out.print("Antall noder: ");
		System.out.println(ANTALL_NODER);
		System.out.println();

		System.out.print("minimum høyde: ");
		System.out.println(tab[0].finnMinHoyde());
		System.out.println();

		System.out.print("maksimum høyde: ");
		System.out.println(tab[0].finnMaksHoyde());
		System.out.println();

		System.out.print("minste høyde under kjøring: ");
		System.out.println(minstHoyde);
		System.out.println();

		System.out.print("Størst høyde under kjøring: ");
		System.out.println(storstHoyde);
		System.out.println();

		int hoyde = 0;

		for(KjedetBinaerSokeTre<Integer> trer : tab) {
			hoyde += trer.finnHoyde();
		}
		hoyde = hoyde / ANTALL_TRER;

		System.out.print("gjennomsnittshøyde: ");
		System.out.println(hoyde);
		System.out.println();

		System.out.println("c = 3.8");
		System.out.println();
		double c = 3.8;

		System.out.print("c * log 4096 = ");
		System.out.println(c * Math.log(ANTALL_NODER) / Math.log(2));
		System.out.println();

		//****************************************************************************

	}
}//class