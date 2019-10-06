package com.example.dh_catalogoprodutos.views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.dh_catalogoprodutos.R;
import com.example.dh_catalogoprodutos.adapter.ProdutosAdapter;
import com.example.dh_catalogoprodutos.interfaces.RecyclerViewOnClick;
import com.example.dh_catalogoprodutos.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutosActivity extends AppCompatActivity implements RecyclerViewOnClick {

    private RecyclerView recyclerView;
    private ProdutosAdapter adapter;
    private List<Produto> listaProdutos = new ArrayList<>();
    public static final String PRODUTO_KEY = "produto";
    public static final String PRECO_KEY = "preco";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerViewProdutos);

        adapter = new ProdutosAdapter(retornaListaProdutos(), this);

        recyclerView.setAdapter(adapter);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public List<Produto> retornaListaProdutos(){
        listaProdutos.add(new Produto("Bolo de brigadeiro", R.drawable.brigadeiro, "R$ 35,00", "3kg", "2 dias"));
        listaProdutos.add(new Produto("Bolo de cenoura", R.drawable.cenoura, "R$ 20,00", "2kg", "6 horas"));
        listaProdutos.add(new Produto("Bolo de coco", R.drawable.coco, "R$ 25,00", "1,5kg", "1 dia"));
        listaProdutos.add(new Produto("Cuca de banana", R.drawable.cucabanana, "R$ 30,00", "4kg", "2 dias"));
        listaProdutos.add(new Produto("Bolo floresta negra", R.drawable.florestanegra, "R$ 50,00", "3kg", "3 dias"));
        listaProdutos.add(new Produto("Bolo de fubá", R.drawable.fuba, "R$ 15,00", "2kg", "3 horas"));
        listaProdutos.add(new Produto("Bolo de morango", R.drawable.morango, "R$ 50,00", "2,5kg", "3 dias"));
        listaProdutos.add(new Produto("Sachertorte", R.drawable.sacher, "R$ 60,00", "4kg", "4 dias"));

        return listaProdutos;
    }

    @Override
    public void onClick(Produto produto) {
        Intent intent = new Intent(ProdutosActivity.this, InformacoesActivity.class);
        Bundle bundle = new Bundle();
        bundle.putParcelable(PRODUTO_KEY, produto);
        bundle.putParcelable(PRECO_KEY, produto);
        intent.putExtras(bundle);
        startActivity(intent);

    }
}
