package com.example.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var txt:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt = findViewById(R.id.calcExpression)
//        res = findViewById(R.id.calcResult)
    }
    fun onNum(view: View)
    {
        txt.append((view as Button).text)
    }
    fun onOperator(view: View)
    {
        txt.append((view as Button).text)
    }
    fun onDot(view: View)
    {
        txt.append((view as Button).text)
    }
    fun onDel()
    {
        this.txt.text =""
    }
    fun onClear(view: View)
    {
        this.txt.text =""
    }
    fun onEquals()
    {
        val text = txt.text.toString()
        val eval = ExpressionBuilder(text).build()
        val res = eval.evaluate()
        txt.text = res.toString()
    }


}