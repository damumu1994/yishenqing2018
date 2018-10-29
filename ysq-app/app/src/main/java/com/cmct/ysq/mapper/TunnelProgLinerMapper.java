package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProgLinerPo;
import com.cmct.ysq.model.vo.TunnelProgLinerVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 施工进度-二衬的详细数据
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 07:17:35
 */
@Mapper
public interface TunnelProgLinerMapper extends BaseMapper<TunnelProgLinerPo> {

    /**
     * @param constructProgressId
     * @return
     */
    List<TunnelProgLinerVo> getConstructProgressHisInfo(String constructProgressId);

}
