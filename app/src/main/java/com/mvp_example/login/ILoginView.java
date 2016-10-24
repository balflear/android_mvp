package com.mvp_example.login;

import com.mvp_example.mvp.IView;

/**
 * MVP -> View
 */
public interface ILoginView extends IView {
    void showSpinner();
    void stopSpinner();
}
