package com.example.asconf;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FirstFragment extends Fragment {

    private final String confStr = "wireless_mac=4c:49:e3:fa:19:bc\n" +
            "bt_name=oneplus's sbt\n" +
            "bt_mac=88:88:88:87:87:77\n" +
            "gb_device_name=oneplus3\n" +
            "sc_android_id=2d7f5e12815e2b55\n" +
            "int-ro-ril-oem-imei=865441037374964\n" +
            "int-ro-ril-oem-imei1=865441037374964\n" +
            "int-ro-ril-oem-imei2=865441037374965\n" +
            "int-ro-display-series=OnePlus 3\n" +
            "int-ro-product-model=OnePlus A3010\n" +
            "int-ro-product-device=OnePlus A3010\n" +
            "int-ro-product-name=cm_oneplus3\n" +
            "int-ro-product-brand=OnePlus\n" +
            "int-ro-product-board=msm8888\n" +
            "int-ro-product-manufacturer=OnePlus\n" +
            "int-ro-product-system-brand=OnePlus\n" +
            "int-ro-product-system-manufacturer=OnePlus\n" +
            "int-ro-product-system-device=OnePlus A3010\n" +
            "int-ro-product-system-name=cm_oneplus3\n" +
            "int-ro-product-system-model=OnePlus A3010\n" +
            "int-ro-product-vendor-device=OnePlus A3010\n" +
            "int-ro-product-vendor-name=cm_oneplus3\n" +
            "int-ro-product-vendor-brand=OnePlus\n" +
            "int-ro-product-vendor-model=OnePlus A3010\n" +
            "int-ro-product-vendor-manufacturer=OnePlus\n" +
            "int-ro-product-odm-device=OnePlus A3010\n" +
            "int-ro-product-odm-name=OnePlus\n" +
            "int-ro-product-odm-model=OnePlus A3010\n" +
            "int-ro-product-odm-brand=OnePlus\n" +
            "int-ro-product-odm-manufacturer=OnePlus\n" +
            "int-ro-build-version-release=9\n" +
            "int-ro-build-product=OnePlus A3010\n" +
            "int-ro-build-fingerprint=OnePlus/cm_oneplus3/oneplus3:7.1.1/MOB31K/6a740217fc:user/test-keys\n" +
            "int-ro-bootimage-build-fingerprint=OnePlus/cm_oneplus3/oneplus3:7.1.1/MOB31K/6a740217fc:user/test-keys\n" +
            "int-ro-vendor-build-fingerprint=OnePlus/cm_oneplus3/oneplus3:7.1.1/MOB31K/6a740217fc:user/test-keys\n" +
            "int-gsm-sim-operator-iso$country=cn,\n" +
            "int-gsm-sim-operator-numeric=46000,\n" +
            "int-gsm-sim-operator-alpha=中国移动,\n" +
            "int-gsm-operator-iso$country=cn,\n" +
            "int-gsm-operator-numeric=46000,\n" +
            "int-gsm-operator-alpha=CHINAMOBILE,\n" +
            "int-gsm-network-type=LTE,Unknown\n" +
            "int-gsm-defaultpdpcontext-active=true\n" +
            "int-tel-mci=219105291\n" +
            "int-tel-mpci=133\n" +
            "int-tel-mtac=20951\n" +
            "int-tel-mearfcn=4018\n" +
            "int-tel-iccid=8668686\n" +
            "int-tel-imsi=89480311043282868888\n" +
            "int-tel-lac=20949\n" +
            "int-tel-cid=220692995\n" +
            "int-wireless-nb=testwifi1,testwifi2\n" +
            "int-tel-longitude=118.7486036\n" +
            "int-tel-latitude=32.0786284\n";

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // you should delete the conf file first, ie:
                // host$ adb root
                // host$ adb shell
                // phone# rm /storage/emulated/0/Podcasts/andd.conf

                String sdPath = Environment.getExternalStorageDirectory().getPath();

                File file = new File(sdPath, "Podcasts/andd.conf");

                // write default conf to /storage/emulated/0/Podcasts/andd.conf
                FileOutputStream confFile = null;
                try {
                    confFile = new FileOutputStream(file);
                    confFile.write(confStr.getBytes());
                    confFile.close();
                } catch (Exception e) {
                    Log.e("confFile", e.getMessage());
                    return;
                }

                // then you can check config file write succeed, ie:
                // host$ adb root
                // host$ adb shell
                // phone# cat /storage/emulated/0/Podcasts/andd.conf
                Log.i("confFile","config file write succeed!");
            }
        });
    }
}