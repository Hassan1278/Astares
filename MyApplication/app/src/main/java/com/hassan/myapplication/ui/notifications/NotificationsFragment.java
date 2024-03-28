package com.hassan.myapplication.ui.notifications;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.hassan.myapplication.R;
import com.hassan.myapplication.databinding.FragmentNotificationsBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationsBinding binding;
    List<String> itemList = new ArrayList<>();
    EditText itemEditText;

    RecyclerView recyclerView;
    Adapter rvAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        recyclerView = root.findViewById(R.id.recyclerView);
        itemEditText = root.findViewById(R.id.Addactiv);
        Button button = root.findViewById(R.id.button2);
        button.setOnClickListener(view -> onAddButtonClicked());

        //Setting the layout and Adapter for RecyclerView
        recyclerView.setLayoutManager(new LinearLayoutManager(this.requireContext().getApplicationContext()));
        rvAdapter = new Adapter(itemList);
        recyclerView.setAdapter(rvAdapter);



        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
    public void onAddButtonClicked() {
        itemList.add(itemEditText.getText().toString());
        rvAdapter.notifyItemInserted(itemList.size()-1);
        itemEditText.setText("");
    }
}