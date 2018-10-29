package com.cmct.ysq.model.vo;

import com.cmct.ysq.model.bo.FileBo;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileVo extends FileBo {

    @ApiModelProperty("文件id")
    private String fileId;
}
