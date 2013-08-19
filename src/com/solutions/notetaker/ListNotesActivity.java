package com.solutions.notetaker;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListNotesActivity extends Activity {
	
	private List<Note> notes = new ArrayList<Note>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_notes);
		
		notes.add(new Note("First note", "Bla blah", new Date()));
		notes.add(new Note("Second note", "Bla blah", new Date()));
		notes.add(new Note("Third note", "Bla blah", new Date()));
		notes.add(new Note("Fourth note", "Bla blah", new Date()));
		notes.add(new Note("Fifth note", "Bla blah", new Date()));

		ListView notesListView = (ListView)findViewById(R.id.noteslistView);
		
		List<String> values = new ArrayList<String>();
		
		for(Note note : notes)
		{
			values.add(note.getTitle());
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
				values);
		
		notesListView.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list_notes, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		notes.add(new Note("Added note", "Blah", new Date()));
		ListView notesListView = (ListView)findViewById(R.id.noteslistView);
		List<String> values = new ArrayList<String>();
				
		for(Note note : notes)
		{
			values.add(note.getTitle());
		}
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1,
				values);
		
		notesListView.setAdapter(adapter);
		
		return true;
	}
	
}
