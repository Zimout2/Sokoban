package jeu;

import java.util.ArrayList;

/**
 * Classe permettant d'ajouter, d'identifier et de chercher des éléments de type Element dans une liste
 */
public class ListeElements extends Element {
    //Initialisation de l'attribut Liste
    private ArrayList<Element> Liste;

    /**
     * Constructeur initialisant la liste Liste
     */
    public ListeElements() {
        Liste = new ArrayList<>();
    }

    /**
     * Méthode permettant de savoir quel est élément se trouvant au coordonnés x, y
     * @param x indice de la colonne
     * @param y indice de la ligne
     *
     * @return élement se trouvant aux coordonnées x, y
     */
    public Element getElement(int x, int y) {
        for (int i = 0; i < Liste.size(); i++) {
            if (Liste.get(i).getX() == x && Liste.get(i).getY() == y) {
                return Liste.get(i);
            }
        }
        return null;
    }

    /**
     * Méthode permettant de savoir s'il y a un élément aux coordonnées x, y ou non via un boolean
     * @param x indice de la colonne
     * @param y indice de la ligne
     *
     * @return boolean informant d'élément à cette position
     */
    public boolean existe(int x, int y) {
        for (int i = 0; i < Liste.size(); i++) {
            if (Liste.get(i).getX() == x && Liste.get(i).getY() == y) {
                return true;
            }
        }
        return false;
    }

    /**
     * Méthode renvoyant la taille de la liste
     *
     * @return la taille de la liste
     */
    public int size() {
        return Liste.size();
    }

    /**
     * Méthode retournant l'indie de l'élément dans la liste
     * @param n indice dans la liste s'il existe
     *
     * @return l'élément se situant à l'indice n de la liste
     */
    public Element getElementInd(int n) {
        if (n >= 0 && n < Liste.size()) {
            return Liste.get(n);
        }
        return null;
    }

    /**
     * Méthode permettant d'ajout un élément à la liste Liste
     * @param e élément à ajouter dans la liste
     */
    public void ajouterElement(Element e) {
        Liste.add(e);
    }
}
