package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import nyc.c4q.wesniemarcelin.nikoandroidclone.Cat;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class CatAdapter extends RecyclerView.Adapter {


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new CatViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CatViewHolder catVH = (CatViewHolder) holder;
        Cat cat;
        //      =   **  database.get(position) logic here  **
        //catVH.bind(cat)
    }

    @Override
    public int getItemCount() {
        // DATABASE SIZE
        return -1;

    }
}
