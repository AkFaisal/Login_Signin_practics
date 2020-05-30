package com.example.mylogin_signin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.example.mylogin_signin.databinding.ActivityProfileBinding;

public class Profile_Activity extends AppCompatActivity {

    private ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_profile_);


        binding.profileNameTextID.setText(getIntent().getStringExtra("registraton_Info_First_name"));
        binding.profileLastNameID.setText(getIntent().getStringExtra("registraton_Info_Last_name"));
        binding.profileEmailTextID.setText(getIntent().getStringExtra("registraton_Info_email"));
        binding.profilePhoneTextID.setText(getIntent().getStringExtra("registraton_Info_phone"));
        binding.profileGenderTextID.setText(getIntent().getStringExtra("registraton_Info_gender_male_female"));
        binding.BirthID.setText(getIntent().getStringExtra("birth_Of_Date"));

        //Adding back button in Action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //.............
    }








//menue for logout & back option in action bar.......................
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater menuInflater =getMenuInflater();

        menuInflater.inflate(R.menu.menu_layout, menu);


        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId()==R.id.settingId){

            Toast.makeText(Profile_Activity.this,"You Click On setting",Toast.LENGTH_SHORT).show();

        }
        if(item.getItemId()==R.id.shareId){

            Toast.makeText(Profile_Activity.this,"You Click On Share",Toast.LENGTH_SHORT).show();

        }
        if(item.getItemId()==R.id.logoutId){


            Toast.makeText(Profile_Activity.this,"Logout Successful ",Toast.LENGTH_SHORT).show();

            //logout sharrepreference  in menue bar...............
            SharePrefarence sharePrefarence=new SharePrefarence(Profile_Activity.this).logout();

            Intent intent=new Intent(Profile_Activity.this,Login_Activity.class);
            startActivity(intent);
           //...................

        }
        if(item.getItemId()==R.id.aboutusId){

            Toast.makeText(Profile_Activity.this,"You Click On AboutUs",Toast.LENGTH_SHORT).show();

        }
        //Adding back button in Action bar
        if(item.getItemId()==android.R.id.home){

            this.finish();
        }
        //..............

        return super.onOptionsItemSelected(item);
    }
    //.................................




}
