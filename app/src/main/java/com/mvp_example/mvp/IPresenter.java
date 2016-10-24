package com.mvp_example.mvp;

/**
 * "Super" interface for all presenters, <br>
 * here we can define our common methods for our presenters
 */
public interface IPresenter {
    void onDestroy();

    void onDataReceived(Object object);;

    void onErrorReceived(String msg);
}
