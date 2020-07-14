package com.example.notification

import android.app.*
import android.content.Context
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var notificationManager: NotificationManager
    lateinit var notificationChannel: NotificationChannel
    lateinit var builder: Notification.Builder
    private val chanelId = "com.example.notification"
    private val description = "Test notification"

    lateinit var activty: FragmentActivity
    lateinit var transacion: FragmentTransaction


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var view = FragmentRight()

        supportFragmentManager.beginTransaction().add(R.id.contenedorFragments, view).commit()


        bindUI()
        //notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

//        buttonNotification.setOnClickListener {
//
//            val intent = Intent(this, LauncherActivity::class.java)
//            val pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
//            val contentView = RemoteViews(packageName, R.layout.notification_layout)
//
//            contentView.setTextViewText(R.id.tvTitle, "Notification Title")
//            contentView.setTextViewText(R.id.tvContent, "Text notification goes here")
//
//            notificationChannel = NotificationChannel(chanelId, description, NotificationManager.IMPORTANCE_HIGH)
//            notificationChannel.enableLights(true)
//            notificationChannel.lightColor = Color.BLUE
//            notificationChannel.enableVibration(false)
//            notificationManager.createNotificationChannel(notificationChannel)
//
//            builder = Notification.Builder(this, chanelId)
//                .setCustomContentView(contentView)
////                .setContentTitle("CodeAndroid")
////                .setContentText("Notification text goes here")
//                .setSmallIcon(R.mipmap.ic_launcher_round)
//                .setLargeIcon(BitmapFactory.decodeResource(this.resources, R.mipmap.ic_launcher))
//                .setColor(Color.BLUE)
//                notificationManager.notify(1, builder.build())
//        }
    }

    private fun bindUI() {

        leftRadioButton.setOnClickListener {
            var view = FragmentLeft()
            setFragment(view)
        }

        rightRadioButton.setOnClickListener {
            var view = FragmentRight()
            setFragment(view)
        }
    }

    private fun setFragment(view: Fragment){
        transacion = supportFragmentManager.beginTransaction()
        transacion.replace(R.id.contenedorFragments, view)
        transacion.addToBackStack(null)
        transacion.commit()
    }
}
