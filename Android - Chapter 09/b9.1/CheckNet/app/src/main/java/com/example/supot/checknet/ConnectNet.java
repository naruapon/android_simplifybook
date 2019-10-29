package com.example.supot.checknet;

import android.content.Context;
import android.net.ConnectivityManager;
/**
 * Created by supot on 26/7/2560.
 */
public class ConnectNet {
    private Context _context;
    public ConnectNet(Context context){
        this._context = context;
    }
    public boolean checkInternetConnect() {

        ConnectivityManager conMgr = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (conMgr.getActiveNetworkInfo() != null &&
                conMgr.getActiveNetworkInfo().isAvailable()
                && conMgr.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }

    }
}
