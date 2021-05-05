package com.example.f1quiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_questions.*

class QuestionsActivity : AppCompatActivity(), View.OnClickListener {


    //each time we get this activity we should start with the first question
    private var mCurrentPosition: Int = 1

    /*
    variable for the questions list which will just be
    an array list of questions, we just gonna set it null
     */
    private var mQuestionsList: ArrayList<Question>? = null

    //option the user has selected
    private var mSelectedOptionPosition : Int =  0

    //check if the answer is correct
    private var mCorrectAnswers: Int = 0

    //variable for username which is set by null
    private var mUserName: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions)

        //creating a new username variable which will be for intent
        mUserName = intent.getStringExtra(Constants.USER_NAME)

        /*
        creating a new question list variable here which will be for constance
        for my constance dot get questions, object is available everywhere
         */

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        //every button should have an onClicklistener

        option_one.setOnClickListener(this)
        option_two.setOnClickListener(this)
        option_three.setOnClickListener(this)
        submitBtn.setOnClickListener(this)



    }

    private fun setQuestion(){

      /*
        the question we are currently looking at will be of type question nullable which is
        assigned to questions list had the current position minus one, that is because the current
        position is set to one, because how constance is named so the first question
        give the id 1, but this is the 0 f index so it has a index of 0 inside the arrayList
        because arrayList is start counting from 0 so that is why we need to use the current
        position minus one here in order to get 0 as the first entry of our question list
       */

        val question = mQuestionsList!![mCurrentPosition-1]

        /*
        each time we set a new question what we also should do
        is to set defaultOptionsView(), just to make sure that all the buttons
        are back to the default appearance than later on select one of them
        by clicking for example
         */
        defaultOptionsView()

        if (mCurrentPosition == mQuestionsList!!.size){
            submitBtn.text = "FINISH"
        }else{
            submitBtn.text = "SUBMIT"
        }

        progressBar.progress = mCurrentPosition
        progress.text = "$mCurrentPosition" + "/" + progressBar.max

        //question is the current question that we looking at, every single object has
        //a question string
        tv_question.text = question.question
        image.setImageResource(question.image)
        option_one.text = question.optionOne
        option_two.text = question.optionTwo
        option_three.text = question.optionThree
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0, option_one)
        options.add(1, option_two)
        options.add(2, option_three)

        for (option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_option_boarder
            )
        }

    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.option_one ->{
                selectedOptionView(option_one, 1)
            }
            R.id.option_two ->{
                selectedOptionView(option_two,2)
            }
            R.id.option_three ->{
                selectedOptionView(option_three,3)
            }
            R.id.submitBtn ->{
                //when it is equal to zero we want to move to the next question that is why ++
                if (mSelectedOptionPosition == 0){
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.USER_NAME, mUserName)
                        intent.putExtra(Constants.CORRECT_ANSWER, mCorrectAnswers)
                        intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                        startActivity(intent)
                        finish()

                        }
                    }
                }else{
                    val question = mQuestionsList?.get(mCurrentPosition -1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition, R.drawable.wrong_answer)
                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_answer)

                    if(mCurrentPosition == mQuestionsList!!.size){
                        submitBtn.text = "FINISH"
                    }else{
                        submitBtn.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    private fun answerView(answer:Int, drawableView: Int){
        when(answer){
            1 ->{
                option_one.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }

            2 ->{
                option_two.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }

            3 ->{
                option_three.background = ContextCompat.getDrawable(
                        this, drawableView
                )
            }
        }

    }



    private fun selectedOptionView(textView: TextView,
                                   selectedOptionNum: Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNum

        textView.setTextColor(Color.parseColor("#363A43"))
        textView.setTypeface(textView.typeface, Typeface.BOLD) //which typeface and how we want to set it
        textView.background = ContextCompat.getDrawable(
                this,
                R.drawable.selected_option_border_bg
        )

    }


}