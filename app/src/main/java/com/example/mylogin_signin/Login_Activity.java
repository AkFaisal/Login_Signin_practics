package com.example.mylogin_signin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mylogin_signin.DataBase.DatabaseHelper;
import com.example.mylogin_signin.databinding.ActivityLoginBinding;

public class Login_Activity extends AppCompatActivity {
    //private Button facebookButton;
//private Button googleButton;
//private Button twitterButton;
//
//private TextView creatAccount;
//    private EditText email ,password;




    private ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login_);


        databaseHelper=new DatabaseHelper(this);
        //Login button........
//      binding.loginButtonID.setOnClickListener(new View.OnClickListener() {
//          @Override
//          public void onClick(View v) {
//
//              if(email.equals(binding.loginEmailEditTextID)&&password.equals(binding.loginPasswordEditTextID)){
//
//
//                  if(binding.rememberMeID.isChecked()){
//                      SharePrefarence sharePrefarence =new SharePrefarence(Login_Activity.this);
//                    sharePrefarence.setName("userNamedata");
//                      sharePrefarence.setPassword("userPassworddata");
//
//
//`
//
//                  }
//              }
//          }
//      });



        // Facebook,Google,Twitter loging Button........

        binding.facebookButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Login_Activity.this, "API not connected", Toast.LENGTH_SHORT).show();

            }
        });

        binding.googleButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Login_Activity.this, "API not connected", Toast.LENGTH_SHORT).show();

            }
        });

        binding.twitterButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(Login_Activity.this, "API not connected", Toast.LENGTH_SHORT).show();

            }
        });


        //create Account Intent.........
        binding.creatAccountTextID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(Login_Activity.this, Registration_Activity.class);
                startActivity(intent);
            }
        });


        //login Intent and share preference and database.........
        binding.loginButtonID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                String email=binding.loginEmailEditTextID.getText().toString();
                String password=binding.loginPasswordEditTextID.getText().toString();
                boolean result=databaseHelper.findPassword(email,password); //after Regeneration  when data is save and given for login

//if(result==true){
//
//    Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
//}
//else  Toast.makeText(getApplicationContext(),"Invalid Email or Password",Toast.LENGTH_SHORT).show();
//


                if (result==true) {

                    if(binding.rememberMeID.isChecked()){

                      SharePrefarence sharePrefarence =new SharePrefarence(Login_Activity.this);
                      sharePrefarence.setName("userNamedata");
                      sharePrefarence.setPassword("userPassworddata");
                        Intent intent = new Intent(Login_Activity.this, Profile_Activity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();

                    }
                    else{
                        Intent intent = new Intent(Login_Activity.this, Profile_Activity.class);
                        startActivity(intent);
                        Toast.makeText(getApplicationContext(),"Login Successful",Toast.LENGTH_SHORT).show();
                    }

                }
                else
                {

                    Toast.makeText(getApplicationContext(),"Invalid Email or Password",Toast.LENGTH_SHORT).show();
                }



            }
        });

        //.............................................

        //Adding logo in action bar.......
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_cash);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        //........................



    }
}
