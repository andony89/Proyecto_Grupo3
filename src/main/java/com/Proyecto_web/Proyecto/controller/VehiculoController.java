package com.Proyecto_web.Proyecto.controller;


import com.Proyecto_web.Proyecto.domain.Vehiculo;
import com.Proyecto_web.Proyecto.service.VehiculoService;
import com.Proyecto_web.Proyecto.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @GetMapping("/listado")
    public String inicio(Model model) {
        var vehiculos = vehiculoService.getVehiculos(false);
        model.addAttribute("vehiculos", vehiculos);
        model.addAttribute("totalvehiculos", vehiculos.size());
        return "/vehiculo/listado";
    }

    @GetMapping("/nuevo")
    public String vehiculoNuevo(Vehiculo vehiculo) {
        return "/vehiculo/modifica";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @PostMapping("/guardar")
    public String prodcutoGuardar(Vehiculo vehiculo,
            @RequestParam("imagenFile") MultipartFile imagenFile) {
        if (!imagenFile.isEmpty()) {
            vehiculoService.save(vehiculo);
            vehiculo.setRutaImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "categoria",
                            vehiculo.getIdVehiculo()));
        }
        vehiculoService.save(vehiculo);
        return "redirect:/categoria/listado";
    }

    @GetMapping("/eliminar/{idVehiculo}")
    public String vehiculoEliminar(Vehiculo vehiculo) {
        vehiculoService.delete(vehiculo);
        return "redirect:/vehiculo/listado";
    }

    @GetMapping("/modificar/{idVehiculo}")
    public String vehiculoModifiar(Vehiculo vehiculo, Model model) {
        vehiculo = vehiculoService.getVehiculo(vehiculo);
        model.addAttribute("vehiculo", vehiculo);
        return "/vehiculo/modifica";
    }
}
