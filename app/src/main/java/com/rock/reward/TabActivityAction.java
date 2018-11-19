package com.rock.reward;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.rock.reward.activity.HomeActivity;
import com.rock.reward.activity.ProfileActivity;
import com.rock.reward.fragment.user_dashboard.MyCommentFragment;
import com.rock.reward.fragment.user_dashboard.MyFundFragment;
import com.rock.reward.fragment.user_dashboard.MyFundingFragment;
import com.rock.reward.fragment.user_dashboard.MyProjectList;
import com.rock.reward.fragment.user_dashboard.UserOverviewFragment;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.UserDashboardData;
import com.rock.reward.volleyWebservice.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class TabActivityAction extends AppCompatActivity implements
        UserOverviewFragment.OnFragmentInteractionListener,
        MyProjectList.OnFragmentInteractionListener,
        MyFundingFragment.OnFragmentInteractionListener,
        MyCommentFragment.OnFragmentInteractionListener,
        MyFundFragment.OnFragmentInteractionListener{

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private int[] tabIcons = {
            R.drawable.ic_dashboard_black_24dp,
            R.drawable.ic_toc_black_24dp,
            R.drawable.ic_monetization_on_black_24dp,
            R.drawable.ic_attach_money_black_24dp,
            R.drawable.ic_comment_black_24dp
    };

    TabLayout tabLayout;
    public PreferencesHelper preferencesHelper;

    private UserDashboardData userDashboardData;

    private ImageView userImage;
    private ImageView userImageCircular;
    private TextView userName;
    private TextView userJoined;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_activity_action);

        preferencesHelper = new PreferencesHelper(TabActivityAction.this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        }
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        setupViewPager(mViewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        setupTabIcons();

        userImage = (ImageView)findViewById(R.id.user_image);
        userImageCircular = (ImageView)findViewById(R.id.user_image_circular);
        userName = (TextView)findViewById(R.id.user_name);

        if(this.preferencesHelper.getPrefBoolean(PreferencesHelper.USER_LOGGED_IN)){
            String loginUser = (this.preferencesHelper.getPrefString(PreferencesHelper.USER_LOGIN));
            try {
                JSONObject jsonObject = new JSONObject(loginUser);
                Log.e("image",jsonObject+"");
                String image = jsonObject.getString("user_image_url");
//                getSupportActionBar().setTitle(projectDetailData.getProjectDetail().getProjectTitle());

                userName.setText(jsonObject.getString(Constants.FIRSTNAME)+" "+jsonObject.getString(Constants.LASTNAME));
                userId = jsonObject.getString(Constants.USER_ID);
                Glide.with(this)
                        .load(image)
                        .crossFade()
                        .into(userImage);

                Glide.with(this)
                        .load(image)
                        .crossFade()
                        .into(userImageCircular);

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFrag(new UserOverviewFragment(), "ONE");
        mSectionsPagerAdapter.addFrag(new MyProjectList(), "TWO");
        mSectionsPagerAdapter.addFrag(new MyFundingFragment(), "THREE");
        mSectionsPagerAdapter.addFrag(new MyFundFragment(), "FOUR");
//        mSectionsPagerAdapter.addFrag(new MyCommentFragment(), "FIVE");
        viewPager.setAdapter(mSectionsPagerAdapter);
    }


    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Overview");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,tabIcons[0], 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("My Projects");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[1], 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("My Funding");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[2], 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("My Fund");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[3], 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);

//        TextView tabFive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
//        tabFive.setText("My Comments");
//        tabFive.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[4], 0, 0);
//        tabLayout.getTabAt(4).setCustomView(tabFive);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_logout) {
            preferencesHelper.clearSpecificSharedPreferences(PreferencesHelper.USER_LOGIN);
            preferencesHelper.putPrefBoolean(PreferencesHelper.USER_LOGGED_IN,false);
            Intent intent = new Intent(TabActivityAction.this,HomeActivity.class);
            startActivity(intent);
            return true;
        }
        if (id == R.id.action_profile) {
            Intent intent = new Intent(TabActivityAction.this,ProfileActivity.class);
            intent.putExtra(Constants.USER_ID,userId);
            startActivity(intent);
            return true;
        }
        if (id == android.R.id.home) {
            Intent intent = new Intent(TabActivityAction.this,HomeActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_tab_activity_action, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}
