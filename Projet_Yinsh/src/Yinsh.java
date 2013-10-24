import java.util.*;

public class Yinsh {

   public enum Couleur {BLACK, WHITE }; // Enumération des 2 constantes de couleur
   public enum Colonne {A, B, C, D, E, F, G, H, I, J, K}; //Enumération des lettres désignant les colonnes

	/*2)########## Deuxième histoire ##########*/
	int nb_zeros=0, nb_anneaux=0;
	int[][] plateau_jeu = new int[11][11];

	/* 1)########## Prémière Histoire ##########*/
	public Couleur current_color() {
		Random random = new Random();
		int nbAlea = random.nextInt(2); //nbAlea choisi au hasard et vaut soit 0 soit 1

		if(Couleur.BLACK.ordinal()==nbAlea) //Si nbAlea=0 alors retourne BLACK sinon retourne BLANC
			return(Couleur.BLACK);
		else
			return(Couleur.WHITE);
	}

	public int[] putRing(String lettre, int num, String couleur) {
		//Conversion de lettre et couleur en majuscule pour ne pas se soucier de la casse
		lettre=lettre.toUpperCase(); 
		couleur=couleur.toUpperCase(); 

		//Vérification des coordonnées + levée d'exception
		try {
			Colonne.valueOf(lettre); 
			Couleur.valueOf(couleur);
		}catch (Exception e) { System.out.println("Les coordonnées"+" ("+lettre+","+num+","+couleur+") "+"n'existent pas ");}

		if (num < 0 || num > 11){
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("Les coordonnées"+" ("+lettre+","+num+","+couleur+") "+"n'existent pas ");
			}
		}

		//Conversion de lettre en valeur de type Colonne et de couleur en valeur de type Couleur	
		Colonne colonne = Colonne.valueOf(lettre); 
		Couleur coulr = Couleur.valueOf(couleur);

		int c = colonne.ordinal(); //c appartient à {0,1,2,...,10}
		int clr = coulr.ordinal(); //clr vaut 0 si couleur=BLACK ou 1 si couleur=BLANC 

		//On compte le nombre de zeros pour savoir si le plateau de jeu est vide ou non
		for (int i=0; i<11; i++) {
			for (int j=0; j<11; j++) {
				if (plateau_jeu[i][j]==0)
					nb_zeros +=1;			
			}	
		}		
		//Si le nombre de zeros est 121 alors le plateau de jeu est vide, on met des 3 partout au lieu de 0 par défaut
		//Car le 0 désigne l'anneau BLACK
		if (nb_zeros==121){
			for (int i=0; i<11; i++) {
				for (int j=0; j<11; j++) {
					plateau_jeu[i][j]=3;
				}
			}
			//int plateau_jeu[][] = plateau_jeu[][]; //
		}

		if (plateau_jeu[c][num]!=1 || plateau_jeu[c][num]!=0) {
			plateau_jeu[c][num] = clr;
		}

		else {

			/*3)########## Troisième histoire ##########*/
			System.out.println("L'intersection demandée est déjà occupée");
		}

		//Compteur du nombre d'anneaux placés
		for (int i=0; i<11; i++) {
			for (int j=0; j<11; j++) {
				if (plateau_jeu[i][j]==0 || plateau_jeu[i][j]==1){
					nb_anneaux +=1;
				}
			}
		}

		int resultat[] = {clr,nb_zeros,nb_anneaux};

		return resultat;

	}

	/*4)########## Quatrième histoire ##########*/
	public boolean is_initialized() {
		Yinsh yinsh = new Yinsh();
		int nb_anneaux=0;

		for (int i=0; i<11; i++) {
			for (int j=0; j<11; j++) {
				if (plateau_jeu[i][j]==0 || plateau_jeu[i][j]==1){
					nb_anneaux +=1;
				}
			}
		}

		if (nb_anneaux == 10){
			return true;
		}
		else {
			return false;
		}


	}

	/*5)########## Cinquième histoire ##########*/
	public int[][] put_marker(String lettre, int num, String couleur){
		int nb_markers=0, nb_zeros=0;
		//Conversion de lettre et couleur en majuscule pour ne pas se soucier de la casse
		lettre=lettre.toUpperCase(); 
		couleur=couleur.toUpperCase(); 
		//Vérification des coordonnées + levée d'exception
		try {
			Colonne.valueOf(lettre); 
			Couleur.valueOf(couleur);
		}catch (Exception e) { System.out.println("Les coordonnées"+" ("+lettre+","+num+","+couleur+") "+"n'existent pas ");}

		if (num < 0 || num > 11){
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("Les coordonnées"+" ("+lettre+","+num+","+couleur+") "+"n'existent pas ");
			}
		}
		//Conversion de lettre en valeur de type Colonne et de couleur en valeur de type Couleur	
		Colonne colonne = Colonne.valueOf(lettre); 
		Couleur coulr = Couleur.valueOf(couleur);

		int c = colonne.ordinal(); //c appartient à {0,1,2,...,10}
		int clr = coulr.ordinal(); //clr vaut 0 si couleur=BLACK ou 1 si couleur=BLANC 

		//On compte le nombre de zeros pour savoir si le plateau de jeu est vide ou non
		for (int i=0; i<11; i++) {
			for (int j=0; j<11; j++) {
				if (plateau_jeu[i][j]==0)
					nb_zeros +=1;			
			}	
		}		
		//Si le nombre de zeros est 121 alors le plateau de jeu est vide, on met des 3 partout au lieu de 0 par défaut
		//Car le 0 désigne l'anneau BLACK
		if (nb_zeros==121){
			for (int i=0; i<11; i++) {
				for (int j=0; j<11; j++) {
					plateau_jeu[i][j]=3;
				}
			}
			//int plateau_jeu[][] = plateau_jeu[][]; //
		}

		if (plateau_jeu[c][num]!=1 || plateau_jeu[c][num]!=0) {
			plateau_jeu[c][num] = clr;
		}

		else {

		}


		//Compteur du nombre d'anneaux placés
		for (int i=0; i<11; i++) {
			for (int j=0; j<11; j++) {
				if (plateau_jeu[i][j]==0 || plateau_jeu[i][j]==1){
					nb_markers +=1;
				}
			}
		}

		return plateau_jeu;

	}	

	public int[][] move_ring(String lettre1, int num1, String lettre2, int num2 , String couleur){
		Yinsh yinsh = new Yinsh();
		lettre1 = lettre2;
		num1 = num2;

		yinsh.putRing(lettre2, num2, couleur);

		return plateau_jeu;

	}

	/*6)########## Cinquième histoire ##########*/

	/*7)########## Septième histoire ##########*/
	public int[][]remove_row(String lettre1, int num1, String lettre2, int num2) {
		lettre1=lettre1.toUpperCase(); 
		lettre2=lettre2.toUpperCase();

		//Vérification des coordonnées + levée d'exception
		try {
			Colonne.valueOf(lettre1); 
			Colonne.valueOf(lettre2); 
		}catch (Exception e) { System.out.println("Les coordonnées"+"n'existent pas ");}

		if (num1 < 0 || num1 > 11 || num2 < 0 || num2 > 11){
			try {
				throw new Exception();
			} catch (Exception e) {
				System.out.println("Les coordonnées"+" n'existent pas ");
			}
		}
		//Conversion de lettre en valeur de type Colonne et de couleur en valeur de type Couleur	
		Colonne colonne = Colonne.valueOf(lettre1); 
		Colonne colonne2 = Colonne.valueOf(lettre2);
		int c = colonne.ordinal(); //c appartient à {0,1,2,...,10}

		if (num1 < num2){
			for (int i=num1;i<=num2;i++){
				for (int j=0;j<11;j++){
					plateau_jeu[i][j]=3; // Le 3 désigne une intersection libre	
				}	
			}	

		}else if (num1 > num2){
			for (int i=num1;i<=num2;i++){
				for (int j=0;j<11;j++){
					plateau_jeu[i][j]=3; // Le 3 désigne une intersection libre	
				}	

			}


		}
		return plateau_jeu;

	}

		public int[][]remove_ring(String lettre, int num, String cloleur) {
			lettre=lettre.toUpperCase(); 

			//Vérification des coordonnées + levée d'exception
			try {
				Colonne.valueOf(lettre); 
			}catch (Exception e) { System.out.println("Les coordonnées"+"n'existent pas ");}

			if (num < 0 || num > 11) {
				try {
					throw new Exception();
				} catch (Exception e) {
					System.out.println("Les coordonnées"+" n'existent pas ");
				}
			}
			//Conversion de lettre en valeur de type Colonne et de couleur en valeur de type Couleur	
			Colonne colonne = Colonne.valueOf(lettre); 
			int c = colonne.ordinal(); //c appartient à {0,1,2,...,10}

			plateau_jeu[c][num] = 3;

			return plateau_jeu;


		}
		
		/*8)########## Huitième histoire ##########*/
		

		
		/*9)########## Neuvième histoire ##########*/



	}
