package scu.edu.q2b;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SecondActivity extends AppCompatActivity {

    private EditText scu_id;


    private Button confirm;
    private Button cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        scu_id = findViewById(R.id.scu_id);
        confirm = findViewById(R.id.enroll);
        cancel = findViewById(R.id.logout);

        confirm.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String id = scu_id.getText().toString();
                SharedPreferences sharedPreferences= getSharedPreferences("data",Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                String user =sharedPreferences.getString("id","");
                if (user.equals("") || !user.equals(id)) {
                    Toast.makeText(SecondActivity.this, "enrolling in" + id, Toast.LENGTH_SHORT).show();
                    editor.putString("id", id);
                    editor.commit();
                } else {
                    Toast.makeText(SecondActivity.this, "scu id duplicate" + id, Toast.LENGTH_SHORT).show();
                }


            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipClick(view);
            }
        });

    }

    public void tipClick(View view) {
        Context context = SecondActivity.this.getApplicationContext();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Are your sure:");
        builder.setMessage("Click yes to logout");
        builder.setIcon(R.mipmap.ic_launcher_round);

        builder.setCancelable(true);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startService(intent);
            }
        });

        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });


        AlertDialog dialog = builder.create();

        dialog.show();
    }



}