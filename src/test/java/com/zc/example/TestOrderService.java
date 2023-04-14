package com.zc.example;

import com.zc.example.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.locationtech.jts.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class TestOrderService {
    
    @Autowired
    private OrderService orderService;
    
    // ----------------------------------------------------- prepare
    
    /**
     * 重新创建 t_order 表
     */
    @Test
    public void testReCreateTable() {
        orderService.dropTable();
        orderService.createTable();
    }
    
    @Test
    public void testTruncateTable() {
        orderService.truncateTable();
        Assert.equals(0L, orderService.count());
    }
    
    // ----------------------------------------------------- 事务
    
    /**
     * 失败自动回滚
     *
     * @throws Exception
     */
    @Test
    public void testTransactionFailureAndRollback() throws Exception {
        orderService.truncateTable();
        Assert.equals(0L, orderService.count());
        try {
            orderService.saveFailed();
        } catch (Exception e) {
            e.printStackTrace();
            Assert.equals(0L, orderService.count());
        }
    }
    
    /**
     * 成功提交
     */
    @Test
    public void testTransactionSuccess() {
        orderService.truncateTable();
        Assert.equals(0L, orderService.count());
        orderService.saveSuccess();
        Assert.equals(4L, orderService.count());
    }
}
