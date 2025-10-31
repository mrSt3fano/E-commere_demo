package com.sistema.regisstro.Sistemademo.Controller.Shop;

import com.sistema.regisstro.Sistemademo.DTO.WebCategory;
import com.sistema.regisstro.Sistemademo.DTO.WebSupplier;
import com.sistema.regisstro.Sistemademo.DTO.WebUser;
import com.sistema.regisstro.Sistemademo.Entity.Productos;
import com.sistema.regisstro.Sistemademo.Entity.Proveedores;
import com.sistema.regisstro.Sistemademo.Entity.Usuario;
import com.sistema.regisstro.Sistemademo.Service.Ecommerce.Product.ServicioProductos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;

@Controller
@RequestMapping("/compras")
public class CCompra {

    private ServicioProductos pp;

    @Autowired
    public CCompra(ServicioProductos pp) {
        this.pp = pp;
    }

    @PostMapping("/seleccionar/{id}")
    public String fomrs(@PathVariable int id, Model mo){
        Productos productoscomprados=pp.consultaProductoID(id);
        List<Proveedores> prov=pp.consultarProveedores(id);
        mo.addAttribute("productocomprado",productoscomprados);
        mo.addAttribute("proveedores",prov);
        mo.addAttribute("novo", new WebSupplier());
        return "/Shopping/ConfirmarCompras";
    }

}
