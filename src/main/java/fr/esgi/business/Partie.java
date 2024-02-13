package fr.esgi.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Partie {

	// constructeur
	private Long id;
	private Difficulte difficulte;
	private List<Question> questions = new ArrayList<>();
	private Joueur joueur;
	private static Long compteur = 0L;

	// constructeur
	public Partie() {
		id = ++compteur;
	}

	public Partie(Difficulte difficulte, Joueur joueur) {
		this();
		this.difficulte = difficulte;
		this.joueur = joueur;
	}

	public Partie(Difficulte difficulte, List<Question> questions, Joueur joueur) {
		this();
		this.difficulte = difficulte;
		this.questions = questions;
		this.joueur = joueur;
	}

	// getter setter
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	// equal hashcode
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Partie partie = (Partie) o;
		return Objects.equals(id, partie.id) && difficulte == partie.difficulte
				&& Objects.equals(questions, partie.questions) && Objects.equals(joueur, partie.joueur);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, difficulte, questions, joueur);
	}

	// to string
	@Override
	public String toString() {
		return "Partie [id=" + id + ", difficulte=" + difficulte + ", questions=" + questions
				+ "]";
	}
}
