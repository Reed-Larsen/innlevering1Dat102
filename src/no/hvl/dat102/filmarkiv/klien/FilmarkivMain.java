package no.hvl.dat102.filmarkiv.klien;

import no.hvl.dat102.filmarkiv.adt.FilmarkivADT;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv;
import no.hvl.dat102.filmarkiv.impl.Filmarkiv2;

import java.util.Scanner;

public class FilmarkivMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Velg implementasjon:");
        System.out.println("1: Tabellimplementasjon (del 1)");
        System.out.println("2: Lenket liste implementasjon (del 2)");
        System.out.print("Ditt valg: ");
        int valg = Integer.parseInt(scanner.nextLine());

        FilmarkivADT filmarkiv;
        if (valg == 1) {
            filmarkiv = new Filmarkiv(100); // Tabellimplementasjon fra del 1
        } else {
            filmarkiv = new Filmarkiv2(); // Lenket liste implementasjon fra del 2
        }

        Meny meny = new Meny(filmarkiv);
        meny.start(); // Start menyen
    }

    }

