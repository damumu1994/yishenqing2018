package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.AddSysUserVo;
import com.cmct.ysq.model.bo.SysUserQueryBo;
import com.cmct.ysq.model.po.SysUserPo;
import com.cmct.ysq.model.vo.SysUserVo;

import java.util.List;

/**
 * <p>
 * 用户 服务类
 * </p>
 *
 * @author shen
 * @since 2018-07-13
 */
public interface ISysUserService {


    /**
     * 获取某个用户的基本信息
     *
     * @param userName
     * @return
     */
    SysUserPo getUserInfo(String userName);

    /**
     * 获取所有新系统用户的信息
     *
     * @param request
     * @return
     */
    JsonPage<SysUserVo> getSysUserVos(SysUserQueryBo request);

    /**
     * 给用户分配角色
     *
     * @param userId   用户id
     * @param roleIds  角色id列表
     * @param modifyBy
     */
    void updateUserRoles(String userId, List<String> roleIds, String modifyBy);

    /**
     * 重置用户的密码
     *
     * @param userId   用户id
     * @param modifyBy
     */
    void resetUserPwd(String userId, String modifyBy);


    /**
     * 删除用户
     *
     * @param userId   用户id
     * @param modifyBy 修改人
     */
    void deleteUser(String userId, String modifyBy);


    /**
     * @param newSysUser 新增用户的信息
     * @param createBy   新增人
     */
    void addNewUser(AddSysUserVo newSysUser, String createBy);


    /**
     * 判断用户是否存在
     *
     * @param userId
     * @param mobile
     * @return
     */
    boolean uniMobile(String userId, String mobile);


    /**
     * 更新用户
     *
     * @param userS 用户
     * @return 返回值含义的说明
     */
    void modify(SysUserPo userS) throws Exception;
}
