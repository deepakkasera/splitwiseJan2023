package com.scaler.splitwisejan2023;

import com.scaler.splitwisejan2023.commands.CommandRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SplitwiseJan23Application {
//    @Autowired
//    private CommandRegistry commandRegistry;
//    @Autowired
//    private RegisterUserCommand registerUserCommand;
//    @Autowired
//    private UpdateProfileCommand updateProfileCommand;

//    @Autowired
//    private RegisterUserCommand registerUserCommand;

    @Autowired
    private CommandRegistry commandRegistry;

    public static void main(String[] args) {
        SpringApplication.run(SplitwiseJan23Application.class, args);
    }

//    @Override
//    public void run(String[] args) throws Exception {
//        commandRegistry.registerCommand(registerUserCommand);
//        commandRegistry.registerCommand(updateProfileCommand);
//
////        String input = "Register namanbhalla 999 password";
//        String input = "5 UpdateProfile strongpassword";
//        commandRegistry.executeCommandLine(input);
////        while (true) {
////            String input = "INPUT FROM COMMAND LINE";
////
////            commandRegistry.executeCommandLine(input);
////        }
//    }

//    @Override
//    public void run(String[] args) throws Exception {
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            String input = scanner.nextLine();
//
//            commandRegistry.execute(input);
//        }
//    }
}
