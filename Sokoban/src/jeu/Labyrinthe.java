package jeu;

import java.util.List;

/**
 * Classe permettant de créer et d'identifier un labyrinthe
 */
public class Labyrinthe {
    // Initialisation des attributs, murs, caisse, pj, depôt et vide du labyrinthe
    private boolean[][] murs;
    public final static char MUR = '#', CAISSE = '$', PJ = '@', DEPOT = '.', VIDE = ' ';

    /**
     * Méthode permettant de retourner un boolean [][] de murs
     *
     * @return un murs[][]
     */
    public boolean[][] getMur() {
        return this.murs;
    }

    /**
     * Méthode permettant de retourner le caractère de type mur
     *
     * @return le caractère mur
     */
    public static char getcharMur() {
        return MUR;
    }

    /**
     * Méthode permettant de retourner le caractère de la caisse
     * @return le caractère caisse
     */
    public static char getcharCaisse() {
        return CAISSE;
    }

    /**
     * Méthode permettant de retourner le caractère du personnage
     * @return le caractère personnage
     */
    public static char getcharPerso() {
        return PJ;
    }

    /**
     * Méthode permettant de retourner le caractère dépôt
     *
     * @return le caractère dépôt
     */
    public static char getcharDepot() {
        return DEPOT;
    }

    /**
     * Méthode permettant de retourner le caractère vide
     * @return le caractère vide
     */
    public static char getcharVide() {
        return VIDE;
    }

    /**
     * Méthode permettnt de dire si le caratère en x, y est bien un mur
     * @param x indice de la colonne
     * @param y indice de la ligne
     *
     * @return un boolean permettant de dire si les coordonnées correspondent à un mur
     */
    public boolean etreMur(int x,int y) {
        if (x < 0 || x >= this.getMur().length || y < 0 || y >= this.murs[0].length) {
            return true;
        }
        return this.murs[x][y];
    }

    /**
     * Méthode pour ajouter un boolea de type murs, à l'attribut murs
     * @param m boolean[][] à ajouter à l'attribut
     */
    public void ajouterMur(boolean[][] m) {
        this.murs = m;
    }
}
