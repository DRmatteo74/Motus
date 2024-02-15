package fr.esgi.business;

import java.util.Objects;

public class Mot {
	// attribut
	private Long id;
	private String mot;
	private int longueurMot;

	private static Long compteur = 0L;

	// constructeur
	public Mot() {
		id = compteur++;
	}

	public Mot(String mot, int longueurMot) {
		this();
		this.mot = mot;
		this.longueurMot = longueurMot;
	}

	// getter setter
	public Long getId() {
		return id;
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public int getLongueurMot() {
		return longueurMot;
	}

	public void setLongueurMot(int longueurMot) {
		this.longueurMot = longueurMot;
	}

	// hash code equals
	@Override
	public int hashCode() {
		return Objects.hash(id, longueurMot, mot);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mot other = (Mot) obj;
		return Objects.equals(id, other.id) && longueurMot == other.longueurMot && Objects.equals(mot, other.mot);
	}

	// to string
	@Override
	public String toString() {
		return "Mot [id=" + id + ", mot=" + mot + ", longueurMot=" + longueurMot + "]";
	}

}
