package com.cmct.ysq.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 下载边坡信息
 */


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DownloadSlopeVO {
    /**
     * 检查记录id
     */
    private String checkId;
    /**
     * 起始桩号
     */
    private Long pegNoStart;
    /**
     * 结束桩号
     */
    private Long pegNoEnd;
    /**
     * 位置,边坡位于道路左侧还是右侧:0左侧;1右侧
     */
    private Integer side;
    /**
     * 已有病害数量
     */
    private Integer diseaseCount;
    /**
     * 检查时间
     */
    private Date checkDate;
    /**
     * 是否勾选
     */
    private boolean isCheck;

    /**
     * 边坡id
     */
    private String slopeId;

}
