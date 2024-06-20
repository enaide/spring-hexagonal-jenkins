package com.ecfcode.hexagonal.infrastructure.demo.concretes;

import com.ecfcode.hexagonal.infrastructure.demo.entities.CustomerDemo;
import com.ecfcode.hexagonal.infrastructure.demo.entities.Sale;
import com.ecfcode.hexagonal.infrastructure.demo.entities.Vehicle;
import com.ecfcode.hexagonal.infrastructure.demo.repository.CustomerDemoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

@Service
public class CustomerService {

    private final CustomerDemoRepository customerRepository;
    private final VehicleService vehicleService;

    public CustomerService(CustomerDemoRepository customerRepository, VehicleService vehicleService) {
        this.customerRepository = customerRepository;
        this.vehicleService = vehicleService;
    }

    public CustomerDemo saveCustomer(CustomerDemo customer) {
        CustomerDemo newCustomer = new CustomerDemo();
        newCustomer.setCustomerName(customer.getCustomerName());

        List<Long> ids = vehicleIds(customer);
        List<Vehicle> vehicles = vehicleList(ids);

        List<Sale> saleDetails = customer.getSales().stream().map(getSaleFunction(vehicles)).toList();
        saleDetails.forEach(sale -> newCustomer.addSale(sale));

        return customerRepository.save(newCustomer);
    }

    private static Function<Sale, Sale> getSaleFunction(List<Vehicle> vehicles) {
        return sale -> {
            Sale newSale = new Sale();
            Vehicle vehicle = vehicles.stream().filter(getVehiclePredicate(sale)).findFirst().orElse(null);
            newSale.setVehicle(vehicle);
            newSale.setDiscount(sale.getDiscount());

            return newSale;
        };
    }

    private List<Long> vehicleIds(CustomerDemo customer) {
        return customer.getSales().stream().map(sale -> sale.getVehicle().getVehicleId()).toList();
    }

    private List<Vehicle> vehicleList(List<Long> saleIds) {
        return vehicleService.findAllVehicleById(saleIds);
    }

    private static Predicate<Vehicle> getVehiclePredicate(Sale sale) {
        return v -> v.getVehicleId().equals(sale.getVehicle().getVehicleId());
    }
}
