package com.cmct.ysq.service.impl;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.base.exception.CmctError;
import com.cmct.common.bean.JsonPage;
import com.cmct.common.exception.Exceptions;
import com.cmct.common.util.ValidateUtil;
import com.cmct.ysq.mapper.TunnelReporterMapper;
import com.cmct.ysq.model.bo.TunnelReporterForAddBo;
import com.cmct.ysq.model.bo.TunnelReporterForQueryBo;
import com.cmct.ysq.model.bo.TunnelReporterForUpdateBo;
import com.cmct.ysq.model.po.TunnelReporterPo;
import com.cmct.ysq.model.vo.TunnelReporterVo;
import com.cmct.ysq.service.TunnelReporterService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.UUID;


/**
 * @author shen
 */
@Transactional(rollbackOn = Exception.class)
@Service
public class TunnelReporterServiceImpl implements TunnelReporterService {

    @Autowired
    private TunnelReporterMapper tunnelReporterMapper;


    @Override
    public JsonPage<TunnelReporterVo> getReportPage(TunnelReporterForQueryBo query) {
        if (null == query) {
            query = new TunnelReporterForQueryBo();
        }
        Page<TunnelReporterVo> page = PageHelper.startPage(query.getPage(), query.getRows());
        tunnelReporterMapper.getReportPage(query);
        return new JsonPage(page);
    }

    @Override
    public void updateReport(TunnelReporterForUpdateBo reporterForUpdateBo,
                             String reporterId, String modifyBy) {

        if (null == reporterForUpdateBo || ValidateUtil.paramInvalid(reporterId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "reporterForUpdateBo或者reporterId不合法");
        }

        tunnelReporterMapper.updateByPrimaryKeySelective(TunnelReporterPo.builder()
                .reporterId(reporterId)
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .url(reporterForUpdateBo.getUrl())
                .fileName(reporterForUpdateBo.getFileName())
                .des(reporterForUpdateBo.getDes())
                .type(reporterForUpdateBo.getType())
                .departId(reporterForUpdateBo.getDepartId())
                .build());

    }


    //TODO
    @Override
    public void saveReport(TunnelReporterForAddBo reporterForAdd, String createBy) {


        if (null == reporterForAdd) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "reporterForAdd不合法");
        }

        tunnelReporterMapper.insertSelective(TunnelReporterPo.builder()
                .reporterId(UUID.randomUUID().toString())
                .createBy(createBy)
                .createDate(new Date())
                .url(reporterForAdd.getUrl())
                .fileName(reporterForAdd.getFileName())
                .des(reporterForAdd.getDes())
                .type(reporterForAdd.getType())
                .departId(reporterForAdd.getDepartId())
                .deleteStatus(DeleteStatus.YES.ordinal())
                .build());
    }

    //TODO
    @Override
    public void deleteReport(String reportId, String modifyBy) {
        if (ValidateUtil.paramInvalid(reportId)) {
            throw Exceptions.createException(CmctError.DATA_ERROR, "reportId无效");
        }

        tunnelReporterMapper.updateByPrimaryKeySelective(TunnelReporterPo.builder()
                .reporterId(reportId)
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .deleteStatus(DeleteStatus.NO.ordinal())
                .build());

    }
}
