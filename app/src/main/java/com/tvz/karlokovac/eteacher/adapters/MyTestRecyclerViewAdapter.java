package com.tvz.karlokovac.eteacher.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.data.Test;
import com.tvz.karlokovac.eteacher.fragments.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyTestRecyclerViewAdapter extends RecyclerView.Adapter<MyTestRecyclerViewAdapter.ViewHolder> {

    private final List<Test> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTestRecyclerViewAdapter(List<Test> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_test, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.testNameView.setText(mValues.get(position).getTestName());
        holder.subjectNameView.setText(mValues.get(position).getSubjectName());
        holder.numberOfParticipantsView.setText(mValues.get(position).getNumberOfParticipants());
        holder.averageScoreView.setText(mValues.get(position).getAverageScore());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction("Tests",holder.mItem);
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
        public final TextView testNameView;
        public final TextView subjectNameView;
        public final TextView numberOfParticipantsView;
        public final TextView averageScoreView;
        public Test mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            testNameView = (TextView) view.findViewById(R.id.test_row_name);
            subjectNameView = (TextView) view.findViewById(R.id.test_row_subjectName);
            numberOfParticipantsView = (TextView) view.findViewById(R.id.test_row_numberOfParticipants);
            averageScoreView = (TextView) view.findViewById(R.id.test_row_averageScore);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + testNameView.getText() + "'";
        }
    }
}
