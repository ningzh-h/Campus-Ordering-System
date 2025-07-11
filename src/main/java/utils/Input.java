package main.java.utils;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    // 读取用户输入的整数
    public static int getInt(String intro) {
        int intInput;
        while (true) {
            try {
                System.out.println(intro);
                intInput = scanner.nextInt();
                scanner.nextLine(); // 清除缓冲区
                scanner.close();
                break;
            } catch (Exception e) {
                System.out.println("无效！请重新输入。");
                scanner.nextLine(); // 清除缓冲区
                scanner.close();
            }
        }
        return intInput;
    }

    public static String getString(String intro) {
        System.out.println(intro);
        return scanner.nextLine();
    }
}
