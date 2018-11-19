package com.rock.reward.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import com.rock.reward.volleyWebservice.Constants;
import com.rock.reward.R;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.extras.CategorySpinner;
import com.rock.reward.model.Category;
import com.rock.reward.model.Country;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilterCampaign.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilterCampaign#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilterCampaign extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private ArrayList<Category> category;
    private ArrayList<Country> country;
    private Spinner categorySpinner;
    private Spinner countrySpinner;

    private ArrayList<String> categorylist;
    private ArrayList<String> countryList;

    private View view;

    private EditText projectName;
    private EditText cityName;

    private RadioGroup goalType;
    private RadioGroup goalSize;
    private RadioGroup status;

    private RadioButton radioGoalType;
    private RadioButton radioGoalSize;
    private RadioButton radioStatus;

    private int goalTypeValue;
    private int goalSizeValue;
    private int goalStatusValue;


    private Button searchButton;

    private Bundle bundle;
    private Bundle browseBundle;

    private CategorySpinner categorySpinnerClass;



    public FilterCampaign() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilterCampaign.
     */
    // TODO: Rename and change types and number of parameters
    public static FilterCampaign newInstance(String param1, String param2) {
        FilterCampaign fragment = new FilterCampaign();
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
            country = b.getParcelableArrayList("countryList");
            browseBundle = b.getBundle("browseBundle");
            if(browseBundle!=null){
                Log.e("browseBundle",browseBundle.getString(Constants.TITLE));

            }

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_filter_campaign, container, false);

        categorySpinner = (Spinner)view.findViewById(R.id.select_category);
        countrySpinner = (Spinner)view.findViewById(R.id.select_country);

        ArrayAdapter adp = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, category);
        adp.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adp);

        ArrayAdapter adpCountry = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, country);
        adpCountry.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        countrySpinner.setAdapter(adpCountry);

        status = (RadioGroup)view.findViewById(R.id.rg_status);
        goalSize = (RadioGroup)view.findViewById(R.id.rg_goal_size);
        goalType = (RadioGroup)view.findViewById(R.id.rg_goal_type);

        projectName = (EditText)view.findViewById(R.id.by_name);
        cityName = (EditText)view.findViewById(R.id.by_city);
        bundle = new Bundle();

        searchButton = (Button)view.findViewById(R.id.search_project);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFilteredProjects();
            }
        });

        if(browseBundle!=null){
            projectName.setText(browseBundle.getString(Constants.TITLE));
            cityName.setText(browseBundle.getString(Constants.CITY));

            categorySpinner.setSelection(browseBundle.getInt(Constants.CATEGORY_ID));
            countrySpinner.setSelection(browseBundle.getInt(Constants.COUNTRY_ID));

            switch (browseBundle.getInt(Constants.GOAL_TYPE)){
                case 0:
                    goalType.check(R.id.rb_all_type);
                    break;
                case 1:
                    goalType.check(R.id.rb_flexibel_type);
                    break;
                case 2:
                    goalType.check(R.id.rb_fixed_type);
                    break;
            }

            switch (browseBundle.getInt(Constants.GOAL_SIZE)){
                case 0:
                    goalSize.check(R.id.rb_all_goal_size);
                    break;
                case 1:
                    goalSize.check(R.id.rb_first_goal_size);
                    break;
                case 2:
                    goalSize.check(R.id.rb_second_goal_size);
                    break;
                case 3:
                    goalSize.check(R.id.rb_third_goal_size);
                    break;
                case 4:
                    goalSize.check(R.id.rb_fourth_goal_size);
                    break;
            }

            switch (browseBundle.getInt(Constants.STATUS)){
                case 0:
                    status.check(R.id.rb_all_status);
                    break;
                case 1:
                    status.check(R.id.rb_open_status);
                    break;
                case 2:
                    status.check(R.id.rb_success_status);
                    break;
                case 3:
                    status.check(R.id.rb_ended_status);
                    break;
            }
        }

        return view;
    }

    public void getFilteredProjects(){

        int selectedStatus = status.getCheckedRadioButtonId();
        int selectedGoalType = goalType.getCheckedRadioButtonId();
        int selectedGoalSize = goalSize.getCheckedRadioButtonId();

        radioGoalType = (RadioButton)view.findViewById(selectedGoalType);
        radioGoalSize = (RadioButton)view.findViewById(selectedGoalSize);
        radioStatus = (RadioButton)view.findViewById(selectedStatus);

        switch (radioGoalSize.getText().toString()){
            case "All":
                goalSizeValue = 0;
                break;
            case "0% - 25%":
                goalSizeValue = 1;
                break;
            case "25% - 50%":
                goalSizeValue = 2;
                break;
            case "50% - 75%":
                goalSizeValue = 3;
                break;
            case "75% - 100+%":
                goalSizeValue = 4;
                break;
        }

        switch (radioGoalType.getText().toString()){
            case "All":
                goalTypeValue = 0;
                break;
            case "Flexible":
                goalTypeValue = 1;
                break;
            case "Fixed":
                goalTypeValue = 2;
                break;
        }

        switch (radioStatus.getText().toString()){
            case "All":
                goalStatusValue = 0;
                break;
            case "Open":
                goalStatusValue = 1;
                break;
            case "Success":
                goalStatusValue = 2;
                break;
            case "Ended":
                goalStatusValue = 3;
                break;
        }

        bundle.putString(Constants.TITLE,projectName.getText().toString());
        bundle.putString(Constants.CITY,cityName.getText().toString());

        bundle.putInt(Constants.GOAL_TYPE,goalTypeValue);
        bundle.putInt(Constants.STATUS,goalStatusValue);
        bundle.putInt(Constants.GOAL_SIZE,goalSizeValue);
        bundle.putInt(Constants.CATEGORY_ID, (int) categorySpinner.getSelectedItemId());
        bundle.putInt(Constants.COUNTRY_ID  ,(int) countrySpinner.getSelectedItemId());

        mListener.onFilterCampaign(bundle);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Bundle bundle) {
        if (mListener != null) {
            mListener.onFilterCampaign(bundle);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFilterCampaign(Bundle bundle);
    }
}
