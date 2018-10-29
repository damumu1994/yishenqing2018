
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
 * 在线更新表
 *
 * @author losing
 * @Date 2016年8月18日
 * @since v0.1
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_sys_version")
public class SysVersionPo {

    /**
     * id
     */
    @Id
    private String versionId;

    /**
     * 版本名
     */
    @Column
    private String versionName;

    /**
     * 版本编号
     */
    @Column
    private String versionCode;

    /**
     * 版本描述
     */
    @Column
    private String versionDescr;

    /**
     * 版本地址
     */
    @Column
    private String versionUrl;
    /**
     * app类型，0是pad，1是查看
     * ，默认是0
     */
    @Column
    private Integer type;
    @Column
    private Date createDate;
    @Column
    private Date modifyDate;

    @Column
    private Integer deleteStatus;
    @Column
    private String createBy;
    @Column
    private String modifyBy;
    @Column
    private Integer validStatus;
    @Column
    private String hisCode;

}
