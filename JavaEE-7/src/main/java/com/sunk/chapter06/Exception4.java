package com.sunk.chapter06;

public class Exception4 {

    public static void main(String[] args) {
        // - 出现 com.sunk.chapter06.Exception4$PasswordException
        try {
            login("admin", "123456");
        } catch (AccountException e) {
            System.out.println("用户账户不正确，需要修正");
        } catch (PasswordException pe) {
            System.out.println("用户密码不正确，需要修正");
        } catch (LoginException e) {
            System.out.println("出现了其他登录相关的异常");
        }
    }

    public static void login(String user, String pass) throws LoginException {
        if (!"admin".equals(user)) {
            // 用户名错误异常
            throw new AccountException("账号不正确");
        }

        if (!"admin".equals(pass)) {
            // 密码错误异常
            throw new PasswordException("密码不正确");
        }

        System.out.println("登陆成功");
    }

    static class LoginException extends RuntimeException {
        public LoginException(String message) {
            super(message);
        }
    }

    static class AccountException extends LoginException {
        public AccountException(String message) {
            super(message);
        }
    }

    static class PasswordException extends LoginException {
        public PasswordException(String message) {
            super(message);
        }
    }
}
