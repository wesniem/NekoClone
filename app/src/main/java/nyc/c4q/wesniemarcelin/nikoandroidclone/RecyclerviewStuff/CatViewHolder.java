package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Random;

import nyc.c4q.wesniemarcelin.nikoandroidclone.R;
import nyc.c4q.wesniemarcelin.nikoandroidclone.RenameMe.ApplicationContextProvider;
import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class CatViewHolder extends RecyclerView.ViewHolder implements Listener {

    private TextView displayableCatName;
    private ImageView imageToBeImported;
    private LinearLayout linearLayout;

    public CatViewHolder(View itemView) {
        super(itemView);
        displayableCatName = (TextView) itemView.findViewById(R.id.cat_name_tv);
        imageToBeImported =  (ImageView) itemView.findViewById(R.id.img_holder_view);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.layout_id);
    }

    public void bind(Cat cat){
        final Cat currentCat = cat;
        displayableCatName.setText(currentCat.getName());

        Random random = new Random();
        String s = String.valueOf(random.nextInt(400) + 101);
        String endPoint = s + "/" + s;
        String tempCatString = "https://placekitten.com/g/" + endPoint;

        Glide.with(ApplicationContextProvider.getContext())
                .load(tempCatString)
                .into(imageToBeImported);

        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                whenClicked(currentCat);
            }
        });
        linearLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                whenLongClicked(currentCat);
                return true;
            }
        });


    }


    @Override
    public void whenClicked(Cat cat) {
        /**
         * click logic here
         * had difficulties accessing context here using 'this' & ApplicationContextProvider. (App would crash when using a test Toast).
         */

    }
    @Override
    public void whenLongClicked(Cat cat) {
        /**
         *
         * FRAGMENT LOGIC HERE
         *
         */


    }
}
