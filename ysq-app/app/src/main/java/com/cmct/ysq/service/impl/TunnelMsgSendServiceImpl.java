package com.cmct.ysq.service.impl;

import com.cmct.ysq.mapper.TunnelMsgSendMapper;
import com.cmct.ysq.model.po.TunnelMsgSend;
import com.cmct.ysq.model.vo.TunnelMsgSendVo;
import com.cmct.ysq.service.TunnelMsgSendService;
import com.cmct.ysq.util.IDUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

/**
 * @author lxb
 * @Date 2018/8/3 14:28
 * 描述:send啊
 */
@Service
@Transactional
public class TunnelMsgSendServiceImpl implements TunnelMsgSendService {
    @Autowired private TunnelMsgSendMapper msgSendMapper;
    @Override
    public void save(TunnelMsgSend msgSend) {
        msgSend.setSendDate(new Date());
        msgSend.setMsgSendId(IDUtil.getId());
        msgSend.setDeleteStatus(0L);
        msgSendMapper.insert(msgSend);
    }

    @Override
    public List<TunnelMsgSendVo> getList(String userId) {
        return msgSendMapper.getList(userId);
    }
}
