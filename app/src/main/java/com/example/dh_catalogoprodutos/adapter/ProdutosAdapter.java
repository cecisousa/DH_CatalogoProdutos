package com.example.dh_catalogoprodutos.adapter;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dh_catalogoprodutos.R;
import com.example.dh_catalogoprodutos.interfaces.RecyclerViewOnClick;
import com.example.dh_catalogoprodutos.model.Produto;

import java.util.List;

public class ProdutosAdapter extends RecyclerView.Adapter<ProdutosAdapter.ViewHolder> {

    private List<Produto> listaProdutos;

    private RecyclerViewOnClick listener;

    public ProdutosAdapter (List<Produto> listaProdutos, RecyclerViewOnClick listener){
        this.listaProdutos = listaProdutos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_recyclerview, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Produto produto = listaProdutos.get(position);
        holder.onBind(produto);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClick(produto);
            }
        });

    }

    @Override
    public int getItemCount() {
        return listaProdutos.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView fotoProduto;
        private TextView nomeProduto;
        private TextView precoProduto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            fotoProduto = itemView.findViewById(R.id.fotoProduto);
            nomeProduto = itemView.findViewById(R.id.nomeProduto);
            precoProduto = itemView.findViewById(R.id.precoProduto);

        }

        public void onBind(Produto produto){
            Drawable drawable = itemView.getResources().getDrawable(produto.getImagem());
            fotoProduto.setImageDrawable(drawable);
            nomeProduto.setText(produto.getNome());
            precoProduto.setText(produto.getPreco());
        }
    }
}
