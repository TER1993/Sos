package com.spd.call;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.SystemProperties;
import android.util.Log;

/**
 * @author xuyan
 */
public class SosReceiver extends BroadcastReceiver {

    @SuppressLint("WrongConstant")
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("sos", "receive sos");
        String str = SystemProperties.get(SosConstants.SOS_PHONE, "10086");
        Intent intent2 = new Intent("android.intent.action.CALL");
        StringBuilder sb = new StringBuilder();
        sb.append("tel:");
        sb.append(str);
        intent2.setData(Uri.parse(sb.toString()));
        intent2.addFlags(268435456);
        context.startActivity(intent2);
    }
}
