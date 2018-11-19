package com.rock.reward.volleyWebservice;


/**
 * The Class ConstantsLocal.
 */
public class ConstantsMain {

    /**
     * Request parameter
     */

    public static final String DEVELOPER_KEY = "AIzaSyADIiRkWm7-4VLIlwT7lOWmpQoi5MeIDUY";


    //GUEST LOGIN
    public static final String ENC_FIRST_PART="FS";
    public static final String ENC_LAST_PART="RT";
    public static final String ENC_KEY="crwsf";
    public static final String GUEST_TOKEN="fscrwsf-token";
    public static final String TOKEN="www-token";
    public static final String TOKEN_STR="token";
    public static final String ENC_IV="rotc.fscrw";

    public static final String OFFSET="offset";
    public static final String RECOMMENDED="Recommended";
    public static final String REWARD="Reward";


    //project detail
    public static final String PROJECT_ID="project_id";
    public static final String PERK_ID="perk_id";

    public static final String COMMENTS="comments";
    public static final String UPDATES="updates";
    public static final String FUNDERS="funders";
    public static final String FOLLOWERS="followers";
    public static final String TEAM_MEMBERS="team_members";

    public static final String TYPE_ID="type_id";
    public static final String TYPE="type";
    public static final String READ_STORY="read_story";






    public static final String CATEGORY_ID="category_id";
    public static final String COUNTRY_ID="country_id";
    public static final String GOAL_SIZE="goal_size";
    public static final String GOAL_TYPE="goal_type";
    public static final String CITY="city";
    public static final String TITLE="title";
    public static final String STATUS="status";
    public static final String ADVANCE_SEARCH="Advance Search";
    public static final String FAVOURITES="Favourites";
    public static final String ACTIVITY="Activity";
    public static final String PROFILE="Profile";
    public static final String LOGIN="Login";
    public static final String REGISTER="Register";
    public static final String CATEGORIES="Categories";


    public static final String SOCIAL_TYPE="social_type";
    public static final String SOCIAL_ID="social_id";
    public static final String SOCIAL_PROFILE_IMAGE="social_profile_image";
    public static final String TW_SCREEN_NAME="tw_screen_name";
    public static final String TW_OAUTH_TOKEN="tw_oauth_token";
    public static final String TW_OAUTH_TOKEN_SECRET="tw_oauth_token_secret";
    public static final String FB_ACCESS_TOKEN="fb_access_token";









    //Header request parameter
    public static final String CONTENT_TYPE = "Content-Type";
    public static final String CONTENT_TYPE_VALUE = "application/x-www-form-urlencoded";
//public static final String CONTENT_TYPE_VALUE = "application/json";
//    public static final String CONTENT_TYPE_VALUE = "multipart/form-data";





    //Login and register user API request parameter
    public static final String PHONE_NUMBER = "PhoneNumber";
    public static final String EMAIL = "email";
    public static final String FULL_NAME = "full_name";

    public static final String USER_ID = "user_id";

    public static final String FIRSTNAME = "first_name";
    public static final String LASTNAME = "last_name";
    public static final String PASSWORD = "password";
    public static final String MOBILE_NUMBER = "PhoneNumber";
    public static final String USER_IMAGE = "user_image_url";

    public static final String USER_LICENSE_DETAIL = "UserLicenseDetail";
    public static final String USER_LICENSE_CITY = "City";
    public static final String USER_LICENSE_DL_CLASS = "DLClass";
    public static final String USER_LICENSE_DATE_OF_BIRTH = "DateOfBirth";
    public static final String USER_LICENSE_EXPIRATION_DATE = "ExpirationDate";
    public static final String USER_LICENSE_HEIGHT = "Height";
    public static final String USER_LICENSE_ISSUE_DATE = "IssueDate ";
    public static final String USER_LICENSE_LICENSE_NUMBER = "LicenseNumber";
    public static final String USER_LICENSE_POSTAL_CODE = "PostalCode";
    public static final String USER_LICENSE_SEX = "Sex";
    public static final String USER_LICENSE_STATE = "State";
    public static final String USER_LICENSE_STREET_ADDRESS = "StreetAddress";
    public static final String USER_LICENSE_WEIGHT = "weight";

    public static final String USER_DEVICE_TRACKS = "Userdevicetracks";
    public static final String USER_DEVICE_HEIGHT = "DeviceHeight";
    public static final String USER_DEVICE_IMEI = "DeviceImei";
    public static final String USER_DEVICE_MENUFACTURE = "DeviceManufacture";
    public static final String USER_DEVICE_DEVICE_MODEL = "DeviceModel";
    public static final String USER_DEVICE_OS = "DeviceOs";
    public static final String USER_DEVICE_SCALE = "DeviceScale";
    public static final String USER_DEVICE_TOKEN = "DeviceToken";
    public static final String USER_DEVICE_TYPE = "DeviceType";
    public static final String USER_DEVICE_WIDTH = "DeviceWidth";

    // Parameters used in setting meeting point
    public static final String MEETING_ACCIDENT_REF = "AccidentRef";
    public static final String MEETING_AGREED_DATE = "AgreedDate";
    public static final String MEETING_AGREED_LATITUDE = "AgreedLatitude";
    public static final String MEETING_AGREED_LOCATION_TO_MEET = "AgreedLocationToMeet";
    public static final String MEETING_AGREED_LONGITUDE = "AgreedLongitude";
    public static final String MEETING_AGREED_TIME = "AgreedTime";
    public static final String MEETING_LATITUDE = "Latitude";
    public static final String MEETING_LONGITUDE = "Longitude";


    // Parameters used in Start Driving and Stop Driving Process
    public static final String DRIVING_ACCIDENT_ID = "AccidentId";
    public static final String DRIVING_GOTO_DRIVER = "GoToDriver";
    public static final String DRIVING_START_ADDRESS = "StartAddress";
    public static final String DRIVING_START_LATITUDE = "StartLatitude";
    public static final String DRIVING_START_LONGITUDE = "StartLongitude";
    public static final String DRIVING_END_ADDRESS = "EndAddress";
    public static final String DRIVING_END_LATITUDE = "EndLatitude";
    public static final String DRIVING_END_LONGITUDE = "EndLongitude";
    public static final String DRIVING_TRIP_ID = "id";

    public static final String OLD_PASSWORD = "OldPassword";
    public static final String NEW_PASSWORD = "NewPassword";

    //Generate Accident API request parameter
    public static final String ACCIDENT_CALL_NUMBER = "AccidentCallNumber";
    public static final String ACCIDENT_TYPE = "AccidentType";
    public static final String ACCIDENT_TYPE_DERID = "AccidentTypeDerId";
    public static final String DRIVER_LATITUDE = "DriverLatitude";
    public static final String DRIVER_LONGITUDE = "DriverLongitude";
    public static final String IP = "Ip";


    /**
     * Response parameter
     */

    //Common response param for the current Appointment
    public static final String DATA = "data";

    //Common response param
    public static final String CODE = "Code";
    public static final String SUCCESS = "success";




    public static final String MESSAGE = "message";
    public static final String Error = "Error";
    public static final String ERRORCODE = "error_code";

    public static String CURRENT_ACCIDENT_ID = "";
    public static double CURRENT_ACCIDENT_REFERENCE = 0;
    public static String CURRENT_ACCIDENT_LATITUDE = "";
    public static String CURRENT_ACCIDENT_LONGITUDE = "";

    public static String MEETING_POINT_LATITUDE = "";
    public static String MEETING_POINT_LONGITUDE = "";
    public static String AGREED_POINT_LATITUDE = "";
    public static String AGREED_POINT_LONGITUDE = "";


    // Store response value for further use in Start and stop driving details
    public static String CURRENT_TRIP_ID = "";
    public static String CURRENT_ADDRESS = "";
    public static String CURRENT_LATITUDE = "";
    public static String CURRENT_LONGITUDE = "";

    //------------ Google Places ConstantsLocal ------------
    public static final String PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place";
    public static final String TYPE_AUTOCOMPLETE = "/autocomplete";
    public static final String OUT_JSON = "/json";
    public static final String CANADA = "ca";
    public static final String USA = "usa";
    public static final String PLACES_API_KEY = "AIzaSyDnmlqPxUuRn4GurVxOCoz1AhulzxCX-r8";

    //------------ Google Static Image API ------------
//    https://maps.googleapis.com/maps/api/staticmap?&zoom=14&scale=2&size=600x300&path=color:%230000ff%7Cweight:5%7Cenc:qtcgCg`n}L@LCxBCpCKnDK`COpAmAOqBS_@?{@?JlCAb@OjAMf@C~@h@jD`@fDFb@LRPZN|@XbCHHHDx@CFbEHHx@L?vC_CZ}A?mACsFE}ACe@@_@HUH_@T]^aAzAvBRnFp@bAL&key=AIzaSyBXU48YWFJhOuh30uWZqfIhZnpk7DKy-Wc%20
    public static final String GOOGLE_IMAGE_API_PART1 = "https://maps.googleapis.com/maps/api/staticmap?&zoom=10&scale=2&size=";
    public static final String GOOGLE_IMAGE_API_PART2 = "&path=color:%230000ff%7Cweight:5%7Cenc:";
    public static final String GOOGLE_IMAGE_API_PART3 = "&key=AIzaSyBXU48YWFJhOuh30uWZqfIhZnpk7DKy-Wc%20";

    // Optional For staic map with marker
    public static final String GOOGLE_MARKER_IMAGE_API_PART1 = "https://maps.googleapis.com/maps/api/staticmap?&zoom=11&scale=2&size=";
    public static final String GOOGLE_MARKER_IMAGE_API_PART2 = "&sensor=true&markers=color:red|";

    // Get Latitude and Longitude from place id
    public static final String GOOGLE_LOCATION_PLACES_API_BASE = "https://maps.googleapis.com/maps/api/place/details/json?placeid=";
    public static final String GOOGLE_LOCATION_PLACES_API_KEY = "&key=";


    public static boolean isMEETING_SET = false;
    public static String SET_MEETING_ADDRESS = "meeting_address";
    public static double SET_MEETING_LONGITUDE = 0;
    public static double SET_MEETING_LATITUDE = 0;

    // constants used in adding new location
    public static boolean isLOCATION_ADD = false;
    public static String ADDRESS = "Address";
    public static String ISDEFAULT = "IsDefault";
    public static String LATITUDE = "Latitude";
    public static String LOCATION_NAME = "LocationName";
    public static String LONGITUDE = "Longitude";

    // constants used store value for location
    public static String VALUE_NEW_LOCATION_ADD = "";
    public static String VALUE_NEW_LONGITUDE = "";
    public static String VALUE_NEW_LATITUDE = "";

    // constants used store value for start driving distance and duration
    public static String DRIVING_ADDRESS = "";
    public static String DRIVING_DISTANCE = "";
    public static String DRIVING_DURATION = "";
    public static String DRIVING_LATITUDE = "";
    public static String DRIVING_LONGITUDE = "";

    // constant use to identify weather RECORD ARRIVAL done or START DRIVE [screen from location listing]
    public static boolean isRECORD_ARRIVAL = false;


    /**
     * The Class WebServiceUrls.
     */
    public class WebServiceUrls {


        /** The Constant API_DOMAIN. */
        /**
         * PRODUCTION ENV
         */
      //public static final String API_DOMAIN = "http://reward.crowdfundingscript.com/";

        /** TEST ENV */
     //  public static final String API_DOMAIN = "http://rockerstech.com/reward_development/";
       public static final String API_DOMAIN = "http://reward.crowdfundingscript.com/";
      // public static final String API_DOMAIN = "http://donation.crowdfundingscript.com/";

        /** QA ENV */
//        public static final String API_DOMAIN = "http://reward.crowdfundingscript.com/";

        /**
         * The Constant Login user
         */
        public static final String GUEST_LOGIN = API_DOMAIN + "api/login/guest";
        public static final String HOME = API_DOMAIN + "api/home/index";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_DETAIL = API_DOMAIN + "api/projectobj/detail";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_COMMENTS = API_DOMAIN + "api/projectobj/comments";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_UPDATES = API_DOMAIN + "api/projectobj/updates";

        /**
         * The Constant project detail
         */
        public static final String USER_LOGIN = API_DOMAIN + "api/login/user_login";

        /**
         * The Constant project detail
         */
        public static final String USER_PROFILE = API_DOMAIN + "api/user/profile";

        /**
         * The Constant project detail
         */
        public static final String USER_DASHBOARD = API_DOMAIN + "api/user/user_dashboard";

        /**
         * The Constant project detail
         */
        public static final String USER_PROJECTS = API_DOMAIN + "api/user/myprojects";

        /**
         * The Constant project detail
         */
        public static final String MY_FUNDING = API_DOMAIN + "api/user/mydonations";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_FUNDERS = API_DOMAIN + "api/projectobj/funders";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_FOLLOWERS = API_DOMAIN + "api/projectobj/followers";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_DONATION_DETAIL = API_DOMAIN + "donation/donation_detail/";

        /**
         * The Constant project detail
         */
        public static final String FOLLOWING_PROJECTS = API_DOMAIN + "api/user/myfollowingprojects";

        /**
         * The Constant project detail
         */
        public static final String MY_ACTIVITIES = API_DOMAIN + "api/user/myactivities";

        /**
         * The Constant project detail
         */
        public static final String USER_REGISTER = API_DOMAIN + "api/register";

        /**
         * The Constant project detail
         */
        public static final String FOLLOW = API_DOMAIN + "api/user/updateinterest";

        /**
         * The Constant project detail
         */
        public static final String SEARCH = API_DOMAIN + "api/search/index";

        /**
         * The Constant project detail
         */
        public static final String SOCIAL_LOGIN = API_DOMAIN + "api/register/social";

        /**
         * The Constant project detail
         */
        public static final String PROJECT_DASHBOARD = API_DOMAIN + "api/projectobj/dashboard";

        /**
         * The Constant project detail
         */
        public static final String USER_COMMENTS = API_DOMAIN + "api/user/mycomments";


        /**
         * register new user on server
         */

        public static final String CHANGE_PASSCODE = API_DOMAIN + "changepassword/driver";
        public static final String UPDATE_PROFILE = API_DOMAIN + "update/driver";
        public static final String LOCATION_LIST = API_DOMAIN + "driver/useraddresslist";
        /**
         * The Constant Login user
         */
        public static final String RUNNING_ACCIDENT_QUEUE = API_DOMAIN + "collector/RunningAccidentQueue";

        /**
         * The Constant Login user
         */
        public static final String COMPLETED_ACCIDENT_QUEUE = API_DOMAIN + "collector/completedaccidentlist";

        /**
         * The Constant Login user
         */
        public static final String COMPLETED_ACCIDENT_LIST = API_DOMAIN + "myaccident/driver/";

        public static final String SUPERVISOR_CALL_NUMBER = API_DOMAIN + "driver/DerPhoneNumber";

        // generate Accident
        public static final String GENERATE_ACCIDENT = API_DOMAIN + "GenerateAccident";

        // Get Active Accident Details
        public static final String GET_ACTIVE_ACCIDENT = API_DOMAIN + "driver/activeaccident";

        /**
         * The Constant supervisor list
         */
        public static final String DRIVER_SUPERVISOR_LIST = API_DOMAIN + "driverderlist/0/0";

        /**
         * Delete Accident
         */
         public static final String DELETE_ACCIDENT = API_DOMAIN + "delete/Accident/";


    }

}
