package random.learning.springbootangular;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import random.learning.springbootangular.entity.RoomEntity;
import random.learning.springbootangular.repository.RoomRepository;

@Component
public class H2Bootstrap implements CommandLineRunner {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bootstrapping data: ");

        roomRepository.save(new RoomEntity(300, "202"));
        roomRepository.save(new RoomEntity(301, "203"));
        roomRepository.save(new RoomEntity(302, "230"));

        Iterable<RoomEntity> all = roomRepository.findAll();
        System.out.println("Printing out data: ");
        for (RoomEntity room : all) {
            System.out.println(room.getRoomNumber());
        }
    }
}
