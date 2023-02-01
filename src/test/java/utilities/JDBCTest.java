package utilities;

import java.sql.*;
import java.util.ArrayList;

public class JDBCTest {

    public static void main(String[] args) throws SQLException {

        //create connection:
        Connection cnn = DriverManager.getConnection(
                "jdbc:postgresql://localhost/HR_Production",
                "postgres",
                "admin"

        );

        //statement
        Statement stt = cnn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);


        //read data ResultSet

        // ResultSet rs= stt.executeQuery("Select * from jobs");

        // rs.next();
        //rs.next();
        //System.out.println(rs.getString("job_title"));
        //System.out.println(rs.getInt(1));

        // to get all the rows in job_title
        //  while(rs.next()) System.out.println(rs.getString("job_title"));


//============================new task
        //print full name of a parent is a parent of full name c hild
        //penelope Giets is a parent of Jack Gietz

      //  ResultSet rs2 = stt.executeQuery("select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) " +
          //      "as d_full_name from employees e, dependents d\n" +
            //    "where e.employee_id = d.employee_id");
      //  while (rs2.next()) {
           // System.out.println(rs2.getString("p_full_name") + " is a parent of " + rs2.getString("d_full_name"));

        //  ResultSet rs3 = stt.executeQuery("select concat(e.first_name, ' ', e.last_name) as p_full_name, concat(d.first_name, ' ', d.last_name) as d_full_name from employees e\n" +
            //        "inner join dependents d on e.employee_id = d.employee_id");
          //  while (rs3.next()) {
           //     System.out.println(rs3.getString("p_full_name") + " is a parent of " + rs3.getString("d_full_name"));
         //   }
            //=============================new task
        //find out if there is any email not ending with @sqltutorial.org
        //1 to get all emails and put them into rs
        //2 put those to arrayList
        //3 find out if there is any email not ending with @sqltutorial.org
        //4 if there is such email  then print "Found different email"
        //5 if all emails end with @sqltutorial.org then print "All emails are the same"

        findDifferentEmail(cnn,stt);
            System.out.println("Pass");
        }

    private static void findDifferentEmail(Connection cnn, Statement stt) throws SQLException {
        ResultSet rs = stt.executeQuery("Select email from employees");

        ArrayList<String> emailList = new ArrayList<>();

        while(rs.next()) emailList.add(rs.getString("email"));

        boolean isWrongEmail = false;

        for (String em: emailList) {
            if(!em.endsWith("@sqltutorial.org")) {
                System.out.println("Wrong email: " + em);
                isWrongEmail = true;
            }
        }
        if(isWrongEmail) System.out.println("Found different email");
        else System.out.println("All emails are the same");

    }


    }


