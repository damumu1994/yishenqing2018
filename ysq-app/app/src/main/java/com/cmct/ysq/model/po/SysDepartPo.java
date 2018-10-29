package com.cmct.ysq.model.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author shen
 * @email sunlightcs@gmail.com
 * @date 2018-07-17 17:12:48
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_sys_depart")
public class SysDepartPo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @Id
    private String departId;
    /**
     * 部门名称
     */
    @Column
    private String departName;
    /**
     * 描述
     */
    @Column
    private String departDescr;
    /**
     * 父部门
     */
    @Column
    private String parentId;

    /**
     * 部门类型id
     */
    @Column
    private String typeId;
    /**
     * 删除状态,默认是0，0是未删除，1是已删除
     */
    @Column
    private Integer deleteStatus;
    /**
     * 创建人
     */
    @Column
    private String createBy;
    /**
     * 修改人
     */
    @Column
    private String modifyBy;
    /**
     * 创建时间
     */
    @Column
    private Date createDate;
    /**
     * 修改时间
     */
    @Column
    private Date modifyDate;
    /**
     * 历史修改状态，0是最新的数据，1是历史修改数据
     */
    @Column
    private Integer validStatus;
    /**
     * 顺序
     */
    @Column
    private Integer paramOrder;
    /**
     * 历史修改历史编号
     */
    @Column
    private String hisCode;


}
