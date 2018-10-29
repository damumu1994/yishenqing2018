package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.BaseModelBo;
import com.cmct.ysq.model.bo.TunnelMonitorItemForUpdateBo;
import com.cmct.ysq.model.vo.TunnelCrossSectionVo;
import com.cmct.ysq.model.vo.TunnelMonitorItemBaseVo;
import com.cmct.ysq.model.vo.TunnelMonitorItemNeweastInfoVo;

import java.util.List;

/**
 * 数据查看/监控量测/监测项管理 服务类
 *
 * @author shen
 * @since 2018-05-21
 */
public interface ITunnelMonitorItemService {


    /**
     * 获取
     *
     * @param pageQuery
     * @return
     */
    JsonPage<TunnelMonitorItemBaseVo> getTunnelMonitorItemBaseInfoList(BaseModelBo pageQuery);


    /**
     * 获取断面信息
     *
     * @param monitorItemRecordId 监测项目记录id
     * @return
     */
    TunnelCrossSectionVo getCrossSection(String monitorItemRecordId);


    /**
     * 删除监测项目
     *
     * @param monitorItemRecordId
     * @param modifyBy
     */
    void deleteTunnelMonitorItem(String monitorItemRecordId, String modifyBy);


    /**
     * 修改监测项目
     *
     * @param monitorItemRecordId 监测项记录id
     * @param updateInfo          更新信息
     * @param modifyBy            修改人
     */
    void updateTunnelMonitorItem(String monitorItemRecordId,
                                 TunnelMonitorItemForUpdateBo updateInfo,
                                 String modifyBy);


    /**
     * 获取最新监测信息
     *
     * @param monitorItemRecordId
     * @return
     */
    List<TunnelMonitorItemNeweastInfoVo> getNeweastMonitorItemInfo(String monitorItemRecordId);
//    JsonPage<TunnelProgressBaseVo> getTunnelMonitorItemBaseInfoList(BaseModelBo pageQuery);
//
//
//    /**
//     * 修改施工进度信息
//     *
//     * @param constructProgressId 施工进度id
//     * @param updateInfo          修改信息
//     * @param modifyBy            修改人
//     */
//    void updateConstructProgressInfo(String constructProgressId,
//                                     ConstructProgForUpdateBo updateInfo,
//                                     String modifyBy);
//
//
//    /**
//     * 获取历史施工进度
//     *
//     * @param constructProgressId
//     * @param hisQuery
//     * @return
//     */
//    JsonPage getConstructProgressHisInfo(String constructProgressId, ConstructProgHisQueryBo hisQuery);
//
//
//    /**
//     * 获取二衬
//     *
//     * @param constructProgressId
//     * @return
//     */
//    List<TunnelProgLinerVo> progLiners(String constructProgressId);


    /**
     * 删除施工进度
     *
     * @param constructProgressId 施工进度id
     * @param modifyBy            修改人
     */
//    void delTunnelMonitorProgress(String constructProgressId, String modifyBy);

}
