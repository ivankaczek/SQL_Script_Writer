/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package output_4_sql_command_lines;

import java.util.ArrayList;

/**
 *
 * @author Ivan
 */
public class SqlCreationScriptLines {
    
    // CONSTRUCTOR
    
    public SqlCreationScriptLines() {
    }
    
    // METHODS
    
    public void createSQLdataBase( String nameOfSchema){
    /*
        DROP DATABASE IF EXISTS tienda;
        CREATE DATABASE tienda CHARACTER SET utf8mb4;
        USE tienda;
    */
//      public final static String SCR01_DROP_PREVIOUS_DB = "DROP DATABASE IF EXISTS ";
//      public final static String SCR02_CREATE_DB = "CREATE DATABASE ";
//      public final static String SCR03_SET_CHARACTER_SET = " CHARACTER SET utf8mb4; ";
//      public final static String SCR04_USE_THIS_DB = "USE ";

        System.out.println(SqlScriptLines.SCR01_DROP_PREVIOUS_DB + nameOfSchema + ";");
        System.out.println(SqlScriptLines.SCR02_CREATE_DB + nameOfSchema + " ");
        System.out.println(SqlScriptLines.SCR03_SET_CHARACTER_SET);
        System.out.println(SqlScriptLines.SCR04_USE_THIS_DB + nameOfSchema + ";");
        System.out.println();
    }

    public void createSQLtable_idPK_int_varchar(String schemaName,
                                                String table2createName,
                                                String fieldName4int,
                                                String fieldName4varchar){
        
        /*
        DROP TABLE IF EXISTS films_by_Almodovar ;
        CREATE TABLE  films_by_Almodovar ( 
        id  INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, 
        film_name VARCHAR(100) NOT NULL 
        );

        */
        
        System.out.println("");
        
        
    }
    
    public void createSQLtableIdName(String nameOfTable, String nameOfOnlyVarcharField){
        /*
        This creates the most simple of the tables, with just 2 columns, one is the primary key, with integeres
        And the other has String (Varchar in SQL) fields
        */
      /*
    CREATE TABLE fabricante (
    codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
    );
    */
//      public final static String SCR05_CREATE_TABLE = "CREATE TABLE  ";
//      public final static String SCR05B_CREATE_TABLE = " ( ";
//      public final static String SCR06_CREATE_FIELD_PK = " INT UNSIGNED AUTO_INCREMENT PRIMARY KEY, ";
//      public final static String SCR07_createFieldVarchar = " VARCHAR(100) NOT NULL ";
//      public final static String SCR08_CLOSE_TABLE_CREATION = " );";
        System.out.println("");
        System.out.println("DROP TABLE IF EXISTS " + nameOfTable + " ;");
        System.out.println(SqlScriptLines.SCR05_CREATE_TABLE + nameOfTable + SqlScriptLines.SCR05B_CREATE_TABLE);
        System.out.println(" id " + SqlScriptLines.SCR06_CREATE_FIELD_PK);
        System.out.println(" " + nameOfOnlyVarcharField + SqlScriptLines.SCR07_CREATE_FIELD_VARCHAR);
        System.out.println(SqlScriptLines.SCR08_CLOSE_TABLE_CREATION);
        System.out.println("");
    }
    
    public void createTableInSchema(){
        /*
        Estaría bueno que un JPane te vaya preguntado 
        a) quiere PK como numeración automática? y/n
        b) cuántos campos con  Varchar? ('0' para ninguno o el número que quiere)
        c) cuántos campos con Integer? ('0' para ninguno o el número que quiere)
        d) cuántos campos con Double? ('0' para ninguno o el número que quiere)
        e) pregunta si hay una FOREIGN KEY
        */
        
       /*
    CREATE TABLE fabricante (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL
);

        
        
CREATE TABLE producto (
  codigo INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(100) NOT NULL,
  precio DOUBLE NOT NULL,
  codigo_fabricante INT UNSIGNED NOT NULL,
  FOREIGN KEY (codigo_fabricante) REFERENCES fabricante(codigo)
);
    */ 
        
       
       
    }
    
    public void insertValuesSQLSimpleIdNameTable(ArrayList<String> listOfNames, String tableName){
        for (int i = 0; i < listOfNames.size(); i++) {
            System.out.println("INSERT INTO " + tableName + " VALUES(" + (i+1) + ",'" + listOfNames.get(i) + "');");
        }
//          INSERT INTO fabricante VALUES(1, 'Asus');
//          INSERT INTO fabricante VALUES(2, 'Lenovo');
//          (etc...)
    }
    
    public void insertValuesSQL_Id_Integer(ArrayList<Integer> listWithIntegers, String tableName){
        /*
            INSERT INTO fabricante VALUES(1, 'Asus');
//          INSERT INTO fabricante VALUES(2, 'Lenovo');
//          (etc...)
        */
        
        System.out.println("");
        for (int i = 0; i < listWithIntegers.size(); i++) {
            System.out.println("INSERT INTO " + tableName + " VALUES(" + (i+1) + ",'" + listWithIntegers.get(i) + "');");
        }
    }
    
    public void insertValuesSQL_idPK_int_varchar(   ArrayList<Integer> intList, 
                                                    ArrayList<String> varchList, 
                                                    String tableName, 
                                                    String schemaName){
        // FIRST CHECK THAT BOTH ARRAYLISTS HAVE SAME AMOUNT OF ELEMENTS
        System.out.println("");
        System.out.println("USE " + schemaName);
        int arraySize = intList.size();
        for (int i = 0; i < arraySize; i++) {
            System.out.println("INSERT INTO " + tableName + " VALUES(" + (i+1) + " ,'" + varchList.get(i) + "'," + 
                    intList.get(i)+"); ");
        }
        
        
    }
    
    public void alterTableAddVarcharColumn(String tableName, String nameOfField2add ){
        /*
            ALTER TABLE table_name
            ADD column_name datatype;
        Exemple:
            ALTER TABLE Customers
            ADD Email varchar(255);
        */
        System.out.println("");
        System.out.println("ALTER TABLE " + tableName + " ");
        System.out.println("ADD " + nameOfField2add + "varchar(100); ");
    }
    
     public void alterTableAddIntegerColumn(String tableName, String nameOfField2add ){
        /*
            ALTER TABLE table_name
            ADD column_name datatype;
        Exemple:
            ALTER TABLE Customers
            ADD customer_code INT UNSIGNED NOT NULL);
        */
        System.out.println("");
        System.out.println("ALTER TABLE " + tableName + " ");
        System.out.println("ADD " + nameOfField2add + " INT; ");
    }
    
     public void updateTableAddIntegerData(ArrayList<Integer> listWithIntegers, String tableName, String columnName, String nameFieldPK){
         /* 
            UPDATE films_by_almodovar SET release_year = 2022  
            WHERE id = 7;
        */
         int counter = 1;
         for (Integer eachInt : listWithIntegers) {
             System.out.println("UPDATE " + tableName + " SET " + columnName + " = " + eachInt + " WHERE " + nameFieldPK + " = " + counter);
             counter++;
         }
         
     }
     
     
}


