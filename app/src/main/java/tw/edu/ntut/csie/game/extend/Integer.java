package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * <code>Integer</code>用多張圖片顯示多位數的整數。
 *
 * @author <a href="http://www.csie.ntut.edu.tw/labsdtl/">Lab SDT</a>
 * @version 2.0
 * @since 1.0
 */
public class Integer implements GameObject {

    /**
     * 預設的整數顯示位數。
     */
    public static final int DEFAULT_DIGITS = 4;

    /**
     * 顯示整數的左上角座標。
     */
    private int _x;
    private int _y;

    /**
     * 顯示的值和位數。
     */
    private int _value;
    private int _digits;

    /**
     * 用來顯示0~9的及負號的圖片。
     */
    private MovingBitmap[] _digitImages;

    /**
     * 使用預設值建立一個<code>Integer</code>物件。
     */
    public Integer() {
        this(DEFAULT_DIGITS);
    }

    /**
     * 使用指定的顯示位數建立一個<code>Integer</code>物件。
     *
     * @param digits 欲顯示的位數
     */
    public Integer(int digits) {
        this(digits, 0, 0, 0);
    }

    /**
     * 使用指定的顯示位數、初始值和初始位置，建立一個<code>Integer</code>物件。
     *
     * @param digits    欲顯示的位數
     * @param initValue 初始值
     * @param x         初始位置的X座標
     * @param y         初始位置的X座標
     */
    public Integer(int digits, int initValue, int x, int y) {
        initialize();
        setDigits(digits);
        setLocation(x, y);
        _value = initValue;
    }

    /**
     * 對目前顯示的數值加上指定的值。
     *
     * @param addend 加數(目前的值為被加數)
     */
    public void add(int addend) {
        _value += addend;
    }

    @Override
    public void move() {
    }

    @Override
    public void release() {
        for (int i = 0; i < 11; i++) {
            _digitImages[i].release();
        }
    }

    //數字反轉
    public int reverse(int x) {
        int result = 0;
        int tmp = x;
        while (true) {
            int digit = tmp%10;
            result = result * 10 + digit;
            tmp /=10;
            if (tmp == 0)
                break;
        }
        return result;
    }

    @Override
    public void show() {
        int ny;
        int MSB;
        if (_value >= 0) {
            MSB =reverse(_value);
            ny = _y + _digitImages[0].getHeight() * (_digits - 1);
        } else {
            MSB = -reverse(_value);
            ny = _y + _digitImages[0].getWidth() * _digits;
        }
        for (int i=_digits-1; i>=0 ; i--) {
            int d = MSB % 10;
            MSB /= 10;
            _digitImages[d].setLocation(_x, ny);
            _digitImages[d].show();
            ny -= _digitImages[d].getWidth();
        }
        if (_value < 0) {
            _digitImages[10].setLocation(_x, ny);
            _digitImages[10].show();
        }
    }

    /**
     * 對目前顯示的數值減去指定的值。
     *
     * @param subtrahend 減數(目前的值為被減數)
     */
    public void subtract(int subtrahend)
    {
       if(_value>0) _value -= subtrahend;
       else _value=0;
    }

    /**
     * 變更顯示的位數。
     *
     * @param digits 新的顯示位數
     */
    public void setDigits(int digits) {
        _digits = digits;
    }

    /**
     * 設定最高位數字的顯示位置，其他位數會依據每個數字的圖片大小依序排列顯示。
     *
     * @param x 顯示位置的x座標
     * @param y 顯示位置的x座標
     */
    public void setLocation(int x, int y) {
        _x = x;
        _y = y;
    }

    /**
     * 設定欲顯示的整數數值。
     *
     * @param value 新的整數值
     */
    public void setValue(int value) {
        _value = value;
    }

    /**
     * 取得目前顯示的整數數值。
     *
     * @return 整數值
     */
    public int getValue() {
        return _value;
    }

    /**
     * 進行初始化。
     */
    private void initialize() {
        _digitImages = new MovingBitmap[11];
        _digitImages[0] = new MovingBitmap(R.drawable.digit_0);
        _digitImages[1] = new MovingBitmap(R.drawable.digit_1);
        _digitImages[2] = new MovingBitmap(R.drawable.digit_2);
        _digitImages[3] = new MovingBitmap(R.drawable.digit_3);
        _digitImages[4] = new MovingBitmap(R.drawable.digit_4);
        _digitImages[5] = new MovingBitmap(R.drawable.digit_5);
        _digitImages[6] = new MovingBitmap(R.drawable.digit_6);
        _digitImages[7] = new MovingBitmap(R.drawable.digit_7);
        _digitImages[8] = new MovingBitmap(R.drawable.digit_8);
        _digitImages[9] = new MovingBitmap(R.drawable.digit_9);
        _digitImages[10] = new MovingBitmap(R.drawable.digit_10);
    }
}
