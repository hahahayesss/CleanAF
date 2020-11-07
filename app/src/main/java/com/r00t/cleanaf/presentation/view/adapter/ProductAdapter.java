package com.r00t.cleanaf.presentation.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.r00t.cleanaf.R;
import com.r00t.cleanaf.domain.model.Product;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> productList;
    private LayoutInflater layoutInflater;

    @Inject
    public ProductAdapter(@ApplicationContext Context context) {
        productList = Collections.emptyList();
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.row_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.idTextView.setText(product.getId());
        holder.nameTextView.setText(product.getName());
        holder.kitSizeTextView.setText(String.valueOf(product.getKitSize()));
        holder.priceTextView.setText(String.valueOf(product.getPrice()));
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idTextView;
        private TextView nameTextView;
        private TextView kitSizeTextView;
        private TextView priceTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            idTextView = itemView.findViewById(R.id.idTextView);
            nameTextView = itemView.findViewById(R.id.nameTextView);
            kitSizeTextView = itemView.findViewById(R.id.kitSizeTextView);
            priceTextView = itemView.findViewById(R.id.priceTextView);
        }
    }
}
