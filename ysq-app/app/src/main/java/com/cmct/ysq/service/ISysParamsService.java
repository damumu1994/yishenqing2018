package com.cmct.ysq.service;

import com.cmct.ysq.model.bo.SysParamForAddBo;
import com.cmct.ysq.model.bo.SysParamForUpdateBo;
import com.cmct.ysq.model.bo.SysParamsBo;
import com.cmct.ysq.model.vo.SysParamVo;

import java.util.List;

/**
 * <p>
 * 检测参数 服务类
 * </p>
 *
 * @author shen123
 * @since 2018-05-21
 */
public interface ISysParamsService {

    /**
     * 获取系统参数
     * @return
     */
    List<SysParamVo> getSysParams();


    SysParamVo getChkParamDetail(SysParamsBo bo);

    /**
     * 保存系统参数
     *
     * @param bo       系统参数实体
     * @param createBy 创建人
     */
    void saveSysParams(SysParamForAddBo bo, String createBy);

    /**
     * 修改系统参数
     *
     * @param bo         系统参数实体
     * @param modifyBy   修改人
     * @param sysParamId
     */
    void updateChkParams(SysParamForUpdateBo bo,
                         String modifyBy, String sysParamId);

    SysParamVo getChkParamDetail(String chkParamId);

    void delSysParamInfo(String sysParamId, String modifyBy);

}
