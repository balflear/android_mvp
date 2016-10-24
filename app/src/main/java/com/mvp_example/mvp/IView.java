package com.mvp_example.mvp;


/**
 * "Super" interface for all Views, <br>
 * here we can define our common methods for our views
 */
public interface IView {
    void onSuccess();

    void onError();
}
