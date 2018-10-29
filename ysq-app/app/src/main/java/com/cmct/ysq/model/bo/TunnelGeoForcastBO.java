package com.cmct.ysq.model.bo;


import com.cmct.common.bean.BaseWhere;
import lombok.Data;

import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Table(name = "t_tunnel_geo_forcast")
public class TunnelGeoForcastBO extends BaseWhere {
    @Id
    private String geoForcastId;
    private String dirId;
    private String holeId;
    private Date forcastDate;
    private String forcastMethod;
    private BigDecimal pegStart;
    private BigDecimal pegEnd;
    private String surrRockLevelLower;
    private Long surrRockLevelLowerStren;
    private String surrRockLevelUpper;
    private Long surrRockLevelUpperStren;
    private String geoDes;
    private Long deleteStatus;

}
