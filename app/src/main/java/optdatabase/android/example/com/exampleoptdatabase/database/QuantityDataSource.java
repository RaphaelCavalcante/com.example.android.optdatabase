package optdatabase.android.example.com.exampleoptdatabase.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import optdatabase.android.example.com.exampleoptdatabase.Quantity;
import optdatabase.android.example.com.exampleoptdatabase.contract.OptDatabaseContract.QuantityEntry;

/**
 * Created by RHounsell on 07/03/2017.
 */

public class QuantityDataSource  {
    private SQLiteHelper helper;
    private SQLiteDatabase database;
    private String [] allColumns = {
            QuantityEntry._ID,
            QuantityEntry.COLUMN_NAME_QUANTITY
    };

    public QuantityDataSource (Context context){
        helper = SQLiteHelper.getInstance(context.getApplicationContext());
    }
    public void open() throws SQLException{
        database = helper.getWritableDatabase();

    }

    public void close() {helper.close();}

    public Quantity createQuantity(int number){
        ContentValues values = new ContentValues();
        values.put(QuantityEntry.COLUMN_NAME_QUANTITY, String.valueOf(number));
        long insertId = database.insert(QuantityEntry.TABLE_NAME, null, values);
        Cursor cursor = database.query(QuantityEntry.TABLE_NAME, allColumns,
                            QuantityEntry._ID+"="+insertId, null,null,null,null);
        Quantity qnt = null;
       if( cursor.moveToFirst()) {
           qnt = cursorToQuantity(cursor);
           cursor.close();
       }
        return qnt;
    }
    public Quantity getQuantityById(long id){
        Cursor cursor = database.query(QuantityEntry.TABLE_NAME, allColumns,
                QuantityEntry._ID+"="+id, null,null,null,null);
        Quantity qnt = null;
        if(cursor.moveToFirst()) {
            qnt = cursorToQuantity(cursor);
            cursor.close();
        }
        return qnt;
    }
    public void updateQuantity(long id, String value){
        ContentValues values = new ContentValues();
        Log.i("TESTE", value);
        values.put(QuantityEntry.COLUMN_NAME_QUANTITY, value);
        database.update(QuantityEntry.TABLE_NAME, values, QuantityEntry._ID+"="+id, null);
    }
    private Quantity cursorToQuantity(Cursor cursor){
        Quantity qnt = new Quantity();
        qnt.setId(cursor.getLong(0));
        qnt.setNumber(cursor.getString(1));
        return qnt;
    }
}
