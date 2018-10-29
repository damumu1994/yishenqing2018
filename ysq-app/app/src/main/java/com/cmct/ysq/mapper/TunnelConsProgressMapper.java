package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelConsProgressPo;
import com.cmct.ysq.model.vo.TunnelProgressBaseVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 隧道施工进度
 *
 * @author shen
 * @email 1292@qq.com
 * @date 2018-07-24 06:08:14
 */
@Mapper
public interface TunnelConsProgressMapper extends BaseMapper<TunnelConsProgressPo> {

    List<TunnelProgressBaseVo> getTunnelProgressBaseInfoList();


    List<String> getHisConsProgressList(@Param("hisCode") String hisCode);

    /**
     * 获取最新掌子面
     *
     * @param tunnelId
     * @param tunnelDirId
     * @param tunnelHoleId
     * @return
     */
    TunnelConsProgressPo getNewestFaceDistance(@Param("tunnelId") String tunnelId,
                                               @Param("tunnelDirId") String tunnelDirId,
                                               @Param("tunnelHoleId") String tunnelHoleId);


}
