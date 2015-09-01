package com.example.raj.practice;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.raj.practice.R.drawable;

/**
 * Created by Raj on 8/27/2015.
 */
// Get called with FragmentManager and Context (= Activity)
public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
    final int PAGE_COUNT = 3;
    private String tabTitles[] = new String[] { "Tab1", "Tab2", "Tab3" };
    private int[] imageResId = { R.drawable.ic_filter_1_black_24dp,
                                 R.drawable.ic_filter_2_black_24dp,
                                 R.drawable.ic_filter_2_black_24dp};
    private Context context;
    private ContextCompat contextCompat;

    public Frag1[] frags;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public int getCount() {
        // Toast.makeText(context, "getCount", Toast.LENGTH_SHORT).show();
        return PAGE_COUNT;
    }


    // Return the Fragment associated with a specified position.
    @Override
    public Fragment getItem(int position) {
        Fragment frag = null;
        switch (position) {
            case 0: frag = new Frag1(); break;
            case 1: frag = new Frag2(); break;
            case 2: frag = new Frag3(); break;
        }
        Toast.makeText(context, "getItem", Toast.LENGTH_SHORT).show();
        return frag;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        // return tabTitles[position];
        Drawable image = ContextCompat.getDrawable(context, imageResId[position]);
        image.setBounds(0, 0, image.getIntrinsicWidth(), image.getIntrinsicHeight());
        SpannableString sb = new SpannableString(" " + tabTitles[position]);
        ImageSpan imageSpan = new ImageSpan(image);
        sb.setSpan(imageSpan, 0, 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        Toast.makeText(context, "getPageTitle", Toast.LENGTH_SHORT).show();
        return sb;
    }

    public View getTabView(int position) {
        // Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
        View v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
        TextView tv = (TextView) v.findViewById(R.id.textView);
        Log.d("tag", String.valueOf(position));
        tv.setText(tabTitles[position]);
        ImageView img = (ImageView) v.findViewById(R.id.imgView);
        img.setImageResource(imageResId[position]);
        Toast.makeText(context, "getTabView", Toast.LENGTH_SHORT).show();
        return v;
    }
}