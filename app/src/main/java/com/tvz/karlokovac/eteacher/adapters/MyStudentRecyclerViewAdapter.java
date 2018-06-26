package com.tvz.karlokovac.eteacher.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.data.Student;
import com.tvz.karlokovac.eteacher.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MyStudentRecyclerViewAdapter extends RecyclerView.Adapter<MyStudentRecyclerViewAdapter.ViewHolder> {

    private final List<Student> mValues;
    private final OnListFragmentInteractionListener mListener;

    public MyStudentRecyclerViewAdapter(List<Student> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_student, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        //holder.mIdView.setText(mValues.get(position).id);
        holder.studentNameView.setText(mValues.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction("Student",holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public final View mView;
        public final TextView studentNameView;
        //public final TextView studentAgeView;
        public Student mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            studentNameView = (TextView) view.findViewById(R.id.student_record_name);
            //view.setOnClickListener(this);
           // studentAgeView = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + studentNameView.getText() + "'";
        }

//        @Override
//        public void onClick(View view) {
//            if (onStudentClick != null) onStudentClick.onStudentInListClick(view, getAdapterPosition(), this.studentNameView.getText().toString());
//        }
    }
}
