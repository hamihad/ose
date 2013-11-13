package fr.mertzel.ose.modele;

import fr.mertzel.ose.vue.Parametres;

/** Position des postes de travail
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
 public class Position {
	private int rangee ;
	private int travee ;
	
	/** Constructeur
	 * @param rangee Rangée
	 * @param travee Travée
	 */
	public Position(int rangee, int travee) {
		super();
		this.rangee = rangee;
		this.travee = travee;
		System.out.println(" position modele");
	}
	
	/** Contructeur (position non définie)
	 */
	public Position() {
		super();
		this.rangee = -1;
		this.travee = -1;
	}
	
	/** Obtenir la rangee d'une position
	 * @return Rangée de la position
	 */
	public int getRangee() {
		System.out.println(" getrangee modele");
		return rangee;
	}
	
	/** Modifier la rangee d'une position
	 * @param rangee Nouvelle rangée
	 */
	public void setRangee(int rangee) {
		System.out.println(" setrangee modele");
		this.rangee = rangee;
	}
	
	/** Obtenir la travée d'une position
	 * @return Travée d'une position
	 */
	public int getTravee() {
		System.out.println("gettravee  modele");
		return travee;
	}
	
	/** Modifier la travée d'une position
	 * @param travee Nouvelle travée
	 */
	public void setTravee(int travee) {
		System.out.println(" settravee modele");
		this.travee = travee;
	}
	
	/** Comparer deux positions
	 * @param position Position à comparer
	 * @return true si les deux positions sont identiques et false dans le cas contraire
	 */
	public boolean equals(Position position){
		System.out.println(" equalposition  modele");
		if(this.rangee == position.rangee && this.travee == position.travee){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Obtenir une représentation textuelle d'une position
	 * @return Représentation textuelle d'une position
	 */
	public String toString(){
		System.out.println("tosring rangee travee  modele");
		return "("+rangee+","+travee+")" ;
	}
	
	/** Obtenir la position voisinne
	 * @param origine Position d'origine
	 * @param orientation Orientation par rapport à la position d'origine
	 * @return Position voisinne
	 */
	public static Position voisin(Position origine,int orientation){
		System.out.println(" position voisin  modele");
		Position position = new Position() ;
		switch(orientation){
			case Orientation.NORD :
				position.setRangee(origine.getRangee()-1) ;
				position.setTravee(origine.getTravee()) ;
				break ;
			case Orientation.NORDEST :
				position.setRangee(origine.getRangee()-1) ;
				position.setTravee(origine.getTravee()+1) ;
				break ;
			case Orientation.EST :
				position.setRangee(origine.getRangee()) ;
				position.setTravee(origine.getTravee()+1) ;
				break ;
			case Orientation.SUDEST :
				position.setRangee(origine.getRangee()+1) ;
				position.setTravee(origine.getTravee()+1) ;
				break ;
			case Orientation.SUD :
				position.setRangee(origine.getRangee()+1) ;
				position.setTravee(origine.getTravee()) ;
				break ; 
			case Orientation.SUDOUEST :
				position.setRangee(origine.getRangee()+1) ;
				position.setTravee(origine.getTravee()-1) ;
				break ;
			case Orientation.OUEST :
				position.setRangee(origine.getRangee()) ;
				position.setTravee(origine.getTravee()-1) ;
				break ;
			case Orientation.NORDOUEST :
				position.setRangee(origine.getRangee()-1) ;
				position.setTravee(origine.getTravee()-1) ;
				break ;
		}
		return position ;
	}
	
	/** Vérifier la validité d'une postion
	 * @param position Position à vérifier
	 * @return true si la position est valide et false dans le cas contraire
	 */
	public static boolean estPositionValide(Position position){
		if(position.travee >= 0 && position.travee < Parametres.NB_TRAVEES && position.rangee >= 0 && position.rangee < Parametres.NB_RANGEES){
			return true ;
		}
		else {
			return false ;
		}
	}
}
