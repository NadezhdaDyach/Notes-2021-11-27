package ru.dachkovska.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class DescriptionsFragment extends Fragment {

    static final String ARG_INDEX = "index";

    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_descriptions, container, false);
    }

    // Этот метод вызывается, когда макет экрана создан и готов к отображению информации. Создаем список заметок
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        // Аргументы могут быть null (как в случае с методом Activity getIntent())
        // поэтому обязательно проверяем на null
        if (arguments != null) {
            Note note = arguments.getParcelable(ARG_INDEX);
            // найдем в root view нужный EditText
            EditText editTextNoteName= view.findViewById(R.id.note_name_edit_text);
            // Возьмем нужное описание и отобразим в EditText
            editTextNoteName.setText(note.getNoteName());
            getChildFragmentManager()
                    .beginTransaction()
                    .addToBackStack("")
                    .replace(R.id.descriptions_child_container, DescriptionsChildFragment.newInstance(note)).commit();
        }

        Button buttonBack = view.findViewById(R.id.descriptions_button_back);
        buttonBack.setOnClickListener(view1 -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        Button buttonSave = view.findViewById(R.id.descriptions_button_save);
        buttonSave.setOnClickListener(view1 -> {
            Toast.makeText(getContext(),"Изменения сохранены", Toast.LENGTH_SHORT).show();
        });
    }

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы
    public static DescriptionsFragment newInstance(Note note) {
        // Создание фрагмента
        DescriptionsFragment fragment = new DescriptionsFragment();
        // Передача параметра через бандл
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX, note);
        fragment.setArguments(args);
        return fragment;
    }
}