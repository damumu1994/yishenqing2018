package com.cmct.ysq.service;

import com.cmct.ysq.model.po.TunnelMsgSend;
import com.cmct.ysq.model.vo.TunnelMsgSendVo;

import java.util.List;

/**
 * @author lxb
 * @Date 2018/8/3 14:27
 * 描述:
 */
public interface TunnelMsgSendService {
    void  save(TunnelMsgSend msgSend);
    List<TunnelMsgSendVo> getList(String userId);
}
