package Clock_GUI;
/*
Callum Jenkins
Title
23/09/2020 of 09, 2020
*/

public class ClockFace {

    public static void main(String[] args){
        boolean tiktok = true;

        //Clock c1 = new Clock(22, 6, 56);
        Clock c2 = new Clock();

        //c1.tick();
        for (int i = 0; i < 300; i ++) {
            c2.tick();
        }
    }

}
