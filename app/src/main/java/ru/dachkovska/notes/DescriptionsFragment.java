package ru.dachkovska.notes;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

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
            int index = arguments.getInt(ARG_INDEX);
            // найдем в root view нужный EditText
            EditText editTextDescription = view.findViewById(R.id.description_text_view);
            // Получим из ресурсов массив описания заметок
            String[] descriptions = getResources().getStringArray(R.array.description);
            // Возьмем нужное описание и отобразим в EditText
           editTextDescription.setText(descriptions[index]);
        }
    }

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы
    public static DescriptionsFragment newInstance(int index) {
        // Создание фрагмента
        DescriptionsFragment fragment = new DescriptionsFragment();
        // Передача параметра через бандл
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }
}