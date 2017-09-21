import javax.swing.*;
import java.awt.*;


/** 表示する数クラス */
public class OldDisplayedNumber extends JLabel{
    /** 数値 */
    private long num;
    /** 入力完了フラグ */
    private boolean finishedFlag;
    /** エラーフラグ **/
    public boolean errorflag = false;

    private OldArithmeticUnit arithmUnit;

    /**コンストラクタ*/
    public OldDisplayedNumber(){
	num = 0;
	setValue(num);
	finishedFlag = false;
    }
    
    /** (表示する)に1桁加える */
    public void addSingleDigit(int d){
	if(finishedFlag == true){
		num = d;
		setValue(num);
		finishedFlag = false;
	}
	else if(finishedFlag == false){
		if(num < 1000000000){
			if(num == 0){
				num = d;
				setValue(num);
			}else{
				num = num*10 + d;
				setValue(num);
			}
		}
	}
    }
    
    /** (表示する)を0にする */
    public void clear(){
	num = 0;
	setValue(num);
    }
    
    /** (表示する)に値を代入する */
    public void setValue(long num){
	boolean flag = errorflag;
	if(flag == true){
		setText("Error");
		errorflag = false;
	}else if(num >= 10000000000L || num <= -100000000){
	    setText("Error");
	}else{
	    setText(Long.toString(num));
	}
    }
    
    /** (表示する)の値を読み出す */
    public long getValue(){
	return num;
    }
    
    /** (表示する)の入力完了フラグを立てる */
    public void finished(){
	finishedFlag = true;
    }
}
