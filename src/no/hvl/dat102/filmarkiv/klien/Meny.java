package no.hvl.dat102.filmarkiv.klien;



import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Scanner;

public class Meny {

    private Tekstgrensesnitt tekstgr;
    private FilmarkivADT filmarkiv;

    public Meny(FilmarkivADT filmarkiv) {
        tekstgr = new Tekstgrensesnitt();
        this.filmarkiv = filmarkiv;
    }

    public void start(){
        Film[] filmer = new Film[] {
                new Film(1, "Warner Bros", "Inception", 2010, Sjanger.SCIENCE_FICTION, "Christopher Nolan"),
                new Film(2, "Paramount Pictures", "Titanic", 1997, Sjanger.ROMANTIKK, "James Cameron"),
                new Film(3, "Paramount Pictures", "The Godfather", 1972, Sjanger.DRAMA, "Francis Ford Coppola"),
                new Film(4, "Warner Bros", "The Dark Knight", 2008, Sjanger.ACTION, "Christopher Nolan"),
                new Film(5, "Miramax", "Pulp Fiction", 1994, Sjanger.DRAMA, "Quentin Tarantino"),
                new Film(6, "Paramount Pictures", "Forrest Gump", 1994, Sjanger.DRAMA, "Robert Zemeckis"),
                new Film(7, "Warner Bros", "The Matrix", 1999, Sjanger.SCIENCE_FICTION, "Lana Wachowski, Lilly Wachowski"),
                new Film(8, "Columbia Pictures", "The Shawshank Redemption", 1994, Sjanger.DRAMA, "Frank Darabont"),
                new Film(9, "Marvel Studios", "Avengers: Endgame", 2019, Sjanger.ACTION, "Anthony Russo, Joe Russo"),
                new Film(10, "Paramount Pictures", "Interstellar", 2014, Sjanger.SCIENCE_FICTION, "Christopher Nolan")
        };
        for (Film film : filmer) {
            filmarkiv.leggTilFilm(film);
        }

        Scanner scanner = new Scanner(System.in);
        boolean fortsett = true;

        while (fortsett) {
            System.out.println("Velg en handling:");
            System.out.println("1: Legg til en ny film");
            System.out.println("2: Søk etter filmer med tittel");
            System.out.println("3: Søk etter filmer etter filmskaper");
            System.out.println("4: Vis statistikk");
            System.out.println("5: Avslutt");

            System.out.print("Ditt valg: ");
            int valg = Integer.parseInt(scanner.nextLine());

            switch (valg) {
                case 1 -> {
                    Film nyFilm = tekstgr.lesFilm();
                    filmarkiv.leggTilFilm(nyFilm);
                    System.out.println("Filmen er lagt til.");
                }
                case 2 -> {
                    System.out.print("Skriv inn del av tittelen: ");
                    String delTittel = scanner.nextLine();
                    tekstgr.skrivUtFilmDelstrengTittel(filmarkiv, delTittel);
                }
                case 3 -> {
                    System.out.print("Skriv inn del av filmskaperens navn: ");
                    String delSkaper = scanner.nextLine();
                    tekstgr.skrivUtFilmProdusent(filmarkiv, delSkaper);
                }
                case 4 -> tekstgr.skrivUtStatistikk(filmarkiv);
                case 5 -> {
                    fortsett = false;
                    System.out.println("Avslutter programmet.");
                }
                default -> System.out.println("Ugyldig valg. Prøv igjen.");
            }
        }

        scanner.close();

        tekstgr.skrivUtStatistikk(filmarkiv);
    }
}
