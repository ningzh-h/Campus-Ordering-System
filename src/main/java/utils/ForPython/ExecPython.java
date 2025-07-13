package main.java.utils.ForPython;

import main.java.entities.Order;
import main.java.entities.users.User;

import java.io.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecPython {
    public static ScheduledExecutorService scheduler;

    public static void execPython(String pythonPath) {
        try {
            int exitCode = getExitCode(pythonPath);
            if (exitCode != 0) {
                System.err.println("Python 文件" + pythonPath + "执行失败，错误码：" + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("获取热度 TOP-10 菜品榜单失败：" + e.getMessage());
        }
    }

    private static int getExitCode(String pythonPath) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonPath);
        Process process = processBuilder.start();

        Thread errorThread = new Thread(() ->{
            try (BufferedReader br = new BufferedReader(
                new InputStreamReader(process.getInputStream()))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.out.println(line);
                    }
            } catch (IOException e) {
                System.err.println("错误流处理失败：" + e.getMessage());
            }
        });
        errorThread.start();

        return process.waitFor();
    }

    public static void execPython(String pythonPath, User user) {
        try {
            int exitCode = getExitCode(pythonPath, user);
            if (exitCode != 0) {
                System.err.println("Python 文件" + pythonPath + "执行失败，错误码：" + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("获取热度 TOP-10 菜品榜单失败：" + e.getMessage());
        }
    }

    private static int getExitCode(String pythonPath, User user) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonPath, String.valueOf(user.getUserID()));
        Process process = processBuilder.start();

        Thread errorThread = new Thread(() ->{
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("错误流处理失败：" + e.getMessage());
            }
        });
        errorThread.start();

        return process.waitFor();
    }


    public static void execPython(String pythonPath, Order order, int status) {
        try {
            int exitCode = getExitCode(pythonPath, order, status);
            if (exitCode != 0) {
                System.err.println("Python 文件" + pythonPath + "执行失败，错误码：" + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("获取热度 TOP-10 菜品榜单失败：" + e.getMessage());
        }
    }

    private static int getExitCode(String pythonPath, Order order, int status) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonPath, String.valueOf(order.getOrderID()), String.valueOf(status));
        Process process = processBuilder.start();

        Thread errorThread = new Thread(() ->{
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("错误流处理失败：" + e.getMessage());
            }
        });
        errorThread.start();

        return process.waitFor();
    }


    public static void integrateJavaPython(String pythonPath, User user) {
        scheduler = Executors.newScheduledThreadPool(1);
        scheduler.scheduleAtFixedRate(() -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("python", pythonPath, String.valueOf(user.getUserID()));
                Process process = pb.start();

                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                }
                process.waitFor();
            } catch (Exception e) {
                System.err.println("运行 Python 文件 " + pythonPath + " 失败：" + e.getMessage());
            }
        }, 10, 10, TimeUnit.SECONDS);
    }

}
