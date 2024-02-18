package com.example.demo;

import java.util.List;

public interface FriendService {
    List<Friends> getAllFriends();

    Friends getFriendById(Long id);

    Friends createFriend(Friends friends);

    Friends updateFriend(Long id, Friends updatedFriends);

    void deleteFriend(Long id);

    List<Friends> getAllUsers();
    User getUserById(Long id);
    Friends createUser(Friends user);
    void deleteUser(Long id);
    Friends signUp(Friends user);
    String login(String email, String password);

}


