import javax.swing.*;
import java.util.Scanner;

/**演算器.演算器号の表示部も含む.2つの数に対して4種類の演算をする.
 *演算結果は「表示する数」オブジェクトに渡して,表示する.*/
public class OldArithmeticUnit extends JLabel{

    /**+演算子（足し算記号）.operator が取りうる値*/
    public static String OP_PLUS="+";
    /**-演算子（引き算記号）.operator が取りうる値*/
    public static String OP_MINUS="-";
    /** *演算子（掛け算記号）.operator が取りうる値*/
    public static String OP_TIMES="×";
    /** /演算子（割り算記号）.operator が取りうる値*/
    public static String OP_DIVIDE="÷";
    /**演算子が未選択であることを示す.operator が取りうる値*/
    public static String OP_NONE="";
    /**ボタンを表示する演算子を列挙した配列*/
    public static String OPERATORS[]={OP_PLUS,OP_MINUS,OP_TIMES,OP_DIVIDE};

    public boolean ErrorFlag = false;

    /**一つ目の数の値*/
    public long firstOperand = 0;
    /**演算を一回行ってるかの確認フラグ**/
    public boolean ArithmFlag = false;
    
    /**演算子*/
    public String operator;
    /**一つ前の演算子**/
    public String operator2;
    /**表示する数*/
    private OldDisplayedNumber dispNumber;

    /**コンストラクタ*/
    public OldArithmeticUnit(OldDisplayedNumber dispNumber){
	this.dispNumber = dispNumber;
	operator = OP_NONE;
	setOperator(operator,false);
    }

    /**演算器が演算する*/
    public void operate(){
	if(operator != OP_NONE ){
	    if(operator == OP_PLUS){
		dispNumber.setValue(firstOperand + dispNumber.getValue());
	    }else if(operator == OP_MINUS){
		dispNumber.setValue(firstOperand - dispNumber.getValue());
	    }else if(operator == OP_TIMES){
		dispNumber.setValue(firstOperand * dispNumber.getValue());
	    }else if(operator == OP_DIVIDE){
		if(dispNumber.getValue() == 0){
		    dispNumber.errorflag = true;
		    dispNumber.setValue(1);
		}else{
		    dispNumber.setValue(firstOperand / dispNumber.getValue());
		}
	    }
	}
	
    }
    
    /**演算器に演算子を設定する*/
    public void setOperator(String operator,boolean flag){
	if(flag == true){
	    ArithmFlag = false;
	}

	this.operator = operator;

	setText(operator);

	if(ArithmFlag == false){
	    ArithmFlag = true;
	    firstOperand = dispNumber.getValue();
	} else{
	    if(operator2 == OP_PLUS){
	        firstOperand += dispNumber.getValue();
	    }else if(operator2 == OP_MINUS){
	        firstOperand -= dispNumber.getValue();
	    }else if(operator2 == OP_TIMES){
	        firstOperand *= dispNumber.getValue();
	    }else if(operator2 == OP_DIVIDE){
		if(dispNumber.getValue() == 0){
		    dispNumber.errorflag = true;
		    dispNumber.setValue(1);
		}
 		else {
		    firstOperand /= dispNumber.getValue();
		}
	    }
	}
	this.operator2 = operator;



	dispNumber.finished();
    }
    
    /**演算器の演算子を未設定にする*/
    public void clear(){
	operator = OP_NONE;
	ArithmFlag = false;
	setText(operator);
	
    }
}
