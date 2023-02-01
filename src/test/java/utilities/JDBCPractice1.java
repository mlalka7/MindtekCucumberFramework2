package utilities;

import java.sql.*;

public class JDBCPractice1 {

    public static void main(String[] args) throws SQLException {
        Connection cnn= DriverManager.getConnection( "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"

        );

        Statement stt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet rs=stt.executeQuery("select l.city, l.postal_code, co.country_name\n" +
                "from locations l, countries co\n" +
                "where co.country_id=l.country_id;");

        while(rs.next()) System.out.println(rs.getString("city")+" has a zip code of: "+" "+rs.getString("postal_code")+
                " is located in: "+" "+rs.getString("country_name"));
    }
}
