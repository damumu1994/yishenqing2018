package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.bo.TunnelTransBo;
import com.cmct.ysq.model.po.TunnelInfoPo;
import com.cmct.ysq.model.vo.SysParamVo;
import com.cmct.ysq.model.vo.TunnelInfoVo;
import com.cmct.ysq.model.vo.TunnelTrans2Vo;
import com.cmct.ysq.model.vo.TunnelTransVo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * create by Administrator
 */
public interface TunnelInfoMapper extends BaseMapper<TunnelInfoPo> {
    @Select(value = "SELECT\n" +
            "\tp.project_id,p.project_name,\n" +
            "\tt.tunnel_pro_id,t.tunnel_name \n" +
            "FROM\n" +
            "\tt_tunnel_project AS p\n" +
            "\tLEFT JOIN t_tunnel_info AS t ON p.project_id = t.project_id\n" +
            "\tWHERE p.project_id=#{projectId}\n" +
            "\tORDER BY t.create_by desc\n" +
            "\t")
    List<Map<String, Object>> getList(String projectId);

    @Select(value = "")
    List<Map<String, Object>> fondByTunnelNameLikeAndprojectId(String projectId);

    @Select(value = "\tSELECT * FROM t_tunnel_info  as p\n" +
            "\tLEFT JOIN t_tunnel_depart_link as l\n" +
            "\tON  p.tunnel_pro_id=l.tunnel_pro_id\n" +
            "\tWHERE p.tunnel_pro_id=#{tunnelProId}")
    TunnelInfoVo getTunnelInfo(String tunnelProId);

    @Select(value = "SELECT * from t_tunnel_info WHERE tunnel_name like CONCAT('%',#{tunnelName},'%') AND delete_status=0 ORDER BY create_date  DESC")
    List<Map<String, Object>> getListByTunnelNameLike(String tunnelName);

    /**
     * 根据条件筛选 pad
     *
     * @param bo
     * @return
     */
    List<TunnelTransVo> findListByTunnelTransBo(TunnelTransBo bo);

    List<TunnelTrans2Vo> getTunnelMonitoringInformation(TunnelTransBo bo);

    /**
     * 获取隧道的方向配置信息
     *
     * @param tunnelId
     * @param typeCodes 方向或者洞口code
     * @return
     */
    List<SysParamVo> getTunnelDirOrHoleInfo(@Param("tunnelId") String tunnelId, @Param("typeCodes") List<String> typeCodes);
}
