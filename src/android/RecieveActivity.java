package cordova-plugin-recieveActivity;


import org.apache.cordova.CordovaPlugin;

import org.apache.cordova.CallbackContext;


import org.json.JSONArray;

import org.json.JSONException;

import org.json.JSONObject;


/**
 * This class echoes a string called from JavaScript.
 */

public class RecieveActivity extends CordovaPlugin {


    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

        if (action.equals("recieveIntent")) {

            String appName = args.getString(0);

            this.recieveIntent(appName, callbackContext);

            return true;

        }

        return false;

    }


    private void recieveIntent(String appName, CallbackContext callbackContext) {

        if (appName != null && appName.length() > 0) {


		Intent callingIntent = this.cordova.getActivity().getStartingIntent();
		String startingName = callingIntent.getStringExtra(this.cordova.getActivity().EXTRA_MESSAGE);
		
            callbackContext.success(appName + " started by: " + startingName);

        } else {

            callbackContext.error("Expected one non-empty string argument.");

        }
    }
}
