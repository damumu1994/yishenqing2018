package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelHoleLinkPo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * @author lxb
 * @Date 2018/7/20 14:45
 */
public interface TunnelHoleLinkMappper extends BaseMapper<TunnelHoleLinkPo> {
    @Select(value = "SELECT l.*,p.param_name FROM t_tunnel_hole_link as l LEFT JOIN t_sys_param as p ON l.param_id=p.param_id WHERE l.tunnel_pro_id=#{tunnelId}' and l.delete_status=0 and p.delete_status=0")
     List<Map<String,Object>> findByTunnelId(String tunnelId);
    //select  l.*,p.param_name from t_tunnel_hole_link as l  left join t_sys_param as p on l.param_id=p.param_id where l.delete_status=0 and  p.delete_status=0 and l.tunnel_pro_id='ew'
}
