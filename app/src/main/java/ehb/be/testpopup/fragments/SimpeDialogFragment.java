package ehb.be.testpopup.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;

/**
 * Created by mobapp07 on 1/03/2018.
 */
//1.Eerst maken we een classe java SimpeDialogFragment extends DialogFragment
public class SimpeDialogFragment extends DialogFragment {

    public SimpeDialogFragment(){
    }
        public static SimpeDialogFragment newInstance(){
        return new SimpeDialogFragment();
                }
    //2.dan maken we on popup methode
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle("Alert");
        builder.setMessage("Past oep e manneke");
        builder.setNegativeButton("Cancel", null);

        return builder.create();
    }
}
