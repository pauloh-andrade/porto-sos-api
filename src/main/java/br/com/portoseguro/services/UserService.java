package br.com.portoseguro.services;

import br.com.portoseguro.models.Client;
import br.com.portoseguro.models.User;
import br.com.portoseguro.repositories.UserRepository;

import javax.naming.AuthenticationException;
import java.util.Objects;

public class UserService {
    private final UserRepository userRepository;

    public UserService () {
        this.userRepository = new UserRepository();
    }

    public boolean login (String phoneNumber, String password) throws Exception {
        User user = this.userRepository.getByPhoneNumber(phoneNumber);

        return Objects.equals(user.getPassword(), password) && Objects.equals(user.getPhoneNumber(), phoneNumber);
    }
}
