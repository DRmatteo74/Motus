package fr.esgi.service;

import fr.esgi.business.Difficulte;

public interface DifficulteService {
	void creerDifficulte();

	Difficulte recupererDifficulteParId(Long id);
}
