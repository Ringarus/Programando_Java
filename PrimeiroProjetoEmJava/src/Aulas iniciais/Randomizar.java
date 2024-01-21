import java.util.Random;

public class Randomizar {
    
    public static void main(String[] args) {
        Random random = new Random();
        //gera numeros aleatorios entre 2 bilhoes negativos e positivos
        int x = random.nextInt();
        //com argumento gera numeros de 0 até o argumento-1
        int y = random.nextInt(5);
        //se quiser que ele faça de 1 até o argumento é só +1
        int z = random.nextInt(5)+1;
        System.out.printf("X: %d\nY: %d\nZ: %d\n",x,y,z);
    }
}
