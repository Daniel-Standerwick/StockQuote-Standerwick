package com.example.stockquote_standerwick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    private Button GetQuote;
    private TextView Result;
    private EditText Symbol;
    private TextView[] stockInfo;
    private Stock toLookUp;
    private AsyncStocks AsyncGetData;
    private TextView NameR;
    private TextView LTPR;
    private TextView LTTR;
    private TextView ChangeR;
    private TextView WeekRangeR;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);

        GetQuote = (Button) findViewById (R.id.button);
        Result = (TextView) findViewById (R.id.ToReturn);
        Symbol = (EditText) findViewById (R.id.Symbol);

        NameR = (TextView) findViewById (R.id.Name);
        LTPR = (TextView) findViewById (R.id.LTPR);
        LTTR = (TextView) findViewById (R.id.LTTPR);
        ChangeR = (TextView) findViewById (R.id.Change);
        WeekRangeR = (TextView) findViewById (R.id.WeekRange);

        stockInfo = new TextView[]{Symbol, LTTR, LTPR, ChangeR, WeekRangeR, NameR};



        GetQuote.setOnClickListener (new View.OnClickListener ( ) {
            @Override
            public void onClick(View v) {
                toLookUp = new Stock (Symbol.getText().toString ());
                AsyncGetData = new AsyncStocks (toLookUp, stockInfo);
                AsyncGetData.execute();



            }
        });



    }
}
