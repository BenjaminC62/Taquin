/**
 * Ce logiciel est distribué à des fins éducatives.
 *
 * Il est fourni "tel quel", sans garantie d’aucune sorte, explicite
 * ou implicite, notamment sans garantie de qualité marchande, d’adéquation
 * à un usage particulier et d’absence de contrefaçon.
 * En aucun cas, les auteurs ou titulaires du droit d’auteur ne seront
 * responsables de tout dommage, réclamation ou autre responsabilité, que ce
 * soit dans le cadre d’un contrat, d’un délit ou autre, en provenance de,
 * consécutif à ou en relation avec le logiciel ou son utilisation, ou avec
 * d’autres éléments du logiciel.
 *
 * (c) 2022-2023 Romain Wallon - Université d'Artois.
 * Tous droits réservés.
 */

package fr.univartois.butinfo.ihm.taquin;

import java.net.URL;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;

/**
 * La classe TaquinController propose un contrôleur permettant de gérer un jeu du Taquin
 * présenté à l'utilisateur sous la forme d'une interface graphique JavaFX.
 *
 * @author Romain Wallon
 *
 * @version 0.1.0
 */
public class TaquinController {

    /**
     * Le label affichant le nombre de déplacements réalisés par l'utilisateur.
     */
    @FXML
    private Label nbMoves;

    /**
     * La grille affichant les boutons permettant de jouer au Taquin.
     */
    @FXML
    private GridPane gridPane;

    /**
     * Les boutons représentant les tuiles du jeu du Taquin.
     */
    private Button[][] buttons;

    /**
     * Le modèle du Taquin avec lequel ce contrôleur interagit.
     */
    private Taquin taquin;

    /**
     * Associe à ce contrôleur la partie du jeu du Taquin en cours.
     *
     * @param taquin La partie du Taquin avec laquelle interagir.
     */
    public void setModel(Taquin taquin) {
        this.taquin = taquin;
    }

    /**
     * Initialise la grille du Taquin affichée par ce contrôleur.
     *
     * @param grid La grille du jeu.
     */
    public void initGrid(Grid grid) {
        // TODO Créez vos boutons dans cette méthode.
    }

    /**
     * Met à jour l'affichage du nombre de déplacements.
     *
     * @param nb Le nombre de déplacements.
     */
    public void updateMoves(int nb) {
        this.nbMoves.setText(Integer.toString(nb));
    }

    /**
     * Met à jour la grille du Taquin affichée par ce contrôleur.
     *
     * @param grid La grille du jeu.
     */
    public void updateGrid(Grid grid) {
        for (int i = 0; i < grid.size(); i++) {
            for (int j = 0; j < grid.size(); j++) {
                buttons[i][j].setText(Integer.toString(grid.get(i, j).getValue()));
            }
        }
    }

    /**
     * Prépare une nouvelle partie sur la vue.
     */
    public void startGame() {
        int size = buttons.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setDisable(false);
            }
        }
    }

    /**
     * Redémarre le jeu affiché sur la vue.
     */
    @FXML
    public void restart() {
        taquin.restartGame();
    }

    /**
     * Termine la partie en cours sur la vue.
     */
    public void endGame() {
        int size = buttons.length;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                buttons[i][j].setDisable(true);
            }
        }
    }

    /**
     * Détermine l'arrière-plan de la tuile ayant l'indice donné.
     *
     * @param index L'indice de la tuile.
     *
     * @return L'arrière-plan associé à la tuile.
     */
    private Background createBackground(Number index) {
        URL urlImage = getClass().getResource("../images/iut-" + index + ".jpg");
        BackgroundImage backgroundImage = new BackgroundImage(
                new Image(urlImage.toExternalForm(), 100, 100, true, false),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        return new Background(backgroundImage);
    }

}
