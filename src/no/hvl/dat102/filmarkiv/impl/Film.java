package no.hvl.dat102.filmarkiv.impl;

public class Film {
    private int filmnr;
    private String filmskaper;
    private String tittel;
    private int lansering;
    private Sjanger sjanger;
    private String filmselskap;

    //Konstruktør for Film
    Film(int filmnr, String filmselskap, String tittel , int lansering , Sjanger sjanger, String filmskaper){
        this.filmnr = filmnr;
        this.filmselskap = filmselskap;
        this.tittel = tittel;
        this.lansering = lansering;
        this.sjanger = sjanger;
        this.filmskaper = filmskaper;
    }


    public int getFilmnr() {
        return filmnr;
    }

    public void setFilmnr(int filmnr) {
        this.filmnr = filmnr;
    }

    public String getFilmskaper() {
        return filmskaper;
    }

    public void setFilmskaper(String filmskaper) {
        this.filmskaper = filmskaper;
    }

    public String getTittel() {
        return tittel;
    }

    public void setTittel(String tittel) {
        this.tittel = tittel;
    }

    public int getLansering() {
        return lansering;
    }

    public void setLansering(int lansering) {
        this.lansering = lansering;
    }

    public Sjanger getSjanger() {
        return sjanger;
    }

    public void setSjanger(Sjanger sjanger) {
        this.sjanger = sjanger;
    }

    public String getFilmselskap() {
        return filmselskap;
    }

    public void setFilmselskap(String filmselskap) {
        this.filmselskap = filmselskap;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Film annenFilm = (Film) obj;

        return filmnr == annenFilm.filmnr;
    }
}
