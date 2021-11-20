package uz.task.service;

import uz.task.model.Result;

public interface BankService {

    Result addBalance();

    Result withDraw();

    Result transfer();

    Result addAccount();

}
