package com.ppb.tugas2.ui.AudioPlayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.ppb.tugas2.R;

import java.io.IOException;


public class AudioPlayer extends Fragment {
    //ImageView imageView;
    Button btn_play, btn_pause, btn_stop;
    MediaPlayer mPlayer;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View viewlast = inflater.inflate(R.layout.fragment_audioplayer, container, false);
        //imageView=viewlast.findViewById(R.id.imageView);
        btn_play = viewlast.findViewById(R.id.button);
        btn_pause = viewlast.findViewById(R.id.button2);
        btn_stop = viewlast.findViewById(R.id.button3);
        stateAwal();
        btn_play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                play();
                btn_play.setEnabled(false);
                btn_pause.setEnabled(true);
                btn_stop.setEnabled(true);
            }
        });
        btn_pause.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                pause();
            }
        });
        btn_stop.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                stop();
            }
        });
        return viewlast;
    }

    public void stateAwal(){
        btn_play.setEnabled(true);
        btn_pause.setEnabled(false);
        btn_stop.setEnabled(false);
    }
    private void play(){
        mPlayer = MediaPlayer.create(getActivity(),R.raw.billie);
        try {
            mPlayer.prepare();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        mPlayer.start();
        mPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion (MediaPlayer mediaPlayer){
                stateAwal();
            }
        });
    }
    public void pause(){
        if (mPlayer.isPlaying())
            if (mPlayer!=null){
                mPlayer.pause();
            }else{
                if (mPlayer!=null){
                    mPlayer.start();
                }
            }
    }
    public void stop(){
        mPlayer.stop();
        try {
            mPlayer.prepare();
            mPlayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }
}
