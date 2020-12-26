package com.example.userinterface1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText value1, value2;
    Button btn1, btn2, btn3, btn4, btn5;
    TextView textResult;
    String num1, num2;
    Float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("초간단 계산기(수정_홍예진)");
        value1 = findViewById(R.id.value1);
        value2 = findViewById(R.id.value2);
        textResult = findViewById(R.id.result);
    }

    public void onClick(View target){
        num1 = value1.getText().toString();
        num2 = value2.getText().toString();

        if(num1.length()==0 || num2.length()==0)
            Toast.makeText(getApplicationContext(), "값을 입력해주세요.", Toast.LENGTH_SHORT).show();
        else {
            switch(target.getId()){
                case R.id.plus:
                    result = Float.parseFloat(num1)+Float.parseFloat(num2);
                    break;
                case R.id.subtract:
                    result = Float.parseFloat(num1)-Float.parseFloat(num2);
                    break;
                case R.id.division:
                    if(Float.parseFloat(num2) == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        result = Float.parseFloat(num1) / Float.parseFloat(num2);
                        break;
                    }
                case R.id.multiply:
                    result = Float.parseFloat(num1)*Float.parseFloat(num2);
                    break;
                case R.id.remainder:
                    if(Float.parseFloat(num2) == 0) {
                        Toast.makeText(getApplicationContext(), "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        break;
                    }
                    else {
                        result = Float.parseFloat(num1)%Float.parseFloat(num2);
                        break;
                    }
            }
            textResult.setText("계산 결과 : "+result.toString());
        }
    }


}