package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelMsgSend;
import com.cmct.ysq.model.vo.TunnelMsgSendVo;

import java.util.List;

/**
 * @author lxb
 * @Date 2018/8/3 14:14
 * 描述: 发送
 */
public interface TunnelMsgSendMapper extends BaseMapper<TunnelMsgSend> {
    List<TunnelMsgSendVo> getList(String userId);
}
