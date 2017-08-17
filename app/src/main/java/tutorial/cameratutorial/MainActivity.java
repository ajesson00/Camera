package tutorial.cameratutorial;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.VideoView;


public class MainActivity extends AppCompatActivity {
    static final int VIDEO_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void videoIntent(View view) {
        Intent takeVideo = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if(takeVideo.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takeVideo, VIDEO_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == VIDEO_REQUEST && resultCode == RESULT_OK) {
            Uri videoUri = intent.getData();
            VideoView vidView = (VideoView)findViewById(R.id.vidView);
            vidView.setVideoURI(videoUri);
            vidView.start();
        }
    }


}
