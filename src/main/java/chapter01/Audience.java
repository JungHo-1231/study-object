package chapter01;

import lombok.Getter;

/**
 * 관람객
 */
public class Audience {
    @Getter
    private Bag bag;

    public Audience(Bag bag) {
        this.bag = bag;
    }

}
