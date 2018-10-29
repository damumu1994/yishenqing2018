package com.cmct.ysq.service.impl;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.mapper.SysVersionDOMapper;
import com.cmct.ysq.model.bo.SysVersionForAddBo;
import com.cmct.ysq.model.bo.SysVersionForUpdateBo;
import com.cmct.ysq.model.bo.SysVersionQueryBo;
import com.cmct.ysq.model.po.SysVersionPo;
import com.cmct.ysq.model.vo.SysVersionVo;
import com.cmct.ysq.service.SysVersionService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * 版本服务实现
 */
@Service
@Transactional
public class SysVersionServiceImpl implements SysVersionService {

    @Autowired
    private SysVersionDOMapper versionMapper;

    @Override
    public JsonPage<SysVersionVo> page(SysVersionQueryBo sysVersionQuery) {
        if (null == sysVersionQuery) {
            sysVersionQuery = new SysVersionQueryBo();
        }
        Page<SysVersionVo> page = PageHelper.startPage(sysVersionQuery.getPage(), sysVersionQuery.getRows());
        versionMapper.page(sysVersionQuery);
        return new JsonPage<>(page);
    }


    //TODO
    @Override
    public void save(SysVersionForAddBo sysVersionForAdd, String createBy) {
        SysVersionPo sysVersionPo = SysVersionPo.builder().build();
        BeanUtils.copyProperties(sysVersionForAdd, sysVersionPo);
        sysVersionPo.setVersionId(UUID.randomUUID().toString());
        sysVersionPo.setCreateBy(createBy);
        sysVersionPo.setCreateDate(new Date());
        sysVersionPo.setDeleteStatus(DeleteStatus.YES.ordinal());
        versionMapper.insertSelective(sysVersionPo);
    }

    //TODO
    @Override
    public void update(SysVersionForUpdateBo sysVersionForUpdate, String modifyBy,
                       String versionId) {
        SysVersionPo sysVersionPo = SysVersionPo.builder().build();
        BeanUtils.copyProperties(sysVersionForUpdate, sysVersionPo);
        sysVersionPo.setVersionId(versionId);
        sysVersionPo.setModifyBy(modifyBy);
        sysVersionPo.setModifyDate(new Date());
        versionMapper.updateByPrimaryKeySelective(sysVersionPo);
    }

    //TODO
    @Override
    public void remove(String versionId, String modifyBy) {
        versionMapper.updateByPrimaryKeySelective(SysVersionPo.builder()
                .deleteStatus(DeleteStatus.NO.ordinal())
                .versionId(versionId)
                .modifyDate(new Date())
                .modifyBy(modifyBy)
                .build());
    }

}
