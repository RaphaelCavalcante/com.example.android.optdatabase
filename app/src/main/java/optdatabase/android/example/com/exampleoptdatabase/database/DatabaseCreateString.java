package optdatabase.android.example.com.exampleoptdatabase.database;

import optdatabase.android.example.com.exampleoptdatabase.contract.OptDatabaseContract.QuantityEntry;
public enum DatabaseCreateString {
    QUANTITY("create table "+
        QuantityEntry.TABLE_NAME+"("+
        QuantityEntry._ID+" integer primary key autoincrement "+
        QuantityEntry.COLUMN_NAME_QUANTITY+" text not null);");
    private String create;
    DatabaseCreateString (String create){this.create=create;}
    public String create(){return create;}
}
