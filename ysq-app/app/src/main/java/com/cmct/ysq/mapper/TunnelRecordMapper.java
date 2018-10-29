package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelRecordPo;
import com.cmct.ysq.model.vo.TunnelMonitorItemBaseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 检测记录表
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-25 10:00:36
 */
public interface TunnelRecordMapper extends BaseMapper<TunnelRecordPo> {


    /**
     * 获取监测项目列表
     *
     * @return
     */
    List<TunnelMonitorItemBaseVo> getTunnelMonitorItemBaseInfoList();


    /**
     * 获取历史修改记录
     *
     * @param monitorItemRecordId
     * @return
     */
    List<TunnelRecordPo> getHisrotyTunnelMonitorItemInfoList(@Param("monitorItemRecordId") String monitorItemRecordId);
}
