package com.example.myquizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.myquizapp.Result

private var current:Int= 1
private var questionList:ArrayList<Question>?= null
private var selectedOption:Int=0
private var submit_btn:Button?=null
private var userName:String?=null
private var correctAnswer:Int=0

class Questions : AppCompatActivity(), View.OnClickListener {
    private var progressBar: ProgressBar?= null
    private var progressBarTxt: TextView?= null
    private var imageView: ImageView?= null
    private var questionTxt: TextView?= null
    private var option1: TextView?= null
    private var option2: TextView?= null
    private var option3: TextView?= null
    private var option4: TextView?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_questions2)
        userName=intent.getStringExtra(Constants.user_name)

        progressBar=findViewById(R.id.progressBar)
        progressBarTxt=findViewById(R.id.progressId)
        imageView=findViewById(R.id.questionImg)
        questionTxt=findViewById(R.id.questionTxt)
        option1=findViewById(R.id.option1)
        option2=findViewById(R.id.option2)
        option3=findViewById(R.id.option3)
        option4=findViewById(R.id.option4)
        submit_btn=findViewById(R.id.submitBtn)

        //Array list that stores the questions which is returned from constant->getQuestion function
        questionList = Constants.getQuestions()

        getQuestion()


        option1?.setOnClickListener(this)
        option2?.setOnClickListener(this)
        option3?.setOnClickListener(this)
        option4?.setOnClickListener(this)
        submit_btn?.setOnClickListener(this)




    }

    private fun getQuestion() {
        optionView()
        val question: Question = questionList!![current - 1]
        progressBar?.progress = current
        progressBarTxt?.text = "$current / ${progressBar?.max}"
        imageView?.setImageResource(question.image)
        questionTxt?.text = question.question
        option1?.text = question.optionOne
        option2?.text = question.optionTwo
        option3?.text = question.optionThree
        option4?.text = question.optionFour

        if(current== questionList!!.size)
        {
            submit_btn?.text="FINISH"
        }
        else
        {
            submit_btn?.text="SUBMIT"
        }

    }

    private fun optionView()
    {
        val optionList=ArrayList<TextView>()

        option1?.let{
            optionList.add(0,it)
        }
        option2?.let{
            optionList.add(1,it)
        }
        option3?.let{
            optionList.add(2,it)
        }
        option4?.let{
            optionList.add(3,it)
        }

        for(i in optionList)
        {
            i.setTextColor(Color.parseColor("#7A8089"))
            i.typeface= Typeface.DEFAULT
            i.background=ContextCompat.getDrawable(
                this,
                R.drawable.option_bg
            )
        }
    }

    private fun selectedOption(tv:TextView,selectedoption:Int)
    {
        optionView()

        selectedOption= selectedoption
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(
            this,
            R.drawable.selected_option
        )
    }

    override fun onClick(view: View?) {
        when(view?.id)
        {
            R.id.option1 ->
            {
                option1?.let{
                    selectedOption(it,1)
                }
            }
            R.id.option2 ->
            {
                option2?.let{
                    selectedOption(it,2)
                }
            }
            R.id.option3 ->
            {
                option3?.let{
                    selectedOption(it,3)
                }
            }
            R.id.option4 ->
            {
                option4?.let{
                    selectedOption(it,4)
                }
            }
            R.id.submitBtn -> {
                //tO DO
                if (selectedOption == 0) {
                    current++

                    when {
                        current <= questionList!!.size -> {
                            getQuestion()
                        }
                        else ->
                        {
                           val intent=Intent(this,Result::class.java)
                            intent.putExtra(Constants.user_name, userName)
                            intent.putExtra(Constants.tot_que, questionList?.size)
                            intent.putExtra(Constants.correct_que, correctAnswer)

                            startActivity(intent)
                            finish()
                        }
                    }
                }
                else
                {
                    val question= questionList?.get(current-1)
                    if(question!!.correctOption!= selectedOption)
                    {
                        answerView(selectedOption,R.drawable.incorrect_option)
                    }
                    else{
                        correctAnswer++
                    }
                        answerView(question.correctOption,R.drawable.correct_option)

                        if(current== questionList!!.size)
                        {
                            submit_btn?.text="FINISH"
                        }
                        else
                        {
                            submit_btn?.text="Go to next question"
                        }

                    selectedOption=0

                }

            }
        }
    }


    private fun answerView(answer:Int,drawableview:Int)
    {
        when(answer)
        {
            1->
            {
                option1?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
            2->
            {
                option2?.background=ContextCompat.getDrawable(
                    this,
                    drawableview
                )
            }
            3->
        {
            option3?.background=ContextCompat.getDrawable(
                this,
                drawableview
            )
        }
            4->
        {
            option4?.background=ContextCompat.getDrawable(
                this,
                drawableview
            )
        }
        }
    }

}