package hridoy.aiz.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText etName,etCell;
    Button btnSubmit,btnShowData,btnEditData,btnDeleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = (EditText) findViewById(R.id.etName);
        etCell = (EditText) findViewById(R.id.etCell);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);
        btnShowData = (Button) findViewById(R.id.btnShowData);
        btnEditData = (Button) findViewById(R.id.btnEditData);
        btnDeleteData = (Button) findViewById(R.id.btnDeleteData);

    }

    public void btnSubmit(View v){

    }

    public void btnShowData(View v){
        startActivity(new Intent(this,Data.class));
    }

    public void btnEditData(View v){

    }

    public void btnDeleteData(View v){

    }
}
