package com.cmct.ysq.service;


import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.TunnelReporterForAddBo;
import com.cmct.ysq.model.bo.TunnelReporterForQueryBo;
import com.cmct.ysq.model.bo.TunnelReporterForUpdateBo;
import com.cmct.ysq.model.vo.TunnelReporterVo;

/**
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-19 14:58:55
 */
public interface TunnelReporterService {


    /**
     * 获取报告列表
     *
     * @param query
     * @return
     */
    JsonPage<TunnelReporterVo> getReportPage(TunnelReporterForQueryBo query);


    /**
     * 修改报告
     *
     * @param reporterForUpdateBo 报告更改实体
     * @param reporterId          报告id
     * @param modifyBy            修改人
     */
    void updateReport(TunnelReporterForUpdateBo reporterForUpdateBo,
                      String reporterId, String modifyBy);

    /**
     * 保存报告
     *
     * @param reporterForAdd 报告新增实体
     * @param createBy       创建人
     */
    void saveReport(TunnelReporterForAddBo reporterForAdd, String createBy);


    /**
     * 删除报告
     *
     * @param reportId 报告id
     * @param modifyBy 修改人
     */
    void deleteReport(String reportId, String modifyBy);
}

