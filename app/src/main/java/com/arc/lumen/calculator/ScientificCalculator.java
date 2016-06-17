package com.arc.lumen.calculator;

import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.commons.math3.util.ArithmeticUtils;
import org.apache.commons.math3.util.CombinatoricsUtils;
import org.apache.commons.math3.util.MathUtils;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

/**
 * Created by dayem on 5/20/16 at 10:47 PM.
 */
public class ScientificCalculator extends Fragment {

    String prevAnswer = "";
    TextView formulascreen;
    TextView resultscreen;
    String formuladisplay = "";
    String resultdisplay = "";
    Double result;
    String operator;
    DecimalFormat res = new DecimalFormat("#,###,###,###.######");
    DecimalFormat formula = new DecimalFormat("##########.######");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scientific_calculator, container, false);

        formulascreen = (TextView) view.findViewById(R.id.formulaTextView);
        updateformuladisplay();

        resultscreen = (TextView) view.findViewById(R.id.resultTextView);
        updateresultdisplay();

        view.findViewById(R.id.btn0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btn9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.btnSqrt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.btnsin).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btncos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btntan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btnlog).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btnln).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btnOpen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickpar(v);
            }
        });

        view.findViewById(R.id.btnClose).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickpar(v);
            }
        });

        view.findViewById(R.id.btnDecimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btnAbs).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btnFactorial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickfact(v);
            }
        });

        view.findViewById(R.id.btnSqr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickspecpow(v);
            }
        });

        view.findViewById(R.id.btnCube).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickspecpow(v);
            }
        });

        view.findViewById(R.id.btnpow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickspecpow(v);
            }
        });

        view.findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickClear(v);
            }
        });

        view.findViewById(R.id.btnDel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickDel(v);
            }
        });

        view.findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.btnMinus).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.btnDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.btnMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.btnncr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickn(v);
            }
        });

        view.findViewById(R.id.btnEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickEquals(v);
            }
        });

        view.findViewById(R.id.btnPrevAns).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickAns(v);
            }
        });

        return view;
    }

    public void onClickEquals(View view) {

            getResult();
            updateresultdisplay();

    }

    private boolean getResult() {

        if (operator.equals("")) return false;

        String[] operation = formuladisplay.split(Pattern.quote(operator));

        if (operation.length < 2) return false;

            result = eval(formuladisplay);
            resultdisplay = String.valueOf(res.format(result));
            prevAnswer = String.valueOf(formula.format(result));
            result = null;

        return true;

    }

    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            void prevChar() {
                ch = (--pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (;;) {
                    if      (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (;;) {
                    if      (eat('x')) x *= parseFactor(); // multiplication
                    else if (eat('÷')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') { // functions
                    while (ch >= 'a' && ch <= 'z'|| ch >= 'A' && ch <= 'Z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sin")) x = Math.sin(x);
                    else if (func.equals("cos")) x = Math.cos(x);
                    else if (func.equals("tan")) x = Math.tan(x);
                    else if (func.equals("log")) x = Math.log(x);
                    else if (func.equals("ln")) x = Math.log10(x);
                    else if (func.equals("Abs")) x = Math.abs(x);
                    //else if (func.equals("fact")) x = CombinatoricsUtils.factorial((int) x);
                    else throw new RuntimeException("Unknown function: " + func);
                }

                else if (ch == '√') { // functions
                    while (ch == '√') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("√")) x = Math.sqrt(x);
                    else throw new RuntimeException("Unknown function: " + func);
                }

                else if (ch == '!') { // functions
                    String func = str.substring(this.pos - 1, this.pos);
                    x = parseFactor();
                    Log.v("Value of x:", "x = " + x);
                    if (func.equals("!")) {
                        x = CombinatoricsUtils.factorial((int) x);
                        Log.v("Value of x:", "x = " + x);
                    }
                    else throw new RuntimeException("Unknown function: " + func);
                }

                else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());
                else if (eat('³')) x = Math.pow(x, 3);
                else if (eat('²')) x = Math.pow(x, 2); // exponentiation

                return x;
            }
        }.parse();

    }

    private void updateformuladisplay() {

        formulascreen.setText(formuladisplay);

    }

    private void updateresultdisplay() {

        resultscreen.setText(resultdisplay);

    }

    public void onClickadvop(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += operator + "(";
        updateformuladisplay();

    }

    public void onClickpar(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += operator;
        updateformuladisplay();

    }

    public void onClickfact(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += "!";
        updateformuladisplay();

    }

    public void onClickDel(View view) {

        if (formuladisplay.length() >= 1) {

            formuladisplay = formuladisplay.substring(0, formuladisplay.length() - 1);
            updateformuladisplay();

        }

    }

    private void clear() {

        formuladisplay = "";
        resultdisplay = "";

    }

    public void onClickClear(View view) {

        clear();
        updateformuladisplay();
        updateresultdisplay();

    }

    public void onClickNumber(View view) {

        Button b = (Button) view;

        if (formuladisplay.length() >= 0 && formuladisplay.length() <= 17) {

            formuladisplay += b.getText();
            updateformuladisplay();

        }

        else {

            updateformuladisplay();

        }

    }

    public void onClickOperator(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += operator;
        updateformuladisplay();

    }

    public void onClickspecpow(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        if (operator.equals("x²")) formuladisplay += "²";
        else if (operator.equals("x³")) formuladisplay += "³";
        else if (operator.equals("xⁿ")) formuladisplay += "^";


        updateformuladisplay();

    }

    public void onClickAns(View view) {

        Button b = (Button) view;

        if (formuladisplay.length() >= 0 && formuladisplay.length() <= 10) {

            formuladisplay += prevAnswer;
            updateformuladisplay();

        }

        else {

            updateformuladisplay();

        }
    }

    public void onClickn(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        if (operator.equals("nCr")) formuladisplay += "C";
        else if (operator.equals("nPr")) formuladisplay += "P";

        updateformuladisplay();

    }

}
