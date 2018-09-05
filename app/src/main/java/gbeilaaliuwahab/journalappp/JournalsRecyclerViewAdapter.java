package gbeilaaliuwahab.journalappp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import gbeilaaliuwahab.journalappp.models.Journal;

public class JournalsRecyclerViewAdapter extends RecyclerView.Adapter<JournalsRecyclerViewAdapter.JournalsRecyclerViewHolder> {

    private List<Journal> mJournalList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{

        void onItemClick(int position);

    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class JournalsRecyclerViewHolder extends RecyclerView.ViewHolder{

        public TextView journalTitle;
//        public TextView journalDescription;
        public Button editJournalDetails;
        public Button deleteJournalDetails;

        public JournalsRecyclerViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            journalTitle = itemView.findViewById(R.id.text_view_journal_title);
            editJournalDetails = itemView.findViewById(R.id.button_edit_journal);
            deleteJournalDetails = itemView.findViewById(R.id.button_delete_journal);
//            journalDescription = itemView.findViewById(R.id.text_view_journal_description);

            editJournalDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }

            });


            deleteJournalDetails.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (listener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            listener.onItemClick(position);
                        }
                    }
                }

            });
        }


    }

    public JournalsRecyclerViewAdapter(List<Journal> journalList){
        mJournalList = journalList;
    }

    @NonNull
    @Override
    public JournalsRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View singlelayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_journal,parent,false);
        JournalsRecyclerViewHolder journalsRecyclerViewHolder = new JournalsRecyclerViewHolder(singlelayoutView,mListener);
        return  journalsRecyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull JournalsRecyclerViewHolder holder, int position) {
        Journal currentJournal = mJournalList.get(position);
        holder.journalTitle.setText(currentJournal.getTitle());
//        holder.journalDescription.setText(currentJournal.getDescription());
    }

    @Override
    public int getItemCount() {
        return mJournalList.size();
    }


}
