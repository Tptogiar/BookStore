package dao.impl;

import dao.OrderItemDao;
import pojo.OrderItem;

/**
 * @author Tptogiar
 * @Descripiton: ]
 * @creat 2021/07/14-18:01
 */


public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {

    @Override
    public int saveOrderItem(OrderItem orderItem) {
        String sql = "insert into t_order_item(`name`,`count`,`price`,`total_price`,`order_id`)values(?,?,?,?,?)";
        return update(sql,orderItem.getName(),orderItem.getCount(),orderItem.getPrice(),orderItem.getTotalPrice(),orderItem.getOrderId());
    }



}
