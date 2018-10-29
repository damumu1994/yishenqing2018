package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProgThreeStepPo;
import com.cmct.ysq.model.vo.TunnelProgThreeStepVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工进度-三台阶法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Mapper
public interface TunnelProgThreeStepMapper extends BaseMapper<TunnelProgThreeStepPo> {

    List<TunnelProgThreeStepVo> getConstructProgressHisInfo(@Param("constructProgressIds") List<String> constructProgressIds);

}
