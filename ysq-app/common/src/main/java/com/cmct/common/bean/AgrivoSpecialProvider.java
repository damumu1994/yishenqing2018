package com.cmct.common.bean;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.EntityHelper;
import tk.mybatis.mapper.mapperhelper.MapperHelper;
import tk.mybatis.mapper.mapperhelper.MapperTemplate;

import java.util.Iterator;
import java.util.Set;

/**
 * @author Aswods
 * @date 2017/7/21
 * @mail 1992ycl@gmail.com
 * @since v0.1
 */
public class AgrivoSpecialProvider extends MapperTemplate {

    public AgrivoSpecialProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }

    public String replace(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append("replace into ");
        sql.append(tableName(entityClass));
        sql.append("(");
        Set columnList = EntityHelper.getColumns(entityClass);
        Iterator var6 = columnList.iterator();
        int columnSize = columnList.size();
        int temp = 1;
        while (var6.hasNext()) {
            EntityColumn column = (EntityColumn) var6.next();
            sql.append(column.getColumn());
            if (temp != columnSize) {
                sql.append(",");
            }
            temp++;
        }
        sql.append(")");
        sql.append(" values ");
        sql.append("(");
        boolean first = true;
        for (EntityColumn column : EntityHelper.getColumns(entityClass)) {
            if (!first) {
                sql.append(",");
            }
            sql.append("#{").append(column.getProperty()).append("}");
            first = false;
        }
        sql.append(")");
        return sql.toString();
    }


}
