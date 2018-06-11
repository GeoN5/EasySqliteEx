package com.example.geonho.sqlitedatabase;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ContactDBHelper dbHelper = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_tables();//create table
        load_values();//show data

        Button buttonSave = (Button)findViewById(R.id.buttonSave);
        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save_values();
                Toast.makeText(getApplicationContext(),"저장이 되었습니다.",Toast.LENGTH_LONG).show();
            }
        });

        Button buttonClear = (Button)findViewById(R.id.buttonClear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete_values();
                Toast.makeText(getApplicationContext(),"삭제가 되었습니다.",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init_tables(){
        //인스턴스 생성 -> 생성자 호출 -> db 생성 -> onCreate() -> table생성
        dbHelper = new ContactDBHelper(this);
    }

    private void load_values() {
        //SQLiteOpenHelper 클래스에서 제공하는 getReadableDatabase()함수를 통해 SQLiteDatabase 객체를 가져옵니다.
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(ContactDBCtrct.SQL_SELECT,null);

        if (cursor.moveToFirst()) {
            //NO (INTEGER) 값 가져오기.
            int no = cursor.getInt(0);
            EditText editTextNo = (EditText) findViewById(R.id.editTextNo);
            editTextNo.setText(Integer.toString(no));

            //NAME (TEXT) 값 가져오기
            String name = cursor.getString(1);
            EditText editTextName = (EditText) findViewById(R.id.editTextName);
            editTextName.setText(name);

            //PHONE (TEXT) 값 가져오기
            String phone = cursor.getString(2);
            EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
            editTextPhone.setText(phone);

            //OVER20 (INTEGER) 값 가져오기
            int over20 = cursor.getInt(3);
            CheckBox checkBoxOver20 = (CheckBox) findViewById(R.id.checkBoxOver20);
            if (over20 == 0) { checkBoxOver20.setChecked(false); }
                else { checkBoxOver20.setChecked(true); }
            }
        }

    private void save_values(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(ContactDBCtrct.SQL_DELETE);

        EditText editTextNo = (EditText) findViewById(R.id.editTextNo);
        int no = Integer.parseInt(editTextNo.getText().toString());

        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        String name = editTextName.getText().toString();

        EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        String phone = editTextPhone.getText().toString();

        CheckBox checkBoxOver20 = (CheckBox) findViewById(R.id.checkBoxOver20);
        boolean isOver20 = checkBoxOver20.isChecked();

        String sqlInsert = ContactDBCtrct.SQL_INSERT +
                " (" +
                Integer.toString(no) + ", " +
                "'" + name + "', " +
                "'" + phone + "', " +
                ((isOver20 == true) ? "1" : "0") +
                ")";
        db.execSQL(sqlInsert);

    }

    private void delete_values(){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.execSQL(ContactDBCtrct.SQL_DELETE);

        EditText editTextNo = (EditText) findViewById(R.id.editTextNo);
        editTextNo.setText("");

        EditText editTextName = (EditText) findViewById(R.id.editTextName);
        editTextName.setText("");

        EditText editTextPhone = (EditText) findViewById(R.id.editTextPhone);
        editTextPhone.setText("");

        CheckBox checkBoxOver20 = (CheckBox) findViewById(R.id.checkBoxOver20);
        checkBoxOver20.setChecked(false) ;
    }
}
