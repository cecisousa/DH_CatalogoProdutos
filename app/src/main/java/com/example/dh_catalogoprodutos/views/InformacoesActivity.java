package com.example.dh_catalogoprodutos.views;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dh_catalogoprodutos.R;
import com.example.dh_catalogoprodutos.model.Produto;

import static com.example.dh_catalogoprodutos.views.ProdutosActivity.PRECO_KEY;
import static com.example.dh_catalogoprodutos.views.ProdutosActivity.PRODUTO_KEY;

public class InformacoesActivity extends AppCompatActivity {

    private ImageView imagemProduto;
    private TextView nomeProduto;
    private TextView precoProduto;
    private TextView tamanhoProduto;
    private TextView entregaProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        initViews();

        if (getIntent() != null && getIntent().getExtras() != null) {
            Produto produto = getIntent().getExtras().getParcelable(PRODUTO_KEY);
            Produto preco = getIntent().getExtras().getParcelable(PRECO_KEY);

            Drawable drawable = getResources().getDrawable(produto.getImagem());
            imagemProduto.setImageDrawable(drawable);
            nomeProduto.setText(produto.getNome());
            precoProduto.setText(produto.getPreco());
            tamanhoProduto.setText(produto.getTamanho());
            entregaProduto.setText(produto.getEntrega());
        }

    }

    public void initViews(){
        imagemProduto = findViewById(R.id.imagemProduto);
        nomeProduto = findViewById(R.id.nomeProduto);
        precoProduto = findViewById(R.id.precoProduto);
        tamanhoProduto = findViewById(R.id.tamanhoProduto);
        entregaProduto = findViewById(R.id.entregaProduto);
    }
}
