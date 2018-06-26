package com.tvz.karlokovac.eteacher.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.adapters.MySubjectStudentRecyclerViewAdapter;
import com.tvz.karlokovac.eteacher.data.StudentInSubject;
import com.tvz.karlokovac.eteacher.data.Subject;
import com.tvz.karlokovac.eteacher.data.SubjectStudent;
import com.tvz.karlokovac.eteacher.dummy.DummyContent;
import com.tvz.karlokovac.eteacher.dummy.DummyContent.DummyItem;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class SubjectStudentFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    private TextView subjectNameView;
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private ArrayList studentsInSubject = new ArrayList<StudentInSubject>();
    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public SubjectStudentFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static SubjectStudentFragment newInstance(int columnCount) {
        SubjectStudentFragment fragment = new SubjectStudentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_subjectstudent_list, container, false);
        RecyclerView list = view.findViewById(R.id.subjectstudent_list);
        ArrayList<String> grades = new ArrayList<>();
        grades.add("4");
        grades.add("5");
        grades.add("3");
        grades.add("4");
        grades.add("5");
        grades.add("3");

        studentsInSubject = new ArrayList();
        StudentInSubject studentInSubject1 = new StudentInSubject("Marko", grades);
        StudentInSubject studentInSubject2 = new StudentInSubject("Iva", grades);
        StudentInSubject studentInSubject3 = new StudentInSubject("Anđela", grades);

        studentsInSubject.add(studentInSubject1);
        studentsInSubject.add(studentInSubject2);
        studentsInSubject.add(studentInSubject3);

        String subjectName = this.getArguments().getString("subjectName");

        // Set the adapter
        if (list instanceof RecyclerView) {
            Context context = list.getContext();
            RecyclerView recyclerView = (RecyclerView) list;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new MySubjectStudentRecyclerViewAdapter(studentsInSubject, mListener));
        }

        subjectNameView = (TextView) view.findViewById(R.id.subjectstudent_subject_name);
        subjectNameView.setText(subjectName);
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

}
