package hridoy.aiz.sqliteexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.SQLException;

public class MainActivity extends AppCompatActivity {

    EditText etName, etCell;
    Button btnSubmit, btnShowData, btnEditData, btnDeleteData;

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

    public void btnSubmit(View v) {

        String name = etName.getText().toString().trim();
        String cell = etCell.getText().toString().trim();

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.createEntry(name, cell);
            Toast.makeText(MainActivity.this, "Successfully Saved!", Toast.LENGTH_SHORT).show();
            etName.setText("");
            etCell.setText("");
            db.close();
        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    public void btnShowData(View v) {
        startActivity(new Intent(this, Data.class));
    }

    public void btnEditData(View v) {

        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.updateEntry("1","john doe","234324324");
            Toast.makeText(MainActivity.this, "Successfully updated!", Toast.LENGTH_SHORT).show();
            db.close();
        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    public void btnDeleteData(View v) {
        try {
            ContactsDB db = new ContactsDB(this);
            db.open();
            db.deleteEntry("2");
            Toast.makeText(MainActivity.this, "Successfully deleted!", Toast.LENGTH_SHORT).show();
            db.close();
        } catch (SQLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
