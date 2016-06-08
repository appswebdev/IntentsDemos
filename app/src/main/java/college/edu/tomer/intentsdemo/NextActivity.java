package college.edu.tomer.intentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    EditText etMessage;
    TimePicker timePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        etMessage = (EditText) findViewById(R.id.etMessage);
        timePicker = (TimePicker) findViewById(R.id.timePicker);

        Intent intent = getIntent();
        String userName = intent.getStringExtra("userName");
        Toast.makeText(NextActivity.this, "Hello, "+userName, Toast.LENGTH_SHORT).show();


    }

    public void dial(View view) {
        Uri telUri = Uri.parse("tel://0507123012");
        Intent telIntent = new Intent(Intent.ACTION_DIAL, telUri);
        startActivity(telIntent);
    }

    public void sms(View view) {
        Uri telUri = Uri.parse("smsto:0507123012");
        Intent telIntent = new Intent(Intent.ACTION_SENDTO, telUri);
        startActivity(telIntent);
    }

    public void google(View view) {
        Uri telUri = Uri.parse("https://www.google.co.il/?q=Hello");
        Intent telIntent = new Intent(Intent.ACTION_VIEW, telUri);
        startActivity(telIntent);
    }


    public void setAlarm(View view) {
        Intent intent = new Intent(AlarmClock.ACTION_SET_ALARM);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            intent.putExtra(AlarmClock.EXTRA_HOUR, timePicker.getHour());
            intent.putExtra(AlarmClock.EXTRA_MINUTES, timePicker.getMinute());
        }else{
            intent.putExtra(AlarmClock.EXTRA_HOUR, timePicker.getCurrentHour());
            intent.putExtra(AlarmClock.EXTRA_MINUTES, timePicker.getCurrentMinute());
        }

        intent.putExtra(AlarmClock.EXTRA_MESSAGE, etMessage.getText().toString());

        if(intent.resolveActivity(getPackageManager())!=null){
            startActivity(intent);
        }
    }
}
