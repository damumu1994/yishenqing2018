package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.po.TunnelGeoForcastPO;
import com.cmct.ysq.model.vo.TunnelGeoForcast2Vo;
import com.cmct.ysq.model.vo.TunnelGeoForcastVO;
import com.cmct.ysq.model.where.TunnelGeoForcastWhere;

public interface TunnelGeoForcastService {
    JsonPage<TunnelGeoForcastVO>paramsQuery(TunnelGeoForcastWhere params) throws Exception;
    void del(TunnelGeoForcastPO po);
    void add(TunnelGeoForcastPO[] po);
    void update(TunnelGeoForcastPO po);
    TunnelGeoForcastVO getInfofindByPk(String key);
    TunnelGeoForcast2Vo findByPk(String key);
}
