package college.edu.tomer.intentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText etUserName;

    EditText etPassword;

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //init the intent object
                Intent i1 = new Intent(MainActivity.this, NextActivity.class);
                //optionally add extra data
                i1.putExtra("userName", etUserName.getText().toString());
                i1.putExtra("password", etPassword.getText().toString());

                startActivity(i1);
            }
        });

    }

}
