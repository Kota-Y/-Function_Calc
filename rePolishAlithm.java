import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**入力式の計算を行うクラス*/
public class rePolishAlithm {

    /* +演算子（足し算記号）が取りうる値 */
    public static String OP_PLUS   = "+";
    /* -演算子（引き算記号）が取りうる値 */
    public static String OP_MINUS  = "-";
    /* ×演算子（掛け算記号）が取りうる値 */
    public static String OP_MULTI  = "✕";
    /* ÷演算子（割り算記号）が取りうる値 */
    public static String OP_DIVI   = "÷";
    /* sin記号が取りうる値 */
    public static String FU_SIN    = "s";
    /* cos記号が取りうる値 */
    public static String FU_COS    = "c";
    /* tan記号が取りうる値 */
    public static String FU_TAN    = "t";
    /* sinh記号が取りうる値 */
    public static String FU_SINH   = "d";
    /* cosh記号が取りうる値 */
    public static String FU_COSH   = "v";
    /* tanh記号が取りうる値 */
    public static String FU_TANH   = "y";
    /* 累乗記号が取りうる値 */
    public static String FU_POWER  = "^";
    /* 階乗記号が取りうる値 */
    public static String FU_FACT   = "!";
    /* 底自由logが取りうる値 */
    public static String FU_LOG    = "l";
    /* 底eのLnが取りうる値 */
    public static String FU_LN     = "i";
    /* combination記号が取りうる値 */
    public static String FU_COMBI  = "C";
    /* parmitation記号が取りうる値 */
    public static String FU_PERMU  = "P";
    /* 左カッコ記号が取りうる値 */
    public static String L_BRACKET = "(";
    /* 右カッコ記号が取りうる値 */
    public static String R_BRACKET = ")";
    /* イコール記号が取りうる値 */
    public static String OP_EQUAL  = "=";

    /* 全記号の群 */
    public static String alith[] ={OP_PLUS, OP_MINUS, OP_MULTI, OP_DIVI, FU_SIN, FU_COS, FU_TAN, FU_SINH, FU_COSH, FU_TANH, FU_POWER, FU_FACT, FU_LOG, FU_COMBI, FU_PERMU, L_BRACKET, R_BRACKET, OP_EQUAL};
    /* 四則演算記号の群 */
    public static String alith4[] = {OP_PLUS, OP_MINUS, OP_MULTI, OP_DIVI};
    /* 四則演算以外の関数の群 */
    public static String fun[] ={FU_SIN, FU_COS, FU_TAN, FU_SINH, FU_COSH, FU_TANH, FU_POWER, FU_FACT, FU_LOG, FU_COMBI, FU_PERMU};
    /* 関数の中でも引数を2つもつ関数の群 */
    public static String fun1[] ={FU_SIN, FU_COS, FU_TAN, FU_SINH, FU_COSH, FU_TANH, FU_POWER, FU_FACT, FU_LN};
    /* 関数の中でも引数を1つもつ関数の群 */
    public static String fun2[] ={FU_LOG, FU_COMBI, FU_PERMU};

    /* 優先度3の関数の群 */
    public static String rank3[] ={FU_SIN, FU_COS, FU_TAN, FU_SINH, FU_COSH, FU_TANH, FU_FACT, FU_COMBI, FU_PERMU, L_BRACKET};
    /* 優先度2の関数の群 */
    public static String rank2[] ={OP_PLUS, OP_MINUS};
    /* 優先度1の関数の群 */
    public static String rank1[] ={OP_MULTI, OP_DIVI};
    
    /* 「中置記法」→「後置記法」の変換に必要なスタック */
    static Stack<String> que1 = new Stack<String>();
    static Stack<String> que2 = new Stack<String>();
    
    /* 「中置記法」→「後置記法」の変換の際,スタック移動の優先度を決める値 */
    static int Rank = 0;
    static int befRank = 0;

    /* 「中置記法」→「後置記法」の変換の際,利用するフラグ */
    static boolean finishFlag = true;
    
    /* 引数の数が違う関数を見分けるフラグ */
    static boolean fun2Flag = true;

    /* 中置記法の入力式を仕分ける際に利用するフラグ */
    static boolean alithFlag;
    static boolean opFlag;
    /* 負の「-」か演算記号の「-」かを見分けるフラグ */
    static boolean minusFlag;

    /* 関数の計算 */
    static private Function funk;

    

    /* 後置記法を計算する */
    public static String rePolish(String inMidleFormula) {
	
        String[] formula = convert(inMidleFormula);

        Stack<Double> que = new Stack<Double>();

        double a = 0;
        double b = 0;
	double ans = 0;


	/** Error表示 **/
	if(formula[0].equals("Error")){
		String result = "Error";
		return result;
	}
	
        for (int i = 0; i < formula.length; i++) {
	    /* 足し算 */
            if (formula[i].equals(OP_PLUS)) {
                a = que.pop();
                b = que.pop();
                que.add(b + a);
                continue;
            }
	    /* 引き算 */
            if (formula[i].equals(OP_MINUS)) {
                a = que.pop();
                b = que.pop();
                que.add(b - a);
                continue;
            }
	    /* かけ算 */
            if (formula[i].equals(OP_MULTI)) {
                a = que.pop();
		b = que.pop();
                que.add(b * a);
                continue;
            }
	    /* 割り算 */
            if (formula[i].equals(OP_DIVI)) {
                a = que.pop();
                b = que.pop();
                que.add(b / a);
                continue;
            }
	    /* sin演算 */
	    if (formula[i].equals(FU_SIN)) {
		que.add(funk.sin( que.pop() ));
		continue;
	    }
	    /* cos演算 */
	    if (formula[i].equals(FU_COS)) {
	        que.add(funk.cos( que.pop() ));
		continue;
	    }
	    /* tan演算 */
	    if (formula[i].equals(FU_TAN)) {
	        que.add(funk.tan( que.pop() ));
		continue;
	    }
	    /* sinh演算 */
	    if (formula[i].equals(FU_SINH)) {
	        que.add(funk.sinh( que.pop() ));
		continue;
	    }
	    /* cosh演算 */
	    if (formula[i].equals(FU_COSH)) {
	        que.add(funk.cosh( que.pop() ));
		continue;
	    }
	    /* tanh演算 */
	    if (formula[i].equals(FU_TANH)) {
	        que.add(funk.tanh( que.pop() ));
		continue;
	    }
	    /* log演算 */
	    if (formula[i].equals(FU_LOG)) {
		a = que.pop();
		b = que.pop();
		que.add(Math.log(a) / Math.log(b));
		continue;
	    }
	    /* ln演算 */
	    if (formula[i].equals(FU_LN)) {
	        que.add(funk.loge( que.pop() ));
		continue;
	    }
	    /* 累乗演算 */
	    if (formula[i].equals(FU_POWER)) {
	        que.add(funk.ruijo( que.pop() ,que.pop()  ));
		continue;
	    }
	    /* 階乗演算 */
	    if (formula[i].equals(FU_FACT)) {
	        que.add( funk.kaijo( que.pop() ) );
		continue;
	    }
	    /* コンビネーション演算 */
	    if (formula[i].equals(FU_COMBI)) {
	        que.add( funk.combination( que.pop() ,que.pop() ) );
		continue;
	    }
	    /* パーミテーション演算 */
	    if (formula[i].equals(FU_PERMU)) {
	        que.add(funk.permutation( que.pop() ,que.pop() ));
		continue;
	    }
            // 演算子以外はstackに登録する
	    if(formula[i].equals("e")){
		que.push(Math.E);
		continue;
	    }
	    if(formula[i].equals("π")){
		que.push(Math.PI);
		continue;
	    }
	    
	    double db = Double.parseDouble(formula[i]);
            que.push( db );
        }
	double Ans = que.pop();

	if(Double.isInfinite(Ans) || Double.isNaN(Ans) ){
	    String result = "Error";
	    return result;
	}

	String result;

	BigDecimal bd = new BigDecimal(Ans);
	BigDecimal reBd = bd.setScale(10, BigDecimal.ROUND_HALF_UP);
	double dAns = reBd.doubleValue();

	if(dAns - Math.floor(dAns) == 0){
	    long AnsInt = (long)dAns;
	    result = Long.toString(AnsInt);
	    if(AnsInt >= 10000000000000000L){
	        result = "Error";
	    }
	} else {
	    result = Double.toString(dAns);
	}
	
	return result;
    }











    /* 「中置記→後置記」　変換器 */
    public static String[] convert(String inMidleFormula){

	/** 機能記号置換 */
	inMidleFormula = inMidleFormula.replaceAll("/"   , "÷");
	inMidleFormula = inMidleFormula.replaceAll("sin" , "s");
	inMidleFormula = inMidleFormula.replaceAll("cos" , "c");
	inMidleFormula = inMidleFormula.replaceAll("tan" , "t");
	inMidleFormula = inMidleFormula.replaceAll("sh"  , "d");
	inMidleFormula = inMidleFormula.replaceAll("ch"  , "v");
	inMidleFormula = inMidleFormula.replaceAll("th"  , "y");
	inMidleFormula = inMidleFormula.replaceAll("log" , "l");
	inMidleFormula = inMidleFormula.replaceAll("ln"  , "i");
	
	
        /** 一文字ずつに区切る */
	String[] befmidleFormula = new String[inMidleFormula.length()];
	for(int i = 0; i < inMidleFormula.length(); i++) {
	    String str2 = String.valueOf(inMidleFormula.charAt(i));
	    befmidleFormula[i] = str2;
	}

	/** 配列[bermidleFormula]内の数字と演算記号を分けて、リストlistmidleFormula内へ */
	ArrayList<String> listmidleFormula = new ArrayList<String>();
	int m = 0;
	alithFlag = false;
	minusFlag = false;
	opFlag = false;
	
	for (int n = 0; n < befmidleFormula.length; n++) {
	    if ( listmidleFormula.size() == 0 ){
		if(befmidleFormula[0].equals(OP_MINUS) == false && Arrays.asList(alith).contains(befmidleFormula[0])){
		    alithFlag = true;
		    if(befmidleFormula[0].equals(OP_MINUS) == false && Arrays.asList(alith4).contains(befmidleFormula[0])){
			listmidleFormula.add("0");
			m++;
		    }
		}
		listmidleFormula.add(befmidleFormula[0]);
	    } else if( Arrays.asList(alith4).contains(befmidleFormula[n]) && opFlag == true ){
		/** 四則演算記号が2回連続並んでいるとErrorを返す。 **/
		String[] Error = new String[1];
		Error[0] = "Error";
		return Error;
		
	    } else if( Arrays.asList(alith).contains(befmidleFormula[n]) ){
	        listmidleFormula.add(befmidleFormula[n]);
		minusFlag = false;
		opFlag = false;
		if(alithFlag == true && befmidleFormula[n].equals(OP_MINUS)){
		    minusFlag = true;
		}
		if(Arrays.asList(alith4).contains(befmidleFormula[n])){
		    opFlag = true;
		} 
		alithFlag = true;
		m++;
	    }else {
		opFlag = false;
		if (alithFlag == true && minusFlag == false){
		    m++;
		    listmidleFormula.add(befmidleFormula[n]);
		    alithFlag = false;
		} else {
		    listmidleFormula.set( m, listmidleFormula.get( m ) + befmidleFormula[n] );
		}
	    }
	}

	

	/** リストlistmidleFormulaの数字と演算器号を、配列[midleFormula]へ */
	String[] midleFormula = new String[listmidleFormula.size()];
	for(int n = 0; n < listmidleFormula.size(); n++){
	    midleFormula[n] = listmidleFormula.get( n );
	}

	/** 中置記法から後置記法へ */
	for(int i = 0; i < midleFormula.length; i++){
	    /* =が来たら残りをque1へ */
	    if (midleFormula[i].equals("=")){
		while(que1.size() != 0){
		    que2.add(que1.pop());
		}
	    } else if ( que1.empty() || Arrays.asList(rank3).contains(midleFormula[i]) ){

		/* スタックque1が空かmidleFormula[i]がrank3の要素ならadd */
		que1.add(midleFormula[i]);
	    } 
	    else {

		/* Rankの設定 */
	        if(Arrays.asList(rank3).contains(midleFormula[i]) || midleFormula[i].equals(R_BRACKET)){
		    Rank = 3;
		} else if (Arrays.asList(rank2).contains(midleFormula[i])){
		    Rank = 2;
		} else if (Arrays.asList(rank1).contains(midleFormula[i])) {
		    Rank = 1;	
		} else {
		    Rank = 0;
		}
		/* finishFlagの初期化 */
		finishFlag = true;
		
		while(finishFlag == true){
		    if ( que1.empty() ){
			/* que1が空ならそのままadd */
			que1.add(midleFormula[i]);
			finishFlag = false;
			
		    } else {
			/* befRank の設定 */
			if( Arrays.asList(rank3).contains(que1.peek()) ){
			    befRank = 3;
			} else if ( Arrays.asList(rank2).contains(que1.peek()) ){
			    befRank = 2;
			} else if (Arrays.asList(rank1).contains(que1.peek())){
			    befRank = 1;	
			} else {
			    befRank = 0;
			}
			/* RankとbefRankの比較 */
			if(Rank >= befRank){
			    if ( que1.peek().equals(L_BRACKET) ){
				que1.pop();
				if(que1.empty() == false && Arrays.asList(fun1).contains(que1.peek())){
				    que2.add(que1.pop());
				}
				finishFlag = false;
			    } else {
				if (Arrays.asList(fun2).contains(que1.peek()) && fun2Flag == true){
				    fun2Flag = false;
				} else {
				    que2.add(que1.pop());
				    fun2Flag = true;
				}
			    }
			} else {
			    que1.add(midleFormula[i]);
			    finishFlag = false;
			}
		    }
		}
	    }
	}

	/** スタックque2内の文字を配列formulaへ移動 */
	String[] formula = new String[que2.size()];
	for(int i = que2.size() - 1; i >= 0; i--) {
	    formula[i] = que2.pop();
	}
	
	return formula;	
    }



}
