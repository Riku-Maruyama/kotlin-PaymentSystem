package com.websarva.wings.android.transfersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

//第2画面(振込種類選択画面)
class TransferTypeSelect : AppCompatActivity() {

    //リストビューに表示するリストデータの作成
    private val transferList = mutableListOf("新しい振込先に振り込む" ,
        "過去に振込した先に振り込む" ,
        "登録している口座に振り込む")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transfer_type_select)

        //ListViewオブジェクトの取得
        val trType = findViewById<ListView>(R.id.trType)

        //アダプタオブジェクトの作成
        val adapter = ArrayAdapter(this@TransferTypeSelect , android.R.layout.simple_list_item_1 ,transferList)
        //リストビューにアダプタオブジェクトの作成
        trType.adapter = adapter
        //ListViewにリスナを設定
        trType.onItemClickListener = ListItemClickListener()
        //戻るメニューの表示
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //第2画面のリストがタップされた時のリスナクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long){
            //タップされた振込種類の行データ取得
            val item = parent.getItemAtPosition(position) as String
            //振込種類データの取得
            val transferType1 = transferList.get(0)
            val transferType2 = transferList.get(1)
            val transferType3 = transferList.get(2)
            //振込種類の画面遷移分岐処理
            //新しい振込先に振り込む場合
            if(transferType1 == transferList.get(0)){
                //第3-1画面用のインテントオブジェクトの生成(金融機関選択[Financial institution selection]画面)
                val intentFis = Intent(this@TransferTypeSelect , FinancialInstitutionSelection::class.java)
                //第3-1画面の起動
                startActivity(intentFis)
            }
            //過去に振込した先に振り込む
            else if(transferType2 == transferList.get(1)){
                //第3-2画面用のインテントオブジェクトの生成(過去に振込した先の振込履歴[Past transfer history]から選択する画面)
                val intentPth = Intent(this@TransferTypeSelect , PastTransferHistory::class.java)
                //第3-2画面の起動
                startActivity(intentPth)

            }
            //登録している口座に振り込む
            else {
                //第3-3画面用のインテントオブジェクトの生成(登録している口座[Registered account]から選択する画面)
                val intentRa = Intent(this@TransferTypeSelect , RegisteredAccount::class.java)
                //第3-3画面の起動
                startActivity(intentRa)
            }
        }
    }

    //戻るメニューのメソッド
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //戻り値用の変数を初期値trueで用意
        var returnVal = true
        //選択されたメニューが「戻る」の場合、アクティビィを終了
        if(item.itemId == android.R.id.home){
            finish()
        }else{
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal

    }
}
