package com.example.fbm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText txtEmail;
    private FirebaseAuth mAuth;
    private Button Login;
    private EditText email;
    private EditText password;

    // private DatabaseReference mDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        txtEmail = findViewById(R.id.txt_email);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //   btnLogin.setText(txtEmail.getText());
                // Toast.makeText(getApplicationContext(),txtEmail.getText(),Toast.LENGTH_LONG).setDuration();
                LoginFun(txtEmail.getText().toString().trim(), password.getText().toString().trim());
            }
        });
    }


    public void LoginFun(final String email, final String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("Tag", "signInWithEmail:success");
                            Toast.makeText(getApplicationContext(), "Login successfully",
                                    Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("Tag", "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Login Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //    CreateAccountFun(email,password);
                        }

                        // ...
                    }
                });
    }
}
