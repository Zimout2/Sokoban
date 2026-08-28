package jeu;

import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TestChargement {
    @Test
    /**
     * Vérification de l'écriture des méthodes
     */
    public void verificationcaratereinconnueJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_caractere.txt");
        });
    }
    @Test
    public void verificationcaisseenplusJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_caisse_en_plus.txt");
        });
    }
    @Test
    public void verificationcaisseenmoinsJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_caisse_en_moins.txt");
        });
    }
    @Test
    public void verificationdepotenmoinsJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_depot_en_moins.txt");
        });
    }
    @Test
    public void verificationdepotenplusJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_depot_en_plus.txt");
        });
    }
    @Test
    public void verificationaucunecaissesJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_aucune_caisse.txt");
        });
    }
    @Test
    public void verificationaucunpersoJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_aucun_perso.txt");
        });
    }
    @Test
    public void verificationaucundepotJeu() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_test_aucun_depot.txt");
        });
    }
    @Test
    public void verificationjeuVide() throws IOException{
        assertThrows(FichierIncorrectException.class, () -> {
            Chargement.chargerJeu("laby/laby_vide.txt");
        });
    }
}