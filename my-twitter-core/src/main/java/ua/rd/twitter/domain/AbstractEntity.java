package ua.rd.twitter.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AbstractEntity<Id> {
    private Id id;
}