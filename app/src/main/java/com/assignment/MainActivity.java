package com.assignment;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.assignment.adapters.HitsAdapter;
import com.assignment.databinding.ActivityMainBinding;
import com.assignment.models.HitsItem;
import com.assignment.models.HitsJson;
import com.assignment.networking.APIFactory;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements HitsAdapter.OnSelectedItemChangeListener {

    private ActivityMainBinding binding;
    private int pageNum = 1;
    private boolean fetchingList;
    private HitsAdapter adapter;
    private ActionMode actionMode;
    private ActionBarCallback actionBarCallback;
    private ArrayList<HitsItem> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        actionBarCallback = new ActionBarCallback();
        adapter = new HitsAdapter(list, this);
        binding.hitList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        binding.hitList.setAdapter(adapter);

        binding.refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 1;
                list.clear();
                fetchHitList();
            }
        });
        binding.hitList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                LinearLayoutManager manager = ((LinearLayoutManager) recyclerView.getLayoutManager());
                if (!fetchingList && manager != null && manager.findLastVisibleItemPosition() >= list.size() - 1) {
                    pageNum++;
                    fetchHitList();
                }
            }
        });
        fetchHitList();
    }

    private void fetchHitList() {
        binding.refresh.setRefreshing(true);
        fetchingList = true;
        new APIFactory().getAPI().getHitList(pageNum).enqueue(new Callback<HitsJson>() {
            @Override
            public void onResponse(Call<HitsJson> call, Response<HitsJson> response) {
                fetchingList = false;
                binding.refresh.setRefreshing(false);
                if (response.isSuccessful()) {
                    initList(response.body());
                } else {
                    showToast(getString(R.string.something_went_wrong));
                }
            }

            @Override
            public void onFailure(Call<HitsJson> call, Throwable t) {
                fetchingList = false;
                binding.refresh.setRefreshing(false);
                showToast(getString(R.string.something_went_wrong));
            }
        });
    }

    private void initList(HitsJson hitsJson) {
        list.addAll(hitsJson.getHits());
        adapter.notifyDataSetChanged();
    }

    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSelectedChange(int selectedItems) {
        if (selectedItems > 0) {
            if (actionMode == null) {
                actionMode = startActionMode(actionBarCallback);
            } else {
                actionMode.invalidate();
            }
            actionMode.setTitle(String.valueOf(selectedItems));
        } else {
            if (actionMode != null)
                actionMode.finish();
            actionMode = null;
        }
    }

    public class ActionBarCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }
}
