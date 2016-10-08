package mhacks8.parkgreen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //TextView textView = new TextView(this);
        //textView.setTextSize(40);
        //textView.setText(message);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_display_message);
        //layout.addView(textView);
        //textView.setText(message);
        TextView textCode = (TextView) findViewById(R.id.textView_Code);
        textCode.setText(message);

        int numPassanger = 1;
        TextView textNumPassanger = (TextView) findViewById(R.id.textView_numPassanger);
        textNumPassanger.setText(Integer.toString(numPassanger));

        if(numPassanger > 0) {
            Button park = (Button) findViewById(R.id.button_park);
            park.setVisibility(View.VISIBLE);
        }




    }

    public void clickNFC(View view) {
        //code goes here
    }
}
