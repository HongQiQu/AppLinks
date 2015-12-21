package com.ihongqiqu.applinks;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Uri deeplink = intent.getData();
        if (deeplink != null) {
            parseDeepLink(deeplink);
        }
    }

    private void parseDeepLink(Uri deeplink) {
        // The path of the deep link, e.g. '/products/detail?key=google'
        String path = deeplink.getPath();
        String latPathSegment = deeplink.getLastPathSegment();
        String value1 = deeplink.getQueryParameter("key");

        Toast.makeText(this,
                "path : " + path
                + "\n lastPathSegment : " + latPathSegment
                + "\n value1 : " + value1,
                Toast.LENGTH_SHORT).show();
    }

}
