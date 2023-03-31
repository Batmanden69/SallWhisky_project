package application;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FadTest {

    @Test
    void lægPåPladsTC1() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Fad fad1 = new Fad(1, 10,  "Fad1", "Leverandør1");
        lager1.createPlads(1, 1, lager1);
        //Act
        fad1.lægPåPlads(lager1);
        ArrayList<Fad> fadListe = lager1.getFadListe();
        //Assert
        assertEquals(1, fadListe.size());
    }

    @Test
    void lægPåPladsTC2() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Fad fad1 = new Fad(1, 10,  "Fad1", "Leverandør1");
        Fad fad2 = new Fad(2, 10,  "Fad2", "Leverandør2");
        lager1.createPlads(1, 1, lager1);
        lager1.createPlads(1, 2, lager1);
        //Act
        fad1.lægPåPlads(lager1);
        fad2.lægPåPlads(lager1);
        ArrayList<Fad> fadListe = lager1.getFadListe();
        //Assert
        assertEquals(2, fadListe.size());
    }

    @Test
    void lægPåPladsTC3() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Lager lager2 = new Lager("Lager2", 10);
        Fad fad1 = new Fad(1, 10, "Fad1", "Leverandør1");
        Fad fad2 = new Fad(2, 10, "Fad2", "Leverandør2");
        Fad fad3 = new Fad(3, 10, "Fad3", "Leverandør3");
        lager1.createPlads(1, 1, lager1);
        lager1.createPlads(1, 2, lager1);
        lager2.createPlads(1, 1, lager2);
        //Act
        fad1.lægPåPlads(lager1);
        fad2.lægPåPlads(lager2);
        fad3.lægPåPlads(lager1);
        ArrayList<Fad> fadListe = lager1.getFadListe();
        //Assert
        assertEquals(2, fadListe.size());
    }

//    @Test
//    void getNuværendeLagringTC1() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Fad fad1 = new Fad(1, 10,  "Fad1", "Leverandør1");
//        lager1.createPlads(1, 1, lager1);
//        Destillering destillering1 = new Destillering(100, 1, "Kornsort1", 1, 40, null, null);
//        Destillat destillat = new Destillat(10, destillering1);
//        LocalDate dato = LocalDate.now();
//
//        //Act
//        destillering1.hældPåFad(fad1);
//        Lagring lagring = fad1.createLagring(destillat, dato);
//        lagring.setFad(fad1);
//
//
//        //Assert
//        assertEquals(fad1.getNuværendeLagring(), lagring);
//    }
}