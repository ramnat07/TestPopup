package ehb.be.testpopup.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

import java.util.ArrayList;

import ehb.be.hellopopup.interfaces.ListDialogListener;

/**
 * Created by mobapp07 on 1/03/2018.
 */
//4.
public class ListDialogFragment extends DialogFragment {

    private String[] toppingsList = {"cheese", "hesp", "sla", "komkommer", "pittavlees", "spek", "tomato", "hardgekookt ei"};//a.
    private boolean[] selectedToppingsList = new boolean[toppingsList.length];//b.dit is dan een boolean aanmaken om meerdere keuzes te laten maken bij beleg


    //7.
    private ListDialogListener mDialogListener; //a. we maken een vaeiabele

    public ListDialogFragment() {

    }

    public static ListDialogFragment newInstance() {//4.
        return new ListDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {//4.
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        //7.d. een lijst aanmaken om kunnen toevoegen of verwijderen
        final ArrayList<String> gekozenToppings = new ArrayList<>();

        builder.setTitle("Choose your toppings");
        builder.setMultiChoiceItems(toppingsList, selectedToppingsList, new DialogInterface.OnMultiChoiceClickListener() {
            @Override//7.c. om geselecteerde items laten saven om later die lijst kunnen doorgeven
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    gekozenToppings.add(toppingsList[which]);
                } else {
                    gekozenToppings.remove(toppingsList[which]);
                }
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mDialogListener.onOkCkicked(gekozenToppings);
            }
        });

        return builder.create();
    }

    @Override //7.b.
    public void onAttach(Context context) {
        super.onAttach(context);

        mDialogListener = (ListDialogListener) context;
    }
}
