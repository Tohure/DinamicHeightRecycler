package pe.tohure.examplerecycler;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by crhto on 22/05/2017.
 */

public class AnunAdapter extends RecyclerView.Adapter<AnunAdapter.AnuncioViewHolder>{

    private List<Anuncio> anuncioList;


    public AnunAdapter(List<Anuncio> anuncioList) {
        this.anuncioList = anuncioList;
    }

    @Override
    public AnuncioViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycler, parent, false);
        return new AnuncioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnuncioViewHolder holder, int position) {

        if (anuncioList.get(position).getType().equals("short")){
            holder.imageView.setImageResource(R.drawable.ic_description_icon);
            holder.descriptiontext.setText(R.string.lorem_2);
        }else{
            holder.imageView.setImageResource(R.drawable.ic_action_place);
            holder.descriptiontext.setText(R.string.lorem_1);
        }

        int height = holder.cardView.getMeasuredHeight();

        ViewGroup.LayoutParams params = holder.container.getLayoutParams();
        // Changes the height and width to the specified *pixels*
        params.height = height;
        holder.container.setLayoutParams(params);

    }

    @Override
    public int getItemCount() {
        return anuncioList.size();
    }

    class AnuncioViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout container;
        private CardView cardView;
        private TextView descriptiontext;
        private ImageView imageView;

        public AnuncioViewHolder(View itemView) {
            super(itemView);
            container = (RelativeLayout) itemView.findViewById(R.id.relativeContainer);
            cardView = (CardView) itemView.findViewById(R.id.crdDescriptionItem);
            descriptiontext = (TextView) itemView.findViewById(R.id.descriptionText);
            imageView = (ImageView) itemView.findViewById(R.id.imgLogoItem);
        }
    }
}
