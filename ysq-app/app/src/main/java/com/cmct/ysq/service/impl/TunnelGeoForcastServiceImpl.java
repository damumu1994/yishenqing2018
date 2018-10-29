package com.cmct.ysq.service.impl;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.mapper.TunnelGeoForcastDOMapper;
import com.cmct.ysq.model.po.TunnelGeoForcastPO;
import com.cmct.ysq.model.vo.TunnelGeoForcast2Vo;
import com.cmct.ysq.model.vo.TunnelGeoForcastVO;
import com.cmct.ysq.model.where.TunnelGeoForcastWhere;
import com.cmct.ysq.service.TunnelGeoForcastService;
import com.cmct.ysq.util.IDUtil;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;


import javax.transaction.Transactional;
import java.util.Date;

@Service
@Transactional
public class TunnelGeoForcastServiceImpl implements TunnelGeoForcastService {
    @Autowired
    private TunnelGeoForcastDOMapper mapper;

   @Override
    public JsonPage<TunnelGeoForcastVO> paramsQuery(TunnelGeoForcastWhere params)throws Exception  {
        if (ObjectUtils.isEmpty(params)) {
            params=new TunnelGeoForcastWhere();
        }
        Page<TunnelGeoForcastVO> page = PageHelper.startPage(params.getPage(), params.getRows());
        mapper.paramsQuery(params);

       //mapper.getAll2();
        return new JsonPage(page);
    }
    @Override
    public void del(TunnelGeoForcastPO tunnelGeoForcastPO) {
        tunnelGeoForcastPO.setModifyDate(new Date());
        tunnelGeoForcastPO.setDeleteStatus(1L);
        mapper.updateByPrimaryKey(tunnelGeoForcastPO);
    }

    @Override
    public void add(TunnelGeoForcastPO[] po) {
       if (null==po) return;
        for (TunnelGeoForcastPO po1 : po) {
            try {

                po1.setGeoForcastId(IDUtil.getId());
                po1.setCreateDate(new Date());
                mapper.insert(po1);
            }catch (Exception e){
                return;
            }
        }

    }
    @Override
    public void update(TunnelGeoForcastPO tunnelGeoForcastPO) {
        tunnelGeoForcastPO.setModifyDate(new Date());
       mapper.updateByPrimaryKey(tunnelGeoForcastPO) ;
    }

    @Override
    public TunnelGeoForcastVO getInfofindByPk(String key) {
        return mapper.getInfofindByPk(key);
    }

    @Override
    public TunnelGeoForcast2Vo findByPk(String key) {
        return mapper.findByPk(key);
    }
}
