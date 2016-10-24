package com.mvp_example.login;

import com.mvp_example.mvp.IPresenter;

/**
 * MVP -> Presenter
 */
public interface ILoginPresenter extends IPresenter {
    void requestDoLogin(String username, String password);
}
