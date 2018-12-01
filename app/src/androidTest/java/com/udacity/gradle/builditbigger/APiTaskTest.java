package com.udacity.gradle.builditbigger;

import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Mohammed El_amary on 2/14/2018.
 */
public class APiTaskTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void onPreExecute() throws Exception {

       // InstrumentationRegistry.getTargetContext();
        APiTask aPiTask = new APiTask(mActivityRule.getActivity().getApplicationContext());
        aPiTask.execute();
        assertTrue(aPiTask.get().length()!= 0);
    }
}