package com.websarva.wings.android.transfersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    //振込ボタンを押した時のメソッド(第1画面)
    fun onButtonClick(view: View) {
        //インテントオブジェクトの生成(第2画面用)
        val intent = Intent(this@MainActivity , TransferTypeSelect::class.java)
        //第2画面の起動
        startActivity(intent)
    }
}
