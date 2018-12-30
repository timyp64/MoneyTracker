package mt.timyp64.com.moneytracker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

public class AddItemActivity extends AppCompatActivity {
    private EditText itemName;
    private EditText itemPrice;
    private Button addBtn;

    private static final String TAG = "AddItemActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_additem);

        final EditText name = findViewById(R.id.name);
        final EditText price = findViewById(R.id.price);
        final Button addBtn = findViewById(R.id.add_btn);

        final Boolean btnFlagName = false;
       final Boolean btnFlagPrice = false;

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                addBtn.setEnabled(!TextUtils.isEmpty(s));
            }
        });
        price.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s);
                price.setText(s);

             /*   if(TextUtils.isEmpty(s)){
                    addBtn.setEnabled(false);
                    Boolean btnFlagName = true;
                }*/

                //Boolean btnFlagPrice = true;
               //addBtn.setEnabled(!TextUtils.isEmpty(s));
            }
        });

        //addBtn.setEnabled(!TextUtils.isEmpty(s));
   /*     addBtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String itemName = name.getText().toString();
                String itemPrice = price.getText().toString();
            }
        });*/
    }
}
