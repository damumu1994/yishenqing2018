package com.cmct.ysq.model.vo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TunnelGeoForcast2Vo {
    private BigDecimal pegStart;
    private BigDecimal pegEnd;
    private String surrRockLevelLower;
    private String surrRockLevelUpper;
    private String tunnelId;


}
