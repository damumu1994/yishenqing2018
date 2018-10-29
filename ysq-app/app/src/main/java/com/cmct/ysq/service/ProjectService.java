package com.cmct.ysq.service;

import com.cmct.ysq.model.po.TunnelProjectPo;

import java.util.List;
import java.util.Map;

public interface ProjectService {
    List<TunnelProjectPo> getList(String userId);
    List<TunnelProjectPo> getListByCityCode(String cityCode);
    List<TunnelProjectPo>findByprojectNameLike( String projectName,String cityCode);
    List<Map<String,Object>>  projectListeLikeNam(String param);
    List<Map<String,Object>>  getCityList();
}
