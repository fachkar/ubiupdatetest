package com.barbar.ubiupdate.test;

import android.content.Intent;
import android.content.res.Resources;
import android.test.ActivityUnitTestCase;
import android.test.suitebuilder.annotation.SmallTest;
import android.widget.Button;
import com.barbar.ubiupdate.UbiUpdateActivity;

public class UbiUpdateTestos extends ActivityUnitTestCase<UbiUpdateActivity> {

    private int chkNowButtonId;
    private UbiUpdateActivity ubiUpdateActivity;

    public UbiUpdateTestos(String name) {
        super(UbiUpdateActivity.class);
    }

    public UbiUpdateTestos() {
        this("UbiUpdateTestos");
    }

    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent(getInstrumentation().getTargetContext(), UbiUpdateActivity.class);
        startActivity(intent, null, null);
        ubiUpdateActivity = getActivity();
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
    
    @SmallTest
    public void testAppName() {
        Resources reso = ubiUpdateActivity.getResources();
        assertEquals("Incorrect label of the button", "UbiUpdate", reso.getText(reso.getIdentifier("app_name", "string", ubiUpdateActivity.getPackageName())));
    }

    @SmallTest
    public void testLayout() {

        chkNowButtonId = com.barbar.ubiupdate.R.id.check_now_button;
        assertNotNull(ubiUpdateActivity.findViewById(chkNowButtonId));
        Button view = (Button) ubiUpdateActivity.findViewById(chkNowButtonId);
        assertEquals("Incorrect label of the button", "Check now", view.getText());
    }

    @SmallTest
    public void testIntentTriggerViaOnClick() {
        chkNowButtonId = com.barbar.ubiupdate.R.id.check_now_button;
        Button ButtonView = (Button) ubiUpdateActivity.findViewById(chkNowButtonId);
        assertNotNull("Button not allowed to be null", ButtonView);

        // You would call the method directly via
        
    }

}
