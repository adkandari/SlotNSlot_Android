package com.slotnslot.slotnslot.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;

import com.slotnslot.slotnslot.R;
import com.slotnslot.slotnslot.fragments.SignInListFragment;
import com.slotnslot.slotnslot.fragments.SignUpFragment;
import com.slotnslot.slotnslot.geth.Utils;

public class SignInUpActivity extends SlotFragmentActivity {

    private boolean doubleBackToExitPressedOnce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fragment frag = new SignUpFragment();
        FragmentTransaction ftrans = getSupportFragmentManager().beginTransaction();
        ftrans.replace(R.id.fragment_framelayout, frag);
        ftrans.addToBackStack(null);
        ftrans.commit();
    }

    public void setTitle(String title) {
        centerTextView.setText(title);
    }

    @Override
    public void onBackPressed() {
        Fragment f = getSupportFragmentManager().findFragmentById(R.id.fragment_framelayout);
        if (f instanceof SignInListFragment) {
            super.onBackPressed();
            return;
        }
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        Utils.showToast("Please click BACK again to exit");
        new Handler().postDelayed(() -> doubleBackToExitPressedOnce = false, 2000);
    }
}
