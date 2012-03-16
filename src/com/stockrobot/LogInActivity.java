package com.stockrobot;

import mypackage.SceneManager.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LogInActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);

		Button login = (Button) findViewById(R.id.login_button);

		login.setOnClickListener(new OnClickListener() {
			public void onClick(View viewParam) {
				EditText usernameEditText = (EditText) findViewById(R.id.text_user);
				EditText passwordEditText = (EditText) findViewById(R.id.text_password);

				String sUserName = usernameEditText.getText().toString();
				String sPassword = passwordEditText.getText().toString();

				AlertDialog alert = new AlertDialog.Builder(LogInActivity.this)
						.create();
				alert.setMessage("Login Successed!");

				alert.setButton("Ok", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub

						Intent i = new Intent(getApplicationContext(),
								MenuActivity.class);
						startActivity(i);
					}

				});

				alert.show();

			}
		});

		TextView registerScreen = (TextView) findViewById(R.id.link_to_reg);

		registerScreen.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getApplicationContext(),
						RegisterActivity.class);
				startActivity(i);
			}

		});
	}

}