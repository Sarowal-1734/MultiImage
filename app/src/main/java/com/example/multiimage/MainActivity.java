package com.example.multiimage;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;

    private ArrayList<Uri> imageUris;    // Store image uris in this array list
    public static final int PICK_IMAGES_CODE = 1;   // Request code to pick image
    int count;   // number of picked image

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        imageView3 = findViewById(R.id.imageView3);
        imageView4 = findViewById(R.id.imageView4);
        imageView5 = findViewById(R.id.imageView5);
        imageUris = new ArrayList<>();
    }

    //Add photos from gallery...
    public void onAddPhotoButtonClick(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select image(s)"), PICK_IMAGES_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGES_CODE && resultCode == RESULT_OK) {
            if (data.getClipData() != null) {
                // picked multiple images
                count = data.getClipData().getItemCount();  // number of picked image
                for (int i = 0; i < count; i++) {
                    Uri imageUri = data.getClipData().getItemAt(i).getUri();  // get image uri at specific index
                    imageUris.add(imageUri);   // Adding the image uri to array list
                }
                if (count == 1)
                    imageView1.setImageURI(imageUris.get(0));
                else if (count == 2){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                }
                else if (count == 3){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                    imageView3.setImageURI(imageUris.get(2));
                }
                else if (count == 4){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                    imageView3.setImageURI(imageUris.get(2));
                    imageView4.setImageURI(imageUris.get(3));
                }
                else if (count == 5){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                    imageView3.setImageURI(imageUris.get(2));
                    imageView4.setImageURI(imageUris.get(3));
                    imageView5.setImageURI(imageUris.get(4));
                }
            } else {
                // picked single image
                Uri imageUri = data.getData();
                imageUris.add(imageUri);
                count = imageUris.size();  // number of picked image
                Toast.makeText(this, ""+count, Toast.LENGTH_SHORT).show();
                if (count == 1)
                    imageView1.setImageURI(imageUris.get(0));
                else if (count == 2){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                }
                else if (count == 3){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                    imageView3.setImageURI(imageUris.get(2));
                }
                else if (count == 4){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                    imageView3.setImageURI(imageUris.get(2));
                    imageView4.setImageURI(imageUris.get(3));
                }
                else if (count == 5){
                    imageView1.setImageURI(imageUris.get(0));
                    imageView2.setImageURI(imageUris.get(1));
                    imageView3.setImageURI(imageUris.get(2));
                    imageView4.setImageURI(imageUris.get(3));
                    imageView5.setImageURI(imageUris.get(4));
                }
            }
        }
    }
}