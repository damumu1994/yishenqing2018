package com.cmct.ysq.model.vo;

import com.cmct.ysq.model.po.TunnelInfoPo;
import lombok.Data;

import java.util.List;

/**
 * create by Administrator
 */
@Data
public class TunnelInfoVo extends TunnelInfoPo {
    private String otherId;
    private String tunnelProId;
    private String construction;
    private String consts;
    private String constBlocks;
    private String supervision;
    private String supervisionBlocks;
    private String monitor;
    private String monitorBlocks;
    /**
     * 隧道方向
     */
    private List<TunnelProParamLinkVo>tunnelDirection;
}
