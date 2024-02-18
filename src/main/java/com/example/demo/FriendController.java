package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/friends")
public class FriendController {

    private final FriendService friendService;

    @Autowired
    public FriendController(FriendService friendService) {
        this.friendService = friendService;
    }

    @GetMapping
    public List<Friends> getAllFriends() {
        return friendService.getAllFriends();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Friends> getFriendById(@PathVariable Long id) {
        Friends friends = friendService.getFriendById(id);

        if (friends != null) {
            System.out.println("Friend found: " + friends);
            return ResponseEntity.ok(friends);
        } else {
            System.out.println("Friend not found for ID: " + id);
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/create")
    public Friends createFriend(@RequestBody Friends friends) {
        return friendService.createFriend(friends);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFriend(@PathVariable Long id) {
        friendService.deleteFriend(id);
        return ResponseEntity.ok("Friend with ID " + id + " successfully deleted");
    }
}
