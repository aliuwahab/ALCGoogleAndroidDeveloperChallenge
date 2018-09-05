package gbeilaaliuwahab.journalappp;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.orm.SugarDb;
import com.xstar97.easyprefs.EasyPrefs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import gbeilaaliuwahab.journalappp.models.Journal;
import gbeilaaliuwahab.journalappp.models.User;

public class MainActivity extends AppCompatActivity {

    private RecyclerView journalsRecyclerView;
    private JournalsRecyclerViewAdapter journalsRecyclerViewAdapater;
    private RecyclerView.LayoutManager journalsRecyclerViewLayoutManager;

    private  List<Journal> queryJounalList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        innitialiseSugarORMDB();

//        storeLoginUserDetailsInPreferences("aliuwahab@gmil.com", "SECRET");
        checkIfUserExist();
    }


    public void innitialiseSugarORMDB(){

        SugarDb db = new SugarDb(this);
//        create if it doesn't, if it exist and there is error do nothing

        try {
            db.onCreate(db.getReadableDatabase());

        }catch (Exception e){

        //Error creating DB: Maybe it exist already.
//            TODO Catch the exception

        }
    }



    public Boolean checkIfUserExist(){
//
//        new EasyPrefs(getApplicationContext())
//                .setPreference()
//                .clearAll();

        //default get; String
        String userEmail = (String) new EasyPrefs(getApplicationContext())
                .setPreference()
                .setKey("email")
                .setValue("noo")
                .get();

        Log.d("USEREMAIL", userEmail);

        if (userEmail.equals("noo")) {
            startActivity(new Intent(this,LoginActivity.class));
            return false;
        }

        //storeLoginUserDetailsInPreferences("aliuwahab@gmil.com", "SECRET");
        setRecyclerViewDetails();
        whenFloatingButtonForAddingJournalIsClick();
        return true;

    }



    public void setRecyclerViewDetails(){

        User sampleUser = new User("aliuwahab@gmail.com");

         queryJounalList = Journal.listAll(Journal.class);
//        Log.d("QUERY", queryJounalList.toString());

//        List<Journal> exampleJounalsList = new LinkedList<>();
//        queryJounalList.add(new Journal("In order to register your service, you need to tag it as swap.service in your service provider:",true,sampleUser));
//        queryJounalList.add(new Journal("In order to register your service, you need to tag it as swap.service in your service provider:",true,sampleUser));
//        queryJounalList.add(new Journal("In order to register your service, you need to tag it as swap.service in your service provider:",true,sampleUser));

        journalsRecyclerView = findViewById(R.id.recycler_view_journals);
        journalsRecyclerView.setHasFixedSize(true);
        journalsRecyclerViewLayoutManager = new LinearLayoutManager(this);
        journalsRecyclerViewAdapater = new JournalsRecyclerViewAdapter(queryJounalList);

        journalsRecyclerView.setLayoutManager(journalsRecyclerViewLayoutManager);
        journalsRecyclerView.setAdapter(journalsRecyclerViewAdapater);

        journalsRecyclerViewAdapater.setOnItemClickListener(new JournalsRecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Journal journal = queryJounalList.get(position);
                queryJounalList.remove(position);
                journalsRecyclerViewAdapater.notifyItemRemoved(position);
                deleteJournal(journal.getId());
            }
        });

    }


    public void whenFloatingButtonForAddingJournalIsClick(){

        FloatingActionButton floatingActionButton = findViewById(R.id.floating_button_add_journal);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,AddJournalActivity.class));
            }
        });
    }



    public void deleteJournal(Long journalID){
        Journal journal = Journal.findById(Journal.class, Long.valueOf(journalID));
        journal.delete();
    }



}
