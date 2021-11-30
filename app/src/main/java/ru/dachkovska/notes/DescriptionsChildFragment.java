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


public class DescriptionsChildFragment extends Fragment {

    static final String ARG_INDEX_CHILD = "index";

    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_descriptions_child, container, false);
    }

    // Этот метод вызывается, когда макет экрана создан и готов к отображению информации. Создаем список заметок
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Bundle arguments = getArguments();
        // Аргументы могут быть null (как в случае с методом Activity getIntent())
        // поэтому обязательно проверяем на null
        if (arguments != null) {
            Note note = arguments.getParcelable(ARG_INDEX_CHILD);
            // найдем в root view нужный EditText
            EditText editTextDescription = view.findViewById(R.id.descriptions_child_EditText);
            // Получим из ресурсов массив описания заметок
          //  String[] descriptions = getResources().getStringArray(R.array.description);
            // Возьмем нужное описание и отобразим в EditText
            editTextDescription.setText(note.getDescription());
        }

    }

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы
    public static DescriptionsChildFragment newInstance(Note note) {
        // Создание фрагмента
        DescriptionsChildFragment fragment = new DescriptionsChildFragment();
        // Передача параметра через бандл
        Bundle args = new Bundle();
        args.putParcelable(ARG_INDEX_CHILD, note);
        fragment.setArguments(args);
        return fragment;
    }
}