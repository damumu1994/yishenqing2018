package com.cmct.common.util;

import com.aliyun.oss.OSSClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * @author shen
 */
@Slf4j
public class OssUtil {

    private String bucketName;
    private OSSClient ossClient;

    public OssUtil(String endpoint, String accessKeyId, String secretAccessKey, String bucketName) {
        buildOssParam(endpoint, accessKeyId, secretAccessKey, bucketName);
    }

    public void buildOssParam(String endpoint, String accessKeyId, String secretAccessKey, String bucketName) {
        if (StringUtils.isEmpty(endpoint) || StringUtils.isEmpty(accessKeyId) || StringUtils.isEmpty(secretAccessKey) || StringUtils.isEmpty(bucketName)) {
            throw new RuntimeException("配置为空");
        }
        this.bucketName = bucketName;
        this.ossClient = new OSSClient(endpoint, accessKeyId, secretAccessKey);
    }


    /**
     * @param fileSaveName 文件保存名
     * @return String 文件路径
     * @Description:拼接OSS文件签名路径
     * @Author Leeg
     * @Date: 2017/12/20
     */
    public String getOssSingRealUrl(String fileSaveName) {
        //生成失效时间
        Date expiration = new Date(System.currentTimeMillis() + 100000000 * 1000);
        return ossClient.generatePresignedUrl(bucketName, fileSaveName, expiration).toString();
    }


    public void upload(String newFileName, MultipartFile file) {
        try {
            long start = System.currentTimeMillis();
            ossClient.putObject(this.bucketName, newFileName, file.getInputStream());
            log.info("上传成功，用时：{}", System.currentTimeMillis() - start);
        } catch (IOException ex) {
            log.error("上传文件[{}]出错，{}", file.getOriginalFilename(), ex.getMessage());
        }
    }

    public void upload(String newFileName, InputStream is) {
        try {
            long start = System.currentTimeMillis();
            ossClient.putObject(this.bucketName, newFileName, is);
            log.info("上传成功，用时：{}", System.currentTimeMillis() - start);
        } catch (Exception ex) {
            log.error("上传文件出错，{}", ex);
        }
    }

    /**
     * @param prefix
     * @param suffix 文件后缀名
     * @return
     */
    public static String getUniquePath(String prefix, String suffix) {
        //生成uuid
        String uuid = UUID.randomUUID().toString().replaceAll("-", "");
        //文件路径
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String path = sdf.format(new Date()) + "/" + uuid;

        if (org.apache.commons.lang.StringUtils.isNotBlank(prefix)) {
            path = prefix + "/" + path;
        }

        return path + suffix;
    }


    public String upload(String newFileName, byte[] data) {
        try {
            long start = System.currentTimeMillis();
            ossClient.putObject(this.bucketName, newFileName, new ByteArrayInputStream(data));
            log.info("上传成功，用时：{}", System.currentTimeMillis() - start);
            return this.getOssSingRealUrl(newFileName);
        } catch (Exception ex) {
            log.error("上传文件出错，{}", ex);
            return null;
        }
    }

}
