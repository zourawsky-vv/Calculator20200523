package com.example.homework20200523;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import static java.lang.Character.isDigit;

public class Table_Calculator extends Activity {
    private TextView textViewStack;
    private TextView textViewRes;

    private String sign;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_calc);

        textViewStack = findViewById(R.id.stack);
        textViewRes = findViewById(R.id.res);

        sign = getResources().getString(R.string.plus);
    }

    public void click(View view) {
        switch (view.getId()) {
            case R.id.butClear :
                clearStack();
                break;
            case R.id.butBS :
                if (textViewStack.getText().length() != 0 && isDigit(textViewStack.getText().charAt(textViewStack.getText().length() - 1)))
                    textViewStack.setText(textViewStack.getText().subSequence(0, textViewStack.getText().length()-1));
                break;
            case R.id.butPers :
                textViewStack.append(getResources().getString(R.string.pers));
                textViewRes.setText(Integer.parseInt(textViewRes.getText().toString()) * 100);
                break;
            case R.id.butPlus :
                if (textViewStack.getText().length() - 1 == -1) break;
                operation(sign);
                sign = getResources().getString(R.string.plus);
                textViewStack.append(sign);
                break;
            case R.id.but1 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str1));
                break;
            case R.id.but2 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str2));
                break;
            case R.id.but3 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str3));
                break;
            case R.id.butMinus :
                if (textViewStack.getText().length() - 1 == -1) break;
                operation(sign);
                sign = getResources().getString(R.string.minus);
                textViewStack.append(sign);
                break;
            case R.id.but4 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str4));
                break;
            case R.id.but5 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str5));
                break;
            case R.id.but6 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str6));
                break;
            case R.id.butMult :
                if (textViewStack.getText().length() - 1 == -1) break;
                operation(sign);
                sign = getResources().getString(R.string.mult);
                textViewStack.append(sign);
                break;
            case R.id.but7 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str7));
                break;
            case R.id.but8 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str8));
                break;
            case R.id.but9 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str9));
                break;
            case R.id.butDiv :
                if (textViewStack.getText().length() - 1 == -1) break;
                operation(sign);
                sign = getResources().getString(R.string.div);
                textViewStack.append(sign);
                break;
            case R.id.but0 :
                afterEq();
                textViewStack.append(getResources().getString(R.string.str0));
                break;
            case R.id.butEq :
                if (textViewStack.getText().length() - 1 == -1) break;
                operation(sign);
                sign = getResources().getString(R.string.eq);
                textViewStack.append(sign);
                break;
        }
    }

    private void operation(String sign) {
        int ePos = textViewStack.getText().length() - 1;
        if (isDigit(textViewStack.getText().charAt(ePos))) {
            int sPos = ePos;
            do {
                sPos--;
            } while (sPos != -1 && isDigit(textViewStack.getText().charAt(sPos)));
            sPos++;

            int val = 0;
            Integer val1 = Integer.parseInt(textViewRes.getText().toString());
            Integer val2 = Integer.parseInt(textViewStack.getText().subSequence(sPos, ePos+1).toString());
            switch (sign) {
                case "+" :
                    val = Integer.parseInt(textViewRes.getText().toString()) +
                            Integer.parseInt(textViewStack.getText().subSequence(sPos, ePos+1).toString());
                    break;
                case "-" :
                    val = Integer.parseInt(textViewRes.getText().toString()) -
                            Integer.parseInt(textViewStack.getText().subSequence(sPos, ePos+1).toString());
                    break;
                case "*" :
                    val = Integer.parseInt(textViewRes.getText().toString()) *
                            Integer.parseInt(textViewStack.getText().subSequence(sPos, ePos+1).toString());
                    break;
                case "/" :
                    if (Integer.parseInt(textViewStack.getText().subSequence(sPos, ePos+1).toString()) == 0) break;

                    val = Integer.parseInt(textViewRes.getText().toString()) /
                            Integer.parseInt(textViewStack.getText().subSequence(sPos, ePos+1).toString());
                    break;
            }
            textViewRes.setText(String.format("%d",val));
        }
        else {
            textViewStack.setText(textViewStack.getText().subSequence(0, textViewStack.getText().length() - 1));
        }
    }
    private void clearStack() {
        textViewStack.setText(R.string.empty);
        textViewRes.setText(R.string.str0);
    }
    private void afterEq() {
        if (textViewStack.getText().length() !=0 &&
                textViewStack.getText().charAt(textViewStack.getText().length() - 1) == '=') {
            clearStack();
            sign = getResources().getString(R.string.plus);
        }
    }
}
