package com.cmct.ysq.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.List;
@Data
@ApiModel("树形结构")
public class Node {
    public  Node init(){
        this.setName("封面");
        this.setPid(0L);
        this.setLevels(0L);
        this.setNodeId("0");
        return this;
    }
    /**
     * @Fields id : 节点编号
     */
     private String nodeId;
    @ApiModelProperty("节点编号(昵称)")
    private String nickNodeId;
    /**
     * @Fields text : 名称
     */
    @ApiModelProperty("名称")
    private String name;
    /**
     * @Fields pid :父目录的id
     */
    @ApiModelProperty("父目录的id")
    private Long pid;
    /**
     * @Fields levels : 目录等级
     */
    @ApiModelProperty("目录等级")
    private Long levels;
    /**
     * @Fields children : 子节点集合
     */
    @ApiModelProperty("子节点集合")
    private List<Node> children;
}
