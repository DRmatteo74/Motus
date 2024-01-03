package fr.esgi.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Joueur {

    // attribut
    private Long id;
    private String pseudo;
    private List<Partie> parties = new ArrayList<>();
    private static Long compteur = 0L;

    // constructeur
    public Joueur(){
        id = ++compteur;
    }
    public Joueur(String pseudo, List<Partie> parties) {
        this();
        this.pseudo = pseudo;
        this.parties = parties;
    }

    // getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public List<Partie> getParties() {
        return parties;
    }

    public void setParties(List<Partie> parties) {
        this.parties = parties;
    }

    // equal hashcode
    @Override
    public int hashCode() {
        return Objects.hash(id, parties, pseudo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Joueur other = (Joueur) obj;
        return Objects.equals(id, other.id) && Objects.equals(parties, other.parties)
                && Objects.equals(pseudo, other.pseudo);
    }

    // to string
    @Override
    public String toString() {
        return "Joueur [id=" + id + ", pseudo=" + pseudo + ", parties=" + parties + "]";
    }
}