package com.assignment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.R;
import com.assignment.databinding.ItemListHitBinding;
import com.assignment.models.HitsItem;

import java.util.ArrayList;

public class HitsAdapter extends RecyclerView.Adapter<HitsAdapter.HitsHolder> {

    private ArrayList<HitsItem> list;
    private OnSelectedItemChangeListener listener;
    private int selectedItems;

    public HitsAdapter(ArrayList<HitsItem> list, OnSelectedItemChangeListener listener) {
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HitsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new HitsHolder(DataBindingUtil.inflate(inflater, R.layout.item_list_hit, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HitsHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    boolean onBind;

    public class HitsHolder extends RecyclerView.ViewHolder {
        ItemListHitBinding binding;

        public HitsHolder(@NonNull ItemListHitBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(HitsItem item) {
            binding.setData(item);
            onBind = true;
            binding.toggle.setChecked(item.isOn());
            onBind = false;
            binding.container.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!list.get(getAdapterPosition()).isOn()) {
                        list.get(getAdapterPosition()).setOn(true);
                        selectedItems++;
                    } else {
                        list.get(getAdapterPosition()).setOn(false);
                        selectedItems--;
                    }
                    notifyDataSetChanged();
                    listener.onSelectedChange(selectedItems);
                }
            });
            binding.container.setActivated(item.isOn());
            binding.toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
                if (!onBind) {
                    item.setOn(isChecked);
                    if (isChecked)
                        selectedItems++;
                    else
                        selectedItems--;
                    notifyDataSetChanged();
                    listener.onSelectedChange(selectedItems);
                }
            });
            binding.executePendingBindings();
        }
    }

    public int getSelectedItems() {
        return selectedItems;
    }

    public interface OnSelectedItemChangeListener {
        public void onSelectedChange(int selectedItems);
    }
}
