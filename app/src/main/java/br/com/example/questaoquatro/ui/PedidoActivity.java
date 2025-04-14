package br.com.example.questaoquatro.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import br.com.example.questaoquatro.R;
import br.com.example.questaoquatro.utils.Lanche;

public class PedidoActivity extends AppCompatActivity {
    public static final String EXTRA_NOME = "br.com.example.questaoquatro";
    public static final String EXTRA_NOME_LANCHE = "br.com.example.questaoquatro";
    public static final String EXTRA_LANCHE_VALOR = "br.com.example.questaoquatro";
    private TextInputLayout txtInputLayout;
    private RadioGroup radioGroup;
    private TextInputEditText txtInput;
    private Button btnGoResumo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.pedido), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        txtInputLayout = findViewById(R.id.inputNomeLayout);
        txtInput = findViewById(R.id.inputNome);
        radioGroup = findViewById(R.id.radioGroup);
        btnGoResumo = findViewById(R.id.goToResumo);

        btnGoResumo.setOnClickListener(view -> {
            if(verificaNome()){
                setPedido();
                Intent intent = new Intent(this, ResumoActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void setPedido(){
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, ResumoActivity.class);
        String nome = txtInput.getText().toString().trim();


        radioGroup.setOnCheckedChangeListener((group, checkedId) ->{
            if(nome.isEmpty()){
                txtInput.setError("Insira seu nome.");
                return;
            }
            Lanche lanche = null;

            if(checkedId == R.id.radioBtnLanche1){
                Lanche hamburger = new Lanche("Hamburger", 25);
            }else if(checkedId == R.id.radioBtnLanche2){
                Lanche brownie = new Lanche("Brownie", 10);
            } else if (checkedId == R.id.radioBtnLanche3) {
                Lanche sushi = new Lanche("Sushi", 15);
            }
            if (lanche != null) {
                bundle.putString(EXTRA_NOME, nome);
                bundle.putString(EXTRA_NOME_LANCHE, lanche.getNome());
                bundle.putInt(EXTRA_LANCHE_VALOR, lanche.getValor());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Selecione um lanche.", Toast.LENGTH_SHORT).show();
            }

        });
    }

    public boolean verificaNome(){
        String nome = txtInput.getText().toString().trim();
        return !nome.isEmpty();
    }

}
