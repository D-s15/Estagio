package com.example.bejamonuments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterAccountActivity extends AppCompatActivity {

    private User user;
    private UserViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        this.viewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    public void onClickRegister(View view){

        EditText editTextName = findViewById(R.id.editTextName);
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextPhone = findViewById(R.id.editTextPhoneNumber);
        EditText editTextPassword = findViewById(R.id.editTextPassword);
        EditText editTextConfirmPassword = findViewById(R.id.editTextConfirmPasssword);

        String name = editTextName.getText().toString();
        String email = editTextEmail.getText().toString();
        String phone = editTextPhone.getText().toString();
        String password = editTextPassword.getText().toString();
        String confirmPassword = editTextConfirmPassword.getText().toString();

        if (name.isEmpty()){
            Toast.makeText(this, "o nome não pode estar vazio", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (email.isEmpty()){
            Toast.makeText(this, "o e-mail não pode estar vazio", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (phone.isEmpty()){
            Toast.makeText(this, "o número de telemóvel não pode estar vazio", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (password.isEmpty()){
            Toast.makeText(this, "A palavra-passe não pode estar vazia", Toast.LENGTH_SHORT).show();
            return;
        }
        else if (confirmPassword.isEmpty()){
            Toast.makeText(this, "o campo 'confirmar palavra passe' tem de ser igual ao campo 'palavra-passe'", Toast.LENGTH_SHORT).show();
            return;
        }
        else{
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void OnClickToLogin(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}