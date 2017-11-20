package com.cl.mywebview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * @author admin
 */
public class MainActivity extends AppCompatActivity {

    private String mUrl = "https://e.czbank.com/weixinHTML/outInterface/creditCardApplyTemplateOutside.html?wxRecommenderId=H1868&wxCreditCardActivtyNo=CZ02&apOrigin=95527";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button webView = (Button) findViewById(R.id.btn_web_view);
        Button agentWeb = (Button) findViewById(R.id.btn_agent_web);
        Button btnHtml = (Button) findViewById(R.id.btn_html);

        webView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, WebViewActivity.class);
                intent.putExtra("URL", mUrl);
                startActivity(intent);
            }
        });

        agentWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AgentWebActivity.class);
                intent.putExtra("URL", mUrl);
                startActivity(intent);
            }
        });

        btnHtml.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HtmlActivity.class);
                startActivity(intent);
            }
        });
    }
}
