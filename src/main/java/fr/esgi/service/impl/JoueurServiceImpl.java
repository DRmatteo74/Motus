package fr.esgi.service.impl;

import fr.esgi.buisness.Joueur;
import fr.esgi.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {

	@Override
	public void creerJoueur(String pseudo) {

		Joueur joueur = new Joueur(pseudo, null);
	}

}
