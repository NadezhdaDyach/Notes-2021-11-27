package ru.dachkovska.notes;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class NoteFragment extends Fragment {


    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    // Этот метод вызывается, когда макет экрана создан и готов к отображению информации. Создаем список заметок
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);
    }

    // создаём список заметок на экране из массива в ресурсах
    private void initList(View view) {
        LinearLayout layoutView = (LinearLayout) view;
        String[] notes = getResources().getStringArray(R.array.notes);
        String[] descriptions = getResources().getStringArray(R.array.description);
        String[] dates = getResources().getStringArray(R.array.created_dates);
        // В этом цикле создаём элемент TextView,
        // заполняем его значениями,
        // и добавляем на экран.
        for (int i=0; i<notes.length;i++) {
            String currentNote=notes[i];
            String currentDescription=descriptions[i];
            String currentDate=dates[i];
            TextView tv = new TextView(getContext());
            tv.setText(currentNote);
            tv.setTextSize(30);
            layoutView.addView(tv);
            final int position=i;
            tv.setOnClickListener(v -> {
                showPortDescription(new Note(currentNote,currentDescription,currentDate));
            });
        }
    }

    // Показываем описание в портретной ориентации
    private void showPortDescription(Note note) {
        FragmentTransaction fragmentTransaction = requireActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .addToBackStack("")
                .replace(R.id.fragment_container, DescriptionsFragment.newInstance(note)).commit();
    }

}