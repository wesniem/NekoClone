package nyc.c4q.wesniemarcelin.nikoandroidclone;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import nyc.c4q.wesniemarcelin.nikoandroidclone.model.Cat;

import static nl.qbusict.cupboard.CupboardFactory.cupboard;

public class UpdateCatNameActivity extends AppCompatActivity {

    Intent intent;
    TextView textView;
    EditText editTxt;
    Button changeNameBtn;
    Button cancel;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_cat_name);
        intent = getIntent();
        final Cat cat =  (Cat) intent.getSerializableExtra("catKey");
        String catName = cat.getName();
        textView = (TextView) findViewById(R.id.tv_1);
        textView.setText(catName);
        changeNameBtn = (Button) findViewById(R.id.btn_rename);
        cancel = (Button) findViewById(R.id.btn_cancel);
        editTxt = (EditText) findViewById(R.id.edit_txt);
        CatDatabaseHelper dbHelp = CatDatabaseHelper.getInstance(this);
        db = dbHelp.getWritableDatabase();
//        cupboard().withDatabase(db).put(cat.getId(), editTxt.getText());
//


        changeNameBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /**
                 *  CHANGE CAT NAME TO _______
                 */

                cupboard().withDatabase(db).put(cat.getId(), editTxt.getText());
            }
        });

        cancel.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent i = new Intent(getApplicationContext(), MainActivity.class);
              startActivity(i);
          }
      });

    }

}
