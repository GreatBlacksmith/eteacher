package com.tvz.karlokovac.eteacher.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.data.Subject;
import com.tvz.karlokovac.eteacher.dummy.DummyContent.DummyItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class MySubjectRecyclerViewAdapter extends RecyclerView.Adapter<MySubjectRecyclerViewAdapter.ViewHolder> {

    private final List<Subject> subjects;
    private final OnListFragmentInteractionListener mListener;

    public MySubjectRecyclerViewAdapter(List<Subject> items, OnListFragmentInteractionListener listener) {
        subjects = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_subject, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.subject = subjects.get(position);
        holder.subjectImage.setImageDrawable(subjects.get(position).getImage());
        holder.subjectName.setText(subjects.get(position).getName());

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction("Subject",holder.subject);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return subjects.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final ImageView subjectImage;
        public final TextView subjectName;
        public Subject subject;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            subjectImage = (ImageView) view.findViewById(R.id.subject_image);
            subjectName = (TextView) view.findViewById(R.id.subject_name);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + subjectName.getText() + "'";
        }
    }
}
