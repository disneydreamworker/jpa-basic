package jpabasic.reserve.main;

import jakarta.persistence.EntityExistsException;
import java.lang.reflect.InvocationHandler;
import jpabasic.reserve.app.*;
import jpabasic.reserve.domain.User;
import jpabasic.reserve.jpa.EMF;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.time.LocalDateTime;

public class Main {
    
    public static void main(String[] args) {
        EMF.init();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                System.out.println("명령어를 입력하세요 : ");
                String line = br.readLine();
                //
                if (line == null) break;
                else if (line.startsWith("new ")) handleNew(line);

            }
        } catch (IOException e) {
            throw new RuntimeException(e);

        } finally {
            EMF.close();
        }


    }

    private static void handleNew(String line) {
        String[] v = line.substring(4).split(" ");
        User u = new User(v[0], v[1], LocalDateTime.now());
        try {
            newUserService.saveNewUser(u);
            logger.info("새 사용자 저장: {}", u);
        } catch (EntityExistsException e) {
            logger.info("사용자가 이미 존재함: {}", u.getEmail());
        }
    }

    private static void handleGet(String line) {
    }

    private static void handleChangeName(String line) {
    }

    private static void handleRemove(String line) {

    }

}
