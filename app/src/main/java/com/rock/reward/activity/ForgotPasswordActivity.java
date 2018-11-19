package com.rock.reward.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rock.reward.Api.ApiClient;
import com.rock.reward.Api.RewardRestInterface;
import com.rock.reward.R;
import com.rock.reward.ResponsePojo.ResponseForgotPassword;

import retrofit2.Call;
import retrofit2.Response;

/**
 * Created by rockers on 25/5/17.
 */

public class ForgotPasswordActivity extends AppCompatActivity {

    private RewardRestInterface restInterface;
    private String token;
    private EditText email;
    private Button resetPass;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        final Intent intent = getIntent();
        token = intent.getStringExtra("www-token");
        email =(EditText)findViewById(R.id.email);
        resetPass =(Button) findViewById(R.id.resetPass);

        resetPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                restInterface = ApiClient.getClient().create(RewardRestInterface.class);
                Call<ResponseForgotPassword> call = restInterface.ForgotPassword(token,email.getText().toString());
                call.enqueue(new retrofit2.Callback<ResponseForgotPassword>() {
                    @Override
                    public void onResponse(Call<ResponseForgotPassword> call, Response<ResponseForgotPassword> response) {
                        if(response.body().isSuccess()){
                            Toast.makeText(ForgotPasswordActivity.this, response.body().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }else{
                            response.body().getError_code();
                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseForgotPassword> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });
    }


}

