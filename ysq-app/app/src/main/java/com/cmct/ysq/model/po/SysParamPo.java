package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * <p>
 * 路面系统参数
 * </p>
 *
 * @author shen123
 * @since 2018-05-21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_sys_param")
public class SysParamPo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @Id
    private String paramId;
    /**
     * 参数名
     */
    @Column(name = "param_name")
    private String paramName;
    /**
     * 参数代码
     */
    @Column(name = "param_code")
    private String paramCode;
    /**
     * 父参数ID
     */
    @Column(name = "parent_id")
    private String parentId;
    @Column
    private String des;

    /**
     * 顺序
     */
    private Integer paramOrder;
    @Column(name = "create_date")
    private Date createDate;
    @Column(name = "modify_date")
    private Date modifyDate;
    @Column(name = "create_by")
    private String createBy;
    @Column(name = "modify_by")
    private String modifyBy;
    /**
     * 0,是删除，1是未删除，默认是0
     */
    @Column(name = "delete_status")
    private Integer deleteStatus;



    /**
     * 历史数据状态，默认是0，0是当前最新数据，1是历史修改数据
     */
    @Column
    private Integer validStatus;
    /**
     * 历史修改历史编号
     */
    @Column
    private String hisCode;

}
