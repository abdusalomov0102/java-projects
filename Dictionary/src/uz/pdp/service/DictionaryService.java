package uz.pdp.service;

import uz.pdp.model.Result;
import uz.pdp.model.Words;

import java.util.Map;

public interface DictionaryService {

    Result addWord();

    Result searchWord();

    void editWord();

    Map<String, Words> deleteWord();

    void showWord();

}
