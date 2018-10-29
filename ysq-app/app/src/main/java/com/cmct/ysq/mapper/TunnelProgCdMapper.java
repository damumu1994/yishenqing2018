package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProgCdPo;
import com.cmct.ysq.model.vo.TunnelProgCdVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工进度-CD法
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:36
 */
@Mapper
public interface TunnelProgCdMapper extends BaseMapper<TunnelProgCdPo> {

    List<TunnelProgCdVo> getConstructProgressHisInfo(@Param("constructProgressIds") List<String> constructProgressIds);

}
