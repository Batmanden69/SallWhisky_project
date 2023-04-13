package test.application;

import application.Fad;
import application.Lager;
import application.Plads;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
}