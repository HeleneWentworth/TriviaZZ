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
        Question("Our First Question",1, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Second Question",1, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Third Question",1, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Fourth Question",1, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Fifth Question",2, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Sixth Question",2, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Seventh Question",2, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Eighth Question",2, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Ninth Question",3, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Tenth Question",3, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Eleventh Question",3, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Twelfth Question",3, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Thirteenth Question",4, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Fourteenth Question",4, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Fifteenth Question",4, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Sixteenth Question",4, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Seventeenth Question",5, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Eighteenth Question",5, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Nineteenth Question",5, listOf("answerOne", "answerTwo", "answerThree"), "answerOne"),
        Question("Our Twentieth Question",5, listOf("answerOne", "answerTwo", "answerThree"), "answerOne")


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
        CategoryItem(4, "Culture"),
        CategoryItem(5, "Cars")
    )


}