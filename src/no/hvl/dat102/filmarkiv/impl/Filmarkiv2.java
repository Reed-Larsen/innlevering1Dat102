package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Film;
import no.hvl.dat102.filmarkiv.impl.LinearNode;
import no.hvl.dat102.filmarkiv.impl.Sjanger;

import java.util.Arrays;

public class Filmarkiv2 implements FilmarkivADT {
    private int antall; // Antall filmer i arkivet
    private LinearNode<Film> start; // Starten av den lenkede listen

    // Konstruktør
    public Filmarkiv2() {
        this.antall = 0;
        this.start = null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {
        LinearNode<Film> nyNode = new LinearNode<>(nyFilm);
        nyNode.setNeste(start); // Sett den nye noden foran i listen
        start = nyNode; // Oppdater start til å peke på den nye noden
        antall++;
    }

    @Override
    public boolean slettFilm(int filmnr) {
        LinearNode<Film> forrige = null;
        LinearNode<Film> aktuell = start;

        while (aktuell != null) {
            if (aktuell.getData().getFilmnr() == filmnr) {
                if (forrige == null) { // Sletter første node
                    start = aktuell.getNeste();
                } else { // Sletter en node midt i eller på slutten
                    forrige.setNeste(aktuell.getNeste());
                }
                antall--;
                return true;
            }
            forrige = aktuell;
            aktuell = aktuell.getNeste();
        }
        return false; // Fant ikke filmen
    }

    @Override
    public Film finnFilm(int nr) {
        LinearNode<Film> aktuell = start;

        while (aktuell != null) {
            if (aktuell.getData().getFilmnr() == nr) {
                return aktuell.getData();
            }
            aktuell = aktuell.getNeste();
        }
        return null; // Fant ikke filmen
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int antallTreff = 0;
        LinearNode<Film> aktuell = start;

        while (aktuell != null) {
            if (aktuell.getData().getTittel().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[antallTreff++] = aktuell.getData();
            }
            aktuell = aktuell.getNeste();
        }
        return Arrays.copyOf(treff, antallTreff); // Returner treffene
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] treff = new Film[antall];
        int antallTreff = 0;
        LinearNode<Film> aktuell = start;

        while (aktuell != null) {
            if (aktuell.getData().getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())) {
                treff[antallTreff++] = aktuell.getData();
            }
            aktuell = aktuell.getNeste();
        }
        return Arrays.copyOf(treff, antallTreff); // Returner treffene
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        LinearNode<Film> aktuell = start;

        while (aktuell != null) {
            if (aktuell.getData().getSjanger() == sjanger) {
                teller++;
            }
            aktuell = aktuell.getNeste();
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }
}
