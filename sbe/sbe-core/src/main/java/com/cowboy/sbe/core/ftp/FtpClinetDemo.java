package com.cowboy.sbe.core.ftp;/**
 * Created by Administrator on 2017/11/16/0016.
 */

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPListParseEngine;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.function.Consumer;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-16 9:48
 **/
public class FtpClinetDemo {
    public static void main(String[] args) throws IOException {
        FTPClient ftpClient = new FTPClient();
        try {
            ftpClient.connect("192.168.42.189");
            ftpClient.login("ftpuser", "123456");
            //            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
            //            ftpClient.setControlEncoding("UTF-8");

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //ftpClient.deleteFile();
        boolean success = ftpClient.deleteFile("/ftp/priv/");
        System.out.println(success);
        if (1 == 1) {
            return;
        }
        //ftpClient.rename("from","to");
        // ftpClient.storeFile("/ftp/priv/psu.jpg",new FileInputStream("C:\\Users\\Administrator\\Desktop\\psu.jpg"));
        ftpClient.deleteFile("/ftp/priv/psu.jpg");
        ftpClient.setControlEncoding("utf-8");
        File file = new File("E:/project_doc/seebon/sbms_develop/v1.1");
        processFile(file, (f) -> {
            String repalcePath = f.getPath().replace("\\", "/").replace(file.getPath().replace("\\", "/"), "");
            try {
                repalcePath = new String(repalcePath.getBytes("utf-8"), "iso-8859-1");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //如果是以/开头,删除/
            if ("/".equals(repalcePath.charAt(0) + "")) {
                repalcePath = repalcePath.substring(1);
                int c = 0;
                while ((c = repalcePath.indexOf("/", c)) != -1) {
                    String cp = repalcePath.substring(0, c);
                    c++;
                    try {
                        ftpClient.makeDirectory(cp);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                try {
                    ftpClient.storeFile(repalcePath, new FileInputStream(f));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(repalcePath);
        });
        //ftpClient.disconnect();
        ftpClient.logout();
    }


    public static void processFile(File file, Consumer<File> consumer) {
        File[] files = file.listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                processFile(f, consumer);
            } else {
                consumer.accept(f);
            }
        }
    }
}
