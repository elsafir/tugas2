package com.ppb.tugas2.ui.videoview;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ppb.tugas2.R;


public class VideoViewFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View myview = inflater.inflate(R.layout.fragment_videoview, container, false);
        VideoView videoView = myview.findViewById(R.id.video_view);
        videoView.setVideoPath("C:\\Users\\Dani\\AndroidStudioProjects\\tugas2\\app\\src\\main\\res\\raw\\History.mp4");

        MediaController mediaController = new MediaController(getActivity().getApplicationContext());
        videoView.setMediaController(mediaController);
        mediaController.setAnchorView(videoView);
        videoView.requestFocus();
       return  myview;
    }


}