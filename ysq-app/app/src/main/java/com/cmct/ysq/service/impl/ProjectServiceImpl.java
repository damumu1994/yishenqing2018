package com.cmct.ysq.service.impl;

import com.cmct.ysq.mapper.ProjectMapper;
import com.cmct.ysq.model.po.TunnelProjectPo;
import com.cmct.ysq.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectMapper mapper;
    @Override
    public List<TunnelProjectPo> getList(String userId) {
        return mapper.getList(userId);
    }

    @Override
    public List<TunnelProjectPo> getListByCityCode(String cityCode) {
        return mapper.getListByCityCode(cityCode);
    }

    @Override
    public List<TunnelProjectPo> findByprojectNameLike(String projectName,String cityCode) {
        return mapper.findByprojectNameLike(projectName,cityCode);
    }

    @Override
    public List<Map<String,Object>> projectListeLikeNam(String param) {
        return mapper.projectListeLikeNam(param);
    }

    @Override
    public List<Map<String, Object>> getCityList() {
        return mapper.getCityList();
    }
}
