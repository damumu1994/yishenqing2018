package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelMsg;
import com.cmct.ysq.model.vo.TunnelMsgVo;
import com.cmct.ysq.model.where.TunnelMsgWhere;

import java.util.List;

/**
 * @author lxb
 * @Date 2018/8/3 14:14
 * 描述:消息
 */
public interface TunnelMsgMapper extends BaseMapper<TunnelMsg> {
    List<TunnelMsgVo> paramsQuery(TunnelMsgWhere params);
}
