package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProParamLinkPo;
import com.cmct.ysq.model.vo.TunnelProParamLinkVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * create by Administrator
 */
public interface TunnelProParamLinkMapper extends BaseMapper<TunnelProParamLinkPo> {
    /**
     * 根据隧道id获取隧道方向
     *
     * @return
     */
    @Select(value = "SELECT p.*,s.param_name FROM t_tunnel_param_link  as p LEFT JOIN t_sys_param as s ON p.param_id=s.param_id WHERE   p.delete_status=0  AND s.delete_status=0 AND p.tunnel_pro_id=#{tunnelProId}")
    List<TunnelProParamLinkVo> getList(String tunnelProId);


}
