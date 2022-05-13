package com.example.listviewwithapirestdata.Adapter;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.listviewwithapirestdata.InfoActivity;
import com.example.listviewwithapirestdata.MainActivity;
import com.example.listviewwithapirestdata.Model.Paises;
import com.example.listviewwithapirestdata.R;

import java.util.ArrayList;

public  class AdaptadorUsuario extends ArrayAdapter<Paises> {


    public AdaptadorUsuario(Context context, ArrayList<Paises> datos) {
        super(context, R.layout.ly_item, datos);

}
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        final View item = inflater.inflate(R.layout.ly_item, null);
        TextView lblNombre = (TextView)item.findViewById(R.id.lblNombre);
        TextView lblemail = (TextView)item.findViewById(R.id.lblEmail);
        TextView lblweb = (TextView)item.findViewById(R.id.lblweb);

        ImageView imageView = (ImageView)item.findViewById(R.id.imgUsr);

        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (item.getContext(), InfoActivity.class);
                intent.putExtra("nombre_Pais",getItem(position).getNombrePais());
                intent.putExtra("url_imagen", getItem(position).getUrl_Pais());
                intent.putExtra("capital_Pais", getItem(position).getCapital());
                intent.putExtra("listaCooordenadas",getItem(position).getCoordenadasPais());
                item.getContext().startActivity(intent);
            }
        });
        Glide.with(this.getContext())
                .load(getItem(position).getUrl_Pais())
                .into(imageView);

            //.error(R.drawable.imgnotfound)



        lblNombre.setText(getItem(position).getNombrePais());
        lblemail.setText(getItem(position).getCapital());
        lblweb.setText(getItem(position).getUrl_Pais());

        return(item);
}

}
