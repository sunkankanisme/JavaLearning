package com.sunk.chapter04;


public class ObjectTest6 {

    public static void main(String[] args) {
        final Computer computer = new Computer();
        final Light light1 = new Light();
        computer.usb1 = light1;

        final Light light2 = new Light();
        computer.usb2 = light2;
        computer.powerSupply();
    }
}


interface USBInterface {

}

interface USBSupply extends USBInterface {
    void powerSupply();
}

interface USBReceive extends USBInterface {
    void powerReceive();
}

class Computer implements USBSupply {

    public USBReceive usb1;
    public USBReceive usb2;

    @Override
    public void powerSupply() {
        System.out.println("电脑提供能源");
        usb1.powerReceive();
        usb2.powerReceive();
    }

}

class Light implements USBReceive {

    @Override
    public void powerReceive() {
        System.out.println("电灯接收能源");
    }
}



