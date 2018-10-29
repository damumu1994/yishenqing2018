package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProgPitPo;
import com.cmct.ysq.model.vo.TunnelProgPitVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工进度-双层壁导坑法
 * 
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Mapper
public interface TunnelProgPitMapper extends BaseMapper<TunnelProgPitPo> {

    List<TunnelProgPitVo> getConstructProgressHisInfo(@Param("constructProgressIds") List<String> constructProgressIds);

}
