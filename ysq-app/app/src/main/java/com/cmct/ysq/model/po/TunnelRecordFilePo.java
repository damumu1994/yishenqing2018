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
 * @author shen
 * @Date 2018/04/10
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "t_tunnel_record_file")
public class TunnelRecordFilePo {
    /**
     * 主键
     */
    @Id
    private String recordFileId;
    /**
     * 监测项目记录id
     */
    @Column
    private String recordId;
    /**
     * 文件类型[1 图片/2 音频/3 视频/4 手绘/5 外部图片]
     */
    @Column
    private String fileType;
    /**
     * 文件路径
     */
    @Column
    private String linkUrl;
    /**
     * 本地地址
     */
    @Column
    private String localUrl;

    /**
     * 文件名
     */
    @Column
    private String fileName;
    /**
     * 备注
     */
    @Column
    private String remark;
    @Column
    private Date createDate;

    @Column
    private String prefix;
    @Column
    private String suffix;

    @Column
    private Date modifyDate;

    @Column
    private Integer deleteStatus;
    @Column
    private String createBy;
    @Column
    private String modifyBy;

}
