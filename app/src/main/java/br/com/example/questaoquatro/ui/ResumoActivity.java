package br.com.example.questaoquatro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import br.com.example.questaoquatro.R;

public class ResumoActivity extends AppCompatActivity {

    private TextView txtNome, txtLanche, txtValor;
    private Button btnVoltar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.resumo), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();

        btnVoltar = findViewById(R.id.btnVoltar);
        txtNome = findViewById(R.id.txtNomePedido);
        txtLanche = findViewById(R.id.txtNomeLanche);
        txtValor =findViewById(R.id.txtValorLanche);

        String nome = intent.getStringExtra(PedidoActivity.EXTRA_NOME);
        String lanche = intent.getStringExtra(PedidoActivity.EXTRA_NOME_LANCHE);
        String valor = intent.getStringExtra(PedidoActivity.EXTRA_LANCHE_VALOR);

        txtNome.setText("Pedido feito por: " + nome);
        txtLanche.setText("Lanche: " + lanche);
        txtValor.setText("Valor: " + valor);


        btnVoltar.setOnClickListener(view -> {
            Intent intent1 = new Intent(this, MainActivity.class);
            startActivity(intent1);
            finish();
        });

    }
}
