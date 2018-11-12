package tw.edu.ntut.csie.game;

import android.util.Log;

import tw.edu.ntut.csie.game.state.StateReady;

public class Model {
    private static final Model ourInstance = new Model();

    private String money;
    private String count10;
    private String count20;
    private String count50;
    private String count80;
    private String giftlast;

    public static Model getInstance() {
        return ourInstance;
    }

    private Model() {
    }

    public void initialize() {
        money = MyApp.read("money").equals(" ") ? "0" : MyApp.read("money");
        count10 = MyApp.read("count10").equals(" ") ? "0" : MyApp.read("count10");
        count20 = MyApp.read("count20").equals(" ") ? "0" : MyApp.read("count20");
       count50 = MyApp.read("count50").equals(" ") ? "0" : MyApp.read("count50");
       count80 = MyApp.read("count80").equals(" ") ? "0" : MyApp.read("count80");
        giftlast = MyApp.read("giftlast").equals(" ") ? "0" : MyApp.read("giftlast");

        MyApp.clean(money);
        MyApp.write("money","500");






    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money)
    {
        MyApp.write("money", String.valueOf(money));
        Log.e("123123","++++++++++++++++++++++++++++++++++");
    }

    public String getCount10() {
        return count10;
    }

    public void setCount10(String count10) {

        MyApp.write("count10", String.valueOf(count10));
    }
    public String getCount20() {
        return count20;
    }

    public void setCount20(String count20) {

        MyApp.write("count20", String.valueOf(count20));
    }
    public String getCount50() {
        return count50;
    }

    public void setCount50(String count50) {

        MyApp.write("count50", String.valueOf(count50));
    }
    public String getCount80() {
        return count80;
    }

    public void setCount80(String count80) {

        MyApp.write("count80", String.valueOf(count80));

    }

    public String getGiftlast() {
        return giftlast;
    }

    public void setGiftlast(String giftlast) {

        MyApp.write("giftlast", String.valueOf(giftlast));
    }
}
