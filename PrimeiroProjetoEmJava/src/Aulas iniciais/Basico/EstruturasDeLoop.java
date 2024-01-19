package Basico;
public class EstruturasDeLoop {
    /*
     * Agora irei treinar estruturas de loop como While, For e o Switch
     */
    public static void main(String[] args) {
        // escrever uma variável em caps locks significa que ela não deve ser modificada
        int NUM10 = 10;
        int i = 0;
        while(i!=NUM10){
            i++;
            System.out.printf("O número é %d\n", i);
        }

        for(i=10;i>0;i--){
            System.out.printf("VOLTANDO %d\n", i);
        }

        switch (NUM10) {
            case 10:
                System.out.println("\n\nÉ 10");
                break;
        
            default:
             System.out.println("\n\nNÃO É 10");
                break;
        }

    }
}
