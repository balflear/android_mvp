package com.mvp_example.login;

import android.util.Log;


/**
 * The presenter who will be the link between the model @{@link ILoginModel} and
 * the view @{@link ILoginView}
 */
public class LoginPresenterImpl implements ILoginPresenter {
    private ILoginView view;
    private ILoginModel model;

    LoginPresenterImpl(ILoginView view) {
        this.view = view;
        model = new LoginModelImpl(this);
    }

    @Override
    public void requestDoLogin(String username, String password) {
        model.doLogin(username, password);
    }

    @Override
    public void onDestroy() {
        model.onDestroy();
    }

    @Override
    public void onDataReceived(Object object) {
        Log.e("App", "in onDataReceived");
        view.onSuccess();
    }

    @Override
    public void onErrorReceived(String msg) {
        Log.e("App", "in onErrorReceived");
        view.onError();
    }
}
