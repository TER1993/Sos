package com.spd.call;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.SystemProperties;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author xuyan
 */
public class MainActivity extends AppCompatActivity {

    private TextView mDescription;
    private EditText mName;
    private EditText mNumber;

    private EditText mName1;
    private EditText mNumber1;

    private EditText mName2;
    private EditText mNumber2;
    private Button mSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @SuppressLint("SetTextI18n")
    private void initView() {
//        mDescription = findViewById(R.id.textview_description);
//        mDescription.setText("    软件说明：" + "\n"
//                + "    此界面为添加紧急联系人界面。" + "\n"
//                + "    在下方输入栏中输入紧急联系人" + "\n"
//                + "    的联系方式并保存后，可通过长按" + "\n"
//                + "    机身右侧部一键SOS键进行拨打紧急" + "\n"
//                + "    电话。"
//        );

        mName = findViewById(R.id.edittext_name);
        mNumber = findViewById(R.id.edittext_number);

        mName.setText(SystemProperties.get(SosConstants.SOS_NAME, ""));
        mNumber.setText(SystemProperties.get(SosConstants.SOS_PHONE, ""));

        mName1 = findViewById(R.id.edittext_name1);
        mNumber1 = findViewById(R.id.edittext_number1);

        mName1.setText(SystemProperties.get(SosConstants.SOS_NAME1, ""));
        mNumber1.setText(SystemProperties.get(SosConstants.SOS_PHONE1, ""));

        mName2 = findViewById(R.id.edittext_name2);
        mNumber2 = findViewById(R.id.edittext_number2);

        mName2.setText(SystemProperties.get(SosConstants.SOS_NAME2, ""));
        mNumber2.setText(SystemProperties.get(SosConstants.SOS_PHONE2, ""));

        mSave = findViewById(R.id.button_save);

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = mName.getText().toString();
                String number = mNumber.getText().toString();

                String name1 = mName1.getText().toString();
                String number1 = mNumber1.getText().toString();

                String name2 = mName2.getText().toString();
                String number2 = mNumber2.getText().toString();

                if ("".equals(name) || "".equals(number)) {
                    if ("".equals(name1) || "".equals(number1)) {
                        if ("".equals(name2) || "".equals(number2)) {
                            Toast.makeText(MainActivity.this, "3组姓名和联系方式不能全为空", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                }

                SystemProperties.set(SosConstants.SOS_NAME, name);
                SystemProperties.set(SosConstants.SOS_PHONE, number);

                SystemProperties.set(SosConstants.SOS_NAME1, name1);
                SystemProperties.set(SosConstants.SOS_PHONE1, number1);

                SystemProperties.set(SosConstants.SOS_NAME2, name2);
                SystemProperties.set(SosConstants.SOS_PHONE2, number2);

                Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_SHORT).show();

            }
        });

    }


}
