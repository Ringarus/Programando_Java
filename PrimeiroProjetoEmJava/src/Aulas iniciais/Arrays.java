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
        for(int i=0;i<5;i++){
            System.err.printf("Minha moto é: %s\nMeu carro é: %s\n\n",motos[i],carros[i]);
        }
    }
}
