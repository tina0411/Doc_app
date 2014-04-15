package com.cmu.doc.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class LogIn extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState); // call superclass's version
        setContentView(R.layout.log_in); // inflate the GUI

        if ( savedInstanceState == null ) // the app just started running
        {
        } // end if
        else // app is being restored from memory, not executed from scratch
        {
            // initialize the bill amount to saved amount
        } // end else
    }

    public void logIn(View view) {
        Intent intent = new Intent(this, FutureActivity.class);
        startActivity(intent);
    }

}
