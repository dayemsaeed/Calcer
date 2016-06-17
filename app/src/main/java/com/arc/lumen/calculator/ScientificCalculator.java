package com.arc.lumen.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.apache.commons.math3.util.CombinatoricsUtils;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * Created by dayem on 5/20/16 at 10:47 PM.
 */
public class ScientificCalculator extends Fragment {

    String prevAnswer = ""; // Used to store result from last calculation
    TextView formulascreen; // The section of the screen on which we will type our formula to be calculated
    TextView resultscreen; // The section of the screen on which our result will be displayed
    String formuladisplay = ""; // The actual text of our formula
    String resultdisplay = ""; // The actual text of the result
    Double result; // The result of the calculation
    String operator; // The operator to be used for the calculation
    DecimalFormat res = new DecimalFormat("#,###,###,###.######"); // To format the result in a suitable way to make it easier to read
    DecimalFormat formula = new DecimalFormat("##########.######"); // To format the formula in a way that'll make it easier to read

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.scientific_calculator, container, false);

        formulascreen = view.findViewById(R.id.formulaTextView);
        updateformuladisplay(); // To update the formula so we can see what the user is entering in realtime

        resultscreen = view.findViewById(R.id.resultTextView);
        updateresultdisplay(); // To update the result display and show the result

        // To enter the different button values that the user presses for their calculations
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

        view.findViewById(R.id.btnSqrt).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClickinv(v);
                return true;
            }
        });

        view.findViewById(R.id.btnMod).setOnClickListener(new View.OnClickListener() {
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

        view.findViewById(R.id.btnsin).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClickinv(v);
                return true;
            }
        });

        view.findViewById(R.id.btncos).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btncos).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClickinv(v);
                return true;
            }
        });

        view.findViewById(R.id.btntan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickadvop(v);
            }
        });

        view.findViewById(R.id.btntan).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                onClickinv(v);
                return true;
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
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.btnnPr).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickn(v);
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

        view.findViewById(R.id.btn10x).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickx10(v);
            }
        });

        return view;
    }

    // To be used when the user presses the '=' button. This will evaluate the result using the getResult() method and display it in the result TextView using the updateresultdisplay() method
    public void onClickEquals(View view) {

        getResult();
        updateresultdisplay();

    }

    // To evaluate the formula the user entered and get the result of the calculation
    private boolean getResult() {

        if (operator.equals("")) return false;

        String[] operation = formuladisplay.split(Pattern.quote(operator));

        if (operation.length < 2 && operator.equals("x") || operation.length < 2 && operator.equals("+") || operation.length < 2 && operator.equals("-") || operation.length < 2 && operator.equals("÷") || operation.length < 2 && operator.equals("C"))
            return false;
        else if (operation.length < 2) return false;

        result = eval(formuladisplay);
        resultdisplay = String.valueOf(res.format(result));
        prevAnswer = String.valueOf(formula.format(result));
        result = null;

        return true;

    }

    // This method is used to actually perform the calculations the user enters and sends it to getResult()
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
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
                } else if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '⁻' || ch == '¹' || ch == '³' || ch == '√') { // functions
                    while (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z' || ch == '⁻' || ch == '¹' || ch == '³' || ch == '√')
                        nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sin")) x = Math.sin(x);
                    else if (func.equals("cos")) x = Math.cos(x);
                    else if (func.equals("tan")) x = Math.tan(x);
                    else if (func.equals("sin⁻¹")) x = Math.asin(x);
                    else if (func.equals("cos⁻¹")) x = Math.acos(x);
                    else if (func.equals("tan⁻¹")) x = Math.atan(x);
                    else if (func.equals("log")) x = Math.log(x);
                    else if (func.equals("ln")) x = Math.log10(x);
                    else if (func.equals("Abs")) x = Math.abs(x);
                    else if (func.equals("√")) x = Math.sqrt(x);
                    else if (func.equals("³√")) x = Math.cbrt(x);
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char)ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());
                else if (eat('³')) x = Math.pow(x, 3);
                else if (eat('²')) x = Math.pow(x, 2);
                else if (eat('!')) x = CombinatoricsUtils.factorial((int) x);
                else if (eat('C'))
                    x = CombinatoricsUtils.binomialCoefficient((int) x, (int) parseFactor());
                else if (eat('P'))
                    x = ((CombinatoricsUtils.factorial((int) x)) / (CombinatoricsUtils.factorial((int) (x - parseFactor()))));
                else if (eat('%')) x %= parseFactor();

                return x;
            }
        }.parse();

    }

    // To update the screen and show the formula the user enters in real time
    private void updateformuladisplay() {

        formulascreen.setText(formuladisplay);

    }

    // To update the screen and show the result of the user's calculations
    private void updateresultdisplay() {

        resultscreen.setText(resultdisplay);

    }

    // To add the advanced operators (such as trig. functions) in a readable way (with parenthesis) and update the screen accordingly
    public void onClickadvop(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += operator + "(";
        updateformuladisplay();

    }

    // To add 'x10' to the formula so it is multiplied by 10
    public void onClickx10(View view) {

        formuladisplay += "x10^";
        updateformuladisplay();

    }

    // To add parenthesis to the formula the user enters when they click the parenthesis button
    public void onClickpar(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += operator;
        updateformuladisplay();

    }

    // To add the factorial symbol to the formula whe the user presses the factorial button
    public void onClickfact(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += "!";
        updateformuladisplay();

    }

    // To delete the last entered character in the formula when the user presses the 'DEL' button in case the user made a mistake and wants to correct it
    public void onClickDel(View view) {

        if (formuladisplay.length() >= 1) {

            formuladisplay = formuladisplay.substring(0, formuladisplay.length() - 1);
            updateformuladisplay();

        }

    }

    // To clear the entire formula and result screen
    private void clear() {

        formuladisplay = "";
        resultdisplay = "";

    }

    // Clears the screen using the clear() method above when the user presses the 'AC' button
    public void onClickClear(View view) {

        clear();
        updateformuladisplay();
        updateresultdisplay();

    }

    // To add a number corresponding to the button the user presses (0-9) and display it in the formula
    public void onClickNumber(View view) {

        Button b = (Button) view;

        if (formuladisplay.length() >= 0 && formuladisplay.length() <= 17) {

            formuladisplay += b.getText();
            updateformuladisplay();

        } else {

            updateformuladisplay();

        }

    }

    // To add an operator corresponding to the button the user presses (+, -, etc) and display it in the formula
    public void onClickOperator(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        formuladisplay += operator;
        updateformuladisplay();

    }

    // To add an exponent with a value corresponding to the button pressed by the user (2, 3 or custom) to a number and display it in the formula
    public void onClickspecpow(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        if (operator.equals("x²")) formuladisplay += "²";
        else if (operator.equals("x³")) formuladisplay += "³";
        else if (operator.equals("xⁿ")) formuladisplay += "^";


        updateformuladisplay();

    }

    // To display the result from the previous calculation and add it to the formula screen in case the user wants to use it for the calculation
    public void onClickAns(View view) {

        Button b = (Button) view;

        if (formuladisplay.length() >= 0 && formuladisplay.length() <= 10) {

            formuladisplay += prevAnswer;
            updateformuladisplay();

        } else {

            updateformuladisplay();

        }
    }

    // To display the appropriate text for nPr and nCr functions in the formula
    public void onClickn(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        if (operator.equals("nCr")) formuladisplay += "C";
        else if (operator.equals("nPr")) formuladisplay += "P";

        updateformuladisplay();

    }

    // To show the inverse functions on the formula display when the user long presses one of the advanced operator buttons
    public void onClickinv(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        if (operator.equals("sin")) formuladisplay += "sin⁻¹(";
        else if (operator.equals("cos")) formuladisplay += "cos⁻¹(";
        else if (operator.equals("tan")) formuladisplay += "tan⁻¹(";
        else if (operator.equals("√")) formuladisplay += "³√";

        updateformuladisplay();

    }

}
