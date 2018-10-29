package com.cmct.ysq.conf;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter4;
import com.cmct.common.exception.CmctException;
import com.cmct.common.exception.Errorcode;
import com.cmct.common.web.WebResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.FieldError;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.http.HttpServletResponse;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.cmct.base.exception.CmctError.PARAM_ERROR;
import static com.cmct.base.exception.CmctError.SYS_ERROR;
import static com.cmct.base.util.ResponseUtil.responseResult;


/**
 * @author Administrator
 */
@Slf4j
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurerAdapter {


    //统一异常处理
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
        exceptionResolvers.add((request, response, handler, e) -> {

            WebResponse result = new WebResponse();
            if (e instanceof CmctException) {
                CmctException cmctException = (CmctException) e;
                Errorcode errorcode = cmctException.getErrorcode();
                errorcode = errorcode == null ? SYS_ERROR : errorcode;
                return exceptionExit(errorcode, response);
            } else if (e instanceof MethodArgumentNotValidException) {
                List<FieldError> fieldErrors = ((MethodArgumentNotValidException) e).getBindingResult().getFieldErrors();

                if (CollectionUtils.isEmpty(fieldErrors)) {
                    return exceptionExit(SYS_ERROR, response);
                }

                String errorMsg = fieldErrors.stream()
                        .map(FieldError::getDefaultMessage)
                        .reduce((s, s2) -> s + ";" + s2)
                        .get();
                Errorcode errorcode = PARAM_ERROR;
                errorcode.setDesc(errorMsg);
                return exceptionExit(errorcode, response);
            }
            return exceptionExit(SYS_ERROR, response);
        });
    }

    private static ModelAndView exceptionExit(Errorcode errorcode, HttpServletResponse response) {
        WebResponse result = new WebResponse();
        result.setCode(errorcode.getCode());
        result.setMsg(errorcode.getDesc());
        responseResult(response, result);
        return new ModelAndView();
    }

    @Bean
    @ConditionalOnProperty(prefix = "jwt", name = "auth-open", havingValue = "true", matchIfMissing = true)
    public AuthFilter jwtAuthenticationTokenFilter() {
        return new AuthFilter();
    }

    private CorsConfiguration buildConfig() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        return corsConfiguration;
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", buildConfig());// 4
        return new CorsFilter(source);
    }

    //使用阿里 FastJson 作为JSON MessageConverter
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        FastJsonHttpMessageConverter4 converter = new FastJsonHttpMessageConverter4();
        FastJsonConfig config = new FastJsonConfig();
        config.setSerializerFeatures(SerializerFeature.WriteMapNullValue);
        converter.setFastJsonConfig(config);
        List<MediaType> mediaTypes = new ArrayList<>();
        mediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        converter.setSupportedMediaTypes(mediaTypes);
        converter.setDefaultCharset(Charset.forName("UTF-8"));
        converters.add(converter);
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        return new MethodValidationPostProcessor();
    }

}
