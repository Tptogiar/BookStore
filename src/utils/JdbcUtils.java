package utils;




import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import java.security.AccessControlException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/**
 * @author Tptogiar
 * @Descripiton:
 * @creat 2021/07/08-13:49
 */


public class JdbcUtils {

    private static DruidDataSource dataSource;
    private static ThreadLocal<Connection> conns=new ThreadLocal<>();

    static {
        try {
            Properties properties = new Properties();
            properties.load(JdbcUtils.class.getClassLoader().getResourceAsStream("config.properties"));
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public  static Connection getConnect() {
        Connection connection = conns.get();

        if(connection==null){
            try {
                connection=dataSource.getConnection();
                conns.set(connection);
                connection.setAutoCommit(false);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        return connection;
        // 一定要执行 remove 操作，否则就会出错。（因为 Tomcat 服务器底层使用了线程池技术）
    }


    public static void commitAndClose(){

        Connection connection = conns.get();

        if(connection!=null){

            try {
                connection.commit();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }

        }

        conns.remove();

    }


    public static void rollbackAndClose(){
        Connection connection = conns.get();

        if(connection!=null){

            try {
                connection.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }


        }
        conns.remove();


    }


//    public static void close(Connection connection){
//
//
//
//        if(connection!=null){
//            try {
//                connection.close();
//            } catch (Exception throwables) {
//                throwables.printStackTrace();
//            }
//        }
//
//    }




}

