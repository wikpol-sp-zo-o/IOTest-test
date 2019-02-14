package com.user.serialization;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Arrays;

import Moka7.*;

public class MainActivity extends AppCompatActivity {

    S7Client s7Client;

    //S7.S7AreaPE - inputs;
    //S7.S7AreaPA - outputs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        s7Client = new S7Client();

    }

    @Override
    protected void onResume() {
        super.onResume();

        connectPLC();

    }


    private void connectPLC() {

        Log.e("connectPLC" , String.valueOf(s7Client.Connected));

        new ConnectPLC().execute();

    }

    private class ConnectPLC extends AsyncTask<Object, Object, Object> {

        String ret = "";

        @Override
        protected Object doInBackground(Object... params) {

            int res = s7Client.ConnectTo ("192.168.1.208", 0, 0);

            if (res == 0) {

                ret = "Connect OK: " + S7Client.ErrorText(res);

            } else {

                ret = "ERROR: " + S7Client.ErrorText(res);

            }

            return null;
        }

        @Override
        protected void onPostExecute(Object o) {
            super.onPostExecute(o);

            TextView txout2 = (TextView) findViewById (R.id.tvText2);
            txout2.setText (ret);

            Log.e("connectPLC" , String.valueOf(s7Client.Connected));


            //new WriteToPLC().execute();
            new ReadFromPLC().execute();


        }

    }


    private class WriteToPLC extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground (String... params) {

            Log.e("WriteToPLC" , "start");
            Log.e("PDULength" , String.valueOf(s7Client.PDULength()));

            byte[] data = new byte[2];

            Log.e("WriteToPLC" , "data - " + Arrays.toString(data));

            //S7.SetBitAt(data, 1, 1, true);
            S7.SetBitAt(data, 0, 0, true);

            Log.e("WriteToPLC" , "data - " + Arrays.toString(data));

            //int res = s7Client.WriteArea(S7.S7AreaPA, 0, 0, 2, data);
            int res = s7Client.WriteArea(S7.S7AreaPE, 0, 0, 2, data);

            return String.valueOf(res);
        }

        @Override
        protected void onPostExecute (String result) {
            super.onPostExecute(result);

            Log.e("WriteToPLC", result);
            Log.e("WriteToPLC", "ERROR - " + S7Client.ErrorText(Integer.parseInt(result)));

        }

    }


    private class ReadFromPLC extends AsyncTask<String, String, String> {

        boolean[] result_0 = new boolean[8];
        boolean[] result_1 = new boolean[5];

        @Override
        protected String doInBackground (String... params) {

            Log.e("ReadFromPLC" , "start");
            Log.e("PDULength" , String.valueOf(s7Client.PDULength()));

            int res;
            byte[] data = new byte[2];

            Log.e("ReadFromPLC" , "data - " + Arrays.toString(data));

            res = s7Client.ReadArea(S7.S7AreaMK, 0, 0, 0, data);

            Log.e("ReadFromPLC" , "res - " + res);
            Log.e("ReadFromPLC" , "ERROR - " + S7Client.ErrorText(res));
            Log.e("ReadFromPLC" , "data - " + Arrays.toString(data));

            res = s7Client.ReadArea(S7.S7AreaMK, 0, 0, 0, data);

            Log.e("ReadFromPLC" , "res - " + res);
            Log.e("ReadFromPLC" , "ERROR - " + S7Client.ErrorText(res));
            Log.e("ReadFromPLC" , "data - " + Arrays.toString(data));

            /*
            result_0[0] = S7.GetBitAt(data, 0, 0);
            result_0[1] = S7.GetBitAt(data, 0, 1);
            result_0[2] = S7.GetBitAt(data, 0, 2);
            result_0[3] = S7.GetBitAt(data, 0, 3);
            result_0[4] = S7.GetBitAt(data, 0, 4);
            result_0[5] = S7.GetBitAt(data, 0, 5);
            result_0[6] = S7.GetBitAt(data, 0, 6);
            result_0[7] = S7.GetBitAt(data, 0, 7);

            result_1[0] = S7.GetBitAt(data, 1, 0);
            result_1[1] = S7.GetBitAt(data, 1, 1);
            result_1[2] = S7.GetBitAt(data, 1, 2);
            result_1[3] = S7.GetBitAt(data, 1, 3);
            result_1[4] = S7.GetBitAt(data, 1, 4);
            */

            return null;
        }

        @Override
        protected void onPostExecute (String result) {
            super.onPostExecute(result);

            Log.e("DATA 0", Arrays.toString(result_0));
            Log.e("DATA 1", Arrays.toString(result_1));

        }

    }


}
