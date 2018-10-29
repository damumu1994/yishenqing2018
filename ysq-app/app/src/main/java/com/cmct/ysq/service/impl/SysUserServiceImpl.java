package com.cmct.ysq.service.impl;

import com.cmct.base.constant.DeleteStatus;
import com.cmct.base.exception.CmctError;
import com.cmct.common.bean.JsonPage;
import com.cmct.common.exception.Exceptions;
import com.cmct.common.util.ObjUtil;
import com.cmct.ysq.mapper.SysUserMapper;
import com.cmct.ysq.model.bo.AddSysUserVo;
import com.cmct.ysq.model.bo.SysUserQueryBo;
import com.cmct.ysq.model.po.SysUserPo;
import com.cmct.ysq.model.vo.SysUserVo;
import com.cmct.ysq.service.ISysUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author shen
 * @since 2018-07-13
 */
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Value("${user.default-pwd}")
    private String defaultPwd;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUserPo getUserInfo(String userName) {
        if (StringUtils.isEmpty(userName)) {
            return null;
        }
        return sysUserMapper.findSysUserByUserName(userName);
    }

    //TODO
    @Override
    public JsonPage<SysUserVo> getSysUserVos(SysUserQueryBo pageReq) {

        if (pageReq == null) {
            pageReq = new SysUserQueryBo();
        }

        Page<SysUserVo> page = PageHelper.startPage(pageReq.getPage(), pageReq.getRows());
        sysUserMapper.findAllSysUsers(pageReq);

        return new JsonPage(page);
    }

    //TODO
    @Override
    public void updateUserRoles(String userId, List<String> roleIds, String modifyBy) {

        if (StringUtils.isEmpty(userId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "userId不能为空");
        }

        if (CollectionUtils.isEmpty(roleIds)) {

        }
    }

    @Override
    public void resetUserPwd(String userId, String modifyBy) {
        if (StringUtils.isEmpty(userId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "userId不能为空");
        }

        sysUserMapper.updateByPrimaryKeySelective(SysUserPo.builder()
                .password(defaultPwd)
                .modifyBy(modifyBy)
                .modifyDate(new Date())
                .userId(userId)
                .build());
    }


    @Override
    public void deleteUser(String userId, String modifyBy) {
        if (StringUtils.isEmpty(userId)) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "userId不能为空");
        }

        sysUserMapper.updateByPrimaryKeySelective(SysUserPo.builder()
                .deleteStatus(DeleteStatus.NO.ordinal())
                .modifyDate(new Date())
                .modifyBy(modifyBy)
                .userId(userId)
                .build());
    }

    //todo
    @Override
    public void addNewUser(AddSysUserVo newSysUser, String modifyBy) {
        if (newSysUser == null) {
            throw Exceptions.createException(CmctError.PARAM_ERROR, "用户信息不能为空");
        }

        SysUserPo sysUserTargetPo = SysUserPo.builder().build();
        BeanUtils.copyProperties(newSysUser, sysUserTargetPo);
        sysUserTargetPo.setCreateBy(modifyBy);
        sysUserTargetPo.setCreateDate(new Date());
        sysUserTargetPo.setDeleteStatus(DeleteStatus.YES.ordinal());
        sysUserTargetPo.setUserId(UUID.randomUUID().toString());
        sysUserMapper.insertSelective(sysUserTargetPo);
    }


    @Override
    public boolean uniMobile(String userId, String mobile) {
        Example userEx = new Example(SysUserPo.class);
        Example.Criteria criteria = userEx.createCriteria()
                .andEqualTo("username", mobile)
                .andEqualTo("deleteStatus", DeleteStatus.YES.ordinal());
        if (ObjUtil.isNotNull(userId)) {//修改
            criteria.andNotEqualTo("userId", userId);
        }
        List<SysUserPo> users = sysUserMapper.selectByExample(userEx);
        return users.size() <= 0;
    }

    @Override
    public void modify(SysUserPo user) {
        user.setModifyDate(new Date());
        user.setUsername(user.getMobile());
        sysUserMapper.updateByPrimaryKeySelective(user);
    }

}
