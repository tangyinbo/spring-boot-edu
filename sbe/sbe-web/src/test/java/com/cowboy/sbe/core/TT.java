package com.cowboy.sbe.core;/**
 * Created by Administrator on 2017/11/10/0010.
 */

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author Tangynbo
 * @version 1.0
 * @create 2017-11-10 16:09
 **/
public class TT {
    public static void main(String[] args) throws IOException {
        File f = new File("C:\\Users\\Administrator\\Desktop\\dowload.zip");
        ZipFile zfile = new ZipFile(f);

/*        System.out.println(zfile.getName());
        System.out.println(zfile.getEntry("page2"));
        System.out.println(File.separator);
        System.out.println(zfile.getEntry("page1"+File.separator+"index.html"));*/


        System.out.println("==============");
       // zfile.getEntry()

        Enumeration zList = zfile.entries();//得到zip包里的所有元素

        while(zList.hasMoreElements()){
            ZipEntry ze = (ZipEntry) zList.nextElement();
            System.out.println(ze.getName());


        }


    }
}
