package utilities;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DBTest {
    public static void main(String[] args) throws SQLException {
        DB db=new DB();

       // String query="insert into countries values ('NK', 'North Korea', 3)";
      //  db.runInsertQuery(query);

            //select first last name, email, phone number from empoyees
            //db.runSelectQuery("1","2","jobs")
            //db.runSelectQuery(, employee
        ArrayList<String> columnName= new ArrayList<>();
        columnName.add("first_name");
        columnName.add("last_name");
        columnName.add("phone_number");


      ResultSet rs= db.runSelectQuery(columnName ,"employees");
      while(rs.next()) System.out.println(rs.getString("first_name")+" "+rs.getString("last_name")+" "+rs.getString("phone_number"));
     //  List<Map<String,Object>> list= db.getTableForQuery(query);
       // System.out.println(list);
        db.close();
    }
}
