package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private UserAdapter adapter;
    private User user;
    private UserViewModel viewModel;
    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.viewModel = new ViewModelProvider(this).get(UserViewModel.class);

         editTextEmail = findViewById(R.id.editTextEmail);
         editTextPassword = findViewById(R.id.editTextPassword);

        this.adapter = new UserAdapter(this);


    }

    public void createAccount(View view){
        Intent intent = new Intent(this, RegisterAccountActivity.class);
        startActivity(intent);
    }

    public void onClickLogin(View view){
        String email = this.editTextEmail.getText().toString();
        String password = this.editTextPassword.getText().toString();

            if (email.isEmpty()) {
                Toast.makeText(this, "o e-mail está vazio", Toast.LENGTH_SHORT).show();
                return;
            } else if (password.isEmpty()) {
                Toast.makeText(this, "a palavra-passe está vazia", Toast.LENGTH_SHORT).show();
                return;
            }if (this.viewModel.loginUser(this, email, password)) {
            Intent intent = new Intent(this, MonumentListActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "os dados da sua conta estão errados", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(this, MonumentListActivity.class);
        startActivity(intent);
    }
}