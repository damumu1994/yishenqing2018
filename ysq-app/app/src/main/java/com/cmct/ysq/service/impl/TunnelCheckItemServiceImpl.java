package com.cmct.ysq.service.impl;

import com.cmct.ysq.mapper.TunnelCheckItemMapper;
import com.cmct.ysq.model.po.TunnelCheckItemPO;
import com.cmct.ysq.service.TunnelCheckItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author lxb
 * @Date 2018/7/27 15:42
 * 描述:
 */
@Service
@Transactional
public class TunnelCheckItemServiceImpl implements TunnelCheckItemService {
    @Autowired
    private TunnelCheckItemMapper mapper;
    @Override
    public List<TunnelCheckItemPO> getInfoByFk(String id) {
        return mapper.getInfoByFk(id);
    }
}
