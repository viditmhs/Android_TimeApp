package com.tmc.TimeAPP;

/*
    Header Information:

    *******************************************************************
    DESCRIPTION:
    Here we show user information. In this page we represents
    - Check In Now          <Button>
    - Check Out Now         <Button>
    - Modifying timing      <Button>
    - Time submit (5)       <Check Box>
    - Information regarding check in and check out time
    - Submit selected date  <Button>

    Here we check in and check out button are to check for a day.
    and then one can choose days on check box and then submit it.
    *******************************************************************
 */

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

public class UserInformation extends Activity{

    final public String INFO = "Info::";
    final private String DEFAULT_MSG = "----" ;

    /*
        Keys for key value pairs used to save instance when app is destroyed
        or its orientation is changed.
        KVP_ implies KeyValuePair

     */

    static final String KVP_CHECK_IN_VALUE      = "CHECK_IN_VALUE";
    static final String KVP_CHECK_OUT_VALUE     = "CHECK_OUT_VALUE";
    static final String KVP_MODIFY_TIME_VALUE   = "MODIFY_TIME_VALUE";
    static final String KVP_CHEKCBOX_DAY1       = "CHECKBOX_DAY1";
    static final String KVP_CHEKCBOX_DAY2       = "CHECKBOX_DAY2";
    static final String KVP_CHEKCBOX_DAY3       = "CHECKBOX_DAY3";
    static final String KVP_CHEKCBOX_DAY4       = "CHECKBOX_DAY4";
    static final String KVP_CHEKCBOX_DAY5       = "CHECKBOX_DAY5";

    static final String KVP_DAY1_IN         = "DAY1_IN";
    static final String KVP_DAY1_OUT        = "DAY1_OUT";
    static final String KVP_DAY1_TOTAL      = "DAY1_TOTAL";
    static final String KVP_DAY2_IN         = "DAY2_IN";
    static final String KVP_DAY2_OUT        = "DAY2_OUT";
    static final String KVP_DAY2_TOTAL      = "DAY2_TOTAL";
    static final String KVP_DAY3_IN         = "DAY3_IN";
    static final String KVP_DAY3_OUT        = "DAY3_OUT";
    static final String KVP_DAY3_TOTAL      = "DAY3_TOTAL";
    static final String KVP_DAY4_IN         = "DAY4_IN";
    static final String KVP_DAY4_OUT        = "DAY4_OUT";
    static final String KVP_DAY4_TOTAL      = "DAY4_TOTAL";
    static final String KVP_DAY5_IN         = "DAY5_IN";
    static final String KVP_DAY5_OUT        = "DAY5_OUT";
    static final String KVP_DAY5_TOTAL      = "DAY5_TOTAL";

    Boolean isCheckBoxDay1Checked = false;
    Boolean isCheckBoxDay2Checked = false;
    Boolean isCheckBoxDay3Checked = false;
    Boolean isCheckBoxDay4Checked = false;
    Boolean isCheckBoxDay5Checked = false;

    Button button_check_in;
    Button button_check_out;
    Button button_modify_time;
    Button button_submit_clocked_time;

    TextView textView_check_in_value, textView_check_out_value, textView_modify_time_value;
    TextView textView_day1_in, textView_day1_out, textView_day1_total;
    TextView textView_day2_in, textView_day2_out, textView_day2_total;
    TextView textView_day3_in, textView_day3_out, textView_day3_total;
    TextView textView_day4_in, textView_day4_out, textView_day4_total;
    TextView textView_day5_in, textView_day5_out, textView_day5_total;

    CheckBox checkBox_day1, checkBox_day2, checkBox_day3, checkBox_day4, checkBox_day5;

    @Override
    public void onCreate(Bundle saveInstanceState){
        super.onCreate(saveInstanceState);

        Log.i(INFO, "Setting user information window");
        setContentView(R.layout.page_1);

        button_check_in     = (Button)findViewById(R.id.check_in);
        button_check_out    = (Button)findViewById(R.id.check_out);
        button_modify_time  = (Button)findViewById(R.id.modify_time);

        button_submit_clocked_time = (Button)findViewById(R.id.submit_clocked_time);

        checkBox_day1 = (CheckBox)findViewById(R.id.checkBox_day1);
        checkBox_day2 = (CheckBox)findViewById(R.id.checkBox_day2);
        checkBox_day3 = (CheckBox)findViewById(R.id.checkBox_day3);
        checkBox_day4 = (CheckBox)findViewById(R.id.checkBox_day4);
        checkBox_day5 = (CheckBox)findViewById(R.id.checkBox_day5);

        textView_check_in_value    = (TextView)findViewById(R.id.check_in_value);
        textView_check_out_value   = (TextView)findViewById(R.id.check_out_value);
        textView_modify_time_value = (TextView)findViewById(R.id.modify_time_value);

        textView_day1_in    = (TextView)findViewById(R.id.day1_in);
        textView_day1_out   = (TextView)findViewById(R.id.day1_out);
        textView_day1_total = (TextView)findViewById(R.id.day1_total);

        textView_day2_in    = (TextView)findViewById(R.id.day2_in);
        textView_day2_out   = (TextView)findViewById(R.id.day2_out);
        textView_day2_total = (TextView)findViewById(R.id.day2_total);

        textView_day3_in    = (TextView)findViewById(R.id.day3_in);
        textView_day3_out   = (TextView)findViewById(R.id.day3_out);
        textView_day3_total = (TextView)findViewById(R.id.day3_total);

        textView_day4_in    = (TextView)findViewById(R.id.day4_in);
        textView_day4_out   = (TextView)findViewById(R.id.day4_out);
        textView_day4_total = (TextView)findViewById(R.id.day4_total);

        textView_day5_in    = (TextView)findViewById(R.id.day5_in);
        textView_day5_out   = (TextView)findViewById(R.id.day5_out);
        textView_day5_total = (TextView)findViewById(R.id.day5_total);

        if (saveInstanceState != null)
        {
            textView_check_in_value.setText(saveInstanceState.getString(KVP_CHECK_IN_VALUE));
            textView_check_out_value.setText(saveInstanceState.getString(KVP_CHECK_OUT_VALUE));
            textView_modify_time_value.setText(saveInstanceState.getString(KVP_MODIFY_TIME_VALUE));

            checkBox_day1.setChecked(saveInstanceState.getBoolean(KVP_CHEKCBOX_DAY1));
            checkBox_day2.setChecked(saveInstanceState.getBoolean(KVP_CHEKCBOX_DAY2));
            checkBox_day3.setChecked(saveInstanceState.getBoolean(KVP_CHEKCBOX_DAY3));
            checkBox_day4.setChecked(saveInstanceState.getBoolean(KVP_CHEKCBOX_DAY4));
            checkBox_day5.setChecked(saveInstanceState.getBoolean(KVP_CHEKCBOX_DAY5));

            textView_day1_in.setText(saveInstanceState.getString(KVP_DAY1_IN));
            textView_day1_out.setText(saveInstanceState.getString(KVP_DAY1_OUT));
            textView_day1_total.setText(saveInstanceState.getString(KVP_DAY1_TOTAL));

            textView_day2_in.setText(saveInstanceState.getString(KVP_DAY2_IN));
            textView_day2_out.setText(saveInstanceState.getString(KVP_DAY2_OUT));
            textView_day2_total.setText(saveInstanceState.getString(KVP_DAY2_TOTAL));

            textView_day3_in.setText(saveInstanceState.getString(KVP_DAY3_IN));
            textView_day3_out.setText(saveInstanceState.getString(KVP_DAY3_OUT));
            textView_day3_total.setText(saveInstanceState.getString(KVP_DAY3_TOTAL));

            textView_day4_in.setText(saveInstanceState.getString(KVP_DAY4_IN));
            textView_day4_out.setText(saveInstanceState.getString(KVP_DAY4_OUT));
            textView_day4_total.setText(saveInstanceState.getString(KVP_DAY4_TOTAL));

            textView_day5_in.setText(saveInstanceState.getString(KVP_DAY5_IN));
            textView_day5_out.setText(saveInstanceState.getString(KVP_DAY5_OUT));
            textView_day5_total.setText(saveInstanceState.getString(KVP_DAY5_TOTAL));

        }
        else
        {
            Log.i(INFO, "Bundle's saved instance is NULL");
        }

        button_check_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ToDo Implement the code. For now only a toast message.
                textView_check_in_value.setText(DateFormat.getDateTimeInstance().format(new Date()));
                Log.i(INFO, "Check in Value inserted.");
            }
        });

        button_check_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ToDo Implement the code. For now only a toast message.
                textView_check_out_value.setText(DateFormat.getDateTimeInstance().format(new Date()));
                Log.i(INFO, "Check out value inserted.");
            }
        });

        button_modify_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ToDo Implement the code. For now only a toast message.
                textView_modify_time_value.setText(DateFormat.getDateTimeInstance().format(new Date()));
                Log.i(INFO, "Check in and/or check out value(s) modified");
            }
        });

        button_submit_clocked_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //ToDo Implement the code. For now only a toast message.
                Toast.makeText(getApplicationContext(), "Submit Clocked Time button pressed", Toast.LENGTH_SHORT).show();

                //Checking which checkbox is checked

                if (checkBox_day1.isChecked()) {
                    isCheckBoxDay1Checked = true;
                    Log.i(INFO, "Day 1 Checked");
                } else {
                    isCheckBoxDay1Checked = false;
                    Log.i(INFO, "Day 1 Not-Checked");
                }

                if (checkBox_day2.isChecked()) {
                    isCheckBoxDay2Checked = true;
                    Log.i(INFO, "Day 2 Checked");
                } else {
                    isCheckBoxDay2Checked = false;
                    Log.i(INFO, "Day 2 Not-Checked");
                }

                if (checkBox_day3.isChecked()) {
                    isCheckBoxDay3Checked = true;
                    Log.i(INFO, "Day 3 Checked");
                } else {
                    isCheckBoxDay3Checked = false;
                    Log.i(INFO, "Day 3 Not-Checked");
                }

                if (checkBox_day4.isChecked()) {
                    isCheckBoxDay4Checked = true;
                    Log.i(INFO, "Day 4 Checked");
                } else {
                    isCheckBoxDay4Checked = false;
                    Log.i(INFO, "Day 4 Not-Checked");
                }

                if (checkBox_day5.isChecked()) {
                    isCheckBoxDay5Checked = true;
                    Log.i(INFO, "Day 5 Checked");
                } else {
                    isCheckBoxDay5Checked = false;
                    Log.i(INFO, "Day 5 Not-Checked");
                }

                // Setting default message to all text View

                updateTextView(textView_day1_in, DEFAULT_MSG);
                updateTextView(textView_day1_out, DEFAULT_MSG);
                updateTextView(textView_day1_total, DEFAULT_MSG);

                updateTextView(textView_day2_in, DEFAULT_MSG);
                updateTextView(textView_day2_out, DEFAULT_MSG);
                updateTextView(textView_day2_total, DEFAULT_MSG);

                updateTextView(textView_day3_in, DEFAULT_MSG);
                updateTextView(textView_day3_out, DEFAULT_MSG);
                updateTextView(textView_day3_total, DEFAULT_MSG);

                updateTextView(textView_day4_in, DEFAULT_MSG);
                updateTextView(textView_day4_out, DEFAULT_MSG);
                updateTextView(textView_day4_total, DEFAULT_MSG);

                updateTextView(textView_day5_in, DEFAULT_MSG);
                updateTextView(textView_day5_out, DEFAULT_MSG);
                updateTextView(textView_day5_total, DEFAULT_MSG);

            }
        });


    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putString(KVP_CHECK_IN_VALUE, textView_check_in_value.getText().toString());
        savedInstanceState.putString(KVP_CHECK_OUT_VALUE, textView_check_out_value.getText().toString());
        savedInstanceState.putString(KVP_MODIFY_TIME_VALUE, textView_modify_time_value.getText().toString());

        savedInstanceState.putBoolean(KVP_CHEKCBOX_DAY1, checkBox_day1.isChecked());
        savedInstanceState.putBoolean(KVP_CHEKCBOX_DAY2, checkBox_day2.isChecked());
        savedInstanceState.putBoolean(KVP_CHEKCBOX_DAY3, checkBox_day3.isChecked());
        savedInstanceState.putBoolean(KVP_CHEKCBOX_DAY4, checkBox_day4.isChecked());
        savedInstanceState.putBoolean(KVP_CHEKCBOX_DAY5, checkBox_day5.isChecked());

        savedInstanceState.putString(KVP_DAY1_IN, textView_day1_in.getText().toString());
        savedInstanceState.putString(KVP_DAY1_OUT, textView_day1_out.getText().toString());
        savedInstanceState.putString(KVP_DAY1_TOTAL, textView_day1_total.getText().toString());

        savedInstanceState.putString(KVP_DAY2_IN, textView_day2_in.getText().toString());
        savedInstanceState.putString(KVP_DAY2_OUT, textView_day2_out.getText().toString());
        savedInstanceState.putString(KVP_DAY2_TOTAL, textView_day2_total.getText().toString());

        savedInstanceState.putString(KVP_DAY3_IN, textView_day3_in.getText().toString());
        savedInstanceState.putString(KVP_DAY3_OUT, textView_day3_out.getText().toString());
        savedInstanceState.putString(KVP_DAY3_TOTAL, textView_day3_total.getText().toString());

        savedInstanceState.putString(KVP_DAY4_IN, textView_day4_in.getText().toString());
        savedInstanceState.putString(KVP_DAY4_OUT, textView_day4_out.getText().toString());
        savedInstanceState.putString(KVP_DAY4_TOTAL, textView_day4_total.getText().toString());

        savedInstanceState.putString(KVP_DAY5_IN, textView_day5_in.getText().toString());
        savedInstanceState.putString(KVP_DAY5_OUT, textView_day5_out.getText().toString());
        savedInstanceState.putString(KVP_DAY5_TOTAL, textView_day5_total.getText().toString());

        super.onSaveInstanceState(savedInstanceState);



    }

    private void updateTextView(TextView textView, String msg){

        textView.setText(msg);

    }
}
