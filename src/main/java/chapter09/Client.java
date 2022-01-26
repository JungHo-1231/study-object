package chapter09;

import chapter02.Money;
import chapter02.Movie;

public class Client {
    private Factory factory;

    public Client(Factory factory) {
        this.factory = factory;
    }

    public Money getAvatarFee(){
        Movie avatar = factory.createAvatarMovie();
        return avatar.getFee();
    }

}
