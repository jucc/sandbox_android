package br.com.teoriadetudo.android.helloWorld;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class HelloWorldActivity extends Activity
{
    public final static String EXTRA_MESSAGE = "br.com.teoriadetudo.android.helloWorld.MESSAGE";
    static final String ROTATIONS = "number";
    private int curNumber;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        // Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // In main activity, the app icon in the action bar is not a button
            ActionBar actionBar = getActionBar();
            actionBar.setHomeButtonEnabled(false);
        }

        if (savedInstanceState != null) {
            curNumber = savedInstanceState.getInt(ROTATIONS, curNumber);
        } else {
            curNumber = 0;
        }

        // Set the user interface layout for this Activity
        // The layout file is defined in the project res/layout/main_activity.xml file
        setContentView(R.layout.main);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState)
    {
        savedInstanceState.putInt(ROTATIONS, curNumber + 1);
        TextView textView = (TextView) findViewById(R.id.count_text);
        if (textView != null) textView.setText("");
        super.onSaveInstanceState(savedInstanceState);
    }

    /** Called when the user clicks the Send button */
    public void sendMessage(View view)
    {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        intent.putExtra(EXTRA_MESSAGE, editText.getText().toString());
        startActivity(intent);
    }

    public void countNumber(View view)
    {
        TextView textView = (TextView) findViewById(R.id.count_text);
        if (textView != null) textView.setText(String.valueOf(curNumber));
    }
}
