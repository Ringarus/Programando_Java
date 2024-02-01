package Porteiro_CSV;

import java.util.ArrayList;
import java.util.Arrays;

public class teste {
    public static void main(String[] args) {
        ArrayList<String[]> listaOrganizada = new ArrayList<String[]>();
        String[] adico = {"PAcco","Lucio","Trema"};
        String[] adica = {"PAcco","Lucio","Jinx"};
        listaOrganizada.add(adico);
        listaOrganizada.add(adica);
        ArrayList<String[]> listaOrganizada2 = new ArrayList<String[]>();
        listaOrganizada2.add(listaOrganizada.get(0));
        System.out.println(Arrays.toString(listaOrganizada2.get(0)));

    }
}
