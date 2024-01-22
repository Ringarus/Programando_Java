public class Strings {
    //STRINGS SÃO IMUTÁVEIS
    public static void main(String[] args) {
                //Declarando string

        //Com literal
        String nome = "Ney";
        //Com construtor
        String segnome = new String("Júnior");
        System.out.printf("Primeiro nome: %s\nSegundo nome: %s\n",nome,segnome);
                
                //Operações básicas

        //Concatenar
        String completo = nome+" "+segnome;
        System.out.println("Nome completo: "+completo);
        String conc = completo.concat(" Dos Santos");
        System.out.println("Nome inteiro: "+conc);

        //Tamanho da string
        int tamanho = completo.length();
        System.out.println("Tamanho do nome: "+(tamanho-1));

        //Maiúsculo e minúsculo
        String nomeMaiusc = completo.toUpperCase();
        String nomeMinusc = completo.toLowerCase();
        System.out.printf("Maiúsculo: %s\nMinúsculo: %s\n",nomeMaiusc,nomeMinusc);
    
        //Verifica se a string começa ou termina com um argumento em string
        boolean isNey = completo.startsWith("Ney");
        boolean isCabralAtLast = completo.endsWith("Cabral");
        System.err.println(isNey);
        System.out.println(isCabralAtLast);
    
        //Posição que está localizado o argumento
        //Perceba que para uma string ele retorna o primeiro index
        int indexOfComma = completo.indexOf("Júnior");
        int lastIndexOfSpace = completo.lastIndexOf(" ");
        System.err.println(indexOfComma);
        System.out.println(lastIndexOfSpace);

        //Trocar elementos na string
        String mudado = completo.replace("Júnior", "Tafarel");
        String trocaTudo = completo.replaceAll("[aeiou]", "-");
        System.err.println(mudado);
        System.out.println(trocaTudo);

        //Tirar os espaços das pontas
        String comEsp = "       "+completo+"       ";
        System.err.println(comEsp);
        String comTrim = comEsp.trim();
        System.err.println(comTrim);

                //Comparando strings

        //Comparar exatamente retornando true/false
        boolean eoNey = nome.equals("Ney");
        boolean notNey = nome.equals("ney");
        System.out.println(eoNey);
        System.out.println(notNey);
        
        //Comparar ignorando case sensetive
        boolean semCaseCompara = nome.equalsIgnoreCase("ney");
        System.out.println(semCaseCompara);

        /*Compara e retorna 0 se for igual, negativo se o argumento 
        fornecido for lexicograficamente maior e positivo se ele for
        maior que o atual
        */
        int lexicalCompare = nome.compareTo("Ney");
        int lexicalAgain = nome.compareTo("Jafar");
        System.out.println(lexicalCompare);
        System.out.println(lexicalAgain);
    }
}
