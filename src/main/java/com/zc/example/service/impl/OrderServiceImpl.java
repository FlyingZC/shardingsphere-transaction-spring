package com.zc.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zc.example.entity.Order;
import com.zc.example.mapper.OrderMapper;
import com.zc.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
    
    @Autowired
    OrderMapper orderMapper;
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Override
    public boolean createTable() {
        return orderMapper.createTable();
    }
    
    @Override
    public boolean dropTable() {
        return orderMapper.dropTable();
    }
    
    @Override
    public boolean truncateTable() {
        return orderMapper.truncateTable();
    }
    
    @Override
    public Long countTable(String tableName) {
        return orderMapper.countTable(tableName);
    }
    
    // ----------------------------------------------------- 事务
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveFailed() throws Exception {
        orderMapper.insert(createOrderEntity(1L, 1L));
        orderMapper.insert(createOrderEntity(1L, 2L));
        orderMapper.insert(createOrderEntity(2L, 3L));
        orderMapper.insert(createOrderEntity(2L, 4L));
        if (true) {
            throw new Exception("模拟异常抛出");
        }
    }
    
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveSuccess() {
        orderMapper.insert(createOrderEntity(1L, 1L));
        orderMapper.insert(createOrderEntity(1L, 2L));
        orderMapper.insert(createOrderEntity(2L, 3L));
        orderMapper.insert(createOrderEntity(2L, 4L));
    }
    
    private Order createOrderEntity(Long userId, Long orderId) {
        Order entity = new Order();
        entity.setUserId(userId);
        entity.setOrderId(orderId);
        entity.setUuid(UUID.randomUUID().toString());
        entity.setStatus("OK");
        entity.setCreateTime(LocalDateTime.of(2025, 5, 1, 0, 0, 0));
        return entity;
    }
}
