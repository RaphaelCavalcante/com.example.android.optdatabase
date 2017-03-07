package optdatabase.android.example.com.exampleoptdatabase.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
public class SQLiteHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "optdatabase.db";
    private static final int DATABASE_VERSION = 1;
    private static SQLiteHelper helper;
    public static synchronized SQLiteHelper getInstance(Context context){
        if(helper == null){
            helper = new SQLiteHelper(context.getApplicationContext());
        }
        return helper;
    }
    private SQLiteHelper(Context context){
        super (context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        for (DatabaseCreateString sql:DatabaseCreateString.values()){
            sqLiteDatabase.execSQL(sql.create());
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
