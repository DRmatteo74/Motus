package fr.esgi.business;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class DifficulteTest {

    @Test
    void testGettersSetters(){
        Difficulte difficulte = new Difficulte();
        String labelDifficulte = "Toto";
        difficulte.setLabelDifficulte(labelDifficulte);
        assertNotNull(difficulte.getId());
        assertNotNull(difficulte.getLabelDifficulte());
    }

    @Test
    void testDefaultConstructor(){
        Difficulte difficulte = new Difficulte();
        assertNotNull(difficulte.getId());
    }

    @Test
    void testSecondConstructor() {
        String labelDifficulte = "Toto";
        Difficulte difficulte = new Difficulte(labelDifficulte);
        assertNotNull(difficulte.getLabelDifficulte());
    }

    @Test
    void testHashCode(){
        Difficulte mot1 = new Difficulte("Toto");
        Difficulte mot2 = new Difficulte("Toto");

        assertNotEquals(mot1.hashCode(), mot2.hashCode());
    }

    @Test
    void testEquals(){
        Difficulte mot1 = new Difficulte("Toto");
        Difficulte mot2 = new Difficulte("Toto");
        assertNotEquals(mot1, mot2);
    }

    @Test
    void testToString(){
        Difficulte mot = new Difficulte("Toto");
        String expectedString = "Difficulte [id=2, labelDifficulte=Toto]";
        assertEquals(expectedString, mot.toString());
    }
}
