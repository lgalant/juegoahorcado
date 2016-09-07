package ar.edu.ort.examenahorcado;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


public class Leandro extends Fragment {

    EditText palabraVW, oportunidadesVW;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_leandro, container, false);

        palabraVW = (EditText)v.findViewById(R.id.palabra);
        oportunidadesVW = (EditText)v.findViewById(R.id.oportunidades);
        return v;
    }

    public int getOportunidades() {
        int oportunidades;
        oportunidades = Integer.valueOf(oportunidadesVW.getText().toString());
        return oportunidades;
    }

    public String getPalabra() {
        return palabraVW.getText().toString();
    }
}
