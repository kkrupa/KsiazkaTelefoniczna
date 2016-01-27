package com.kkrupa.android.nauka.ksiazkatelefoniczna;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by kkrupa on 18.01.16.
 */
public class Adapter4Osoba extends ArrayAdapter<Osoba> {
    Context ctx;

    public Adapter4Osoba (Context context, List<Osoba> objects) {
        super(context, R.layout.wiersz, objects);
        ctx = context;
    }

    public View getView(int pos, View v, ViewGroup p) {
        View wiersz = v;

        if (wiersz == null) {
            LayoutInflater inflater = (LayoutInflater)ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            wiersz = inflater.inflate(R.layout.wiersz, p, false);
        }

        Osoba o = getItem(pos);
        ((TextView)wiersz.findViewById(R.id.wierszLinia1)).setText(o.getImie() +
                " " + o.getNazwisko().toUpperCase());
        ((TextView)wiersz.findViewById(R.id.wierszLinia2)).setText(o.getNumerTelefonu());
        ((TextView)wiersz.findViewById(R.id.wierszLinia3)).setText(o.getEmail());

        return wiersz;
    }
}
