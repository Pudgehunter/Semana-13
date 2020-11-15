package co.domi.semana13;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.UUID;

public class UsuarioAdaptador extends BaseAdapter {

    //Data
    private ArrayList<Usuario> usuarioData;

    public UsuarioAdaptador(){
        usuarioData = new ArrayList<>();
    }

    public void addUsuario(Usuario usuario){
        usuarioData.add(usuario);
        notifyDataSetChanged();
    }

    public void clear(){
        usuarioData.clear();
        notifyDataSetChanged();
    }


    @Override
    public int getCount() {
        return usuarioData.size();
    }

    @Override
    public Object getItem(int position) {
        return usuarioData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int pos, View reglon, ViewGroup lista) {

        LayoutInflater inflater = LayoutInflater.from(lista.getContext());
        View renglonView = inflater.inflate(R.layout.row, null);

        Usuario usuario = usuarioData.get(pos);

        Button borrarBtn = renglonView.findViewById(R.id.borrarBtn);
        TextView nombreIdView = renglonView.findViewById(R.id.nombreIdView);
        TextView telefonoIdView = renglonView.findViewById(R.id.telefonoIdView);

        nombreIdView.setText(usuario.getNombre());
        telefonoIdView.setText((int) usuario.getTelefono());

        borrarBtn.setOnClickListener(
                (v) -> {
                   //String id = usuarioData.getId();
                   //DatabaseReference
                }
        );

        


        return renglonView;
    }
}
