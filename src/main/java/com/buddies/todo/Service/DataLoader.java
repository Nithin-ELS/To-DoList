package com.buddies.todo.Service;

import com.buddies.todo.Entity.User;
import com.buddies.todo.Repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataLoader implements ApplicationRunner {

    private final IUserRepository userRepository;
    @Override
    public void run(ApplicationArguments args) throws Exception {
        User user = new User();
        user.setFirstName("piolo");
        user.setLastName("pascual");
        user.setEmail("piolo@a.com");
        user.setPassword("abc123");
        userRepository.save(user);
    }
}
