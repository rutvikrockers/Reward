package com.rock.reward.fragment;

import android.content.Context;
import android.os.Bundle;
//import android.app.Fragment;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.rock.reward.R;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.adapter.CategoryListAdapter;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Category;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CardBackFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CardBackFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private View view;
    private RecyclerView recyclerView;
    private Context context;
    private String token;
    private CategoryListAdapter categoryListAdapter;
    private TextView tvNoDataFound;
    private ArrayList<Category> category;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Bundle bundle;
    private String categoryId;

    private OnCategoryListFragmentListener mListener;



    public CardBackFragment() {
        // Required empty public constructor
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(String categoryId, String categoryName,int status) {
        Log.e("categoryId",categoryId);
        if (mListener != null) {
            if(status==2){
                ((HomeActivity) getActivity()).preferencesHelper.putPrefString(PreferencesHelper.CATEGORY_ID, null);
                ((HomeActivity) getActivity()).preferencesHelper.putPrefString(PreferencesHelper.CATEGORY_NAME, null);
            }else{
                ((HomeActivity) getActivity()).preferencesHelper.putPrefString(PreferencesHelper.CATEGORY_ID, categoryId);
                ((HomeActivity) getActivity()).preferencesHelper.putPrefString(PreferencesHelper.CATEGORY_NAME, categoryName);
            }

            mListener.OnCategoryListFragment(categoryId,categoryName,status);
        }
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CardBackFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CardBackFragment newInstance(String param1, String param2) {
        CardBackFragment fragment = new CardBackFragment();
        Bundle args = new Bundle();

        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((HomeActivity) getActivity()).getSupportActionBar().show();
        ((HomeActivity) getActivity()).mBottomBar.setVisibility(View.VISIBLE);


        if (getArguments() != null) {
            Bundle b = this.getArguments();
            category = b.getParcelableArrayList("categoryList");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_card_back, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.category_list);
        tvNoDataFound = (TextView) view.findViewById(R.id.tv_no_data_found);
        context = view.getContext();

        getCategories();

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnCategoryListFragmentListener) {
            mListener = (OnCategoryListFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    private void getCategories(){

        try {
            Log.i("categ","Home Categories"+category.size());
            if(category.size()>0){
                recyclerView.setLayoutManager(new GridLayoutManager(context,2));
                categoryListAdapter = new CategoryListAdapter(category,getActivity(),CardBackFragment.this);
                recyclerView.setAdapter(categoryListAdapter);
            }else{
                recyclerView.setVisibility(View.GONE);
                tvNoDataFound.setVisibility(View.VISIBLE);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public interface OnCategoryListFragmentListener {
        // TODO: Update argument type and name
        void OnCategoryListFragment(String categoryId, String categoryName,int status);
    }

}
