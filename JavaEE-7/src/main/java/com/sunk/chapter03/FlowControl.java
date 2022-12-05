package com.sunk.chapter03;

public class FlowControl {

    public static void main(String[] args) {

        int i = 10;
        int j = 20;

        int res = i + j * 20;


        int i2 = 100;
        if (i2 > 20) {
            System.out.println("YES");
        } else if (i2 < 20) {
            System.out.println("NO");
        } else {
            System.out.println("OTHER");
        }

        int i3 = 100;
        switch (i3) {
            case 10:
                System.out.println("-> 10");
                break;
            case 100:
                System.out.println("-> 100");
                break;
            default:
                System.out.println("-> OTHER");
        }


        o:
        for (int k = 0; k < 10; k++) {
            for (int l = 0; l < 10; l++) {
                break o;
            }
        }


        int age = 30;
        do {
            System.out.println("age: " + age++);
        } while (age <= 40);




    }


}
