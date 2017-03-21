package franciscoguixot.eventosdeportivosapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by FranciscoGuixot on 18/3/17.
 */

public class CustomList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] eventos;
    private final Integer[] imageId;

    public CustomList(Activity context, String[] eventos, Integer[] imageId) {
        super(context, R.layout.fila_lista, eventos);
        this.context = context;
        this.eventos = eventos;
        this.imageId = imageId;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.fila_lista, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.nombre_fila_lista);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        txtTitle.setText(eventos[position]);

        imageView.setImageResource(imageId[position]);
        return rowView;
    }

}
