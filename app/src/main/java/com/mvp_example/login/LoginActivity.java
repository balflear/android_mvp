package com.mvp_example.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mvp_example.R;
import com.mvp_example.home.HomeActivity;
import com.mvp_example.utils.Constants;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends AppCompatActivity implements ILoginView {
    @BindView(R.id.etUsername)
    EditText etUsername;

    @BindView(R.id.etPassword)
    EditText etPassword;

    @BindView(R.id.login_progress)
    View mProgressView;

    @BindView(R.id.btnLogin)
    Button loginBtn;

    // MVP - Presenter
    private ILoginPresenter presenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        // Initialize the MVP presenter
        presenter = new LoginPresenterImpl(this);

        loginBtn.setOnClickListener(click -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            showSpinner();
            presenter.requestDoLogin(username, password);
        });
    }

    @Override
    public void onSuccess() {
        stopSpinner();
        Toast.makeText(this, Constants.LOGIN_SUCCESS_MSG, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }

    @Override
    public void onError() {
        stopSpinner();
        Toast.makeText(this, Constants.LOGIN_ERROR_MSG, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showSpinner() {
        mProgressView.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopSpinner() {
        mProgressView.setVisibility(View.INVISIBLE);
    }
}