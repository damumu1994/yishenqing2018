package com.cmct.ysq.service.impl;

import com.cmct.ysq.mapper.TunnelConsInfoMapper;
import com.cmct.ysq.model.po.TunnelConsInfoPo;
import com.cmct.ysq.service.TunnelConsInfoService;
import com.cmct.ysq.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @author lxb
 * @Date 2018/7/23 17:30
 * 描述:
 */
@Service
@Transactional
public class TunnelConsInfoServiceImpl  implements TunnelConsInfoService {
    @Autowired
    private TunnelConsInfoMapper mapper;
    @Override
    /**
     * 批处理
     */
    public Boolean add(TunnelConsInfoPo[] arr)  {
        for (TunnelConsInfoPo consInfoPo : arr) {
            try {
                consInfoPo.setConsInfoId(IDUtil.getId());
                mapper.insert(consInfoPo);
            }catch (Exception ex){
                return false;
            }

        }
     return true;
    }
}
