public class Main {

    public static void main(String[] args) {
        Yinsh yinsh = new Yinsh();

        //Test histoire1
        System.out.println(yinsh.current_color());

        //Test histoire2

        //yinsh.plateau_jeu[1][1]=1;
        //yinsh.plateau_jeu[0][0]=1;


        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(yinsh.put_marker("e", 3, "black")[i][j]);
            }

            System.out.println("");

        }


    }
}
