package com.gtwstg.gatewaystorage.controller;

import java.net.URI;
import java.util.Date;

import javax.validation.Valid;

import com.gtwstg.gatewaystorage.entities.TotemPacket;
import com.gtwstg.gatewaystorage.services.GatewayStorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


@RestController
@RequestMapping("/totem")
public class EndpointTotem {

    @Autowired
    private GatewayStorageService gatewayStorageService;

    @GetMapping
    public String getGatewayTotem() {
        Date date = new Date();
        SimpleDateFormat dateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.sss");       
        return "Return from Totem Endpoint at " + dateForm.format(date);
    }

    @PostMapping 
    public ResponseEntity<TotemPacket> toPacketStoragee(@Valid @RequestBody TotemPacket totemPacket)
    {   
        String response = gatewayStorageService.blobStorage(totemPacket.getFileName(), totemPacket.getData());
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{totem}").buildAndExpand(response).toUri();
        return ResponseEntity.created(uri).build();
    }
}

