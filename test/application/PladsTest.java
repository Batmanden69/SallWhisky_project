package test.application;

import application.Fad;
import application.Lager;
import application.Plads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;

import static org.junit.jupiter.api.Assertions.*;

class PladsTest {
    private Lager lager;
    private Fad fad;
    private Plads plads;

    @BeforeEach
    void setUp() {
        lager = new Lager("Lager1", 10);
        fad = new Fad(100, "Eg", "Frankrig");
        plads = lager.createPlads(1, 1, lager);
    }

    @Test
    public void plads() {
        //Arrange
        Lager lager1 = new Lager("Lager1", 10);
        Plads plads1 = lager1.createPlads(1, 1, lager1);
        //Act
        Lager lager = plads1.getLager();
        boolean optaget = plads1.isOptaget();
        //Assert
        assertEquals(lager1, lager);
        assertEquals(false, optaget);
    }

    @Test
    void getLager() {
        Lager actualResult = plads.getLager();
        assertEquals(lager, actualResult);
    }

    @Test
    void getFad(){
        plads.setFad(fad);
        Fad actualResult = plads.getFad();
        assertEquals(fad, actualResult);
    }

    @Test
    void setFad(){
        plads.setFad(fad);
        Fad actualResult = plads.getFad();
        assertEquals(fad, actualResult);
    }

    @Test
    void isOptaget() {
        plads.setOptaget(true);
        boolean actualResult = plads.isOptaget();
        assertTrue(actualResult);
    }

//    @Test
//    void getLagerTC1() throws NoSuchFieldException, IllegalAccessException {
//        //Arrange
//        final Lager lager1 = new Lager("Lager1", 10);
//        final Plads plads1 = lager1.createPlads(1, 1, lager1);
//        final Field field = plads1.getClass().getDeclaredField("lager");
//        field.setAccessible(true);
//        field.set(plads1, lager1);
//        //Act
//        final Lager result = plads1.getLager();
//        //Assert
//        assertEquals(lager1, result);
//    }
//
//    @Test
//    void getLagerTC2() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//
//        //Act
//        Lager lager2 = plads1.getLager();
//        Lager lager3 = new Lager("Lager3", 10);
//        //Assert
//        assertNotEquals(lager3, lager2);
//    }
//
//    @Test
//    void setOptagetTC1() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        //Act
//
//        plads1.setOptaget(true);
//        //Assert
//        assertTrue(plads1.isOptaget());
//    }
//
//    @Test
//    void setOptagetTC2() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        //Act
//
//        plads1.setOptaget(false);
//        //Assert
//        assertFalse(plads1.isOptaget());
//    }
//
//    @Test
//    void isOptagetTC1() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        //Act
//        plads1.setOptaget(true);
//        //Assert
//        assertTrue(plads1.isOptaget());
//    }
//
//    @Test
//    void isOptagetTC2() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        //Act
//        plads1.setOptaget(false);
//        //Assert
//        assertFalse(plads1.isOptaget());
//    }
//
//    @Test
//    void getFadTC1() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
//        //Act
//        plads1.setFad(fad1);
//        //Assert
//        assertEquals(fad1, plads1.getFad());
//    }
//
//    @Test
//    void getFadTC2() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
//        //Act
//        plads1.setFad(fad1);
//        Fad fad2 = new Fad(100, "Ex Bourbon", "USA");
//        //Assert
//        assertNotEquals(fad2, plads1.getFad());
//    }
//
//    @Test
//    void setFadTC1() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
//        //Act
//        plads1.setFad(fad1);
//        //Assert
//        assertEquals(fad1, plads1.getFad());
//    }
//
//    @Test
//    void setFadTC2() {
//        //Arrange
//        Lager lager1 = new Lager("Lager1", 10);
//        Plads plads1 = lager1.createPlads(1, 1, lager1);
//        Fad fad1 = new Fad(100, "Ex Bourbon", "USA");
//        //Act
//        plads1.setFad(fad1);
//        Fad fad2 = new Fad(100, "Ex Bourbon", "USA");
//        //Assert
//        assertNotEquals(fad2, plads1.getFad());
//    }
}