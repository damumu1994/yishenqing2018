package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.bo.DepartQueryBo;
import com.cmct.ysq.model.po.SysDepartPo;
import com.cmct.ysq.model.vo.SysDepartVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shen
 * @email sunlightcs@gmail.com
 * @date 2018-07-17 17:12:48
 */
public interface SysDepartMapper extends BaseMapper<SysDepartPo> {


    /**
     * 查询符合条件的部门列表
     *
     * @param departQuery 查询条件
     * @return
     */
    List<SysDepartVo> getDepartList(DepartQueryBo departQuery);

    /**
     * 根据 typeId  name  模糊查询
     * @param typeId
     * @param departName
     * @return
     */
    @Select(value = "select  * from   t_sys_depart where  type_id=#{typeId} and  delete_status=0 and  depart_name like  concat('%',#{departName},'%') order by  create_date desc")
    List<SysDepartVo> getDepartListLikeByDepartName(String typeId,String departName);
}
