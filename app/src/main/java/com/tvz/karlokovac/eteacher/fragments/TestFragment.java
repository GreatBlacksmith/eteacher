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

import com.negusoft.compountadapter.recyclerview.AdapterGroup;
import com.negusoft.compountadapter.recyclerview.SingleAdapter;
import com.tvz.karlokovac.eteacher.OnListFragmentInteractionListener;
import com.tvz.karlokovac.eteacher.R;
import com.tvz.karlokovac.eteacher.adapters.MyTestRecyclerViewAdapter;
import com.tvz.karlokovac.eteacher.data.Test;
import com.tvz.karlokovac.eteacher.fragments.dummy.DummyContent;
import com.tvz.karlokovac.eteacher.fragments.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class TestFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TestFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static TestFragment newInstance(int columnCount) {
        TestFragment fragment = new TestFragment();
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
        View view = inflater.inflate(R.layout.fragment_test_list, container, false);

        List<Test> tests = new ArrayList<>();
        tests.add(new Test ("Zbrajanje", "Matematika", "20", "89"));
        tests.add(new Test ("Oduzimanje", "Matematika", "19", "79"));
        tests.add(new Test ("Životinje", "Priroda i društvo", "22", "97"));
        tests.add(new Test ("Recitacije", "Hrvatski jezik", "22", "88"));


        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            AdapterGroup adapterGroup = new AdapterGroup();
            adapterGroup.addAdapter(SingleAdapter.create(R.layout.test_recycleview_header));
            adapterGroup.addAdapter(new MyTestRecyclerViewAdapter(tests, mListener));

            recyclerView.setAdapter(adapterGroup);
        }
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
