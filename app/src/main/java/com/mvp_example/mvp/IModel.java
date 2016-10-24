package com.mvp_example.mvp;

/**
 * "Super" interface for the all models, <br>
 * here we can define our common methods for our models
 */
public interface IModel {
    void onDestroy(); // Release resources here
}
