public class Retorno {
    public static void main(String[] args) {
        //uso de return para métodos
        int resultado = soma(32, 10);
        System.err.println("Resultado: "+resultado);
    }

    static int soma(int a,int b){
        return a+b;
    }
}
