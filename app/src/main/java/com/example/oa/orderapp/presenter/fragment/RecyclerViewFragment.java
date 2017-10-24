package com.example.oa.orderapp.presenter.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

import com.example.oa.orderapp.R;
import com.example.oa.orderapp.presenter.adapter.CustomAdapter;

import io.realm.RealmList;
import io.realm.RealmObject;

/**
 * Created by Phoenix on 7/10/17.
 */
public abstract class RecyclerViewFragment<T extends RealmObject> extends BaseFragment {

    private static final String TAG = "RecyclerViewFragment";
    public static final String KEY_LAYOUT_MANAGER = "layoutManager";
    public static final int TYPE_VERTICAL_LIST = 0;
    public static final int TYPE_HORIZONTAL_LIST = 1;
    public static final int TYPE_GRID = 2;
    public static final int TYPE_STAGGERD_GRID = 3;
    private static final int SPAN_COUNT = 2;

    protected Integer mCurrentLayoutManagerType;

    protected RadioButton mLinearLayoutRadioButton;
    protected RadioButton mGridLayoutRadioButton;

    protected RecyclerView mRecyclerView;
    protected CustomAdapter mAdapter;
    protected RecyclerView.LayoutManager mLayoutManager;
    protected RealmList<T> mDataset;

    public  Callback<T> callback;

    public interface Callback<T> {
        void onMenuItemClick(T item, boolean b);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle b = getArguments();
        if (b != null)
            mCurrentLayoutManagerType = getArguments().getInt(KEY_LAYOUT_MANAGER);
    }

    public void setCallback(Callback<T> callback) {
        this.callback = callback;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.recycler_view_frag, container, false);
        rootView.setTag(TAG);

        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        mAdapter = new CustomAdapter();

        if (savedInstanceState != null) {
            // Restore saved layout manager type.
            mCurrentLayoutManagerType = (Integer) savedInstanceState
                    .getInt(KEY_LAYOUT_MANAGER);
        }
        setRecyclerViewLayoutManager(mCurrentLayoutManagerType);


        mRecyclerView.setAdapter(mAdapter);

        initData();

        return rootView;
    }

    abstract void initData();

    /**
     * Set RecyclerView's LayoutManager to the one given.
     *
     * @param layoutManagerType Type of layout manager to switch to.
     */
    public void setRecyclerViewLayoutManager(int layoutManagerType) {
        int scrollPosition = 0;

        // If a layout manager has already been set, get current scroll position.
        if (mRecyclerView.getLayoutManager() != null) {
            scrollPosition = ((LinearLayoutManager) mRecyclerView.getLayoutManager())
                    .findFirstCompletelyVisibleItemPosition();
        }

        switch (layoutManagerType) {
            case TYPE_GRID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
//                mAdapter.setType(TYPE_GRID);
                mCurrentLayoutManagerType = TYPE_GRID;
                break;
            case TYPE_STAGGERD_GRID:
                mLayoutManager = new GridLayoutManager(getActivity(), SPAN_COUNT);
//                mAdapter.setType(TYPE_STAGGERD_GRID);
                mCurrentLayoutManagerType = TYPE_STAGGERD_GRID;
                break;
            case TYPE_VERTICAL_LIST:
                mLayoutManager = new LinearLayoutManager(getActivity());
//                mAdapter.setType(TYPE_VERTICAL_LIST);
                mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
                break;
            case TYPE_HORIZONTAL_LIST:
                mLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
                mCurrentLayoutManagerType = TYPE_HORIZONTAL_LIST;
                break;
            default:
                mLayoutManager = new LinearLayoutManager(getActivity());
                mCurrentLayoutManagerType = TYPE_VERTICAL_LIST;
        }

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.scrollToPosition(scrollPosition);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save currently selected layout manager.
        savedInstanceState.putSerializable(KEY_LAYOUT_MANAGER, mCurrentLayoutManagerType);
        super.onSaveInstanceState(savedInstanceState);
    }
}
