package mhacks8.parkgreen;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class Passanger1 extends AppCompatActivity {

    EditText passanger_code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passanger1);

        passanger_code = (EditText) findViewById(R.id.passanger_code);

    }
}
