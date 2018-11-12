package tw.edu.ntut.csie.game.state;


import android.graphics.Bitmap;
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

public class StateInside extends AbstractGameState  {
    public static final int DEFAULT_SCORE_DIGITS = 3;
    private int distance=0;
    private int mx,my;
    private int point=0,top=0,toprightinfo=0,table=0,door=0,topbutton=0,doorinside=0,top_door=0,top_bag=0,bag=0,gift=0,photo=0;
    public static MovingBitmap photo1,photo2,photo3,photo4,photo5;
    private MovingBitmap photo1_s,photo2_s,photo3_s,photo4_s,photo5_s;
    private MovingBitmap _home;
    private int insidePointX,insidePointY;
    private int outorhome=0;//在家或出門
    private Animation _frogmake,_frogread,_frogwrite,_frogeat;
    private MovingBitmap _table;
    private MovingBitmap _topbutton,_question,_collect,gooutbtn,gohomebtn,bringphoto;
    private String strmoney;
    private Integer _money;
    private BitmapButton _baglist,_gift;
    private int money,rand,photonum=0;
    public static String _giftlast;
    private Audio _music;

    public StateInside(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        Log.e("test", "stateinside");

        _home = new MovingBitmap(R.drawable.home);
        _home.setLocation(0,0);



        _topbutton = new MovingBitmap(R.drawable.topbutton);
        _topbutton.setLocation(0,0);

        _question = new MovingBitmap(R.drawable.question);
        _question.setLocation(0,0);

        _collect = new MovingBitmap(R.drawable.collect);
        _collect.setLocation(0,0);

        _table=new MovingBitmap(R.drawable.table);
        _table.setLocation(0,0);


        _frogmake = new Animation();
        _frogmake.setLocation(344, 10);
        _frogmake.addFrame(R.drawable.frogmake1);
        _frogmake.addFrame(R.drawable.frogmake2);
        _frogmake.setDelay(2);

        _frogread = new Animation();
        _frogread.setLocation(0, 0);
        _frogread.addFrame(R.drawable.frogread1);
        _frogread.addFrame(R.drawable.frogread2);
        _frogread.addFrame(R.drawable.frogread3);
        _frogread.addFrame(R.drawable.frogread2);
        _frogread.setDelay(4);

        _frogwrite = new Animation();
        _frogwrite.setLocation(-2, 0);
        _frogwrite.addFrame(R.drawable.frogwrite1);
        _frogwrite.addFrame(R.drawable.frogwrite2);
        _frogwrite.addFrame(R.drawable.frogwrite3);
        _frogwrite.setDelay(4);

        _frogeat = new Animation();
        _frogeat.setLocation(-10, 0);
        _frogeat.addFrame(R.drawable.frogeat1);
        _frogeat.addFrame(R.drawable.frogeat2);
        _frogeat.addFrame(R.drawable.frogeat3);
        _frogeat.addFrame(R.drawable.frogeat4);
        _frogeat.addFrame(R.drawable.frogeat5);
        _frogeat.addFrame(R.drawable.frogeat4);
        _frogeat.addFrame(R.drawable.frogeat3);
        _frogeat.setDelay(4);

        gooutbtn =new MovingBitmap(R.drawable.gooutbutton);
        gooutbtn.setLocation(482,4);
        gohomebtn =new MovingBitmap(R.drawable.gohomebutton);
        gohomebtn.setLocation(482,4);

        _baglist = new BitmapButton(R.drawable.baglist);
        _baglist.setLocation(0,0);

        _gift = new BitmapButton(R.drawable.gift);
        _gift.setLocation(0,0);

        strmoney= Model.getInstance().getMoney();
        switch (money= java.lang.Integer.parseInt(strmoney)) {
        }
        Log.e("money:"+money,"moneyyyyy"+strmoney);
        _money = new Integer(DEFAULT_SCORE_DIGITS, money, 12, 270);
        rand=(int)(Math.random()*3+1);

        _giftlast=Model.getInstance().getGiftlast();
        bringphoto=new MovingBitmap(R.drawable.bringpphoto);
        bringphoto.setLocation(0,0);

        photo1=new MovingBitmap(R.drawable.photo1);
        photo2=new MovingBitmap(R.drawable.photo2);
        photo3=new MovingBitmap(R.drawable.photo3);
        photo4=new MovingBitmap(R.drawable.photo4);
        photo5=new MovingBitmap(R.drawable.photo5);
        photo1_s=new MovingBitmap(R.drawable.photo1_s2);
        photo1_s.setLocation(205,47);
        photo2_s=new MovingBitmap(R.drawable.photo2_s2);
        photo2_s.setLocation(205,47);

        photo3_s=new MovingBitmap(R.drawable.photo3_s2);
        photo4_s=new MovingBitmap(R.drawable.photo4_s2);
        photo5_s=new MovingBitmap(R.drawable.photo5_s2);
        photo3_s.setLocation(205,47);
        photo4_s.setLocation(205,47);
        photo5_s.setLocation(205,47);


    }



    @Override
    public void move() {
        _frogmake.move();
        _frogread.move();
        _frogwrite.move();
        _frogeat.move();
    }
    @Override
    public void show() {
        _home.show();
        if (rand ==1)_frogmake.show();
        else if (rand ==2)_frogread.show();
        else if (rand ==3) _frogwrite.show();
        else if (rand ==4) _frogeat.show();

        if(outorhome==0){
            gooutbtn.show();
        }
        else if(outorhome==1){
            gohomebtn.show();

        }
        if(photo==1){
            bringphoto.show();
            bringphoto.setVisible(true);
        }
        if(photonum==1){
            photo1_s.show();
            photo1_s.setVisible(true);
        }
        else if(photonum==2){
            photo2_s.show();
            photo2_s.setVisible(true);
        }
        else if(photonum==3){
            photo3_s.show();
            photo3_s.setVisible(true);
        }
        else if(photonum==4){
            photo4_s.show();
            photo4_s.setVisible(true);
        }
        else if(photonum==5){
            photo5_s.show();
            photo5_s.setVisible(true);
        }

        //顯示右上角3個按鈕
        if(top==11){
            _topbutton.show();
        }
        //Log.e("state", "show: " + top);

        //門的按鈕
        if(door==1) {
            _collect.show();
            _collect.setVisible(true);
        }
        if(door==0) {
            _collect.setVisible(false);
        }
        //右上左按鈕
        if(bag==1) {
            _baglist.show();
            _baglist.setVisible(true);
        }
        if(bag==0) {
            _baglist.setVisible(false);
        }
        //桌面
        if(table==1) {
            _table.show();
            _table.setVisible(true);
        }
        if(table==0) {
            _table.setVisible(false);
        }

        //右上角？按紐內容顯示
        if(topbutton==11){
            _question.show();
            _question.setVisible(true);
        }
        if(topbutton==0){
            _question.setVisible(false);
        }
        if(gift==1){
            _gift.show();
            _gift.setVisible(true);
        }
        if(gift==0){
            _gift.setVisible(false);
        }
        //右上左按鈕
        if(bag==1) {
            _baglist.show();
            _baglist.setVisible(true);
        }
        if(bag==0) {
            _baglist.setVisible(false);
        }
        _money.show();
    }

    @Override
    public void release() {
        _home.release();
        _frogmake.release();
        _table.release();
        _topbutton.release();
        _question.release();
        _collect.release();
        gooutbtn.release();
        gohomebtn.release();
        _money.release();
        _frogread.release();
        _frogwrite.release();
        _frogeat.release();
        _baglist.release();
        _gift.release();
        bringphoto.release();
        photo1_s.release();
        photo2_s.release();
        photo3_s.release();
        photo4_s.release();
        photo5_s.release();
        _home=null;
        _frogmake=null;
        _table=null;
        _topbutton=null;
        _question=null;
        _collect=null;
        gooutbtn=null;
        gohomebtn=null;
        _money=null;
        _frogread=null;
        _frogwrite=null;
        _frogeat=null;
        _baglist=null;
        _gift=null;
        bringphoto=null;
        photo1_s=null;
        photo2_s=null;
        photo3_s=null;
        photo4_s=null;
        photo5_s=null;


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
        if((insidePointX>=527 &&insidePointX<=574) &&(insidePointY>=8&&insidePointY<=53)){
            changeState(Game.SHOP_STATE);
        }
        else if((insidePointX>=585 &&insidePointX<=626) &&(insidePointY>=8&&insidePointY<=48)){
            changeState(Game.RUNNING_STATE);
        }
        //右上右邊按鈕
        else if((insidePointX>=7 &&insidePointX<=50) &&(insidePointY>=9&&insidePointY<=52)){
            if(top==11){
                topbutton=1;//裡面按鈕
            }
            top = 1;
            top_door=1;
            top_bag=1;
            Log.e("located","toplocated");
        }
        else if(topbutton==11) {//？按紐內容顯示(x.須知按鈕)

            if ((insidePointX >= 138 && insidePointX <= 158) && (insidePointY >= 45 && insidePointY <= 67)) {
                topbutton = 0;
            }
            else if ((insidePointX >= 203 && insidePointX <= 238) && (insidePointY >= 79 && insidePointY <= 303)) {
                toprightinfo = 1;
            }
            else if ((insidePointX >= 256 && insidePointX <= 288) && (insidePointY >= 79 && insidePointY <= 303)) {
                toprightinfo = 2;
            }
            else if ((insidePointX >= 309 && insidePointX <= 342) && (insidePointY >= 79 && insidePointY <= 303)) {
                toprightinfo = 3;
            }
            else if ((insidePointX >= 361 && insidePointX <= 391) && (insidePointY >= 79 && insidePointY <= 303)) {
                toprightinfo = 4;
            }
            else if ((insidePointX >= 414 && insidePointX <= 442) && (insidePointY >= 79 && insidePointY <= 303)) {
                toprightinfo = 5;
            }
            else if ((insidePointX >= 465 && insidePointX <= 496) && (insidePointY >= 79 && insidePointY <= 303)) {
                toprightinfo = 6;
            }
            Log.e("located","topinside");
        }
        //右上中間按鈕
        else if((insidePointX>=7 &&insidePointX<=50) &&(insidePointY>=68&&insidePointY<=107)&&(top_door==1)){
            door=1;
            Log.e("located","top_door");
        }
        //右上左間按鈕
        else if((insidePointX>=11 &&insidePointX<=53) &&(insidePointY>=122&&insidePointY<=164)&&(top_bag==1)){
            bag=1;
            Log.e("located","top_bag");
        }
        //右上x
        else if((top_door==1)||(top_bag==1)){
            if ((insidePointX >= 238 && insidePointX <= 258) && (insidePointY >= 69 && insidePointY <= 91)) {
                door = 0;//右上中間按鈕x
            }
            else if ((insidePointX >= 115 && insidePointX <= 132) && (insidePointY >= 41 && insidePointY <= 57)) {
                bag = 0;//右上左間按鈕x
            }
            else if((insidePointX>= 310 && insidePointX<= 386) && (insidePointY>= 206 && insidePointY<= 286)){
                changeState(Game.GIFT_STATE_INSIDE);
                Log.e("located","gift");
            }
            else if((insidePointX>= 310 && insidePointX<= 386) && (insidePointY>= 94 && insidePointY<= 179)){
                changeState(Game.PHOTO_STATE_INSIDE);
                Log.e("located","photo");
            }
        }
        //出去鈕
        if((insidePointX>=482 && insidePointX<=529)&&(insidePointY>=8&&insidePointY<=53)) {
            if (outorhome == 0) {
                _frogmake.setVisible(false);
                _frogread.setVisible(false);
                _frogwrite.setVisible(false);
                _frogeat.setVisible(false);
                outorhome=1;
                photo=1;
                int rand2=(int)(Math.random()*5+1);
                if(rand2==1){
                    photonum=1;
                    MyApp.getBitmapList().add(photo1);
                }
                else if(rand2==2){
                    photonum=2;
                    MyApp.getBitmapList().add(photo2);
                }
                else if(rand==3){
                    photonum=3;
                    MyApp.getBitmapList().add(photo3);
                }
                else if(rand2==4){
                    photonum=4;
                    MyApp.getBitmapList().add(photo4);
                }
                else if(rand2==5){
                    photonum=5;
                    MyApp.getBitmapList().add(photo5);
                }

                int theSize = MyApp.getBitmapList().size();
                Log.e("size", "pointerPressed: "+ theSize);
            }
            else if(outorhome==1){
                rand=(int)(Math.random()*4+1);
                if(rand==1){
                    _frogmake.setVisible(true);
                }
                else if(rand==2){
                    _frogread.setVisible(true);
                }
                else if(rand==3){
                    _frogwrite.setVisible(true);
                }
                else if(rand==4){
                    _frogeat.setVisible(true);
                }
                outorhome=0;

            }
        }
        if(photo==1) {
            if ((insidePointX >= 172 && insidePointX <= 188) && (insidePointY >= 31 && insidePointY <= 52)){
                bringphoto.setVisible(false);
                photo2_s.setVisible(false);
                photo1_s.setVisible(false);
                photo3_s.setVisible(false);
                photo4_s.setVisible(false);
                photo5_s.setVisible(false);

                photonum=0;
                photo=0;
            }
            if((insidePointY>=44&&insidePointY<=154)&&(insidePointX>=426&&insidePointX<=454)) {
                //MyApp.getBitmapList().remove(photo1);

                bringphoto.setVisible(false);
                photo=0;
                photo2_s.setVisible(false);
                photo1_s.setVisible(false);
                photo3_s.setVisible(false);
                photo4_s.setVisible(false);
                photo5_s.setVisible(false);
                photonum=0;
            }
        }



        //桌面顯示
        if((insidePointX>=590 &&insidePointX<=630) &&(insidePointY>=275&&insidePointY<=366)){
            Log.e("located","tablelocated");
            table = 1;
        }
        else if(table==1){
            if ((insidePointX>=157 &&insidePointX<=177) &&(insidePointY>=44&&insidePointY<=68)) {
                table = 0;
                Log.e("located","tableinside");
            }
        }
        //門的按鈕
        if((insidePointX>=278 &&insidePointX<=329) &&(insidePointY>=209&&insidePointY<=261)){
            Log.e("located","doorlocated");
            door = 1;
        }
        else if(door==1){
            if ((insidePointX >= 246 && insidePointX <= 258) && (insidePointY >= 68 && insidePointY <= 91)) {
                door = 0;
                Log.e("located","doorinside");
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
        distance=0;

        //按鈕按下去第一次
        if(top==1)top=11;
        if(topbutton==1) topbutton=11;
        if(toprightinfo==1)toprightinfo=11;
        else if(toprightinfo==2)toprightinfo=22;
        else if(toprightinfo==3)toprightinfo=33;
        else if(toprightinfo==4)toprightinfo=44;
        else if(toprightinfo==5)toprightinfo=55;
        else if(toprightinfo==6)toprightinfo=66;

        distance=0;
        return true;
    }

    @Override
    public void pause() {
        _music.pause();
    }

    @Override
    public void resume() {
        _music.resume();
    }


}


