package com.warcard.emin.zeynalov

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.util.*

class MainActivity : AppCompatActivity() {

    internal lateinit var cardLeft: ImageView
    internal lateinit var cardRight: ImageView
    internal lateinit var dealBtn: ImageView
    internal lateinit var scoreLeft: TextView
    internal lateinit  var scoreRight: TextView
    internal lateinit var player_1: TextView
    internal lateinit var player_2: TextView
    var leftScore=0
    var rightScore=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cardLeft=findViewById<ImageView>(R.id.left_card)
        cardRight=findViewById<ImageView>(R.id.right_card)
        dealBtn=findViewById<ImageView>(R.id.deal_btn)
        scoreLeft=findViewById<TextView>(R.id.score_left)
        scoreRight=findViewById<TextView>(R.id.score_right)
        player_1=findViewById<TextView>(R.id.player_1)
        player_2=findViewById<TextView>(R.id.player_2)
    }


    @RequiresApi(Build.VERSION_CODES.M)
    fun onClicked(view: View){
        var leftCard= Random().nextInt(10)+2
        var rightCard= Random().nextInt(10)+2

        var leftImage=resources.getIdentifier("card_$leftCard", "drawable", packageName)
        cardLeft.setImageResource(leftImage)
        var rightImage=resources.getIdentifier("card_$rightCard", "drawable", packageName)
        cardRight.setImageResource(rightImage)

        when {
            leftCard>rightCard -> {
                leftScore++
                scoreLeft.text=leftScore.toString()
            }
            leftCard<rightCard -> {
                rightScore++
                scoreRight.text=rightScore.toString()
            }
            else -> Toast.makeText(this, "WarCardGame", Toast.LENGTH_SHORT).show()
        }

        if(leftScore>=10){
            zeroScore()
            Toast.makeText(this, "Player 1 победил", Toast.LENGTH_SHORT).show()
            player_1.setTextColor(getColor(R.color.red))
            player_2.setTextColor(getColor(R.color.white))
        }else if(rightScore>=10){
            zeroScore()
            Toast.makeText(this, "Player 2 победил", Toast.LENGTH_SHORT).show()
            player_2.setTextColor(getColor(R.color.red))
            player_1.setTextColor(getColor(R.color.white))
        }else if (leftScore==10 && rightScore==10){
            zeroScore()
            Toast.makeText(this, "ничья!!!", Toast.LENGTH_SHORT).show()
            player_1.setTextColor(getColor(R.color.white))
            player_2.setTextColor(getColor(R.color.white))
        }
    }

    fun zeroScore(){
        leftScore=0
        rightScore=0
        scoreLeft.text=leftScore.toString()
        scoreRight.text=rightScore.toString()
    }

}

