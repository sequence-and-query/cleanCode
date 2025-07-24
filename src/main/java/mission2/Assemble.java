package mission2;

import lombok.Data;

import java.util.Scanner;

public class Assemble {
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder();
        carBuilder.start();
    }
}
