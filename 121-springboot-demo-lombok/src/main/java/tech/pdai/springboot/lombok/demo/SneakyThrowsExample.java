package tech.pdai.springboot.lombok.demo;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

/**
 * @author pdai
 */
public class SneakyThrowsExample {

    @SneakyThrows()
    public void read() {
        InputStream inputStream = new FileInputStream("");
    }

    @SneakyThrows
    public void write() {
        throw new UnsupportedEncodingException();
    }

}
