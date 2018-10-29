package com.cmct.ysq.util;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.common.net.RestHttpRequester;
import com.cmct.common.util.ValidateUtil;
import com.cmct.common.web.WebResponse;
import com.cmct.ysq.StartApplication;
import com.cmct.ysq.mapper.SysParamMapper;
import com.cmct.ysq.model.bo.JwtTokenKeys;
import com.cmct.ysq.model.po.SysParamPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@Slf4j
@Component
public class EncacheUtil {


    @Cacheable(value = "jwtTokenKey", key = "#root.targetClass+#root.methodName")
    public JwtTokenKeys getTokenKeys() {
        ParameterizedTypeReference<WebResponse<JwtTokenKeys>> typeRef = new ParameterizedTypeReference<WebResponse<JwtTokenKeys>>() {
        };

        WebResponse<JwtTokenKeys> result = null;

        try {
            result = RestHttpRequester.Instance.getInstance().exchange("http://localhost:8100/cmct-api-common/login/token/keys", HttpMethod.GET, null, typeRef)
                    .getBody();
        } catch (Exception e) {
            e.printStackTrace();
            log.error("EncacheUtil.getTokenKeys.获取token失败:{}", e);
            return null;
        }
        if (result.getCode() == 0) {
            return result.getData();
        }

        return null;
    }


    public static String getSysParamName(String sysParamId) {

        if (ValidateUtil.paramInvalid(sysParamId)) {
            return null;
        }


        EncacheUtil encacheUtil = StartApplication.applicationContext.getBean(EncacheUtil.class.getName(), EncacheUtil.class);

        return encacheUtil.getAllSysParams()
                .parallelStream()
                .filter(((Predicate<SysParamPo>) sysParamPo -> !ValidateUtil.paramInvalid(sysParamPo.getParamId()))
                        .and(sysParamPo -> sysParamPo.getParamId().equalsIgnoreCase(sysParamId)))
                .findFirst()
                .map(SysParamPo::getParamName)
                .orElse(null);

    }

    public static String getSysParamCode(String sysParamId) {

        if (ValidateUtil.paramInvalid(sysParamId)) {
            return null;
        }


        EncacheUtil encacheUtil = StartApplication.applicationContext.getBean(EncacheUtil.class.getName(), EncacheUtil.class);

        return encacheUtil.getAllSysParams()
                .parallelStream()
                .filter(((Predicate<SysParamPo>) sysParamPo -> !ValidateUtil.paramInvalid(sysParamPo.getParamId()))
                        .and(sysParamPo -> sysParamPo.getParamId().equalsIgnoreCase(sysParamId)))
                .findFirst()
                .map(SysParamPo::getParamCode)
                .orElse(null);

    }

    //TODO
    @Cacheable(value = "tunnel_sysparam", key = "#root.targetClass+#root.methodName")
    public List<SysParamPo> getAllSysParams() {
        SysParamMapper sysParamMapper = StartApplication.applicationContext.getBean(SysParamMapper.class.getName(), SysParamMapper.class);
        Example ex = new Example(SysParamPo.class);
        ex.createCriteria()
                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal());
        return Optional.ofNullable(sysParamMapper.selectByExample(ex)).orElse(new ArrayList<>());
    }


}
