package ru.skypro.kursovaia.service;

import ru.skypro.kursovaia.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestion(int amount);
}
