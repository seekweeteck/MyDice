package my.edu.tarc.mydice

import android.graphics.drawable.AnimationDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imageViewDice : ImageView
    lateinit var dice : AnimationDrawable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageViewDice = findViewById(R.id.imageViewDice)


        buttonStart.setOnClickListener {
            //Play dice rolling sound
            mediaPlayer = MediaPlayer.create(this, R.raw.dice)
            mediaPlayer.start()
            mediaPlayer.isLooping = true

            //Play dice animation
            imageViewDice.setBackgroundResource(R.drawable.dice_animation)

            dice = imageViewDice.background as AnimationDrawable
            dice.start()

        }

        buttonStop.setOnClickListener {
            //Generate a random integer number
            val random = Random.nextInt(1, 6)

            //Stop dice animation
            dice.stop()

            //Stop rolling sound
            mediaPlayer.stop()

            when (random) {
                1 -> imageViewDice.setBackgroundResource(R.drawable.dice1)
                2 -> imageViewDice.setBackgroundResource(R.drawable.dice2)
                3 -> imageViewDice.setBackgroundResource(R.drawable.dice3)
                4 -> imageViewDice.setBackgroundResource(R.drawable.dice4)
                5 -> imageViewDice.setBackgroundResource(R.drawable.dice5)
                else ->
                    imageViewDice.setBackgroundResource(R.drawable.dice6)
            }

            val area = spinnerArea.selectedItemPosition
            when(area){
                0-> {
                    val result = resources.getStringArray(R.array.love)
                    textViewResult.text = String.format("%s", result[random].toString())
                }
                1->{
                    val result = resources.getStringArray(R.array.friendship)
                    textViewResult.text = String.format("%s", result[random].toString())
                }
                2->{
                    val result = resources.getStringArray(R.array.career)
                    textViewResult.text = String.format("%s", result[random].toString())
                }
                3->{
                    val result = resources.getStringArray(R.array.wellness)
                    textViewResult.text = String.format("%s", result[random].toString())
                }
                else->{
                    val result = resources.getStringArray(R.array.money)
                    textViewResult.text = String.format("%s", result[random].toString())
                }
            }
        }
    }

}
