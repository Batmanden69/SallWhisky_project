package test.application;

import application.Destillat;
import application.Destillering;
import application.Fad;
import application.Lagring;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import static org.junit.jupiter.api.Assertions.*;

class LagringTest {

    @Test
    void getLagringsperiodeTC1(){
//Arrange
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5,"Tørv",null);
        Destillat destillat1 = new Destillat(100,destillering1);
        Lagring lagring = new Lagring(fad1, destillat1);
        lagring.setSlutDato(LocalDate.now().plus(1, ChronoUnit.DAYS));
        //Act
        long result = lagring.getLagringsperiode();
        //Assert
        assertEquals(1,result);

    }
    @Test
    void getLagringsperiodeTC2() {
        //Arrange
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5,"Tørv",null);
        Destillat destillat1 = new Destillat(100,destillering1);
        Lagring lagring = new Lagring(fad1, destillat1);
        lagring.setSlutDato(LocalDate.now().plus(100, ChronoUnit.DAYS));
        //Act
        long result = lagring.getLagringsperiode();
        //Assert
        assertEquals(100,result);
    }

    @Test
    void getLagringsperiodeTC3(){
        //Arrange
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5,"Tørv",null);
        Destillat destillat1 = new Destillat(100,destillering1);
        Lagring lagring = new Lagring(fad1, destillat1);
        lagring.setSlutDato(LocalDate.now().plus(0, ChronoUnit.DAYS));
        //Act
        long result = lagring.getLagringsperiode();
        //Assert
        assertEquals(0,result);

    }
    @Test
    void getLagringsperiodeTC4(){
        //Arrange
        Fad fad1 = new Fad(100, "Eg", "Frankrig");
        Destillering destillering1 = new Destillering(1000, 1, "Byg", 45.5,"Tørv",null);
        Destillat destillat1 = new Destillat(100,destillering1);
        Lagring lagring = new Lagring(fad1, destillat1);
        //Act
        long result = lagring.getLagringsperiode();
        //Assert
        assertEquals(0,result);
    }
}