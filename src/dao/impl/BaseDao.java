package dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/08-15:17
 */


public abstract class BaseDao {

        private QueryRunner queryRunner=new QueryRunner();


        public int update(String sql,Object...args){
                Connection connect = JdbcUtils.getConnect();
                try {
                        return queryRunner.update(connect, sql, args);
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        throw new RuntimeException(throwables);
                }
        }

        public <T> List<T> queryForlist(Class<T> type,String sql, Object...args){
                Connection connect = JdbcUtils.getConnect();
                try {
                        return queryRunner.query(connect,sql,new BeanListHandler<T>(type),args);
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        throw new RuntimeException(throwables);
                }
        }


        public <T> T queryForOne(Class<T> type,String sql,Object...args){
                Connection connect = JdbcUtils.getConnect();
                try {
                        return queryRunner.query(connect,sql,new BeanHandler<T>(type),args);
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        throw new RuntimeException(throwables);
                }

        }



        public Object queryForSingleValue(String sql,Object...args){
                Connection connect = JdbcUtils.getConnect();
                try {
                        return queryRunner.query(connect,sql,new ScalarHandler(),args);
                } catch (SQLException throwables) {
                        throwables.printStackTrace();
                        throw new RuntimeException(throwables);
                }
        }

}
