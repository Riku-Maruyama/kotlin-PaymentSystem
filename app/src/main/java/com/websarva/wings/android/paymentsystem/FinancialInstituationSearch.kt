package com.websarva.wings.android.transfersystem

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


//第4-1画面(金融機関検索画面用)
class FinancialInstituationSearch : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_financial_instituation_search)

        val spinner = findViewById<Spinner>(R.id.spinner)
        ArrayAdapter.createFromResource(this, R.array.spinner_items, android.R.layout.simple_spinner_item
        ).also { adapter ->
            spinner.adapter = adapter
        }

        class SpinnerActivity : Activity(), AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, pos: Int, id: Long) {
                //　spinner内のリストが選択されたとき
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
                //　spinner内のリストが選択されなかった
            }
        }
    }

    //検索ボタンを押した時のメソッド(第5画面)
    fun onButtonClickSearch(view: View) {

        //検索ボタンの取得
        val btnSerch = findViewById<Button>(R.id.bt_search)
        //検索欄を取得
        val seEdit = findViewById<EditText>(R.id.edittext)
        //検索された文字列を取得
        val search = seEdit.text.toString()
        //取得した文字列の一文字から一桁目を取得
        val searchsubstr =search.substring(1,1)

        //TODO：検索された文字列から該当するデータを検索結果として表示
        //TODO：DBに格納されているデータから該当のデータを持ってくる
        //TODO：検索結果の該当のデータ(リスト)をタップした場合、支店検索画面に遷移
        //②受け取った値から、DB内のデータを検索してそこから該当するデータを抽出する。
        //③抽出したデータを受け取る。
        //④受け取ったのち、検索結果としてリストで抽出したデータを画面に表示する。

    }

}
