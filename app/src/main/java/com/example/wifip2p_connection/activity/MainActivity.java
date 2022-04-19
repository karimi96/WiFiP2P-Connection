package com.example.wifip2p_connection.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.net.wifi.p2p.WifiP2pManager;
import android.os.Bundle;

import com.example.wifip2p_connection.R;
import com.example.wifip2p_connection.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private WifiManager wifiManager;
    private WifiP2pManager mManager;
    private WifiP2pManager.Channel mChannel;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initDataBinding();
        initWifiManager();
    }

    private void initDataBinding(){
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    private void initWifiManager(){
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        mManager = (WifiP2pManager) getSystemService(Context.WIFI_P2P_SERVICE);
        mChannel = mManager.initialize(this, getMainLooper(), null);
    }
}