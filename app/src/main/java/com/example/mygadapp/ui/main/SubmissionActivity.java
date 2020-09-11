package com.example.mygadapp.ui.main;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mygadapp.Models.Project;
import com.example.mygadapp.R;
import com.example.mygadapp.dialogs.ConfirmSubmissionDialog;
import com.example.mygadapp.dialogs.SubmissionSuccessDialog;
import com.example.mygadapp.dialogs.SubmissionWarningDialog;
import com.example.mygadapp.network.RequestInterface;
import com.example.mygadapp.network.Retro;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.text.TextUtils.isEmpty;

public class SubmissionActivity extends AppCompatActivity {

    private EditText First_name, Last_name, Email, GitLik;
    private Button backButton, submitButton;

    private RequestInterface second_instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submission);

        First_name = findViewById(R.id.tf_firstname);
        Last_name = findViewById(R.id.tf_lastname);
        Email = findViewById(R.id.tf_email);
        GitLik = findViewById(R.id.tf_git);
//        backButton = findViewById(R.id.backButton);
        submitButton = findViewById(R.id.submit_btn);

//        backButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SubmissionActivity.this, MainActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isEmpty(First_name.getText().toString()) || !isEmpty(Last_name.getText().toString())
                        || !isEmpty(Email.getText().toString()) || !isEmpty(GitLik.getText().toString())){
//                    submit();
                    ConfirmSubmissionDialog dialog = new ConfirmSubmissionDialog();
                    dialog.show(getSupportFragmentManager(), "Confirm Submission");
                }else {
                    makeToast("Please fill out all the fields");
                }
            }
        });
    }

    private boolean isEmpty(String s){
        return s.equals("");
    }

    public void submit(){
        second_instance = Retro.Retro_form()
                .create(RequestInterface.class);
        if (second_instance != null){
            second_instance.submitProject(First_name.getText().toString(), Last_name.getText().toString(), Email.getText().toString(),
                    GitLik.getText().toString(), new Callback<Project>() {
                        @Override
                        public void onResponse(Call<Project> call, Response<Project> response) {
                            SubmissionSuccessDialog dialog = new SubmissionSuccessDialog();
                            dialog.show(getSupportFragmentManager(), "Submission Success");
                        }

                        @Override
                        public void onFailure(Call<Project> call, Throwable t) {
                            SubmissionWarningDialog dialog = new SubmissionWarningDialog();
                            dialog.show(getSupportFragmentManager(), "Submission Error");
                        }
                    });
        }else {
            SubmissionWarningDialog dialog = new SubmissionWarningDialog();
            dialog.show(getSupportFragmentManager(), "Error submitting");
        }
    }

    private void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}