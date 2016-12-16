package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.wesniemarcelin.nikoandroidclone.R;
import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class CatAdapter extends RecyclerView.Adapter {

    private List<Cat> catList;

    public CatAdapter(List<Cat> catList){
        this.catList = catList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_cat_view, parent, false);
        return new CatViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CatViewHolder catVH = (CatViewHolder) holder;
        Cat cat = catList.get(position);
        catVH.bind(cat);
        //      =   **  database.get(position) logic here  **
    }

    @Override
    public int getItemCount() {
        return catList.size();
    }

}
