package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import nyc.c4q.wesniemarcelin.nikoandroidclone.R;
import nyc.c4q.wesniemarcelin.nikoandroidclone.RenameMe.ApplicationContextProvider;
import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class CatViewHolder extends RecyclerView.ViewHolder{

    private TextView displayableCatName;
    private ImageView imageToBeImported;

    public CatViewHolder(View itemView) {
        super(itemView);
        displayableCatName = (TextView) itemView.findViewById(R.id.cat_name_tv);
        imageToBeImported =  (ImageView) itemView.findViewById(R.id.img_holder_view);
    }

    public void bind(Cat cat){
        String tempCatString = "https://placekitten.com/g/75/75";

        displayableCatName.setText(cat.getName());
        Glide.with(ApplicationContextProvider.getContext())
                .load(tempCatString)
                .into(imageToBeImported);

    }
}
