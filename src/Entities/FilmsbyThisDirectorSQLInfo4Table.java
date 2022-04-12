
package Entities;

import java.util.ArrayList;


public class FilmsbyThisDirectorSQLInfo4Table {
    
    protected String tableName;
    protected String varCharColumName;
    protected String integerColumnName;
    protected String schemaItBelongs2;
    protected ArrayList<String> everyFilmName;
    protected ArrayList<Integer> everyReleaseYear;

    public FilmsbyThisDirectorSQLInfo4Table() {
        // ATTENTION: ArrayList initialized as empty ArrayList
        this.everyFilmName = new ArrayList();
        this.everyReleaseYear = new ArrayList();
    }

    public FilmsbyThisDirectorSQLInfo4Table(String tableName, String varCharColumName, String integerColumnName, String schemaItBelongs2, ArrayList<String> everyFilmName, ArrayList<Integer> everyReleaseYear) {
        this.tableName = tableName;
        this.varCharColumName = varCharColumName;
        this.integerColumnName = integerColumnName;
        this.schemaItBelongs2 = schemaItBelongs2;
        this.everyFilmName = everyFilmName;
        this.everyReleaseYear = everyReleaseYear;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getVarCharColumName() {
        return varCharColumName;
    }

    public void setVarCharColumName(String varCharColumName) {
        this.varCharColumName = varCharColumName;
    }

    public String getIntegerColumnName() {
        return integerColumnName;
    }

    public void setIntegerColumnName(String integerColumnName) {
        this.integerColumnName = integerColumnName;
    }

    public String getSchemaItBelongs2() {
        return schemaItBelongs2;
    }

    public void setSchemaItBelongs2(String schemaItBelongs2) {
        this.schemaItBelongs2 = schemaItBelongs2;
    }

    public ArrayList<String> getEveryFilmName() {
        return everyFilmName;
    }

    public void setEveryFilmName(ArrayList<String> everyFilmName) {
        this.everyFilmName = everyFilmName;
    }

    public ArrayList<Integer> getEveryReleaseYear() {
        return everyReleaseYear;
    }

    public void setEveryReleaseYear(ArrayList<Integer> everyReleaseYear) {
        this.everyReleaseYear = everyReleaseYear;
    }
    
    
    
    
    
}
