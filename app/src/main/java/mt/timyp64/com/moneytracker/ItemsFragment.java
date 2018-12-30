package mt.timyp64.com.moneytracker;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;

//import static android.support.constraint.Constraints.TAG;

public class ItemsFragment extends Fragment {


    private static final String TYPE_KEY = "type";

    public static ItemsFragment createItemsFragmensFragment(String  type) {
        ItemsFragment fragment = new ItemsFragment();
        Bundle bundle = new Bundle();
        bundle.putString(ItemsFragment.TYPE_KEY, type);
        fragment.setArguments(bundle);
        return fragment;
    }

    private String type;

    private RecyclerView recycler;
    private ItemsAdapter adapter;

    private Api api;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new ItemsAdapter();

        Bundle bundle = getArguments();
        type = bundle.getString(TYPE_KEY, Item.TYPE_EXPENSES);

        if (type.equals(Item.TYPE_UNKNOW)) {
            throw new IllegalArgumentException("Unknown type");
        }

       api =  ((App) getActivity().getApplication()).getApi();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler = view.findViewById(R.id.list);
        recycler.setLayoutManager(new LinearLayoutManager(getContext()));
        recycler.setAdapter(adapter);
        loadItems();
    }

    private void loadItems(){
        Log.d("ItensFragment", "loadItems: current thread" + " " + Thread.currentThread().getName());

        Thread thread = new Thread(new LoadItemsTask());
        thread.start();
    };
    private class LoadItemsTask implements Runnable {
        @Override
        public void run() {
           Log.d("ItensFragment", "run: current thread" + " " + Thread.currentThread().getName());

            Call<List<Item>> call = api.getItem(type);
            try {
                List<Item> items =  call.execute().body();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
