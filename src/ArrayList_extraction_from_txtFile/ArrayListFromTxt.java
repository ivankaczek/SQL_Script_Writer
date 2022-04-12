
package ArrayList_extraction_from_txtFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import output_4_sql_from_txt_file_app.Output_4_SQL_from_TXT_file_APP;

public class ArrayListFromTxt {
   /*
      ArrayList<String> almodArray = new ArrayList();
        ArrayList<String> almodFilmNamesArray = new ArrayList();
        ArrayList<Integer> almodFilmReleaseYearArray = new ArrayList();
        
        String tableName01 = "films_by_Almodovar";
        String schemaName01 = "movies_i_love";
        
        File almodTxt = new File("D:\\code_projects\\sql_films_I_love\\Films_directed_by_Pedro_Almodovar.txt");
  
        Output_4_sql_services serv = new Output_4_sql_services();
        serv.getSqlCreation().createSQLdataBase(schemaName01);
        serv.getSqlCreation().createSQLtableIdName(tableName01, "film_name");
        serv.getSqlCreation().alterTableAddIntegerColumn(tableName01, "release_year");
    */
    
    
    
    
        public ArrayListFromTxt(){
        }

    public ArrayList<String> joeWrightFilmsFileExtraction() {
        ArrayList<String> joeWrightTxtLines = new ArrayList();
        ArrayList<String> joeWrightFilmNames = new ArrayList();
        ArrayList<String> joeWrightFilmReleaseYear = new ArrayList();
        
        String tableName02 = "films_by_Joe_Wright";
        String schemaName01 = "movies_i_love";
        String joeWrightFilePath = "D:\\code_projects\\sql_films_I_love\\Films_directed_by_Joe_Wright.txt";
        
        File joeWriteTxtFile = new File(joeWrightFilePath);
        
        try {
            Scanner joeWright_sc = new Scanner(joeWriteTxtFile);
            
            while (joeWright_sc.hasNextLine()) {
                String joeWrightTemporary = joeWright_sc.nextLine();
                //System.out.println(joeWrightTemporary);
                joeWrightFilmNames.add(joeWrightTemporary);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrayListFromTxt.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //I will remove the first 2 lines
        joeWrightFilmNames.remove(0);
        joeWrightFilmNames.remove(0);
        return joeWrightFilmNames;
    }
        
     /////////////////////WARNING ///////////////////// HERE EVERYTHING YET TO BE DONE
    public ArrayList<Integer> joeWrightReleaseYearFileExtraction() {
        ArrayList<String> joeWrightTxtLines = new ArrayList();
        ArrayList<String> joeWrightFilmNames = new ArrayList();
        ArrayList<String> joeWrightFilmReleaseYear = new ArrayList();
        
        String tableName02 = "films_by_Joe_Wright";
        String schemaName01 = "movies_i_love";
        String joeWrightFilePath = "D:\\code_projects\\sql_films_I_love\\Films_directed_by_Joe_Wright.txt";
        
        File joeWriteTxtFile = new File(joeWrightFilePath);
        
        try {
            Scanner joeWright_sc = new Scanner(joeWriteTxtFile);
            
            while (joeWright_sc.hasNextLine()) {
                String joeWrightTemporary = joeWright_sc.nextLine();
                //System.out.println(joeWrightTemporary);
                joeWrightFilmNames.add(joeWrightTemporary);
            }
            
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ArrayListFromTxt.class.getName()).log(Level.SEVERE, null, ex);
        } 
        //I will remove the first 2 lines
        joeWrightFilmNames.remove(0);
        joeWrightFilmNames.remove(0);
        return new ArrayList();
    }
    
} 

           
    
    
    

