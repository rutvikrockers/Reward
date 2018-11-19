package com.rock.reward.activity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.IdRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.NavUtils;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import com.rock.reward.volleyWebservice.Constants;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;
import com.rock.reward.R;
import com.rock.reward.TabActivityAction;
import com.rock.reward.fragment.CardBackFragment;
import com.rock.reward.fragment.FilterCampaign;
import com.rock.reward.fragment.FilterCampaignList;
import com.rock.reward.fragment.HomeFragment;

import com.rock.reward.fragment.LoginCheckFragment;
import com.rock.reward.fragment.LoginFragment;
import com.rock.reward.fragment.MyActivityFragment;
import com.rock.reward.fragment.ProjectFollowingFragment;
import com.rock.reward.fragment.SignUpFragment;
import com.rock.reward.fragment.SocialLoginFragment;
import com.rock.reward.localStorage.PreferencesHelper;
import com.rock.reward.model.Category;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

public class HomeActivity extends AppCompatActivity implements
        HomeFragment.OnFragmentInteractionListener,
        LoginFragment.OnFragmentInteractionListener,
        CardBackFragment.OnCategoryListFragmentListener,
        LoginCheckFragment.OnFragmentInteractionListener,
        ProjectFollowingFragment.OnFragmentInteractionListener,
        MyActivityFragment.OnFragmentInteractionListener,
        SignUpFragment.OnFragmentInteractionListener,
        FilterCampaign.OnFragmentInteractionListener,
        FilterCampaignList.OnFragmentInteractionListener,
        SocialLoginFragment.OnFragmentInteractionListener,
        android.app.FragmentManager.OnBackStackChangedListener{

    public BottomBar mBottomBar;
    private static final String TWITTER_KEY = "rpyF80W7RZaSpWlLDjLXfjztU";
    private static final String TWITTER_SECRET = "vRX7lLV6RPdlPnge8S7yQiYL9cPHm9SMwKehph9VQ5Zn2slfo0";

    private String categoryId;

    private Bundle categoriesBundle;
    private Bundle args;
    private Bundle browseBundle;

    public PreferencesHelper preferencesHelper;
    CallbackManager callbackManager;

    /**
     * A handler object, used for deferring UI operations.
     */
    private Handler mHandler = new Handler();

    /**
     * Whether or not we're showing the back of the card (otherwise showing the front).
     */
    private boolean mShowingBack = false;
    private Toolbar toolbar;
    private String categorryid = "";
    private boolean showCategorySearch=true;
    private boolean showSearch=false;
    private boolean showCancelNavigation=false;
    ArrayList<Category> categories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        /*Twitter sdk initialise*/
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));

        FacebookSdk.sdkInitialize(getApplicationContext());

        setContentView(R.layout.activity_home);

        /*Toolbar*/
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        try {
            PackageInfo info = getPackageManager().getPackageInfo("com.rock.rockers.thecrowd",
                    PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures) {
                MessageDigest md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                Log.e("KeyHash:", Base64.encodeToString(md.digest(), Base64.DEFAULT));
            }
        } catch(PackageManager.NameNotFoundException| NoSuchAlgorithmException e) {
        }
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(Constants.REWARD);
        }

        //Init PreferencesHelper
        preferencesHelper = new PreferencesHelper(HomeActivity.this);

        mBottomBar = BottomBar.attachShy((CoordinatorLayout) findViewById(R.id.myCoordinator),
                findViewById(R.id.myScrollingContent), savedInstanceState);

        mBottomBar.setItems(R.menu.bottombar_menu);

        mBottomBar.setOnMenuTabClickListener(new OnMenuTabClickListener() {
            @Override
            public void onMenuTabSelected(@IdRes int menuItemId) {

                showCategorySearch=false;
                showSearch=false;
                showCancelNavigation=false;
                invalidateOptionsMenu();

                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user selected item number one.

                    HomeFragment fragment = new HomeFragment();
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, fragment);
                    fragmentTransaction.commit();
                    getSupportActionBar().setTitle(Constants.REWARD);

                    showCategorySearch=true;
                    invalidateOptionsMenu();

                }
                if (menuItemId == R.id.bottomBarItemTwo) {
                    // The user selected item number one.


                    if(categoriesBundle.getParcelableArrayList("countryList")!=null && categoriesBundle.getParcelableArrayList("categoryList")!=null){
                        FilterCampaign fragment = new FilterCampaign();
                        categoriesBundle.putBundle("browseBundle",browseBundle);
                        fragment.setArguments(categoriesBundle);
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container, fragment);
                        fragmentTransaction.commit();
                        getSupportActionBar().setTitle(Constants.ADVANCE_SEARCH);

                    }
                }
                if (menuItemId == R.id.bottomBarItemThree) {
                    // The user selected item number one.

                    if(preferencesHelper.getPrefBoolean(preferencesHelper.USER_LOGGED_IN)){
                        ProjectFollowingFragment fragment = new ProjectFollowingFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container, fragment);
                        fragmentTransaction.commit();
                    }else{
                        LoginCheckFragment fragment = new LoginCheckFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
                        fragmentTransaction.replace(R.id.frame_container, fragment);
                        fragmentTransaction.commit();
                    }

                    getSupportActionBar().setTitle(Constants.FAVOURITES);
//                    mBottomBar.setVisibility(View.GONE);
                }
                if (menuItemId == R.id.bottomBarItemFour) {
                    // The user selected item number one.

                    if(preferencesHelper.getPrefBoolean(preferencesHelper.USER_LOGGED_IN)){
                        MyActivityFragment fragment = new MyActivityFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container, fragment);
                        fragmentTransaction.commit();
                    }else{
                        LoginCheckFragment fragment = new LoginCheckFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
                        fragmentTransaction.replace(R.id.frame_container, fragment);
                        fragmentTransaction.commit();
                    }
                    getSupportActionBar().setTitle(Constants.ACTIVITY);


//                    mBottomBar.setVisibility(View.GONE);
                }
                if(menuItemId == R.id.bottomBarItemFive){
                    if(preferencesHelper.getPrefBoolean(preferencesHelper.USER_LOGGED_IN)){
                        Intent intent = new Intent(HomeActivity.this, TabActivityAction.class);
                        startActivity(intent);

                    }else{
                        LoginCheckFragment fragment = new LoginCheckFragment();
                        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
                        fragmentTransaction.replace(R.id.frame_container, fragment);
                        fragmentTransaction.commit();
                    }
                    getSupportActionBar().setTitle(Constants.ACTIVITY);
                }

            }

            @Override
            public void onMenuTabReSelected(@IdRes int menuItemId) {
                if (menuItemId == R.id.bottomBarItemOne) {
                    // The user reselected item number one, scroll your content to top.
                }
            }
        });

        // Setting colors for different tabs when there's more than three of them.
        // You can set colors for tabs in three different ways as shown below.
        mBottomBar.mapColorForTab(0, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(1, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(2, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(3, ContextCompat.getColor(this, R.color.colorAccent));
        mBottomBar.mapColorForTab(4, ContextCompat.getColor(this, R.color.colorAccent));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Necessary to restore the BottomBar's state, otherwise we would
        // lose the current tab on orientation change.
        mBottomBar.onSaveInstanceState(outState);
    }

    @Override
    public void onFragmentInteraction() {
        findViewById(R.id.bottomBarItemOne).performClick();

//        HomeFragment fragment = new HomeFragment();
//        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//        fragmentTransaction.replace(R.id.frame_container, fragment);
//        fragmentTransaction.commit();
//        mBottomBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void onHomeFragment(String task) {
        if(task=="register"){
            SignUpFragment fragment = new SignUpFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.frame_container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(Constants.REGISTER);
        }
    }

    @Override
    public void onSocialFragment(Bundle bundle) {
        SocialLoginFragment fragment = new SocialLoginFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle(Constants.REGISTER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        FragmentManager fragment = getSupportFragmentManager();
        if (fragment != null) {
            fragment.findFragmentById(R.id.frame_container).onActivityResult(requestCode, resultCode, data);
        }else{
            Log.d("Twitter", "fragment is null");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.toolbar_menu, menu);

        MenuItem item = menu.add(Menu.NONE, R.id.action_flip, Menu.NONE,
                mShowingBack
                        ? R.string.action_photo
                        : R.string.action_info);
        item.setIcon(mShowingBack
                ? R.drawable.ic_action_photo
                : R.drawable.ic_category);
        item.setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);
        item.setVisible(showCategorySearch);

        MenuItem itemsearch = menu.findItem(R.id.icSearch);
        itemsearch.setVisible(showSearch);

        MenuItem itemcancel = menu.findItem(R.id.cancel_ac);
        itemcancel.setVisible(showCancelNavigation);

        return true;
    }

    private void flipCard() {

        if (mShowingBack) {
            getFragmentManager().popBackStack();
            return;
        }

        if(categoriesBundle.getParcelableArrayList("categoryList")!=null){
            ArrayList<Category> category = categoriesBundle.getParcelableArrayList("categoryList");
            String name =  category.get(0).getProjectCategoryName();

            CardBackFragment fragInfo = new CardBackFragment();
            fragInfo.setArguments(categoriesBundle);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right);
            transaction.replace(R.id.frame_container, fragInfo);
            transaction.commit();
            showCancelNavigation=true;
            showSearch=false;
            showCategorySearch=false;
            invalidateOptionsMenu();
            getSupportActionBar().setTitle(Constants.CATEGORIES);

        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // Navigate "up" the demo structure to the launchpad activity.
                // See http://developer.android.com/design/patterns/navigation.html for more.
                NavUtils.navigateUpTo(this, new Intent(this, HomeActivity.class));
                return true;

            case R.id.action_flip:
                flipCard();
                return true;

            case R.id.icSearch:
                if(categoriesBundle.getParcelableArrayList("countryList")!=null && categoriesBundle.getParcelableArrayList("categoryList")!=null){
                    FilterCampaign fragment = new FilterCampaign();
                    categoriesBundle.putBundle("browseBundle",browseBundle);
                    fragment.setArguments(categoriesBundle);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frame_container, fragment);
                    fragmentTransaction.commit();
                }
                showCategorySearch=false;
                showSearch=true;
                invalidateOptionsMenu();
                return true;

            case R.id.cancel_ac:
                HomeFragment fragment = new HomeFragment();
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, fragment);
                fragmentTransaction.commit();
                showCategorySearch=true;
                showCancelNavigation=false;
                invalidateOptionsMenu();

                String CategoryName = this.preferencesHelper.getPrefString(PreferencesHelper.CATEGORY_NAME);

                if(CategoryName!=null)getSupportActionBar().setTitle(CategoryName);
                else getSupportActionBar().setTitle(Constants.REWARD);

                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackStackChanged() {
        mShowingBack = (getFragmentManager().getBackStackEntryCount() > 0);

        // When the back stack changes, invalidate the options menu (action bar).
        invalidateOptionsMenu();
    }

    @Override
    public void onFragmentInteraction(Bundle bundle) {
        this.categoriesBundle = bundle;

    }

    @Override
    public void OnCategoryListFragment(String categoryId, String categoryName, int status) {
        args = new Bundle();
        args.putString(Constants.CATEGORY_ID,categoryId);

        if(categoryName!=null)getSupportActionBar().setTitle(categoryName);

        HomeFragment fragment = new HomeFragment();
        if(status!=2){
            fragment.setArguments(args);
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
        showCategorySearch=true;
        showCancelNavigation=false;
        invalidateOptionsMenu();
    }

    @Override
    public void onFragmentInteraction(String string) {
        if(string=="login"){
//            findViewById(R.id.bottomBarItemTwo).performClick();

            LoginFragment fragment = new LoginFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
            fragmentTransaction.replace(R.id.frame_container, fragment);
            fragmentTransaction.commit();
            getSupportActionBar().setTitle(Constants.LOGIN);


//            mBottomBar.setVisibility(View.GONE);
        }
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onSignUpFragment(String msg) {
        Log.e("signup","signuphomee");

        if (msg == "login") {
            LoginFragment fragment = new LoginFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
            fragmentTransaction.replace(R.id.frame_container, fragment);
            fragmentTransaction.commit();
        }
        else if(msg == "home"){
            HomeFragment fragment = new HomeFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
            fragmentTransaction.replace(R.id.frame_container, fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onSocialSignupFragment(Bundle bundle) {
        SocialLoginFragment fragment = new SocialLoginFragment();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
        getSupportActionBar().setTitle(Constants.REGISTER);
    }

    @Override
    public void onFilterCampaign(Bundle bundle) {
        FilterCampaignList fragment = new FilterCampaignList();
        fragment.setArguments(bundle);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();

        showCategorySearch=false;
        showSearch=true;

        invalidateOptionsMenu();
    }

    @Override
    public void onSocialLoginInteraction() {
        HomeFragment fragment = new HomeFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.setCustomAnimations(R.anim.slide_in_bottom, R.anim.slide_out_top);
        fragmentTransaction.replace(R.id.frame_container, fragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onFragmentInteractionProjectFilter(Bundle bundle) {
        browseBundle = bundle;
    }

    boolean doubleBackToExitPressedOnce = false;

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }

}
