package nyc.c4q.wesniemarcelin.nikoandroidclone.RecyclerviewStuff;

import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

/**
 * Created by shawnspeaks on 12/17/16.
 */

public interface Listener {
    void whenClicked(Cat cat);
    void whenLongClicked(Cat cat);
}

