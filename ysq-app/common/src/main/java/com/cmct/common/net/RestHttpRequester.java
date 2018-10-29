package com.cmct.common.net;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
@Slf4j
public enum RestHttpRequester {

    Instance;

    private RestTemplate restTemplate;

    RestHttpRequester() {
        this.restTemplate = new RestTemplate();
        List<HttpMessageConverter<?>> converterList = this.restTemplate.getMessageConverters();
        HttpMessageConverter<?> converterTarget = null;
        for (HttpMessageConverter<?> item : converterList) {
            if (item.getClass() == StringHttpMessageConverter.class) {
                converterTarget = item;
                break;
            }
        }

        if (converterTarget != null) {
            converterList.remove(converterTarget);
        }
        HttpMessageConverter<?> converter = new StringHttpMessageConverter(Charset.defaultCharset());
        converterList.add(converter);
    }

    public RestTemplate getInstance() {
        return restTemplate;
    }


    /**
     * 网络请求
     *
     * @param url
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getResult(String url, Class<T> tClass) {

        HttpHeaders headers = new HttpHeaders();
        List<MediaType> list = new ArrayList<>();
        list.add(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(list);

        ResponseEntity<T> response = Instance.getInstance().exchange(
                url,
                HttpMethod.GET,
                new HttpEntity<T>(headers),
                tClass);

        return response.getBody();
    }

}
