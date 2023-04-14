package com.zc.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zc.example.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {
    
    boolean createTable();
    
    boolean dropTable();
    
    boolean truncateTable();
    
    Long countTable(@Param("tableName") String tableName);
}
