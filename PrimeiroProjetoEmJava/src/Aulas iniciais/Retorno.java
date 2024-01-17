public class Retorno {
    public static void main(String[] args) {
        //uso de return para métodos
        int resultado = soma(32, 10);
        //uso de return dentro de um ternary op.
        boolean isTrue = (resultado>100)?true:false;
        System.err.println("Resultado: "+resultado);
        System.err.println("Resultado: "+isTrue);
    }

    static int soma(int a,int b){
        return a+b;
    }
}
