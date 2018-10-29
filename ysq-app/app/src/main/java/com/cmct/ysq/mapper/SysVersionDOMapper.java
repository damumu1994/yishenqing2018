package com.cmct.ysq.mapper;

import com.cmct.common.bean.BaseMapper;
import com.cmct.ysq.model.bo.SysVersionQueryBo;
import com.cmct.ysq.model.po.SysVersionPo;
import com.cmct.ysq.model.vo.SysVersionVo;

import java.util.List;

public interface SysVersionDOMapper extends BaseMapper<SysVersionPo> {

    /**
     * 查看版本结果列表
     *
     * @param where
     * @return
     */
    List<SysVersionVo> page(SysVersionQueryBo where);


}
