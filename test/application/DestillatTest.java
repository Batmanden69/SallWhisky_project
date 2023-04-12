package test.application;

import application.Destillat;
import application.Destillering;
import application.Fad;
import application.Lagring;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DestillatTest {

    @Test
    void hældPåFadTC1() {
        //Arrange
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        //Act
        destillat.hældPåFad(fad, 1);
        //Assert
        assertEquals(1, fad.getAntalLiterPåfyldt());
    }

    @Test
    void hældPåFadTC2() {
        //Arrange
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        //Act
        destillat.hældPåFad(fad, 100);
        //Assert
        assertEquals(100, fad.getAntalLiterPåfyldt());
    }

    @Test
    void hældPåFadTC3() {
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            destillat.hældPåFad(fad, 101);
        });
        assertEquals("Den indtastede mængde overskrider mængden af destillat.", exception.getMessage());
    }

    @Test
    void hældPåFadTC4() {
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            destillat.hældPåFad(fad, 0);
        });
        assertEquals("Den indtastede mængde skal være større end 0.", exception.getMessage());
    }
    @Test
    void hældPåFadTC5() {
        //Arrange
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        //Act
        destillat.hældPåFad(fad, 100);
        //Assert
        assertNotNull(destillat.getDestillatHistorik().get(0));
    }

    @Test
    void hældPåFadTC6() {
        //Arrange
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        //Act
        destillat.hældPåFad(fad, 100);
        //Assert
        assertNotNull(fad.getLagringList().get(0));
    }
    @Test
    void hældPåFadTC7(){
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5, "Tørv", null);
        Destillat destillat = new Destillat(100, destillering1);
        Fad fad = new Fad(100, "Eg", "Frankrig");
        //Act
        destillat.hældPåFad(fad, 100);
        Lagring destillatLagring = destillat.getDestillatHistorik().get(0);
        Lagring fadLagring = fad.getLagringList().get(0);
        //Assert
        assertSame(destillatLagring, fadLagring);

    }
}
