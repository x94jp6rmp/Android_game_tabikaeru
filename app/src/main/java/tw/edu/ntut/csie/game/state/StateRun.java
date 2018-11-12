package tw.edu.ntut.csie.game.state;

import android.graphics.Bitmap;
import android.util.Log;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Model;
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


public class StateRun extends AbstractGameState  {
    public static final int DEFAULT_SCORE_DIGITS = 3;
    public  Integer _money;
    private MovingBitmap _background,_question;
    private BitmapButton _homeButton;
    private BitmapButton _buyButton;
    private BitmapButton _menuButton;
    private BitmapButton _sroce;
    private BitmapButton _baglist;
    private BitmapButton _bag80;
    private int x,y,beeshow=0,bee=0,rand;
    private boolean _grab;
    private int _bx,_by=0,_my,_ly,_ly1,_ly3,_ly4,_ly5,_ly6,_ly7,_ly8,_ly9,_ly11,_ly12,_ly13,_ly14,_ly15,_ly16,_ly17,_ly18,_ly19;
    private int ay;
    private int distance=0,money;
    private int top=0,topbutton=0,toprightinfo=0,door=0,top_door=0,bag=0,top_bag=0;
    private Audio _music;
    private int mx,my;
    private MovingBitmap _topbutton,_collect;
    public StateRun(GameEngine engine) {
        super(engine);
    }
    private int insidePointX,insidePointY;
    private String strmoney;
    private MovingBitmap score;
    private int number=0;
    private Animation _bee;
    private Animation _lucky,_lucky1,_lucky3,_lucky4,_lucky5,_lucky6,_lucky7,_lucky8,_lucky9,_lucky11,_lucky12,_lucky13,_lucky14,_lucky15,_lucky16,_lucky17,_lucky18,_lucky19;
    private int luckymove=0,lucky1move=0,lucky3move=0,lucky4move=0,lucky5move=0,lucky6move=0,lucky7move=0,lucky8move=0,lucky9move=0,lucky11move=0,lucky12move=0,lucky13move=0,lucky14move=0,lucky15move=0,lucky16move=0,lucky17move=0,lucky18move=0,lucky19move=0;
    @Override
    public void initialize(Map<String, Object> data) {


        _background = new MovingBitmap(R.drawable.background);
        _bx=0;
        _by=0;

        _background.setLocation(_bx,_by);
        //_scores = new Integer(DEFAULT_SCORE_DIGITS, 50, 550, 10);
        _music = new Audio(R.raw.ntut);
        _music.setRepeating(true);
        _music.play();
        _grab = false;

        _menuButton=new BitmapButton(R.drawable.menubutton,5,3);
        _buyButton=new BitmapButton(R.drawable.buybutton,525,3);
        _homeButton=new BitmapButton(R.drawable.homebutton,580,3);

        _topbutton = new MovingBitmap(R.drawable.topbutton);
        _topbutton.setLocation(4,-2);

        _question = new MovingBitmap(R.drawable.question);
        _question.setLocation(0,0);

        _collect = new MovingBitmap(R.drawable.collect);
        _collect.setLocation(0,0);

        _sroce = new BitmapButton(R.drawable.sroce);
        _sroce.setLocation(0,0);
        luckymove=0;
        _lucky = new Animation();
        _ly=300;
        _lucky.setLocation(340,_ly);
        _lucky.addFrame(R.drawable.lucky);
        _lucky.addFrame(R.drawable.lucky_alpha70);
        _lucky.addFrame(R.drawable.lucky_alpha30);
        _lucky.addFrame(R.drawable.lucky_alpha10);
        _lucky.setDelay(1);
        _lucky.setRepeating(false);
        lucky1move=0;
        _lucky1 = new Animation();
        _ly1=270;
        _lucky1.setLocation(300,_ly1);
        _lucky1.addFrame(R.drawable.lucky1);
        _lucky1.addFrame(R.drawable.lucky1_alpha70);
        _lucky1.addFrame(R.drawable.lucky1_alpha30);
        _lucky1.addFrame(R.drawable.lucky1_alpha10);
        _lucky1.setDelay(1);
        _lucky1.setRepeating(false);
        lucky3move=0;
        _lucky3 = new Animation();
        _ly3=320;
        _lucky3.setLocation(310,_ly3);
        _lucky3.addFrame(R.drawable.lucky3);
        _lucky3.addFrame(R.drawable.lucky3_alpha70);
        _lucky3.addFrame(R.drawable.lucky3_alpha30);
        _lucky3.addFrame(R.drawable.lucky3_alpha10);
        _lucky3.setDelay(1);
        _lucky3.setRepeating(false);
        lucky4move=0;
        _lucky4 = new Animation();
        _ly4=340;
        _lucky4.setLocation(330,_ly4);
        _lucky4.addFrame(R.drawable.lucky4);
        _lucky4.addFrame(R.drawable.lucky4_alpha70);
        _lucky4.addFrame(R.drawable.lucky4_alpha30);
        _lucky4.addFrame(R.drawable.lucky4_alpha10);
        _lucky4.setDelay(1);
        _lucky4.setRepeating(false);
        lucky5move=0;
        _lucky5 = new Animation();
        _ly5=360;
        _lucky5.setLocation(320,_ly5);
        _lucky5.addFrame(R.drawable.lucky5);
        _lucky5.addFrame(R.drawable.lucky5_alpha70);
        _lucky5.addFrame(R.drawable.lucky5_alpha30);
        _lucky5.addFrame(R.drawable.lucky5_alpha10);
        _lucky5.setDelay(1);
        _lucky5.setRepeating(false);
        lucky6move=0;
        _lucky6 = new Animation();
        _ly6=380;
        _lucky6.setLocation(290,_ly6);
        _lucky6.addFrame(R.drawable.lucky6);
        _lucky6.addFrame(R.drawable.lucky6_alpha70);
        _lucky6.addFrame(R.drawable.lucky6_alpha30);
        _lucky6.addFrame(R.drawable.lucky6_alpha10);
        _lucky6.setDelay(1);
        _lucky6.setRepeating(false);
        lucky7move=0;
        _lucky7 = new Animation();
        _ly7=400;
        _lucky7.setLocation(310,_ly7);
        _lucky7.addFrame(R.drawable.lucky7);
        _lucky7.addFrame(R.drawable.lucky7_alpha70);
        _lucky7.addFrame(R.drawable.lucky7_alpha30);
        _lucky7.addFrame(R.drawable.lucky7_alpha10);
        _lucky7.setDelay(1);
        _lucky7.setRepeating(false);
        lucky8move=0;
        _lucky8 = new Animation();
        _ly8=390;
        _lucky8.setLocation(340,_ly8);
        _lucky8.addFrame(R.drawable.lucky8);
        _lucky8.addFrame(R.drawable.lucky8_alpha70);
        _lucky8.addFrame(R.drawable.lucky8_alpha30);
        _lucky8.addFrame(R.drawable.lucky8_alpha10);
        _lucky8.setDelay(1);
        _lucky8.setRepeating(false);
        lucky9move=0;
        _lucky9 = new Animation();
        _ly9=420;
        _lucky9.setLocation(330,_ly9);
        _lucky9.addFrame(R.drawable.lucky9);
        _lucky9.addFrame(R.drawable.lucky9_alpha70);
        _lucky9.addFrame(R.drawable.lucky9_alpha30);
        _lucky9.addFrame(R.drawable.lucky9_alpha10);
        _lucky9.setDelay(1);
        _lucky9.setRepeating(false);
        lucky11move=0;
        _lucky11 = new Animation();
        _ly11=370;
        _lucky11.setLocation(360,_ly11);
        _lucky11.addFrame(R.drawable.lucky11);
        _lucky11.addFrame(R.drawable.lucky11_alpha70);
        _lucky11.addFrame(R.drawable.lucky11_alpha30);
        _lucky11.addFrame(R.drawable.lucky11_alpha10);
        _lucky11.setDelay(1);
        _lucky11.setRepeating(false);
        lucky12move=0;
        _lucky12 = new Animation();
        _ly12=280;
        _lucky12.setLocation(320,_ly12);
        _lucky12.addFrame(R.drawable.lucky12);
        _lucky12.addFrame(R.drawable.lucky12_alpha70);
        _lucky12.addFrame(R.drawable.lucky12_alpha30);
        _lucky12.addFrame(R.drawable.lucky12_alpha10);
        _lucky12.setDelay(1);
        _lucky12.setRepeating(false);
        lucky13move=0;
        _lucky13 = new Animation();
        _ly13=450;
        _lucky13.setLocation(300,_ly13);
        _lucky13.addFrame(R.drawable.lucky13);
        _lucky13.addFrame(R.drawable.lucky13_alpha70);
        _lucky13.addFrame(R.drawable.lucky13_alpha30);
        _lucky13.addFrame(R.drawable.lucky13_alpha10);
        _lucky13.setDelay(1);
        _lucky13.setRepeating(false);
        lucky14move=0;
        _lucky14 = new Animation();
        _ly14=480;
        _lucky14.setLocation(310,_ly14);
        _lucky14.addFrame(R.drawable.lucky14);
        _lucky14.addFrame(R.drawable.lucky14_alpha70);
        _lucky14.addFrame(R.drawable.lucky14_alpha30);
        _lucky14.addFrame(R.drawable.lucky14_alpha10);
        _lucky14.setDelay(1);
        _lucky14.setRepeating(false);
        lucky15move=0;
        _lucky15 = new Animation();
        _ly15=430;
        _lucky15.setLocation(350,_ly15);
        _lucky15.addFrame(R.drawable.lucky15);
        _lucky15.addFrame(R.drawable.lucky15_alpha70);
        _lucky15.addFrame(R.drawable.lucky15_alpha30);
        _lucky15.addFrame(R.drawable.lucky15_alpha10);
        _lucky15.setDelay(1);
        _lucky15.setRepeating(false);
        lucky16move=0;
        _lucky16 = new Animation();
        _ly16=410;
        _lucky16.setLocation(290,_ly16);
        _lucky16.addFrame(R.drawable.lucky16);
        _lucky16.addFrame(R.drawable.lucky16_alpha70);
        _lucky16.addFrame(R.drawable.lucky16_alpha30);
        _lucky16.addFrame(R.drawable.lucky16_alpha10);
        _lucky16.setDelay(1);
        _lucky16.setRepeating(false);
        lucky17move=0;
        _lucky17 = new Animation();
        _ly17=500;
        _lucky17.setLocation(340,_ly17);
        _lucky17.addFrame(R.drawable.lucky17);
        _lucky17.addFrame(R.drawable.lucky17_alpha70);
        _lucky17.addFrame(R.drawable.lucky17_alpha30);
        _lucky17.addFrame(R.drawable.lucky17_alpha10);
        _lucky17.setDelay(1);
        _lucky17.setRepeating(false);
        lucky18move=0;
        _lucky18 = new Animation();
        _ly18=320;
        _lucky18.setLocation(350,_ly18);
        _lucky18.addFrame(R.drawable.lucky18);
        _lucky18.addFrame(R.drawable.lucky18_alpha70);
        _lucky18.addFrame(R.drawable.lucky18_alpha30);
        _lucky18.addFrame(R.drawable.lucky18_alpha10);
        _lucky18.setDelay(1);
        _lucky18.setRepeating(false);
        lucky19move=0;
        _lucky19 = new Animation();
        _ly19=470;
        _lucky19.setLocation(360,_ly19);
        _lucky19.addFrame(R.drawable.lucky19);
        _lucky19.addFrame(R.drawable.lucky19_alpha70);
        _lucky19.addFrame(R.drawable.lucky19_alpha30);
        _lucky19.addFrame(R.drawable.lucky19_alpha10);
        _lucky19.setDelay(1);
        _lucky19.setRepeating(false);
        strmoney=Model.getInstance().getMoney();
        switch (money = java.lang.Integer.parseInt(strmoney)) {}
        _money = new Integer(DEFAULT_SCORE_DIGITS, money, 15, 270);

        score = new MovingBitmap(R.drawable.sroce);

        _bag80 = new BitmapButton(R.drawable.bag80);
        _bag80.setLocation(200,50);

        _baglist = new BitmapButton(R.drawable.baglist);
        _baglist.setLocation(0,0);

        _bee = new Animation();
        _bee.setLocation(0, 0);
        _bee.addFrame(R.drawable.bee);
        _bee.addFrame(R.drawable.bee1);
        _bee.addFrame(R.drawable.bee2);
        _bee.addFrame(R.drawable.bee);
        _bee.setDelay(2);


    }

    @Override
    public void move() {
        if(luckymove==1)_lucky.move();
        if(lucky1move==1)_lucky1.move();
        if(lucky3move==1)_lucky3.move();
        if(lucky4move==1)_lucky4.move();
        if(lucky5move==1)_lucky5.move();
        if(lucky6move==1)_lucky6.move();
        if(lucky7move==1)_lucky7.move();
        if(lucky8move==1)_lucky8.move();
        if(lucky9move==1)_lucky9.move();
        if(lucky11move==1)_lucky11.move();
        if(lucky12move==1)_lucky12.move();
        if(lucky13move==1)_lucky13.move();
        if(lucky14move==1)_lucky14.move();
        if(lucky15move==1)_lucky15.move();
        if(lucky16move==1)_lucky16.move();
        if(lucky17move==1)_lucky17.move();
        if(lucky18move==1)_lucky18.move();
        if(lucky19move==1)_lucky19.move();
        _bee.move();

    }
    @Override
    public void show() {
        // �I�s���Ǭ��K�϶���
        _background.show();
        _buyButton.show();
        _homeButton.show();
        _menuButton.show();
        _lucky.show();
        _lucky1.show();
        _lucky3.show();
        _lucky4.show();
        _lucky5.show();
        _lucky6.show();
        _lucky7.show();
        _lucky8.show();
        _lucky9.show();
        _lucky11.show();
        _lucky12.show();
        _lucky13.show();
        _lucky14.show();
        _lucky15.show();
        _lucky16.show();
        _lucky17.show();
        _lucky18.show();
        _lucky19.show();
        _sroce.show();

        //_bag80.show();

        //顯示右上角3個按鈕
        if(top==11){
            _topbutton.show();
        }
        //Log.e("state", "show: " + top);
        //右上角？按紐內容顯示
        if(topbutton==11){
            _question.show();
            _question.setVisible(true);
        }
        if(topbutton==0){
            _question.setVisible(false);
        }
        //右二按鈕
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
        _money.show();


        if(beeshow==0){
            _bee.show();
            _bee.setVisible(true);
        }
        else _bee.setVisible(false);



    }

    @Override
    public void release() {
        _background.release();
        _music.release();
        _buyButton.release();
        _homeButton.release();
        _menuButton.release();
        _topbutton.release();
        _question.release();
        _collect.release();
        _lucky.release();
        _lucky1.release();
        _lucky3.release();
        _lucky4.release();
        _lucky5.release();
        _lucky6.release();
        _lucky7.release();
        _lucky8.release();
        _lucky9.release();
        _lucky11.release();
        _lucky12.release();
        _lucky13.release();
        _lucky14.release();
        _lucky15.release();
        _lucky16.release();
        _lucky17.release();
        _lucky18.release();
        _lucky19.release();
        _money.release();
        _sroce.release();
        _bag80.release();
        _baglist.release();
        _bee.release();

        _background = null;
        _music = null;
        _buyButton=null;
        _homeButton=null;
        _menuButton=null;
        _topbutton=null;
        _question=null;
        _collect=null;
        _lucky=null;
        _lucky1=null;
        _lucky3=null;
        _lucky4=null;
        _lucky5=null;
        _lucky6=null;
        _lucky7=null;
        _lucky8=null;
        _lucky9=null;
        _lucky11=null;
        _lucky12=null;
        _lucky13=null;
        _lucky14=null;
        _lucky15=null;
        _lucky16=null;
        _lucky17=null;
        _lucky18=null;
        _lucky19=null;
        _money = null;
        _sroce=null;
        _bag80=null;
        _baglist=null;
        _bee=null;

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
        ay=actionPointer.getY();
        x=actionPointer.getX();
        y=actionPointer.getY();
        insidePointX=actionPointer.getX();
        insidePointY=actionPointer.getY();
        if((x>=385 &&x<=505) &&(y>=167&&y<=376)){//幸運草

        }
        if((x>=527 &&x<=574) &&(y>=8&&y<=53)){
            changeState(Game.SHOP_STATE);
        }
        if((x>=585 &&x<=629) &&(y>=8&&y<=48)){
            changeState(Game.INSIDE_STATE);
        }
        if((x>=284 &&x<=325) &&(y>=34&&y<=88)){
            changeState(Game.INSIDE_STATE);
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
                changeState(Game.GIFT_STATE);
                Log.e("located","gift");
            }
            else if((insidePointX>= 310 && insidePointX<= 386) && (insidePointY>= 94 && insidePointY<= 179)){
                changeState(Game.PHOTO_STATE);
                Log.e("located","photo");
            }
        }


        mx = actionPointer.getX();
        my =actionPointer.getY();
        Log.e("located", "x: "+mx+" y:"+my );


        return true;


    }

    @Override
    public boolean pointerMoved(Pointer actionPointer, List<Pointer> pointers) {
        distance =(actionPointer.getY()-ay);
            if(distance>0 && _by<0) {
                if(distance>60)distance=30;
               _by=_by+distance/5;
                _background.setLocation(0, _by );
            }
            else if(distance<0 && _by>-175){
                if(distance<-40)distance=-40;
                _by=_by+distance/5;
                _background.setLocation(0, _by );
            }


        //幸運草由左向右
        if(distance<0 && _by>-175){
            _ly=_ly+distance/5;
            _ly1=_ly1+distance/5;
            _ly3=_ly3+distance/5;
            _ly4=_ly4+distance/5;
            _ly5=_ly5+distance/5;
            _ly6=_ly6+distance/5;
            _ly7=_ly7+distance/5;
            _ly8=_ly8+distance/5;
            _ly9=_ly9+distance/5;
            _ly11=_ly11+distance/5;
            _ly12=_ly12+distance/5;
            _ly13=_ly13+distance/5;
            _ly14=_ly14+distance/5;
            _ly15=_ly15+distance/5;
            _ly16=_ly16+distance/5;
            _ly17=_ly17+distance/5;
            _ly18=_ly18+distance/5;
            _ly19=_ly19+distance/5;
            bee=bee+distance/5;
            _lucky.setLocation(340,_ly);
            _lucky1.setLocation(300,_ly1);
            _lucky3.setLocation(310,_ly3);
            _lucky4.setLocation(330,_ly4);
            _lucky5.setLocation(320,_ly5);
            _lucky6.setLocation(290,_ly6);
            _lucky7.setLocation(310,_ly7);
            _lucky8.setLocation(340,_ly8);
            _lucky9.setLocation(330,_ly9);
            _lucky11.setLocation(360,_ly11);
            _lucky12.setLocation(320,_ly12);
            _lucky13.setLocation(300,_ly13);
            _lucky14.setLocation(310,_ly14);
            _lucky15.setLocation(350,_ly15);
            _lucky16.setLocation(290,_ly16);
            _lucky17.setLocation(340,_ly17);
            _lucky18.setLocation(350,_ly18);
            _lucky19.setLocation(360,_ly19);
            _bee.setLocation(0,bee);

        }
        //幸運草由右向左
        else if(distance>0 && _by<0){
            _ly=_ly+distance/5;
            _ly1=_ly1+distance/5;
            _ly3=_ly3+distance/5;
            _ly4=_ly4+distance/5;
            _ly5=_ly5+distance/5;
            _ly6=_ly6+distance/5;
            _ly7=_ly7+distance/5;
            _ly8=_ly8+distance/5;
            _ly9=_ly9+distance/5;
            _ly11=_ly11+distance/5;
            _ly12=_ly12+distance/5;
            _ly13=_ly13+distance/5;
            _ly14=_ly14+distance/5;
            _ly15=_ly15+distance/5;
            _ly16=_ly16+distance/5;
            _ly17=_ly17+distance/5;
            _ly18=_ly18+distance/5;
            _ly19=_ly19+distance/5;
            bee=bee+distance/5;
            _lucky.setLocation(340,_ly);
            _lucky1.setLocation(300,_ly1);
            _lucky3.setLocation(310,_ly3);
            _lucky4.setLocation(330,_ly4);
            _lucky5.setLocation(320,_ly5);
            _lucky6.setLocation(290,_ly6);
            _lucky7.setLocation(310,_ly7);
            _lucky8.setLocation(340,_ly8);
            _lucky9.setLocation(330,_ly9);
            _lucky11.setLocation(360,_ly11);
            _lucky12.setLocation(320,_ly12);
            _lucky13.setLocation(300,_ly13);
            _lucky14.setLocation(310,_ly14);
            _lucky15.setLocation(350,_ly15);
            _lucky16.setLocation(290,_ly16);
            _lucky17.setLocation(340,_ly17);
            _lucky18.setLocation(350,_ly18);
            _lucky19.setLocation(360,_ly19);
            _bee.setLocation(0,bee);
        }

            if ((actionPointer.getX() >= 400 && actionPointer.getX() <= 420) && (actionPointer.getY() >= _ly16 && actionPointer.getY() <= _ly16 + 20)) {
            lucky16move = 1;
            _money.add(1);
            money = money + 1;
            Model.getInstance().setMoney(String.valueOf(money));
            Log.e("located", "16");
            } else if ((actionPointer.getX() >= 450 && actionPointer.getX() <= 470) && (actionPointer.getY() >= _ly && actionPointer.getY() <= _ly + 20)) {
                luckymove = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "0");
            } else if ((actionPointer.getX() >= 410 && actionPointer.getX() <= 430) && (actionPointer.getY() >= _ly1 && actionPointer.getY() <= _ly1 + 20)) {
                lucky1move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "1");
            } else if ((actionPointer.getX() >= 420 && actionPointer.getX() <= 440) && (actionPointer.getY() >= _ly3 && actionPointer.getY() <= _ly3 + 20)) {
                lucky3move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "3");
            } else if ((actionPointer.getX() >= 440 && actionPointer.getX() <= 460) && (actionPointer.getY() >= _ly4 && actionPointer.getY() <= _ly4 + 20)) {
                lucky4move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "4");
            } else if ((actionPointer.getX() >= 430 && actionPointer.getX() <= 450) && (actionPointer.getY() >= _ly5 && actionPointer.getY() <= _ly5 + 20)) {
                lucky5move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "5");
            } else if ((actionPointer.getX() >= 400 && actionPointer.getX() <= 420) && (actionPointer.getY() >= _ly6 && actionPointer.getY() <= _ly6 + 20)) {
                lucky6move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "6");
            } else if ((actionPointer.getX() >= 420 && actionPointer.getX() <= 440) && (actionPointer.getY() >= _ly7 && actionPointer.getY() <= _ly7 + 20)) {
                lucky7move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "7");
            } else if ((actionPointer.getX() >= 450 && actionPointer.getX() <= 470) && (actionPointer.getY() >= _ly8 && actionPointer.getY() <= _ly8 + 20)) {
                lucky8move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "8");
            } else if ((actionPointer.getX() >= 420 && actionPointer.getX() <= 460) && (actionPointer.getY() >= _ly9 && actionPointer.getY() <= _ly9 + 20)) {
                lucky9move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "9");
            }
            else if ((actionPointer.getX() >= 470 && actionPointer.getX() <= 490) && (actionPointer.getY() >= _ly11 && actionPointer.getY() <= _ly11 + 20)) {
                lucky11move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "11");
            } else if ((actionPointer.getX() >= 430 && actionPointer.getX() <= 450) && (actionPointer.getY() >= _ly12 && actionPointer.getY() <= _ly12 + 20)) {
                lucky12move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "12");
            } else if ((actionPointer.getX() >= 410 && actionPointer.getX() <= 430) && (actionPointer.getY() >= _ly13 && actionPointer.getY() <= _ly13 + 20)) {
                lucky13move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "13");
            } else if ((actionPointer.getX() >= 420 && actionPointer.getX() <= 440) && (actionPointer.getY() >= _ly14 && actionPointer.getY() <= _ly14 + 20)) {
                lucky14move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "14");
            } else if ((actionPointer.getX() >= 460 && actionPointer.getX() <= 480) && (actionPointer.getY() >= _ly15 && actionPointer.getY() <= _ly15 + 20)) {
                lucky15move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "15");
            }  else if ((actionPointer.getX() >= 450 && actionPointer.getX() <= 470) && (actionPointer.getY() >= _ly17 && actionPointer.getY() <= _ly17 + 20)) {
                lucky17move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "17");
            } else if ((actionPointer.getX() >= 460 && actionPointer.getX() <= 480) && (actionPointer.getY() >= _ly18 && actionPointer.getY() <= _ly18 + 20)) {
                lucky18move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "18");
            } else if ((actionPointer.getX() >= 470 && actionPointer.getX() <= 490) && (actionPointer.getY() >= _ly19 && actionPointer.getY() <= _ly19 + 20)) {
                lucky19move = 1;
                _money.add(1);
                money = money + 1;
                Model.getInstance().setMoney(String.valueOf(money));
                Log.e("located", "19");
            }
            if((insidePointX >= 352 &&insidePointX<= 406) && (insidePointY >= 114 && insidePointY <= 179)){
                beeshow=1;
                _money.add(20);
                money = money + 20;
                Model.getInstance().setMoney(String.valueOf(money));
            }


        return true;

    }

    public void resizeAndroidIcon() {

    }

    @Override
    public boolean pointerReleased(Pointer actionPointer, List<Pointer> pointers) {
        _grab = false;
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
        Model.getInstance().initialize();
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
