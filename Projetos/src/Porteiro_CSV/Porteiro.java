package Porteiro_CSV;

import java.util.ArrayList;

public class Porteiro {

    //COLUNAS : Andar,Apartamento,Ocupado,Proprietario,Moradores,TelContato,Email

    // O porteiro vai ser responsável por excluir, adicionar e alterar dados

    public static void main(String[] args) {
        //Como não existia necessidade de orientação a objetos criei tudo estático
        //Admer.adicionar("5","501","true","Valerio","Valerio","21999999999","vhyst@gmail.com");
        ArrayList<String[]> tabela = Interno.pesquisar("1","101");
        Interno.exibirTabelaFormatada(tabela);
    }

    
}
