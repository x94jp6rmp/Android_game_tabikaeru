package tw.edu.ntut.csie.game.state;

import android.util.Log;
import java.util.List;
import java.util.Map;


import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Model;
import tw.edu.ntut.csie.game.MyApp;
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

public class StateShop extends AbstractGameState  {

    public static final int DEFAULT_SCORE_DIGITS = 3;
    public  Integer _money;
    private Integer _intro10count,_intro20count,_intro50count,_intro80count,_intro100_1count,_intro100_2count,_intro150count,_intro3000count;
    private int count10=0,count20=0,count50=0,count80=0,count100_1,count100_2,count150,count3000;

    private  int pagestate;
    private  int state;
    private Audio _music;
    private int shopPointX,shopPointY;
    private int pictureMoveX,pictureMoveY=0;
    private  int shopOriginY;
    private int distance=0;
    private int mx,my;
    private  int buystate;
    private String strmoney,strcount10,strcount20,strcount50,strcount80;
    private MovingBitmap intro_10,intro_20,intro_50,intro_80,intro_100_1,intro_100_2,intro_150,intro_3000;
    private MovingBitmap _shopbackground,_shopfood;
    private  MovingBitmap pagebtnleft,pagebtnright;
    private MovingBitmap buyornot;
    public static int  money;



    public StateShop(GameEngine engine) {
        super(engine);
    }
    @Override
    public void initialize(Map<String, Object> data) {

       /*Model.getInstance().setMoney("500");
        Model.getInstance().setCount10("0");
        Model.getInstance().setCount20("0");
        Model.getInstance().setCount50("0");
        Model.getInstance().setCount80("0");*/

        distance=0;
        buystate=0;
        state=0;
        pictureMoveX=0;
        pictureMoveY=-406;
        pagestate=1;
        _shopbackground = new MovingBitmap(R.drawable.shopb);
        _shopbackground.setLocation(0,0);
        //食物大圖
        _shopfood = new MovingBitmap(R.drawable.shopfood);
        _shopfood.setLocation(pictureMoveX,pictureMoveY);
        //食物們的文字介紹
        intro_10 = new MovingBitmap(R.drawable.food);
        intro_10.setLocation(502,120);
        intro_20 =new MovingBitmap(R.drawable.intro_20);
        intro_20.setLocation(505,137);
        intro_50 =new MovingBitmap(R.drawable.intro_50);
        intro_50.setLocation(507,143);
        intro_80 =new MovingBitmap(R.drawable.intro_80);
        intro_80.setLocation(509,170);
        intro_100_1=new MovingBitmap(R.drawable.intro_100_1);
        intro_100_1.setLocation(509,165);
        intro_100_2=new MovingBitmap(R.drawable.intro_100_2);
        intro_100_2.setLocation(510,160);
        intro_150 =new MovingBitmap(R.drawable.intro_450);
        intro_150.setLocation(508,187);
        intro_3000=new MovingBitmap(R.drawable.intro_3000);
        intro_3000.setLocation(509,150);
        //右下角按鈕
        buyornot=new MovingBitmap((R.drawable.buyornot));
        buyornot.setLocation(0,0);
        pagebtnright =new MovingBitmap(R.drawable.pagebtn_right);
        pagebtnright.setLocation(265,10);
        pagebtnleft =new MovingBitmap(R.drawable.pagebtn_left);
        pagebtnleft.setLocation(265,340);

        //幸運草(我的錢)顯示
        strmoney=Model.getInstance().getMoney();
        switch (money = java.lang.Integer.parseInt(strmoney)) {}
        _money = new Integer(DEFAULT_SCORE_DIGITS, money, 22, 115);

       //食物數量的顯示
        strcount10=Model.getInstance().getCount10();
     switch (count10 = java.lang.Integer.parseInt(strcount10)){};

       strcount20=Model.getInstance().getCount20();
       switch (count20 = java.lang.Integer.parseInt(strcount20)){};

        strcount50=Model.getInstance().getCount50();
        switch (count50 = java.lang.Integer.parseInt(strcount50)){};

       strcount80=Model.getInstance().getCount80();
      switch (count80 = java.lang.Integer.parseInt(strcount80)){};

        //物品持有數
        _intro10count = new Integer(1, count10, 310, 166);
        _intro20count = new Integer(1, count20, 310, 166);
        _intro50count = new Integer(1, count50, 310, 166);
        _intro80count = new Integer(1, count80, 310, 166);
        _intro100_1count = new Integer(1, 0, 310, 166);
        _intro100_2count= new Integer(1, 0, 310, 166);
        _intro150count = new Integer(1, 0, 310, 166);
        _intro3000count = new Integer(1, 0, 310, 166);




    }



    @Override
    public void move() {

    }
    @Override
    public void show() {
        _shopbackground.show();
        _shopfood.show();

        if (pagestate == 1) {
            pagebtnright.show();
            if (state == 11) intro_10.show();
            else if (state == 22) intro_20.show();
            else if (state == 33) intro_80.show();
            else if (state == 44) intro_50.show();
            if (buystate == 11) {
                buyornot.show();
                if (state == 11) {
                    _intro10count.show();
                } else if (state == 22) {
                    _intro20count.show();
                } else if (state == 33) {
                    _intro80count.show();
                } else if (state == 44) {
                    _intro50count.show();
                }
            }

        } else if (pagestate == 2) {
            pagebtnleft.show();
            if (state == 11) intro_100_1.show();
            else if (state == 22) intro_100_2.show();
            else if (state == 33) intro_150.show();
            else if (state == 44) intro_3000.show();
            if (buystate == 11) {
                buyornot.show();
                if (state == 11) {
                    _intro100_1count.show();
                } else if (state == 22) {
                    _intro100_2count.show();
                } else if (state == 33) {
                    _intro150count.show();
                } else if (state == 44) {
                    _intro3000count.show();
                }
            }

        }
        //Log.e("state", "show: " + pagestate);
        _money.show();


    }

    @Override
    public void release() {
        _shopbackground.release();
        _shopfood.release();
        intro_10.release();
        intro_20.release();
        intro_50.release();
        intro_80.release();
        intro_150.release();
        intro_100_1.release();
        intro_100_2.release();
        intro_3000.release();
        buyornot.release();
        pagebtnright.release();
        pagebtnleft.release();
        _money.release();
        _intro10count.release();
        _intro20count.release();
        _intro50count.release();
        _intro80count.release();
        _intro100_1count.release();
        _intro100_2count.release();
        _intro150count.release();
        _intro3000count.release();
        buyornot=null;
        intro_10=null;
        _shopbackground=null;
        _shopfood=null;
        intro_20=null;
        intro_50=null;
        intro_80=null;
        intro_150=null;
        intro_100_1=null;
        intro_100_2=null;
        intro_3000=null;
        pagebtnright=null;
        pagebtnleft=null;
        _money = null;
        _intro10count = null;
        _intro20count = null;
        _intro50count = null;
        _intro80count = null;
        _intro100_1count = null;
        _intro100_2count = null;
        _intro150count = null;
        _intro3000count = null;

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
        shopOriginY=actionPointer.getY();
        shopPointX=actionPointer.getX();
        shopPointY=actionPointer.getY();
        mx = actionPointer.getX();
        my =actionPointer.getY();
        Log.e("located", "x: "+mx+" y:"+my );
//買畫面
        if(buystate==11) {
            if ((shopPointX >= 360 && shopPointX <= 390) && (shopPointY <= 261) && (shopPointY >= 206)) {
                buystate = 2;
                if(state==11&&pagestate==1){
                    _intro10count.add(1);
                   count10=count10+1;
                    Model.getInstance().setCount10(String.valueOf(count10));
                    _money.subtract(10);
                    money=money-10;
                    Model.getInstance().setMoney(String.valueOf(money));

                }
                if(state==22&&pagestate==1){
                    _intro20count.add(1);
                  count20=count20+1;
                    Model.getInstance().setCount20(String.valueOf(count20));
                    _money.subtract(20);
                    money=money-20;
                    Model.getInstance().setMoney(String.valueOf(money));
                }
                if(state==33&&pagestate==1){
                    _intro80count.add(1);
                   count80=count80+1;
                   Model.getInstance().setCount80(String.valueOf(count80));
                    _money.subtract(80);
                    money=money-80;
                    Model.getInstance().setMoney(String.valueOf(money));
                }
                if(state==44&&pagestate==1){
                    _intro50count.add(1);
                   count50=count50+1;
                    Model.getInstance().setCount50(String.valueOf(count50));
                    _money.subtract(50);
                    money=money-50;
                    Model.getInstance().setMoney(String.valueOf(money));
                }
                if(state==11&&pagestate==2){
                    _intro100_1count.add(1);
                    _money.subtract(100);
                    money=money-100;
                    Model.getInstance().setMoney(String.valueOf(money));
                }
                if(state==22&&pagestate==2){
                    _intro100_2count.add(1);
                    _money.subtract(100);
                    money=money-100;
                    Model.getInstance().setMoney(String.valueOf(money));
                }
                if(state==33&&pagestate==2){
                    _intro150count.add(1);
                    _money.subtract(150);
                    money=money-150;
                    Model.getInstance().setMoney(String.valueOf(money));
                }
                if(state==44&&pagestate==2){
                    _intro3000count.add(1);
                    _money.subtract(3000);
                    money=money-3000;
                    Model.getInstance().setMoney(String.valueOf(money));
                }

            } else if ((shopPointX >= 360 && shopPointX <= 390) && (shopPointY <= 173) && (shopPointY >= 87)) {
                buystate=3;
            }

        }




        //第一種食物
        else if((shopPointX>=130 &&shopPointX<=270) &&(shopPointY<=346&&shopPointY>=209)){
            if(state==11){
                buystate=1;
            }
            state = 1;
        }
        //第二種食物
        else if((shopPointX>=130 &&shopPointX<=270) &&(shopPointY>=30&&shopPointY<=176)){
            if(state==22){
                buystate=1;
            }
            state = 2;
        }
        //第三種食物
        else if((shopPointX>=304 &&shopPointX<=437) &&(shopPointY>=30&&shopPointY<=176)){
            if(state==33){
                buystate=1;
            }
            state = 3;
        }
        //第四種食物
        else if((shopPointX>=304 &&shopPointX<=437) &&(shopPointY<=346&&shopPointY>=209)){
            if(state==44){
                buystate=1;
            }
            state = 4;
        }

        //回戶外按鈕
        else if((shopPointX>=527 &&shopPointX<=574) &&(shopPointY>=8&&shopPointY<=53)){
            changeState(Game.RUNNING_STATE);
        }
        //回家裡按鈕
        else if((shopPointX>=600 &&shopPointX<=630) &&(shopPointY>=3&&shopPointY<=42)){
            changeState(Game.INSIDE_STATE);
        }
        //抽獎
        else if((shopPointX>=15 &&shopPointX<=56) &&(shopPointY>=11&&shopPointY<=51)){
            changeState(Game.LOTTERY_STATE);
        }
        Log.e("money:"+money,"moneyyyyy"+strmoney);
        return true;
    }
@Override
    public boolean pointerMoved(Pointer actionPointer, List<Pointer> pointers) {
        //食物圖片左右滑動
        distance =(actionPointer.getY()-shopOriginY);
        if(distance>0 && pictureMoveY<0 &&buystate!=11) {
            if(distance>30)distance=10;
            pictureMoveY=pictureMoveY+(distance/2);
            _shopfood.setLocation(0, pictureMoveY );
        }
        if(distance<0 && pictureMoveY>-380&&buystate!=11){
            if(distance<-30)distance=-20;
            pictureMoveY=pictureMoveY+(distance/2);
            _shopfood.setLocation(0, pictureMoveY );
        }
        if(pictureMoveY>0)pagestate=2;


        return true;

    }

    public void resizeAndroidIcon() {

    }

    @Override
    public boolean pointerReleased(Pointer actionPointer, List<Pointer> pointers) {
        //pagestate
        pagestate=1;
        if(pictureMoveY>=-420&&pictureMoveY<=-380)pagestate=1;
        else if(pictureMoveY>=-100&&pictureMoveY<=40)pagestate=2;

        //食物圖片左右滑動
        if(pictureMoveY<-320 && actionPointer.getY()-pictureMoveY>0)pictureMoveY=-406;
        else if(pictureMoveY>=-320 && actionPointer.getY()-shopOriginY>0)pictureMoveY=0;
        else if(pictureMoveY<-80 && actionPointer.getY()-shopOriginY<0)pictureMoveY=-406;
        else if(pictureMoveY>=-80 && actionPointer.getY()-shopOriginY<0)pictureMoveY=0;
        _shopfood.setLocation(0, pictureMoveY );

        //食物按鈕按下去第一次
        if(state==1) state=11;
        else if(state==2)state=22;
        else if(state==3)state=33;
        else if(state==4)state=44;
        if(buystate==1)buystate=11;
        distance=0;
        Log.e("money:"+StateShop.money,"moneyyyyy"+strmoney);
        Model.getInstance().initialize();
        /*MyApp.getBitmapList().add(new MovingBitmap());
        for (MovingBitmap bitmap : MyApp.getBitmapList()) {
            bi
        }*/
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