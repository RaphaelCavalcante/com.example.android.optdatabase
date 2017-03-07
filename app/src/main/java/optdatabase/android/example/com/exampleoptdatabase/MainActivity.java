package optdatabase.android.example.com.exampleoptdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import optdatabase.android.example.com.exampleoptdatabase.fragments.UpdateNumberFragment;

public class MainActivity extends AppCompatActivity {
    private TextView number;
    private UpdateNumberFragment numberDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        number = (TextView) findViewById(R.id.number);
        numberDialog = UpdateNumberFragment.getInstance();
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

    private void changeNumberValue(TextView thisNumber){
        int intNumber= Integer.valueOf(thisNumber.getText().toString());
        intNumber=intNumber+1;
        thisNumber.setText(String.valueOf(intNumber));
    }
}
