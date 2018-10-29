package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.bo.TunnelReporterForQueryBo;
import com.cmct.ysq.model.po.TunnelReporterPo;
import com.cmct.ysq.model.vo.TunnelReporterVo;

import java.util.List;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 */
public interface TunnelReporterMapper extends BaseMapper<TunnelReporterPo> {


    /**
     * 获取分页报告
     *
     * @param query
     * @return
     */
    List<TunnelReporterVo> getReportPage(TunnelReporterForQueryBo query);

}
