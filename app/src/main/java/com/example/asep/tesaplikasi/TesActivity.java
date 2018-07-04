package com.example.asep.tesaplikasi;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TesActivity extends AppCompatActivity implements View.OnClickListener {
    Button camera;
    ImageView gambar;
    static  int media_image=100;
    static  int media_video=200;
    static  String directory="Hello_Camera";
    static int request_image=1;
    static int request_video=2;
    Uri fileUri;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tes);

        TextView txt = findViewById(R.id.textView1);
        Intent intent = getIntent();
        String s = intent.getStringExtra("helo");
        txt.setText(s);

        camera= findViewById(R.id.button3);
        gambar = findViewById(R.id.imageView);
        camera.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        if(view==camera){
            CaptureImage();
        }
    }
    public void CaptureImage(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        this.fileUri = getMediaFileUri(media_image);
        intent.putExtra("output",this.fileUri);
        startActivityForResult(intent,request_image);
    }
    public Uri getMediaFileUri(int meditype){
        return Uri.fromFile(getFileUri(meditype));
    }
    public File getFileUri(int mediatype){
        File mediaStorage = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),directory);
        if (mediaStorage.exists()||mediaStorage.mkdirs()){
            String timesmap = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            if (mediatype==media_image){
                return new File(mediaStorage.getPath() +File.separator + "IMG" + timesmap + ".jpg");
            }
            return null;
        }
        Log.d("error","gagal membuat directory");
        return null;
    }
    public  void onActivityResult(int requestCode,int result_code,Intent data){
        if (requestCode == request_image){
            gambar.setImageBitmap(BitmapFactory.decodeFile(this.fileUri.getPath()));
        }else {
            Toast.makeText(getApplicationContext(),"user Cancled Img Capture",Toast.LENGTH_SHORT).show();
        }
    }




}
