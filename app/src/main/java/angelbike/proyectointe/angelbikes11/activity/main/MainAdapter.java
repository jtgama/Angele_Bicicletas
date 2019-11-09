package angelbike.proyectointe.angelbikes11.activity.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import angelbike.proyectointe.angelbikes11.R;
import angelbike.proyectointe.angelbikes11.model.ModeloUsuario;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.RecyclerViewAdapter> {

    private Context context;
    private List<ModeloUsuario> modeloUsuarios;
    private ItemClickListener itemClickListener;
    private  RecyclerView recyclerView;

    public MainAdapter(Context context, List<ModeloUsuario> modeloUsuarios, ItemClickListener itemClickListener) {
        this.context = context;
        this.modeloUsuarios = modeloUsuarios;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view  = LayoutInflater.from(context).inflate(R.layout.item_cliente,parent,false);

        return new RecyclerViewAdapter(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter holder, int position) {

        ModeloUsuario modeloUsuario = modeloUsuarios.get(position);
        //holder.id_angel.setText(modeloUsuario.getId());
        holder.angel.setText(modeloUsuario.getAngel());
        holder.correo.setText(modeloUsuario.getCorreo());
        holder.telefono.setText(modeloUsuario.getTele());

        holder.itemCard.setCardBackgroundColor(modeloUsuario.getColor());


    }

    @Override
    public int getItemCount() {
        return modeloUsuarios.size();
    }

    public class RecyclerViewAdapter extends RecyclerView.ViewHolder implements  View.OnClickListener{

        TextView angel,correo,telefono;
        CardView itemCard;
        ItemClickListener itemClickListener;



        public RecyclerViewAdapter(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);

           //id_angel= itemView.findViewById(R.id.id_angel);
            angel = itemView.findViewById(R.id.angel);
            correo = itemView.findViewById(R.id.corre);
            telefono = itemView.findViewById(R.id.tele);

           itemCard = itemView.findViewById(R.id.item_lista);
            this.itemClickListener = itemClickListener;
           itemCard.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {

            itemClickListener.onItemClick(view, getAdapterPosition());
        }
    }
    public  interface ItemClickListener{
      void onItemClick(View view , int position);

    }

}
