package fr.esgi.service;

import fr.esgi.business.Difficulte;

/**
 * Service qui concerne toutes fonctions de la class Difficulte
 */
public interface DifficulteService {
	void creerDifficulte();

	Difficulte recupererDifficulteParId(Long id);
}
