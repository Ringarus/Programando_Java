
public class OutrasEstruturas {
    /*
     * Agora vou treinar outras estruturas:
     *  - Do While
     *  - Break e continue
     *  - Labels (Rótulos)
     *  - Assert
     *  - Try-catch-finally
     */


    public static void main(String[] args) {
        
        /*      DO WHILE -> primeiro executa o bloco e depois verifica a condição
         * útil para quando a gente precisa que o bloco execute ao mínimo uma vez.
         */
        int contador = 0;
        do {
            System.out.println("CONTANDO!");
        } while (contador > 10);

        /*  break e continue -> O break serve para interromper uma estrutura de repetição
         *  como um loop for ou while enquanto o continue serve para pular aquela iteração
         *  e passar para a próxima.
         */
        // Contando apenas os pares e quando chega ao 9 ele para.
        for(int i=0;i<100;i++){
            if(i==9) break;
            if(i%2!=0){
                continue;
            } else {
                System.out.println("O número " + i + " é par");
            }

        }

    }
}
