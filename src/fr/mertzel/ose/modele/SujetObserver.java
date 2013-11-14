package fr.mertzel.ose.modele;

import java.util.ArrayList;

import fr.mertzel.ose.vue.Observateur;

abstract class SujetObserver {
	
	private ArrayList<Observateur> lesObservateur = new ArrayList<Observateur>();
	
	public void ajouter(Observateur observateur){
		lesObservateur.add(observateur);
	}
	
	public void supprime(Observateur observateur){
		lesObservateur.remove(observateur) ;
	}
 
	public void notifier(){
		for (Observateur observateur :lesObservateur){
			observateur.actualiser();
		}
	}

}
