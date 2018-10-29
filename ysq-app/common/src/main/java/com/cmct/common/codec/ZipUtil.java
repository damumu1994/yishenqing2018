package com.cmct.common.codec;

import com.cmct.common.util.ObjUtil;
import org.xerial.snappy.Snappy;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * Created by Administrator on 2017/8/23.
 */
public class ZipUtil {

    public static byte[] snappyCompress(String str) {
        try {
            return Snappy.compress(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String snappyDeCompress(byte[] bytes) {
        try {
            return Snappy.uncompressString(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static byte[] compressToBytes(String str) throws IOException {
        if (ObjUtil.isNull(str)) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        gzip.write(str.getBytes());
        gzip.close();
        return out.toByteArray();
    }

    // 解压缩
    public static String decompressFromBytes(byte[] bytes) throws IOException {
        if (ObjUtil.isNull(bytes)) {
            return null;
        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        GZIPInputStream gunzip = new GZIPInputStream(in);
        byte[] buffer = new byte[256];
        int n;
        while ((n = gunzip.read(buffer)) >= 0) {
            out.write(buffer, 0, n);
        }
        // toString()使用平台默认编码，也可以显式的指定如toString(&quot;GBK&quot;)
        return out.toString();
    }

//    public static void main(String[] args) throws Exception {
//        StringBuffer sb = new StringBuffer("");

//        for(int i = 0; i < 100000; i ++) {
//            sb.append("fdsjkfjdsfkljsdfkldsjklfjdskfjdsklfjdsklfjdslfjdsklfjdskljfdslkjfdslkjfldsqwerq");
//        }
//
//        String s = sb.toString();
//        System.out.println("------------------> s : " + s.length());
//
//
//        byte[] cs = compress(s);
//        System.out.println("-----------------> cs : " + cs.length);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("user", "user");
//        map.put("pass", "pass");
//
//        WebResponse r = new WebResponse(0, "", snappyCompress(JsonUtil.toJson(map)));
//
//        byte[] a = compressToBytes(JsonUtil.toJson(r));
//
//
//
////
//        System.out.println("-----------------> cs : " + decompressFromBytes(a));


//        String cs = "H4sIAAAAAAAAAKtWKkgsLlayglA6SqXFqUVAHpiqBQAqwKSqHQAAAA==";
//
//
//        System.out.println("-----------------> cs : " + decompressFromBytes(cs.getBytes("ISO-8859-1")));
//
//    }
}
