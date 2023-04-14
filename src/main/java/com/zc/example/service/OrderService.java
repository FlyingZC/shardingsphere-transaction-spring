package com.zc.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zc.example.entity.Order;

public interface OrderService extends IService<Order> {
    
    boolean createTable();
    
    boolean dropTable();
    
    boolean truncateTable();

    Long countTable(String tableName);
    
    // ----------------------------------------------------- 事务
    
    void saveFailed() throws Exception;
    
    void saveSuccess();
}
