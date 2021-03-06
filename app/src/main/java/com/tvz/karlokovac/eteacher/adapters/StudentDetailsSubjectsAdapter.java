package com.tvz.karlokovac.eteacher.adapters;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

        viewHolder.buttonAddGrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(view.getRootView().getContext());
                View mView = layoutInflaterAndroid.inflate(R.layout.add_grade_to_studentsubject, null);
                final Context context = view.getRootView().getContext();
                AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(view.getRootView().getContext());
                alertDialogBuilderUserInput.setView(mView);

                final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.add_grade_userInput);
                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("Dodaj", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                Toast.makeText(context, "Ocjena uspješno dodana!",
                                        Toast.LENGTH_LONG).show();
                            }
                        })

                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {
                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
            }
        });
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewClassName;
        public TextView textViewAverage;
        public Button buttonAddGrade;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            textViewClassName = (TextView) itemLayoutView.findViewById(R.id.student_details_row_subject_name);
            textViewAverage = (TextView) itemLayoutView.findViewById(R.id.student_details_row_average);
            buttonAddGrade = (Button) itemLayoutView.findViewById(R.id.button_studentsubject_addGrade);
        }
    }

    // Return the size of your items (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return subjects.length;
    }
}
