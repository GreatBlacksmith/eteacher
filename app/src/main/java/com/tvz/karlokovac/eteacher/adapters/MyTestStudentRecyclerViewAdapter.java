package com.tvz.karlokovac.eteacher.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.data.TestStudent;
import com.tvz.karlokovac.eteacher.fragments.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class MyTestStudentRecyclerViewAdapter extends RecyclerView.Adapter<MyTestStudentRecyclerViewAdapter.ViewHolder> {

    private final List<TestStudent> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyTestStudentRecyclerViewAdapter(List<TestStudent> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_teststudemt, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.testStudentNameView.setText(mValues.get(position).getStudentName());
        holder.testStudentScoreView.setText(mValues.get(position).getScore());
        holder.testStudentCommentView.setText(mValues.get(position).getComment());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction("TestStudent", holder.mItem);
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
        public final TextView testStudentNameView;
        public final TextView testStudentScoreView;
        public final TextView testStudentCommentView;
        public TestStudent mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            testStudentNameView = (TextView) view.findViewById(R.id.testStudent_row_studentName);
            testStudentScoreView = (TextView) view.findViewById(R.id.testStudent_row_score);
            testStudentCommentView = (TextView) view.findViewById(R.id.testStudent_row_comment);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + testStudentNameView.getText() + "'";
        }
    }
}
