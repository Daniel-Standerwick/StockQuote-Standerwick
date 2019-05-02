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
            theStock.load ();
            return theStock;
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    protected void onPostExecute(Stock s){
        super.onPostExecute (s);
        info[0].setText (theStock.getSymbol ());
        info[1].setText (theStock.getLastTradeTime ());
        info[2].setText (theStock.getLastTradePrice ());
        info[3].setText (theStock.getChange ());
        info[4].setText (theStock.getRange ());
        info[5].setText (theStock.getName ());
    }


}
