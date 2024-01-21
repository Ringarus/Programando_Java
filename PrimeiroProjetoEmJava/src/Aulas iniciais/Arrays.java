public class Arrays {
    public static void main(String[] args) {
        //como declarar um array? simples, basta usar []
        // Existe dois modos de criar um array
        
        //MODO 1
        String[] motos = {"CB500F","Titan","Meteor 350","Intruder 125"};
        motos[0] = "Fan";

        //MODO 2
        String[] carros = new String[4];
        carros[0] = "Mustang";
        carros[1] = "Corolla";
        carros[2] = "Voyage";
        carros[3] = "Celta";

        //Vendo os resultados
        for(int i=0;i<4;i++){
            System.err.printf("Minha moto é: %s\nMeu carro é: %s\n\n",motos[i],carros[i]);
        }

        //Fazendo array 2D
        int[][] pares = new int[3][3];
        pares[0][0] = 2;
        pares[0][1] = 4;
        pares[0][2] = 6;
        pares[1][0] = 12;
        pares[1][1] = 14;
        pares[1][2] = 16;
        pares[2][0] = 104;
        pares[2][1] = 216;
        pares[2][2] = 512;

        par:
            for (int index = 0; index < pares.length; index++) {
                for (int i = 0; i < pares.length; i++) {
                    System.err.println(pares[index][i]);
                    if(pares[index][i]==216) break par;
                }
            }
    }
}
