package no.hvl.dat102.filmarkiv.impl;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;

import java.util.Arrays;

public class Filmarkiv implements FilmarkivADT {

    private Film[] filmer;
    private int antall;

    //Konstruktør: Oppretter et tom arkiv med en gitt grensesnitt
    public Filmarkiv(int kapasitet){
        this.filmer = new Film[kapasitet];
        this.antall = 0;
    }
    //Finner film ved hjelp av filmnummer
    @Override
    public Film finnFilm(int nr) {
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmnr() == nr){
                return filmer[i]; //Returnerer filmen hvis nummeret matcher
            }

        }
        return null;
    }

    @Override
    public void leggTilFilm(Film nyFilm) {



    }

    @Override
    public boolean slettFilm(int filmnr) {
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        return new Film[0];
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        return new Film[0];
    }

    @Override
    public int antall(Sjanger sjanger) {
        return 0;
    }

    @Override
    public int antall() {
        return 0;
    }

    private void utvid(){
        int nyKapasitet = filmer.length * 2;
        filmer = Arrays.copyOf(filmer, nyKapasitet);
        System.out.println("Tabellen er full. Ny kapasitet");
    }
}
