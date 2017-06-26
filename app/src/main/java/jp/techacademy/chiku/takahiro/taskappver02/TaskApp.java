package jp.techacademy.chiku.takahiro.taskappver02;

/**
 * Created by takahiro chiku on 2017/06/25.
 */

import android.app.Application;

import io.realm.Realm;

//アプリケーション立ち上げ時にRealmを初期化させる
public class TaskApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}