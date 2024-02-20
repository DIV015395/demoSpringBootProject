package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UsersDTO> getAllUsers() {
        List<Users> usersList = userRepository.findAll();
        return usersList.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UsersDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    @Transactional
    @Override
    public UsersDTO createUser(UsersDTO usersDTO) {
        Users userEntity = convertToEntity(usersDTO);
        Users savedUser = userRepository.save(userEntity);
        return convertToDTO(savedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    private UsersDTO convertToDTO(Users user) {
        // Logic to convert Users entity to UsersDTO
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setName(user.getName());
        usersDTO.setPhoneNo(user.getPhoneNo());
        usersDTO.setAddress(user.getAddress());
        return usersDTO;
    }

    private Users convertToEntity(UsersDTO usersDTO) {
        // Logic to convert UsersDTO to Users entity
        Users user = new Users();
        user.setName(usersDTO.getName());
        user.setPhoneNo(usersDTO.getPhoneNo());
        user.setAddress(usersDTO.getAddress());
        return user;
    }
}
