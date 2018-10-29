/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.common;

import com.cmct.common.exception.ExceptionUtils;
import com.cmct.common.log.LogUtil;
import com.cmct.common.util.ObjUtil;
import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.config.ConnectionConfig;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 基于httpcomponents的实现类
 *
 * @author losing
 * @Date 2016年8月15日
 * @since v0.1
 */
public class HttpClientService {

    // 最大连接数
    private static final int MAX_TOTAL_CONNECTIONS = 800;

    // 连接超时时间，单位ms，下同
    public final static int CONNECT_TIMEOUT = 5000;

    // 读取超时时间
    public final static int READ_TIMEOUT = 5000;

    /**
     * 每个路由最大连接数 路由的概念：运行环境机器 到 目标机器的一条线路。 举例来说，我们使用HttpClient的实现来分别请求 www.baidu.com 的资源和 www.bing.com
     * 的资源那么他就会产生两个route。 默认值为2，如果不设置这个参数值默认情况下对于同一个目标机器的最大并发连接只有2个， 这意味着即使设置连接池的最大连接数为200
     * ，但是实际上还是只有2个连接在工作，其他剩余的198个连接都在等待，都是为别的目标机器服务的.
     */
    public final static int MAX_ROUTE_CONNECTIONS = 50;

    private CloseableHttpClient httpClient;

    private RequestConfig defaultRequestConfig;

    private String handToken;

    private static final String HAND_TOKEN_KEY = "hand-token";

    public HttpClientService(String handToken) {
        ConnectionConfig connectionConfig = ConnectionConfig.custom().setCharset(Consts.UTF_8).build();
        PoolingHttpClientConnectionManager cm = new PoolingHttpClientConnectionManager();
        cm.setDefaultConnectionConfig(connectionConfig);
        cm.setDefaultMaxPerRoute(MAX_ROUTE_CONNECTIONS);
        cm.setMaxTotal(MAX_TOTAL_CONNECTIONS);
        defaultRequestConfig =
                RequestConfig.custom().setSocketTimeout(5000).setConnectTimeout(5000)
                        .setConnectionRequestTimeout(5000).build();
        httpClient =
                HttpClients.custom().setConnectionManager(cm).setDefaultRequestConfig(defaultRequestConfig)
                        .build();
        this.handToken = handToken;
    }

    public String httpGet(String url, Map<String, String> urlparams) {
        return httpGet(url, urlparams, "UTF-8");
    }

    public String httpGet(String url) {
        return httpGet(url, null, "UTF-8");
    }


    public String httpGet(String url, Map<String, String> urlparams, String charset) {
        HttpGet httpGet = null;
        CloseableHttpResponse response = null;
        String content = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            if (urlparams != null && urlparams.size() > 0) {
                for (Entry<String, String> entry : urlparams.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            httpGet = new HttpGet(builder.build());
            httpGet.setHeader(HAND_TOKEN_KEY, handToken);
            long start = System.currentTimeMillis();
            response = this.httpClient.execute(httpGet);
            LogUtil.info("execute get request:[{}],cost [{}] ms", url,
                    String.valueOf(System.currentTimeMillis() - start));
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            LogUtil.error("access {},error {} ", url, e);
            httpGet.abort();
            ExceptionUtils.throwException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                httpGet.abort();
                LogUtil.error("access {},error {} ", url, e);
            }
        }
        return content;

    }

    public String httpPost(String url, Map<String, String> urlparams, Map<String, String> bodyParams,
                           String charset) {
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        String content = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            if (urlparams != null && urlparams.size() > 0) {
                for (Entry<String, String> entry : urlparams.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            httpPost = new HttpPost(builder.build());
            httpPost.setHeader(HAND_TOKEN_KEY, handToken);

            if (bodyParams != null && bodyParams.size() > 0) {
                List<NameValuePair> bodyEntity = new ArrayList<>(bodyParams.size());
                for (Entry<String, String> entry : bodyParams.entrySet()) {
                    bodyEntity.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
                }
                httpPost.setEntity(new UrlEncodedFormEntity(bodyEntity, charset));
            }

            long start = System.currentTimeMillis();
            response = this.httpClient.execute(httpPost);
            LogUtil.info("execute get request:[{}],cost [{}] ms", url,
                    String.valueOf(System.currentTimeMillis() - start));
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            LogUtil.error("access {},error. ", url, e);
            httpPost.abort();
            ExceptionUtils.throwException(e);
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                httpPost.abort();
                LogUtil.error("close {},error. ", url, e);
            }
        }
        return content;

    }


    public String httpPostJson(String url, Map<String, String> urlparams) {
        return httpPostJson(url, urlparams, null, "UTF-8");
    }

    public String httpPostJson(String url, Map<String, String> urlparams, String jsonBody) {
        return httpPostJson(url, urlparams, jsonBody, "UTF-8");
    }

    public String httpPostJson(String url, String jsonBody) {
        return httpPostJson(url, null, jsonBody, "UTF-8");
    }

    public String httpPostJson(String url, Map<String, String> urlparams, String jsonBody,
                               String charset) {
        return httpPost(url, urlparams, jsonBody, charset);
    }

    private String httpPost(String url, Map<String, String> urlparams, String jsonBody, String charset) {
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;
        String content = null;
        try {
            URIBuilder builder = new URIBuilder(url);
            if (urlparams != null && urlparams.size() > 0) {
                for (Entry<String, String> entry : urlparams.entrySet()) {
                    builder.addParameter(entry.getKey(), entry.getValue());
                }
            }
            httpPost = new HttpPost(builder.build());
            httpPost.setHeader(HAND_TOKEN_KEY, handToken);

            if (ObjUtil.isStrNotBlank(jsonBody)) {
                httpPost.setEntity(new StringEntity(jsonBody, charset));
            }

            long start = System.currentTimeMillis();
            response = this.httpClient.execute(httpPost);
            LogUtil.info("execute get request:[{}],cost [{}] ms", url,
                    String.valueOf(System.currentTimeMillis() - start));
            HttpEntity entity = response.getEntity();
            content = EntityUtils.toString(entity, charset);
        } catch (Exception e) {
            LogUtil.error("access {},error {} ", url, e);
            httpPost.abort();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                httpPost.abort();
                LogUtil.error("access {},error {} ", url, e);
            }
        }
        return content;

    }

    public <T> T httpGet(String url, Map<String, String> urlparams, HttpResponseParser<T> parser) {
        return httpGet(url, urlparams, "UTF-8", parser);
    }

    public <T> T httpGet(String url, HttpResponseParser<T> parser) {
        return httpGet(url, null, "UTF-8", parser);
    }

    public <T> T httpPost(String url, HttpResponseParser<T> parser) {
        return httpPost(url, null, null, parser);
    }

    public <T> T httpPost(String url, Map<String, String> urlparams, HttpResponseParser<T> parser) {
        return httpPost(url, urlparams, null, parser);
    }


    public <T> T httpPost(String url, String jsonBody, HttpResponseParser<T> parser) {
        return httpPost(url, null, jsonBody, parser);
    }


    public <T> T httpPost(String url, Map<String, String> urlparams, String jsonBody,
                          HttpResponseParser<T> parser) {
        String content = this.httpPostJson(url, urlparams, jsonBody, "UTF-8");
        return parser.parse(content);
    }

    private <T> T httpGet(String url, Map<String, String> urlparams, String charset,
                          HttpResponseParser<T> parser) {
        String content = this.httpGet(url, urlparams, charset);
        return parser.parse(content);
    }

}
