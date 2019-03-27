package no.oslomet.assignmenttwo.service;

import no.oslomet.assignmenttwo.model.Shipping;

import java.util.List;

public interface ShippingService {
    List<Shipping> findAllShippings();

    Shipping saveShipping(Shipping shipping);
}
