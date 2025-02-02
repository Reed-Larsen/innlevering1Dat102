package no.hvl.dat102.filmarkiv.klien;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;



public class Tekstgrensesnitt {

    public Film lesFilm(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Filmnummer: ");
        int nummer = Integer.parseInt(scanner.nextLine());

        System.out.println("Selskap: ");
        String selskap = scanner.nextLine();

        System.out.println("Tittel: ");
        String tittel = scanner.nextLine();

        System.out.println("Lanseringsår: ");
        int lansering = Integer.parseInt(scanner.nextLine());

        Sjanger sjanger = null;
        boolean validSjanger = false;

        while (!validSjanger) {
            try {
                System.out.print("Sjanger (ACTION, DRAMA, ROMANTIKK, SCIENCE_FICTION, KOMEDIE): ");
                sjanger = Sjanger.valueOf(scanner.nextLine().toUpperCase());
                validSjanger = true; // Gyldig input, avslutt løkken
            } catch (IllegalArgumentException e) {
                System.out.println("Ugyldig sjanger! Prøv igjen.");
            }
        }

        System.out.println("Filmskaper: ");
        String filmskaper = scanner.nextLine();


        return new Film(nummer, selskap, tittel, lansering, sjanger, filmskaper);
    }

    public void skrivUtFilm(Film film){
        //TODO Skriv ut en film med alle opplysninger på skjermen, (Husk tekst for sjanger)
        if(film != null){
        System.out.println("Filmnummer: " + film.getFilmnr());
        System.out.println("Selskap: " + film.getFilmselskap());
        System.out.println("Tittel: " + film.getTittel());
        System.out.println("Lansering: " + film.getLansering());
        System.out.println("Sjanger: " + film.getSjanger());
        System.out.println("Filmskaper: " + film.getFilmskaper());
        } else {
            System.out.println("Filmen ikke funnet.");
        }
    }

    public void skrivUtFilmDelstrengTittel(FilmarkivADT arkiv, String delstreng){
        //TODO Skal skrive ut alle filmer med en
        //TODO spesiell delstreng i tittelen
    }

    public void skrivUtFilmProdusent(FilmarkivADT akriv, String delstreng){
        //TODO Skal skrive ut alle filmer av en
        //TODO produsent (Produsent er delstreng)
    }

    public void skrivUtStatistikk(FilmarkivADT arkiv){
        //TODO Skal skrive ut en enkel statistikk som
        //TODO inneholder antall filmer totalt
        //TODO og hvor mange det er i hver sjanger
    }
}
