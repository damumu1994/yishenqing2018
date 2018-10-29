package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelProjectPo;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ProjectMapper extends BaseMapper<TunnelProjectPo> {
    /**
     * 得到list集合  暂时查询所有
     * @return
     */
    @Select(value = "select * from t_tunnel_project")
    List<TunnelProjectPo> getList(String userId);
    @Select(value = "select * from t_tunnel_project where city_code=#{cityCode}")
    List<TunnelProjectPo> getListByCityCode(String cityCode);

    /**
     * 模糊查询
     * @param projectName
     * @return
     */
    @Select(value = "SELECT project_id,project_name FROM t_tunnel_project WHERE project_name LIKE CONCAT('%',#{projectName},'%') AND delete_status=0  AND city_code=#{cityCode} ORDER BY create_date DESC")
    List<TunnelProjectPo>findByprojectNameLike( String projectName,String cityCode);
    @Select(value = "SELECT * FROM t_tunnel_project WHERE project_name LIKE CONCAT('%',#{projectName},'%') AND delete_status=0   ORDER BY create_date DESC")
    List<Map<String,Object>>findByprojectNameLikeList(String projectName);

@Select(value = "SELECT * FROM t_tunnel_project WHERE project_name LIKE CONCAT('%',#{projectName}','%') ORDER BY create_date DESC")
    List<Map<String,Object>>projectListeLikeNam(String projectName);
@Select(value = "select s.param_id,s.param_name from  t_sys_param as s where s.parent_id=003001")
    List<Map<String,Object>>getCityList();
}
