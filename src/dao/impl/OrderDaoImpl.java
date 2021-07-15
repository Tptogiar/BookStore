package dao.impl;

import dao.OrderDao;
import pojo.Order;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/14-18:00
 */


public class OrderDaoImpl extends BaseDao implements OrderDao {


    @Override
    public int saveOrder(Order order) {
        String sql = "insert into t_order(`order_id`,`create_time`,`price`,`status`,`user_id`) values(?,?,?,?,?)";

        return update(sql,order.getOrderId(),order.getCreateTime(),order.getPrice(),order.getStatus(),order.getUserId());
    }
}
