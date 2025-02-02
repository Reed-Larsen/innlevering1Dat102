package no.hvl.dat102.filmarkiv.impl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class FilmarkivTest {
    private Filmarkiv arkiv;

    @BeforeEach
    void setUp() {
        arkiv = new Filmarkiv(5);
        arkiv.leggTilFilm(new Film(1, "Warner Bros", "Inception", 2010, Sjanger.SCIENCE_FICTION, "Christopher Nolan"));
        arkiv.leggTilFilm(new Film(2, "Paramount", "Titanic", 1997, Sjanger.ROMANTIKK, "James Cameron"));
        arkiv.leggTilFilm(new Film(3, "Paramount", "The Godfather", 1972, Sjanger.DRAMA, "Francis Ford Coppola"));
    }

    @Test
    void finnFilm() {
        Film film = arkiv.finnFilm(1);
        assertNotNull(film);
        assertEquals("Inception", film.getTittel());}
}