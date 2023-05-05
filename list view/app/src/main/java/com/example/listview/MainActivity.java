package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    PackageManager packageManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        packageManager = getPackageManager();

        //Pegando nomes dos apps instalados no sistemas
        ArrayList<String> appsNames = new ArrayList<>();
        List<ApplicationInfo> apps = packageManager.getInstalledApplications(PackageManager.GET_META_DATA);
        for (ApplicationInfo app : apps) {
            appsNames.add(app.loadLabel(packageManager).toString());
        }

        //Criando adapter
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, appsNames);

        //Adaptador Personalizado
        AppsAdapter customAdapter = new AppsAdapter(this, R.layout.list_layout, apps);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ApplicationInfo applicationInfo = (ApplicationInfo) adapterView.getItemAtPosition(i);
                String packageName = applicationInfo.packageName;
                Toast.makeText(MainActivity.this, "Abrindo o App", Toast.LENGTH_SHORT).show();

                Intent intent = packageManager.getLaunchIntentForPackage(packageName);
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Não foi possível abrir o aplicativo", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //Setando o adapter
        listView.setAdapter(customAdapter);
    }
}
