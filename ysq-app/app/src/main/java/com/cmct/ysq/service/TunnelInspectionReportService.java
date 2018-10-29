package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.TunnelCheckItemBO;
import com.cmct.ysq.model.bo.TunnelInspectionReportBO;
import com.cmct.ysq.model.po.TunnelInspectionReportPO;
import com.cmct.ysq.model.vo.SysParamVo;
import com.cmct.ysq.model.vo.TunnelInspectionReport2VO;
import com.cmct.ysq.model.vo.TunnelInspectionReportVO;
import com.cmct.ysq.model.where.TunnelInspectionReportWhere;

import java.util.List;

public interface TunnelInspectionReportService {
    /**
     * 动态查询
     * @param where
     * @return
     */
    JsonPage<TunnelInspectionReportVO>paramsByQuery(TunnelInspectionReportWhere where);

    /**
     *  添加
     * @param bo
     */
    void add(TunnelInspectionReportBO bo);
    void  update(TunnelInspectionReportPO po);

    /**
     * del
     * @param bo
     */
    void del(TunnelCheckItemBO bo);

    /**
     * dit
     * @param key
     */
    TunnelInspectionReport2VO dit(String key);
    List<SysParamVo> getInspectionArea(String param);
}
