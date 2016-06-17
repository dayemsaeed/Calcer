package com.arc.lumen.calculator;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.util.regex.Pattern;

/**
 * Created by dayem on 5/20/16 at 6:37 PM.
 */
public class SimpleCalculator extends Fragment {

    // Variables for simple calculator
    private TextView _screen;
    private String operator;
    private String display = "";
    private Double result;
    DecimalFormat res = new DecimalFormat("##########.######");

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_calculator, container, false);

        _screen = view.findViewById(R.id.textView);
        updateScreen();

        // OnClick Listeners for numbers
        view.findViewById(R.id.button0).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button6).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button7).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button8).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        view.findViewById(R.id.button9).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickNumber(v);
            }
        });

        // OnClick listeners for operators.
        view.findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.buttonSubtract).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.buttonMultiply).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.buttonMod).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.buttonDivide).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.buttonPow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        // OnClick listeners for decimal and equals
        view.findViewById(R.id.buttonDecimal).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickOperator(v);
            }
        });

        view.findViewById(R.id.buttonEquals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickEquals(v);
            }
        });

        // OnClick listeners for delete and clear
        view.findViewById(R.id.buttonDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickBackspace(v);
            }
        });

        view.findViewById(R.id.buttonClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickClear(v);
            }
        });

        return view;
    }

    private void updateScreen() {

        _screen.setText(display);

    }

    public void onClickNumber(View view) {

        Button b = (Button) view;

        if (display.length() >= 0 && display.length() <= 17) {

            display += b.getText();
            updateScreen();

        } else {

            updateScreen();

        }

    }

    public void onClickBackspace(View view) {

        if (display.length() >= 1) {

            display = display.substring(0, display.length() - 1);
            updateScreen();

        }

    }

    public void onClickOperator(View view) {

        Button b = (Button) view;

        operator = b.getText().toString();

        display += operator;
        updateScreen();

    }

    private void clear() {

        display = "";

    }

    public void onClickClear(View view) {

        clear();
        updateScreen();

    }

    private boolean getResult() {

        if (operator.equals("")) return false;

        String[] operation = display.split(Pattern.quote(operator));

        if (operation.length < 2 && operator.equals("x") || operation.length < 2 && operator.equals("+") || operation.length < 2 && operator.equals("-") || operation.length < 2 && operator.equals("÷") || operation.length < 2 && operator.equals("C") || operation.length < 2 && operator.equals("P"))
            return false;
        else if (operation.length < 1) return false;

        result = eval(display);
        display = String.valueOf(res.format(result));

        return true;

    }

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
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('x')) x *= parseFactor(); // multiplication
                    else if (eat('÷')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());
                else if (eat('%')) x %= parseFactor();

                return x;
            }
        }.parse();

    }

    public void onClickEquals(View view) {

        getResult();
        updateScreen();

    }

}
