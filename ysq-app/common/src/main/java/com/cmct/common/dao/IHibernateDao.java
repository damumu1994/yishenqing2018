package com.cmct.common.dao;
/**
 * 文件名称:  IHibernateDao.java
 * 文件序号:  序号
 * 内容描述:  文件简单描述，多行换行书写
 * 版权声明:  山东鸿蝶信息技术有限公司
 * 创建用户:  zhangkai
 * 创建日期:  2016/12/20 20:20
 * 修改用户:  无
 * 修改日期:  无
 * 修改说明:  无
 * 文件版本:  V1.0
 * 文件路径:
 */

import org.hibernate.Session;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 名  称:IHibernateDao
 * 类  型: interface
 * 描  述: 用一句话描述类的作用
 * 路  径:com.hongdee.dao
 * 作  者:zhangkai
 * 日  期:2016/12/20 20:20
 */
public interface IHibernateDao<T> {

    /**
     * 方法名称: getSession
     * 方法描述: 获取Hibernate 会话
     * 返回内容: Session Hibernate 的 Session 对象
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public Session getSession() throws Exception;

    /**
     * 方法名称: findEntity
     * 方法描述: 根据实体类型，主键查询实体
     * 参数名称: Class<T> entityClass，使用@Entity注解的实体 class
     * 参数名称: Serializable id 主键，对应@Id 标识的属性
     * 返回内容: T @Entity注解的实体对象实例
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public T findEntity(Class<T> entityClass, Serializable id) throws Exception;

    /**
     * 方法名称: findEntityList
     * 方法描述: 根据实体类型，主键查询实体集合
     * 参数名称: Class<T> entityClass，使用@Entity注解的实体 class
     * 返回内容: List<T> @Entity注解的实体对象实例集合
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public List<T> findEntityList(Class<T> entityClass) throws Exception;

    /**
     * 方法名称: findEntityByHql
     * 方法描述: 根据 HQL 查询单个实体对象
     * 参数名称: String hql，hql 语句
     * 返回内容: T @Entity注解的实体对象实例
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public T findEntityByHql(String hql) throws Exception;

    /**
     * 方法名称: findEntityByHql
     * 方法描述: 根据 HQL 和 HQL 语句对应的参数查询单个实体对象
     * 参数说明: String hql，hql 语句，所有占位为 :占位名称
     * 参数说明: Map<String, Object> params， 参数集合，对应 HQL语句中 :标注的占位名称
     * 返回内容: T @Entity注解的实体对象实例
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public T findEntityByHqlWithParams(String hql, Map<String, Object> params) throws Exception;

    /**
     * 方法名称: findEntityListByHql
     * 方法描述: 根据 HQL 实体对象集合
     * 参数说明: String hql，hql 语句
     * 返回内容: T @Entity注解的实体对象实例集合
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public List<T> findEntityListByHql(String hql) throws Exception;

    /**
     * 方法名称: findEntityListByHql
     * 方法描述: 根据 HQL 实体对象集合
     * 参数说明: String hql，hql 语句
     * 参数说明: String hql，hql 语句，所有占位为 :占位名称
     * 参数说明: Map<String, Object> params， 参数集合，对应 HQL语句中 :标注的占位名称
     * 返回内容: T @Entity注解的实体对象实例集合
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public List<T> findEntityListByHqlWithParams(String hql, Map<String, Object> param) throws Exception;

    /**
     * 方法名称: addEntity
     * 方法描述: 将实体对象实例保存到数据库中
     * 参数说明: T entity ，@Entity 注解标注的实体对象实例
     * 返回内容: Serializable @Entity 注解标注的实体对象实例保存时产生的主键
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public Serializable addEntity(T entity) throws Exception;

    /**
     * 方法名称: addEntityList
     * 方法描述: 将实体对象实例集合保存到数据库中
     * 参数说明: List<T> entityList ，@Entity 注解标注的实体对象实例集合
     * 返回内容: Serializable @Entity 注解标注的实体对象实例保存时产生的主键集合
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public List<Serializable> addEntityList(List<T> entityList) throws Exception;

    /**
     * 方法名称: updateEntity
     * 方法描述: 将实体对象实例更新到数据库中
     * 参数说明: T entityList ，@Entity 注解标注的实体对象实例
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void updateEntity(T entity) throws Exception;

    /**
     * 方法名称: updateEntityList
     * 方法描述: 将实体对象实例集合更新到数据库中
     * 参数说明: List<T> entityList ，@Entity 注解标注的实体对象实例集合
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void updateEntityList(List<T> entityList) throws Exception;

    /**
     * 方法名称: saveOrUpdateEntity
     * 方法描述: 将实体对象实例保存或更新到数据库中
     * 参数说明: T entityList ，@Entity 注解标注的实体对象实例
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void saveOrUpdateEntity(T entity) throws Exception;

    /**
     * 方法名称: saveOrUpdateEntityList
     * 方法描述: 将实体对象实例集合保存或更新到数据库中
     * 参数说明: List<T> entityList ，@Entity 注解标注的实体对象实例集合
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void saveOrUpdateEntityList(List<T> entityList) throws Exception;

    /**
     * 方法名称: delEntity
     * 方法描述: 将实体对象实例从数据库中删除
     * 参数说明: T entityList ，@Entity 注解标注的实体对象实例
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void delEntity(T entity) throws Exception;

    /**
     * 方法名称: delEntityList
     * 方法描述: 将实体对象实例集合从数据库中删除
     * 参数说明: List<T> entityList ，@Entity 注解标注的实体对象实例集合
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void delEntityList(List<T> entityList) throws Exception;

    /**
     * 方法名称: executeHql
     * 方法描述: 招执行更新或删除的 HQL 语句
     * 参数说明: String hql ，HQL 语句
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void executeHql(String hql) throws Exception;

    /**
     * 方法名称: executeHqlWithParams
     * 方法描述: 招执行更新或删除的  带参数的HQL 语句
     * 参数说明: String hql ，HQL 语句，使用:占位
     * 参数说明: Map<String,Object> params,参数集合，key 值为 HQL 中的:占位名称
     * 返回内容: 无
     * 异常说明: Exception
     * 创建用户:
     * 创建时间:
     * 修改用户:
     * 修改时间:
     * 修改内容:
     */
    public void executeHqlWithParams(String hql, Map<String, Object> params) throws Exception;

}
