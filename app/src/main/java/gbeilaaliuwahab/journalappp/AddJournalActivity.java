package gbeilaaliuwahab.journalappp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import gbeilaaliuwahab.journalappp.models.Journal;
import gbeilaaliuwahab.journalappp.models.User;

public class AddJournalActivity extends AppCompatActivity {

    private EditText mEditTextJournalTitle;
    private Button mButtonAddNewJournal;
    private String journalTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journal);

        associateWidgets();

    }




    public void associateWidgets(){
        mEditTextJournalTitle = findViewById(R.id.edit_text_journal_title);
        mButtonAddNewJournal = findViewById(R.id.button_create_journal);

        mButtonAddNewJournal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addANewJournal();
            }
        });
    }



    public void addANewJournal(){

        User sampleUser = new User("aliuwahab@gmail.com");

//        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        journalTitle = mEditTextJournalTitle.getText().toString();
        if (journalTitle.matches("")) {
            Toast.makeText(this, "You did not enter a journal title", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Toast.makeText(this, journalTitle, Toast.LENGTH_SHORT).show();

            Journal newJournal = new Journal( journalTitle, true, sampleUser);
            newJournal.save();

            startActivity(new Intent(this,MainActivity.class));
//            return false;
            return;
        }


    }



    public void saveJournalOnFirebase(){


    }



}
