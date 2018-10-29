package com.cmct.ysq.service;


import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.DepartQueryBo;
import com.cmct.ysq.model.bo.SysDepartForAddBo;
import com.cmct.ysq.model.bo.SysDepartForUpdateBo;
import com.cmct.ysq.model.vo.SysDepartVo;

/**
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2018-07-17 17:12:48
 */
public interface ISysDepartService {


    /**
     * 获取部门列表
     *
     * @param departQuery 请求参数
     * @return
     */
    JsonPage<SysDepartVo> getDepartList(DepartQueryBo departQuery);


    /**
     * 修改部门
     *
     * @param departId           部门id
     * @param sysDepartForUpdate 更新实体
     * @param modifyBy           修改人
     */
    void updateDepart(String departId,
                      SysDepartForUpdateBo sysDepartForUpdate,
                      String modifyBy);

    /**
     * 新增部门
     *
     * @param sysDepartForAdd 新增实体
     * @param createBy        创建人
     */
    void addDepart(SysDepartForAddBo sysDepartForAdd,
                   String createBy);

    /**
     * 新增部门
     *
     * @param deleteDepart 部门id
     * @param createBy     创建人
     */
    void deleteDepart(String deleteDepart, String createBy);
}

