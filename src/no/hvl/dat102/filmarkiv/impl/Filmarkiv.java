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

        if(antall >= filmer.length){
            utvid();
        }
        filmer[antall++] = nyFilm;


    }

    @Override
    public boolean slettFilm(int filmnr) {
        for (int i = 0; i < antall; i++) {
            if(filmer[i].getFilmnr() == filmnr){
                for (int j = i; j < antall -1; j++){
                    filmer[j] = filmer[j+1];
                }
                filmer [antall--] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public Film[] soekTittel(String delstreng) {
        Film[] treff = new Film[antall];
        int antallTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getTittel().toLowerCase().contains(delstreng.toLowerCase())){
                treff[antallTreff++] = filmer[i];
            }
        }

        return Arrays.copyOf(treff, antallTreff);
    }

    @Override
    public Film[] soekProdusent(String delstreng) {
        Film[] treff = new Film[antall];
        int antallTreff = 0;
        for (int i = 0; i < antall; i++) {
            if (filmer[i].getFilmskaper().toLowerCase().contains(delstreng.toLowerCase())){
                treff[antallTreff++] = filmer[i];
            }
        }

        return Arrays.copyOf(treff, antallTreff);
    }

    @Override
    public int antall(Sjanger sjanger) {
        int teller = 0;
        for (int i = 0; i < antall; i++){
            if (filmer[i].getSjanger() == sjanger){
                teller++;
            }
        }
        return teller;
    }

    @Override
    public int antall() {
        return antall;
    }

    private void utvid(){
        int nyKapasitet = filmer.length * 2;
        filmer = Arrays.copyOf(filmer, nyKapasitet);
        System.out.println("Tabellen er full. Ny kapasitet");
    }
}
