package com.example.liangorange.secondactivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // For getting Device width and height
    private DisplayMetrics displayMetrics;

    RelativeLayout rootLayout;
    RelativeLayout secondLayout;

    private ScrollView scrollView;

    ImageView imageView;

    Button rootButtonOne;

    Button button;

    ImageButton imageButton;
    ImageButton imageButtonFirst;
    ImageButton imageButtonSecond;

    TextView resultText;

    RelativeLayout.LayoutParams params;


    // Animation
    Animation animFadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get display width and height
        displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);


        rootLayout = (RelativeLayout) findViewById(R.id.root_relative_layout);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        secondLayout = (RelativeLayout) findViewById(R.id.secondLayout);
        resultText = (TextView) findViewById(R.id.textView);

        rootLayout.removeView(scrollView);

        addRootButtons();

        // load Animation
        animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.fade_in);

        rootLayout.setOnTouchListener(new RelativeLayout.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent m) {
                // Perform tasks here

                System.out.println("Background Selected");
                // addRootButtons();

                // Set root button to be visible
                rootButtonOne.setAlpha(1);
                // Enable the root button onclick function
                rootButtonOne.setEnabled(true);

                rootLayout.removeView(scrollView);

                return true;
            }
        });


        // Displaying current scrollView Width
        System.out.println("ScrollView Width: " + scrollView.getLayoutParams().width);

        /*
        button = new Button(this);
        button.setBackgroundColor(Color.YELLOW);
        button.setText("First Button");
        params = new RelativeLayout.LayoutParams(200, 150);
        params.leftMargin = 50;
        params.topMargin = 160;
        secondLayout.addView(button, params);
        */
        /*
        imageView = new ImageView(this);
        imageView.setBackgroundColor(Color.YELLOW);
        params = new RelativeLayout.LayoutParams(30, 40);
        params.leftMargin = 50;
        params.topMargin = 60;
        secondLayout.addView(imageView, params);

        imageView = new ImageView(this);
        imageView.setBackgroundColor(Color.RED);
        params = new RelativeLayout.LayoutParams(30, 40);
        params.leftMargin = 80;
        params.topMargin = 90;
        secondLayout.addView(imageView, params);
        */


    }

    public void addScrollView() {

        scrollView.setAlpha(0);
        params = new RelativeLayout.LayoutParams(scrollView.getLayoutParams());
        // params.leftMargin = displayMetrics.widthPixels;
        params.topMargin = 100;

        rootLayout.addView(scrollView, params);

        // Adding buttons to the scrollView
        addButtons();
    }

    public void addButtons() {

        imageButton = new ImageButton(this);
        // imageButton.setImageDrawable(getResources().getDrawable(R.drawable.moviebutton));
        imageButton.setBackground(getResources().getDrawable(R.drawable.moviebutton));
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 50;
        params.topMargin = 160;
        secondLayout.addView(imageButton, params);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("Button Clicked");
            }
        });


        imageButtonFirst = new ImageButton(this);
        imageButtonFirst.setBackground(getResources().getDrawable(R.drawable.moviebutton));
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = 250;
        params.topMargin = 160;
        secondLayout.addView(imageButtonFirst, params);

        imageButtonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("Second Button Clicked");
            }
        });


        imageButtonSecond = new ImageButton(this);
        imageButtonSecond.setBackground(getResources().getDrawable(R.drawable.moviebuttontwo));
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = scrollView.getLayoutParams().width / 2 - 150;
        params.topMargin = 3 * (scrollView.getLayoutParams().height / 4) - 150 ;
        secondLayout.addView(imageButtonSecond, params);

        imageButtonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("Third Button Clicked");
            }
        });
    }

    public void startAnimation(View view) {

        // rootLayout.removeView(rootButtonOne);

        // Set the root button to be invisible
        rootButtonOne.setAlpha(0);
        // Disable the root button
        rootButtonOne.setEnabled(false);

        addScrollView();

        scrollView.setAlpha(1);

        // Move the left margin of the scrollView to back to the screen
        // scrollView.setLeft(0);
        // System.out.println("ScrollView Left Margin: " + scrollView.getLeft());
        System.out.println("ScrollView Width: " + scrollView.getWidth());
        scrollView.startAnimation(animFadeIn);

    }

    public void addRootButtons() {

        rootButtonOne = new Button(this);
        rootButtonOne.setText("Root Button");

        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.leftMargin = getDeviceWidth() / 4;
        params.topMargin = getDeviceHeight() / 2;
        rootLayout.addView(rootButtonOne, params);

        rootButtonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultText.setText("Root Button Clicked");
            }
        });

    }

    public void removeRootButtons() {
        rootLayout.removeView(rootButtonOne);
    }

    public int getDeviceWidth() {
        int width = displayMetrics.widthPixels;

        return width;
    }

    public int getDeviceHeight() {
        int height = displayMetrics.heightPixels;

        return height;
    }
}
