package sg.edu.rp.c346.id19013886.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Step 1: Declare the field variables
    EditText etName;
    EditText etMobileNo;
    EditText etPax;
    CheckBox cbEnabled;
    DatePicker dp;
    TimePicker tp;
    Button btnReserve;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Step 2: Link the the field variable to UI components in Layout
        etName = findViewById(R.id.editTextName);
        etMobileNo = findViewById(R.id.editTextMobileNo);
        etPax = findViewById(R.id.editTextPax);
        cbEnabled = findViewById(R.id.checkBoxSmokeArea);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);

        // Set the Default Date and Time
        dp.updateDate(2021, 5, 1);
        tp.setCurrentHour(7);
        tp.setCurrentMinute(30);


        // Enhancements
        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String checkField = "";
                if (etName.getText().toString().isEmpty()
                        & etMobileNo.getText().toString().isEmpty()
                        & etPax.getText().toString().isEmpty()){
                    checkField = "Please enter all the required fields.";

                    Toast.makeText(MainActivity.this, checkField, Toast.LENGTH_LONG).show();

                } else {
                    String name = etName.getText().toString();
                    String mobileNo = etMobileNo.getText().toString();
                    String pax = etPax.getText().toString();

                    String smokeArea = "";
                    if (cbEnabled.isChecked()){
                        smokeArea = "smoking area";
                    } else {
                        smokeArea = "non-smoking area";
                    }

                    String date = dp.getYear() + "/" + (dp.getMonth() + 1) + "/" + dp.getDayOfMonth();
                    String time = tp.getCurrentHour() + ":" + String.format("%02d", tp.getCurrentMinute());

                    String msg = "Hi, " + name + ", you have book a "
                            + pax + " person(s) " + smokeArea
                            + " table on " + date + " at "
                            + time + ". Your phone number is "
                            + mobileNo + ".";

                    Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                }

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etMobileNo.setText("");
                etPax.setText("");
                cbEnabled.setChecked(false);
                dp.updateDate(2021, 5, 1);
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
            }
        });

    }
}