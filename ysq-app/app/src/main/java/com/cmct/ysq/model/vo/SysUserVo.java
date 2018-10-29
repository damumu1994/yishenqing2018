package com.cmct.ysq.model.vo;

import com.cmct.ysq.model.po.SysUserPo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class SysUserVo {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    private String userId;
    @ApiModelProperty("登录账号")
    private String username;
    @ApiModelProperty("性别，0是未知，1是男，0是女，其他值为未知")
    private Integer sex;
    @ApiModelProperty("真实姓名")
    private String realName;
    @ApiModelProperty("头像地址")
    private String headUrl;
    @ApiModelProperty("部门id")
    private String departId;
    @ApiModelProperty("邮箱地址")
    private String email;
    @ApiModelProperty("联系电话")
    private String mobile;
    @ApiModelProperty("生日")
    private Date birthday;
    @ApiModelProperty("岗位")
    private String jobName;
    @ApiModelProperty("职称")
    private String title;
    @ApiModelProperty("持证资格")
    private String certificate;
    @ApiModelProperty("证书号")
    private String certificateNo;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("创建人")
    private String createBy;
    private String modifyBy;
    @ApiModelProperty("注册时间")
    private Date createDate;

    public static SysUserVo transfer(SysUserPo sysUserPo) {
        return SysUserVo.builder()
                .userId(sysUserPo.getUserId())
                .username(sysUserPo.getUsername())
                .sex(sysUserPo.getSex())
                .realName(sysUserPo.getRealName())
                .headUrl(sysUserPo.getHeadUrl())
                .departId(sysUserPo.getDepartId())
                .email(sysUserPo.getEmail())
                .mobile(sysUserPo.getMobile())
                .birthday(sysUserPo.getBirthday())
                .jobName(sysUserPo.getJobName())
                .title(sysUserPo.getTitle())
                .certificate(sysUserPo.getCertificate())
                .certificateNo(sysUserPo.getCertificateNo())
                .remark(sysUserPo.getRemark())
                .jobName(sysUserPo.getJobName())
                .createBy(sysUserPo.getCreateBy())
                .modifyBy(sysUserPo.getModifyBy())
                .createDate(sysUserPo.getCreateDate())
                .build();
    }


}
