package pe.tohure.examplerecycler;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recicler;
    private List<Anuncio> anuncioList = new ArrayList<>();
    private AnunAdapter anunAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDummy();
        init();
    }

    private void initDummy() {
        Anuncio anuncio;

        for (int i = 0; i < 10;i++){
            if (i%2==0){
                anuncio = new Anuncio("Artefacto "+i,"short",i+"");
            }else {
                anuncio = new Anuncio("Artefacto "+i,"long",i+"");
            }
            anuncioList.add(anuncio);
        }
    }

    private void init() {
        recicler = (RecyclerView) findViewById(R.id.recicler);
        anunAdapter = new AnunAdapter(anuncioList);
        recicler.setLayoutManager(new LinearLayoutManager(this));
        recicler.setAdapter(anunAdapter);
    }
}
