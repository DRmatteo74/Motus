package fr.esgi.service.impl;

import java.util.ArrayList;

import fr.esgi.business.Difficulte;
import fr.esgi.service.DifficulteService;

public class DifficulteServiceImpl implements DifficulteService {

	private static ArrayList<Difficulte> difficultes = new ArrayList<>();

	@Override
	public void creerDifficulte() {
		Difficulte facile = new Difficulte("facile");
		Difficulte moyen = new Difficulte("moyen");
		Difficulte difficile = new Difficulte("difficile");

		difficultes.add(difficile);
		difficultes.add(moyen);
		difficultes.add(facile);

	}

	@Override
	public Difficulte recupererDifficulteParId(Long id) {
		return difficultes.stream().filter(mot -> mot.getId().equals(id)).findFirst().orElse(null);
	}

}
