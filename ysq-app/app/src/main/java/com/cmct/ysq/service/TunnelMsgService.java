package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.po.TunnelMsg;
import com.cmct.ysq.model.vo.TunnelMsgVo;
import com.cmct.ysq.model.where.TunnelMsgWhere;

/**
 * @author lxb
 * @Date 2018/8/3 14:26
 * 描述:
 */
public interface TunnelMsgService {
    JsonPage<TunnelMsgVo> paramsQuery(TunnelMsgWhere params) throws Exception;
    void edit(String msgId,String status,String handlingWay,String userId);
    void save(TunnelMsg tunnelMsg);
}
