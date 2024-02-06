package com.teslusko.quizapp.service;

import com.teslusko.quizapp.dao.QuestionDAO;
import com.teslusko.quizapp.model.Questions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {


    @Autowired
    QuestionDAO questionDAO;
    public ResponseEntity<List<Questions>> getAllQuestions(){
        try {
            return new ResponseEntity<>(questionDAO.findAll(), HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<List<Questions>> getQuestionsByCategory(String category){
        try{
        return new ResponseEntity<>(questionDAO.findByCategory(category), HttpStatus.OK);
    }
        catch (Exception e){
        e.printStackTrace();
    }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<String> addQuestion(Questions questions) {
        questionDAO.save(questions);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
}
