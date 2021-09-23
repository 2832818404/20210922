package cud.xcdq;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author hongxiaozheng
 * @date 2021/9/10 9:08
 */
public class Demo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {

        Tools.registerInfo();


        // 1注册驱动
        Class.forName(Tools.getDriver());
        // 2获取链接
        Connection connection = DriverManager.getConnection(Tools.getUrl(), Tools.getUser(), Tools.getPassword());
        // 3准备传输器
        Statement statement =  connection.createStatement();
        // 4执行sql
        ResultSet resultSet = statement.executeQuery("select * from book");
        // 5 获取结果
        while (resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2)
                    + resultSet.getString(3) + " " + resultSet.getDouble(4)
            );
        }
        // 6 关闭资源
        Tools.closeAll(resultSet , statement , connection);

    }

}
