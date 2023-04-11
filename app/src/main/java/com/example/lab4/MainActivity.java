package com.example.lab4;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Switch;
public class MainActivity extends AppCompatActivity {
    // make a reference to buttons
    Button btn_add;
    EditText et_name, et_age;
    Switch sw_active;
    ArrayAdapter studentArrayAdapter;
    DataBaseHelper dataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // on create, give value
        btn_add = findViewById(R.id.btn_add);
        sw_active = findViewById(R.id.sw_active);
        et_age=findViewById(R.id.et_age);
        et_name = findViewById(R.id.et_name);


       // dataBaseHelper = new DataBaseHelper(MainActivity.this);
       // ShowStudentsOnListView(dataBaseHelper);


        //Listeners:

        btn_add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v){
               // dataBaseHelper = new DataBaseHelper(MainActivity.this);
               // ShowStudentsOnListView(dataBaseHelper);

                //Toast.makeText(MainActivity.this, everyone.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        btn_add.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // create model
                customerModel customerModel;
                try {
                    customerModel = new customerModel(0, et_name.getText().toString(), Integer.parseInt(et_age.getText().toString()) ,sw_active.isActivated());
                    DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                    boolean b =dataBaseHelper.addOne(customerModel);
                    Toast.makeText(MainActivity.this, "Added:"+ b , Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "Enter Valid input", Toast.LENGTH_SHORT).show();
                    customerModel = new customerModel(-1, "ERROR", 0 ,false);
                }

               /* DataBaseHelper dataBaseHelper = new DataBaseHelper(MainActivity.this);
                boolean b = dataBaseHelper.addOne(customerModel);
                Toast.makeText(MainActivity.this, "SUCCESS= "+ b, Toast.LENGTH_SHORT).show();

                ShowStudentsOnListView(dataBaseHelper);*/

            }
        });}}

       /* lv_StudentList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                customerModel ClickedStudent = (customerModel) adapterView.getItemAtPosition(i);
                dataBaseHelper.DeleteOne(ClickedStudent);
                ShowStudentsOnListView(dataBaseHelper);
                Toast.makeText(MainActivity.this, "Deleted" + ClickedStudent.toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    private void ShowStudentsOnListView(DataBaseHelper dataBaseHelper) {
        studentArrayAdapter = new ArrayAdapter<customerModel>(MainActivity.this, android.R.layout.simple_list_item_1, dataBaseHelper.getEveryone());
        lv_StudentList.setAdapter(studentArrayAdapter);
    }
}8*/
