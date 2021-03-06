package com.AutoShop.preLoadData;



import com.AutoShop.model.*;
import com.AutoShop.repository.ClientRepository;
import com.AutoShop.repository.OrderRepository;
import com.AutoShop.repository.VehicleRepository;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private VehicleRepository vehicleRepository;

    private OrderRepository orderRepository;

    private ClientRepository clientRepository;

    @Autowired
    public DataLoader(VehicleRepository vehicleRepository, OrderRepository orderRepository, ClientRepository clientRepository){
        this.vehicleRepository =vehicleRepository;
        this.orderRepository = orderRepository;
        this.clientRepository= clientRepository;
    }

    public void run(ApplicationArguments args){

        Client client1 = new Client("Marian", "Grubinski","Poznan");
        Client client2 =  new Client("Stefan", "Stefanczyk","Warszawa");
        Client client3 = new Client("Marianna", "Sadurczyk","Gdynia");
        Client client4 = new Client("Marcin", "Kokolewski","Szczecin");


        Car car1 = new Car ("Ford Fiesta", 25000, 150, 5);
        Car car2 = new Car("Mercedes C63", 150000, 160, 4);
        Bike bike1 = new Bike("Romet Classic", 1350, 15, "pink" );
        Bike bike2 = new Bike("Gazele UltraSpeed", 2500, 12, "colourfull");
        Motorcycle motorcycle1 = new Motorcycle("Ducati Panigale V4", 55000, 210, 1000);

        DateTimeFormatter dateTimeFormatter= DateTimeFormat.forPattern("dd/MM/yyyy");
        DateTime dateOrder1= DateTime.parse("05/05/2018", dateTimeFormatter);
        DateTime dateOrder2= DateTime.parse("15/11/2019", dateTimeFormatter);

        Order order1 = new Order(dateOrder1, bike2, client1);
        Order order2 = new Order(dateOrder2, motorcycle1, client3);

        clientRepository.save(client1);
        clientRepository.save(client2);
        clientRepository.save(client3);
        clientRepository.save(client4);

        orderRepository.save(order1);
        orderRepository.save(order2);

        vehicleRepository.save(car1);
        vehicleRepository.save(car2);
        vehicleRepository.save(bike1);
        vehicleRepository.save(bike2);
        vehicleRepository.save(motorcycle1);

       }
}
