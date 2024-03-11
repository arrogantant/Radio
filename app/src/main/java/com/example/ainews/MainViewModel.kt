package com.example.ainews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import android.media.MediaPlayer

class MainViewModel : ViewModel() {
    private var mediaPlayer: MediaPlayer? = null

    fun startStreaming(streamUrl: String) { // 스트리밍 URL을 메서드 인자로 받음
        viewModelScope.launch(Dispatchers.IO) {
            mediaPlayer?.release() // 기존 MediaPlayer가 있다면 자원을 해제
            mediaPlayer = MediaPlayer().apply {
                try {
                    setDataSource(streamUrl) // 인자로 받은 스트리밍 URL 사용
                    prepareAsync() // 비동기적으로 준비
                    setOnPreparedListener { start() } // 준비가 완료되면 시작
                } catch (e: Exception) {
                    e.printStackTrace() // 예외 발생 시 로그 출력
                }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        mediaPlayer?.release() // ViewModel이 클리어될 때 MediaPlayer 자원 해제
        mediaPlayer = null
    }
}
