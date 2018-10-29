/**
 * Copyright (c) @2016,cmct 版权所有
 */
package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelGeoForcastPO;
import com.cmct.ysq.model.vo.TunnelGeoForcast2Vo;
import com.cmct.ysq.model.vo.TunnelGeoForcastVO;
import com.cmct.ysq.model.where.TunnelGeoForcastWhere;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shen
 * @date 2018/7/12
 */
public interface TunnelGeoForcastDOMapper extends BaseMapper<TunnelGeoForcastPO> {

    /**
     * @return
     * @throws Exception
     */
    List<TunnelGeoForcastVO>paramsQuery(TunnelGeoForcastWhere params);
    @Select(value = " SELECT s1.param_name as holeName,s2.param_name as dirName,i.tunnel_name,t.* FROM `cmct-tunnel`.t_tunnel_geo_forcast t\n" +
            "      left join t_tunnel_info as i on i.tunnel_pro_id=tunnel_pro_id\n" +
            "       left join t_sys_param as s1 on  s1.param_id=t.hole_id\n" +
            "      left join  t_sys_param as s2 on  s2.param_id=t.dir_id\n" +
            "      where\n" +
            "     t.geo_forcast_id=concat(#{key})\n" +
            "       and t.delete_status=0")
   TunnelGeoForcastVO getInfofindByPk(String key);
    @Select(value = "SELECT\n" +
            "  t.peg_start,t.peg_end,t.tunnel_id,surr_rock_level_lower,t.surr_rock_level_upper\n" +
            "FROM\n" +
            "  `cmct-tunnel`.t_tunnel_geo_forcast t\n" +
            "WHERE\n" +
            "  t.geo_forcast_id = concat(#{key})\n" +
            "  AND t.delete_status =0")
    TunnelGeoForcast2Vo findByPk(String key);
}
