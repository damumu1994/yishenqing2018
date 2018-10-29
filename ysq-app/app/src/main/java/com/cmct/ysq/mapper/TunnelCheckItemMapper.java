package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelCheckItemPO;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TunnelCheckItemMapper extends BaseMapper<TunnelCheckItemPO> {
    @Select("SELECT\tcheck_item_type FROM\tt_tunnel_check_item WHERE\tinspection_report_id= #{id}")
    public List<String> findByFk(String id);

@Select(value = "select  * from t_tunnel_check_item where inspection_report_id= #{id} ")
    public List<TunnelCheckItemPO> getInfoByFk(String id);
}
