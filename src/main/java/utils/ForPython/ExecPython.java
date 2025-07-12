package main.java.utils.ForPython;

import java.io.*;

public class ExecPython {

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
                new InputStreamReader(process.getErrorStream()))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        System.err.println("[Python Error]" + line);
                    }
            } catch (IOException e) {
                System.err.println("错误流处理失败：" + e.getMessage());
            }
        });
        errorThread.start();

        return process.waitFor();
    }

    public static void execPython(String pythonPath, int merchantID) throws IOException {
        try {
            int exitCode = getExitCode(pythonPath, merchantID);
            if (exitCode != 0) {
                System.err.println("Python 文件" + pythonPath + "执行失败，错误码：" + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("获取热度 TOP-10 菜品榜单失败：" + e.getMessage());
        }
    }

    private static int getExitCode(String pythonPath, int merchantID) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("python", pythonPath, String.valueOf(merchantID));
        Process process = processBuilder.start();

        Thread errorThread = new Thread(() ->{
            try (BufferedReader br = new BufferedReader(
                    new InputStreamReader(process.getErrorStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    System.err.println("[Python Error]" + line);
                }
            } catch (IOException e) {
                System.err.println("错误流处理失败：" + e.getMessage());
            }
        });
        errorThread.start();

        return process.waitFor();
    }

}
