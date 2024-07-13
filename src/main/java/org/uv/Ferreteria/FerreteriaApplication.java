package org.uv.Ferreteria;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.uv.Ferreteria.servicio.RolService;

@SpringBootApplication(scanBasePackages = {"org.uv.Ferreteria"})
public class FerreteriaApplication {

    @Autowired
    private RolService rolService;

    public static void main(String[] args) {
        SpringApplication.run(FerreteriaApplication.class, args);
    }

    //Metodo para crear el rol=Empleado por defecto
    @PostConstruct
    public void init() {
        rolService.init();
    }
}
