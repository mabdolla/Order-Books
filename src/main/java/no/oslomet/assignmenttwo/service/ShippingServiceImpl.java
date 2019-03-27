package no.oslomet.assignmenttwo.service;

import no.oslomet.assignmenttwo.model.Shipping;
import no.oslomet.assignmenttwo.repository.ShippingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShippingServiceImpl implements ShippingService{

    @Autowired
    ShippingRepository shippingRepository;

    @Override
    public List<Shipping> findAllShippings() {
        return shippingRepository.findAll();
    }

    @Override
    public  Shipping saveShipping(Shipping shipping){
        return shippingRepository.save(shipping);
    }
}
