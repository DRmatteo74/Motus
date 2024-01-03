package fr.esgi.service;

import fr.esgi.business.Mot;
import java.util.List;

public interface MotService {
	void importerMot();

	Mot recupererMot(String nom);

	Mot recupererMotParId(Long id);

	Mot recupererMotAleatoire();

	List<Mot> recupererMots();

	Mot ajouterMot(Mot mot);

}
