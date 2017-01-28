package ua.rd.twitter.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class AbstractEntity {
    @Getter
    @Setter
    private Long id;
}
