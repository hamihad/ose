package fr.mertzel.ose.modele;

import java.util.ArrayList;

import fr.mertzel.ose.vue.Observateur;

abstract class SujetObserver {
	
	private ArrayList<Observateur> lesObservateur = new ArrayList<Observateur>();
	
	public void ajouter(Observateur observateur){
		System.out.println("SujetObserver::ajouter") ;
		lesObservateur.add(observateur);
	}
	
	public void supprime(Observateur observateur){
		lesObservateur.remove(observateur) ;
	}
 
	public void notifier(){
		System.out.println("SujetObserve::notifier()");
		for (Observateur observateur :lesObservateur){
			observateur.actualiser();
		}
	}

}
