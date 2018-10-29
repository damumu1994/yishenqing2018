package com.cmct.common.file;

import java.io.File;
import java.io.FileOutputStream;

/**
 * 文件上传
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/3/15
 */
public final class FileUtil {


    /**
     * 上传文件
     *
     * @param file
     * @param filePath
     * @param fileName
     * @throws Exception
     */
    public static void uploadFile(byte[] file, String filePath, String fileName) throws Exception {
        File targetFile = new File(filePath);
        if (!targetFile.exists()) {
            targetFile.mkdirs();
        }
        FileOutputStream out = new FileOutputStream(filePath + fileName);
        out.write(file);
        out.flush();
        out.close();
    }

//    public static void uploadFile(byte[] file, String fileName) throws Exception {
//        File targetFile = new File(filePath);
//        if(!targetFile.exists()){
//            targetFile.mkdirs();
//        }
//        FileOutputStream out = new FileOutputStream(filePath+fileName);
//        out.write(file);
//        out.flush();
//        out.close();
//    }
}
