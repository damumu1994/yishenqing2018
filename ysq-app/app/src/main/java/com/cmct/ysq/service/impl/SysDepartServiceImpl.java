package com.cmct.ysq.service.impl;

import com.cmct.base.exception.CmctError;
import com.cmct.common.bean.JsonPage;
import com.cmct.common.exception.Exceptions;
import com.cmct.ysq.mapper.SysDepartMapper;
import com.cmct.ysq.model.bo.DepartQueryBo;
import com.cmct.ysq.model.bo.SysDepartForAddBo;
import com.cmct.ysq.model.bo.SysDepartForUpdateBo;
import com.cmct.ysq.model.vo.SysDepartVo;
import com.cmct.ysq.service.ISysDepartService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
public class SysDepartServiceImpl implements ISysDepartService {


    @Autowired
    private SysDepartMapper sysDepartMapper;

    @Override
    public JsonPage<SysDepartVo> getDepartList(DepartQueryBo departQuery) {

        if (departQuery == null) {
            departQuery = new DepartQueryBo();
        }

        Page<SysDepartVo> page = PageHelper.startPage(departQuery.getPage(), departQuery.getRows());
        sysDepartMapper.getDepartList(departQuery);

        return new JsonPage(page);
    }


    //TODO
    @Override
    public void updateDepart(String departId, SysDepartForUpdateBo sysDepartForUpdate, String modifyBy) {
        if (StringUtils.isEmpty(departId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "departId不能为空");
        }


    }

    //TODO
    @Override
    public void addDepart(SysDepartForAddBo sysDepartForAdd, String createBy) {

    }

    //TODO
    @Override
    public void deleteDepart(String deleteDepart, String createBy) {

    }
}
