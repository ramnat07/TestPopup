package ehb.be.testpopup.activitis;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import ehb.be.hellopopup.R;
import ehb.be.hellopopup.fragments.ListDialogFragment;
import ehb.be.hellopopup.fragments.SimpeDialogFragment;
import ehb.be.hellopopup.interfaces.ListDialogListener;

public class MainActivity extends AppCompatActivity  implements ListDialogListener{ //8. toegevoegd implements ListDialogListener

   //3. variabele aanmeken
    private Button btnSimpleDialog;
    private Button btnListDialog; //5.a


    //a. link tussen knoppen en code
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSimpleDialog = findViewById(R.id.btn_siple_dialog);
        btnSimpleDialog.setOnClickListener(new View.OnClickListener() { //b. onClickListener aanmaken en daarna dingens die doet bij het aanklokken
            @Override
            public void onClick(View v) {

                SimpeDialogFragment sdf = SimpeDialogFragment.newInstance();
                sdf.show(getSupportFragmentManager(), "sdf");

            }
        });
    //5. hier doe bijna hetzelfde als in stuk 3.
        btnListDialog = findViewById(R.id.btn_list_dialog);
        btnListDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListDialogFragment ldf = ListDialogFragment.newInstance();
                ldf.show(getSupportFragmentManager(), "ldf");
            }
        });

    }

    @Override
    public void onOkCkicked(ArrayList<String> selectedItems) {
        Toast.makeText(getApplicationContext(), selectedItems.toString(),Toast.LENGTH_LONG).show();
    //8. wij beginnen een snackbar maken
        Snackbar sb = Snackbar.make(findViewById(R.id.container),"Placed order", Snackbar.LENGTH_INDEFINITE);

        //8.b.
        sb.setActionTextColor(Color.RED);
        sb.setAction("Undo", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Cancelled order", Toast.LENGTH_LONG).show();
            }
        });
        sb.show(); //8.a.


    }
}
