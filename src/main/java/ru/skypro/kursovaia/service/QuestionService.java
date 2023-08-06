package ru.skypro.kursovaia.service;

import ru.skypro.kursovaia.model.Question;
import ru.skypro.kursovaia.exeption.QuestionNotFoundException;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);

    Question add(Question question);

    Question remove(Question question) throws QuestionNotFoundException;

    Collection<Question> getAll();

    Question getRandomQuestion();



}
