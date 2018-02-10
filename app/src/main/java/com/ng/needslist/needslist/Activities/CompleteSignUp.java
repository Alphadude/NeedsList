package com.ng.needslist.needslist.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.ng.needslist.needslist.Modal.UserInfo;
import com.ng.needslist.needslist.R;

import java.util.Random;

import de.hdodenhof.circleimageview.CircleImageView;

public class CompleteSignUp extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private DatabaseReference userRe;
    private CircleImageView userImage;
    private EditText nameEdt;
    private static final int REQUEST_CODE_PICKER = 0x8;
    private FirebaseStorage mStorerage;
    private StorageReference mStorageref, filePath;
    private Uri imageUri = null;
    private static final int MAX_LENGTH = 5;
    private ProgressDialog dialog;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_complete_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getIntent().hasExtra("name")){
            name = getIntent().getStringExtra("name");

        }else{
            name = "";
        }

        mAuth = FirebaseAuth.getInstance();
        userRe = FirebaseDatabase.getInstance().getReference().child("Users");
        mStorerage = FirebaseStorage.getInstance();
        mStorageref = mStorerage.getReference().child("Profile_Images");
        dialog = new ProgressDialog(this);



        userImage = (CircleImageView)findViewById(R.id.userImage);
        nameEdt = (EditText)findViewById(R.id.edtname);

        nameEdt.setText(name);

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent photo = new Intent(Intent.ACTION_PICK);
                photo.setType("image/*");
                startActivityForResult(photo,REQUEST_CODE_PICKER);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabComplete);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                saveUserInfo();

            }
        });
    }

    private void saveUserInfo() {
        dialog.setMessage("Saving your info.....");
        dialog.show();

        if (mAuth.getCurrentUser() != null) {
            if (imageUri != null) {

                String path = randomString();
                filePath = mStorageref.child(imageUri.getLastPathSegment() + path);
                filePath.putFile(imageUri).addOnSuccessListener(CompleteSignUp.this, new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                        String DeviceToken = FirebaseInstanceId.getInstance().getToken();
                        String url = taskSnapshot.getDownloadUrl().toString();
                        String userId = mAuth.getCurrentUser().getUid();
                        DatabaseReference currentUserDb = userRe.child(userId);
                        UserInfo userInfo = new UserInfo();
                        userInfo.setUrl(url);
                        userInfo.setName(nameEdt.getText().toString().trim());
                        userInfo.setDevice_token(DeviceToken);
                        currentUserDb.setValue(userInfo);
                        dialog.dismiss();
                        goFront();

                    }
                }).addOnFailureListener(CompleteSignUp.this, new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        dialog.dismiss();
                        Toast.makeText(CompleteSignUp.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                    }
                });

            } else {
                dialog.dismiss();
                Toast.makeText(CompleteSignUp.this, "Sorry, it looks like you need to pick an image to continue", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_PICKER && resultCode == RESULT_OK && data != null) {
            imageUri = data.getData();
            userImage.setImageURI(imageUri);
        }
    }

    public static String randomString() {
        Random generator = new Random();
        StringBuilder randomStringBuilder = new StringBuilder();
        int randomLength = generator.nextInt(MAX_LENGTH);
        char tempChar;
        for (int i = 0; i < randomLength; i++) {
            tempChar = (char) (generator.nextInt(96) + 32);
            randomStringBuilder.append(tempChar);
        }
        return randomStringBuilder.toString();
    }


    private void goFront() {
        //   startActivity(new Intent(CompleteSignup.this,Home.class));
        Intent goHomme = new Intent(CompleteSignUp.this, MainActivity.class);
        goHomme.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(goHomme);

    }
}
