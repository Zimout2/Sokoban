package jeu;

/**
 * Classe permettant de savoir et de modifier les coordonnées des éléments
 */
public class Element {

    // Initialisation des attributs qui sont les coordonnés de la largeur et de la hauteur
    private int x, y;

    /**
     * Méthode permettant de retourner l'indice de la largeur
     *
     * @return un nombre qui indique l'indice de la largeur
     */
    public int getX() {
        return x;
    }

    /**
     * Méthode permettant de retourner l'indice de la hauteur
     *
     * @return un nombre qui indique l'indice de la hauteur
     */
    public int getY() {
        return y;
    }

    /**
     * Méthode permettant de modifier l'indice de la largeur
     * @param new_x nouvel indice de la largeur
     */
    public void setX(int new_x) {
        x = new_x;
    }

    /**
     * Méthode permettant de modifier l'indice de la hauteur
     * @param new_y nouvel indice de la hauteur
     */
    public void setY(int new_y) {
        y = new_y;
    }
}
