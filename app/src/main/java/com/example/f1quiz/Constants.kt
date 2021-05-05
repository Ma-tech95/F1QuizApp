package com.example.f1quiz

object Constants {

    /*
     If we go to our main activity we can see that we have this intent sense as
     over to this quiz question activity, so we need to put some extra information
     into this intent
     */

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWER: String = "correct_answers"
    //we have to make array list which contains bunch of questions
    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1= Question(1,"Who became the first world champion in Formula 1 (1950)?",
            R.drawable.ic_1,
            "Giuseppe Farina",
            "Alberto Ascari",
            "James Hunt",
            1)

        questionsList.add(que1)


        val que2= Question(2,"How many world titles has Niki Lauda?",
            R.drawable.ic_2,
            "2",
            "5",
            "3",
            3)

        questionsList.add(que2)

        val que3= Question(3,"What was the name of first woman in Formula 1?",
            R.drawable.ic_3,
            "Divina Galica",
            "Lella Lombardi",
            "Maria Teresa de Filippis",
            3)

        questionsList.add(que3)

        val que4= Question(4,"From which country is Alpine driver Esteban Ocon?",
            R.drawable.ic_4,
            "France",
            "Italy",
            "Portugal",
            1)

        questionsList.add(que4)

        val que5= Question(5,"How many F1 world champions was from Finland?",
            R.drawable.ic_5,
            "1",
            "3",
            "2",
            2)

        questionsList.add(que5)

        val que6= Question(6,"Who became the youngest F1 world champion?",
            R.drawable.ic_6,
            "Lewis Hamilton",
            "Sebastian Vettel",
            "Fernando Alonso",
            2)

        questionsList.add(que6)

        val que7= Question(7,"From which country there was the most F1 World Champions?",
            R.drawable.ic_7,
            "Spain",
            "Germany",
            "Great Britain",
            3)

        questionsList.add(que7)

        val que8= Question(8,"From which country was Ayrton Senna?",
            R.drawable.ic_8,
            "Brazil",
            "Portugal",
            "Argentina",
            1)

        questionsList.add(que8)

        val que9= Question(9,"In which team Jack Brabham became F1 world champion for the first time?",
            R.drawable.ic_9,
            "Cooper",
            "Ferrari",
            "Alfa Romeo",
            1)

        questionsList.add(que9)

        val que10= Question(1,"How many times Lewis Hamilton became World Champion?",
            R.drawable.ic_10,
            "3",
            "5",
            "7",
            3)

        questionsList.add(que10)

        return questionsList





    }
}