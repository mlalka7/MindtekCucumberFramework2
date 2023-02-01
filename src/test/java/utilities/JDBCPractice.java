package utilities;

import java.sql.*;

public class JDBCPractice {

    public static void main(String[] args) throws SQLException {
        Connection cnn= DriverManager.getConnection( "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"

        );
        Statement stt= cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

        ResultSet rs=stt.executeQuery("select e.first_name, e.last_name , j.job_title, d.first_name\n" +
                "from employees e, jobs j, dependents d\n" +
                "where e.employee_id=d.employee_id and e.job_id=j.job_id;");

        while(rs.next()) System.out.println(rs.getString("first_name")+" "+rs.getString("last_name")+" is working as "+
                rs.getString("job_title")+"."+"Child's name is: "+" "+rs.getString("first_name")+".");
    }
}
