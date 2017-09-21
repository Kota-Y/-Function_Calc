import java.util.*;
import java.lang.*;
import java.io.*;

/**関数の計算を行うクラス*/
public class Function{
    
    /**sinの計算メソッド*/
    public static Double sin(double x){
	return Math.sin(x);
    }

    /**cosの計算メソッド*/
    public static Double cos(double x){
	return Math.cos(x);
    }

    /**tanの計算メソッド*/
    public static Double tan(double x){
	return Math.tan(x);
    }

    /**sinhの計算メソッド*/
    public static Double sinh(double x){
	return Math.sinh(x);
    }

    /**coshの計算メソッド*/
    public static Double cosh(double x){
	return Math.cosh(x);
    }

    /**tanhの計算メソッド*/
    public static Double tanh(double x){
	return Math.tanh(x);
    }

    /**log_(e)の計算メソッド*/
    public static Double loge(double x){
	return Math.log(x);
    }

    /**log_(10)の計算メソッド*/
    public static Double log10(double x){
	return Math.log10(x);
    }
    
    /**平方根の計算メソッド*/
    public static Double root(double x){
	return Math.pow(x,0.5);
    }

    /**10の乗数倍の計算メソッド*/
    public static Double multipl10(double x){
	return Math.pow(10,x);
    }

    /**基数x,指数yとして累乗計算*/
    public static Double ruijo(double y, double x){
	return Math.pow(x,y);
    }

    /**階乗の計算メソッド*/ 
    public static Double kaijo(Double x){	
	double fact = 1;
	if (x == 0){
	    return fact;
	} else {
	    for ( double i = x; i > 0; i--){
		fact *= i;
	    }
	    return fact;
	}
    }

    /**P(x)(y)の形でxのパーミテーションyを求める*/
    public static Double permutation(Double y, Double x){
	double fact = 1;
	if (y == 0){
	    return fact;
	} else {
	    for ( int n = 0; y > n; n++){
		fact *= x;
		x--;
	    }
	    return fact;
	}
    }
    
    /**C(x)(y)の形でxのコンビネーションyを求める*/ 
    public static Double combination(Double y, Double x){
	double fact = 1;
	if (y == 0){
	    return fact;
	} else {
	    double aa = permutation(y,x);
	    double bb = kaijo(y);
	    fact = aa / bb;
	    return fact;
	}
    }
    
    
    /**log_(x)yの計算メソッド(底を指定しての対数計算)*/
    public static double log_xy(double x,double y){
	return Math.log(x)/Math.log(y);
    }
    
}


