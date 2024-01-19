package Basico;
public class EstruturasDeDados {
    /*
     * For each
     *  Itera uma lista pegando cada elemento um a um e realizando alguma operação
     * as operações não são definitivas e se mantém apenas ao escopo do loop
     */
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        for (int numero : numeros) {
            numero=2;
            System.out.println(numero*2);
        }
        for (int numero : numeros) {
            System.out.println(numero*2);
        }
    }
}
