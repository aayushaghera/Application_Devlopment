package com.example.async_task;

import androidx.appcompat.app.AppCompatActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnRun;
    private EditText editTextInTime;
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRun = findViewById(R.id.btn_run);
        editTextInTime = findViewById(R.id.editext_intime);
        textViewResult = findViewById(R.id.textview_result);

        // Create AsyncTask (similar to creating a thread object)
        btnRun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTaskRunner runner = new MyAsyncTaskRunner();
                String sleepTime = editTextInTime.getText().toString();
                runner.execute(sleepTime);
            }
        });
    }

    // Params, Progress, Result
    private class MyAsyncTaskRunner extends AsyncTask<String, String, String> {
        private String response;
        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(MainActivity.this, "Progress Dialog",
                    "Wait for " + editTextInTime.getText().toString() + " seconds");
        }

        @Override
        protected void onProgressUpdate(String... updateText) {
            textViewResult.setText(updateText[0]); // Update UI
        }

        @Override
        protected String doInBackground(String... params) {
            publishProgress("Sleeping..."); // Calls onProgressUpdate()
            try {
                int timeInSeconds = Integer.parseInt(params[0]);
                int timeInMillis = timeInSeconds * 1000;

                for (int i = 0; i < timeInSeconds; i++) {
                    Thread.sleep(1000); // Simulating background work
                    response = "Slept for " + (i + 1) + " of " + timeInSeconds + " seconds";
                    publishProgress(response); // Calls onProgressUpdate()
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
                response = e.getMessage();
            }
            return response;
        }

        @Override
        protected void onPostExecute(String result) {
            progressDialog.dismiss();
            textViewResult.setText(result); // Get final result
        }
    }
}
