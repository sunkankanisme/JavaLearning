package com.sunk.chapter04;


public class ObjectTest9 {

    public static void main(String[] args) {
        final QQSystem qqSystem = new QQSystem();

        final User9 user9 = new User9();
        user9.setAccount("admin");
        user9.setPassword("admin");

        qqSystem.login(user9);
    }
}

class User9 {
    /*
     * 此处的属性直接使用 public 不安全，可以使用 private 修饰，再提供相应的读写方法进行访问
     */
    // public String account;
    // public String password;
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
     * 此处登录方法从属于 User 对象
     * 但登录功能应该不是 User 对象的理论上是属于一个系统的
     * 谁提供这个功能应该放在对应的类中
     */
    // public boolean login() {
    //     return true;
    // }
}

class QQSystem {
    public boolean login(User9 user9) {
        if (user9.getAccount().equals("admin") && user9.getPassword().equals("admin")) {
            return true;
        }

        return false;
    }
}


