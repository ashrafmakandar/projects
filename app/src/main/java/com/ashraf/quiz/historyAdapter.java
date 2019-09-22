package com.ashraf.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class historyAdapter extends RecyclerView.Adapter<historyAdapter.viewshold> {

    List<history> histories;
    Context context;

    public historyAdapter(List<history> histories, Context context) {
        this.histories = histories;
        this.context = context;
    }

    @NonNull
    @Override
    public viewshold onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.user_history, parent, false);

        return new viewshold(v);
    }

    @Override
    public void onBindViewHolder(@NonNull viewshold holder, int position) {
        holder.uname.setText("Name :" + histories.get(position).getName() + "\n\n" + histories.get(position).getTime());

        holder.qt1.setText("Q1 :" + histories.get(position).getQ1());
        holder.qt2.setText("Q2" + histories.get(position).getQ2());
        holder.at1.setText("ANSWER 1 :" + histories.get(position).getAnswer1());
        holder.at2.setText("ANSWER 2:" + histories.get(position).getAnswer2());

    }

    @Override
    public int getItemCount() {
        return histories.size();
    }

    public class viewshold extends RecyclerView.ViewHolder {
        TextView uname, qt1, qt2, at1, at2;

        public viewshold(@NonNull View itemView) {
            super(itemView);

            uname = itemView.findViewById(R.id.userHname);
            qt1 = itemView.findViewById(R.id.questH1);
            qt2 = itemView.findViewById(R.id.questH2);
            at1 = itemView.findViewById(R.id.ansrH1);

            at2 = itemView.findViewById(R.id.ansrh2);
        }
    }
}
