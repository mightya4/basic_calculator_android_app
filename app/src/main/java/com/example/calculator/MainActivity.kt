package com.example.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Number events */
        calcOne.setOnClickListener {
            evaluateExpression("1", clear = true)
        }
        calcTwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }
        calcThree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        calcFour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }
        calcFive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }
        calcSix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }
        calcSeven.setOnClickListener {
            evaluateExpression("7", clear = true)
        }
        calcEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }
        calcNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }
        calcZero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }


        /* Operator events */
        calcPlus.setOnClickListener {
            evaluateExpression("+", clear = true)
        }
        calcMinus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }
        calcMul.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        calcDivide.setOnClickListener {
            evaluateExpression("/", clear = true)
        }
        calcDot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        /* Action events */
        calcClear.setOnClickListener {
            calcExpression.text = ""
            calcResult.text = ""
        }
        calcEquals.setOnClickListener {
            val text = calcExpression.text.toString()
            val expression = ExpressionBuilder(text).build()

            val result = expression.evaluate()
            val longResult = result.toLong()
            if ( result == longResult.toDouble() ) {
                calcResult.text = longResult.toString()
            } else {
                calcResult.text = result.toString()
            }
        }
        calcBack.setOnClickListener {
            val text = calcExpression.text.toString()
            if(text.isNotEmpty()) {
                calcExpression.text = text.drop(1)
            }
            calcResult.text = ""
        }
    }

    private fun evaluateExpression(s: String, clear: Boolean) {
        if( clear ) {
            calcResult.text = ""
            calcExpression.append(s)
        } else {
            calcExpression.append(calcResult.text)
            calcExpression.append(s)
            calcResult.text = ""
        }
    }

}