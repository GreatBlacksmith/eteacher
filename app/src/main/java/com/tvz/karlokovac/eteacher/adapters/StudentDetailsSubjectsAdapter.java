package com.tvz.karlokovac.eteacher.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.data.Subject;

public class StudentDetailsSubjectsAdapter extends RecyclerView.Adapter<StudentDetailsSubjectsAdapter.ViewHolder> {
    private Subject[] subjects;

    public StudentDetailsSubjectsAdapter(Subject[] subjects) {
        this.subjects = subjects;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_details_subjects_row, null);

        // create ViewHolder

        return new ViewHolder(itemLayoutView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        viewHolder.textViewClassName.setText(subjects[position].getName());
        viewHolder.textViewAverage.setText(subjects[position].getAverage());
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewClassName;
        public TextView textViewAverage;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            textViewClassName = (TextView) itemLayoutView.findViewById(R.id.student_details_row_subject_name);
            textViewAverage = (TextView) itemLayoutView.findViewById(R.id.student_details_row_average);
        }
    }

    // Return the size of your items (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return subjects.length;
    }
}
