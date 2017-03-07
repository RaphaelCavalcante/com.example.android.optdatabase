package optdatabase.android.example.com.exampleoptdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import optdatabase.android.example.com.exampleoptdatabase.database.QuantityDataSource;
import optdatabase.android.example.com.exampleoptdatabase.fragments.UpdateNumberFragment;

public class MainActivity extends AppCompatActivity {
    private TextView number;
    private UpdateNumberFragment numberDialog;
    private QuantityDataSource dataSource;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Quantity qnt;
        number = (TextView) findViewById(R.id.number);
        dataSource = new QuantityDataSource(getApplicationContext());
        dataSource.open();

        if((qnt=dataSource.getQuantityById(1))!=null){
            number.setText(String.valueOf(qnt.getNumber()));
        }else{
            qnt=dataSource.createQuantity(0);
            number.setText(qnt.getNumber());
        }
        numberDialog = UpdateNumberFragment.getInstance(dataSource);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_option, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.change_num:
                numberDialog.show(getSupportFragmentManager(), "Update Number");
                return true;
            case R.id.about:
                Toast.makeText(this, "About", Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void updateTextView(){
        Quantity qnt = dataSource.getQuantityById(1);
        if(qnt!=null){
            number.setText(String.valueOf(qnt.getNumber()));
        }else{
            Toast.makeText(this, "ERROR ON GET VALUE", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        updateTextView();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if(hasFocus){
            updateTextView();
        }
    }
}
