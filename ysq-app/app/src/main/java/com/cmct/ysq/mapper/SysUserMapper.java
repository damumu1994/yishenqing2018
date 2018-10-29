package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.bo.SysUserQueryBo;
import com.cmct.ysq.model.po.SysUserPo;
import com.cmct.ysq.model.vo.SysUserVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 用户 Mapper 接口
 * </p>
 *
 * @author shen
 * @since 2018-07-13
 */
public interface SysUserMapper extends BaseMapper<SysUserPo> {

    SysUserPo findSysUserByUserName(@Param("userName") String userName);


    List<SysUserVo> findAllSysUsers(SysUserQueryBo sysUserQueryBo);

}
