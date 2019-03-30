package com.example.anusirohi.constraintsdemologin.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.anusirohi.constraintsdemologin.R;
import com.example.anusirohi.constraintsdemologin.http.DataManager;
import com.example.anusirohi.constraintsdemologin.model.register.RegisterRequest;
import com.example.anusirohi.constraintsdemologin.model.register.RegisterResponse;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.edit_name) EditText editName;
    @BindView(R.id.edit_email_address) EditText editEmailAddress;
    @BindView(R.id.edit_contact) EditText editContact;
    @BindView(R.id.edit_password) EditText editPassword;
    @BindView(R.id.edit_confirm_password) EditText editConfirmPassword;
    @BindView(R.id.button_register) Button buttonRegister;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.button_register)
    void registerTapped() {

        String name = editName.getText().toString();
        String contact = editContact.getText().toString();
        String email = editEmailAddress.getText().toString();
        String password = editPassword.getText().toString();
        String confirmPassword = editConfirmPassword.getText().toString();

        register(name, contact, email, password, confirmPassword);
    }

    private void register(String name, String contact, String email, String password, String confirmPassword) {

        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setSiteType("1");
        if (!TextUtils.isEmpty(name)) registerRequest.setUserName(name);
        if (!TextUtils.isEmpty(contact)) registerRequest.setUserMobile(contact);
        if (!TextUtils.isEmpty(email)) registerRequest.setUserEmail(email);
        if (!TextUtils.isEmpty(password)) registerRequest.setUserPassword(password);
        if (!TextUtils.isEmpty(confirmPassword))
            registerRequest.setUserConfirmPassword(confirmPassword);
        DataManager.getInstance().register(this, registerRequest, new DataManager.DataManagerListener() {
            @Override
            public void onSuccess(Object response) {
//                ProgressHelper.stop();
                if (response == null) return;
                RegisterResponse registerResponse = (RegisterResponse) response;
                Toast.makeText(RegisterActivity.this, "aa gya.." + registerResponse.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Object response) {
//                ProgressHelper.stop();
//                ErrorManager errorManager = new ErrorManager(LoginActivity.this, relativeLayoutRoot, response);
//                errorManager.handleErrorResponse();
            }
        });
    }
}
