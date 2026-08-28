package jeu;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Chargement {

    /**
     * Cette méthode permet de charger le jeu,
     * de vérifier si tous les éléments ajoutés
     * sont conformes aux conditions demandées.
     * Et d'ensuite de créer une partie.
     */
    public static Jeu chargerJeu(String nomFichier) throws IOException, FichierIncorrectException {
        /*
         * Cette première partie permet de lire le fichier donné en paramètre.
         */
        // Lecture du fichier
        BufferedReader fichier = new BufferedReader(new FileReader(nomFichier));
        ArrayList<String> carac = new ArrayList<String>();
        String ligne;

        // Ajouts des caractères dans la liste
        while ((ligne = fichier.readLine()) != null) {
            carac.add(ligne);
        }
        fichier.close();

        // Déclaration et initialisations des variables pour la largeur et la hauteur et pour compter le personnage.
        int count_x = 0, count_y = carac.size(), count_perso = 0;

        // On vient récupérer la réelle largeur du jeu.
        for (int i = 0; i < carac.size(); i++) {
            if (count_x < carac.get(i).length()) {
                count_x = carac.get(i).length();
            }
        }
        /**
         * Initialisation des variables pour
         * récupérer les murs
         * pour créer le labyrinthe
         * pour créer les ou la caisse
         * pour créer les ou le dépôt
         * pour créer le perso
         * pour compter le nombre de caisses et le nombre de dépôts
         */
        boolean[][] murs = new boolean[count_x][count_y];
        Labyrinthe laby = new Labyrinthe();
        ListeElements caisse = new ListeElements();
        ListeElements depot = new ListeElements();
        Perso p = new Perso();
        int count_caisse = 0, count_depot = 0;

        // Création et utilisation de la boucle sur la liste des éléments pour vérifier et ajouter chaque élément au bon endroit
        for (int y = 0; y < carac.size(); y++) {
            for (int x = 0; x < carac.get(y).length(); x++) {
                char c = carac.get(y).charAt(x);

                // Si le caractère et un mur, on l'ajoute à la variable de type mur
                if (c == Labyrinthe.getcharMur()) {
                    murs[x][y] = true;
                }

                // Si le caractère et une caisse, on ajoute ses coordonnées à l'élément type caisse et on ajoute 1 au compteur de caisse.
                else if (c == Labyrinthe.getcharCaisse()) {
                    Element e = new Element();
                    e.setX(x); e.setY(y);
                    caisse.ajouterElement(e);
                    count_caisse++;
                }

                // Si le caractère et un dépôt, on ajoute ses coordonnées à l'élément type dépôt et on ajoute 1 au compteur de dépôt.
                else if (c == Labyrinthe.getcharDepot()) {
                    Element e = new Element();
                    e.setX(x); e.setY(y);
                    depot.ajouterElement(e);
                    count_depot++;
                }

                // Si le caractère et un personnage, on modifie les coordonnées de l'élément de type personnage et on ajoute 1 au compteur de personnage.
                else if (c == Labyrinthe.getcharPerso()) {
                    p.setX(x);
                    p.setY(y);
                    count_perso++;
                }

                //  S'il y a un caractère vide, on le détecte, mais on ne veut pas polluer la console.
                else if (c == Labyrinthe.getcharVide()) {
                }

                // S'il y a un caractère inconnu, on lance une exception de type FichierIncorrectException avec un message explicite
                else {
                    throw new FichierIncorrectException("Caractère inconnue trouvé : " + c);
                }
            }
        }
        // Condition pour savoir s'il y a un personnage
        if (count_perso == 0){
            throw new FichierIncorrectException("Aucun personnage n'est disponible pour jouer");
        }

            // Condition pour savoir s'il y a autant de caisses que de dépôts
        if (count_depot != count_caisse) {
            throw new FichierIncorrectException("nombre de dépot incorrect vis à vis du nombre de caisse");
        }

        // Condition pour savoir s'il y a au moins une caisse pour finir le jeu
        if (count_caisse == 0)
            throw new FichierIncorrectException("Jeu impossible, aucune caisse n'est disponible pour jouer");

        // Ajout des murs au labyrinthe
        laby.ajouterMur(murs);

        // Création de la partie
        Jeu partie = new Jeu(p, caisse, depot, laby);

        return partie;
    }
}