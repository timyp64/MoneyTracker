package mt.timyp64.com.moneytracker;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ItemViewHolder>{

    private List<Item> data = new ArrayList<>();

//    public ItemsAdapter() {
//        /reateData();
//
//    }

    public void setData(List<Item>  data){
        this.data = data;
    }

    @NonNull
    @Override
    public ItemsAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ItemViewHolder holder, int i) {
        Item item = data.get(i);
        holder.applyData(item);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        private final TextView title;
        private final TextView price;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
        }

        public void applyData(Item item) {
            title.setText(item.title);
            price.setText(String.valueOf(item.price));
        }
    }

 /*   private void createData() {
        data.add(new Item(35, "Молоко"));
        data.add(new Item(1, "Жизнь"));
        data.add(new Item(100, "Курсы"));
        data.add(new Item(100, "Хлеб"));
        data.add(new Item(600000, "Тот самый ужин который я оплатил за всех потому что платил картой"));
        data.add(new Item(0, ""));
        data.add(new Item(100, "Тот самый ужин"));
        data.add(new Item(100, "ракета "));
        data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));      data.add(new Item(100000000, "Монитор"));
        data.add(new Item(100, "МакБукПро"));
        data.add(new Item(100, "Шоколадка"));
        data.add(new Item(100, "Шкаф"));
    }*/

}
