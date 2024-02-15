package fr.esgi.service.impl;

import java.util.ArrayList;
import java.util.List;

import fr.esgi.business.Joueur;
import fr.esgi.business.Partie;
import fr.esgi.service.JoueurService;

public class JoueurServiceImpl implements JoueurService {

	private static ArrayList<Joueur> joueurs = new ArrayList<>();

	/**
	 * Créer un joueur grâce au pseudo
	 * 
	 * @param pseudo
	 */
	@Override
	public void creerJoueur(String pseudo) {

		Joueur joueur = new Joueur(pseudo, null);
		joueurs.add(joueur);
	}

	/**
	 * Retourne le joueur
	 * 
	 * @return Joueur
	 */
	@Override
	public Joueur recupererJoueur() {
		return joueurs.get(0);
	}

	/**
	 * Ajoute la liste de partie au joueur
	 * 
	 * @param joueur
	 * @param partie
	 */
	@Override
	public void ajouterPartie(Joueur joueur, Partie partie) {
		List<Partie> listPartieJoueur = joueur.getParties();
		if (listPartieJoueur == null) {
			listPartieJoueur = new ArrayList<>();
		}
		listPartieJoueur.add(partie);
		joueur.setParties(listPartieJoueur);

	}

}
