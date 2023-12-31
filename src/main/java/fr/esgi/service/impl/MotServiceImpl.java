package fr.esgi.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import fr.esgi.buisness.Mot;
import fr.esgi.service.MotService;

public class MotServiceImpl implements MotService {

	private static ArrayList<Mot> mots = new ArrayList<>();
	private static Random random = new Random();

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

	@Override
	public Mot recupererMot(String nom) {
		return mots.stream().filter(mot -> mot.getMot().equals(nom)).findFirst().orElse(null);
	}

	@Override
	public Mot ajouterMot(Mot mot) {
		mots.add(mot);
		return mot;
	}

	@Override
	public Mot recupererMotParId(Long id) {
		return mots.stream().filter(mot -> mot.getId().equals(id)).findFirst().orElse(null);
	}

	@Override
	public Mot recupererMotAleatoire() {
		return mots.get(random.nextInt(0, mots.size()));
	}

	@Override
	public List<Mot> recupererMots() {
		return mots;
	}

}
