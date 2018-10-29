package com.cmct.ysq.model.vo;

import com.cmct.ysq.model.po.TunnelGeoForcastPO;
import lombok.Data;

@Data
public class TunnelGeoForcastVO extends TunnelGeoForcastPO {
 /*   private String geoForcastId;

    private Date forcastDate;
    private String forcastMethod;
    private BigDecimal pegStart;
    private BigDecimal pegEnd;*/
     private String dirName;
     private  String holeName;
     private String   tunnelName;
}
