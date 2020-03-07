package com.dinh.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Notification;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;

import de.hdodenhof.circleimageview.CircleImageView;

import static com.dinh.activity.App.CHANGE_ID_1;

public class MusicDetailActivity extends AppCompatActivity {

    CircleImageView imgDiaNhac;
    TextView txtTimeSong, txtTimeTotalSong;
    SeekBar seekBarSong;
    ImageButton imgShuffle, imgPrevious, imgPlay, imgNext, imgReplay;

    MediaPlayer mediaPlayer;
    ObjectAnimator animator;

    NotificationManagerCompat notificationManagerCompat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_detail);

        addControls();
        addEvents();

        notificationManagerCompat = NotificationManagerCompat.from(this);

        imgReplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(),R.drawable.image);

                Notification notification = new NotificationCompat.Builder(getApplicationContext(),CHANGE_ID_1)
                        .setSmallIcon(R.drawable.ic_shuffle)
                        .setContentTitle("Let Me Love You")
                        .setContentText("I LOVE YOU")
                        .setLargeIcon(bitmap)
                        .addAction(R.drawable.ic_skip_previous,"Quay Lại",null)
                        .addAction(R.drawable.ic_pause,"Quay Lại",null)
                        .addAction(R.drawable.ic_skip_next,"Quay Lại",null)
                        .setStyle(new androidx.media.app.NotificationCompat.MediaStyle().setShowActionsInCompactView(1,2,3))
                        .build();

                notificationManagerCompat.notify(1,notification);
            }
        });
    }
    private void addEvents() {
        mediaPlayer = MediaPlayer.create(this, R.raw.cuoinhaudi);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        txtTimeTotalSong.setText(simpleDateFormat.format(mediaPlayer.getDuration()) + ""); //lay tong thoi gian cua bai hat
        seekBarSong.setMax(mediaPlayer.getDuration());

        imgPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    imgPlay.setImageResource(R.drawable.ic_play);
                } else {
                    mediaPlayer.start();
                    animator.start();
                    imgPlay.setImageResource(R.drawable.ic_pause);
                }
            }
        });

        updateTime();

        seekBarSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(seekBar.getProgress());
            }
        });
    }

    private void addControls() {
        txtTimeSong = findViewById(R.id.txtTimeSong);
        txtTimeTotalSong = findViewById(R.id.txtTimeTotalSong);
        seekBarSong = findViewById(R.id.seekBarSong);
        imgShuffle = findViewById(R.id.imgShuffle);
        imgPrevious = findViewById(R.id.imgPrevious);
        imgPlay = findViewById(R.id.imgPlay);
        imgNext = findViewById(R.id.imgNext);
        imgReplay = findViewById(R.id.imgReplay);
        imgDiaNhac = findViewById(R.id.imgDiaNhac);

        animator = ObjectAnimator.ofFloat(imgDiaNhac,"rotation",0f,360f); //rotation thuoc tinh xoay
        animator.setDuration(10000);// thoi gian xoay dia nhac
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setInterpolator(new LinearInterpolator());
    }

    private void updateTime() {
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mediaPlayer != null) {
                    seekBarSong.setProgress(mediaPlayer.getCurrentPosition());
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
                    txtTimeSong.setText("" + simpleDateFormat.format(mediaPlayer.getCurrentPosition()));
                    handler.postDelayed(this, 300);
                    mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            try {
                                Thread.sleep(1000);
                                imgPlay.setImageResource(R.drawable.ic_play);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }, 500);
    }
}
