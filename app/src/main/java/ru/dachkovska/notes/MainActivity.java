package ru.dachkovska.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Создаем фрагмент
        NoteFragment notesFragment = new NoteFragment();
        // Вызываем FragmentManager
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, notesFragment).commit();
    }
}
