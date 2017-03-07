package optdatabase.android.example.com.exampleoptdatabase.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import optdatabase.android.example.com.exampleoptdatabase.Quantity;
import optdatabase.android.example.com.exampleoptdatabase.R;
import optdatabase.android.example.com.exampleoptdatabase.database.QuantityDataSource;

/**
 * Created by RHounsell on 07/03/2017.
 */

public class UpdateNumberFragment extends DialogFragment{
    private static QuantityDataSource qntDataSource;
    private EditText numberText;
    public static UpdateNumberFragment getInstance(QuantityDataSource dataSource){
        UpdateNumberFragment numberFragment = new UpdateNumberFragment();
        qntDataSource = dataSource;
        return numberFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.update_number_fragment_layout,null);

        Quantity qnt= qntDataSource.getQuantityById(1);

        numberText = (EditText) dialogView.findViewById(R.id.number_text);
        if(qnt!=null){
            numberText.setText(qnt.getNumber());
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("UPDATE NUMBER");

        builder.setView(dialogView).setPositiveButton("Update", this.onUpdateButtonClick())
                .setNegativeButton("Cancel", this.onCancelButtonClick());

        return builder.create();
    }
    private DialogInterface.OnClickListener onUpdateButtonClick() {
        return new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                qntDataSource.updateQuantity(1, numberText.getText().toString());
            }

        };
    }
    private DialogInterface.OnClickListener onCancelButtonClick() {
        return new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dismiss();
            }

        };
    }
}
