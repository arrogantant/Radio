package com.example.ainews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.media.MediaPlayer

class MainViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    fun startStreaming() {
        viewModelScope.launch(Dispatchers.IO) {
            if (mediaPlayer == null) {
                mediaPlayer = MediaPlayer().apply {
                    try {
                        setDataSource("https://radio-stream.nhk.jp/hls/live/2023507/nhkradiruakfm/master.m3u8")
                        prepareAsync() // 비동기적으로 준비
                        setOnPreparedListener { start() } // 준비가 완료되면 시작
                    } catch (e: Exception) {
                        e.printStackTrace()
                    }
                }
            } else if (!mediaPlayer!!.isPlaying) {
                // 이미 MediaPlayer가 초기화되어 있고, 현재 재생중이 아니라면 재생 시작
                mediaPlayer?.start()
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release() // ViewModel이 클리어될 때 MediaPlayer 자원 해제
        mediaPlayer = null
    }
}
