package fr.mertzel.ose.modele;
import java.util.* ;

import fr.mertzel.ose.modele.Orientation;
import fr.mertzel.ose.modele.Position;
import fr.mertzel.ose.modele.PlanSalle.Poste;


/** Modèle (MVC) de l'application - Représentation mémoire du plan de salle
 * @since Janvier 2013
 * @author xilim
 * @version 0.2
 */
public class PlanSalle implements Iterable<Poste>{
	private String nom ;
	private List<Poste> postes = new ArrayList<Poste>() ;

	/** Constructeur
	 * @param nom Nom du plan de salle
	 */
	public PlanSalle(String nom) {
		super();
		this.nom = nom;
		System.out.println("plansalle vuep");
	}

	/** Obtenir le nom du plan de salle
	 * @return Nom du plan de salle
	 */
	public String getNom() {
		System.out.println("getnom vuep");
		return nom;
	}

	/** Modifier le nom du plan de salle
	 * @param nom Nouveau nom du plan de salle
	 */
	public void setNom(String nom) {
		System.out.println("setnom  vuep");
		this.nom = nom;
	}
	
	/** Ajouter un poste au plan de salle
	 * @param position Position du nouveau poste
	 * @param orientation Orientation du nouveau poste
	 */
	public void ajouterPoste(Position position,int orientation){
		System.out.println("ajouterposte vuep");
		postes.add(new Poste(position,orientation)) ;
		this.rechercherPostesVisibles() ;
	}
	
	/** Retirer un poste du plan de salle
	 * @param position Position à libérer
	 */
	public void retirerPoste(Position position){
		System.out.println(" retirerpostevuep");
		int indice = this.rechercherPoste(position) ;
		if(indice != -1){
			postes.remove(indice) ;
			this.rechercherPostesVisibles() ;
		}
	}
	
	/** Visualiser sous forme textuelle le plan de salle
	 */
	public void visualiserPostes(){
		System.out.println("visualiseposte vuep");
		int i = 0 ;
		for(Poste poste : postes){
			System.out.println(i+" : "+poste) ;
			i++ ;
		}
	}
	
	/** Rechercher l'indice d'un poste dans le plan de salle
	 * @return Indice du poste recherché
	 */
	public int rechercherPoste(Position position){
		System.out.println("rechercheposte vuep");
		int i = 0 ;
		int indice = -1 ;
		while(i < postes.size() && indice == -1){
			if(position.equals(postes.get(i).getPosition())){
				indice = i ;
			}
			else {
				i++ ;
			}
		}
		return indice ;
	}
	
	/** Savoir si une position est occupée par un poste
	 * @return true si la position est occupée, et false dans le cas contraire
	 */
	public boolean positionOccupee(Position position){
		System.out.println("positionoccuper vuep");
		int indice = this.rechercherPoste(position) ;
		if(indice != -1){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	/** Obtenir la liste des postes
	 * @return Liste des postes
	 */
	public List<Poste> listerPostes(){
		System.out.println("listerposte vuep");
		return this.postes ;
	}
	
	/** Créer, pour chaque poste, la liste des postes visibles
	 */
	private void rechercherPostesVisibles(){
		System.out.println(" rechercheposte vuep");
		for(Poste poste : postes){
			poste.initialiserPostesVisibles() ;
			for(int orientation = Orientation.NORD ; orientation <= Orientation.NORDOUEST ; orientation += 1){
				Position positionCible = Position.voisin(poste.getPosition(),orientation) ;
				if(Position.estPositionValide(positionCible)){
					int indicePosteVoisin = this.rechercherPoste(positionCible) ;
					if(indicePosteVoisin != -1){
						if(Orientation.estVisible(poste.getOrientation(),orientation,postes.get(indicePosteVoisin).getOrientation())){
							poste.ajouterPosteVisible(postes.get(indicePosteVoisin)) ;
						}
					}
				}
			}
		}
	}
	
	public Iterator<Poste> iterator(){
		return this.postes.iterator();
	}
	/** Poste de travail
	 * @since Janvier 2013
	 * @author xilim
	 * @version 0.2
	 */
	public class Poste {
		private List<Poste> postesVisibles ;
		private Position position ;
		private int orientation ;
		
		/** Constructeur
		 * @param position Position du poste dans la salle
		 * @param orientation Orientation du poste
		 */
		public Poste(Position position, int orientation) {
			super() ;
			this.position = position ;
			this.orientation = orientation ;
			this.initialiserPostesVisibles() ;
			System.out.println("poste  vuep");
		}

		/** Obtenir la position du poste
		 * @return Position du poste
		 */
		public Position getPosition() {
			System.out.println("getpositon vuep");
			return position;
		}

		/** Modifier la position du poste
		 * @param position Nouvelle position du poste
		 */
		public void setPosition(Position position) {
			System.out.println("setposition vuep");
			this.position = position;
		}

		/** Obtenir l'orientation du poste
		 * @return Orientation du poste
		 */
		public int getOrientation() {
			System.out.println("getorientation vuep");
			return orientation;
		}

		/** Modifier l'orientation du poste
		 * @param orientation Nouvelle orientation du poste
		 */
		public void setOrientation(int orientation) {
			System.out.println("getorientation vuep");
			this.orientation = orientation;
		}
		
		/** Obtenir une représentation textuelle du poste
		 * @return Représentation textuelle du poste
		 */
		public String toString(){
			System.out.println("tostring posittion orientation vuep");
			return position + " : " + orientation + " : " + this.peutVoir() ;
		}
		
		/** Obtenir la travée du poste
		 * @return La travée du poste
		 */
		public int getTravee(){
			System.out.println("gettravee vuep");
			return this.position.getTravee() ;
		}
		
		/** Obtenir la rangée du poste
		 * @return La rangée du poste
		 */
		public int getRangee(){
			System.out.println("getrangee vuep");
			return this.position.getRangee() ;
		}
		
		/** Savoir si le candidat qui se trouve sur ce poste peut voir l'écran d'un autre poste
		 * @return Visibilité du candidat
		 */
		public boolean peutVoir(){
			System.out.println("peutvoir  vuep");
			if(this.postesVisibles.size() == 0){
				return false ;
			}
			else {
				return true ;
			}
		}
		
		/** Initialiser la liste des postes dont l'écran est visible à partir du poste du candidat
		 */
		public void initialiserPostesVisibles(){
			System.out.println("initialiserpostevisible vuep");
			this.postesVisibles = new ArrayList<Poste>() ;
		}
		
		/** Ajouter un poste visible à partir du poste du candidat
		 * @param poste Poste dont l'écran est visible pas le candidat
		 */
		public void ajouterPosteVisible(Poste poste){
			System.out.println(" ajouterposte vuep");
			this.postesVisibles.add(poste) ;
		}
		
		/** Obtenir la liste des postes dont l'écran est visible à partir du poste du candidat
		 * @return Liste des postes dont l'écran est visible
		 */
		public List<Poste> getPostesVisibles(){
			System.out.println("getpostevisible vuep");
			return this.postesVisibles ;
		}
		
		/** Obtenir le nombre de postes dont l'écran est visible à partir du poste du candidat
		 * @return Nombre de postes dont l'écran est visible
		 */
		public int nbPostesVisibles(){
			System.out.println(" nbpostevisible vuep");
			return this.postesVisibles.size() ;
		}
	}

}
