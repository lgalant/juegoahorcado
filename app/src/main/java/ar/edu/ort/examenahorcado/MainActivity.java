package ar.edu.ort.examenahorcado;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Leandro leandro;
    Galanterni galanterni;
    FragmentManager fm;
    String palabra;
    int oportunidades;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leandro = new Leandro();
        fm = getSupportFragmentManager();
        fm.beginTransaction()
                .replace(R.id.contenedor, leandro)
                .commit();

    }


    public void opciones(View v) {
        fm.beginTransaction()
                .replace(R.id.contenedor, leandro)
                .commit();
    }

    public void juego(View v) {
        palabra = leandro.getPalabra();
        oportunidades = leandro.getOportunidades();
        fm.beginTransaction()
                .replace(R.id.contenedor,  new Galanterni())
                .commit();
    }


    public String getPalabra() {
        return palabra;
    }

    public int getOportunidades() {
        return oportunidades;
    }
}
