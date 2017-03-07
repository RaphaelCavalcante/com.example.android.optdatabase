package optdatabase.android.example.com.exampleoptdatabase.fragments;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import optdatabase.android.example.com.exampleoptdatabase.R;

/**
 * Created by RHounsell on 07/03/2017.
 */

public class UpdateNumberFragment extends DialogFragment{
    public static UpdateNumberFragment getInstance(){
        UpdateNumberFragment numberFragment = new UpdateNumberFragment();
        return numberFragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.update_number_fragment_layout,null);
        EditText numberText = (EditText) dialogView.findViewById(R.id.number);

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
                Toast.makeText(getContext(), "update number", Toast.LENGTH_SHORT).show();
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
