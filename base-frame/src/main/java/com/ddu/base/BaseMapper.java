package com.ddu.base;

import java.util.List;

/**  
 * 通用DAO接口  
 *  
 * @param <T>  
 * @param <PK>  
 */  
public interface BaseMapper<T> {  
    
    /**  
     * 插入一个实体  
     * @param entity  
     */  
    Long insert(T entity) ;  
      
    /**  
     * 根据实体主键删除一个实体  
     * @param id  
     */  
    void delete(Long id);  
      
    /**  
     * 更新一个实体  
     * @param entity  
     */  
    void update(T entity);   
    
    /**  
     * 根据主键获取一个实体  
     * @param id  
     * @return  
     */  
    T queryOne(Long id);  
      
    /**  
     * 查询所有实体  
     * @return  
     */  
    List<T> queryAll();  
  
    /**  
     * 查询所有实体,根据实体属性值为判断条件查询所有实体，  
     * @param entity  
     * @return  
     */  
    List<T> queryAllByEntity(T entity);  
      
}  