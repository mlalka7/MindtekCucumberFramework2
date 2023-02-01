package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCEmail {

    public static void main(String[] args) throws SQLException {

        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"

        );
        Statement stt=cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

       changeAllEmails(stt);
    }

    private static void changeAllEmails(Statement stt) throws SQLException {
        String emailQuery="Select email from employees";
        ResultSet rs=stt.executeQuery(emailQuery);

        ArrayList<String> emailList= new ArrayList<>();
                while(rs.next()){
                    emailList.add("emailQ");
        }

    }
}
