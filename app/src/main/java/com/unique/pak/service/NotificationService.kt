package com.unique.pak.service

import android.util.Log
import com.google.firebase.messaging.FirebaseMessagingService

private const val TAG = "NotificationService"
class NotificationService: FirebaseMessagingService() {

    override fun onNewToken(token: String) {
        super.onNewToken(token)

        Log.e(TAG,"onNewToken - $token")
    }
}