package com.ss.utopia.controllers;

import com.ss.utopia.exceptions.UserAlreadyExistsException;
import com.ss.utopia.exceptions.UserNotFoundException;
import com.ss.utopia.exceptions.UserRoleNotFoundException;
import com.ss.utopia.models.ErrorMessage;
import com.ss.utopia.models.Role;
import com.ss.utopia.models.User;
import com.ss.utopia.services.UserService;
import java.net.ConnectException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping(value = "/users")
public class UserController {

  @Autowired
  UserService userService;

  @GetMapping("/health")
  public ResponseEntity<Object> health() {
    return new ResponseEntity<>("\"status\": \"up\"", HttpStatus.OK);
  }

  @GetMapping
  public ResponseEntity<Object> findAll() {
    List<User> userList = userService.findAll();
    return !userList.isEmpty()
      ? new ResponseEntity<>(userList, HttpStatus.OK)
      : new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
  }

  @PostMapping
  public ResponseEntity<Object> insert(@RequestBody User user)
    throws UserAlreadyExistsException {
    if (user.getUserRole().equals(null)) {
      user.setUserRole(Role.USER);
    }
    return new ResponseEntity<>(userService.insert(user), HttpStatus.CREATED);
  }

  @GetMapping("{userId}")
  public ResponseEntity<Object> findById(@PathVariable Integer userId)
    throws UserNotFoundException {
    User user = userService.findById(userId);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping("/email/{email}")
  public ResponseEntity<Object> findByEmail(@PathVariable String email)
    throws UserNotFoundException {
    User user = userService.findByEmail(email);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  @GetMapping("/phone/{phone}")
  public ResponseEntity<Object> findByPhone(@PathVariable String phone)
    throws UserNotFoundException {
    User user = userService.findByPhone(phone);
    return new ResponseEntity<>(user, HttpStatus.OK);
  }

  //   @DeleteMapping("{userId}")
  //   public ResponseEntity<Object> delete(@PathVariable Integer userId)
  //     throws UserNotFoundException {
  //     userService.delete(userId);
  //     return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
  //   }

  // 	@PostMapping
  // 	public ResponseEntity<Object> insert(@RequestBody User user) throws UserAlreadyExistsException {
  // 		user.setUserRole(Role.USER);
  // 		return new ResponseEntity<>(userService.insert(user), HttpStatus.CREATED);
  // 	}

  @PutMapping
  public ResponseEntity<Object> update(@RequestBody User user)
    throws UserNotFoundException {
    User currentUser = userService.findById(user.getUserId());
    user.setUserPassword(currentUser.getUserPassword()); // <- ignore password changes
    return new ResponseEntity<>(userService.update(user), HttpStatus.CREATED);
  }

  @DeleteMapping("{userId}")
  public ResponseEntity<Object> delete(@PathVariable String userId)
    throws UserNotFoundException, NumberFormatException {
    Integer formattedUserId = Integer.parseInt(userId);
    String deleteInformation = userService.delete(formattedUserId);
    return new ResponseEntity<>(deleteInformation, HttpStatus.ACCEPTED);
  }

  @ExceptionHandler(UserNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> userNotFoundException(Throwable err) {
    return new ResponseEntity<>(
      new ErrorMessage(err.getMessage()),
      HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(UserRoleNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ResponseEntity<Object> userTypeNotFoundException(Throwable err) {
    return new ResponseEntity<>(
      new ErrorMessage(err.getMessage()),
      HttpStatus.NOT_FOUND
    );
  }

  @ExceptionHandler(ConnectException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ResponseEntity<Object> invalidConnection() {
    return new ResponseEntity<>(
      new ErrorMessage("Service temporarily unavailabe."),
      HttpStatus.SERVICE_UNAVAILABLE
    );
  }

  @ExceptionHandler(HttpMessageNotReadableException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ResponseEntity<Object> invalidMessage() {
    return new ResponseEntity<>(
      new ErrorMessage("Invalid HTTP message content."),
      HttpStatus.BAD_REQUEST
    );
  }

  @ExceptionHandler(SQLException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ResponseEntity<Object> invalidSQL() {
    return new ResponseEntity<>(
      new ErrorMessage("Service temporarily unavailabe."),
      HttpStatus.SERVICE_UNAVAILABLE
    );
  }
}
