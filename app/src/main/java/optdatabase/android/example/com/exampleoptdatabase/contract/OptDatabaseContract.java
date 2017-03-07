package optdatabase.android.example.com.exampleoptdatabase.contract;

import android.provider.BaseColumns;
public class OptDatabaseContract {
    private OptDatabaseContract(){}
    public static class QuantityEntry implements BaseColumns{
        public static final String TABLE_NAME = "quantity_tb";
        public static final String COLUMN_NAME_QUANTITY = "quantity";
    }
}
