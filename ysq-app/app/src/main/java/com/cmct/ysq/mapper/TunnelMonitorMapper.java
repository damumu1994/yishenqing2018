package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelMonitorPo;
import com.cmct.ysq.model.vo.TunnelCrossSectionVo;
import org.apache.ibatis.annotations.Param;

/**
 * 断面信息
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-26 13:56:54
 */
public interface TunnelMonitorMapper extends BaseMapper<TunnelMonitorPo> {

    /**
     * 获取断面信息
     *
     * @param monitorItemRecordId
     * @return
     */
    TunnelCrossSectionVo getCrossSection(@Param("monitorItemRecordId") String monitorItemRecordId);


    String getMonitorItemMethod(@Param("monitorId") String monitorId);
}
