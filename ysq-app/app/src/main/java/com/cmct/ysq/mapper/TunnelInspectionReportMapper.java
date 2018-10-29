package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.po.TunnelInspectionReportPO;
import com.cmct.ysq.model.vo.TunnelInspectionReport2VO;
import com.cmct.ysq.model.vo.TunnelInspectionReportVO;
import com.cmct.ysq.model.where.TunnelInspectionReportWhere;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TunnelInspectionReportMapper extends BaseMapper<TunnelInspectionReportPO> {
    List<TunnelInspectionReportVO> paramsQuery(TunnelInspectionReportWhere where);
    @Select("SELECT\n" +
            "\tr.inspection_report_id,\n" +
            "\tr.tunnel_id,\n" +
            "\tr.direction,\n" +
            "\tr.hole,\n" +
            "\tr.report_number,\n" +
            "\tr.check_time,\n" +
            "\tr.start_pile_no,\n" +
            "\tr.end_pile_no,\n" +
            "\tr.check_area,\n" +
            "r.original_record_url,\n" +
            "\tr.create_time,\n" +
            "r.update_time,\n" +
            "r.create_by,\n" +
            "\tr.update_by,\n" +
            "\tr.delete_status,\n" +
            "   p.tunnel_name\t\n" +
            "FROM\n" +
            "\tt_tunnel_inspection_report as r INNER JOIN t_tunnel_info as p  ON r.tunnel_id=p.tunnel_pro_id\n" +
            "WHERE\n" +
            "\tr.inspection_report_id = #{key}")
    TunnelInspectionReport2VO findByPK(String key);



}
