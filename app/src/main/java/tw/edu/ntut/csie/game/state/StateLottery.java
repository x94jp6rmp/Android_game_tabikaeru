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

public class StateLottery extends AbstractGameState{
    public static final int DEFAULT_SCORE_DIGITS = 3;
    private MovingBitmap _lottery,_ticket,_white,_blue,_red,_yellow,_green;
    private int ticket=0,rand,money,all=0;
    private int mx,my;
    private int x,y;
    private int insidePointX,insidePointY;
    public  Integer _money;
    private String strmoney;


    public StateLottery(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        Log.e("test", "stateinside");

        _lottery = new MovingBitmap(R.drawable.lottery);
        _lottery.setLocation(0,0);

        _ticket = new MovingBitmap(R.drawable.ticket);
        _ticket.setLocation(0,0);

        _white = new MovingBitmap(R.drawable.white);
        _white.setLocation(0,0);
        _blue = new MovingBitmap(R.drawable.blue);
        _blue.setLocation(0,0);
        _red = new MovingBitmap(R.drawable.red);
        _red.setLocation(0,0);
        _yellow = new MovingBitmap(R.drawable.yellow);
        _yellow.setLocation(0,0);

        _green = new MovingBitmap(R.drawable.green);
        _green.setLocation(0,0);

        strmoney=Model.getInstance().getMoney();
        switch (money = java.lang.Integer.parseInt(strmoney)) {}
        _money = new Integer(DEFAULT_SCORE_DIGITS, money, 30, 120);

    }



    @Override
    public void move() {

    }
    @Override
    public void show() {
        _lottery.show();
        _money.show();

        if(ticket==1) {
            _ticket.show();
            _ticket.setVisible(true);
        }
        if(ticket==0) {
            _ticket.setVisible(false);
        }
        if (rand ==1){
            _white.show();
            _white.setVisible(true);
        }
        else if (rand ==2) {
            _red.show();
            _red.setVisible(true);
        }
        else if (rand ==3) {
            _blue.show();
            _blue.setVisible(true);
        }
        else if (rand ==4) {
            _green.show();
            _green.setVisible(true);
        }
        else if (rand ==5){
            _yellow.show();
            _yellow.setVisible(true);
        }
        if(all==1){
            _white.setVisible(false);
            _red.setVisible(false);
            _blue.setVisible(false);
            _yellow.setVisible(false);
            _green.setVisible(false);
        }

    }

    @Override
    public void release() {
        _lottery.release();
        _ticket.release();
        _blue.release();
        _green.release();
        _red.release();
        _yellow.release();
        _white.release();

        _lottery=null;
        _ticket=null;
        _blue=null;
        _green=null;
        _red=null;
        _yellow=null;
        _white=null;
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
        //回商店鈕
        if((insidePointX>=11 &&insidePointX<=55) &&(insidePointY>=12&&insidePointY<=51)){
            changeState(Game.SHOP_STATE);
        }
        //抽獎鈕
        if((insidePointX>=526 &&insidePointX<=572) &&(insidePointY>=227&&insidePointY<=327)) {
            rand = (int) (Math.random() * 4 + 1);
            if (rand == 1) {
                _money.add(-1);
                money = money - 1;
                Model.getInstance().setMoney(String.valueOf(money));
                all=3;
            } else if (rand == 2) {
                _money.add(10);
                money = money + 10;
                Model.getInstance().setMoney(String.valueOf(money));
                all=3;
            } else if (rand == 3) {
                _money.add(3);
                money = money + 3;
                Model.getInstance().setMoney(String.valueOf(money));
                all=3;
            } else if (rand == 4) {
                _money.add(5);
                money = money + 5;
                Model.getInstance().setMoney(String.valueOf(money));
                all=3;
            } else if (rand == 5) {
                _money.add(20);
                money = money + 20;
                Model.getInstance().setMoney(String.valueOf(money));
                all=3;
            }
            _money.add(-5);
            money = money - 5;
            Model.getInstance().setMoney(String.valueOf(money));
        }
        else if(all==3){
            if((insidePointX>=5 &&insidePointX<=640) &&(insidePointY>=4&&insidePointY<=376)){
                all=1;
            }
        }


        //獎項說明鈕
        if((insidePointX>=506 &&insidePointX<=543) &&(insidePointY>=59&&insidePointY<=151)){
            ticket=1;
        }
        else if(ticket==1){
            if ((insidePointX>=116 &&insidePointX<=135) &&(insidePointY>=20&&insidePointY<=45)) {
                ticket = 0;
                Log.e("located","ticket");
            }
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
        Model.getInstance().initialize();
        return true;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }


}

