package com.example.triviaz

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.triviaz.data.Question

class GameViewModel: ViewModel() {

    private val _question = MutableLiveData<Question>()
    private val _currentQuestion = MutableLiveData<Int>()
    private val _score = MutableLiveData<Int>()
    private val _amountOfQuestions = MutableLiveData<Int>()
    private val _categoryQuestions = MutableLiveData<List<Question>>()


//    init {
//        _score.value = 0
//        _question.value = questions[0]
//        _currentQuestion.value = 0
//
//    }

    fun setupGame(categoryId: Int){
        val newQuestion = questions.filter { q -> q.categoryId == categoryId  }
        _categoryQuestions.postValue(newQuestion)
        _question.value = newQuestion[0]
        _currentQuestion.value = 0
        _score.value = 0
        _amountOfQuestions.value = 4
    }

    val question: LiveData<Question> = _question
    val currentQuestion: LiveData<Int> = _currentQuestion
    val score: LiveData<Int> = _score
    val amountOfQuestions : LiveData<Int> = _amountOfQuestions

    fun updateQuestion(index: Int){
        _question.value = _categoryQuestions.value?.get(index.plus(1))
        _currentQuestion.value = index.plus(1)

    }
    fun checkQuestion(answer: Int){
        val validAnswer: String? = question.value?.correctAnswer
        val submittedAnswer: String? = question.value?.answers?.get(answer)
        if(submittedAnswer == validAnswer){
            _score.value = score.value?.plus(1)
        }
    }
    private val questions = listOf(
        Question("Where did Naas Botha play his first test match for South Africa?",1, listOf("Ellis Park", "Danie Craven", "Wanderers"), "Wanderers"),
        Question("Who was the first female athlete to run under six hours in the Comrades Marathon?",1, listOf("Elana Meyer", "Frith van der Merwe", "Frances Hayward"), "Frith van der Merwe"),
        Question("Who was the first South African to make a century on his test debut?",1, listOf("Hansie Cronje", "Andrew Hudson", "Tony Greig"), "Andrew Hudson"),
        Question("How many Rugby tests did Jan Ellis play for South Africa?",1, listOf("38", "59", "75"), "38"),
        Question("Published after her death, what did teenager Anne Frank leave behind?",2, listOf("Diary", "Pen", "Letter"), "Diary"),
        Question("When did the Cold War officially end?",2, listOf("1975", "1989", "1923"), "1989"),
        Question("How many heads of executive departments make up the president's cabinet - 10, 15, or 25?",2, listOf("10", "25", "15"), "15"),
        Question("The second atomic bomb ever used in war-time was dropped on what city?",2, listOf("Nagasaki", "Hiroshima", "Tokoyo"), "Nagasaki"),
        Question("What is Pablo Picasso's daughter's name?",3, listOf("Paloma", "Daisy", "Olivia"), "Paloma"),
        Question("Leonardo da Vinci was hired by the Duke of Milan when he said he could build a portable what?",3, listOf("Car", "Plane", "Bridge"), "Bridge"),
        Question("In which city is the Prado Art Gallery?",3, listOf("Italy", "Madrid", "Dubai"), "Madrid"),
        Question("What artist is famous for the \"Helga Pictures\"?",3, listOf("Andrew Wyeth", "Leonardo Da Vinci", "Michelangelo"), "Andrew Wyeth"),
        Question("What are the names of Kim Kardashian and Kanye West’s kids?",4, listOf("North, Silva, Chicago and Psalm", "North, Saint, Chicago and Psalm", "South, Saint, Chicago and Psalm"), "North, Saint, Chicago and Psalm"),
        Question("How many kids does Angelina Jolie have?",4, listOf("4", "6", "3"), "6"),
        Question("How many times did Ross Geller get divorced on Friends?",4, listOf("3 times", "5 times", "2 times"), "3 times"),
        Question("How many Harry Potter books and movies are there?",4, listOf("6 books and 8 movies", "7 books and 8 movies", "7 books and 9 movies"), "7 books and 8 movies"),
        Question("What is generally considered to be the first \"pony car\"?",5, listOf("Ford Mustang", "Chevrolet Camaro", "Ferrari"), "Ford Mustang"),
        Question("What was the first Japanese car to be produced in the United States?",5, listOf("Honda Accord", "Nissan Maxima", "Toyota Camry"), "Honda Accord"),
        Question("What was the first car to break the sound barrier?",5, listOf("Bugatti Veyron", "ThrustSSC", "Hennessey Venom GT"), "ThrustSSC"),
        Question("What was the first car launched into space?",5, listOf("BMW", "Porsche 911", "Tesla Roadster"), "Tesla Roadster")


    )
      fun generateDummyList(size: Int):List<CategoryItem>{
        val list = ArrayList<CategoryItem>()
        for (i in 1 until size){
            val item = CategoryItem(i,"Category $i")
            list += item
        }
        return  list
    }
     val categories = listOf(
        CategoryItem(1, "Sport"),
        CategoryItem(2, "History"),
        CategoryItem(3, "Art"),
        CategoryItem(4, "Pop Culture"),
        CategoryItem(5, "Cars")
    )


}