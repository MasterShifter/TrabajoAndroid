package com.example.csi2_23.trabajoandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class EditActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edtAlumnId, edtName, edtSurname, edtPhone, edtMail, edtMark;
    private Spinner spinSubject;
    private Button btnEditOk, btnEditCancel;

    private List<String> subjetcNames = new ArrayList<>();

    private Alumno alumno = new Alumno();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        subjetcNames.add(getString(R.string.subject0));
        subjetcNames.add(getString(R.string.subject1));
        subjetcNames.add(getString(R.string.subject2));
        subjetcNames.add(getString(R.string.subject3));

        edtAlumnId = (EditText)findViewById(R.id.edtAlumnId);
        edtName = (EditText)findViewById(R.id.edtName);
        edtSurname = (EditText)findViewById(R.id.edtSurname);
        edtPhone = (EditText)findViewById(R.id.edtPhone);
        edtMail = (EditText)findViewById(R.id.edtMail);
        edtMark = (EditText)findViewById(R.id.edtMark);

        spinSubject = (Spinner)findViewById(R.id.spinSubject);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, subjetcNames);
        spinSubject.setAdapter(adapter);

        btnEditOk = (Button)findViewById(R.id.btnEditOk);
        btnEditCancel = (Button)findViewById(R.id.btnEditCancel);
        btnEditOk.setOnClickListener(this);
        btnEditCancel.setOnClickListener(this);

        Alumno alumno = (Alumno)getIntent().getExtras().get("alumno");

        if (alumno.getIdAlumn() != -1){
            edtAlumnId.setText(alumno.getIdAlumn().toString());
            edtName.setText(alumno.getName());
            edtSurname.setText(alumno.getSurname());
            edtPhone.setText(alumno.getPhonenumber().toString());
            edtMail.setText(alumno.getEmail());
            edtMark.setText(alumno.getMark().toString());

            spinSubject.setSelection(alumno.getSubject());
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnEditOk:

                Intent i = new Intent(EditActivity.this, ListActivity.class);
                alumno.setIdAlumn(Integer.parseInt(edtAlumnId.getText().toString()));
                alumno.setName(edtName.getText().toString());
                alumno.setSurname(edtSurname.getText().toString());
                alumno.setEmail(edtMail.getText().toString());
                alumno.setPhonenumber(Integer.parseInt(edtPhone.getText().toString()));
                alumno.setSubject(spinSubject.getSelectedItemPosition());
                alumno.setMark(Float.parseFloat(edtMark.getText().toString()));
                i.putExtra("alumno", alumno);
                setResult(RESULT_OK, i);
                finish();
                break;
            case R.id.btnEditCancel:
                setResult(RESULT_CANCELED);
                finish();
                break;
        }
    }

    @Override
    public void onBackPressed() {
        setResult(RESULT_CANCELED);
        finish();
    }
}
