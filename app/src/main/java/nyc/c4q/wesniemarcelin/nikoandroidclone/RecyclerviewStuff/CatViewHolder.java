package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import nyc.c4q.wesniemarcelin.nikoandroidclone.R;
import nyc.c4q.wesniemarcelin.nikoandroidclone.RenameMe.ApplicationContextProvider;
import nyc.c4q.wesniemarcelin.nikoandroidclone.UpdateCatNameActivity;
import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

/**
 * Created by shawnspeaks on 12/4/16.
 */

public class CatViewHolder extends RecyclerView.ViewHolder implements Listener {

    private TextView displayableCatName;
    private ImageView imageToBeImported;
    private LinearLayout linearLayout;
    private Context context;

    public CatViewHolder(View itemView) {
        super(itemView);
        displayableCatName = (TextView) itemView.findViewById(R.id.cat_name_tv);
        imageToBeImported =  (ImageView) itemView.findViewById(R.id.img_holder_view);
        linearLayout = (LinearLayout) itemView.findViewById(R.id.layout_id);
        context = itemView.getContext();
    }

    public void bind(Cat cat){
        final Cat currentCat = cat;
        displayableCatName.setText(currentCat.getName());

        Glide.with(ApplicationContextProvider.getContext())
                .load(cat.getCatUrl())
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

        Toast.makeText(context, cat.getName(), Toast.LENGTH_SHORT).show();
//        Activity activity = (Activity) context;
//        FragmentManager fm = activity.getFragmentManager();
//        fm.beginTransaction().add(R.id.activity_main, new CatEditorFragment()).commit();
        Intent intent = new Intent(context, UpdateCatNameActivity.class);
        intent.putExtra("catKey", cat);
        context.startActivity(intent);
    }
}
