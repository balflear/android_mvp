package com.mvp_example.login;

import android.os.Handler;


public class LoginModelImpl implements ILoginModel {
    private ILoginPresenter presenter;
    private Handler handler;
    private static final long DELAY = 2000;
    private static final String USERNAME = "demo";
    private static final String PASSWORD = "demo";


    LoginModelImpl(ILoginPresenter presenter) {
        this.presenter = presenter;
    }

    // Simulate login call
    @Override
    public void doLogin(String username, String password) {
        handler = new Handler();
        handler.postDelayed(() -> { // run
            if (username.equalsIgnoreCase(USERNAME) && password.equals(PASSWORD)) {
                presenter.onDataReceived(null);
            } else {
                presenter.onErrorReceived("Wrong username");
            }
        }, DELAY);
    }

    @Override
    public void onDestroy() {
        // Free resources here...
    }
}
