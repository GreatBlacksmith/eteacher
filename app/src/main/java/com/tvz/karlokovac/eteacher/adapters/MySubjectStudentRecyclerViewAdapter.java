package com.tvz.karlokovac.eteacher.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.data.StudentInSubject;
import com.tvz.karlokovac.eteacher.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MySubjectStudentRecyclerViewAdapter extends RecyclerView.Adapter<MySubjectStudentRecyclerViewAdapter.ViewHolder> {

    private final List<StudentInSubject> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MySubjectStudentRecyclerViewAdapter(List<StudentInSubject> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_subjectstudent, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.studentNameView.setText(mValues.get(position).getStudentName());
        holder.studentGradesView.setText(mValues.get(position).getGrades().toString());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction("StudentInSubject",holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView studentNameView;
        public final TextView studentGradesView;
        public StudentInSubject mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            studentNameView = (TextView) view.findViewById(R.id.subjectstudent_row_studentName);
            studentGradesView = (TextView) view.findViewById(R.id.ubjectstudent_row_studentGrades);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + studentNameView.getText() + "'";
        }
    }
}
