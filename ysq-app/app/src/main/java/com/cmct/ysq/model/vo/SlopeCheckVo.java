package com.cmct.ysq.model.vo;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


/**
 * 边坡项目检测 vo
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/3/28
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SlopeCheckVo extends BaseVo {
    private String checkId;// 检查记录ID
    private Integer checkType;// 检查类型[1日常/2经常/3定期/4特殊]
    private Date checkDate;// 检查开始时间
    private Date checkDateEnd;// 检查结束时间
    private String slopeId;// 边坡ID
    private String responsiblePerson;// 负责人
    private String checkPerson;// 检查人员
    private Double score;// 得分
    private String proClassifyId;// 边坡评分分类ID
    private String checkStatus;// 检查状态(0 正在检测 1已完成)
    private String projectId;//所属项目
    private String departId;// 数据权限（对应部门ID）
    private Date createDate;
    private Date updateDate;
    private String temperature;//温度
    private String weather;//天气
    private String checkItem;

}
