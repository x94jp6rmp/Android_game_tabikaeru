package tw.edu.ntut.csie.game.state;
import android.util.Log;

import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Model;
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

public class StateGiftI extends AbstractGameState{
    public static final int DEFAULT_SCORE_DIGITS = 3;
    private BitmapButton _gift,_door;
    private int mx,my;
    private int x,y;
    private int insidePointX,insidePointY;


    public StateGiftI(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        Log.e("test", "stateinside");

        _gift = new BitmapButton(R.drawable.gift);
        _gift.setLocation(0,0);



    }



    @Override
    public void move() {

    }
    @Override
    public void show() {
        _gift.show();
    }

    @Override
    public void release() {
        _gift.release();

        _gift=null;
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

