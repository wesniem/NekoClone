package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.nikoandroidclone.R;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class CatViewHolder extends RecyclerView.ViewHolder{



    private TextView displayableCatName;
    private View imageToBeImported;

    public CatViewHolder(View itemView) {
        super(itemView);
        displayableCatName = (TextView) itemView.findViewById(R.id.cat_name_tv);
        imageToBeImported =  itemView.findViewById(R.id.img_holder_view);
    }
}
