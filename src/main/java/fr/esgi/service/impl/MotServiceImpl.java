package fr.esgi.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.esgi.business.Mot;
import fr.esgi.service.MotService;

public class MotServiceImpl implements MotService {

	private static ArrayList<Mot> mots = new ArrayList<>();
	private static Random random = new Random();

	/**
	 * Import les mots des liens et les mets dans une liste
	 * 
	 */
	@Override
	public void importerMot() {
		try {
			// Utiliser URL pour lire un fichier depuis une URL
			URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire6.txt");
			try (BufferedReader lecteur = new BufferedReader(new InputStreamReader(url.openStream()))) {
				String ligne;

				while ((ligne = lecteur.readLine()) != null) {
					// Assurez-vous que recupererMot renvoie une instance de la classe Mot
					Mot mot = recupererMot(ligne);
					if (mot == null) {
						mot = new Mot(ligne, ligne.length());
						ajouterMot(mot);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Utiliser URL pour lire un fichier depuis une URL
			URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire7.txt");
			try (BufferedReader lecteur = new BufferedReader(new InputStreamReader(url.openStream()))) {
				String ligne;

				while ((ligne = lecteur.readLine()) != null) {
					// Assurez-vous que recupererMot renvoie une instance de la classe Mot
					Mot mot = recupererMot(ligne);
					if (mot == null) {
						mot = new Mot(ligne, ligne.length());
						ajouterMot(mot);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			// Utiliser URL pour lire un fichier depuis une URL
			URL url = new URL("https://raw.githubusercontent.com/gverdier/motus/master/Console/Dictionnaire8.txt");
			try (BufferedReader lecteur = new BufferedReader(new InputStreamReader(url.openStream()))) {
				String ligne;

				while ((ligne = lecteur.readLine()) != null) {
					// Assurez-vous que recupererMot renvoie une instance de la classe Mot
					Mot mot = recupererMot(ligne);
					if (mot == null) {
						mot = new Mot(ligne, ligne.length());
						ajouterMot(mot);
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Recupère un mot grâce à un String
	 * 
	 * @param nom
	 * @return Mot
	 */
	@Override
	public Mot recupererMot(String nom) {
		return mots.stream().filter(mot -> mot.getMot().equals(nom)).findFirst().orElse(null);
	}

	/**
	 * Ajoute un mot à la liste de mot
	 * 
	 * @param mot
	 * @return Mot
	 */
	@Override
	public Mot ajouterMot(Mot mot) {
		mots.add(mot);
		return mot;
	}

	/**
	 * Recupere un mot par son id
	 * 
	 * @param id
	 * @return Mot
	 */
	@Override
	public Mot recupererMotParId(Long id) {
		return mots.stream().filter(mot -> mot.getId().equals(id)).findFirst().orElse(null);
	}

	/**
	 * Recupere un mot aléatoirement
	 * 
	 * @return Mot
	 */
	@Override
	public Mot recupererMotAleatoire() {
		return mots.get(random.nextInt(0, mots.size()));
	}

	/**
	 * Recupere un mot par sa taille (definit par la difficulté)
	 * 
	 * @param difficulte
	 * @return Mot
	 */
	@Override
	public Mot recupererMotAleatoireParNiveau(int difficulte) {
		int taille;
		Mot mot = null;
		switch (difficulte) {
		case 1:
			taille = 6;
			break;
		case 2:
			taille = 7;
			break;
		default:
			taille = 8;
			break;
		}

		do {
			mot = recupererMotAleatoire();
		} while (mot.getLongueurMot() != taille);

		return mot;
	}

	/**
	 * Retourne la liste de tous les mots
	 * 
	 * @return List de Mots
	 */
	@Override
	public List<Mot> recupererMots() {
		return mots;
	}

	/**
	 * Verifie si un mot est déjà dans la liste de mot
	 * 
	 * @param mot
	 * @return boolean
	 */
	@Override
	public boolean appartenirAuMot(String mot) {
		// TODO Auto-generated method stub
		return false;
	}

}
