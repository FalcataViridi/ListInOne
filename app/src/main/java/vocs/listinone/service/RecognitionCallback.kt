package vocs.listinone.service

import android.os.Bundle
import vocs.listinone.model.RecognitionStatus

interface RecognitionCallback {
    fun onPrepared(status: RecognitionStatus)
    fun onBeginningOfSpeech()
    fun onReadyForSpeech(params: Bundle)
    fun onBufferReceived(buffer: ByteArray)
    fun onRmsChanged(rmsdB: Float)
    fun onPartialResults(results: List<String>)
    fun onResults(results: List<String>, scores: FloatArray?)
    fun onError(errorCode: Int)
    fun onEvent(eventType: Int, params: Bundle)
    fun onEndOfSpeech()
    fun onKeywordDetected(keys: String) { }

}