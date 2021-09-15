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
    private EditText editTextPasswordRegister;
    private EditText editTextPasswordConfirm;
    private EditText phone;
    private EditText email;
    private EditText username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);

        editTextPasswordConfirm = findViewById(R.id.editTextConfirmPasssword);
        editTextPasswordRegister = findViewById(R.id.editTextPassword);
        phone = findViewById(R.id.editTextPhoneNumber);
        email = findViewById(R.id.editTextEmail);
        username = findViewById(R.id.editTextUsername);

        this.viewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }

    public void onClickRegister(View view){

        username = findViewById(R.id.editTextUsername);
        email = findViewById(R.id.editTextEmail);
        phone = findViewById(R.id.editTextPhoneNumber);
        editTextPasswordRegister = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextConfirmPasssword);

        String username = this.username.getText().toString();
        String email = this.email.getText().toString();
        String phone = this.phone.getText().toString();
        String password = this.editTextPasswordRegister.getText().toString();
        String confirmPassword = this.editTextPasswordConfirm.getText().toString();

        if (username.isEmpty()){
            Toast.makeText(this, "o nome de utilizador não pode estar vazio", Toast.LENGTH_SHORT).show();
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
            viewModel.newUser(username, email, phone, password, this);
            viewModel.updateUsers(this);
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    public void OnClickToLogin(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        this.viewModel.updateUsers(this);
    }
}