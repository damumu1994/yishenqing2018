package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.bo.SysParamsBo;
import com.cmct.ysq.model.po.SysParamPo;
import com.cmct.ysq.model.vo.SysParamVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 系统参数 Mapper 接口
 * </p>
 *
 * @author shen
 * @since 2018-05-21
 */
public interface SysParamMapper extends BaseMapper<SysParamPo> {


    List<SysParamVo> getSysParams();


    SysParamVo getSysParamDetail(SysParamsBo bo);
    //001001
    @Select(value = "SELECT  * FROM t_sys_param  WHERE parent_id=#{param} and delete_status=0")
    List<SysParamVo> getLaneNumList(String param);
}
