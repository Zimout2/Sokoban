package jeu;

import java.util.List;

/**
 * Classe permettant d'afficher,
 * de modifier la position,
 * de déplacer,
 * de signifier la fin du jeu
 * et tout simplement de définir les règles du jeu
 */
public class Jeu {
    // Initialisation des attributs perso, caisses, dépôts, labyrinthe et des actions à faire
    private Perso perso;
    private ListeElements caisses, depots;
    private Labyrinthe laby;
    public final static String HAUT = "HAUT", BAS = "BAS", GAUCHE = "GAUCHE", DROITE = "DROITE";

    /**
     * Constructeur permettant l'initialisation des attributs avec les paramètres donnés
     *
     * @param p personnage donné
     * @param c élément de type caisse donné
     * @param d élément de type dépôt donné
     * @param l élément de type labyrinthe
     **/
    public Jeu(Perso p, ListeElements c, ListeElements d, Labyrinthe l) {
        this.perso = p;
        this.caisses = c;
        this.depots = d;
        this.laby = l;
    }

    /**
     * Méthode permettant de retourner le perso du jeu
     *
     * @return le perso du jeu
     **/
    public Perso getPj() {
        return this.perso;
    }

    /**
     * Méthode permettant de retourner la direction gauche
     *
     * @return la direction gauche
     **/
    public String getGauche() {
        return Jeu.GAUCHE;
    }

    /**
     * Méthode permettant de retourner la direction droite
     *
     * @return la direction droite
     **/
    public String getDroite() {
        return Jeu.DROITE;
    }

    /**
     * Méthode permettant de retourner la direction haut
     *
     * @return la direction haut
     **/
    public String getHaut() {
        return Jeu.HAUT;
    }

    /**
     * Méthode permettant de retourner la direction bas
     *
     * @return la direction bas
     **/
    public String getBas() {
        return Jeu.BAS;
    }

    /**
     * Méthode permettant d'afficher les caractères du jeu
     *
     * @return La concaténation de caractères affichés à la console
     **/
    public String jeuToString() {
        String coor = "";
        boolean[][] murs = laby.getMur();
        for (int y = 0; y < murs[0].length; y++) {
            for (int x = 0; x < murs.length; x++) {
                if (laby.getMur()[x][y]) {
                    coor += Labyrinthe.getcharMur();
                }
                else if (this.perso.getX() == x && this.perso.getY() == y) {
                    coor += Labyrinthe.getcharPerso();
                }
                else if (this.caisses.existe(x, y)) {
                    coor += Labyrinthe.getcharCaisse();
                }
                else if (this.depots.existe(x, y)) {
                    coor += Labyrinthe.getcharDepot();
                }
                else {
                    coor += " ";
                }
            }
            coor += "\n";
        }
        return coor;
    }

    /**
     * Méthode permettant de déplacer l'objet dans le tableau de coordonnées x, y en fonction de l'action demandée
     *
     * @param x est la colonne à modifier
     * @param y ets la ligne à modifier
     * @param action est l'action demandée par l'utilisateur
     *
     * @return les nouvelles coordonnées une fois modifié
     **/
    public int[] getSuivant(int x, int y, String action) {
        int[] rep = new int[]{x, y};
        if (action.equals(this.getHaut())) {
            y--;
            rep[1] = y;        }
        if (action.equals(this.getBas())) {
            y++;
            rep[1] = y;
        }
        if (action.equals(this.getGauche())) {
            x--;
            rep[0] = x;
        }
        if (action.equals(this.getDroite())) {
            x++;
            rep[0] = x;
        }
        return rep;
    }
    /**
     * Méthode permettant de déplacer le perso dans l'espace de coordonnées
     *
     * @param action est l'action demandée par l'utilisateur
     * @throws ActionInconnueException identifie si l'action est possible ou non
     **/
    public void deplacerPerso(String action) throws ActionInconnueException{
        action = action.toUpperCase();
        // Déplacement du personnage
        System.out.println("La position actuelle du personnage " + " et : " + perso.getX() + ";" + perso.getY());
        System.out.println();
        int[] coordoSuivante = getSuivant(perso.getX(), perso.getY(), action);
        int x_cible = coordoSuivante[0], y_cible = coordoSuivante[1];

        // Gestion de l'erreur si l'action proposée n'est pas possible
        if (!action.equals(this.getHaut()) && !action.equals(this.getBas()) && !action.equals(this.getGauche()) && !action.equals(this.getDroite())) {
            throw new ActionInconnueException("Mauvaise direction !");
        }

        // Condition pour savoir s'il y a un mur sur la case suivante
        if (laby.etreMur(x_cible, y_cible)) {
            throw new ActionInconnueException("Mauvaise direction, il y a un mur à cet endroit");
        }

        // Condition pour savoir s'il y a une caisse ou un mur derrière la caisse actuelle ou non
        if (this.caisses.existe(x_cible, y_cible)) {
            int[] coordosuivanteCaisse = getSuivant(x_cible, y_cible, action);
            int x_caisse = coordosuivanteCaisse[0], y_caisse = coordosuivanteCaisse[1];
            if (!laby.etreMur(x_caisse, y_caisse) && !this.caisses.existe(x_caisse, y_caisse)) {
                Element caisseapousser = this.caisses.getElement(x_cible, y_cible);
                caisseapousser.setX(x_caisse);
                caisseapousser.setY(y_caisse);
            }
            else {
                throw new ActionInconnueException("Mauvaise direction, la caisse est bloqué");
            }
        }

        // Modification des coordonnées du personnage avec les nouvelles
        perso.setX(x_cible);
        perso.setY(y_cible);

        // Affichage de la nouvelle position du personnage
        System.out.println("Nouvelle position du personnage en : (" + perso.getX() + ";"+ perso.getY() + ")");
        System.out.println();
    }

    /**
     * Méthode permettant de savoir si le jeu est fini ou non
     * @return un boolean informant de l'état actuel du jeu
     */
    public boolean etreFini() {
        for (int i = 0; i < this.caisses.size(); i++) {
            Element caisse = this.caisses.getElementInd(i);

            // Condition pour savoir si les coordonnées du dépots sont aussi celle de la caisse
            if (!this.depots.existe(caisse.getX(), caisse.getY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Méthode permettant d'afficher une phrase de fin au lieu d'un simple boolean
     * @return return un message informant de l'état actuel de la partie
     */
    public String phrasedeFin() {
        String result = "";
        if (etreFini()) {
            result += "Vous avec finis le jeu bravo !";
        }
        else {
            result += "Le jeu n'est pas finis, continuer !";
        }
        return result;
    }
}
