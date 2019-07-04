package com.example.caculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.caculator.caculator.caculator;

public class BasicCaculatorActivity extends AppCompatActivity {

    caculator ca = new caculator();
    TextView  express;
    TextView  result;
    TableLayout table;
    TableRow tablerow2;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_caculator);
        express = findViewById(R.id.expresstext);
        result= findViewById(R.id.resulttex);
        table = findViewById(R.id.table);
        tablerow2 = findViewById(R.id.tableRow2);
        table.setColumnCollapsed(0,true);
        tablerow2.setVisibility(View.GONE);
    }
    public void sendMessage(View view)
    {
        String o = ((Button)view).getText().toString();
        if (o.equals("C"))
        {
            ca.claer();
            result.setText("");
            express.setText("");
            return;
        }
        if (o.equals("=")  )
        {
            if(!(result.getText().equals("err")||result.getText().equals("")))
            {
                ca.claer();
                ca.editExpree(result.getText().toString());
                express.setText(result.getText().toString());
                result.setText("");
            }

            return;
        }
        if (o.equals("B"))
        {
            ca.backspace();
        }
        else
        {
            ca.editExpree(o);
        }

        express.setText(ca.gete());
        String r = ca.exe();
        if (r == null)
            r = "err";
        result.setText( r );


    }
    public void switchMode(View view)
    {
        if (table.isColumnCollapsed(0) == true)
        {
            table.setColumnCollapsed(0,false);
            tablerow2.setVisibility(View.VISIBLE);
        }else
        {
            table.setColumnCollapsed(0,true);
            tablerow2.setVisibility(View.GONE);
        }

    }
}
