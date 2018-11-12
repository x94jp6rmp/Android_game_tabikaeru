package tw.edu.ntut.csie.game;

import android.app.Application;
import android.content.SharedPreferences;
import android.graphics.Bitmap;

import java.util.ArrayList;

import tw.edu.ntut.csie.game.core.MovingBitmap;

public class MyApp extends Application {

    private static MyApp singleton;
    private static ArrayList<MovingBitmap> bitmapList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();
        singleton = this;
        Model.getInstance().initialize();
    }

    public static void write(String name, String value){
        SharedPreferences pref = singleton.getSharedPreferences("test", MODE_PRIVATE);
        pref.edit()
            .putString(name, value)
            .commit();
    }
    public static String read(String name){
        SharedPreferences pref = singleton.getSharedPreferences("test", MODE_PRIVATE);
        return pref.getString(name, "0");
    }
    public static void clean(String name){
        SharedPreferences pref = singleton.getSharedPreferences("test", MODE_PRIVATE);
        pref.edit().clear().commit();
    }

    public static ArrayList<MovingBitmap> getBitmapList() {
        return bitmapList;
    }
}
