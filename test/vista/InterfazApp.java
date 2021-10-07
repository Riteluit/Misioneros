/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.util.Scanner;
import mundo.Misioneros;

public class InterfazApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inic = 0;

        Misioneros misionero;

        int Izq[];
        int Der[];

        Izq = new int[3];
        Der = new int[3];

        Izq[0] = 3;
        Izq[1] = 3;
        Izq[2] = 1;
        Der[0] = 0;
        Der[1] = 0;
        Der[2] = 0;

        misionero = new Misioneros(Izq,Der);
        System.out.print("Posicion inicial: \n");misionero.ver();

        do {
            switch (inic) {
                case 0:
                    System.out.println("\nMenu \n 1. Mover un Misionero \n 2. Mover un Canibal \n 3. Mover 2 misioneros \n 4. Mover 2 Canibales  "
                            + "\n 5. Mover 1 misionero y 1 canibal \n 6. Salir");
                    System.out.print("Digite la opcion: ");inic = sc.nextInt();
                    break;
                case 1:
                    misionero.unMisionero();
                    misionero.ver();
                    inic = 0;
                    break;
                case 2:
                    misionero.unCanibal();
                    misionero.ver();
                    inic = 0;
                    break;
                case 3:
                    misionero.dosMisioneros();
                    misionero.ver();
                    inic = 0;
                    break;
                case 4:
                    misionero.dosCanibal();
                    misionero.ver();
                    inic = 0;
                    break;
                case 5:
                    misionero.mis_can();
                    misionero.ver();
                    inic = 0;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    inic = 0;
            }
        } while (inic != 6);
    }
}
