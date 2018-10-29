/**
 * 文件名称:  HibernateDaoImpl.java
 * 文件序号:  序号
 * 内容描述:  文件简单描述，多行换行书写
 * 版权声明:  山东鸿蝶信息技术有限公司
 * 创建用户:  zhangkai
 * 创建日期:  2016/12/20 20:22
 * 修改用户:  无
 * 修改日期:  无
 * 修改说明:  无
 * 文件版本:  V1.0
 * 文件路径:
 */

package com.cmct.common.dao.impl;


import com.cmct.common.dao.IHibernateDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 名  称:HiberanteDaoImpl
 * 类  型: class
 * 描  述: 用一句话描述类的作用
 * 路  径:com.hongdee.dao
 * 作  者:zhangkai
 * 日  期:2016/12/20 20:22
 */
@Service
public class HibernateDaoImpl<T> implements IHibernateDao<T> {

    private Session session;
    @Resource
    private SessionFactory sessionFactory;


    @Override
    public Session getSession() {
        return this.sessionFactory.openSession();
    }

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
     *
     * @param entityClass
     * @param id
     */
    @Override
    public T findEntity(Class<T> entityClass, Serializable id) throws Exception {
        Session session = getSession();
        try {
            T entity = session.load(entityClass, id);

            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entityClass
     */
    @Override
    public List<T> findEntityList(Class<T> entityClass) throws Exception {
        Session session = getSession();
        try {
            String name = entityClass.getSimpleName();
            String hql = " from " + name;
            Query query = session.createQuery(hql);
            List<T> resList = query.list();
            return resList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param hql
     */
    @Override
    public T findEntityByHql(String hql) throws Exception {
        Session session = getSession();
        try {
            Query query = session.createQuery(hql);
            List<T> resList = query.list();
            return null != resList && resList.size() > 0 ? resList.get(0) : (T) new Object();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param hql
     * @param params
     */
    @Override
    public T findEntityByHqlWithParams(String hql, Map<String, Object> params) throws Exception {
        Session session = getSession();
        try {
            Query query = session.createQuery(hql);
            for (Map.Entry entry : params.entrySet()) {
                query.setParameter(String.valueOf(entry.getKey()), entry.getValue());
            }
            List<T> resList = query.list();
            return null != resList && resList.size() > 0 ? resList.get(0) : (T) new Object();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();

        }
    }

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
     *
     * @param hql
     */
    @Override
    public List<T> findEntityListByHql(String hql) throws Exception {
        Session session = getSession();
        try {
            Query query = session.createQuery(hql);
            List<T> resList = query.list();
            return resList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
    @Override
    public List<T> findEntityListByHqlWithParams(String hql, Map<String, Object> params) throws Exception {
        Session session = getSession();
        try {
            Query query = session.createQuery(hql);
            for (Map.Entry entry : params.entrySet()) {
                query.setParameter(String.valueOf(entry.getKey()), entry.getValue());
            }
            List<T> resList = query.list();
            return resList;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entity
     */
    @Override
    public Serializable addEntity(T entity) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            Serializable si = session.save(entity);
            session.getTransaction().commit();
            return si;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entityList
     */
    @Override
    public List<Serializable> addEntityList(List<T> entityList) throws Exception {
        Session session = getSession();
        try {
            List<Serializable> siList = new ArrayList<Serializable>();
            session.beginTransaction();
            for (T entity : entityList) {
                siList.add(session.save(entity));
            }
            session.getTransaction().commit();
            return siList;
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entity
     */
    @Override
    public void updateEntity(T entity) throws Exception {
        Session session = getSession();
        try {
            List<Serializable> siList = new ArrayList<Serializable>();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entityList
     */
    @Override
    public void updateEntityList(List<T> entityList) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            for (T entity : entityList) {
                session.update(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entity
     */
    @Override
    public void saveOrUpdateEntity(T entity) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entityList
     */
    @Override
    public void saveOrUpdateEntityList(List<T> entityList) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            for (T entity : entityList) {
                session.saveOrUpdate(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entity
     */
    @Override
    public void delEntity(T entity) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param entityList
     */
    @Override
    public void delEntityList(List<T> entityList) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            for (T entity : entityList) {
                session.delete(entity);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param hql
     */
    @Override
    public void executeHql(String hql) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            Query qc = session.createQuery(hql);
            qc.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }

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
     *
     * @param hql
     * @param params
     */
    @Override
    public void executeHqlWithParams(String hql, Map<String, Object> params) throws Exception {
        Session session = getSession();
        try {
            session.beginTransaction();
            Query qc = session.createQuery(hql);
            for (Map.Entry entry : params.entrySet()) {
                qc.setParameter(String.valueOf(entry.getKey()), entry.getValue());
            }
            qc.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            throw new Exception(e.getMessage());
        } finally {
            session.close();
        }
    }


}
