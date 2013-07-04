package com.barbar.ubiupdate.test;

import android.app.Instrumentation;
import android.app.Instrumentation.ActivityMonitor;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.test.ActivityInstrumentationTestCase2;
import android.test.TouchUtils;
import android.test.ViewAsserts;
import android.test.suitebuilder.annotation.SmallTest;
import android.util.Log;
import android.widget.Button;
import com.barbar.ubiupdate.UbiUpdateActivity;

public class UbiUpdateTestos extends ActivityInstrumentationTestCase2<UbiUpdateActivity> {

    private int chkNowButtonId;
    private UbiUpdateActivity ubiUpdateActivity;
    private Instrumentation mInstrumentation;

    public UbiUpdateTestos(String name) {
        super(UbiUpdateActivity.class);
    }

    public UbiUpdateTestos() {
        this("UbiUpdateTestos");
    }

    protected void setUp() throws Exception {
        super.setUp();
        setActivityInitialTouchMode(false);
        ubiUpdateActivity = getActivity();
        mInstrumentation = getInstrumentation();

    }

    protected void tearDown() throws Exception {
        super.tearDown();
        
    }

    @SmallTest
    public void testUIActivity() {
        assertNotNull("UbiUpdate is null", ubiUpdateActivity);
        assertNotNull("Instrumentation is null", mInstrumentation);
        
        
        
        Resources reso = ubiUpdateActivity.getResources();
        assertEquals("Incorrect label of the button", "UbiUpdate", reso.getText(reso.getIdentifier("app_name", "string", ubiUpdateActivity.getPackageName())));
        
        
        // Add monitor to check for the UbiUpdate activity
        ActivityMonitor monitor = mInstrumentation.addMonitor(UbiUpdateActivity.class.getName(), null, false);

        // Wait 5 seconds for the start of the activity
        UbiUpdateActivity ubiUpdateActivityStarted = (UbiUpdateActivity) monitor.waitForActivityWithTimeout(5000);

        assertNotNull("UbiUpdate Activity not started", ubiUpdateActivityStarted);
        
        chkNowButtonId = com.barbar.ubiupdate.R.id.check_now_button;
        Button clickNowButtonView = (Button) ubiUpdateActivity.findViewById(chkNowButtonId);
        assertNotNull("Button not allowed to be null", clickNowButtonView);        
        ViewAsserts.assertOnScreen(ubiUpdateActivityStarted.getWindow().getDecorView(), clickNowButtonView);
        assertEquals("Incorrect label of the button", "Check now", clickNowButtonView.getText());
        
        TouchUtils.clickView(this, clickNowButtonView);
        getInstrumentation().waitForIdleSync();
        
        ubiUpdateActivity.finish();
        
    }

}
