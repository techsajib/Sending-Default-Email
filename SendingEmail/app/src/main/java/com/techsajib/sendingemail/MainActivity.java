package com.techsajib.sendingemail;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        Button email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = (Button) findViewById(R.id.email);

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try{
                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String [] {"example@gmail.com"});
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Official email for business!");
                    intent.putExtra(Intent.EXTRA_TEXT, "Hi dude, I hope our relationship doing better day by day...");
                    intent.setType("massage/efc822");
                    startActivity(intent);

                }catch (ActivityNotFoundException anfe){
                    Toast.makeText(MainActivity.this, "Sorry! No email client found here!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
}
