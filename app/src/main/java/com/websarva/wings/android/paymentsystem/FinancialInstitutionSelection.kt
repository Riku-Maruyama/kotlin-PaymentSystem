package com.websarva.wings.android.transfersystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView

////第3-1画面(金融機関選択画面)
class FinancialInstitutionSelection : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_financial_institution_selection)

        //ListViewオブジェクトの取得
        val trFis = findViewById<ListView>(R.id.trFinancialInstituationSelection)
        //リストビューに表示するリストデータの作成
        val fisList = mutableListOf("三菱UFJ銀行" , "三菱UFJ信託銀行" , "auじぶん銀行" , "みずほ銀行"
            , "三井住友銀行" , "ゆうちょ銀行" , "りそな銀行" , "埼玉りそな銀行" , "PayPay銀行" , "楽天銀行")
        //アダプタオブジェクトの作成
        val adapter = ArrayAdapter(this@FinancialInstitutionSelection , android.R.layout.simple_list_item_1 ,fisList)
        //リストビューにアダプタオブジェクトの作成
        trFis.adapter = adapter
        //ListViewにリスナを設定
        trFis.onItemClickListener = ListItemClickListener()
        //戻るメニューの表示
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //「下記以外の金融機関を検索する」ボタンを押した時のメソッド(第3画面)
    fun onButtonClick(view: View) {
        //第4-1画面インテントオブジェクトの生成(金融機関検索画面用)
        val intentFish = Intent(this@FinancialInstitutionSelection , FinancialInstituationSearch::class.java)
        //金融機関検索画面の起動
        startActivity(intentFish)
    }

    //第3画面(新しい振込先)のリストがタップされた時のリスナクラス
    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long){
            //タップされた各金融機関の行データ取得
            val item = parent.getItemAtPosition(position) as String
            //各金融機関名データの取得
            val financialInstitutionName = item
            //第4-2画面用のインテントオブジェクトの生成(支店検索[Branch search]画面)
            val intentBs = Intent(this@FinancialInstitutionSelection , BranchSearch::class.java)
            //支店検索画面に送るデータの格納(振込先)
            intentBs.putExtra("FinancialInstitutionName" , financialInstitutionName)
            //支店検索画面の起動
            startActivity(intentBs)
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
