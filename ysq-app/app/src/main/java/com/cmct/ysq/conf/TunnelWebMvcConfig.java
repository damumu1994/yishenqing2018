package com.cmct.ysq.conf;

import com.cmct.common.bean.BaseMapper;
import com.cmct.common.bean.InsertOrUpdateMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
 * @author shen
 * @version 1.0.0
 * @since 2018/4/26
 */
@Configuration
@EnableAutoConfiguration
public class TunnelWebMvcConfig {

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer() {
        MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
        // 注册自己项目中使用的通用Mapper接口，这里没有默认值，必须手动注册
        mapperScannerConfigurer.setBasePackage("com.cmct.tunnel.mapper");
        mapperScannerConfigurer.setMarkerInterface(BaseMapper.class);
        mapperScannerConfigurer.setMarkerInterface(InsertOrUpdateMapper.class);
        //配置完成后，执行下面的操作
        return mapperScannerConfigurer;
    }


}
