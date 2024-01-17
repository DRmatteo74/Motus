package fr.esgi.service.impl;

import java.util.ArrayList;

import fr.esgi.business.Joueur;
import fr.esgi.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {

	private static ArrayList<Joueur> joueurs = new ArrayList<>();

	@Override
	public void creerJoueur(String pseudo) {

		Joueur joueur = new Joueur(pseudo, null);
		joueurs.add(joueur);
	}

	@Override
	public Joueur recupererJoueur() {
		return joueurs.get(0);
	}

}
