package mundo;

import sss.Logic;

public class MisionerosS3 extends Logic {

    //Atributos
    int ParIzq[];
    int ParDer[];

    //Constructores
    public MisionerosS3() {
        ParIzq = new int[7];
        ParDer = new int[7];
    }

    public MisionerosS3(int[] Izq, int[] Der) {
        ParIzq = new int[7];
        ParDer = new int[7];
        ParIzq[0] = Izq[0];
        ParIzq[1] = Izq[1];
        ParIzq[2] = Izq[2];
        ParDer[0] = Der[0];
        ParDer[1] = Der[1];
        ParDer[2] = Der[2];
    }

    public int[] getParIzq() {
        return ParIzq;
    }

    public void setParIzq(int[] ParIzq) {
        this.ParIzq = ParIzq;
    }

    public int[] getParDer() {
        return ParDer;
    }

    public void setParDer(int[] ParDer) {
        this.ParDer = ParDer;
    }

    //Metodos
    //M , C == {(2,0)Der / Izq , (0,2) ,(1,1) , (1,0) , (0,1)} (  [misionero, canibal, bote (1 si esta 0 si no)]
    public void unMisionero() {
        if (ParIzq[2] == 1 && ParIzq[0] > 0 && !(ParIzq[1] > ParIzq[0] - 1 || ParIzq[0] == 0)) { //Izquierda
            if (!(ParIzq[1] > ParIzq[0] - 1) || ParIzq[0] - 1 == 0) {
                ParIzq[0] -= 1;
                ParDer[0] += 1;
                ParIzq[2] = 0;
                ParDer[2] = 1;
            }
        } else {
            if (ParDer[2] == 1 && ParDer[0] > 0) { // Derecha
                if (!(ParDer[1] > ParDer[0] - 1) || ParDer[0] - 1 == 0) {
                    ParIzq[0] += 1;
                    ParDer[0] -= 1;
                    ParIzq[2] = 1;
                    ParDer[2] = 0;
                }
            }
        }
    }

    public void unCanibal() {
        if (ParIzq[2] == 1 && ParIzq[1] > 0) { // Izq
            if (!(ParDer[1] + 1 > ParDer[0]) || ParDer[0] == 0) {
                ParIzq[1] -= 1;
                ParDer[1] += 1;
                ParIzq[2] = 0;
                ParDer[2] = 1;
            }
        } else {
            if (ParDer[2] == 1 && ParDer[1] > 0) { // Der
                if (!(ParIzq[1] + 1 > ParIzq[0]) || ParIzq[0] == 0) {
                    ParIzq[1] += 1;
                    ParDer[1] -= 1;
                    ParIzq[2] = 1;
                    ParDer[2] = 0;
                }
            }
        }
    }

    public void dosMisioneros() {
        if (ParIzq[2] == 1 && ParIzq[0] > 1) {//Izq
            if (!(ParIzq[1] > ParIzq[0] - 2) || ParIzq[0] - 2 == 0) {
                ParIzq[0] -= 2;
                ParDer[0] += 2;
                ParIzq[2] = 0;
                ParDer[2] = 1;
            }
        } else {
            if (ParDer[2] == 1 && ParDer[0] > 1) { //Der
                if (!(ParDer[1] > ParDer[0] - 2) || ParDer[0] - 2 == 0) {
                    ParIzq[0] += 2;
                    ParDer[0] -= 2;
                    ParIzq[2] = 1;
                    ParDer[2] = 0;
                }
            }
        }
    }

    public void dosCanibal() {
        if (ParIzq[2] == 1 && ParIzq[1] > 1) { //Izq a Der
            ParIzq[1] -= 2;
            ParDer[1] += 2;
            ParIzq[2] = 0;
            ParDer[2] = 1;
        } else {
            if (ParDer[2] == 1 && ParDer[1] > 1) { //Der a Izq
                ParIzq[1] += 2;
                ParDer[1] -= 2;
                ParIzq[2] = 1;
                ParDer[2] = 0;
            }
        }
    }

    public void mis_can() {
        if (ParIzq[2] == 1 && ParIzq[0] > 0 && ParIzq[1] > 0) {
            if (ParIzq[0] > 0 && ParIzq[1] > 0 && ParIzq[0] == ParIzq[1]) {
                ParIzq[0] -= 1;
                ParIzq[1] -= 1;
                ParDer[0] += 1;
                ParDer[1] += 1;
                ParIzq[2] = 0;
                ParDer[2] = 1;
            }

        } else {
            if (ParDer[2] == 1 && ParDer[0] > 0 && ParDer[1] > 0) {
                if (ParDer[0] > 0 && ParDer[1] > 0 && ParDer[0] == ParDer[1]) {
                    ParIzq[0] += 1;
                    ParIzq[1] += 1;
                    ParDer[0] -= 1;
                    ParDer[1] -= 1;
                    ParIzq[2] = 1;
                    ParDer[2] = 0;
                }
            }
        }
    }

    /*
    public void ver() {
        for (int i = 0; i < 2; i++) {
            System.out.print("[" + ParIzq[i] + "]");
        }
        System.out.print("  " + ParIzq[2] + "______" + ParDer[2] + "  ");
        for (int i = 0; i < 2; i++) {
            System.out.print("[" + ParDer[i] + "]");
        }
    }*/
    @Override
    public void action(int index) {
        switch (index) {
            case 1: {
                unMisionero();
                break;
            }
            case 2: {
                unCanibal();
                break;
            }
            case 3: {
                dosMisioneros();
                break;
            }
            case 4: {
                dosCanibal();
                break;
            }
            case 5: {
                mis_can();
                break;
            }
        }
    }

    @Override
    public Object cloneObject(Object object) {
        MisionerosS3 obj = (MisionerosS3) object;
        MisionerosS3 objClone;

        int Izqu[] = new int[3];
        int Dere[] = new int[3];
        int Izquierda[] = obj.getParIzq();
        int Derecha[] = obj.getParDer();

        objClone = new MisionerosS3();

        for (int i = 0; i < 3; i++) {
            Izqu[i] = Izquierda[i];
            Dere[i] = Derecha[i];
        }

        objClone.setParIzq(Izqu);
        objClone.setParDer(Dere);

        return objClone;
    }

    @Override
    public String state() {
        String state = "";
        state = state + ParIzq[0] + ParIzq[1] + ParIzq[2];
        state = state + "|   |" + ParDer[2] + ParDer[0] + ParDer[1];
        return state;
    }
}
