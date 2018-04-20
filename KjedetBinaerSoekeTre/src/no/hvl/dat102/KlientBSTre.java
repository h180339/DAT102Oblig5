package no.hvl.dat102;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.*;

class KlientBSTre {

	public static void main(String[] a) {
		//Lager BS-tre med 8 noder
		//Skriv ut i in-orden, dvs sortert
		//Sjekker om verdien 10 er i treet
		//

		final int ANTALL_NODER = 1024;
		Random tilfeldig = new Random();

		KjedetBinaerSokeTre<Integer> bs = new KjedetBinaerSokeTre();
		/*
		Integer resultat = null;

		for(int i = 0; i < ANTALL_NODER; i++) {
			Integer element = new Integer(tilfeldig.nextInt(30));
			System.out.println(element);
			bs.leggTil(element);
		}
		*/

		//Lager 100 binæretrer og legger det inn i en tabell kalt "tab"
		final int ANTALL_TRER = 100;
		KjedetBinaerSokeTre<Integer>[] tab = new KjedetBinaerSokeTre[ANTALL_TRER];

		for(int i = 0; i < ANTALL_TRER; i++) {
			KjedetBinaerSokeTre<Integer> bst = new KjedetBinaerSokeTre();
			for(int j = 0; j < ANTALL_NODER; j++) {
				Integer element = new Integer(tilfeldig.nextInt(50));
				bst.leggTil(element);
			}
			tab[i] = bst;
		}

		System.out.println("minimum høyde: ");
		System.out.println(tab[0].finnMinHoyde());

		System.out.println("maksimum høyde: ");
		System.out.println(tab[0].finnMaksHoyde());

		int hoyde = 0;

		for(KjedetBinaerSokeTre<Integer> trer : tab) {
			hoyde += trer.finnHoyde();
		}
		hoyde = hoyde / ANTALL_TRER;

		System.out.print("gjennomsnittshøyde: ");
		System.out.println(hoyde);

		System.out.print("c =");
		double logN = (Math.log(ANTALL_NODER) / Math.log(2));
		double c = hoyde / logN;

		System.out.println(c);

		System.out.print("c * log 4096 = ");
		System.out.println(c * Math.log(4096) / Math.log(2));

		//****************************************************************************

	}
}//class