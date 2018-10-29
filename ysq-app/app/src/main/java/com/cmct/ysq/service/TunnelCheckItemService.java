package com.cmct.ysq.service;

import com.cmct.ysq.model.po.TunnelCheckItemPO;

import java.util.List;

/**
 * @author lxb
 * @Date 2018/7/27 15:41
 * 描述:
 */
public interface TunnelCheckItemService {
    public List<TunnelCheckItemPO> getInfoByFk(String id);
}
