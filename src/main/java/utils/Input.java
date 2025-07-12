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
                break;
            } catch (Exception e) {
                System.out.println("无效！请重新输入。");
                scanner.nextLine(); // 清除缓冲区
            }
        }
        return intInput;
    }

    public static String getString(String intro) {
        String info = null;
        while (info == null || info.trim().isEmpty()) {
            System.out.println(intro);
            info = scanner.nextLine();
        }
        return info;
    }

    public static void jump(String intro) {
        System.out.println(intro);
        scanner.nextLine();
    }

    public static double getDouble(String intro) {
        double doubleInput;
        while (true) {
            try {
                System.out.println(intro);
                doubleInput = scanner.nextDouble();
                scanner.nextLine(); // 清除缓冲区
                break;
            } catch (Exception e) {
                System.out.println("无效！请重新输入。");
                scanner.nextLine(); // 清除缓冲区
            }
        }
        return doubleInput;
    }
}
