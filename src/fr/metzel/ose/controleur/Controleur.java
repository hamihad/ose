package fr.metzel.ose.controleur;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JOptionPane;

import fr.mertzel.ose.modele.Orientation;
import fr.mertzel.ose.modele.PlanSalle;
import fr.mertzel.ose.modele.Position;
import fr.mertzel.ose.vue.FenetrePrincipale;
import fr.mertzel.ose.vue.Parametres;


/** Contrôleur (MVC) de l'application
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class Controleur implements MouseListener, ActionListener {

	private FenetrePrincipale vue ;
	private PlanSalle modele ;
	private Position position ;
	
	/** Constructeur
	 * @param vue Fenetre principale
	 * @param modele Modèle (MVC) - Plan de la salle
	 */
	public Controleur(FenetrePrincipale vue,PlanSalle modele) {
		this.vue = vue ;
		this.modele = modele ;
		vue.getItemOuvrir().addActionListener(this) ;
		vue.getItemEnregistrer().addActionListener(this) ;
		vue.getItemQuitter().addActionListener(this) ;
		vue.getItemPlacerNord().addActionListener(this) ;
		vue.getItemPlacerEst().addActionListener(this) ;
		vue.getItemPlacerSud().addActionListener(this) ;
		vue.getItemPlacerOuest().addActionListener(this) ;
		vue.getItemRetirer().addActionListener(this) ;
		vue.getPlan().addMouseListener(this) ;
		vue.getItempurger().addActionListener(this) ;
		vue.getItemnommer().addActionListener(this) ;
	}
	
	/** Traiter les événements liés au menu de l'application
	 * @param evt Evénement à traiter
	 */
	public void actionPerformed(ActionEvent evt){
		System.out.println("Controleur::actionPerformed()");
		Object source = evt.getSource() ;
		if(source == vue.getItemOuvrir()){
			System.out.println("Ouvrir") ;
		}
		else if(source == vue.getItemEnregistrer()){
			System.out.println("Enregistrer") ;
	
		}
	
	else if(source == vue.getItempurger()){
		System.out.println("purger") ;
		modele.purger();
		}
	else if(source == vue.getItemnommer()){
		System.out.println("nommer") ;
		modele.setNom ("nom");
		String retour = JOptionPane.showInputDialog(vue, "le message", "VALEUR INITIALE");
		modele.setNom (retour);
		}
	
		else if(source == vue.getItemQuitter()){
			System.out.println("Quitter") ;
			System.exit(0) ;
		}
		else if(source == vue.getItemPlacerNord()){
			modele.ajouterPoste(this.position,Orientation.NORD) ;
		}
		else if(source == vue.getItemPlacerEst()){
			modele.ajouterPoste(this.position,Orientation.EST) ;
		}
		else if(source == vue.getItemPlacerSud()){
			modele.ajouterPoste(this.position,Orientation.SUD) ;
		}
		else if(source == vue.getItemPlacerOuest()){
			modele.ajouterPoste(this.position,Orientation.OUEST) ;
		}
		else if(source == vue.getItemRetirer()){
			modele.retirerPoste(this.position) ;
		}
		vue.visualiserPlan() ;
	}
	
	public void mouseClicked(MouseEvent evt){
	}
	
	/** Afficher le menu contextuel dans la représentation graphique du plan de salle
	 * @param evt Evénement associé au bouton de la souris
	 */
	public void mousePressed(MouseEvent evt){
		Object source = evt.getSource() ;
		if(source == vue.getPlan()){
			if(evt.isPopupTrigger()){
				int rangee = evt.getY() / Parametres.HAUTEUR_RANGEE ;
				int travee = evt.getX() / Parametres.LARGEUR_TRAVEE ;
				this.position = new Position(rangee,travee) ;
				vue.afficherMenuContextuel(evt.getX(),evt.getY()) ;
			}
		}
	}
	
	public void mouseReleased(MouseEvent evt){
	}
	
	public void mouseEntered(MouseEvent evt){
	}
	
	public void mouseExited(MouseEvent evt){
	}
}
