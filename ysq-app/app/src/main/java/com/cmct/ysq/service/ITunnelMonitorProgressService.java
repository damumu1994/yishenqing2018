package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.BaseModelBo;
import com.cmct.ysq.model.bo.ConstructProgForUpdateBo;
import com.cmct.ysq.model.bo.TunnelCrossSectionForAddBo;
import com.cmct.ysq.model.bo.TunnelDataUploadBo;
import com.cmct.ysq.model.vo.TunnelProgLinerVo;
import com.cmct.ysq.model.vo.TunnelProgressBaseVo;

import java.util.List;

/**
 * 数据查看/监控量测/施工进度 服务类
 *
 * @author shen
 * @since 2018-05-21
 */
public interface ITunnelMonitorProgressService {


    /**
     * 获取施工进度的基本信息
     *
     * @param pageQuery
     * @return
     */
    JsonPage<TunnelProgressBaseVo> getTunnelProgressBaseInfoList(BaseModelBo pageQuery);


    /**
     * 修改施工进度信息
     *
     * @param constructProgressId 施工进度id
     * @param updateInfo          修改信息
     * @param modifyBy            修改人
     */
    void updateConstructProgressInfo(String constructProgressId,
                                     ConstructProgForUpdateBo updateInfo,
                                     String modifyBy);


    /**
     * 获取历史施工进度
     *
     * @param constructProgressId
     * @param hisQuery
     * @return
     */
    JsonPage getConstructProgressHisInfo(String constructProgressId, BaseModelBo hisQuery);


    /**
     * 获取二衬
     *
     * @param constructProgressId
     * @return
     */
    List<TunnelProgLinerVo> progLiners(String constructProgressId);

    /**
     * 新增施工进度
     *
     * @param dataUpload
     * @param createBy
     */
    void postMonitorDataInfo(TunnelDataUploadBo dataUpload, String createBy);


    /**
     * 新增断面信息
     *
     * @param crossSectionForAdds
     * @param createBy
     */
    void postCrossSectionInfo(List<TunnelCrossSectionForAddBo> crossSectionForAdds, String createBy);

    //    /**
//     * 获取系统参数
//     *
//     * @return
//     */
//    List<SysParamVo> getSysParams();
//
//
//    SysParamVo getChkParamDetail(SysParamsBo bo);
//
//    /**
//     * 保存系统参数
//     *
//     * @param bo       系统参数实体
//     * @param createBy 创建人
//     */
//    void saveSysParams(SysParamForAddBo bo, String createBy);
//
//    /**
//     * 修改系统参数
//     *
//     * @param bo         系统参数实体
//     * @param modifyBy   修改人
//     * @param sysParamId
//     */
//    void updateChkParams(SysParamForUpdateBo bo,
//                         String modifyBy, String sysParamId);
//
//    SysParamVo getChkParamDetail(String chkParamId);
//

    /**
     * 删除施工进度
     *
     * @param constructProgressId 施工进度id
     * @param modifyBy            修改人
     */
    void delTunnelMonitorProgress(String constructProgressId, String modifyBy);

}
