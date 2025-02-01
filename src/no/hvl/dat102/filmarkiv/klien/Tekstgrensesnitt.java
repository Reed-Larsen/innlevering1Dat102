package no.hvl.dat102.filmarkiv.klien;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;

public class Tekstgrensesnitt {

    public Film lesFilm(){
        //TODO Skal lese inn opplysninger fra tastatur - returnere et filmobjekt

        return null;
    }

    public void skrivUtFilm(Film film){
        //TODO Skriv ut en film med alle opplysninger på skjermen, (Husk tekst for sjanger)
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
