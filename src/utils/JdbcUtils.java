package utils;




import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

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
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return connection;
    }



    public static void close(Connection connection){
        if(connection!=null){
            try {
                connection.close();
            } catch (Exception throwables) {
                throwables.printStackTrace();
            }
        }

    }




}

