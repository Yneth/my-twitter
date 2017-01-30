package ua.rd.twitter.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false, exclude = {"authorities"})
public class User extends AbstractEntity<Long> {
    private String username;

    private String password;

    private List<Authority> authorities = new ArrayList<>();
}
