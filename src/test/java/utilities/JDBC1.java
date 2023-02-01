package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBC1 {

    public static void main(String[] args) throws SQLException {


        // create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"
        );

        // statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        // read data
        //ResultSet rs = stt.executeQuery("Select * from jobs");

       // rs.next();
        //System.out.println(rs.getString("job_title"));

      //
        // printCountries(stt);
       // printDepartmentsByCountries(stt);
        updateAllEmails(stt);
    }

    private static void updateAllEmails(Statement stt) throws SQLException {
        //write a query to get email in a result set
        String emailQuery="select email from employees";
        ResultSet rs=stt.executeQuery(emailQuery);


        //iterate though your rs and put all emails into arraylist
        ArrayList<String> emailList= new ArrayList<>();
        while(rs.next()){
            emailList.add(rs.getString("email"));

        }
        //iterate though array list and change email from @sqltutorial.org to @mindtek.edu
        ArrayList<String> newEmailList=new ArrayList<>();
        for(String email: emailList){
            email= email.substring(0,email.indexOf('@'))+ "@mindtek.edu";
            newEmailList.add(email);
        }
        System.out.println(newEmailList);
        //put to db
       String updateQuery= "update employees set email= newEmail where employees.email= oldEmail";
        int i=0;
        for(String em:emailList){
            updateQuery="update employees set email= '"+ newEmailList.get(i)+"' where employees.email ='"+emailList.get(i)+"'";
          stt.executeUpdate(updateQuery);
            i++;
        }

    }

    private static void printDepartmentsByCountries(Statement stt) throws SQLException {
        //add implementation
        ResultSet rs=stt.executeQuery("select locations.country_id, count(departments.department_name) \n" +
                "from locations, departments\n" +
                "where locations.location_id=departments.location_id\n" +
                "group by locations.country_id");
        while(rs.next()){
            System.out.println(rs.getString("country_id")+" -> "+rs.getString("count"));
        }
    }

    private static void printCountries(Statement stt) throws SQLException {
        ResultSet rs=stt.executeQuery("Select * from countries");



        int i=1;
        while(rs.next()){
            System.out.println(i+" -> "+(rs.getString("country_name")));
            i++;
        }
    }
}
