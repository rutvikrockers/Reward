package com.rock.reward.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.rock.reward.volleyWebservice.Constants;
import com.rock.reward.R;
import com.rock.reward.fragment.userProfile.UserCommentsFragment;
import com.rock.reward.fragment.userProfile.UserCreatedCampaignsFragment;
import com.rock.reward.fragment.userProfile.UserFollowersFragment;
import com.rock.reward.fragment.userProfile.UserOverviewFragment;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.ProfileData;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements
        UserCommentsFragment.OnFragmentInteractionListener,
        UserOverviewFragment.OnFragmentInteractionListener,
        UserFollowersFragment.OnFragmentInteractionListener,
        UserCreatedCampaignsFragment.OnFragmentInteractionListener {

    public PreferencesHelper preferencesHelper;
    private String token;
    public String userId;
    private ProfileData profileData;

    public TextView userName;
    private TextView comments;

    public ImageView fbIcon;
    public ImageView twIcon;
    public ImageView lnIcon;
    public ImageView googleIcon;
    public ImageView youtubeIcon;
    public ImageView mySpaceIcon;

    public ImageView userImage;
    public ImageView userImageCircular;

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private Bundle bundle;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    private int[] tabIcons = {
            R.drawable.ic_followers_24,
            R.drawable.ic_created_campaigns_24,
            R.drawable.ic_comments_24,
            R.drawable.ic_user_overview_24,
    };

    TabLayout tabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        preferencesHelper = new PreferencesHelper(ProfileActivity.this);

        comments = (TextView)findViewById(R.id.comments_count);
        userImage = (ImageView)findViewById(R.id.user_image);
        userImageCircular = (ImageView)findViewById(R.id.user_image_circular);
        userName = (TextView)findViewById(R.id.user_name);

        fbIcon = (ImageView)findViewById(R.id.fb_icon);
        twIcon = (ImageView)findViewById(R.id.tw_icon);
        lnIcon = (ImageView)findViewById(R.id.ln_icon);
        googleIcon = (ImageView)findViewById(R.id.google_icon);
        mySpaceIcon = (ImageView)findViewById(R.id.myspace_icon);
        youtubeIcon = (ImageView)findViewById(R.id.youtube_icon);

        final Intent intent = getIntent();
        userId = intent.getStringExtra(Constants.USER_ID);


//        Log.e("user",userId);

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
    }


    private void setupViewPager(ViewPager viewPager) {
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mSectionsPagerAdapter.addFrag(UserOverviewFragment.newInstance(userId), "ONE");
        mSectionsPagerAdapter.addFrag(UserCreatedCampaignsFragment.newInstance(userId), "TWO");
        mSectionsPagerAdapter.addFrag(UserCommentsFragment.newInstance(userId), "THREE");
        mSectionsPagerAdapter.addFrag(UserFollowersFragment.newInstance(userId), "FOUR");
        viewPager.setAdapter(mSectionsPagerAdapter);
    }
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("Overview");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,tabIcons[0], 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("Created Projects");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[1], 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("Comments");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[2], 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabFour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabFour.setText("Followers");
        tabFour.setCompoundDrawablesWithIntrinsicBounds(0, tabIcons[3], 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabFour);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_user_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_edit_profile) {
            Intent intent = new Intent(ProfileActivity.this,EditUserProfileActivity.class);
            intent.putExtra(Constants.USER_PROFILE_DATA,bundle);
            startActivity(intent);
            return true;
        }
        if (id == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onFragmentInteraction(Bundle uri) {
        bundle = uri;
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
