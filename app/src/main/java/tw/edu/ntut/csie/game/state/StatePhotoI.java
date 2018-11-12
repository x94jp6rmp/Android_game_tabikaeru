package tw.edu.ntut.csie.game.state;
import android.util.Log;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Model;
import tw.edu.ntut.csie.game.MyApp;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;

import android.util.Log;

import java.util.List;
import java.util.Map;


import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.PointerEventHandler;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.Animation;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;
import tw.edu.ntut.csie.game.extend.Integer;

public class StatePhotoI extends AbstractGameState{
    public static final int DEFAULT_SCORE_DIGITS = 3;
    private BitmapButton _photo;
    private int mx,my;
    private int x,y;
    private int insidePointX,insidePointY;


    public StatePhotoI(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        Log.e("test", "stateinside");

        _photo = new BitmapButton(R.drawable.photo);
        _photo.setLocation(0,0);



    }



    @Override
    public void move() {

    }
    @Override
    public void show() {

        _photo.show();

        MyApp.getBitmapList().get(1).show();
        MyApp.getBitmapList().get(1).setLocation(130, 200);
        MyApp.getBitmapList().get(2).show();
        MyApp.getBitmapList().get(2).setLocation(290, 200);
        MyApp.getBitmapList().get(3).show();
        MyApp.getBitmapList().get(3).setLocation(450, 200);
        MyApp.getBitmapList().get(4).show();
        MyApp.getBitmapList().get(4).setLocation(130, 30);
        MyApp.getBitmapList().get(5).show();
        MyApp.getBitmapList().get(5).setLocation(290, 30);
        MyApp.getBitmapList().get(6).show();
        MyApp.getBitmapList().get(6).setLocation(450, 30);




    }

    @Override
    public void release() {
        _photo.release();

        _photo=null;

    }

    @Override
    public void keyPressed(int keyCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(int keyCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public void orientationChanged(float pitch, float azimuth, float roll) {

    }

    @Override
    public void accelerationChanged(float dX, float dY, float dZ) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean pointerPressed(Pointer actionPointer, List<Pointer> pointers) {
        insidePointX=actionPointer.getX();
        insidePointY=actionPointer.getY();
        mx = actionPointer.getX();
        my = actionPointer.getY();
        Log.e("located", "x: "+mx+" y:"+my );
        x=actionPointer.getX();
        y=actionPointer.getY();
        if((insidePointX>=23 &&insidePointX<=62) &&(insidePointY>=314&&insidePointY<=353)){
            changeState(Game.INSIDE_STATE);
        }
        if((insidePointX>=588&&insidePointX<=623)&&(insidePointY>=264&&insidePointY<=303)){

            MyApp.getBitmapList().clear();
        }


        return true;


    }

    @Override
    public boolean pointerMoved(Pointer actionPointer, List<Pointer> pointers) {


        return true;

    }

    public void resizeAndroidIcon() {

    }

    @Override
    public boolean pointerReleased(Pointer actionPointer, List<Pointer> pointers) {

        return true;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


}


