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
 * 用户
 * </p>
 *
 * @author shen
 * @since 2018-07-13
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_sys_user")
public class SysUserPo {

    private static final long serialVersionUID = 1L;

    @Id
    private String userId;
    /**
     * 登录账号
     */
    @Column
    private String username;
    /**
     * 密码
     */
    @Column

    private String password;
    /**
     * 性别，0是未知，1是男，0是女，其他值为未知
     */
    @Column
    private Integer sex;
    /**
     * 真实姓名
     */
    @Column
    private String realName;
    /**
     * 头像地址
     */
    @Column
    private String headUrl;
    /**
     * 部门id
     */
    @Column
    private String departId;
    /**
     * 邮箱地址
     */
    @Column
    private String email;
    /**
     * 联系电话
     */
    @Column
    private String mobile;
    /**
     * 生日
     */
    @Column
    private Date birthday;
    /**
     * 岗位
     */
    @Column
    private String jobName;
    /**
     * 职称
     */
    @Column
    private String title;
    /**
     * 持证资格
     */
    @Column
    private String certificate;
    /**
     * 证书号
     */
    @Column
    private String certificateNo;
    /**
     * 备注
     */
    @Column
    private String remark;
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
     * 创建时间
     */
    @Column
    private Date createDate;
    /**
     * 修改人
     */
    @Column
    private String modifyBy;
    /**
     * 修改时间
     */
    @Column
    private Date modifyDate;
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
