package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProgTwoStepPo;
import com.cmct.ysq.model.vo.TunnelProgTwoStepVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工进度-二台阶法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Mapper
public interface TunnelProgTwoStepMapper extends BaseMapper<TunnelProgTwoStepPo> {

    List<TunnelProgTwoStepVo> getConstructProgressHisInfo(@Param("constructProgressIds") List<String> constructProgressId);

}
