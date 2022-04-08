package output_4_sql_from_txt_file_app;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import output_4_sql_from_txt_file_app.services.Output_4_sql_services;

public class Output_4_SQL_from_TXT_file_APP {
    
    public static void main(String[] args) {
        
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
       
        
        try {
            Scanner almodovar_sc = new Scanner(almodTxt);
            
            while (almodovar_sc.hasNextLine()){
                String temporaryString = almodovar_sc.nextLine();
                if(temporaryString.length()>6 && !temporaryString.endsWith("credits)")){
                    String yearAsString = temporaryString.substring(1,5);
                    Integer year2putInArray = Integer.parseInt(yearAsString);
                    System.out.println(temporaryString);
                    almodFilmReleaseYearArray.add(year2putInArray);
                    String name2putInArray = temporaryString.substring(6);
                    for (int i = 0; i < name2putInArray.length(); i++) {
                        String char2analyze = name2putInArray.substring(i, i+1);
                        if(char2analyze.equals("'")){
                            int stopRightNow = i;
                            String trimmedName2putInArray = name2putInArray.substring(0, stopRightNow);
                            name2putInArray = trimmedName2putInArray;
                        }
                    }
                    almodFilmNamesArray.add(name2putInArray);
                }
                // let's delete the first line, which is the title "director ... etc"
                //almodFilmNamesArray.remove(0);
                
                //System.out.println(temporaryString);
                almodArray.add(temporaryString);
                
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Output_4_SQL_from_TXT_file_APP.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            //System.out.println(almodTxt.toString());
        }
      
        //serv.getSqlCreation().insertValuesSQLSimpleIdNameTable(almodFilmNamesArray, tableName01);
        System.out.println("");
        System.out.println("here follws the script I want");
         serv.getSqlCreation().insertValuesSQL_idPK_int_varchar(almodFilmReleaseYearArray, almodFilmNamesArray,tableName01,schemaName01);
        
        System.out.println("");
        System.out.println("Here follows all the integers ni the release year array");
        serv.displayIntegersInArrayList(almodFilmReleaseYearArray);
        //serv.displayStringsInArrayList(almodArray);
        //serv.displayStringsInArrayList(almodFilmNamesArray);
        
        //System.out.println(almodArray.get(3));
        
        System.out.println("");
        System.out.println("the size of the names list is " + almodFilmNamesArray.size());
        System.out.println("the size of the releaseYear list is " + almodFilmReleaseYearArray.size() );
        
    }
    
}

/*
+--------------------------------------------------------------------------+
| here follows an sql script to use as a reference                       |
+--------------------------------------------------------------------------+

DROP DATABASE IF EXISTS tienda;
CREATE DATABASE tienda CHARACTER SET utf8mb4;
USE tienda;

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

INSERT INTO fabricante VALUES(1, 'Asus');
INSERT INTO fabricante VALUES(2, 'Lenovo');
INSERT INTO fabricante VALUES(3, 'Hewlett-Packard');
INSERT INTO fabricante VALUES(4, 'Samsung');
INSERT INTO fabricante VALUES(5, 'Seagate');
INSERT INTO fabricante VALUES(6, 'Crucial');
INSERT INTO fabricante VALUES(7, 'Gigabyte');
INSERT INTO fabricante VALUES(8, 'Huawei');
INSERT INTO fabricante VALUES(9, 'Xiaomi');

INSERT INTO producto VALUES(1, 'Disco duro SATA3 1TB', 86.99, 5);
INSERT INTO producto VALUES(2, 'Memoria RAM DDR4 8GB', 120, 6);
INSERT INTO producto VALUES(3, 'Disco SSD 1 TB', 150.99, 4);
INSERT INTO producto VALUES(4, 'GeForce GTX 1050Ti', 185, 7);
INSERT INTO producto VALUES(5, 'GeForce GTX 1080 Xtreme', 755, 6);
INSERT INTO producto VALUES(6, 'Monitor 24 LED Full HD', 202, 1);
INSERT INTO producto VALUES(7, 'Monitor 27 LED Full HD', 245.99, 1);
INSERT INTO producto VALUES(8, 'Portátil Yoga 520', 559, 2);
INSERT INTO producto VALUES(9, 'Portátil Ideapd 320', 444, 2);
INSERT INTO producto VALUES(10, 'Impresora HP Deskjet 3720', 59.99, 3);
INSERT INTO producto VALUES(11, 'Impresora HP Laserjet Pro M26nw', 180, 3);


+--------------------------------------------------------------------------+
|   sql script ends here                                                   |
+--------------------------------------------------------------------------+



The idea is that I originally have a .txt file with a list of films, and I want to translate that into
commands for SQL in order to easily create a table

+--------------------------------------------------------------------------+
| the file text starts after the header and ends right before the footnotes|
+--------------------------------------------------------------------------+
Director (43 credits)

 0000 Extraña forma de vida (Short) (pre-production)
 0000 Untitled Almodóvar Short (Short) (pre-production)
 2022 A Manual for Cleaning Women (pre-production)
 2021 Madres paralelas
 2020 La voz humana (Short)
 2019 Dolor y gloria
 2016 Julieta
 2013 Los amantes pasajeros
 2011 La piel que habito
 2009 Los abrazos rotos
 2009 La concejala antropófaga (Short) (as Mateo Blanco)
 2006 Volver
 2004 La mala educación
 2002 Hable con ella
 1999 Todo sobre mi madre
 1997 Carne trémula (as Pedro Almodovar)
 1996 Pastas Ardilla (TV Short)
 1995 La flor de mi secreto
 1993 Kika (as Pedro Almodovar)
 1991 Tacones lejanos
 1989 Átame!
 1988 Mujeres al borde de un ataque de nervios
 1987 La ley del deseo (as Pedro Almodovar)
 1986 Matador
 1985 Tráiler para amantes de lo prohibido! (TV Short)
 1984 ¿Qué he hecho YO para merecer esto!! (as Pedro Almodovar)
 1983 Entre tinieblas (as Pedro Almodovar)
 1982 Laberinto de pasiones
 1980 Pepi, Luci, Bom y otras chicas del montón
 1978 Folle... folle... fólleme Tim!
 1978 Salomé (Short)
 1977 Complementos (Short)
 1977 Las tres ventajas de Ponte (Short)
 1977 Sexo va, sexo viene (Short)
 1976 Muerte en la carretera (Short)
 1976 Sea caritativo (Short)
 1976 Tráiler de 'Who's Afraid of Virginia Woolf?' (Short)
 1975 Blancor (Short)
 1975 El sueño, o la estrella (Short)
 1975 Homenaje (Short)
 1975 La caída de Sódoma (Short)
 1974 Dos putas, o historia de amor que termina en boda (Short)
 1974 Film político (Short)

+--------------------------------------------------------------------------+
| this is no longer part of the file. Te above was extracted from imdb.com |
+--------------------------------------------------------------------------+

package io;

import java.io.File;
import java.util.Scanner;

public class ReadFromFileUsingScanner {
    public static void main(String[] args) throws Exception {
        File file=new File("C:\\Users\\pankaj\\Desktop\\test.java");
        Scanner sc=new Scanner(file);
        while(sc.hasNextLine()){
            System.out.println(sc.nextLine());
        }
    }
}



https://stackoverflow.com/questions/13185727/reading-a-txt-file-using-scanner-class-in-java





*/


