package scu.edu.q2b;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText username;
    private EditText password;
    private Button login;

    private String un;
    private String pw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                un = username.getText().toString();
                pw = password.getText().toString();

                String a = MainActivity.this.getString(R.string.user_name);
                String b = MainActivity.this.getString(R.string.user_password);

                if (un.equals(a) && pw.equals(b)) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                    startActivity(intent);

                } else {
                    Toast.makeText(MainActivity.this, "username or password is incorrect", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}