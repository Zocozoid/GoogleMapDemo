package com.example.googlemapdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class  LogInActivity extends AppCompatActivity {


    EditText sifraPatrola, sifraKorisnik;
    Button login;
    DatabaseOpenHelper databaseOpenHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);


        login = findViewById(R.id.login);

        sifraPatrola = findViewById(R.id.sifraPatrola);
        sifraKorisnik = findViewById(R.id.sifraKorisnik);


        databaseOpenHelper = new DatabaseOpenHelper(LogInActivity.this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              boolean ifExist = databaseOpenHelper.checkUserExist(sifraPatrola.getText().toString(),sifraKorisnik.getText().toString());

              if (ifExist)
              {
                  Intent intent = new Intent(LogInActivity.this,MainActivity.class);
                  intent.putExtra("sifraPatrola",sifraPatrola.getText().toString());

                  startActivity(intent);
              } else

                 sifraKorisnik.setText(null);
              Toast.makeText(LogInActivity.this, "Неуспешно најавување. Грешна патрола или кориснички код", Toast.LENGTH_SHORT).show();

            }
        });





    }
}
