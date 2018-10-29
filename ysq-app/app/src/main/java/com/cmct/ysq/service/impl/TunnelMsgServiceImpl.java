package com.cmct.ysq.service.impl;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.mapper.TunnelMsgMapper;
import com.cmct.ysq.model.po.TunnelMsg;
import com.cmct.ysq.model.vo.TunnelMsgVo;
import com.cmct.ysq.model.where.TunnelMsgWhere;
import com.cmct.ysq.service.TunnelMsgService;
import com.cmct.ysq.util.IDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author lxb
 * @Date 2018/8/3 14:26
 * 描述:
 */
@Service@Transactional
public class TunnelMsgServiceImpl implements TunnelMsgService {
    @Autowired private TunnelMsgMapper msgMapper;


    @Override
    public JsonPage<TunnelMsgVo> paramsQuery(TunnelMsgWhere params) throws Exception {
        if (ObjectUtils.isEmpty(params)) {
            params=new TunnelMsgWhere();
        }
        Page<TunnelMsgVo> page = PageHelper.startPage(params.getPage(), params.getRows());
        msgMapper.paramsQuery(params);
        //mapper.getAll2();
        return new JsonPage(page);
    }

    @Override
    public void edit(String msgId,String status, String handlingWay, String userId) {
        msgMapper.updateByPrimaryKey(TunnelMsg.builder().modifyBy(userId)
                .modifyDate(new Date())
                .msgId(msgId)
                .status(Long.parseLong(status))
                .handlingWay(Long.parseLong(handlingWay))
                .build());
    }

    @Override
    public void save(TunnelMsg tunnelMsg) {
        tunnelMsg.setMsgId(IDUtil.getId());
        tunnelMsg.setCreateDate(new Date());
        tunnelMsg.setDeleteStatus(0L);
        tunnelMsg.setStatus(0L);//default
        msgMapper.insert(tunnelMsg);
    }
}
