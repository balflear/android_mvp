package com.mvp_example.login;

import com.mvp_example.mvp.IModel;

/**
 * MVP -> Model
 */
public interface ILoginModel extends IModel {
    void doLogin(String username, String password);
}
