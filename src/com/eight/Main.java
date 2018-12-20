package com.eight;

public class Main {

    public static void main(String[] args) {
        // write your code here
        File file = new File("readMe.txt");
        System.out.println("第一行");
        System.out.println("##First File:\r\n" + file.readToStringMySelf());

        File destFile = new File("OK.txt");
        FileHelper.copy(file, destFile);
        System.out.println("第二行");
        System.out.println("##Second File:\r\n" + destFile.readToStringMySelf());
    }
}
