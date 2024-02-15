package fr.esgi.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import fr.esgi.business.Difficulte;

public class DifficulteServiceImplTest {

    private DifficulteServiceImpl difficulteService;

    @BeforeEach
    void setUp() {
        difficulteService = new DifficulteServiceImpl();
        difficulteService.creerDifficulte();
    }

    @Test
    @DisplayName("Test récupération de la difficulté par ID")
    void testRecupererDifficulteParId() {
        Long id = 1L;
        Difficulte facile = difficulteService.recupererDifficulteParId(id);
        assertNotNull(facile);
        assertEquals(id, facile.getId());
        assertEquals("facile", facile.getLabelDifficulte());
    }

    @Test
    @DisplayName("Test récupération de la difficulté par ID - ID inexistant")
    void testRecupererDifficulteParIdInexistant() {
        Long idInexistant = 10L;
        Difficulte difficulteInexistante = difficulteService.recupererDifficulteParId(idInexistant);
        assertNull(difficulteInexistante);
    }
}
