import junit.framework.*;


public class MonTest extends TestCase {

	public MonTest(String name) {super(name);}

	/*1)########## Test histoir1 ##########*/
	public void test_Histoire1() {
		Yinsh a = new Yinsh();

		assertTrue(a.current_color() == Couleur.BLACK || a.current_color() == Couleur.WHITE);
	}

	/*2)########## Test histoire2 ##########*/
	public void test_Histoire2() {
		Yinsh a = new Yinsh();

		int resulat[] = a.put_ring("D",5,"BLACK");//resultat[0]=clr, resultat[1]=nb_zeros, resultat[2]=nb_anneaux
		/*Vérification qu'à l'appel de la méthode, il existe bien un anneau sur l'intersection*/
		//Si un anneau BLANC est placé à l'intersection (i,j) alors plateau_jeu[i][j]==0
		//Si c'est anneau BLACK, alors plateau_jeu[i][j]==1;
		assertTrue((resulat[0]==0 || resulat[0]==1));
		//Vérification si à l'état initial il n'ya aucun anneau (nb_zeros=121), après l'appel nb_anneau=1
		assertTrue(resulat[1]==121 && resulat[2]==1);
		
	}
	
	/*3)########## Troisième histoire ##########*/
	public void test_Histoire3() {
		Yinsh a = new Yinsh();

		assertTrue(a.put_ring("D",5,"BLACK")[0]==0 || a.put_ring("D",5,"WHITE")[0]==1);
	}
	
	/*4)########## Quatrième histoire ##########*/
	public void test_Histoire4() {
		Yinsh a = new Yinsh();

		assertTrue(a.is_initialized()==true || a.is_initialized()==false);
	}
	
	/*5)########## Cinquième histoire ##########*/
	public void test_Histoire5() {
		Yinsh a = new Yinsh();

		assertTrue(a.put_marker("D",2,"BLACK")[3][2]==0);
	    assertTrue(a.move_ring("D",2,"D", 5, "BLACK")[3][5]==0 ||a.put_ring("D",5,"BLACK")[0]==0);
		//assertTrue(a.put_marker("D",2,"BLANC")[3][2]==1 || a.put_marker("D", 3, "BLACK")[3][3]==0 );
		assertTrue(a.put_marker("D",2,"BLACK")[3][2]==0 && a.put_ring("D",6,"BLACK")[0]==0);
		assertTrue(a.put_marker("D",2,"BLACK")[3][2]==0 && a.put_ring("D",7,"BLACK")[0]==0);
		
	}
	
	/*6)########## Cinquième histoire ##########*/
	public void test_Histoire6() {
		Yinsh a = new Yinsh();
		
		assertTrue(a.put_marker("E",4,"BLACK")[4][4]==0);
		assertTrue(a.put_marker("E",6,"BLACK")[4][6]==0);
		assertTrue(a.put_marker("E",7,"BLACK")[4][7]==0);
		assertTrue(a.put_marker("E",9,"BLACK")[4][9]==0);
	  //assertTrue(a.put_marker("E",5,"BLANC")[4][5]==1 || a.put_ring("E",5,"BLANC")[0]==1);
	  //assertTrue(a.put_marker("E",8,"BLANC")[4][8]==1 || a.put_ring("E",5,"BLANC")[0]==1);
		
	}
	
	/*7)########## Septième histoire ##########*/
	public void test_Histoire7() {
		Yinsh a = new Yinsh();
		
		assertTrue(a.remove_row("E",6,"I",10)[3][6] !=0 || a.remove_row("E",6,"I",10)[3][6] !=1);
		
	}
	
	/*8)########## Huitième histoire ##########*/
	public void test_Histoire8() {
		Yinsh a = new Yinsh();
		
		for (int i=0;i<11;i++){
			for (int j=0;j<11;j++){
				System.out.print(a.put_marker("E",2,"BLACK")[i][j]);
			/*System.out.print(a.put_marker("E",10,"BLACK")[i][j]);
				System.out.print(a.put_marker("D",4,"WHITE")[i][j]);
				System.out.print(a.put_marker("F",4,"WHITE")[i][j]);
				System.out.print(a.put_marker("G",4,"White")[i][j]);
				System.out.print(a.put_marker("H",4,"BLACK")[i][j]);
				System.out.print(a.put_marker("I",4,"BLACK")[i][j]);
				System.out.print(a.put_marker("F",5,"BLACK")[i][j]);
				System.out.print(a.put_marker("E",2,"WHITE")[i][j]); */
			}
			System.out.println("");
		}
	}
	
	
	

}
