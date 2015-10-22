package com.tmc.TimeAPP;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
    Header Information:

    *******************************************************************
    DESCRIPTION:
    First page of the time app for TMC. App help user to check in and
    check out. The time difference between check-in and check-out would
    then be uploaded to TMC server for automatic time registration.
 */

public class MainActivity extends Activity {

    //Some Class specific Variable
    final public String INFO = "Info:: ";

    // NOTE for warnign we use 23### as index
    final int userNameWarningidx  = 23001;
    final int userPasswordidx     = 23002;
    final int userWarningidx      = 23003;
    private String sUsername;
    private String sPassword;

    // EditView object for Username
    EditText mUserName;
    EditText mPassword;
    final private String usernameWarningMsg = "Wrong or No username";

    // TextView object for PassWord
    TextView mUserNameWarning;
    TextView mPasswordWarning;
    final private String passwordWarningMsg = "Wrong or No password";

    // Button object for Login
    Button mLogin;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.i(INFO, "Setting the main view");
        setContentView(R.layout.main);

        // Initializing username, usernameWarning TextView
        mUserName = (EditText)findViewById(R.id.username);
        mUserNameWarning = (TextView)findViewById(R.id.usernameWarning);

        // Initializing password TextView
        mPassword = (EditText)findViewById(R.id.password);
        mPasswordWarning = (TextView)findViewById(R.id.passwordWarning);

        // Initializing login button
        mLogin = (Button)findViewById(R.id.login);

        // Implementing onButtonClickListern
        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Setting mUsernameWarning and mPasswordWarning to nothing

                // Check if mUserName is null or has no input string then give warning
                sUsername = mUserName.getText().toString();

                if(sUsername != null && !sUsername.isEmpty()){
                    Log.i(INFO, "User name not null. " + sUsername);

                }else{
                    Log.i(INFO, "User name null. " + sUsername);
                    // Restart the page with Error message
                    setWarning(userNameWarningidx);
                }

                // Check if mPassword is null or has no input string then give warning

                sPassword = mPassword.getText().toString();

                if(sPassword != null && !sPassword.isEmpty()){
                    Log.i(INFO, "Password not null. " + sPassword);

                }else{
                    Log.i(INFO, "Password null. " + sPassword);
                    // Restart the page with Error message
                    setWarning(userPasswordidx);
                }

                // If sUsername and sPassword are not null then check for credential in database
                //  // Todo: Stub this functionality to be implemented later
                boolean credentialCheckResult = checkCredentials(sUsername, sPassword);

                // If matcher start new activity with information retrieved from data base.
                if(credentialCheckResult){

                    // Start retrieving user check-in check-out data for last week and current week
                    // and start displaying  them into listView
                    Intent userInformationIntent = new Intent(getApplicationContext(), UserInformation.class);
                    startActivity(userInformationIntent);

                }else{

                    // Since credential doesn't match give ERROR: WRONG USERNAME OR PASSWORD
                    // and ask user password again.
                    Toast.makeText(getApplicationContext(), "Login Unsuccessfull", Toast.LENGTH_LONG).show();

                }

            }
        });


    }
    // Stub function to check credentials of username and password
    private boolean checkCredentials(String user, String password){

        if(user.contentEquals("admin") && password.contentEquals("tmc")){

            return true;

        }else{

            if(user != "admin"){
                setWarning(userNameWarningidx);
            }

            if(password != "tmc"){
                setWarning(userPasswordidx);
            }
            return false;

        }
    }

    private void setWarning(int Label){

        switch (Label){

            case userNameWarningidx:
                if (mUserNameWarning != null) {
                    mUserNameWarning.setText(usernameWarningMsg);
                    Log.i(INFO, "Username warning set");
                }
                break;
            case userPasswordidx:
                if(mPasswordWarning != null) {
                    mPasswordWarning.setText(passwordWarningMsg);
                    Log.i(INFO, "Password warning set");
                }
                break;
            case userWarningidx:
                if(mUserNameWarning != null && mPasswordWarning != null) {
                    mUserNameWarning.setText(usernameWarningMsg);
                    mPasswordWarning.setText(passwordWarningMsg);
                    Log.i(INFO, "Setting warning");
                }
                break;
            default:
                Log.i(INFO, "Cannot set the warning. Wrong index");
        }

    }
}
