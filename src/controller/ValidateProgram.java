package controller;

import Repository.ValidateRepository;

public class ValidateProgram {

    ValidateRepository program;

    public ValidateProgram() {
        program = new ValidateRepository();
    }

    public void run() {
        System.out.println("====== Validate Progaram ======");
        program.Validate();
    }
}
