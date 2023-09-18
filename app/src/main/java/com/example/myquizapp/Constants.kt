package com.example.myquizapp

object Constants {

    const val user_name:String= "User_name"
    const val tot_que:String="total_Question"
    const val correct_que:String="correct_Answer"

    fun getQuestions():ArrayList<Question>
    {
        val questionList=ArrayList<Question>()

        val que1=Question(
            1,
            "What country does this flag belong to?",
            R.drawable.brazil,
            "Brazil",
            "India",
            "Nepal",
            "United Kingdom",
            1
        )
        questionList.add(que1)

        val que2=Question(
            2,
            "What country does this flag belong to?",
            R.drawable.bangladesh,
            "Brazil",
            "India",
            "Bangladesh",
            "United Kingdom",
            3
        )
        questionList.add(que2)

        val que3=Question(
            3,
            "What country does this flag belong to?",
            R.drawable.india,
            "Brazil",
            "India",
            "Nepal",
            "United Kingdom",
            2
        )
        questionList.add(que3)

        val que4=Question(
            4,
            "What country does this flag belong to?",
            R.drawable.iceland,
            "Brazil",
            "Iceland",
            "Nepal",
            "United Kingdom",
            2
        )
        questionList.add(que4)

        val que5=Question(
            5,
            "What country does this flag belong to?",
            R.drawable.israel,
            "Israel",
            "India",
            "Nepal",
            "Canada",
            1
        )
        questionList.add(que5)

        val que6=Question(
            6,
            "What country does this flag belong to?",
            R.drawable.japan,
            "Brazil",
            "Japan",
            "Nepal",
            "Bangladesh",
            2
        )
        questionList.add(que6)

        val que7=Question(
            7,
            "What country does this flag belong to?",
            R.drawable.southafrica,
            "Brazil",
            "India",
            "Nepal",
            "South Africa",
            4
        )
        questionList.add(que7)

        val que8=Question(
            8,
            "What country does this flag belong to?",
            R.drawable.ukraine,
            "Brazil",
            "India",
            "Ukraine",
            "United Kingdom",
            3
        )
        questionList.add(que8)

        val que9=Question(
            9,
            "What country does this flag belong to?",
            R.drawable.unitedkingdom,
            "Brazil",
            "India",
            "Nepal",
            "United Kingdom",
            4
        )
        questionList.add(que9)

        val que10=Question(
            10,
            "What country does this flag belong to?",
            R.drawable.canada,
            "Iceland",
            "Canada",
            "Nepal",
            "United Kingdom",
            2
        )
        questionList.add(que10)




        return questionList
    }



}