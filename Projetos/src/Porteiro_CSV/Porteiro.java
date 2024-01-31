package Porteiro_CSV;

import org.omg.PortableInterceptor.AdapterNameHelper;

public class Porteiro {

    //COLUNAS : Andar,Apartamento,Ocupado,Proprietario,Moradores,TelContato,Email

    // O porteiro vai ser responsável por excluir, adicionar e alterar dados

    public static void main(String[] args) {
        Admer adm = new Admer();
        adm.exibirTabelaFormatada();
    }

    
}
