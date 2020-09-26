package com.example.ps2bidespus;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        up();
        LinearLayout upload = findViewById(R.id.upload);
        LinearLayout download =findViewById(R.id.download);
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goUpload = new Intent(Home.this, UploadDoc.class);
                startActivity(goUpload);
                finish();
            }
        });
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent goDownload = new Intent(Home.this, vView.class);
                startActivity(goDownload);
                finish();
            }
        });
    }
    public void Logout(View view) {
        final AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
        builder.setTitle("Reminder");
        builder.setMessage("Apakah anda yakin ingin logout?");
        builder.setCancelable(true);
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sharedSession getOut = new sharedSession(Home.this);
                getOut.removeSession();

                Intent backHome = new Intent(Home.this,LoginActivity.class);
                startActivity(backHome);
                finish();
            }
        });
        AlertDialog showup = builder.create();
        showup.show();
    }
    public void up(){
        final AlertDialog.Builder notifikasi = new AlertDialog.Builder(Home.this);
        notifikasi.setTitle("Pemberitahuan");
        notifikasi.setMessage("Aplikasi ini masih dalam tahap pengembangan. untuk itu ada beberapa fitur yang tidak dapat digunakan untuk beberapa waktu. kami akan mengupdate dalam waktu dekat, Salam dan Terimakasih");
        notifikasi.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //signature adam amir
            }
        });
        AlertDialog keluar = notifikasi.create();
        keluar.show();
    }
    public void down(){
        final AlertDialog.Builder notifikasi = new AlertDialog.Builder(Home.this);
        notifikasi.setTitle("Pemberitahuan");
        notifikasi.setMessage("Fitur ini dalam tahap pengembangan tunggu informasi selanjutnya");
        notifikasi.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //signature adam amir
            }
        });
        AlertDialog keluar = notifikasi.create();
        keluar.show();
    }

    public void kontaksp(View view) {
        down();
    }
}