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
        switch (intent.getIntExtra("number", 0)) {
            case 0: {
                String str = SystemProperties.get(SosConstants.SOS_PHONE, "10086");
                Intent intent2 = new Intent("android.intent.action.CALL");
                String sb = "tel:" + str;
                intent2.setData(Uri.parse(sb));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
            break;
            case 1: {
                String str = SystemProperties.get(SosConstants.SOS_PHONE1, "10086");
                Intent intent2 = new Intent("android.intent.action.CALL");
                String sb = "tel:" + str;
                intent2.setData(Uri.parse(sb));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
            break;
            case 2: {
                String str = SystemProperties.get(SosConstants.SOS_PHONE2, "10086");
                Intent intent2 = new Intent("android.intent.action.CALL");
                String sb = "tel:" + str;
                intent2.setData(Uri.parse(sb));
                intent2.addFlags(268435456);
                context.startActivity(intent2);
            }
            break;
            default:
                break;
        }


    }
}
