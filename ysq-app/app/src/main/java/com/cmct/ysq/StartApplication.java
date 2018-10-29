package com.cmct.ysq;

import com.cmct.common.bean.BaseMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

/**
 * @author shen
 */
@EnableCaching
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@MapperScan(basePackages = {"com.cmct.ysq.mapper"}, markerInterface = BaseMapper.class)
@PropertySources({@PropertySource("classpath:/config/app/application.properties"),
        @PropertySource("classpath:/config/app/application-${spring.profiles.active}.properties")})
@EntityScan(basePackages = "com.cmct.dao.model.po")
public class StartApplication {

    public static ApplicationContext applicationContext;
    public static void main(String[] args) {
        applicationContext = new SpringApplicationBuilder(StartApplication.class)
                .web(true)
                .run(args);
    }

    /**
     * 声明缓存管理器
     */
    @Bean
    public CacheManager cacheManager() {
        return new ConcurrentMapCacheManager();
    }
}
