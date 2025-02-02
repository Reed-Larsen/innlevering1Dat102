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
        assertEquals("Inception", film.getTittel());
    }

    @Test
    void testLeggTilFilm() {
        assertEquals(3, arkiv.antall());
        arkiv.leggTilFilm(new Film(4, "Interstellar", "Christopher Nolan", 2014, Sjanger.SCIENCE_FICTION, "Warner Bros"));
        assertEquals(4, arkiv.antall());
    }

    @Test
    void testSlettFilm() {
        assertTrue(arkiv.slettFilm(2)); // Sletter Titanic
        assertEquals(2, arkiv.antall());
        assertNull(arkiv.finnFilm(2)); // Sjekker at filmen ikke finnes lenger
    }

    @Test
    void testSoekTittel() {
        Film[] treff = arkiv.soekTittel("God");
        assertEquals(1, treff.length);
        assertEquals("The Godfather", treff[0].getTittel());
    }

    @Test
    void testSoekProdusent() {
        Film[] treff = arkiv.soekProdusent("Paramount");
        assertEquals(2, treff.length); // Titanic og The Godfather
    }

    @Test
    void testAntallPerSjanger() {
        assertEquals(1, arkiv.antall(Sjanger.ROMANTIKK));
        assertEquals(1, arkiv.antall(Sjanger.DRAMA));
        assertEquals(1, arkiv.antall(Sjanger.SCIENCE_FICTION));
    }

    @Test
    void testAntallTotalt() {
        assertEquals(3, arkiv.antall());
    }
}
