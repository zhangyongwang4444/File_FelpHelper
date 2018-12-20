package com.eight;

import java.io.*;

public class File {

    private String m_dir;

    public File(String dir) {
        m_dir = dir;
    }

    public String readToString() {
        java.io.File file = new java.io.File(m_dir);
        Long fileLength = file.length();
        byte[] fileContent = new byte[fileLength.intValue()];
        try {
            FileInputStream in = new FileInputStream(file);
            in.read(fileContent);
            in.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(fileContent);
    }

    /*
     * 不依赖系统File版
     * */
    static final int BUFFER_SIZE = 4 * 1024;

    public String readToStringMySelf() {
        String result = "";
        try {
            FileInputStream is = new FileInputStream(m_dir);
            //InputStreamReader sr = new InputStreamReader(is,"utf-8");
            int len = 0;
            byte[] buf = new byte[BUFFER_SIZE];
            while ((len = is.read(buf)) != -1) {
                result += new String(buf, 0, len);
            }
            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    //写入一个String2file.
    public void writeString(String content) {
        java.io.File file = new java.io.File(m_dir);
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            out.write(content.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeStringMySelf(String content) {

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(m_dir, false);
            out.write(content.getBytes());
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


}

