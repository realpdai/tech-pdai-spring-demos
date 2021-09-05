package tech.pdai.springboot.lombok.demo;

import lombok.Cleanup;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author pdai
 */
@Slf4j
public class BasicExample {

    public void valExample() {
        val sets = new HashSet<String>();
        val lists = new ArrayList<String>();
        val maps = new HashMap<String, String>();

        log.info(sets.toString());
        log.info(lists.toString());
        log.info(maps.toString());
    }

    public void notNullExample(@NonNull String string) {
        string.length();
    }

    public void cleanupExample() {
        try {
            @Cleanup InputStream inputStream = new FileInputStream("/aaa.jb");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
