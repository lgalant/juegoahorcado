package ar.edu.ort.examenahorcado;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class Galanterni extends Fragment implements View.OnClickListener {

    int oportRestantes;
    String palabraJuego, palabraOriginal, caracteresErroneos, caracteresCorrectos;
    TextView palabraJuegoVw,oportRestantesVw,elegidosVW;
    EditText caracterVW;
    boolean gameOver=false;
    public Galanterni() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_galanterni, container, false);
        palabraJuegoVw = (TextView)v.findViewById(R.id.palabra_juego);
        oportRestantesVw = (TextView)v.findViewById(R.id.oport_restantes);
        caracterVW = (EditText) v.findViewById(R.id.caracter);
        elegidosVW = (TextView)v.findViewById(R.id.elegidos);
        Button agregar = (Button)v.findViewById(R.id.agregar);
        agregar.setOnClickListener(this);

        MainActivity ma = (MainActivity)getActivity();
        palabraOriginal = ma.getPalabra();
        oportRestantes = ma.getOportunidades();

       // palabraJuegoVw.setText(palabraJuego);
        oportRestantesVw.setText(String.valueOf(oportRestantes));
        caracteresCorrectos =""+palabraOriginal.charAt(0);
        caracteresErroneos="";

        //palabraJuego = dibujarPalabra();
        dibujarPalabra();
        return v;
    }


    @Override
    public void onClick(View view) {
        if (gameOver)
            return;

        if (palabraOriginal.indexOf(caracterVW.getText().toString()) ==-1) {
            oportRestantes--;
            oportRestantesVw.setText(String.valueOf(oportRestantes));
            caracteresErroneos += caracterVW.getText().toString();
            elegidosVW.setText(caracteresErroneos);
        }
        else {
            caracteresCorrectos+=caracterVW.getText().toString();
            dibujarPalabra();
        }

        if (oportRestantes <0) {
            Toast.makeText(getContext(), "Perdiste!", Toast.LENGTH_SHORT).show();
            gameOver=true;
        }
    }



    private void dibujarPalabra() {
        String resultado = "";
        boolean falta=false;
        for (int i = 0; i < palabraOriginal.length(); i++) {
            if (caracteresCorrectos.indexOf(palabraOriginal.charAt(i)) >= 0)
                resultado += palabraOriginal.charAt(i);
            else {
                resultado += "-";
                falta =true;
            }
        }

        palabraJuegoVw.setText(resultado);
        if (!falta) {
            Toast.makeText(getContext(), "Ganaste!", Toast.LENGTH_SHORT).show();
            gameOver=true;
        }
    }
}
