package com.cmct.common.util;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 正则匹配得到的位置以及匹配的内容
 *
 * @author shen
 * @version 1.0.0
 * @since 2018/3/16
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReplaceFlagAndPosition {

    /**
     * 正则匹配得到的起始位置
     */
    private int position;

    /**
     * 正则匹配得到的结束位置
     */
    private int end;

    /**
     * 正则匹配的结果
     */
    private String regResult;
}
