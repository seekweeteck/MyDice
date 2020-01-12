package my.edu.tarc.mydice

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imageViewDice : ImageView
    lateinit var dice : AnimationDrawable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewDice = findViewById<ImageView>(R.id.imageViewDice)

        buttonStart.setOnClickListener {
            //Play dice rolling sound
            mediaPlayer = MediaPlayer.create(this, R.raw.dice)
            mediaPlayer.start()
            mediaPlayer.isLooping = true

            //Play dice animation
            imageViewDice.clearAnimation()
            imageViewDice.setBackgroundResource(R.drawable.dice_animation)
            dice = imageViewDice.background as AnimationDrawable
            dice.start()
        }

        buttonStop.setOnClickListener {
            //Generate a random integer number
            val random = Random.nextInt(1, 6)
            textViewResult.text = random.toString()

            //Stop dice animation
            dice.stop()

            mediaPlayer.stop()

            when (random) {
                1 -> imageViewDice.setImageResource(R.drawable.dice1)
                2 -> imageViewDice.setImageResource(R.drawable.dice2)
                3 -> imageViewDice.setImageResource(R.drawable.dice3)
                4 -> imageViewDice.setImageResource(R.drawable.dice4)
                5 -> imageViewDice.setImageResource(R.drawable.dice5)
                else ->
                    imageViewDice.setImageResource(R.drawable.dice6)
            }
        }
    }

}
