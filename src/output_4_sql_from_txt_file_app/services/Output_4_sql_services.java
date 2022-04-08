
package output_4_sql_from_txt_file_app.services;

import java.util.ArrayList;
import output_4_sql_command_lines.SqlCreationScriptLines;

public class Output_4_sql_services {
    
    SqlCreationScriptLines sqlCreation;

    public Output_4_sql_services() {
      this.sqlCreation = new SqlCreationScriptLines();  
    }

    
    
    public Output_4_sql_services(SqlCreationScriptLines sqlCreation) {
        this.sqlCreation = new SqlCreationScriptLines();
    }

    // GETTERS & SETTERS
    
    public SqlCreationScriptLines getSqlCreation() {
        return sqlCreation;
    }

    public void setSqlCreation(SqlCreationScriptLines sqlCreation) {
        this.sqlCreation = sqlCreation;
    }

   
    // METHODS
    
    public void displayStringsInArrayList(ArrayList<String> list){
        
        System.out.println("+--------------------------------------+");
        System.out.println("| Here follows an ArrayList of Strings |");
        System.out.println("+--------------------------------------+");
        for (String string : list) {
            System.out.println(string);
        }
        
        System.out.println("");
    }
    
    public void displayIntegersInArrayList (ArrayList<Integer> list){
        for (Integer integer : list) {
            System.out.println(Integer.toString(integer));
        }
    }
    
    
}
