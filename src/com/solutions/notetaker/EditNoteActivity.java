package com.solutions.notetaker;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditNoteActivity extends Activity {
	
	private boolean isInEditMode = true;

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);
        
        final Button saveButton = (Button)findViewById(R.id.saveButton);
		final EditText titleEditText = (EditText)findViewById(R.id.titleEditText);
		final EditText noteEditText = (EditText)findViewById(R.id.noteEditText);
		final TextView dateTextView = (TextView)findViewById(R.id.dateValueTextView);
		
		Serializable extra = getIntent().getSerializableExtra("Note");
		if(extra != null)
		{
			Note note = (Note)extra;
			titleEditText.setText(note.getTitle());
			noteEditText.setText(note.getNote());
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
			String date = dateFormat.format(note.getDate());
			
			dateTextView.setText(date);
			
			isInEditMode = false;
			titleEditText.setEnabled(false);
			noteEditText.setEnabled(false);
			saveButton.setText("Edit");
		}
		
        saveButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {				
				if(isInEditMode)
				{
					Intent returnIntent = new Intent();
					Note note = new Note(
							titleEditText.getText().toString(),
							noteEditText.getText().toString(),
							Calendar.getInstance().getTime());
					returnIntent.putExtra("Note", note);
					setResult(RESULT_OK, returnIntent);
					finish();
				}
				else
				{
					isInEditMode = true;
					saveButton.setText("Save");
					titleEditText.setEnabled(true);
					noteEditText.setEnabled(true);
				}
				
				
			}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
