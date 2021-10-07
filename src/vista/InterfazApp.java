package vista;

import java.util.ArrayList;
import mundo.MisionerosS3;
import sss.Actions;
import sss.SearchStateSpaces;

public class InterfazApp {

    public static void main(String[] args) {
        MisionerosS3 misioneros3;

        int Izq[] = {3, 3, 1};
        int Der[] = {0, 0, 0};
        SearchStateSpaces sss;
        ArrayList<Actions> lst;

        System.out.println("MisionerosS3");
        misioneros3 = new MisionerosS3(Izq, Der);
        sss = new SearchStateSpaces("000|   |133", misioneros3, 5);
        lst = sss.solve();

        System.out.println("Número de pasos: " + lst.size());
        
        if (lst.size() > 0) {
            for (int i = 0; i < lst.size(); i++) {
                System.out.println(lst.get(i));
            }
        }else{
            System.out.println("No hay Solucion.");
        }
        
    }
}
