package com.cmct.ysq.service.impl;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.mapper.SysParamMapper;
import com.cmct.ysq.mapper.TunnelCheckItemMapper;
import com.cmct.ysq.mapper.TunnelInspectionReportMapper;
import com.cmct.ysq.model.bo.TunnelCheckItemBO;
import com.cmct.ysq.model.bo.TunnelInspectionReportBO;
import com.cmct.ysq.model.po.TunnelCheckItemPO;
import com.cmct.ysq.model.po.TunnelInspectionReportPO;
import com.cmct.ysq.model.vo.*;
import com.cmct.ysq.model.where.TunnelInspectionReportWhere;
import com.cmct.ysq.service.TunnelInspectionReportService;
import com.cmct.ysq.util.IDUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TunnelInspectionReportServiceImpl implements TunnelInspectionReportService {
    @Autowired
    private TunnelInspectionReportMapper mapper;
    @Autowired
    private TunnelCheckItemMapper checkItemMapper;
   @Autowired
   private SysParamMapper sysParamMapper;
    @Override
    public JsonPage<TunnelInspectionReportVO> paramsByQuery(TunnelInspectionReportWhere params) {
        if (ObjectUtils.isEmpty(params)) {
            params = new TunnelInspectionReportWhere();
        }
        Page<TunnelInspectionReportVO> page = PageHelper.startPage(params.getPage(), params.getRows());
        mapper.paramsQuery(params);
        //mapper.getAll2();
        return new JsonPage(page);
    }

    @Override
    public void add(TunnelInspectionReportBO bo) {
        TunnelInspectionReportPO po = bo.getTunnelInspectionReportPO();
        String inspectionReportId = IDUtil.getId();
        po.setInspectionReportId(inspectionReportId);
        po.setCreateTime(new Date());
        po.setTunnelId(bo.getTunnelProId());
        po.setDeleteStatus(0L);
        mapper.insert(po);
        List<TunnelCheckItemPO> items = bo.getTunnelCheckItemPOS();
        items.forEach((value) -> {
            value.setInspectionReportId(inspectionReportId);
            value.setCreateTime(new Date());
            value.setDeleteStatus(0L);
            checkItemMapper.insert(value);
        });
        //需要返回结果集
    }

    @Override
    public void update(TunnelInspectionReportPO po) {
        po.setUpdateTime(new Date());
        mapper.updateByPrimaryKey(po);
    }

    @Override
    public void del(TunnelCheckItemBO bo) {
        TunnelCheckItemPO checkItemPO = new TunnelCheckItemPO();
        checkItemPO.setDeleteStatus(1L);
        checkItemPO.setCheckItemId(bo.getCheckItemId());
        checkItemMapper.updateByPrimaryKey(checkItemPO);
        TunnelInspectionReportPO tunnelInspectionReportPO = new TunnelInspectionReportPO();
        tunnelInspectionReportPO.setDeleteStatus(1L);
        tunnelInspectionReportPO.setInspectionReportId(bo.getInspectionReportId());
        mapper.updateByPrimaryKey(tunnelInspectionReportPO);
    }

    /**
     *
     *
     * @param key
     * @return
     */
    @Override
    public TunnelInspectionReport2VO dit(String key) {
        StringBuffer stringBuffer = new StringBuffer();
        TunnelInspectionReport2VO vo = mapper.findByPK(key);
        vo.setInspectionReportId(key);
        List<String> list = checkItemMapper.findByFk(key);
        list.forEach((v) -> {
            switch (v.toString()){//0钢拱架间距 1喷射混凝土厚度 2 喷射混凝土及其背后密实,,脱空情况 3 净空断面
                case "0":
                    stringBuffer.append("钢拱架间距" + ",");
                    break;
                case "1":
                    stringBuffer.append("喷射混凝土厚度" + ",");
                    break;
                case "2":
                    stringBuffer.append("喷射混凝土及其背后密实,脱空情况 " + ",");
                    break;
                case "3":
                    stringBuffer.append("净空断面" + ",");
                    break;
                    default:break;
            }
        });
        vo.setCheckItem(stringBuffer.replace(stringBuffer.toString().lastIndexOf(","), stringBuffer.lastIndexOf(",") + 1, "").toString());
      //node模板
        return vo;
    }

    @Override
    public List<SysParamVo> getInspectionArea(String param) {
        return sysParamMapper.getLaneNumList(param);
    }
}
