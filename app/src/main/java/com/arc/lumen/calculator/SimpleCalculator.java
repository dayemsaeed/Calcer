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
    private String display = "";
    private String currentOperator = "";
    private String result = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.simple_calculator, container, false);

        _screen = (TextView) view.findViewById(R.id.textView);
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
                onClickDecimal(v);
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

        if (result != "") {

            clear();
            updateScreen();

        }

        Button b = (Button) view;
        display += b.getText();
        updateScreen();

    }

    public void onClickDecimal(View view) {

        if (result != "") {

            clear();
            updateScreen();

        }

        Button b = (Button) view;
        display += b.getText();
        updateScreen();

    }

    public void onClickBackspace(View view) {

        int length = display.length();

        if (length >= 1) {

            display = display.substring(0, length - 1);
            updateScreen();

        }

        else {

            //Toast toast = Toast.makeText(this, "Please enter some numbers first", Toast.LENGTH_SHORT);
            //toast.show();

        }

    }

    private boolean isOperator(char op) {

        switch (op) {

            case '+':
                return true;

            case '-':
                return true;

            case 'x':
                return true;

            case '÷':
                return true;

            case '%':
                return true;

            case '^':
                return true;

            case '√':
                return true;

            default:
                return false;

        }

    }

    public void onClickOperator(View view) {

        if (display == "") return;

        Button b = (Button) view;


        if (result != "") {

            String _display = result;
            clear();
            display = _display;

        }

        if (currentOperator != "") {

            if (isOperator(display.charAt(display.length() - 1))) {

                display = display.replace(display.charAt(display.length() - 1), b.getText().charAt(0));
                updateScreen();
                return;

            }

            else {

                getResult();
                display = result;
                result = "";

            }

            currentOperator = b.getText().toString();

        }

        display += b.getText();
        currentOperator = b.getText().toString();
        updateScreen();

    }

    private void clear() {

        display = "";
        currentOperator = "";
        result = "";

    }

    public void onClickClear(View view) {

        clear();
        updateScreen();

    }

    private double operate(String a, String b, String op) {

        switch (op) {

            case "+":
                return Double.valueOf(a) + Double.valueOf(b);

            case "-":
                return Double.valueOf(a) - Double.valueOf(b);

            case "x":
                return Double.valueOf(a) * Double.valueOf(b);

            case "÷":
                return Double.valueOf(a) / Double.valueOf(b);

            case "%":
                return Double.valueOf(a) % Double.valueOf(b);

            case "^":
                return Math.pow(Double.valueOf(a), Double.valueOf(b));

            case "√":
                return Math.sqrt(Double.valueOf(a));

            default:
                return -1;


        }

    }

    private boolean getResult() {

        DecimalFormat res = new DecimalFormat("#,###,###,###.######");

        if (currentOperator == "") return false;

        String[] operation = display.split(Pattern.quote(currentOperator));

        if (operation.length < 2) return false;

        result = String.valueOf(operate(operation[0], operation[1], currentOperator));

        return true;

    }

    public void onClickEquals(View view) {

        int length = result.length();

        if (display == "") return;

        if(!getResult()) return;

        if (length <= 10) {

            _screen.setText(String.valueOf(result));

        }

        else {

            result = result.substring(0, 9);
            _screen.setText(String.valueOf(result));

        }

    }

}
