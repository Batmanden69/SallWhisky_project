package test.application;

import application.Fad;
import application.Lager;
import application.Plads;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PladsTest {

    @Test
    void getLagerTC1() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        //Act
        Lager lager2 = plads1.getLager();
        //Assert
        assertEquals(lager1, lager2);
    }

    @Test
    void getLagerTC2() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);

        //Act
        Lager lager2 = plads1.getLager();
        Lager lager3 = new Lager("Lager3", 10);
        //Assert
        assertNotEquals(lager3, lager2);
    }

    @Test
    void setOptagetTC1() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        //Act

        plads1.setOptaget(true);
        //Assert
        assertTrue(plads1.isOptaget());
    }

    @Test
    void setOptagetTC2() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        //Act

        plads1.setOptaget(false);
        //Assert
        assertFalse(plads1.isOptaget());
    }

    @Test
    void isOptagetTC1() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        //Act
        plads1.setOptaget(true);
        //Assert
        assertTrue(plads1.isOptaget());
    }

    @Test
    void isOptagetTC2() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        //Act
        plads1.setOptaget(false);
        //Assert
        assertFalse(plads1.isOptaget());
    }

    @Test
    void getFadTC1() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
        //Act
        plads1.setFad(fad1);
        //Assert
        assertEquals(fad1, plads1.getFad());
    }

    @Test
    void getFadTC2(){
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
        //Act
        plads1.setFad(fad1);
        Fad fad2 = new Fad(100, "Ex Bourbon", "USA");
        //Assert
        assertNotEquals(fad2, plads1.getFad());
    }

    @Test
    void setFadTC1() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
        //Act
        plads1.setFad(fad1);
        //Assert
        assertEquals(fad1, plads1.getFad());
    }

    @Test
    void setFadTC2(){
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
        //Act
        plads1.setFad(fad1);
        Fad fad2 = new Fad(100, "Ex Bourbon", "USA");
        //Assert
        assertNotEquals(fad2, plads1.getFad());
    }
}