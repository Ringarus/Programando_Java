package Basico;
/**
 * RótulosLabels
 */
public class RótulosLabels {

    public static void main(String[] args) {
        //É como se você estivesse dando nome para um bloco de loops aninhados
        outerLoop:
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.printf("Valor de i:%d\nValor de j:%d\n\n",i,j);
                if (i * j > 6) {
                    System.out.println("Sai do loop externo.");
                    break outerLoop;
                }
            }
        }

    }
}