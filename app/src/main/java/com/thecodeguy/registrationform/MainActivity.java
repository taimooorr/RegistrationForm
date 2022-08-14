package com.thecodeguy.registrationform;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private EditText txtFirstName, txtLastName, txtPassword, txtConfirmPassword;
    private Button btnRegister, btnUpldImg;
    private RadioGroup rgGender;
    private Spinner spinner;
    private Checkable agree;
    private ConstraintLayout parent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        btnUpldImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "This Button is Not Functional Right Now", Toast.LENGTH_SHORT).show();
            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                initRegister();

            }
        });
    }
    public void initRegister() {
        Log.d(TAG, "initRegister: Initializing Register");
        if (validateData()) {
            if (agree.isChecked()) {
                showSnakBar();

            } else {
                Toast.makeText(this, "Please Agree to Terms and Conditions", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void showSnakBar() {
        Log.d(TAG, "showSnakBar: Started");
        Snackbar.make(parent, "Registration Successful", Snackbar.LENGTH_INDEFINITE).setAction("Dismis", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lets clear the fields
                txtFirstName.setText(null);
                txtLastName.setText(null);
                txtPassword.setText(null);
                txtConfirmPassword.setText(null);
                rgGender.clearCheck();
                spinner.setSelection(0);
                agree.setChecked(false);

            }
        }).show();
    }
    public boolean validateData(){
        Log.d(TAG, "validateData: validating the data entered");
        if(txtFirstName.getText().toString().isEmpty()){
            txtFirstName.setError("Please Enter Your First Name");
            return false;
        }
        if(txtLastName.getText().toString().isEmpty()){
            txtLastName.setError("Please Enter Your Last Name");
            return false;
        }
        if (txtPassword.getText().toString().isEmpty()){
            txtPassword.setError("Please Enter Your Password");
            return false;
        }
        if(txtConfirmPassword.getText().toString().isEmpty())  {
            txtConfirmPassword.setError("Please Confirm Your Password");
            return false;
        }
        if(!txtPassword.getText().toString().equals(txtConfirmPassword.getText().toString())){
            txtConfirmPassword.setError("Passwords Do Not Match");
            return false;
        }
        return true;

    }


    private void initViews() {
        Log.d(TAG, "initViews: started");
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtPassword = findViewById(R.id.txtPswd);
        txtConfirmPassword = findViewById(R.id.txtConfirmPswd);
        btnRegister = findViewById(R.id.register);
        btnUpldImg = findViewById(R.id.btnUpldImg);
        rgGender = findViewById(R.id.rbGender);
        spinner = findViewById(R.id.sltdCountry);
        agree = findViewById(R.id.agree);
        parent = findViewById(R.id.constID);

    }
}