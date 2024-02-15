package fr.esgi.service.impl;

import java.util.ArrayList;

import fr.esgi.business.Difficulte;
import fr.esgi.service.DifficulteService;

public class DifficulteServiceImpl implements DifficulteService {

	private static ArrayList<Difficulte> difficultes = new ArrayList<>();


	/**
	 * Créer les trois niveaux de difficultés et les ajoutes dans une liste
	 */
	@Override
	public void creerDifficulte() {
		Difficulte facile = new Difficulte("facile");
		Difficulte moyen = new Difficulte("moyen");
		Difficulte difficile = new Difficulte("difficile");

		difficultes.add(difficile);
		difficultes.add(moyen);
		difficultes.add(facile);

	}

	/**
	 * Récupère l'objet difficulté par l'id
	 * @param id
	 * @return Difficulte
	 */
	@Override
	public Difficulte recupererDifficulteParId(Long id) {
		return difficultes.stream().filter(mot -> mot.getId().equals(id)).findFirst().orElse(null);
	}

}
