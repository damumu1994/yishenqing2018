package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProgFullFacePo;
import com.cmct.ysq.model.vo.TunnelProgFullFaceVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工进度-全断面法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Mapper
public interface TunnelProgFullFaceMapper extends BaseMapper<TunnelProgFullFacePo> {

    List<TunnelProgFullFaceVo> getConstructProgressHisInfo(@Param("constructProgressIds") List<String> constructProgressIds);

}
