package com.example.stockquote_standerwick;

import android.os.AsyncTask;
import android.widget.TextView;

public class AsyncStocks extends AsyncTask<Stock, Void, Stock> {

    private Stock theStock;
    private TextView[] info;

    public AsyncStocks(Stock theStock, TextView[] info) {
        this.info = info;
        this.theStock = theStock;
    }

    @Override
    protected Stock doInBackground(Stock... stocks) {

        try{
            theStock.load ( );
            return theStock;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(Stock s){
        super.onPostExecute (s);
        info[0].setText (s.getSymbol ());
        info[1].setText (s.getLastTradeTime ());
        info[2].setText (s.getLastTradePrice ());
        info[3].setText (s.getChange ());
        info[4].setText (s.getRange ());
        info[5].setText (s.getName ());
    }


}
