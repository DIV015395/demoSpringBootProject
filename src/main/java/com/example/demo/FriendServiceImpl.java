package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FriendServiceImpl implements FriendService
{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private FriendRepository friendRepository;
    private final UserService userService;

    @Autowired
    public FriendServiceImpl(FriendRepository friendRepository, UserService userService) {
        this.friendRepository = friendRepository;
        this.userService = userService;
    }

    @Override
    public List<Friends> getAllFriends() {
        return friendRepository.findAll();
    }

    @Override
    public Friends getFriendById(Long id) {
        return friendRepository.findById(id).orElse(null);
    }

    @Override
    public Friends createFriend(Friends friends) {
        String currentUsername = getCurrentUsername();

        // Find the User by username and associate it with Friends
        User user = userRepository.findByUsername(currentUsername);
        friends.setUser(user);

        // Save the friend
        return friendRepository.save(friends);
    }


    private String getCurrentUsername() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @Override
    public Friends updateFriend(Long id, Friends updatedFriends) {
        // Get the existing friend from the database
        Friends existingFriends = friendRepository.findById(id).orElse(null);

        if (existingFriends != null)
        {
            existingFriends.setName(updatedFriends.getName());
            existingFriends.setPhoneNo(updatedFriends.getPhoneNo());
            existingFriends.setAddress(updatedFriends.getAddress());
            return friendRepository.save(existingFriends);
        }

        return null; // Friend not found
    }

    @Override
    public void deleteFriend(Long id) {
        friendRepository.deleteById(id);
    }

    @Override
    public List<Friends> getAllUsers() {
        return null;
    }

    @Override
    public User getUserById(Long id) {
        return null;
    }

    @Override
    public Friends createUser(Friends user) {
        return null;
    }

    @Override
    public void deleteUser(Long id) {

    }

    @Override
    public Friends signUp(Friends user) {
        return null;
    }

    @Override
    public String login(String email, String password) {
        return null;
    }
}
