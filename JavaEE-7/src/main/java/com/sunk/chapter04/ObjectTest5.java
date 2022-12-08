package com.sunk.chapter04;


public class ObjectTest5 {

    public static void main(String[] args) {
        final User5 user5 = new User5() {
            @Override
            public void eat() {

            }
        };

    }

}

abstract class User5 {

    public abstract void eat();

}

class Chinese extends User5 {
    @Override
    public void eat() {
        System.out.println("我是中国人，使用筷子吃饭");
    }
}



