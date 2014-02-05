package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters
    private int mCreate, mStart, mResume, mRestart;

    TextView mTvCreate, mTvStart, mTvResume, mTvRestart;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

        mTvCreate = (TextView) findViewById(R.id.create);
        mTvStart = (TextView) findViewById(R.id.start);
        mTvResume = (TextView) findViewById(R.id.resume);
        mTvRestart = (TextView) findViewById(R.id.restart);

		Button closeButton = (Button) findViewById(R.id.bClose);
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method


			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {
            mCreate = savedInstanceState.getInt(RESTART_KEY);
            mStart = savedInstanceState.getInt(START_KEY);
            mResume = savedInstanceState.getInt(RESUME_KEY);
            mRestart = savedInstanceState.getInt(CREATE_KEY);
        }

        Log.i(TAG, "Activity one onCreate");

        mCreate++;
        displayCounts();
    }

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
        super.onStart();

        Log.i(TAG, "Activity one onStart");

        mStart++;
        displayCounts();
    }

	@Override
	public void onResume() {
        super.onResume();

        Log.i(TAG, "Activity one onResume");

        mResume++;
        displayCounts();
    }

	@Override
	public void onPause() {
        super.onPause();

        Log.i(TAG, "Activity one onPause");
    }

	@Override
	public void onStop() {
        super.onStop();

        Log.i(TAG, "Activity two onStop");
    }

	@Override
	public void onRestart() {
        super.onRestart();

        Log.i(TAG, "Activity two onResume");

        mRestart++;
        displayCounts();
    }

	@Override
	public void onDestroy() {
        super.onDestroy();

        Log.i(TAG, "Activity two onDestroy");
    }

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(RESTART_KEY, mCreate);
        savedInstanceState.putInt(START_KEY, mStart);
        savedInstanceState.putInt(RESUME_KEY, mResume);
        savedInstanceState.putInt(CREATE_KEY, mRestart);
    }

	// Updates the displayed counters
	public void displayCounts() {

		mTvCreate.setText("onCreate() calls: " + mCreate);
		mTvStart.setText("onStart() calls: " + mStart);
		mTvResume.setText("onResume() calls: " + mResume);
		mTvRestart.setText("onRestart() calls: " + mRestart);
	
	}
}
