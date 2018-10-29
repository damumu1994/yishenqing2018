
package com.cmct.ysq.service;

import com.cmct.common.bean.JsonPage;
import com.cmct.ysq.model.bo.SysVersionForAddBo;
import com.cmct.ysq.model.bo.SysVersionForUpdateBo;
import com.cmct.ysq.model.bo.SysVersionQueryBo;
import com.cmct.ysq.model.vo.SysVersionVo;

/**
 * 版本服务
 *
 * @author losing
 * @Date 2016年9月16日
 * @since v0.1
 */
public interface SysVersionService {

    /**
     * 分页查询版本列表
     *
     * @return 返回值含义的说明
     */
    JsonPage<SysVersionVo> page(SysVersionQueryBo sysVersionQuery);

    /**
     * 保存版本
     *
     * @param sysVersionForAdd
     * @param createBy
     */
    void save(SysVersionForAddBo sysVersionForAdd, String createBy);

    /**
     * 更新版本
     *
     * @param sysVersionForUpdate
     * @param modifyBy
     * @param versionId
     * @throws Exception
     */
    void update(SysVersionForUpdateBo sysVersionForUpdate, String modifyBy, String versionId) throws Exception;

    /**
     * 通过id删除版本记录
     *
     * @param versionId
     * @param modifyBy
     */
    void remove(String versionId, String modifyBy);

}
